package be.intecbrussel.jdbcdemo.data;

import be.intecbrussel.jdbcdemo.model.Beer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BeerDaoJdbcImpl implements BeerDao {
    String CONNECTIONSTRING = "jdbc:mysql://localhost:3306/beersdb";
    String USERNAME = "root";
    String PASSWORD = "nAt25PEx";


    @Override
    public void createBeer(Beer beer) {

        try (Connection connection = DriverManager.getConnection(CONNECTIONSTRING, USERNAME, PASSWORD)) {
            // ask for a statement
            PreparedStatement statement = connection.prepareStatement("insert into beers(name,alcohol,Price,Stock) value (?,?,?,? )");
            statement.setString(1,beer.getBeerName());
            statement.setDouble(2,beer.getAlcoholPercentage());
            statement.setDouble(3,beer.getPrice());
            statement.setInt(4,beer.getStock());
            //use this statement to execute a query
            statement.execute();
            // do database things
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Beer readBeer(int beerId) {
        Beer beer = null;
        try (Connection connection = DriverManager.getConnection(CONNECTIONSTRING, USERNAME, PASSWORD)) {
            // ask for a statement
            PreparedStatement statement = connection.prepareStatement("select * from beers where Id=?");
            statement.setInt(1,beerId);
            //use this statement to execute a query
            ResultSet resultSet = statement.executeQuery();
            // do database things
            if (resultSet.next()){
                beer = new Beer();
                beer.setBeerName(resultSet.getString("name"));
                beer.setAlcoholPercentage(resultSet.getDouble("alcohol"));
                beer.setPrice(resultSet.getDouble("Price"));
                beer.setStock(resultSet.getInt("stock"));
                beer.setId(resultSet.getInt("id"));
            }
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }


        return beer;
    }

    @Override
    public Beer readBeer(String beerName) {
        Beer beer = null;
        try (Connection connection = DriverManager.getConnection(CONNECTIONSTRING, USERNAME, PASSWORD)) {
            // ask for a statement
            PreparedStatement statement = connection.prepareStatement("select * from beers where Name=?");
            statement.setString(1,beerName);
            //use this statement to execute a query
            ResultSet resultSet = statement.executeQuery();
            // do database things
            if (resultSet.next()){
                beer = new Beer();
                beer.setBeerName(resultSet.getString("name"));
                beer.setAlcoholPercentage(resultSet.getDouble("alcohol"));
                beer.setPrice(resultSet.getDouble("Price"));
                beer.setStock(resultSet.getInt("stock"));
                beer.setId(resultSet.getInt("id"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }


        return beer;
    }

    @Override
    public void updateBeer(Beer beer) {
        try (Connection connection = DriverManager.getConnection(CONNECTIONSTRING, USERNAME, PASSWORD)) {
            // ask for a statement
            PreparedStatement statement = connection.prepareStatement("update beers set name=? ,alcohol=?,Price=?,Stock=? where id =?");
            statement.setString(1,beer.getBeerName());
            statement.setDouble(2,beer.getAlcoholPercentage());
            statement.setDouble(3,beer.getPrice());
            statement.setInt(4,beer.getStock());
            statement.setInt(5,beer.getId());
            //use this statement to execute a query
            statement.execute();
            // do database things
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteBeer(Beer beer) {
        try (Connection connection = DriverManager.getConnection(CONNECTIONSTRING, USERNAME, PASSWORD)) {
            // ask for a statement
            PreparedStatement statement = connection.prepareStatement("DELETE from beers where Id = ?");
            statement.setInt(1,beer.getId());
            //use this statement to execute a query
            statement.execute();
            // do database things
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Beer> readAllBeers() {
        List<Beer> beerList = new ArrayList<>();

        try(Connection connection=DriverManager.getConnection(CONNECTIONSTRING,USERNAME,PASSWORD)){
            PreparedStatement statement = connection.prepareStatement("select * from beers");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Beer beer = new Beer();
                beer.setBeerName(resultSet.getString("name"));
                beer.setAlcoholPercentage(resultSet.getDouble("alcohol"));
                beer.setPrice(resultSet.getDouble("Price"));
                beer.setStock(resultSet.getInt("stock"));
                beer.setId(resultSet.getInt("id"));
                beerList.add(beer);
            }
            resultSet.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return beerList;
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
