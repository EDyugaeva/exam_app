package pro.sky.java.course2.course_2_work;

import pro.sky.java.course2.course_2_work.data.Question;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class JavaQuestionServiceConstants {
    public static final String QUESTIONTEXTONE = "Question text 1";
    public static final String QUESTIONTEXTTWO = "Question text 2";

    public static final String ANSWERTEXTONE = "Answer text 1";
    public static final String ANSWERTEXTTWO = "Answer text 2";

    public static final Question QUESTIONTHREE = new Question("Question text 3", "Answer text 3");
    public static final Question QUESTIONFOUR = new Question("Question text 4", "Answer text 4");

    public static final Set<Question> QUESTIONS = Set.of(new Question("Question 1", "Answer 1"),
            new Question("Question 2", "Answer 2"),
            new Question("Question 3", "Answer 3"),
            new Question("Question 4", "Answer 4"),
            new Question("Question 5", "Answer 5"),
            QUESTIONFOUR);



}
