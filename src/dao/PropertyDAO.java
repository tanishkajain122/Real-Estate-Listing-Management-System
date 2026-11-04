package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DatabaseConnection;
import model.Property;

public class PropertyDAO {

    // Add a new property
    public boolean addProperty(Property property) {

        String sql = "INSERT INTO properties " +
                "(title, description, property_type, bhk, area_sqft, price, " +
                "city, locality, address, status, owner_name, owner_phone, image_path) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, property.getTitle());
            statement.setString(2, property.getDescription());
            statement.setString(3, property.getPropertyType());
            statement.setInt(4, property.getBhk());
            statement.setInt(5, property.getAreaSqft());
            statement.setDouble(6, property.getPrice());
            statement.setString(7, property.getCity());
            statement.setString(8, property.getLocality());
            statement.setString(9, property.getAddress());
            statement.setString(10, property.getStatus());
            statement.setString(11, property.getOwnerName());
            statement.setString(12, property.getOwnerPhone());
            statement.setString(13, property.getImagePath());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all properties
    public List<Property> getAllProperties() {

        List<Property> properties = new ArrayList<>();

        String sql = "SELECT * FROM properties";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                Property property = new Property(
                        result.getInt("property_id"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("property_type"),
                        result.getInt("bhk"),
                        result.getInt("area_sqft"),
                        result.getDouble("price"),
                        result.getString("city"),
                        result.getString("locality"),
                        result.getString("address"),
                        result.getString("status"),
                        result.getString("owner_name"),
                        result.getString("owner_phone"),
                        result.getString("image_path")
                );

                properties.add(property);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return properties;
    }

    public List<Property> searchProperties(
        String city,
        String locality,
        double minPrice,
        double maxPrice,
        String propertyType,
        int bhk) {

    List<Property> properties = new ArrayList<>();

    StringBuilder sql = new StringBuilder(
            "SELECT * FROM properties " +
            "WHERE city = ? " +
            "AND price BETWEEN ? AND ? " +
            "AND status = 'Available'"
    );

    List<Object> parameters = new ArrayList<>();

    parameters.add(city);
    parameters.add(minPrice);
    parameters.add(maxPrice);

    // Add locality filter only if user did NOT select All
    if (!locality.equals("All")) {
        sql.append(" AND locality = ?");
        parameters.add(locality);
    }

    // Add property type filter only if user did NOT select All
    if (!propertyType.equals("All")) {
        sql.append(" AND property_type = ?");
        parameters.add(propertyType);
    }

    // Add BHK filter only if user did NOT select All
    if (bhk != 0) {
        sql.append(" AND bhk = ?");
        parameters.add(bhk);
    }

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement =
                 connection.prepareStatement(sql.toString())) {

        for (int i = 0; i < parameters.size(); i++) {
            Object parameter = parameters.get(i);

            if (parameter instanceof String) {
                statement.setString(i + 1, (String) parameter);
            } else if (parameter instanceof Double) {
                statement.setDouble(i + 1, (Double) parameter);
            } else if (parameter instanceof Integer) {
                statement.setInt(i + 1, (Integer) parameter);
            }
        }

        ResultSet result = statement.executeQuery();

        while (result.next()) {

            Property property = new Property(
                    result.getInt("property_id"),
                    result.getString("title"),
                    result.getString("description"),
                    result.getString("property_type"),
                    result.getInt("bhk"),
                    result.getInt("area_sqft"),
                    result.getDouble("price"),
                    result.getString("city"),
                    result.getString("locality"),
                    result.getString("address"),
                    result.getString("status"),
                    result.getString("owner_name"),
                    result.getString("owner_phone"),
                    result.getString("image_path")
            );

            properties.add(property);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return properties;
}
}