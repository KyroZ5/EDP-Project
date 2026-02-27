
package edp.pos;

import java.util.ArrayList;
import java.util.List;

public class Users {
    public static List<Users> accts = new ArrayList<>();
    private String username;
    private String password;
    private String employeeName;

    private static boolean isAdmin;
    private static String staff;

    public Users(String username, String password, String employeeName) {
        this.username = username;
        this.password = password;
        this.employeeName = employeeName;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmployeeName() { return employeeName; }

    public static void setAdmin(boolean admin) { isAdmin = admin; }
    public static boolean isAdmin() { return isAdmin; }

    public static void setStaff(String staffName) { staff = staffName; }
    public static String getStaff() { return staff; }
}