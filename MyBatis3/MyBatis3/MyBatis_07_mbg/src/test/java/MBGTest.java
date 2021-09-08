import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.bean.EmployeeExample;
import com.atguigu.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/*
	此启动置文件是基于父子工程环境下的mbg
    正常是去掉[../MyBatis3/MyBatis_07_mbg/]
*/
public class MBGTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}


	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("../MyBatis3/MyBatis_07_mbg/mbg.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
	}

	@Test
	public void testMyBatis3() throws IOException {
		SqlSessionFactory sqlSession = getSqlSessionFactory();
		SqlSession openSession = sqlSession.openSession();
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

		//1.查询所有
//		List<Employee> employeeList = mapper.selectByExample(null);

		//2.查询员工名字带m和员工性别是1的
		EmployeeExample employeeExample = new EmployeeExample();
		//创建一个Criteria，这个Criteria就是拼装查询条件
		/*select id, last_name, gender, email, d_id from tbl_employee WHERE ( last_name like ? and gender = ? )*/
		EmployeeExample.Criteria criteria = employeeExample.createCriteria();
		criteria.andLastNameLike("%m%");
		criteria.andGenderEqualTo("1");
		//or:此时SQL:select id, last_name, gender, email, d_id from tbl_employee WHERE ( last_name like ? and gender = ? ) or( email like ? )
		EmployeeExample.Criteria criteria2=employeeExample.createCriteria();
		criteria2.andEmailLike("%e%");
		employeeExample.or(criteria2);

		List<Employee> employeeList = mapper.selectByExample(employeeExample);

		for (Employee employee : employeeList)
			System.out.println(employee);

		openSession.commit();
		openSession.close();
	}




}