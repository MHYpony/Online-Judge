package db.service;

import java.io.IOException;
import org.apache.ibatis.session.SqlSession;
import db.access.Dbaccess;
import db.model.Category;
import db.mapper.CategoryMapper;


public class CategoryService {

	public CategoryService() {
		// TODO Auto-generated constructor stub
	}
	public Category selectCategory(String name){
		Dbaccess dbaccess=new Dbaccess();
		SqlSession sqlSession=null;
		Category category = new Category();
		category.setName(name);
		try {
			sqlSession=dbaccess.getSqlSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CategoryMapper cm =sqlSession.getMapper(CategoryMapper.class);
		Category category1=cm.selectCategory(category);
		return category1;
		
	}
	public int insertCategory(String name){
		Dbaccess dbaccess=new Dbaccess();
		SqlSession sqlSession=null;
		Category category = new Category();
		category.setName(name);
		try {
			sqlSession=dbaccess.getSqlSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CategoryMapper cm =sqlSession.getMapper(CategoryMapper.class);
		int result=cm.insertCategory(category);
		sqlSession.commit();
		return result;
		
	}
	public int deleteCategory(String name){
		Dbaccess dbaccess=new Dbaccess();
		SqlSession sqlSession=null;
		Category category = new Category();
		category.setName(name);
		try {
			sqlSession=dbaccess.getSqlSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CategoryMapper cm =sqlSession.getMapper(CategoryMapper.class);
		int result=cm.deleteCategory(category);
		sqlSession.commit();
		return result;
		
	}

}
