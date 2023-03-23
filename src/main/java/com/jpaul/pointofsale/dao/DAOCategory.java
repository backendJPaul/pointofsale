package com.jpaul.pointofsale.dao;

import com.jpaul.pointofsale.model.Category;

import java.util.ArrayList;
import java.util.List;

public class DAOCategory extends Base implements IBaseCategory {

    @Override
    public List<Category> fetch(Category o) throws Exception {
        this.connect();
        this.callableStatement = this.connection.prepareCall("call fetchCategory(?)");
        this.callableStatement.setInt(1,o.getIdCatalogStatus());
        return this.setAll();
    }

    @Override
    public Category gotoId(Category o) throws Exception {
        this.connect();
        this.callableStatement = this.connection.prepareCall("call gotoIdCategory(?,?)");
        this.callableStatement.setInt(1,o.getIdCategory());
        this.callableStatement.setInt(2,o.getIdCatalogStatus());

        return this.set();
    }

    @Override
    public Category save(Category o) throws Exception {
        this.connect();
        this.callableStatement = this.connection.prepareCall("call saveCategory(?)");
        this.callableStatement.setString(1,o.getName());
        return this.set();
    }

    @Override
    public Category update(Category o) throws Exception {
        this.connect();
        this.callableStatement = this.connection.prepareCall("call updateCategory(?,?)");
        this.callableStatement.setInt(1,o.getIdCategory());
        this.callableStatement.setString(2,o.getName());
        return this.set();
    }

    @Override
    public Category delete(Category o) throws Exception {
        this.connect();
        this.callableStatement = this.connection.prepareCall("call deleteCategory(?,?)");
        this.callableStatement.setInt(1,o.getIdCatalogStatus());
        this.callableStatement.setInt(2,o.getIdCategory());
        return this.set();
    }

    @Override
    public List<Category> search(Category o) throws Exception {
        this.connect();
        this.callableStatement = this.connection.prepareCall("call searchCategory(?)");
        this.callableStatement.setString(1,o.getName());
        return this.setAll();
    }

    @Override
    public Category set() throws Exception {
        this.resultSet = this.callableStatement.executeQuery();
        this.resultSet.next();
        Category category = new Category();

        category.setIdCategory(resultSet.getInt("idCategory"));
        category.setName(resultSet.getString("name"));
        category.setIdCatalogStatus(resultSet.getInt("idCatalogStatus"));

        this.disconnect();
        return category;
    }

    @Override
    public List<Category> setAll() throws Exception {
        this.resultSet = this.callableStatement.executeQuery();
        ArrayList<Category> categories = new ArrayList<Category>();

        while(this.resultSet.next()){
            Category category = new Category();
            category.setIdCategory(resultSet.getInt("idCategory"));
            category.setName(resultSet.getString("name"));
            category.setIdCatalogStatus(resultSet.getInt("idCatalogStatus"));
            categories.add(category);
        }
        this.disconnect();
        return categories;
    }
}
