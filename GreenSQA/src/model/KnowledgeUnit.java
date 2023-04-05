package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class KnowledgeUnit {

    private String id;
    private String employeeName;
    private String employeesJob;
    private String description;
    private UnitType unitType;
    private String learnedLessons;
    private Status status;
    private Calendar approvalDate;
    private PublishingStatus publishingStatus;
    private String url;

    private DateFormat formatter;

    public KnowledgeUnit(String id, String employeeName, String employeesJob, String description, UnitType unitType, String learnedLessons) {

        this.formatter = new SimpleDateFormat("dd/MM/yyyy");

        this.id = id;
        this.employeeName = employeeName;
        this.employeesJob = employeesJob;
        this.description = description;
        this.unitType = unitType;
        this.learnedLessons = learnedLessons;
        this.status = Status.POR_DEFINIR;
        this.approvalDate = null;
        this.publishingStatus = PublishingStatus.NOT_PUBLISHED;
        this.url = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public String getLearnedLessons() {
        return learnedLessons;
    }

    public void setLearnedLessons(String learnedLessons) {
        this.learnedLessons = learnedLessons;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public Calendar getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Calendar approvalDate) {
        this.approvalDate = approvalDate;
    }

    public PublishingStatus getPublishingStatus(){
        return publishingStatus;
    }

    public void setPublishingStatus(PublishingStatus publishingStatus){
        this.publishingStatus = publishingStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString(){
        String msg ="";
        msg = "ID: " + id + "\nDescription: " + description + "\nUnit ype: " + unitType + "\nLearned lessons: " + learnedLessons + "\nStatus: " + status + "\nPublishing status: " + publishingStatus + "\nURL: " + url + "\n";
        return msg;
    }
}