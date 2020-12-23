package generator;

import java.time.LocalDate;
import entities.Teacher;

public class TeacherGenerator {
    public static Teacher createTeacher(String firstname,String lastname,String teacherCode, Double salary,LocalDate birthdate) {
        return new Teacher(firstname,lastname,teacherCode, salary,birthdate);
    }

    public static Teacher createTeacher(String firstname,String lastname, String teacherCode) {
        Teacher teacher = new Teacher();
        teacher.setFirstname(firstname);
        teacher.setLastname(lastname);
        teacher.setTeacherCode(teacherCode);
        return teacher;
    }
    public static Teacher createTeacher(String firstname,String lastname,String teacherCode ,Double salary) {
        Teacher teacher = new Teacher();
        teacher.setFirstname(firstname);
        teacher.setLastname(lastname);
        teacher.setTeacherCode(teacherCode);
        teacher.setSalary(salary);
        return teacher;
    }
    public static Teacher createTeacher(String firstname,String lastname, String teacherCode, LocalDate birthdate) {
        Teacher teacher = new Teacher();
        teacher.setFirstname(firstname);
        teacher.setLastname(lastname);
        teacher.setTeacherCode(teacherCode);
        teacher.setBirthdate(birthdate);
        return teacher;
    }


}
