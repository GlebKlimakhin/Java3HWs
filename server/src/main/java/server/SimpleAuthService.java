package server;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {

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
            String filename = login + ".txt";
            File file = new File("clientsHistory", filename );
            try {
                System.out.println(file.createNewFile());}
            catch (IOException e){
                e.printStackTrace();
                System.out.println("Не удалось создать файл для сохранения истории!");
            }
            AddToDB.connect();
            AddToDB.insert(login, password, nickname);
            return true;
        }
    }