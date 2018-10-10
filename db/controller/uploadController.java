package db.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import db.model.Question;
import db.service.*;

@Controller
public class uploadController {
	
	QuestionService qs = new QuestionService();
	TestDataService tds=new TestDataService();
	public int getj(int i, String info) {
		int j, len = info.length();
		for(j = i + 1; j < len; j++) {
			if(info.charAt(j) == '\"') {
				break;
			}
		}
		return j;
	}
	@RequestMapping(path = {"/share"}, method = RequestMethod.POST)
	@ResponseBody
	public Boolean loadInfo(@RequestBody String info) {
		//System.out.println(info);
		String content = "", category = "", name = "", input = "", output = "";
		int len = info.length(), cnt = 0;
		for(int i = 0; i < len; i++) {
			if(info.charAt(i) == '\"') {
				cnt++;
			}
			if(cnt == 3) {
				int j = getj(i, info);
				cnt++;
				content = info.substring(i+1, j);
				i = j;
			}
			else if(cnt == 7) {
				int j = getj(i, info);
				cnt++;
				category = info.substring(i+1, j);
				i = j;
			}
			else if(cnt == 11) {
				int j = getj(i, info);
				cnt++;
				name = info.substring(i+1, j);
				i = j;
			}
			else if(cnt == 15) {
				int j = getj(i, info);
				cnt++;
				input = info.substring(i+1, j);
				i = j;
			}
			else if(cnt == 19) {
				int j = getj(i, info);
				cnt++;
				output = info.substring(i+1, j);
				i = j;
			}
		}
		System.out.println(name + " " + content + " " + category + " " + input + " " + output);
		Question question = new Question(null, null, name, content);
		List<Question> list = qs.selectQuestion(question);
		if(list.size() == 0) {
			qs.insertQuestion(name, category, content);
			List<Question> list2 = qs.selectQuestion(question);
			int qid = list2.get(0).getQid();
			System.out.println("qid = " + qid);
			tds.insertTestData(qid, input, output);
			return true;
		}
		return false;
	}
}
