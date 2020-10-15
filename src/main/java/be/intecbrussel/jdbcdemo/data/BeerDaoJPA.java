package be.intecbrussel.jdbcdemo.data;

import be.intecbrussel.jdbcdemo.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.jdbcdemo.model.Beer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BeerDaoJPA implements BeerDao{
    private EntityManagerFactory emf= EntityManagerFactoryProvider.getInstance().getEmf();
    @Override
    public void createBeer(Beer beer) {
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("beerpersistenceunit");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(beer);
            em.getTransaction().commit();

        }finally{
            if(em != null) em.close();
            if(emf != null) emf.close();
        }
    }

    @Override
    public Beer readBeer(int beerId) {
        // use .find() method
        Beer beer = null;
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{em = emf.createEntityManager();
        beer = em.find(Beer.class, beerId);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            if(em != null) em.close();
        }
        return beer;
    }

    @Override
    public Beer readBeer(String beerName) {
        return null;
    }

    @Override
    public void updateBeer(Beer beer) {
       EntityManager em = null;
       try {
           em = emf.createEntityManager();
           Beer beerToUpdate = em.find(Beer.class, beer.getId());

           em.getTransaction().begin();
           em.merge(beer);
//           beerToUpdate.setBeerName(beer.getBeerName());
//           beerToUpdate.setPrice(beer.getPrice());
//           beerToUpdate.setStock(beer.getStock());
//           beerToUpdate.setAlcoholPercentage(beer.getAlcoholPercentage());
           em.getTransaction().commit();

       }catch(Exception ex){
           ex.printStackTrace();
       }finally{
           if(em != null) em.close();
       }



    }

    @Override
    public void deleteBeer(Beer beer) {
        EntityManager em = null;
        try{
            em = emf.createEntityManager();
            Beer beerToDelete = em.find(Beer.class, beer.getId());
            em.getTransaction().begin();
            em.remove(beerToDelete);
            em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(em != null) em.close();
        }

    }

    @Override
    public List<Beer> readAllBeers() {
        return null;
    }

    @Override
    public List<Beer> readAllBeersHavingAlcoholLowerThan(double maxAlcohol) {
        return null;
    }

    @Override
    public List<Beer> readAllBeersHavingStockHigherThan(int minimumStock) {
        return null;
    }
}
