package be.intecbrussel.jdbcdemo.data;

import be.intecbrussel.jdbcdemo.model.Category;

public interface CategoryDao {

    void createCategory(Category category);
    Category readCategory(int categoryId);
    void updateCategory(Category category);
    void deleteCategory(Category category);
}
