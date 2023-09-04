package org.kutsepalov.gpt.research.usecase7.student;

import java.util.List;

public class StudentConverter {

    public List<Student> convertStudents(List<Student> students) {

        return students.stream().map(student -> {
            Student result = new Student();

            result.setName(student.getName());
            result.setAge(student.getAge());
            result.setGrade(student.getGrade());

            if (student.getGrade() > 90) {
                if (student.getAge() < 21) {
                    result.setExceptional(true);
                } else {
                    result.setHonorRoll(true);
                }
            } else {
                result.setPassed(student.getGrade() > 70);
            }
            return result;

        }).toList();
    }
}

