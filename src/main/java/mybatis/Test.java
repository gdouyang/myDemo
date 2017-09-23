package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test
{
	public static void main(String[] args) throws IOException
	{
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
		  BlogMapper mapper = session.getMapper(BlogMapper.class);
		  Blog blog = mapper.selectBlog(101);
		  System.out.println(blog);
		} finally {
		  session.close();
		}
	}
}
