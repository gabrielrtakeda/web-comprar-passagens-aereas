package br.com.gabrielrtakeda.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import org.glassfish.jersey.server.ResourceConfig;
import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

@ApplicationPath("/")
public class ComprarPassagemAereaApi extends Application {

    // public ComprarPassagemAereaApi() {
    //     packages(true, "br.com.gabrielrtakeda.api.resource");
    // }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(MOXyJsonProvider.class);
        return classes;
    }
}
