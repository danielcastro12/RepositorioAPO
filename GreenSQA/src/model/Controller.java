package model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private Project[] projects;

	public Controller() {

		projects = new Project[10];
	
	}

    /**
     * Description: This method uses the parameters received to calculate the dates for the project and each stage, it creates the project with the six stages and saves it in an array
     * @param name String
     * @param clientName String
     * @param type int
     * @param startDay int
     * @param startMonth int
     * @param startYear int
     * @param budget double
     * @param greenManagerName String
     * @param greenManagerNumber String
     * @param clientManagerName String
     * @param clientManagerNumber String
     * @param stage1Len int
     * @param stage2Len int
     * @param stage3Len int
     * @param stage4Len int
     * @param stage5Len int
     * @param stage6Len int
     * @return boolean
     */
	
	public boolean registerProject(String name, String clientName, int type, int startDay, int startMonth, int startYear, double budget, String greenManagerName, String greenManagerNumber, String clientManagerName, String clientManagerNumber, int stage1Len, int stage2Len, int stage3Len, int stage4Len, int stage5Len, int stage6Len) {

		Calendar initialDate = new GregorianCalendar(startYear, startMonth-1, startDay);

        Calendar dateStage1 = initialDate;

        dateStage1.add(Calendar.MONTH, stage1Len);
        Calendar dateStage2 = dateStage1;

        dateStage2.add(Calendar.MONTH, stage2Len);
        Calendar dateStage3 = dateStage2;

        dateStage3.add(Calendar.MONTH, stage3Len);
        Calendar dateStage4 = dateStage3;

        dateStage4.add(Calendar.MONTH, stage4Len);
        Calendar dateStage5 = dateStage4;

        dateStage5.add(Calendar.MONTH, stage5Len);
        Calendar dateStage6 = dateStage5;

		Calendar finalDate = dateStage6;

        ProjectType projectType = ProjectType.DEVELOP;

        if(type == 1){
            projectType = ProjectType.DEVELOP;
        }

        else if (type == 2){
            projectType = ProjectType.MAINTENANCE;
        }

		else if (type == 3){
			projectType = ProjectType.DEPLOYMENT;
		}

        Project newProject = new Project(name, clientName, initialDate, finalDate, budget, projectType, greenManagerName, greenManagerNumber, clientManagerName, clientManagerNumber);

        Stage stage1 = new Stage(newProject.getName(), StageName.START, initialDate, dateStage1, initialDate, null, StageStatus.ACTIVE);
        Stage stage2 = new Stage(newProject.getName(), StageName.ANALYSIS, dateStage1, dateStage2, null, null, StageStatus.INACTIVE);
        Stage stage3 = new Stage(newProject.getName(), StageName.DESIGN, dateStage2, dateStage3, null, null, StageStatus.INACTIVE);
        Stage stage4 = new Stage(newProject.getName(), StageName.EXECUTION, dateStage3, dateStage4, null, null, StageStatus.INACTIVE);
        Stage stage5 = new Stage(newProject.getName(), StageName.CLOSURE_AND_FOLLOW_UP, dateStage4, dateStage5, null, null, StageStatus.INACTIVE);
        Stage stage6 = new Stage(newProject.getName(), StageName.PROYECT_CONTROL, dateStage5, dateStage6, null, null, StageStatus.INACTIVE);

        newProject.setStage(0, stage1);
        newProject.setStage(1, stage2);
        newProject.setStage(2, stage3);
        newProject.setStage(3, stage4);
        newProject.setStage(4, stage5);
        newProject.setStage(5, stage6);

        for (int i = 0; i < projects.length; i++){
            if (projects[i] == null){
                projects[i] = newProject;
                return true;
            }
        }

        return false;
	}

    /**
     * Description: This method allows to get the projects registered that are found in the array
     * @return msg String
     */

    public String getRegisteredProjects(){

        String msg = "";

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                msg += projects[i].getName() + ":" + projects[i].getProjectType() + "\n";
            }
        }

        return msg;
    }

    /**
     * Description: This method uses the parameters to calculate the unit type, the stage name and it creates a new knowledge unit in an available space inside the stage selected
     * @param projectName String
     * @param stage int
     * @param id String
     * @param employeeName String
     * @param employeesJob String
     * @param description String
     * @param type int
     * @param learnedLessons String
     * @return boolean
     */

    public boolean registerKnowledgeUnit(String projectName, int stage, String id, String employeeName, String employeesJob, String description, int type, String learnedLessons) {

        UnitType typeKU = UnitType.TECHNICAL;
        StageName stageKU = StageName.START;

        if(type == 1){
            typeKU = UnitType.TECHNICAL;
        }

        if(type == 2){
            typeKU = UnitType.MANAGEMENT;
        }

        if(type == 3){
            typeKU = UnitType.DOMAIN;
        }

        if(type == 4){
            typeKU = UnitType.EXPERIENCES;
        }

        if(stage == 1){
            stageKU = StageName.START;
        }

        if(stage == 2){
            stageKU = StageName.ANALYSIS;
        }

        if(stage == 3){
            stageKU = StageName.DESIGN;
        }

        if(stage == 4){
            stageKU = StageName.EXECUTION;
        }

        if(stage == 5){
            stageKU = StageName.CLOSURE_AND_FOLLOW_UP;
        }

        if(stage == 6){
            stageKU = StageName.PROYECT_CONTROL;
        }

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                if(projects[i].getName().equals(projectName)){
                    for(int x = 0; x < projects[i].getStages().length; x++){
                        if(projects[i].getStages()[x] != null){
                            if(projects[i].getStages()[x].getStageName().equals(stageKU)){
                                for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                                    if(projects[i].getStages()[x].getUnits()[y] == null){
                                        projects[i].getStages()[x].getUnits()[y] = new KnowledgeUnit(id, employeeName, employeesJob, description, typeKU, learnedLessons);
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Description: This method allows to get the knowledge units registered in the system
     * @return msg String
     */

    public String getRegisteredUnits(){
        String msg = "";

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                msg += projects[i].getStages()[x].getUnits()[y].getId() + ": " + projects[i].getStages()[x].getUnits()[y].getDescription() + "\n";
                            }
                        }
                    }
                }
            }
        }

        return msg;
    }

    /**
     * Description: This method allows to get the active project stages in the system
     * @return msg String
     */

    public String getProjectStages(){
        String msg = "";

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x].getStageStatus().equals(StageStatus.ACTIVE)){
                        msg += "Project: " + projects[i].getStages()[x].getProjectName() + "\nCurrent stage: " + projects[i].getStages()[x].getStageName() + "\nStatus: " + projects[i].getStages()[x].getStageStatus() + "\n";
                    }
                }
            }
        }
        return msg;
    }

    /**
     * Description: This method compares a given id with different positions in an array, and returns it if its found.
     * @param id String
     * @return msg String
     */

    public String compareId(String id){

        String msg = "";

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                if(projects[i].getStages()[x].getUnits()[y].getId().equals(id)){
                                    msg = projects[i].getStages()[x].getUnits()[y].getId();
                                }
                            }
                        }
                    }
                }
            }
        }

        return msg;
    }

    /**
     * Description: This method calculates the approval date with the given parameter and it changes the approval status of a knowledge unit found in the array and register the approval date
     * @param id String
     * @param newStatus int
     * @param currentDay int
     * @param currentMonth int
     * @param currentYear int
     */

    public void approveKnowledgeUnit(String id, int newStatus, int currentDay, int currentMonth, int currentYear) {

        Calendar approvalDate = new GregorianCalendar(currentYear, currentMonth-1, currentDay);

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                if(projects[i].getStages()[x].getUnits()[y].getId().equals(id)){
                                    if(newStatus == 1){
                                        projects[i].getStages()[x].getUnits()[y].setStatus(Status.APPROVED);
                                        projects[i].getStages()[x].getUnits()[y].setApprovalDate(approvalDate);
                                    }
                                    else if(newStatus == 2){
                                        projects[i].getStages()[x].getUnits()[y].setStatus(Status.NOT_APPROVED);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Description: This method allows to publish an approved knowledge unit with an ID that matches the parameter
     * @param id String
     */

    public void publishKnowledgeUnit(String id) {

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                if(projects[i].getStages()[x].getUnits()[y].getId().equals(id)){
                                    if(projects[i].getStages()[x].getUnits()[y].getStatus().equals(Status.APPROVED)){
                                        projects[i].getStages()[x].getUnits()[y].setPublishingStatus(PublishingStatus.PUBLISHED);
                                        projects[i].getStages()[x].getUnits()[y].setUrl("www.greensqa.co/" + projects[i].getName() + "/" + projects[i].getStages()[x].getUnits()[y].getId());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Description: This method allows to get the URL of a knowledge unit with its ID
     * @param id String
     * @return msg String
     */

    public String getUrl(String id){

        String msg = "";

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                if(projects[i].getStages()[x].getUnits()[y].getId().equals(id)){
                                    if(projects[i].getStages()[x].getUnits()[y].getStatus().equals(Status.APPROVED)){
                                        if(projects[i].getStages()[x].getUnits()[y].getPublishingStatus().equals(PublishingStatus.PUBLISHED)){
                                            msg = projects[i].getStages()[x].getUnits()[y].getUrl();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }

    /**
     * Description: This method compares the parameter with the name of a project on a stage, and if its found, it returns as a string
     * @param projectName String
     * @return msg String
     */

    public String compareName(String projectName){

        String msg = "";

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        if(projects[i].getStages()[x].getStageStatus().equals(StageStatus.ACTIVE)){
                            if(projects[i].getStages()[x].getProjectName().equals(projectName)){
                                msg = projects[i].getStages()[x].getProjectName();
                            }
                        }
                    }
                }
            }
        }

        return msg;
    }

    /**
     * Description: This method uses the parameters received for calculating a date and ending a project stage, changing its status and providing the real end date. If theres a stage next, its activated an provided with a real start date
     * @param projectName String
     * @param currentDay int
     * @param currentMonth int
     * @param currentYear int
     */

    public void endProjectStage(String projectName, int currentDay, int currentMonth, int currentYear){

        Calendar currentDate = new GregorianCalendar(currentYear, currentMonth-1, currentDay);

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                if(projects[i].getName().equals(projectName)){
                    for(int x = 0; x < projects[i].getStages().length; x++){
                        if(projects[i].getStages()[x] != null){
                            if(projects[i].getStages()[x].getStageStatus().equals(StageStatus.ACTIVE)){
                                if (x == 5) {
                                    projects[i].getStages()[x].setStageStatus(StageStatus.INACTIVE);
                                    projects[i].getStages()[x].setRealEndDate(currentDate);
                                } else {
                                    projects[i].getStages()[x].setStageStatus(StageStatus.INACTIVE);
                                    projects[i].getStages()[x].setRealEndDate(currentDate);
                                    projects[i].getStages()[x+1].setStageStatus(StageStatus.ACTIVE);
                                    projects[i].getStages()[x+1].setRealStartDate(currentDate);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Description: This method allows to get the found approved knowledge units inside the projects and stages
     * @return msg String
     */

    public String getApprovedKnowledgeUnits(){

        String msg = "";

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                if(projects[i].getStages()[x].getUnits()[y].getStatus().equals(Status.APPROVED)){
                                    msg += projects[i].getStages()[x].getUnits()[y].getId() + ": " + projects[i].getStages()[x].getUnits()[y].getDescription() + "(" + projects[i].getStages()[x].getUnits()[y].getStatus()+ ")\n";
                                }
                            }
                        }
                    }
                }
            }
        }

        return msg;
    }

    /**
     * Description: This method allows to get the name of the projects found in the array
     * @return msg String
     */

    public String getProjectNames(){
        String msg = "";
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                msg += projects[i].getName() + "\n";
            }
        }
        return msg;
    }

    /**
     * Description: This method allows to get the number of technical units
     * @return number int
     */

    public int getTechnicalUnits(){
        int number = 0;
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                if(projects[i].getStages()[x].getUnits()[y].getUnitType().equals(UnitType.TECHNICAL)){
                                    number += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return number;
    }

    /**
     * Description: This method allows to get the number of management units
     * @return number int
     */

    public int getManagementUnits(){
        int number = 0;
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                if(projects[i].getStages()[x].getUnits()[y].getUnitType().equals(UnitType.MANAGEMENT)){
                                    number += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return number;
    }

    /**
     * Description: This method allows to get the number of domain units
     * @return number int
     */

    public int getDomainUnits(){
        int number = 0;
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                if(projects[i].getStages()[x].getUnits()[y].getUnitType().equals(UnitType.DOMAIN)){
                                    number += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return number;
    }

    /**
     * Description: This method allows to get the number of experiences units
     * @return number int
     */

    public int getExperiencesUnits(){
        int number = 0;
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                if(projects[i].getStages()[x].getUnits()[y].getUnitType().equals(UnitType.EXPERIENCES)){
                                    number += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return number;
    }

    /**
     * Description: This method allows to get the learned lessons of a specific stage for all projects
     * @param unitStage int 
     * @return msg String
     */

    public String getLearnedLessonsByStageAllProjects(int unitStage){

        StageName stageKU = StageName.START;

        if(unitStage == 1){
            stageKU = StageName.START;
        }

        if(unitStage == 2){
            stageKU = StageName.ANALYSIS;
        }

        if(unitStage == 3){
            stageKU = StageName.DESIGN;
        }

        if(unitStage == 4){
            stageKU = StageName.EXECUTION;
        }

        if(unitStage == 5){
            stageKU = StageName.CLOSURE_AND_FOLLOW_UP;
        }

        if(unitStage == 6){
            stageKU = StageName.PROYECT_CONTROL;
        }

        String msg = "";

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        if(projects[i].getStages()[x].getStageName().equals(stageKU)){
                            for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                                if(projects[i].getStages()[x].getUnits()[y] != null){
                                    msg += projects[i].getStages()[x].getProjectName() + " (" + projects[i].getStages()[x].getStageName() + "): " + projects[i].getStages()[x].getUnits()[y].getDescription() + "\n";
                                }
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }

    /**
     * Description: This method allows to get the name of the project with most knowledge units registered
     * @return msg String
     */

    public String getProjectWithMostUnits(){

        String msg = "";
        int max = 0; 

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                if(projects[i].getNumberKnowledgeUnits() > max){
                    max = projects[i].getNumberKnowledgeUnits();
                    msg = projects[i].getName() + " (" + projects[i].getNumberKnowledgeUnits() + ")";
                }
            }
        }
        return msg;
    }

    /**
     * Description: This method allows to get the knowledge units that an employee has registered on a specific project
     * @param name String
     * @param project String
     * @return msg String
     */

    public String getUnitInProjectByEmployee(String name, String project){

        String msg = "";

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                if(projects[i].getName().equals(project)){
                    for(int x = 0; x < projects[i].getStages().length; x++){
                        if(projects[i].getStages()[x] != null){
                            for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                                if(projects[i].getStages()[x].getUnits()[y] != null){
                                    if(projects[i].getStages()[x].getUnits()[y].getEmployeeName().equals(name) ){
                                        msg += projects[i].getStages()[x].getUnits()[y].toString();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return msg;
    }

    /**
     * Description: This method allows to get the information of a project based on a keyword provided by the user
     * @param keyword String
     * @return msg String
     */

    public String getLearnedLessonsByHashtags(String keyword){

        String msg = "";

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                if(projects[i].getStages()[x].getUnits()[y].getStatus().equals(Status.APPROVED)){
                                    if(projects[i].getStages()[x].getUnits()[y].getDescription().contains(keyword) || projects[i].getStages()[x].getUnits()[y].getLearnedLessons().contains(keyword)){
                                        msg += projects[i].getStages()[x].getUnits()[y].toString();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }
}