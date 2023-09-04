package org.kutsepalov.gpt.research.usecase7.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentConverterTest {

    private final StudentConverter testable = new StudentConverter();

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setName("Mike Wazowski");
    }

    @Test
    @DisplayName("High Achiever")
    void studentShouldBeHonorRoll() {
        final int age = 21;
        final int grade = 91;

        student.setAge(age);
        student.setGrade(grade);

        List<Student> resultList = testable.convertStudents(List.of(student));

        assertNotNull(resultList);
        assertEquals(1, resultList.size());

        Student result = resultList.get(0);

        assertEquals(age, result.getAge());
        assertEquals(grade, result.getGrade());
        assertEquals(student.getName(), result.getName());

        assertTrue(result.isHonorRoll());
        assertFalse(result.isExceptional());
        assertFalse(result.isPassed());
    }

    @Test
    @DisplayName("Exceptional Young High Achiever")
    void studentShouldBeExceptional() {
        final int age = 16;
        final int grade = 95;

        student.setAge(age);
        student.setGrade(grade);

        List<Student> resultList = testable.convertStudents(List.of(student));

        assertNotNull(resultList);
        assertEquals(1, resultList.size());

        Student result = resultList.get(0);

        assertEquals(age, result.getAge());
        assertEquals(grade, result.getGrade());
        assertEquals(student.getName(), result.getName());

        assertFalse(result.isHonorRoll());
        assertTrue(result.isExceptional());
        assertFalse(result.isPassed());
    }

    @Test
    @DisplayName("Passed Student")
    void studentShouldBePassed() {
        final int age = 21;
        final int grade = 71;

        student.setAge(age);
        student.setGrade(grade);

        List<Student> resultList = testable.convertStudents(List.of(student));

        assertNotNull(resultList);
        assertEquals(1, resultList.size());

        Student result = resultList.get(0);

        assertEquals(age, result.getAge());
        assertEquals(grade, result.getGrade());
        assertEquals(student.getName(), result.getName());

        assertFalse(result.isHonorRoll());
        assertFalse(result.isExceptional());
        assertTrue(result.isPassed());
    }

    @Test
    @DisplayName("Failed Student")
    void studentShouldBeFailed() {
        final int age = 21;
        final int grade = 70;

        student.setAge(age);
        student.setGrade(grade);

        List<Student> resultList = testable.convertStudents(List.of(student));

        assertNotNull(resultList);
        assertEquals(1, resultList.size());

        Student result = resultList.get(0);

        assertEquals(age, result.getAge());
        assertEquals(grade, result.getGrade());
        assertEquals(student.getName(), result.getName());

        assertFalse(result.isHonorRoll());
        assertFalse(result.isExceptional());
        assertFalse(result.isPassed());
    }

    @Test
    @DisplayName("Empty Array")
    void studentListShouldBeEmpty() {

        List<Student> resultList = testable.convertStudents(List.of());

        assertNotNull(resultList);
        assertEquals(0, resultList.size());
    }

    @Test
    @DisplayName("Input is null")
    void exceptionShouldBeThrown() {

        assertThrows(NullPointerException.class, () -> testable.convertStudents(null));
    }
}