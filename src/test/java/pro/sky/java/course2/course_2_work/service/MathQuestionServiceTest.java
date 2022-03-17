package pro.sky.java.course2.course_2_work.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.course_2_work.data.MathQuestionRepository;
import pro.sky.java.course2.course_2_work.service.impl.MathQuestionService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.course_2_work.JavaQuestionServiceConstants.*;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Mock
    private MathQuestionRepository mathQuestionRepositoryMock;

    @InjectMocks
    private MathQuestionService out;

    @Test
    public void testAddFromString() {
        when(mathQuestionRepositoryMock.add(QUESTIONONE)).thenReturn(QUESTIONONE);
        when(mathQuestionRepositoryMock.getAll()).thenReturn(QUESTION_SET_OF_ONE);

        assertEquals(out.add(QUESTIONTEXTONE, ANSWERTEXTONE), QUESTIONONE);
        assertEquals(out.getAll().size(), 1);
    }

    @Test
    public void testAddFromObject() {
        when(mathQuestionRepositoryMock.add(QUESTIONONE)).thenReturn(QUESTIONONE);
        when(mathQuestionRepositoryMock.getAll()).thenReturn(QUESTION_SET_OF_ONE);

        assertEquals(out.add(QUESTIONONE), QUESTIONONE);
        assertEquals(out.getAll().size(), 1);

    }

    @Test
    public void testRemove() {
        when(mathQuestionRepositoryMock.remove(QUESTIONONE)).thenReturn(QUESTIONONE);
        assertEquals(out.remove(QUESTIONONE), QUESTIONONE);

    }

    @Test
    public void testGetAll() {
        when(mathQuestionRepositoryMock.getAll()).thenReturn(QUESTIONSMATHS);
        assertEquals(out.getAll(), QUESTIONSMATHS);

    }

    @Test
    public void testGetRandomQuestion() {
        when(mathQuestionRepositoryMock.getAll()).thenReturn(QUESTIONSMATHS);
        assertTrue(QUESTIONSMATHS.contains(out.getRandomQuestion()));
    }


}
