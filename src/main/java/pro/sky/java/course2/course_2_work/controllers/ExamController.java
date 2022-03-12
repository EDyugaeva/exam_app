package pro.sky.java.course2.course_2_work.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.course_2_work.data.Question;
import pro.sky.java.course2.course_2_work.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get")
    public Collection<Question> getQuestion(@RequestParam int amount) {
        return examinerService.getQuestion(amount);
    }
}
