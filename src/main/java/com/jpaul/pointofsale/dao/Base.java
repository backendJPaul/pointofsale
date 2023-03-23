package com.jpaul.pointofsale.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Base {
    protected Connection connection;
    protected CallableStatement callableStatement;
    protected ResultSet resultSet;

    public void connect()throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posstore","admin","root");
        }
        catch(Exception e){
            throw new Exception(e.toString());
        }
    }
    public void disconnect()throws Exception{
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(callableStatement != null){
                callableStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        catch(Exception e){
            throw new Exception(e.toString());
        }
    }

}
