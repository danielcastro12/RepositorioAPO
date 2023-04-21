package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.ParseException;

public class Project{
	
	private String name;
	private String clientName;
	private ProjectType projectType;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;
    private String greenManagerName;
    private String greenManagerNumber;
    private String clientManagerName;
    private String clientManagerNumber;
    private Stage[] stages;

	private DateFormat formatter;

	public Project(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget, ProjectType projectType, String greenManagerName, String greenManagerNumber, String clientManagerName, String clientManagerNumber){
		
		this.formatter = new SimpleDateFormat("dd/MM/yyyy");

		this.name = name;	
		this.clientName = clientName;
		this.projectType = projectType;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;
        this.greenManagerName = greenManagerName;
        this.greenManagerNumber = greenManagerNumber;
        this.clientManagerName = clientManagerName;
        this.clientManagerNumber = clientManagerNumber;
        this.stages = new Stage[6];
	}

	public String getName(){
		return name;
	}
	
	public String getClientName(){
		return clientName;
	}

    public ProjectType getProjectType(){
        return projectType;
    }

	public Calendar getInitialDate(){
		return initialDate;
	}
	
	public String getInitialDateFormated() throws ParseException{
		return formatter.format(this.initialDate.getTime());
	}

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated() throws ParseException{
		return formatter.format(this.finalDate.getTime());
	}		

	public double getBudget(){
		return budget;
	}

    public String getGreenManagerName(){
        return greenManagerName;
    }

    public String getGreenManagerNumber(){
        return greenManagerNumber;
    }

    public String getClientManagerName(){
        return clientManagerName;
    }

    public String getClientManagerNumber(){
        return clientManagerNumber;
    }

    public String getProjectName(int stageNumber){
        return stages[stageNumber].getProjectName();
    }

    public StageName getStageName(int stageNumber){
        return stages[stageNumber].getStageName();
    }

    public Calendar getPlannedStartDate(int stageNumber){
        return stages[stageNumber].getPlannedStartDate();
    }

    public Calendar getPlannedEndDate(int stageNumber){
        return stages[stageNumber].getPlannedEndDate();
    }

    public Calendar getRealStartDate(int stageNumber){
        return stages[stageNumber].getRealStartDate();
    }

    public Calendar getRealEndDate(int stageNumber){
        return stages[stageNumber].getRealEndDate();
    }

    public StageStatus getStageStatus(int stageNumber){
        return stages[stageNumber].getStageStatus();
    }

    public void setProjectName(int stageNumber, String projectName) {
        stages[stageNumber].setProjectName(projectName);
    }
    
    public void setStageName(int stageNumber, StageName stageName) {
        stages[stageNumber].setStageName(stageName);
    }
    
    public void setPlannedStartDate(int stageNumber, Calendar plannedStartDate) {
        stages[stageNumber].setPlannedStartDate(plannedStartDate);
    }
    
    public void setPlannedEndDate(int stageNumber, Calendar plannedEndDate) {
        stages[stageNumber].setPlannedEndDate(plannedEndDate);
    }
    
    public void setRealStartDate(int stageNumber, Calendar realStartDate) {
        stages[stageNumber].setRealStartDate(realStartDate);
    }
    
    public void setRealEndDate(int stageNumber, Calendar realEndDate) {
        stages[stageNumber].setRealEndDate(realEndDate);
    }
    
    public void setStageStatus(int stageNumber, StageStatus stageStatus) {
        stages[stageNumber].setStageStatus(stageStatus);
    }

    public void setStage(int stageNumber, Stage stage){
        stages[stageNumber] = stage;
    }

    public Stage[] getStages() {
        return this.stages;
    }

    public void setStages(Stage[] stages) {
        this.stages = stages;
    }

    /**
     * Description: This method allows to get the number of knowledge units registered in a project
     * @return number int
     */

    public int getNumberKnowledgeUnits(){
        int number = 0;
        for(int x = 0; x < getStages().length; x++){
            if(getStages()[x] != null){
                for(int y = 0; y < getStages()[x].getUnits().length; y++){
                    if(getStages()[x].getUnits()[y] != null){
                        number += 1; 
                    }
                }
            }
        }
        return number;
    }

	public String getProjectInfo() throws ParseException{
		return "\nName: " + name + "\nClient: " + clientName + "\nProject type: " + projectType + "\nInitial Date: " + getInitialDateFormated() + 
		"\nFinal Date: " + getFinalDateFormated() + "\nTotalBudget: $" + budget + "\nGreen manager name: " + greenManagerName + 
        "\nGreen manager number: " + greenManagerNumber + "\nClient manager name: " + clientManagerName + "\nClient manager number: " + clientManagerNumber + "\n";
	}
}