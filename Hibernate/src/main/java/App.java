import dao.AddressDao;
import dao.StudentDao;
import dao.TeacherDao;
import entities.Address;
import entities.Student;
import entities.Teacher;
import generator.AddressGenerator;
import generator.StudentGenerator;
import generator.TeacherGenerator;
import util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class App {

    private static TeacherDao teacherDao;
    private static StudentDao studentDao;
    private static AddressDao addressDao;

    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerFactoryUtil.createEntityManagerFactory().createEntityManager();
        initializedDao(entityManager);
        entityManager.getTransaction().begin();
        //=================================================================================
        Student student1 = StudentGenerator.createStudent("ali","alavi","1000", LocalDate.of(2005,12,16));
        Student student2 = StudentGenerator.createStudent("naghi","naghavi","1001", LocalDate.of(2005, 3,7));
        studentDao.save(student1);
        studentDao.save(student2);
        //=================================================================================
        Teacher teacher = TeacherGenerator.createTeacher("rahman","rahmani", "2000", 10_000_000D);
        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        teacher.setStudents(students);
        teacherDao.save(teacher);
        //=================================================================================
        Address address1student1 = AddressGenerator.createAddress("0912","tehran");
        address1student1.setStudent(student1);
        addressDao.save(address1student1);
        //=================================================================================
        Address address2student1 = AddressGenerator.createAddress("0913","tehran","tehran","1234567890");
        address2student1.setStudent(student1);
        addressDao.save(address2student1);
        //=================================================================================
        Address teacherAddress = AddressGenerator.createAddress("0915","tehran");
        teacherAddress.setTeacher(teacher);
        addressDao.save(teacherAddress);



        entityManager.getTransaction().commit();
        entityManager.close();
        EntityManagerFactoryUtil.shutdown();

    }

    public static void initializedDao(EntityManager entityManager) {
        teacherDao = new TeacherDao(entityManager);
        studentDao = new StudentDao(entityManager);
        addressDao = new AddressDao(entityManager);
    }

}
