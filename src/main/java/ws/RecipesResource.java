package ws;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
    public Response get(@PathParam("id") int id) {
        Recipe recipe = recipeService.get(id);
        return recipe == null ? Response.status(404).build() :
                                Response.ok(recipe).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Recipe recipe) {
        int id = recipeService.add(recipe);
        URI created = uriInfo.getBaseUriBuilder()
                             .path( RecipesResource.class )
                             .path( RecipesResource.class, "get" )
                             .build( id );
        return Response.created(created).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Recipe recipe) {
        recipe.setId(id);
        recipeService.update(recipe);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") int id) {
        recipeService.remove(id);
        return Response.ok().build();
    }
}