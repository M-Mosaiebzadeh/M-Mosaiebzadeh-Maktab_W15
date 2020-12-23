package generator;

import entities.Student;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class StudentGenerator {
    public static Student createStudent(String firstname, String lastname,String studentCode, LocalDate birthdate) {
        return new Student(firstname,lastname,studentCode, birthdate);
    }
    public static Student createStudent(String firstname, String lastname, String studentCode) {
        Student student = new Student();
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setStudentCode(studentCode);
        return student;
    }
}
