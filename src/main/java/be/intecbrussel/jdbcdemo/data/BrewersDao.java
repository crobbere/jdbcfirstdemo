package be.intecbrussel.jdbcdemo.data;


import be.intecbrussel.jdbcdemo.model.Brewers;

public interface BrewersDao {

    void createBrewer(Brewers brewer);
    Brewers readBrewer(int brewerId);
    void updateBrewer(Brewers brewer);
    void deleteBrewer(Brewers brewer);
}
