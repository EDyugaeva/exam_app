package pro.sky.java.course2.course_2_work.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.course_2_work.data.MathQuestionRepository;
import pro.sky.java.course2.course_2_work.data.Question;
import pro.sky.java.course2.course_2_work.exceptions.EmptyParameterException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements pro.sky.java.course2.course_2_work.service.QuestionService {
    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }


    @Override
    public Question add(String question, String answer) {
        if (question.isEmpty() || answer.isEmpty()) {
            throw new EmptyParameterException("Вопрос и/или ответ не задан(ы)");
        }
        Question addedQuestion = new Question(question, answer);
        mathQuestionRepository.add(addedQuestion);
        return addedQuestion;
    }

    @Override
    public Question add(Question question) {
        mathQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        mathQuestionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        if (mathQuestionRepository.getAll().isEmpty()) {
            throw new EmptyParameterException("Лист с вопросами пустой");
        }
        ArrayList<Question> listQuestion = new ArrayList<>(mathQuestionRepository.getAll());
        Random ran = new Random();
        int randomNumber = ran.nextInt(mathQuestionRepository.getAll().size());
        return listQuestion.get(randomNumber);
    }

}
