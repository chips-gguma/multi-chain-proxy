package com.sp.fc.web.controller;

import com.sp.fc.web.student.Student;
import com.sp.fc.web.student.StudentManager;
import com.sp.fc.web.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/teacher") // 모바일에서는 api/teacher를 호출
public class MobTeacherController {

    @Autowired
    private StudentManager studentManager;

    @PreAuthorize("hasAnyAuthority('ROLE_TEACHER')")
    @GetMapping("/students")
    public List<Student> students(@AuthenticationPrincipal Teacher teacher) { // json 객체로 내려받음

        // 해당 페이지 쪽으로 학생 리스트를 넘겨 줌
        return studentManager.myStudents(teacher.getId());
    }


}
