package recipe.ejb;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

import recipe.model.Recipe;


@Stateless
public class RecipeService {
    public List<Recipe> getAll() {
        return Arrays.asList(new Recipe(), new Recipe(), new Recipe());
    }

    public Recipe get(String id) {
        return new Recipe();
    }

    public int add(Recipe recipe) {
        return 66;
    }

    public void update(Recipe recipe) {
    }
}