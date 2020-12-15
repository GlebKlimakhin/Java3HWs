package client;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HistoryFiles {
    public static PrintWriter out;


    public static String getFileByLogin(String login) {
        return "clientsHistory/" + login + ".txt";
    }
    public static void openWriting(String login) throws FileNotFoundException {
        out = new PrintWriter(new FileOutputStream(getFileByLogin(login)), true);
    }
    public static void writeLine(String msg){
        out.println(msg);
    }
    public static void stop(){
        if(out!=null){
            out.close();
        }
    }
    public static String addLastLines(String login) throws IOException {
        String pathToFile = getFileByLogin(login);
        StringBuilder stringBuilder = new StringBuilder();
        if(Files.exists(Paths.get(pathToFile))){
            return " ";
        }
        List<String> lines = Files.readAllLines(Paths.get(pathToFile));
        int firstLinePos;
        if(lines.size()>100){
            firstLinePos = lines.size() - 100;
        }
        else{
            firstLinePos = 0;
        }
        for (int i = firstLinePos; i < lines.size(); i++) {
            stringBuilder.append(lines.get(i)).append("\n");
        }
        return stringBuilder.toString();
    }

}
