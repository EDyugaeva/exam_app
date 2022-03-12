package pro.sky.java.course2.course_2_work.service;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.course_2_work.data.Question;
import pro.sky.java.course2.course_2_work.exceptions.AbsentQuestionException;
import pro.sky.java.course2.course_2_work.exceptions.EmptyParameterException;
import pro.sky.java.course2.course_2_work.service.impl.JavaQuestionService;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.course_2_work.JavaQuestionServiceConstants.*;

public class JavaQuestionServiceTest {
    private QuestionService out = new JavaQuestionService();

    @Test
    public void testAddWithText() {
        assertEquals(out.getAll().size(), 0);
        HashSet<Question> actual = new HashSet<>();

        assertEquals(out.add(QUESTIONTEXTONE, ANSWERTEXTONE), new Question(QUESTIONTEXTONE, ANSWERTEXTONE));
        assertEquals(out.getAll().size(), 1);
        actual.add(new Question(QUESTIONTEXTONE, ANSWERTEXTONE));
        assertEquals(out.getAll(), actual);

        assertEquals(out.add(QUESTIONTEXTTWO, ANSWERTEXTTWO), new Question(QUESTIONTEXTTWO, ANSWERTEXTTWO));
        assertEquals(out.getAll().size(), 2);
        actual.add(new Question(QUESTIONTEXTTWO, ANSWERTEXTTWO));
        assertEquals(out.getAll(), actual);

    }

    @Test
    public void testAddWithTextException() {
        assertThrows(EmptyParameterException.class, () -> out.add("", ANSWERTEXTONE));
        assertThrows(EmptyParameterException.class, () -> out.add(QUESTIONTEXTTWO, ""));
    }

    @Test
    public void testAddWithObjects() {
        assertEquals(out.getAll().size(), 0);
        HashSet<Question> actual = new HashSet<>();

        assertEquals(out.add(QUESTIONTHREE), QUESTIONTHREE);
        assertEquals(out.getAll().size(), 1);
        actual.add(QUESTIONTHREE);
        assertEquals(out.getAll(), actual);

        assertEquals(out.add(QUESTIONFOUR), QUESTIONFOUR);
        assertEquals(out.getAll().size(), 2);
        actual.add(QUESTIONFOUR);
        assertEquals(out.getAll(), actual);

    }

    @Test
    public void testRemove() {
        assertEquals(out.getAll().size(), 0);
        HashSet<Question> actual = new HashSet<>();
        out.add(QUESTIONTHREE);
        assertEquals(out.getAll().size(), 1);

        assertEquals(out.remove(QUESTIONTHREE), QUESTIONTHREE);
        assertEquals(out.getAll().size(), 0);
        assertEquals(out.getAll(), actual);
    }

    @Test
    public void testRemoveException() {
        assertThrows(AbsentQuestionException.class, () -> out.remove(QUESTIONTHREE));
    }

    @Test
    public void testGetRandomQustion() {
        out.add(QUESTIONTHREE);
        assertEquals(out.getRandomQuestion(),QUESTIONTHREE);
        out.add(QUESTIONFOUR);
        assertTrue(out.getAll().contains(out.getRandomQuestion()));
    }

    @Test
    public void testGetRandomQuestionException() {
        assertThrows(EmptyParameterException.class, () ->  out.getRandomQuestion());
    }


}
