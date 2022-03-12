package pro.sky.java.course2.course_2_work.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.course_2_work.data.Question;
import pro.sky.java.course2.course_2_work.exceptions.IllegalCountOfQuestionException;
import pro.sky.java.course2.course_2_work.service.impl.ExaminerServiceImpl;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.course_2_work.JavaQuestionServiceConstants.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    private QuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;


    @Test
    public void testGetListQuestion() {
        when(questionServiceMock.getRandomQuestion()).thenReturn(QUESTIONFOUR);
        when(questionServiceMock.getAll()).thenReturn(QUESTIONS);
        Set<Question> actual = Set.of(QUESTIONFOUR);
        assertEquals(out.getQuestion(1), actual);

        assertThrows(IllegalCountOfQuestionException.class, () -> out.getQuestion(10));
        assertThrows(IllegalCountOfQuestionException.class, () -> out.getQuestion(-1));

    }

}
