package ua.ahreshchik.votingsystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class DBService {

    static private DataSource dataSource;

    private static ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();

    @Autowired
    public DBService(DataSource dataSource) {
        DBService.dataSource = dataSource;
    }

    public static void populateDB() {
        rdp.setSqlScriptEncoding("UTF-8");
        rdp.addScript(new ClassPathResource("db/initDB.sql"));
        rdp.addScript(new ClassPathResource("db/populateDB.sql"));
        try {
            Connection connection = dataSource.getConnection();
            rdp.populate(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
