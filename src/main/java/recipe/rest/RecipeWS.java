package recipe.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import recipe.ejb.RecipeService;
import recipe.model.Recipe;


@Path("/recipe")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RecipeWS {

    @Inject RecipeService recipeService;

    @GET
    public String list() {
        return recipeService.list();
    }

    @GET
    @Path("{id}")
    public String list(@PathParam("id") String id) {
        return id;
    }

    @POST
    public Recipe add(Recipe recipe) {
        return recipe;
    }

    @PUT
    @Path("{id}")
    public String add(@PathParam("id") String id, Recipe recipe) {
        return "Updated id: " + id + " " + recipe;
    }
}