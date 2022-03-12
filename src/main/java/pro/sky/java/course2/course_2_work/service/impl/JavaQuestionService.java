package pro.sky.java.course2.course_2_work.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.course_2_work.data.Question;
import pro.sky.java.course2.course_2_work.exceptions.AbsentQuestionException;
import pro.sky.java.course2.course_2_work.exceptions.EmptyParameterException;
import pro.sky.java.course2.course_2_work.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        if (question.isEmpty() || answer.isEmpty()) {
            throw new EmptyParameterException("Вопрос и/или ответ не задан(ы)");
        }
        Question addedQuestion = new Question(question, answer);
        questions.add(addedQuestion);
        return addedQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new AbsentQuestionException("Такой вопрос в списке отсутствует");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new EmptyParameterException("Лист с вопросами пустой");
        }
        ArrayList<Question> listQuestion = new ArrayList<>(questions);
        Random ran = new Random();
        int randomNumber = ran.nextInt(questions.size());
        return listQuestion.get(randomNumber);

    }
}
