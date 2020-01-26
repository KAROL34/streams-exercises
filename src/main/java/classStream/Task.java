package classStream;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    Integer id;
    String desprition;
    LocalDateTime createOn;
    LocalDateTime deadline;
    Integer assignetToEmployeeId;

    public Task(Integer id, String desprition, LocalDateTime createOn, Integer assignetToEmployeeId) {
        this.id = id;
        this.desprition = desprition;
        this.createOn = createOn;
        this.deadline = createOn.plusDays(2);
        this.assignetToEmployeeId = assignetToEmployeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesprition() {
        return desprition;
    }

    public void setDesprition(String desprition) {
        this.desprition = desprition;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Integer getAssignetToEmployeeId() {
        return assignetToEmployeeId;
    }

    public void setAssignetToEmployeeId(Integer assignetToEmployeeId) {
        this.assignetToEmployeeId = assignetToEmployeeId;
    }
}
