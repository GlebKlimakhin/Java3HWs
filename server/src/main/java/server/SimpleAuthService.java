package server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {

    private static Connection connection;
    private static Statement stmt;

    static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:users.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private class UserData {
        String login;
        String password;
        String nickname;


        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    private List<UserData> users;


    public SimpleAuthService() {

            users = new ArrayList<>();
            users.add(new UserData("qwe", "qwe", "qwe"));
            users.add(new UserData("asd", "asd", "asd"));
            users.add(new UserData("zxc", "zxc", "zxc"));
            for (int i = 1; i <= 10; i++) {
                users.add(new UserData("login" + i, "pass" + i, "nick" + i));
            }
        }

        @Override
        public String getNicknameByLoginAndPassword (String login, String password){
            for (UserData user : users) {
                if (user.login.equals(login) && user.password.equals(password)) {
                    return user.nickname;
                }
            }
            return null;
        }

        @Override
        public boolean registration (String login, String password, String nickname){
            for (UserData user : users) {
                if (user.login.equals(login) || user.nickname.equals(nickname)) {
                    return false;
                }
            }

            users.add(new UserData(login, password, nickname));
            connect();
            String sql = String.format("INSERT INTO users (login, password, nickname) VALUES ('%s', '%s', '%s')", login, password, nickname);
            try{
            stmt.executeUpdate(sql);}
            catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }
