package dao;

import entities.Address;

import javax.persistence.EntityManager;

public class AddressDao extends AbstractDao<Long, Address>{

    public AddressDao(EntityManager entityManager) {
        super(entityManager);
    }


    public Class<Address> entityClass() {
        return Address.class;
    }
}
