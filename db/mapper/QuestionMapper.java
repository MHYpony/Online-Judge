package db.mapper;

import java.util.List;

import db.model.Question;

public interface QuestionMapper {
	
	int insertQuestion(Question question);
	int updateQuestion(Question question);
	int deleteQuestion(Question question);
	List<Question> selectQuestion (Question question);

}
