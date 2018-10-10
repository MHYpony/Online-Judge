package db.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.sql.Timestamp;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;

import db.access.Dbaccess;
import db.mapper.Run_statusMapper;
import db.model.Question;
import db.model.Run_status;
import db.model.TestData;

public class Run_statusService {

	public Run_statusService() {
		// TODO Auto-generated constructor stub
	}
	public void insertRun_status(Run_status run_status){
		Dbaccess dbaccess=new Dbaccess();
		
		try {
			SqlSession	sqlSession=dbaccess.getSqlSession();
			Run_statusMapper run_statusMapper=sqlSession.getMapper(Run_statusMapper.class);
			run_statusMapper.insertRun_status(run_status);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Run_statusMapper Run_statusMapper=sqlSession.getMapper(Run_statusMapper.class);
	}
	public List<Run_status> selectRun_status(Run_status run_status){
		Dbaccess dbaccess=new Dbaccess();
		SqlSession	sqlSession=null;
		try {
		sqlSession=dbaccess.getSqlSession();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Run_statusMapper run_statusMapper=sqlSession.getMapper(Run_statusMapper.class);
		return run_statusMapper.selectRun_status(run_status);
		
	}
	
	
	public Run_status judge(String uid,String qid,String code){
		Run_status run_status= new Run_status();
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间*/
		Timestamp  sub_time= new Timestamp(System.currentTimeMillis()); 
		run_status.setSub_time(sub_time);
		run_status.setCode(code);
		run_status.setQid(Integer.valueOf(qid));
		run_status.setUid(Integer.valueOf(uid));
		run_status.setLanguage("c++");
		System.out.println(run_status);//...................
		TestDataService testDataService=new TestDataService();
		TestData testData=new TestData();
		testData=testDataService.selectTestData(Integer.valueOf(qid));
		try {
			outFile2("C:\\onlinejudge\\a.cpp",code);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(testData.getInput());//.....
			outFile("C:\\onlinejudge\\in.txt",testData.getInput());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			outFile("C:\\onlinejudge\\answer.txt",testData.getOutput());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			run_cmd("cmd /c start  C:\\onlinejudge\\command.bat");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String run_time=inFile("C:\\onlinejudge\\time.txt");
			//System.out.println(run_time);
			run_status.setRun_time(Integer.valueOf(replaceBlank(run_time)));
			String judge_status=inFile("C:\\onlinejudge\\result.txt");
			run_status.setJudge_status(judge_status);
			String run_memory=inFile("C:\\onlinejudge\\memory.txt");
			run_status.setRun_memory(Integer.valueOf(replaceBlank(run_memory)));	
			String result = run_status.getJudge_status();
			result = replaceBlank(result);
			System.out.println("result = " + result);//........
			if(result.equals("0")) result = "Accepted";
			else if(result.equals("1")) result = "Wrong Answer";
			else if(result.equals("2")) result = "Time Limit Exceed";
			else if(result.equals("3")) result = "Runtime Error";
			else result = "Compile Error";
			run_status.setJudge_status(result);
			insertRun_status( run_status);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return run_status;
		
	}
	 private String replaceBlank(String s) {
	    	String result= null; 
	    	if (s == null) { 
	    		return result; } 
	    	else {
	    		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	    		Matcher m = p.matcher(s); 
	    		result= m.replaceAll(""); 
	    		return result;
	    		} 
	    	}
	public void outFile(String fileName, String content) throws IOException{
		File fout = new File(fileName);	
 		FileOutputStream fos = new FileOutputStream(fout); 	
 		@SuppressWarnings("resource")
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos)); 	
 		int len = content.length(), last = 0;
 		for (int i = 0; i < len; i++) {
 			
 			if(content.charAt(i) == '\\') {
 				System.out.println(content.substring(last, i));
 				bw.write(content.substring(last, i));
 				bw.newLine();
 				last = i + 2;
 				i = i + 1;
 			}
 			
 		}
 		bw.close();
	}
	 public void run_cmd(String strcmd) {
		 //
		         Runtime rt = Runtime.getRuntime(); //Runtime.getRuntime()返回当前应用程序的Runtime对象
		         Process ps = null;  //Process可以控制该子进程的执行或获取该子进程的信息。
		         try {
		             ps = rt.exec(strcmd);   //该对象的exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
		             ps.waitFor();  //等待子进程完成再往下执行。
		         } catch (IOException e1) {
		             e1.printStackTrace();
		         } catch (InterruptedException e) {
		             // TODO Auto-generated catch block
		             e.printStackTrace();
		         }

		         int i = ps.exitValue();  //接收执行完毕的返回值
		         if (i == 0) {
		             System.out.println("执行完成.");
		         } else {
		             System.out.println("执行失败.");
		         }

		         ps.destroy();  //销毁子进程
		         ps = null;   
		     }
	 	public void outFile2(String fileName, String content) throws IOException {
			OutputStream out = null;
			try {
				
				out = new FileOutputStream(fileName, false);
				out.write(content.getBytes());
				out.flush();
			} finally {
				out.close();
			}

		}
	    public String inFile(String fsrc) throws IOException{
			String result="";
			File filename=new File(fsrc);
			Reader reader=null;
			BufferedReader bReader= null;
			try{
				reader=new FileReader(filename);
				bReader= new BufferedReader(reader);
				
				String line = bReader.readLine();
				while(line!=null){
		             result+=line;
					line=bReader.readLine();				
				}
			
			}finally {
				bReader.close();
				reader.close();
			}
			return result;
		}
//	    public static void outFile2(String fileName, String content) throws IOException {
//			OutputStream out = null;
//			try {
//				
//				out = new FileOutputStream(fileName, false);
//				out.write(content.getBytes());
//				out.flush();
//			} finally {
//				out.close();
//			}
//
//		}
//	    public static String inFile2(String fsrc) throws IOException{
//			String result="";
//			File filename=new File(fsrc);
//			Reader reader=null;
//			BufferedReader bReader= null;
//			try{
//				reader=new FileReader(filename);
//				bReader= new BufferedReader(reader);
//				
//				String line = bReader.readLine();
//				while(line!=null){
//		             result+=line+'\n';
//					line=bReader.readLine();				
//				}
//			
//			}finally {
////				bReader.close();
////				reader.close();
//			}
//			return result;
//		}
//	   public static void main(String[] args) throws IOException{
//		  Run_statusService jjw = new Run_statusService();
//		  String code = inFile2("C:\\Users\\马昊阳\\Desktop\\jjw.cpp");
//		  //outFile2("C:\\\\Users\\\\马昊阳\\\\Desktop\\\\jjww.cpp", code);
//		  Run_status jjww = jjw.judge("18", "15", code);
//		 // System.out.println(jjww.toString());
//		   
//		}


}
