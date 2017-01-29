package app.pistachevegane.com.model;

public class CookingStep {
    private Long id;
    private String descriptionStep;
    private Integer timer;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionStep() {
        return descriptionStep;
    }

    public void setDescriptionStep(String descriptionStep) {
        this.descriptionStep = descriptionStep;
    }

    public Integer getTimer() {
        return timer;
    }

    public void setTimer(Integer timer) {
        this.timer = timer;
    }
}
