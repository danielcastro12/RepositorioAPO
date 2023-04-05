package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Stage {

    private String projectName;
    private StageName stageName;
    private Calendar plannedStartDate;
    private Calendar plannedEndDate;
    private Calendar realStartDate;
    private Calendar realEndDate;
    private StageStatus stageStatus;
    private KnowledgeUnit[] units;

    private DateFormat formatter;

    public Stage(String projectName, StageName stageName, Calendar plannedStartDate, Calendar plannedEndDate, Calendar realStartDate, Calendar realEndDate, StageStatus stageStatus) {

        new SimpleDateFormat("dd/MM/yyyy");

        this.projectName = projectName;
        this.stageName = stageName;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.realStartDate = realStartDate;
        this.realEndDate = realEndDate;
        this.stageStatus = stageStatus;
        this.units = new KnowledgeUnit[50];
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public StageName getStageName() {
        return stageName;
    }

    public void setStageName(StageName stageName) {
        this.stageName = stageName;
    }

    public Calendar getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Calendar plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Calendar getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(Calendar plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public Calendar getRealStartDate() {
        return realStartDate;
    }

    public void setRealStartDate(Calendar realStartDate) {
        this.realStartDate = realStartDate;
    }

    public Calendar getRealEndDate() {
        return realEndDate;
    }

    public void setRealEndDate(Calendar realEndDate) {
        this.realEndDate = realEndDate;
    }

    public StageStatus getStageStatus() {
        return stageStatus;
    }

    public void setStageStatus(StageStatus stageStatus) {
        this.stageStatus = stageStatus;
    }

    public String getId(int knowledgeUnitNumber){
        return units[knowledgeUnitNumber].getId();
    }

    public String getDescription(int knowledgeUnitNumber){
        return units[knowledgeUnitNumber].getDescription();
    }

    public UnitType getUnitType(int knowledgeUnitNumber){
        return units[knowledgeUnitNumber].getUnitType();
    }

    public String getLearnedLessons(int knowledgeUnitNumber){
        return units[knowledgeUnitNumber].getLearnedLessons();
    }

    public Status getStatus(int knowledgeUnitNumber){
        return units[knowledgeUnitNumber].getStatus();
    }

    public PublishingStatus getPublishingStatus(int knowledgeUnitNumber){
        return units[knowledgeUnitNumber].getPublishingStatus();
    }

    public String getUrl(int knowledgeUnitNumber){
        return units[knowledgeUnitNumber].getUrl();
    }

    public void setId(int knowledgeUnitNumber, String id) {
        units[knowledgeUnitNumber].setId(id);
    }
    
    public void setDescription(int knowledgeUnitNumber, String description) {
        units[knowledgeUnitNumber].setDescription(description);
    }
    
    public void setUnitType(int knowledgeUnitNumber, UnitType unitType) {
        units[knowledgeUnitNumber].setUnitType(unitType);
    }
    
    public void setLearnedLessons(int knowledgeUnitNumber, String learnedLessons) {
        units[knowledgeUnitNumber].setLearnedLessons(learnedLessons);
    }
    
    public void setStatus(int knowledgeUnitNumber, Status status) {
        units[knowledgeUnitNumber].setStatus(status);
    }
    
    public void setPublishingStatus(int knowledgeUnitNumber, PublishingStatus publishingStatus) {
        units[knowledgeUnitNumber].setPublishingStatus(publishingStatus);
    }
    
    public void setUrl(int knowledgeUnitNumber, String url) {
        units[knowledgeUnitNumber].setUrl(url);
    }

    public void setKnowledgeUnit(int knowledgeUnitNumber, String id, String employeeName, String employeesJob, String description, UnitType unitType, String learnedLessons){
        units[knowledgeUnitNumber] = new KnowledgeUnit(id, employeeName, employeesJob, description, unitType, learnedLessons);
    }

    public KnowledgeUnit[] getUnits() {
        return this.units;
    }

    public void setUnits(KnowledgeUnit[] units) {
        this.units = units;
    }

    public String toString() {
        String msg = "";
        msg = "Project name: " + projectName + "Stage name: " + stageName + "\nPlanned start date: " + plannedStartDate + "\nPlanned end date: " + plannedEndDate
        + "\nReal start date: " + realStartDate + "\nReal end date: " + realEndDate + "\nStage status" + stageStatus + "\n";
        return msg;
    }
}