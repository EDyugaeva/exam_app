package pro.sky.java.course2.course_2_work.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.course_2_work.data.Question;
import pro.sky.java.course2.course_2_work.exceptions.IllegalCountOfQuestionException;
import pro.sky.java.course2.course_2_work.service.ExaminerService;
import pro.sky.java.course2.course_2_work.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new IllegalCountOfQuestionException("Вопросов в запросе больше чем в списке вопросов");
        }
        if (amount <= 0) {
            throw new IllegalCountOfQuestionException("Некорректное количество вопросов");
        }
        HashSet<Question> questionForExam = new HashSet<>();
        while (questionForExam.size() < amount) {
            questionForExam.add(questionService.getRandomQuestion());
        }
        return questionForExam;
    }
}
