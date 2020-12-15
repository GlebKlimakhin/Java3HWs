package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddToDB {
    public static Connection connection;
    public static Statement stmt;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:users.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insert(String login, String password, String nickname){
        String sql = String.format("INSERT INTO users (login, password, nickname) VALUES ('%s', '%s', '%s')", login, password, nickname);
            try{
            stmt.executeUpdate(sql);}
            catch (Exception e) {
                e.printStackTrace();
            }
    }
    public static void upd(String nickname){
        String sql = String.format("UPDATE users SET nickname = \"d\" WHERE login = \"d\";");
        try{
            stmt.executeUpdate(sql);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
