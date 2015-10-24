package br.com.gabrielrtakeda.strategy;

import br.com.gabrielrtakeda.config.Configuration;
import br.com.gabrielrtakeda.dao.AbstractDAOFactory;

public class DAOStrategy {

    public static AbstractDAOFactory get() {
        try {
            return AbstractDAOFactory.getDAOFactory(
                Configuration.getSelectedDatabaseDriver()
            );
        }
        catch(Exception ex) {
            System.out.println("ex: " + ex);
        }
        return null;
    }
}
