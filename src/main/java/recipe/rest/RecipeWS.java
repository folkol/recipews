package recipe.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import recipe.ejb.RecipeService;


@Path("/recipe")
public class RecipeWS {

    @Inject RecipeService recipeService;

    @GET
    public String list() {
        return recipeService.list();
    }
}