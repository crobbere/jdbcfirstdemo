package be.intecbrussel.jdbcdemo.data;

import be.intecbrussel.jdbcdemo.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.jdbcdemo.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CategoryDaoJPA implements CategoryDao{
    private EntityManagerFactory emf= EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createCategory(Category category) {
        EntityManager em = null;
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(category);
            em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(em != null) em.close();
        }

    }

    @Override
    public Category readCategory(int categoryId) {
        EntityManager em = null;
        Category categoryToFind = new Category();
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            categoryToFind = em.find(Category.class, categoryId);
            em.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
            if(em != null) em.close();
        }
        return categoryToFind;
    }

    @Override
    public void updateCategory(Category category) {
        EntityManager em = null;

        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(category);
            em.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
            if(em != null) em.close();
        }

    }

    @Override
    public void deleteCategory(Category category) {
        EntityManager em = null;

        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.remove(category);
            em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(em != null) em.close();
        }

    }
}
