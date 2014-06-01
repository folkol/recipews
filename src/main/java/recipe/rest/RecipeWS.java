package recipe.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import recipe.ejb.RecipeService;
import recipe.model.Recipe;


@Path("/recipe")
public class RecipeWS {

    @Inject RecipeService recipeService;

    @GET
    public String list() {
        return recipeService.list();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Recipe add(Recipe recipe) {
        return recipe;
    }
}