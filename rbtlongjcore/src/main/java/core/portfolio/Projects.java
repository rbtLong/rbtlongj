package core.portfolio;

import helperj.db.Db;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class Projects {

    public static final String cmdAll =  "select * from projects";
    public static ArrayList<Map<String, Object>> all()
            throws FileNotFoundException, UnknownHostException, SQLException, ClassNotFoundException {
        return Db.rbtLong().rows(cmdAll);
    }

    public static final String cmdById = "select * from projects where id = ?";
    public static Map<String,Object> byId(int id)
            throws FileNotFoundException, UnknownHostException, SQLException, ClassNotFoundException {
        return Db.rbtLong().row(cmdById, id);
    }

}
