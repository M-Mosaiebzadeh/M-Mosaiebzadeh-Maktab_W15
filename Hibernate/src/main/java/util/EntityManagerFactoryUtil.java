package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory createEntityManagerFactory() {
        if(entityManagerFactory == null)
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        return entityManagerFactory;
    }

    public static void shutdown() {
        if(entityManagerFactory != null)
            entityManagerFactory.close();
    }
}
