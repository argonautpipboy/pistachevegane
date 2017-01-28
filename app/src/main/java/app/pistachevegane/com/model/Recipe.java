package app.pistachevegane.com.model;

public class Recipe {
    private Long id;
    private String title;
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
}
