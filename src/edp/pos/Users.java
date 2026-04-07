package edp.pos;

import java.util.ArrayList;
import java.util.List;

public class Users {
    public static List<Users> accts = new ArrayList<>();
    
    private String username;
    private String password;
    private String name;   
    private String role;

    private static String currentUsername;
    private static String currentName;
    private static String currentRole;

    public Users(String username, String password, String name, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getRole() { return role; }

    public static void setCurrentUser(String username, String name, String role) {
        currentUsername = username;
        currentName = name;
        currentRole = role;
    }
    public static String getCurrentUsername() { return currentUsername; }
    public static String getCurrentName() { return currentName; }
    public static String getCurrentRole() { return currentRole; }
}
