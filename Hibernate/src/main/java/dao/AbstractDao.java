package dao;

import entities.IEntity;

import javax.persistence.EntityManager;

public abstract class AbstractDao<K,E extends IEntity<K>> implements Dao<K,E> {

    private final EntityManager entityManager;

    public AbstractDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public E load(K id) {
        return entityManager.find(entityClass(),id);
    }

    public void save(E entity) {
        entityManager.persist(entity);
    }

    public void update(E entity) {
        entityManager.merge(entity);
    }

    public void delete(E entity) {
        entityManager.remove(entity);
    }
    public abstract Class<E> entityClass();
}
