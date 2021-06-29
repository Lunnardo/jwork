package lunnardosoekarnolukias.jwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseLocation {

    public static Location insertLocation(Location location) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String province = location.getProvince();
            String city = location.getCity();
            String description = location.getDescription();
            String sql = "INSERT INTO location (province, city, description) " +
                    "VALUES ('" + province + "', '" + city + "', '" + description + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return location;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getLastLocationId() {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        int lastId = 0;
        try {
            String sql = "SELECT MAX(id) AS lastId FROM location;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lastId = rs.getInt("lastId");
            }
            stmt.close();
            c.close();
            return lastId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastId;
    }


    public static Location getLocationById(int locationId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Location location = null;
        int id = 0;
        String province = null;
        String city = null;
        String description = null;
        try {
            String sql = "SELECT * FROM location WHERE id = '" + locationId + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                province = rs.getString("province");
                city = rs.getString("city");
                description = rs.getString("description");
            }
            rs.close();
            stmt.close();
            c.close();

            location = new Location(id, province, city, description);
            return location;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void removeLocation(int locationId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM location WHERE id = '" + locationId + "';";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
