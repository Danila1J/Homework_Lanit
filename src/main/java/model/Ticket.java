package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

/**
 * Объект тикета (POJO)
 */
public class Ticket {
    private Integer id;
    private String dueDate;
    @JsonIgnore
    private String assignedTo;
    private String title;
    private String created;
    private String modified;
    private String submitterEmail;
    private Integer status;
    private Boolean onHold;
    private String description;
    private String resolution;
    private Integer priority;
    private String lastEscalation;
    private String secretKey;
    private Integer queue;
    @JsonIgnore
    private Integer kbItem;
    @JsonIgnore
    private Integer mergedTo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getSubmitterEmail() {
        return submitterEmail;
    }

    public void setSubmitterEmail(String submitterEmail) {
        this.submitterEmail = submitterEmail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getOnHold() {
        return onHold;
    }

    public void setOnHold(Boolean onHold) {
        this.onHold = onHold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getLastEscalation() {
        return lastEscalation;
    }

    public void setLastEscalation(String lastEscalation) {
        this.lastEscalation = lastEscalation;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    public Integer getKbItem() {
        return kbItem;
    }

    public void setKbItem(Integer kbItem) {
        this.kbItem = kbItem;
    }

    public Integer getMergedTo() {
        return mergedTo;
    }

    public void setMergedTo(Integer mergedTo) {
        this.mergedTo = mergedTo;
    }

    public Ticket(Integer id, String dueDate, String assignedTo, String title, String created, String modified, String submitterEmail, Integer status, Boolean onHold, String description, String resolution, Integer priority, String lastEscalation, String secretKey, Integer queue, Integer kbItem, Integer mergedTo) {
        this.id = id;
        this.dueDate = dueDate;
        this.assignedTo = assignedTo;
        this.title = title;
        this.created = created;
        this.modified = modified;
        this.submitterEmail = submitterEmail;
        this.status = status;
        this.onHold = onHold;
        this.description = description;
        this.resolution = resolution;
        this.priority = priority;
        this.lastEscalation = lastEscalation;
        this.secretKey = secretKey;
        this.queue = queue;
        this.kbItem = kbItem;
        this.mergedTo = mergedTo;
    }

    public Ticket(){
        this.title="Название_Тикета";
        this.status=Status.OPEN.getCode();
        this.priority=2;
        this.queue=1;
    }

    public Ticket(String title, Integer status, Integer priority, Integer queue) {
        this.title = title;
        this.status=status;
        this.priority=priority;
        this.queue = queue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(dueDate, ticket.dueDate) &&
                Objects.equals(title, ticket.title) &&
                Objects.equals(created, ticket.created) &&
                Objects.equals(modified, ticket.modified) &&
                Objects.equals(submitterEmail, ticket.submitterEmail) &&
                Objects.equals(status, ticket.status) &&
                Objects.equals(onHold, ticket.onHold) &&
                Objects.equals(description, ticket.description) &&
                Objects.equals(resolution, ticket.resolution) &&
                Objects.equals(priority, ticket.priority) &&
                Objects.equals(lastEscalation, ticket.lastEscalation) &&
                Objects.equals(secretKey, ticket.secretKey) &&
                Objects.equals(queue, ticket.queue) &&
                Objects.equals(kbItem, ticket.kbItem) &&
                Objects.equals(assignedTo, ticket.assignedTo) &&
                Objects.equals(mergedTo, ticket.mergedTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dueDate, assignedTo, title, created, modified, submitterEmail, status, onHold, description, resolution, priority, lastEscalation, secretKey, queue, kbItem, mergedTo);
    }
}
