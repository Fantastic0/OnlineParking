package com.myspring.classes;

import java.sql.*;
import java.util.ArrayList;

public class DBUtil {

    private Connection connection;

    public void connect(){

        try{

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springtask1","root","");

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void addItem(String name, double price){

        connect();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into items (id, name, price) values(NULL, ?, ?)");
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.executeUpdate();
            statement.close();
            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Items> getAllList(){

        ArrayList<Items> arrayList = new ArrayList<Items>();
        connect();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){

                arrayList.add(new Items(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getDouble("price")));

            }
            statement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return arrayList;
    }

    public Items getItemById(Long id){

        Items items = new Items();
        connect();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){

                items = new Items(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getDouble("price"));

            }
            statement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return items;
    }

    public void editItem(Long id, String name, double price){

        connect();
        try {
            PreparedStatement statement = connection.prepareStatement("update items set name = ?, price = ? where id = ?");
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setLong(3, id);
            statement.executeUpdate();
            statement.close();
            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteItem(Long id){

        connect();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from items where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
