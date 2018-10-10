package db.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import db.service.*;
import db.model.*;

import db.model.Question;
import db.model.Run_status;

@Controller
public class searchController {
	QuestionService questionService = new QuestionService();
	@RequestMapping(path = {"/search/tables"}, method = RequestMethod.POST)
	@ResponseBody
	public List<Question> searchQuestion(@RequestBody Question question) {
		List<Question> list = questionService.selectQuestion(question);
		return list;
	}
	Run_statusService run_statusService = new Run_statusService();
	@RequestMapping(path = {"/search/test"}, method = RequestMethod.POST)
	@ResponseBody
	public Run_status judgement(@RequestBody Judge ju) {
		return run_statusService.judge(ju.getuid().toString(), ju.getqid().toString(), ju.getcode());
		
	}
}
