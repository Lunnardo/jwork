package lunnardosoekarnolukias.jwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class DatabaseJobseekerPostgre {

    public static Jobseeker insertJobseeker(Jobseeker jobseeker) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            int id = jobseeker.getId();
            String name = jobseeker.getName();
            String email = jobseeker.getEmail();
            String password = jobseeker.getPassword();
            int year = jobseeker.getJoinDate().get(Calendar.YEAR) - 1;
            int month = jobseeker.getJoinDate().get(Calendar.MONTH) - 1;
            int day = jobseeker.getJoinDate().get(Calendar.DATE) - 1;
            String sql = "INSERT INTO jobseeker ( name, email, password, year, month, day) " +
                    "VALUES ('" + name + "', '" + email + "', '" + password + "', '" + year + "', '" + month + "', '" + day + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return jobseeker;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getLastJobseekerId() {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        int lastId = 0;
        try {
            String sql = "SELECT MAX(id) AS lastId FROM jobseeker;";
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

    public static Jobseeker getJobseekerById(int jobseekerId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Jobseeker jobseeker = null;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        int year = 0;
        int month = 0;
        int day = 0;
        try {
            String sql = "SELECT * FROM jobseeker WHERE id = '" + jobseekerId + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                year = rs.getInt("year");
                month = rs.getInt("month");
                day = rs.getInt("day");
            }
            rs.close();
            stmt.close();
            c.close();

            jobseeker = new Jobseeker(id, name, email, password, year, month, day);
            return jobseeker;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void removeJobseeker(int jobseekerId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM jobseeker WHERE id = '" + jobseekerId + "';";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Jobseeker getJobseekerLogin(String emailLog, String passwordLog) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Jobseeker jobseeker = null;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        int year = 0;
        int month = 0;
        int day = 0;
        try {
            String sql = "SELECT * FROM jobseeker WHERE email = '" + emailLog + "' AND password = '" + passwordLog + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                year = rs.getInt("year");
                month = rs.getInt("month");
                day = rs.getInt("day");
            }
            rs.close();
            stmt.close();
            c.close();

            jobseeker = new Jobseeker(id, name, email, password, year, month, day);
            return jobseeker;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
