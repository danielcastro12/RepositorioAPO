package ui;

import java.text.ParseException;
import java.util.Scanner;
import model.Controller;

public class Executable {

    private Scanner reader;
    private Controller controller;

    public Executable() {

        reader = new Scanner(System.in);
        controller = new Controller();
    }

    public static void main(String[] args) throws ParseException {

        Executable exe = new Executable();
        exe.menu();
    }

    /**
     * Description: This method has the menu for the program and it calls the other methods in the executable
     * @throws ParseException
     */

    public void menu() throws ParseException {

        System.out.println("Welcome to GreenSQA's ");

        boolean condition = false;

        while(!condition){

            System.out.println("Select the option you want to do: \n1 = Register a project \n2 = End a stage of a project \n3 = Register a knowledge unit \n4 = Approve a knowledge unit \n5 = Publish a knowledge unit \n6 = Leave program");
            int option = reader.nextInt();

            switch(option){

                case 1:

                    registerProject();
                    break;

                case 2:

                    endProjectStage();
                    break;

                case 3:

                    registerKnowledgeUnit();
                    break;

                case 4: 

                    approveKnowledgeUnit();
                    break;

                case 5: 

                    publishKnowledgeUnit();
                    break;

                case 6:

                    condition = true;
                    break;
            }
        }
    }

    /**
     * Description: This method allows the user to provide the information required for approving a knowledge unit and calls the method in the controller
     */

    private void approveKnowledgeUnit() {

        String registeredUnits = controller.getRegisteredUnits();

        if(registeredUnits.equals("")){

            System.out.println("There are not knowledge units registered");
        }

        else{

            reader.nextLine();

            System.out.println("These are the knowledge units registered: ");
            System.out.println(registeredUnits);

            System.out.println("Insert the ID of the knowledge unit to change status: ");
            String id = reader.nextLine();

            if(controller.compareId(id).equals(id)){

                System.out.println("Insert the new approval status of the knowledge unit: \n1 = Approved \n2 = Not Approved");
                int newStatus = reader.nextInt();

                reader.nextLine();
    
                System.out.println("Insert the day of the approval for the knowledge unit: ");
                int currentDay = reader.nextInt();
    
                System.out.println("Insert the month of the approval for the knowledge unit: ");
                int currentMonth = reader.nextInt();
    
                System.out.println("Insert the year of the approval for the knowledge unit: ");
                int currentYear = reader.nextInt();

                controller.approveKnowledgeUnit(id, newStatus, currentDay, currentMonth, currentYear);
                System.out.println("The approval status was modified successfully and the approval date was registered");
            }

            else{

                System.out.println("There is not a knowledge unit with the given ID");
            }
        }
    }

    /**
     * Description: This method allows the user to provide the information required to register a knowledge unit and calls the method in the controller
     */

    public void registerKnowledgeUnit() {

        String projectNames = controller.getProjectNames();

        System.out.println("These are the registered projects: ");
        System.out.println(projectNames);

        reader.nextLine();

        System.out.println("Insert the exact name of the project to register the knowledge unit in: ");
        String projectName = reader.nextLine();

        System.out.println("Insert the stage in which you want to register the knowledge unit: \n1 = START \n2 = ANALYSIS \n3 = DESIGN \n4 = EXECUTION \n5 = CLOSURE_AND_FOLLOW_UP \n6 = PROYECT_CONTROL");
        int stage = reader.nextInt();
        reader.nextLine();
        
        System.out.println("Insert the ID of the Knowledge Unit: ");
        String id = reader.nextLine();

        System.out.println("Insert your name: ");
        String employeeName = reader.nextLine();

        System.out.println("Insert your position on the company: ");
        String employeesJob = reader.nextLine();

        System.out.println("Insert a brief description: ");
        String description = reader.nextLine();

        System.out.println("Insert the type of the Knowledge Unit: \n1 = Technical \n2 = Experiences");
        int type = reader.nextInt();
        reader.nextLine();

        System.out.println("Insert the learned lesson of the Knowledge Unit: ");
        String learnedLesson = reader.nextLine();

        if (controller.registerKnowledgeUnit(projectName, stage, id, employeeName, employeesJob, description, type, learnedLesson)){
            System.out.println("Knowledge Unit created successfully");
        }
        else{
            System.out.println("Knowledge Unit was not created due to lack of memory on the system");
        }            
    }

    public void showAllKnowledgeUnits() {
        String show = controller.getAllKnowledgeUnits();
        if (show.equals("")){
            System.out.println("There are not knowledge units registered");
        }
        else{
            System.out.println(show);
        }
    }

    /**
     * Description: This method allows the user to provide the information for publishing a knowledge unit and calls the method in the controller
     */

    public void publishKnowledgeUnit() {

        String approvedKnowledgeUnits = controller.getApprovedKnowledgeUnits();

        if(approvedKnowledgeUnits.equals("")){
            System.out.println("There are not knowledge units approved");
        }

        else{
            reader.nextLine();

            System.out.println("These are the knowledge units approved: ");
            System.out.println(approvedKnowledgeUnits);

            System.out.println("Insert the ID of the knowledge unit to publish: ");
            String id = reader.nextLine();

            if(controller.compareId(id).equals(id)){
                controller.publishKnowledgeUnit(id);
                System.out.println("The knowledge unit was approved successfully and it's available on this URL: ");
                System.out.println(controller.getUrl(id));
            }

            else{
                System.out.println("There is not an approved knowledge unit with the given ID");
            }
        }
    }

    /**
     * Description: This method allow the user to provide the information required to register a project and calls the method in the controller
     */

    public void registerProject() {

        reader.nextLine();
    
        System.out.println("Insert the name of the project: ");
        String name = reader.nextLine();
    
        System.out.println("Insert the name of the client: ");
        String client = reader.nextLine();
    
        System.out.println("Insert the type of the project: \n1 = Develop \n2 = Maintenance \n3 = Deployment");
        int type = reader.nextInt();
        reader.nextLine();
    
        System.out.println("Insert the day that the project starts: ");
        int startDay = reader.nextInt();
    
        System.out.println("Insert the month that the project starts: ");
        int startMonth = reader.nextInt();
    
        System.out.println("Insert the year that the project starts: ");
        int startYear = reader.nextInt();
    
        System.out.println("Insert the budget of the proyect: ");
        double budget = reader.nextDouble();
    
        reader.nextLine();
    
        System.out.println("Insert the name of Green's manager: ");
        String greenManagerName = reader.nextLine();
    
        System.out.println("Insert the number of Green's manager: ");
        String greenManagerNumber = reader.nextLine();
    
        System.out.println("Insert the name of the client's manager: ");
        String clientManagerName = reader.nextLine();
    
        System.out.println("Insert the number of the client's manager: ");
        String clientManagerNumber = reader.nextLine();
    
        System.out.println("Insert the number of months that stage 1 is intended to last: ");
        int stage1Len = reader.nextInt();
    
        System.out.println("Insert the number of months that stage 2 is intended to last: ");
        int stage2Len = reader.nextInt();
    
        System.out.println("Insert the number of months that stage 3 is intended to last: ");
        int stage3Len = reader.nextInt();
    
        System.out.println("Insert the number of months that stage 4 is intended to last: ");
        int stage4Len = reader.nextInt();
    
        System.out.println("Insert the number of months that stage 5 is intended to last: ");
        int stage5Len = reader.nextInt();
    
        System.out.println("Insert the number of months that stage 6 is intended to last: ");
        int stage6Len = reader.nextInt();
    
        reader.nextLine();

		if (controller.registerProject(name, client, type, startDay, startMonth, startYear, budget, greenManagerName, greenManagerNumber, clientManagerName, clientManagerNumber, stage1Len, stage2Len, stage3Len, stage4Len, stage5Len, stage6Len)) {
			System.out.println("Project created successfully");
		} else {
			System.out.println("Project was not created due to lack of memory on the system");
		}
	}

	public void searchProjectsAfterDate() throws ParseException {

		System.out.println("Insert the day: ");
		int day = reader.nextInt();

		System.out.println("Insert the month: ");
		int month = reader.nextInt();

		System.out.println("Insert the year: ");
		int year = reader.nextInt();

		System.out.println(controller.searchProjectsAfterDate(day, month, year));
	}

	public void searchProjectsBeforeDate() throws ParseException {

		System.out.println("Insert the day: ");
		int day = reader.nextInt();

		System.out.println("Insert the month: ");
		int month = reader.nextInt();

		System.out.println("Insert the year: ");
		int year = reader.nextInt();

		System.out.println(controller.searchProjectsBeforeDate(day, month, year));
	}

    /**
     * Description: This method allows the user to provide the information required to end a project stage and call the method in the controller
     * @throws ParseException
     */

    public void endProjectStage() throws ParseException {

        String projectStages = controller.getProjectStages();

        if (projectStages.equals("")){
            System.out.println("There are not active stages registered for any project");
        }

        else{
            reader.nextLine();
            System.out.println("These are the active registered stages: ");
            System.out.println(projectStages);

            System.out.println("Insert the project name whose stage you would like to end: ");
            String projectName = reader.nextLine();

            System.out.println("Insert the day of the end of the stage: ");
            int currentDay = reader.nextInt();

            System.out.println("Insert the month of the end of the stage: ");
            int currentMonth = reader.nextInt();

            System.out.println("Insert the year of the end of the stage: ");
            int currentYear = reader.nextInt();

            if(controller.compareName(projectName).equals(projectName)){
                controller.endProjectStage(projectName, currentDay, currentMonth, currentYear);
                System.out.println("The stage was ended successfully and the next stage (if any) was activated");
            }
        }
    }
}