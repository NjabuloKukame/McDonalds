/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mcdonalds;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tikkun
 */
public class BurgerDAO {
    
    public List<Burger> getBurgerItems(){
        List<Burger> burgerItems = new ArrayList<>();
        String query = "SELECT item_name, price FROM burger";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                String name = resultSet.getString("item_name");
                double price = resultSet.getDouble("price");
                burgerItems.add(new Burger(name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return burgerItems;
    }
    
    
}
