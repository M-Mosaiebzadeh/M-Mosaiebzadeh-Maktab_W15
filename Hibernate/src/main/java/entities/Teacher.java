package entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher implements IEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "teacher_code",nullable = false,unique = true)
    private String teacherCode;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_student",
    joinColumns = @JoinColumn(name = "fk_teacher"),
    inverseJoinColumns = @JoinColumn(name = "fk_student"))
    private Set<Student> students;

    @OneToOne(mappedBy = "teacher")
    private Address address;

    public Teacher() {

    }

    public Teacher(String firstname, String lastname,String teacherCode, Double salary, LocalDate birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.teacherCode = teacherCode;
        setSalary(salary);
        this.birthdate = birthdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        if (salary != 0)
            this.salary = salary;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Address getTeacherAddress() {
        return address;
    }

    public void setTeacherAddress(Address teacherAddress) {
        this.address = teacherAddress;
    }
}
