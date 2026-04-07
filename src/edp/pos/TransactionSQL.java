package edp.pos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TransactionSQL {

    public static int addTransaction(java.util.Date dateTime, double amount, double change, String staff) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
             PreparedStatement pst = con.prepareStatement("INSERT INTO transactions (date_time, amount, change_amount, staff) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            pst.setTimestamp(1, new java.sql.Timestamp(dateTime.getTime()));
            pst.setDouble(2, amount);
            pst.setDouble(3, change);
            pst.setString(4, staff);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet keys = pst.getGeneratedKeys();
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
            return -1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }


    public static void loadTransactions(DefaultTableModel model) {
        model.setRowCount(0);
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM transactions ORDER BY transaction_no DESC")) {

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("transaction_no"),
                    rs.getString("date_time"),
                    rs.getDouble("amount"),
                    rs.getDouble("change_amount"),
                    rs.getString("staff")
                };
                model.addRow(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static boolean deleteTransaction(int transactionNo) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
            PreparedStatement pst = con.prepareStatement("DELETE FROM transactions WHERE transaction_no=?")) {

            pst.setInt(1, transactionNo);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void loadTransactionsByDate(DefaultTableModel model, java.util.Date selectedDate) {
        model.setRowCount(0);
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
            PreparedStatement pst = con.prepareStatement("select * from transactions where date(date_time) = ? ORDER BY transaction_no desc")) {

            String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
            pst.setString(1, date);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("transaction_no"),
                    rs.getTimestamp("date_time"),
                    rs.getDouble("amount"),
                    rs.getDouble("change_amount"),
                    rs.getString("staff")
                };
                model.addRow(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static int getNextTransactionNo() {
        int nextNo = 1;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "")) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT IFNULL(MAX(transaction_no), 0) + 1 AS nextNo FROM transactions");
            if (rs.next()) {
                nextNo = rs.getInt("nextNo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextNo;
    }
}
