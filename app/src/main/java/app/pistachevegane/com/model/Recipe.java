package app.pistachevegane.com.model;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable{
    private Long id;
    private String title;
    private String descriptionRecipe;
    private List<Ingredient> ingredients;
    private List<CookingStep> cookingSteps;
    private String type;
    private String labelTime;
    private Integer timeToCook;
    private String complexity;
    private Integer identifierDrawablePicture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabelTime() {
        return labelTime;
    }

    public void setLabelTime(String labelTime) {
        this.labelTime = labelTime;
    }

    public Integer getTimeToCook() {
        return timeToCook;
    }

    public void setTimeToCook(Integer timeToCook) {
        this.timeToCook = timeToCook;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public Integer getIdentifierDrawablePicture() {
        return identifierDrawablePicture;
    }

    public void setIdentifierDrawablePicture(Integer identifierDrawablePicture) {
        this.identifierDrawablePicture = identifierDrawablePicture;
    }

    public String getDescriptionRecipe() {
        return descriptionRecipe;
    }

    public void setDescriptionRecipe(String descriptionRecipe) {
        this.descriptionRecipe = descriptionRecipe;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<CookingStep> getCookingSteps() {
        return cookingSteps;
    }

    public void setCookingSteps(List<CookingStep> cookingSteps) {
        this.cookingSteps = cookingSteps;
    }
}
