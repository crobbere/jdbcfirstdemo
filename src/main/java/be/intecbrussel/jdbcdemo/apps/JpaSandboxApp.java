package be.intecbrussel.jdbcdemo.apps;

import be.intecbrussel.jdbcdemo.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.jdbcdemo.model.Beer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Scanner;

public class JpaSandboxApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();
        EntityManager em = null;
        try{
            Beer beer = new Beer("sandbeer", 0, 1, 10000);
            em = emf.createEntityManager();
            em.persist(beer);
            em.getTransaction().begin();
            beer.setBeerName("sandy beer");
            em.flush();
            new Scanner(System.in).nextLine();
            em.getTransaction().commit();
        }catch(Exception exception){
            exception.printStackTrace();
        }finally{
            if(em != null) em.close();
        }
    }
}
