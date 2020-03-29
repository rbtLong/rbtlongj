package _scrap;

import helperj.SrvCfg;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class db_tests {

    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Map<String, Object> logs = SrvCfg.dblogs();

        String host = (String) logs.get("host");
        String username = (String) logs.get("user");
        String password = (String) logs.get("password");
        String database = (String) logs.get("database");
        String url = "jdbc:mysql://" + host
                + "/" + database
                + "?user=" + username
                + "&password=" + password;
        Connection conn = DriverManager.getConnection(url);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from log");
        ResultSetMetaData info = rs.getMetaData();
        info.getColumnCount();

        ArrayList<Map<String, Object>> rows = new ArrayList<>();
        ArrayList<String> cols = new ArrayList<>();

        // get the columns, populate cols
        for(int i=0; i<info.getColumnCount(); ++i) {
            cols.add(info.getColumnName(i+1));
        }

        // for each row that exists, append it to rows
        while(rs.next()) {
            Map<String, Object> _row = new HashMap<>();
            for (String _col : cols) {
                _row.put(_col, rs.getObject(_col));
            }
            rows.add(_row);
        }
        conn.close();

        String json = new Gson().toJson(rows);
        System.out.println(json);
    }

}
