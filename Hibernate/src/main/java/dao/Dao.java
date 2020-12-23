package dao;

import entities.IEntity;

public interface Dao<K,E extends IEntity<K>> {

    E load(K id);

    void save(E entity);

    void update(E entity);

    void delete(E entity);
}
