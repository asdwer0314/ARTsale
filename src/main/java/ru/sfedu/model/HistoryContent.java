package ru.sfedu.model;


import java.util.Date;
import java.util.Objects;

/**
 * The type History content
 */
public class HistoryContent {
    private String className;
    private Date createdDate;
    private String actor;
    private String methodName;
    private Object object;
    private String status;

    /**
     * Instantiates a new History content
     */
    public HistoryContent() {
    }

    /**
     * Instantiates a new History content
     *
     * @param className   the class name
     * @param createdDate the created date
     * @param actor       the actor
     */
    public HistoryContent(String className, Date createdDate, String actor) {
        this.className = className;
        this.createdDate = createdDate;
        this.actor = actor;
    }

    /**
     * Instantiates a new History content
     *
     * @param className   the class name
     * @param createdDate the created date
     * @param actor       the actor
     * @param methodName  the method name
     * @param object      the object
     * @param status      the status
     */
    public HistoryContent(String className, Date createdDate, String actor, String methodName, Object object, String status) {
        this.className = className;
        this.createdDate = createdDate;
        this.actor = actor;
        this.methodName = methodName;
        this.object = object;
        this.status = status;
    }

    /**
     * Get class name
     * @return the class name
     */
    public String getClassName() {
        return className;
    }

    /**
     * Set class name
     * @param className the class name
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Get created date
     * @return the created date
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Set created date
     * @param createdDate the created date
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Get actor
     * @return the actor
     */
    public String getActor() {
        return actor;
    }

    /**
     * Set actor
     * @param actor the actor
     */
    public void setActor(String actor) {
        this.actor = actor;
    }

    /**
     * Get method name
     * @return the method name
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * Set method name
     * @param methodName the method name
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * Get object
     * @return the object
     */
    public Object getObject() {
        return object;
    }

    /**
     * Set object
     * @param object the object
     */
    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * Get status
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set status
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryContent that = (HistoryContent) o;
        return Objects.equals(className, that.className)
                && Objects.equals(createdDate, that.createdDate)
                && Objects.equals(actor, that.actor)
                && Objects.equals(methodName, that.methodName)
                && Objects.equals(object, that.object)
                && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(className,
                createdDate, actor, methodName, object, status);
    }

    @Override
    public String toString() {
        return "HistoryContent{" +
                "className='" + className + '\'' +
                ", createdDate=" + createdDate +
                ", actor='" + actor + '\'' +
                ", methodName='" + methodName + '\'' +
                ", object=" + object +
                ", status=" + status +
                '}';
    }
}
