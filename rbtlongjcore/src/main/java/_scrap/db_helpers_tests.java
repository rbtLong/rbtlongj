package _scrap;

import com.google.gson.Gson;
import helperj.db.Db;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class db_helpers_tests {
    public static void main(String[] args) throws FileNotFoundException, SQLException, ClassNotFoundException {
        ArrayList<Map<String, Object>> logs = Db.Logs().rows("select * from log");

        Gson g = new Gson();
        for(Map<String, Object> l : logs) {
            System.out.println(g.toJson(l));
        }
    }
}
