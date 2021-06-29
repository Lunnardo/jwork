package lunnardosoekarnolukias.jwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseBonusPostgre {

    public static Bonus insertBonus(Bonus bonus) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            int extraFee = bonus.getExtraFee();
            int minTotalFee = bonus.getMinTotalFee();
            String referralCode = bonus.getReferralCode();
            boolean active = bonus.getActive();

            String sql = "INSERT INTO bonus (extraFee, minTotalFee, referralCode, active) " +
                    "VALUES ('" + extraFee + "', '" + minTotalFee + "', '" + referralCode + "', '" + active + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return bonus;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getLastBonusId() {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        int lastId = 0;
        try {
            String sql = "SELECT MAX(id) AS lastId FROM bonus;";
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

    public static ArrayList<Bonus> getBonusDatabase() {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Bonus bonus = null;
        ArrayList<Bonus> bonusList = new ArrayList<>();
        int id = 0;
        int extraFee = 0;
        int minTotalFee = 0;
        String referralCode = null;
        boolean active = false;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM bonus;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                extraFee = rs.getInt("extraFee");
                minTotalFee = rs.getInt("minTotalFee");
                referralCode = rs.getString("referralCode");
                active = rs.getBoolean("active");
                bonus = new Bonus(id, referralCode, extraFee, minTotalFee, active);
                bonusList.add(bonus);
            }
            rs.close();
            stmt.close();
            c.close();
            return id != 0? bonusList : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bonus getBonusById(int bonusId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Bonus bonus = null;
        int id = 0;
        int extraFee = 0;
        int minTotalFee = 0;
        String referralCode = null;
        boolean active = false;
        try {
            String sql = "SELECT * FROM bonus WHERE id = '" + bonusId + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                extraFee = rs.getInt("extraFee");
                minTotalFee = rs.getInt("minTotalFee");
                referralCode = rs.getString("referralCode");
                active = rs.getBoolean("active");
            }
            rs.close();
            stmt.close();
            c.close();
            bonus = new Bonus(id, referralCode, extraFee, minTotalFee, active);
            return bonus;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bonus getBonusByReferralCode(String referralCodeTable) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Bonus bonus = null;
        int id = 0;
        int extraFee = 0;
        int minTotalFee = 0;
        String referralCode = null;
        boolean active = false;
        try {
            String sql = "SELECT * FROM bonus WHERE referralCode = '" + referralCodeTable + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                extraFee = rs.getInt("extraFee");
                minTotalFee = rs.getInt("minTotalFee");
                referralCode = rs.getString("referralCode");
                active = rs.getBoolean("active");
            }
            rs.close();
            stmt.close();
            c.close();
            bonus = new Bonus(id, referralCode, extraFee, minTotalFee, active);
            return bonus;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void removeBonus(int bonusId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM bonus WHERE id = '" + bonusId + "';";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
