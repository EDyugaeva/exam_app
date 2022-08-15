package pro.sky.java.course2.course_2_work.data;

import pro.sky.java.course2.course_2_work.data.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();

}
