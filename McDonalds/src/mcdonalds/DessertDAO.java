/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mcdonalds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tikkun
 */
public class DessertDAO {
    public List<Dessert> getDessertItems() {
        List<Dessert> dessertItems = new ArrayList<>();
        String query = "SELECT name, price FROM desserts";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                dessertItems.add(new Dessert(name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dessertItems;
    }
}
