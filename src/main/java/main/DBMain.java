package main;

import config.DatabaseConfiguration;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.ManagedDataSource;
import io.dropwizard.flyway.FlywayBundle;
import io.dropwizard.flyway.FlywayFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.flywaydb.core.Flyway;


import java.sql.*;

public class DBMain extends Application<DatabaseConfiguration> {
    @Override
    public void run(DatabaseConfiguration databaseConfiguration, Environment environment) throws Exception {


    }

    public static void main(String[] args) throws Exception {
        new DBMain().run(args);
    }


    public void initialize(Bootstrap<DatabaseConfiguration> bootstrap) {
        bootstrap.addBundle(new FlywayBundle<DatabaseConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(DatabaseConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }
}
