package pro.sky.java.course2.course_2_work.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.course_2_work.data.Question;
import pro.sky.java.course2.course_2_work.exceptions.IllegalCountOfQuestionException;
import pro.sky.java.course2.course_2_work.service.ExaminerService;
import pro.sky.java.course2.course_2_work.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }


    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount > (javaQuestionService.getAll().size() + mathQuestionService.getAll().size())) {
            System.out.println(javaQuestionService.getAll().size());
            System.out.println(mathQuestionService.getAll().size());
            throw new IllegalCountOfQuestionException("Вопросов в запросе больше чем в списках вопросов");
        }
        if (amount <= 0) {
            throw new IllegalCountOfQuestionException("Некорректное количество вопросов");
        }
        Set<Question> questionForExam = new HashSet<>();

        int amountJavaQuestion = findAmountJavaQuestion(amount);

        while (amountJavaQuestion + mathQuestionService.getAll().size() < amount) {
            amountJavaQuestion++;
        }

        while (questionForExam.size() < amountJavaQuestion) {
            questionForExam.add(javaQuestionService.getRandomQuestion());
        }
        while (questionForExam.size() < amount) {
            questionForExam.add(mathQuestionService.getRandomQuestion());
        }



        return questionForExam;
    }

    private int findAmountJavaQuestion(int amount) {
        int amountJavaQuestion = 0;
        Random ran = new Random();

        if (javaQuestionService.getAll().isEmpty()) {
            return 0;
        }

        if (mathQuestionService.getAll().isEmpty()) {
            return amount;
        }
        if (mathQuestionService.getAll().size() == javaQuestionService.getAll().size()) {
            return (int) amount/2;
        }

        if (javaQuestionService.getAll().size() > amount) {
            amountJavaQuestion = ran.nextInt(amount);
        }
        if (javaQuestionService.getAll().size() < amount) {
            amountJavaQuestion = ran.nextInt(javaQuestionService.getAll().size());
        }

        return amountJavaQuestion;
    }

}
