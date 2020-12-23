package dao;

import entities.Student;
import javax.persistence.EntityManager;

public class StudentDao extends AbstractDao<Long, Student>{


    public StudentDao(EntityManager entityManager) {
        super(entityManager);
    }

    public Class<Student> entityClass() {
        return Student.class;
    }
}
