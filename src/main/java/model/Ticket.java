package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

/**
 * Объект тикета (POJO)
 */
public class Ticket {
    private Integer id;
    private String due_date;
    @JsonIgnore
    private String assigned_to;
    private String title;
    private String created;
    private String modified;
    private String submitter_email;
    private Integer status;
    private Boolean on_hold;
    private String description;
    private String resolution;
    private Integer priority;
    private String last_escalation;
    private String secret_key;
    private Integer queue;
    @JsonIgnore
    private Integer kbitem;
    @JsonIgnore
    private Integer merged_to;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
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

    public String getSubmitter_email() {
        return submitter_email;
    }

    public void setSubmitter_email(String submitter_email) {
        this.submitter_email = submitter_email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getOn_hold() {
        return on_hold;
    }

    public void setOn_hold(Boolean on_hold) {
        this.on_hold = on_hold;
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

    public String getLast_escalation() {
        return last_escalation;
    }

    public void setLast_escalation(String last_escalation) {
        this.last_escalation = last_escalation;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    public Integer getKbitem() {
        return kbitem;
    }

    public void setKbitem(Integer kbitem) {
        this.kbitem = kbitem;
    }

    public Integer getMerged_to() {
        return merged_to;
    }

    public void setMerged_to(Integer merged_to) {
        this.merged_to = merged_to;
    }

    public Ticket(Integer id, String due_date, String assigned_to, String title, String created, String modified, String submitter_email, Integer status, Boolean on_hold, String description, String resolution, Integer priority, String last_escalation, String secret_key, Integer queue, Integer kbitem, Integer merged_to) {
        this.id = id;
        this.due_date = due_date;
        this.assigned_to = assigned_to;
        this.title = title;
        this.created = created;
        this.modified = modified;
        this.submitter_email = submitter_email;
        this.status = status;
        this.on_hold = on_hold;
        this.description = description;
        this.resolution = resolution;
        this.priority = priority;
        this.last_escalation = last_escalation;
        this.secret_key = secret_key;
        this.queue = queue;
        this.kbitem = kbitem;
        this.merged_to = merged_to;
    }

    public Ticket(){
        this.title="Название_Тикета";
        this.status=Status.OPEN.getCode();
        this.priority=2;
        this.queue=1;
        this.created="2023-05-03T11:20:55.218005";
        this.modified="2023-05-03T11:20:55.218005";
    }

    public Ticket(String title, Integer status, Integer priority, Integer queue) {
        this.title = title;
        this.status=status;
        this.priority=priority;
        this.queue = queue;
        this.created="2023-05-03T11:20:55.218005";
        this.modified="2023-05-03T11:20:55.218005";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(due_date, ticket.due_date) &&
                Objects.equals(title, ticket.title) &&
                Objects.equals(created, ticket.created) &&
                Objects.equals(modified, ticket.modified) &&
                Objects.equals(submitter_email, ticket.submitter_email) &&
                Objects.equals(status, ticket.status) &&
                Objects.equals(on_hold, ticket.on_hold) &&
                Objects.equals(description, ticket.description) &&
                Objects.equals(resolution, ticket.resolution) &&
                Objects.equals(priority, ticket.priority) &&
                Objects.equals(last_escalation, ticket.last_escalation) &&
                Objects.equals(secret_key, ticket.secret_key) &&
                Objects.equals(queue, ticket.queue) &&
                Objects.equals(kbitem, ticket.kbitem) &&
                Objects.equals(assigned_to, ticket.assigned_to) &&
                Objects.equals(merged_to, ticket.merged_to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, due_date, assigned_to, title, created, modified, submitter_email, status, on_hold, description, resolution, priority, last_escalation, secret_key, queue, kbitem, merged_to);
    }
}
