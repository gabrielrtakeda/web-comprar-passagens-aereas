package br.com.gabrielrtakeda.config;

import br.com.gabrielrtakeda.config.DatabaseDriverType;

public class Configuration {

    private static final DatabaseDriverType selectedDriver = DatabaseDriverType.MYSQL;

    public static DatabaseDriverType getSelectedDatabaseDriver() {
        return Configuration.selectedDriver;
    }
}
