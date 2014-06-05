package ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Recipe;


@Stateful
public class RecipeService {

    @PersistenceContext(unitName = "recipes")
    EntityManager em;

    public List<Recipe> getAll() {
        TypedQuery<Recipe> q = em.createQuery("select r from Recipe r", Recipe.class);
        return q.getResultList();
    }

    public Recipe get(int id) {
        return em.find(Recipe.class, id);
    }

    public int add(Recipe recipe) {
        em.persist(recipe);
        return recipe.getId();
    }

    public void update(Recipe recipe) {
    }
}