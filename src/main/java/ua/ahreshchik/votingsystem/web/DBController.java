package ua.ahreshchik.votingsystem.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DBController {

    static private DataSource dataSource;

    private static ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();

    @Autowired
    public DBController(DataSource dataSource) {
        DBController.dataSource = dataSource;
    }

    static void populateDB() {
        rdp.addScript(new ClassPathResource("db/populateDB.sql"));
        try {
            Connection connection = dataSource.getConnection();
            rdp.populate(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
