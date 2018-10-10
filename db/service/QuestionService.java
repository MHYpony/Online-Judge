package db.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import db.access.Dbaccess;

import db.mapper.CategoryMapper;
import db.mapper.QuestionMapper;
import db.model.Category;
import db.model.Question;
@Service
public class QuestionService {

	public QuestionService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Question> selectQuestion(Question question) {
		Dbaccess dbAccess = new Dbaccess();
		SqlSession sqlSession = null;
		List<Question> questionList = new ArrayList<Question>();
		try {
			sqlSession = dbAccess.getSqlSession();
			QuestionMapper qm=sqlSession.getMapper(QuestionMapper.class);
			questionList = qm.selectQuestion(question);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return questionList;
	}
	//
	//
	//
	public List<Question> selectQuestionByCategory(String categoryName) {
		Dbaccess dbaccess=new Dbaccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbaccess.getSqlSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Question> questionList = new ArrayList<Question>();
		Question question=new Question();
		Category category=new Category();
		category.setName(categoryName);
		Category category1=new Category();
		CategoryMapper cm=sqlSession.getMapper(CategoryMapper.class);
		QuestionMapper qm=sqlSession.getMapper(QuestionMapper.class);
		category1=cm.selectCategory(category);
		question.setCid(category1.getId());
		questionList=qm.selectQuestion(question);
		return questionList;
	}
	//
	//
	//
    public Question selectQuestionByID(String ID) {
		
    	Dbaccess dbaccess=new Dbaccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbaccess.getSqlSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		QuestionMapper qm=sqlSession.getMapper(QuestionMapper.class);
		List<Question> questionList = new ArrayList<Question>();
		Question question=new Question();
		Question question1=new Question();
		if(ID !=null){
		question.setQid(Integer.valueOf(ID));
		}
		questionList=qm.selectQuestion(question);
		if(!questionList.isEmpty()){
		question1=questionList.get(0);
		}
		return question1;
	}
    //
    //
    //
    public Boolean insertQuestion(String name,String categoryName,String content){
    	Dbaccess dbaccess=new Dbaccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbaccess.getSqlSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		QuestionMapper qm=sqlSession.getMapper(QuestionMapper.class);
		CategoryMapper cm=sqlSession.getMapper(CategoryMapper.class);
		Category category=new Category();
		category.setName(categoryName);
    	Category test=new Category();
		test = cm.selectCategory(category);
		Question question=new Question();
		question.setDescription(content);
		question.setName(name);
    	if(test !=null){
    		question.setCid(test.getId());
    	}
    	else{
    		cm.insertCategory(category);
    		test = cm.selectCategory(category);
    		question.setCid(test.getId());
    	}
    	
    	qm.insertQuestion(question);
    	sqlSession.commit();
    	return true;
    }

}
