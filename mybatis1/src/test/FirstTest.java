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
	//ǰ��׼��
	@Before
	public void init() throws IOException{
		//�����ļ�
		String resource = "SqlMapConfig.xml";
		//���������ļ���������
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//�����Ự����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testSelectById(){
		//��ȡsession
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
		//ͨ��session�������ݿ�
		Book book = sqlsession.selectOne("test.findBookById", 1000L);
		System.out.println(book);
		}catch(Exception e){
			throw e;
		}finally{
			//�ر�session
			sqlsession.close();
		}
	}
	
	@Test
	public void testSelectByName(){
		//��ȡsession
		SqlSession sqlsession = sqlSessionFactory.openSession();
		//ͨ��session�������ݿ�
		try {
			List<Book> booklist = sqlsession.selectList("test.findBookByName", "����");
			System.out.println(booklist);
		} catch (Exception e) {
			throw e;
		}finally{
			//�ر�session
			sqlsession.close();
		}
	}
	@Test
	public void testInsertBook(){
		//��ȡsession
		SqlSession sqlsession = sqlSessionFactory.openSession();
		//ͨ��session�������ݿ�
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
			//�ر�session
			sqlsession.close();
		}
	}
	
	@Test
	public void testDeleteBook(){
		//��ȡsession
		SqlSession sqlsession = sqlSessionFactory.openSession();
		//ͨ��session�������ݿ�
		try {
			int bookid = sqlsession.insert("test.deleteBook", 123L);
			sqlsession.commit();
			System.out.println(bookid);
		} catch (Exception e) {
			throw e;
		}finally{
			//�ر�session
			sqlsession.close();
		}
	}
	
	@Test
	public void testupdateBook(){
		//��ȡsession
		SqlSession sqlsession = sqlSessionFactory.openSession();
		//ͨ��session�������ݿ�
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
			//�ر�session
			sqlsession.close();
		}
	}
}
