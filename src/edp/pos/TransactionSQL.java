package edp.pos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TransactionSQL {

    public static boolean addTransaction(java.util.Date dateTime, double amount, double change, String staff) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
            PreparedStatement  pst = con.prepareStatement("insert into transactions (date_time, amount, change_amount, staff) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            
            pst.setTimestamp(1, new java.sql.Timestamp(dateTime.getTime()));
            pst.setDouble(2, amount);
            pst.setDouble(3, change);
            pst.setString(4, staff);

            int rowsAffected = pst.executeUpdate();

            ResultSet keys = pst.getGeneratedKeys();
            if (keys.next()) {
                int transactionNo = keys.getInt(1);
                System.out.println("New Transaction #: " + transactionNo);
            }

            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
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
}
