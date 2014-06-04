package ws;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/ws")
public class WebService extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<>(asList(RecipesResource.class));
    }
}