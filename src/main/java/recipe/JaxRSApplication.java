package recipe;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import recipe.rest.RecipesResource;


@ApplicationPath("/rest-api")
public class JaxRSApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<>(asList(RecipesResource.class));
    }
}