package db.service;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import db.access.Dbaccess;
import db.model.TestData;
import db.mapper.TestDataMapper;

public class TestDataService {

	public TestDataService() {
		// TODO Auto-generated constructor stub
	}
	public int insertTestData(Integer qid,String input,String output) {
		Dbaccess dbaccess = new Dbaccess();
		SqlSession sqlSession = null;
		int line = 0;
		TestData testData= new TestData();
		testData.setQid(qid);
		testData.setInput(input);
		testData.setOutput(output);
		try {
			sqlSession=dbaccess.getSqlSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestDataMapper tdm=sqlSession.getMapper(TestDataMapper.class);
		line=tdm.insertTestData(testData);
		sqlSession.commit();
		return line;
	}
	
	public int deleteTestData(Integer qid) {
		Dbaccess dbaccess = new Dbaccess();
		SqlSession sqlSession = null;
		int line = 0;
		TestData testData= new TestData();
		testData.setQid(qid);
		
		try {
			sqlSession=dbaccess.getSqlSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestDataMapper tdm=sqlSession.getMapper(TestDataMapper.class);
		line=tdm.deleteTestData(testData);
		sqlSession.commit();
		return line;
	}
	
	public TestData selectTestData(Integer qid) {
		Dbaccess dbaccess = new Dbaccess();
		SqlSession sqlSession = null;
	
		TestData testData= new TestData();
		testData.setQid(qid);
		
		try {
			sqlSession=dbaccess.getSqlSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestDataMapper tdm=sqlSession.getMapper(TestDataMapper.class);
		TestData testData1=tdm.selectTestData(testData);
		sqlSession.commit();
		return testData1;
	}
	
	

}
