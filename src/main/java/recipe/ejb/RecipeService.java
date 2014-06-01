package recipe.ejb;

import java.util.Date;


public class RecipeService {
    public String list() {
        return "pojo ok @ " + new Date().toString();
    }
}