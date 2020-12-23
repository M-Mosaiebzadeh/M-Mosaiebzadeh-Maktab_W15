package entities;


import java.time.LocalDate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student implements IEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "studentCode",nullable = false,unique = true)
    private String studentCode;

//    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @ManyToMany(mappedBy = "students",cascade = CascadeType.ALL)
    private Set<Teacher> teachers;

    @OneToMany(mappedBy = "student")
    private Set<Address> addresses;

    public Student() {

    }

    public Student(String firstname, String lastname,String studentCode, LocalDate birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentCode = studentCode;
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

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

}
