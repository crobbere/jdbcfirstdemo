package be.intecbrussel.jdbcdemo.data;

import be.intecbrussel.jdbcdemo.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.jdbcdemo.model.Brewers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class BrewersDaoJPA implements BrewersDao{
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createBrewer(Brewers brewer) {
        EntityManager em = null;
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(brewer);
            em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(em !=null) em.close();
        }

    }

    @Override
    public Brewers readBrewer(int brewerId) {
        EntityManager em = null;
        Brewers brewerToFind = new Brewers();
        try{
            em = emf.createEntityManager();
            brewerToFind = em.find(Brewers.class, brewerId);
        }catch (Exception ex){

        }finally{

        }
        return brewerToFind;
    }



    @Override
    public void updateBrewer(Brewers brewer) {
        EntityManager em = null;
        Brewers brewerToFind;
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            brewerToFind = em.find(Brewers.class, brewer.getId());
            brewerToFind.setAddress(brewer.getAddress());
            brewerToFind.setCity(brewer.getCity());
            brewerToFind.setName(brewer.getName());
            brewerToFind.setTurnover(brewer.getTurnover());
            em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(em != null) em.close();
        }

    }

    @Override
    public void deleteBrewer(Brewers brewer) {
        EntityManager em = null;
        Brewers brewerToDelete;
        try{
            em = emf.createEntityManager();
            brewerToDelete = em.find(Brewers.class, brewer.getId());
            em.remove(brewerToDelete);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(em != null) em.close();
        }
    }
}
