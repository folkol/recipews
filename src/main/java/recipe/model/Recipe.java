package recipe.model;

import static java.lang.String.format;


public class Recipe {

    public String title;
    public String ingredients;
    public String[] image;

    @Override
    public String toString() {
        return format("%s\n%s\n%s", title, ingredients, image != null ? image : "lol");
    }


}
