package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import po.Book;

public class FirstTest {

	private SqlSessionFactory sqlSessionFactory = null;
	//前提准备
	@Before
	public void init() throws IOException{
		//配置文件
		String resource = "SqlMapConfig.xml";
		//加载配置文件到输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testSelectById(){
		//获取session
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
		//通过session操作数据库
		Book book = sqlsession.selectOne("test.findBookById", 1000L);
		System.out.println(book);
		}catch(Exception e){
			throw e;
		}finally{
			//关闭session
			sqlsession.close();
		}
	}
	
	@Test
	public void testSelectByName(){
		//获取session
		SqlSession sqlsession = sqlSessionFactory.openSession();
		//通过session操作数据库
		try {
			List<Book> booklist = sqlsession.selectList("test.findBookByName", "数据");
			System.out.println(booklist);
		} catch (Exception e) {
			throw e;
		}finally{
			//关闭session
			sqlsession.close();
		}
	}
	@Test
	public void testInsertBook(){
		//获取session
		SqlSession sqlsession = sqlSessionFactory.openSession();
		//通过session操作数据库
		try {
			Book book = new Book();
			book.setBook_id(123L);
			book.setName("pwang6book");
			book.setNumber(4);
			int bookid = sqlsession.insert("test.insertBook", book);
			sqlsession.commit();
			System.out.println(bookid);
		} catch (Exception e) {
			throw e;
		}finally{
			//关闭session
			sqlsession.close();
		}
	}
	
	@Test
	public void testDeleteBook(){
		//获取session
		SqlSession sqlsession = sqlSessionFactory.openSession();
		//通过session操作数据库
		try {
			int bookid = sqlsession.insert("test.deleteBook", 123L);
			sqlsession.commit();
			System.out.println(bookid);
		} catch (Exception e) {
			throw e;
		}finally{
			//关闭session
			sqlsession.close();
		}
	}
	
	@Test
	public void testupdateBook(){
		//获取session
		SqlSession sqlsession = sqlSessionFactory.openSession();
		//通过session操作数据库
		try {
			Book book = new Book();
			book.setBook_id(123L);
			book.setName("pwangbook");
			book.setNumber(9);
			int bookid = sqlsession.insert("test.updateBook", book);
			sqlsession.commit();
			System.out.println(bookid);
		} catch (Exception e) {
			throw e;
		}finally{
			//关闭session
			sqlsession.close();
		}
	}
}
