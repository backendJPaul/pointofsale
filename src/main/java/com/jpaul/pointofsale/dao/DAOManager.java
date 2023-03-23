package com.jpaul.pointofsale.dao;

public class DAOManager {
    private DAOCategory daoCategory = null;

    public DAOCategory getDAOCategory(){
        return daoCategory = new DAOCategory();
    }
}
