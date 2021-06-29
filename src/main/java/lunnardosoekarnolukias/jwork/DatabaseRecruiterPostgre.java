package lunnardosoekarnolukias.jwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseRecruiterPostgre {

    public static Recruiter insertRecruiter(Recruiter recruiter) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String name = recruiter.getName();
            String email = recruiter.getEmail();
            String phoneNumber = recruiter.getPhoneNumber();
            int locationId = recruiter.getLocation().getId();

            String sql = "INSERT INTO recruiter (name, email, phoneNumber, locationId) " +
                    "VALUES ('" + name + "', '" + email + "', '" + phoneNumber + "', '" + locationId + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return recruiter;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method ini akan mengambil lastId atau id terakhir dari database recruiter
     *
     * @return lastId atau id terakhir dari database recruiter
     */
    public static int getLastRecruiterId() {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        int lastId = 0;
        try {
            String sql = "SELECT MAX(id) AS lastId FROM recruiter;";
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

    /**
     * Method ini akan mengambil semua entry recruiter yang terdapat pada database
     *
     * @return array list yang berisi recruiter apabila berhasil, null apabila gagal
     */
    public static ArrayList<Recruiter> getRecruiterDatabase() {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Recruiter recruiter = null;
        ArrayList<Recruiter> recruiterList = new ArrayList<>();
        int id = 0;
        String name = null;
        String email = null;
        String phoneNumber = null;
        int locationId = 0;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM recruiter;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                phoneNumber = rs.getString("phoneNumber");
                locationId = rs.getInt("locationId");
                recruiter = new Recruiter(id, name, email, phoneNumber, DatabaseLocation.getLocationById(locationId));
                recruiterList.add(recruiter);
            }
            rs.close();
            stmt.close();
            c.close();
            return id != 0? recruiterList : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method untuk mengambil recruiter dari database recruiter melalui id
     *
     * @param recruiterId sebagai id acuan untuk mengambil recruiter
     * @return objek recruiter apabila berhasil, null apabila terjadi exception
     */
    public static Recruiter getRecruiterById(int recruiterId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Recruiter recruiter = null;
        int id = 0;
        String name = null;
        String email = null;
        String phoneNumber = null;
        int locationId = 0;

        try {
            String sql = "SELECT * FROM recruiter WHERE id = '" + recruiterId + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                phoneNumber = rs.getString("phoneNumber");
                locationId = rs.getInt("locationId");
            }
            rs.close();
            stmt.close();
            c.close();

            recruiter = new Recruiter(id, name, email, phoneNumber, DatabaseLocation.getLocationById(locationId));
            return recruiter;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }    }


    public static void removeRecruiter(int recruiterId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM recruiter WHERE id = '" + recruiterId + "';";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
