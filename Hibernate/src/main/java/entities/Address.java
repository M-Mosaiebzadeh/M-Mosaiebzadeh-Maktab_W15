package entities;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address implements IEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "number",nullable = false,unique = true)
    private String number;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_address")
    private String postalAddress;

    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne()
    @JoinColumn(name = "fk_student")
    private Student student;

    @OneToOne()
    @JoinColumn(name = "fk_teacher")
    private Teacher teacher;

    public Address() {
    }

    public Address(String number, String state, String city, String postalAddress, String postalCode) {
        this.number = number;
        this.state = state;
        this.city = city;
        this.postalAddress = postalAddress;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
