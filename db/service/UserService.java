package db.service;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import db.access.Dbaccess;
import db.mapper.UserMapper;
import db.model.User;
@Service
public class UserService {

	public UserService() {
		// TODO Auto-generated constructor stub
	}
	//
	//
	//
	public Boolean insertUser(String name, String password){
		Dbaccess dbaccess=new Dbaccess();
		SqlSession sqlSession=null;
		User user=new User(name,password,false);
		
		try {
			sqlSession=dbaccess.getSqlSession();
			UserMapper um =sqlSession.getMapper(UserMapper.class);
			User user1=um.selectUser(user);
			if (user1 !=null){
				return false;
			}else{
			um.insertUser(user);
			}
			sqlSession.commit();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			sqlSession.close();
		}
		return  true;
		
	}
	//
	//
	//
	public  Boolean checkUser(String name, String password){
		Dbaccess dbaccess=new Dbaccess();
		SqlSession sqlSession=null;
		User user=new User(name,password,false);
		try {
			sqlSession=dbaccess.getSqlSession();
			UserMapper um =sqlSession.getMapper(UserMapper.class);
			User user1=um.selectUser(user);
			sqlSession.commit();
			if (user1 !=null && user1.getPassword().equals(password)){
				return true;
			}else{
			    return false;
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			sqlSession.close();
		}
		return false;
		
	}
}
