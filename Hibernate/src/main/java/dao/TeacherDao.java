package dao;

import entities.Teacher;

import javax.persistence.EntityManager;

public class TeacherDao extends AbstractDao<Long, Teacher> {
    public TeacherDao(EntityManager entityManager) {
        super(entityManager);
    }

    public Class<Teacher> entityClass() {
        return Teacher.class;
    }
}
