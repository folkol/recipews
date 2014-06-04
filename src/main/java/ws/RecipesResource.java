package ws;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import model.Recipe;
import ejb.RecipeService;


@Path("/recipes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RecipesResource {

    @Inject RecipeService recipeService;
    @Context UriInfo uriInfo;

    @GET
    public List<Recipe> list() {
        return recipeService.getAll();
    }

    @GET
    @Path("{id}")
    public Recipe get(@PathParam("id") String id) {
        return recipeService.get(id);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(Recipe recipe) throws URISyntaxException {
        int id = recipeService.add(recipe);
        URI created = uriInfo.getBaseUriBuilder()
                             .path( RecipesResource.class )
                             .path( RecipesResource.class, "get" )
                             .build( id );
        return Response.created(created).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") String id, Recipe recipe) {
        recipe.setId(id);
        recipeService.update(recipe);
        return Response.ok().build();
    }
}