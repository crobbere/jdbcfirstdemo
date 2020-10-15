package be.intecbrussel.jdbcdemo.data.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProvider {

    private static EntityManagerFactoryProvider provider;

    private EntityManagerFactory emf;

    private EntityManagerFactoryProvider(){
        emf = Persistence.createEntityManagerFactory("beerpersistenceunit");
    }

    public EntityManagerFactory getEmf() {
        if(emf==null){
            emf = Persistence.createEntityManagerFactory("beerpersistenceunit");
        }
        return emf;
    }
    public static EntityManagerFactoryProvider getInstance(){
        if(provider==null){
            provider = new EntityManagerFactoryProvider();
        }
        return provider;
    }
}