import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface InterfaceForEmployeeManagementSystem {
    void interactiveModelStart();
}

class EmployeeManagementSystemUserInput {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String adminName = "admin";
    String adminPassword = "123";

    String adminLoginNameString;
    String adminLoginPasswordString;
    String employeeLoginIdString;
    String employeeLoginPasswordString;
    String employeePasswordTemp;
    String userOptionString;
    int userOption;
    String continueOption;
    String idToUpdate;
    String idToDelete;
    String name;
    String id;
    String dob;
    String doj;
    String mobile;
    String mail;
    String designation;
    String password;
    int count;
}
public class EmployeeManagementSystem extends EmployeeManagementSystemUserInput implements InterfaceForEmployeeManagementSystem {
    private String salary;

    private void deleteId() {
        System.out.println("Data related to the Id is deleted");
        adminOptions();
    }

    private void confirmDelete() {
        System.out.print("Enter your choice : ");
        try {
            continueOption = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (continueOption) {
            case "1":
                deleteId();
                break;
            case "2":
                adminOptions();
                break;
            default:
                System.out.println("This not a Valid Option choose 1 or 2 ");
                confirmDelete();
                break;
        }
    }

    private void deleteParticularData() {
        System.out.print("Enter an ID to Delete from Database : ");
        try {
            idToDelete = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (idToDelete.equals("")) {
            System.out.println("This is not a valid ID. Retry...");
            deleteParticularData();
        } else if (!idToDelete.equals("")) {
            try {
                if (count > 0) {
                    System.out.println("Do you want to Delete this Id = " + idToDelete);
                    System.out.println("1 = YES");
                    System.out.println("2 = NO");
                    System.out.println();
                    confirmDelete();
                } else if (count == 0) {
                    System.out.println("The ID is not present in the database please insert this ID before Deleting");
                    continueOrExit();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            continueOrExit();
        }
    }

    private void updateId() {
        System.out.println("Please Specify the Data to be modified ");
        System.out.println("1 = ID");
        System.out.println("2 = NAME");
        System.out.println("3 = DATE OF BIRTH");
        System.out.println("4 = DATE OF JOIN");
        System.out.println("5 = MOBILE NUMBER");
        System.out.println("6 = EMAIL-ID");
        System.out.println("7 = DESIGNATION");
        System.out.println("8 = SALARY");
        System.out.println("9 = PASSWORD");
        System.out.println("10 = EXIT");
        System.out.println();
        System.out.print("Enter your option :");
        try {
            userOptionString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userOption = Integer.parseInt(userOptionString);
        if (userOption <= 0 || userOption > 10) {
            System.out.println("Enter only numbers between 1 to 10");
            adminOptions();
        }
        switch (userOption) {
            case 1:
                System.out.println("Enter the new ID ");
                try {
                    id = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                continueOrExit();
                break;
            case 2:
                System.out.println("Enter the new Name ");
                try {
                    name = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                continueOrExit();
                break;
            case 3:
                System.out.println("Enter the new Date of Birth ");
                try {
                    dob = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                continueOrExit();
                break;
            case 4:
                System.out.println("Enter the new Date of Birth ");
                try {
                    doj = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                continueOrExit();
                break;
            case 5:
                System.out.println("Enter the new Mobile Number ");
                try {
                    mobile = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                continueOrExit();
                break;
            case 6:
                System.out.println("Enter the new Email-ID ");
                try {
                    mail = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                continueOrExit();
                break;
            case 7:
                System.out.println("Enter the new Designation ");
                try {
                    designation = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                continueOrExit();
                break;
            case 8:
                System.out.println("Enter the new Salary ");
                try {
                    salary = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                continueOrExit();
                break;
            case 9:
                System.out.println("Enter the new Password ");
                try {
                    password = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                continueOrExit();
                break;
            case 10:
                System.out.println("Exiting Update");
                continueOrExit();
                break;
        }
    }

    private void confirmUpdate() {

        System.out.print("Enter your choice : ");
        try {
            continueOption = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (continueOption) {
            case "1":
                try {
                    updateId();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "2":
                adminOptions();
                break;
            default:
                System.out.println("This not a Valid Option choose 1 or 2 ");
                confirmUpdate();
                break;
        }
    }

    private void updateSpecificIdDetails() {
        System.out.print("Enter an ID to update Datas : ");
        try {
            idToUpdate = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (idToUpdate.equals("")) {
            System.out.println("This is not a valid ID");
            updateSpecificIdDetails();
        } else {
            try {
                count = 0;
                if (count > 0) {
                    System.out.println("Do you want to update this Id =" + idToUpdate);
                    System.out.println("1 = YES");
                    System.out.println("2 = NO");
                    System.out.println();
                    confirmUpdate();
                } else if (count == 0) {
                    System.out.println("The ID is not present in the database please insert this ID before Updating");
                    continueOrExit();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void viewDatabaseEntries() {
        System.out.println("=============================================   Employee Details   ================================================================================");
        System.out.println();
        System.out.println("Id\tName\tDateOfBirth\tMobileNumber\t\tMail-Id\t\tDateOfJoining\t\tDesignation\tSalary\t\tPassword");
        System.out.println("===================================================================================================================================================");
        System.out.println("===================================================================================================================================================");
    }

    private void continueOrExit() {
        System.out.println("=========================");
        System.out.println("Do you want to continue ?");
        System.out.println("1 = Go to Main Menu");
        System.out.println("2 = Exit from Application");
        System.out.println("=========================");
        System.out.println();
        System.out.print("Enter your option : ");
        try {
            continueOption = bufferedReader.readLine(); //Number of employees is entered here
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (continueOption) {
            case "1":
                System.out.println();
                adminOptions();
                break;
            case "2":
                System.out.println("Exiting Program....");
                System.exit(0);
            default:
                System.out.println("Enter option 1 or 2");
                continueOrExit();
                break;
        }
    }

    private void getDatasFromUser() {
            System.out.println("Enter the Details of Employee");
    }

    private void adminOptions() {
        System.out.println("==========ADMIN===========");
        System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("Enter your choice: ");
        System.out.println("1 = INSERT RECORD");
        System.out.println("2 = VIEW RECORDS");
        System.out.println("3 = UPDATE RECORD");
        System.out.println("4 = DELETE RECORD");
        System.out.println("5 = LOG OUT");
        System.out.println("6 = EXIT");
        System.out.println("=========================");
        System.out.println();
        System.out.print("Enter your option : ");
        try {
            userOptionString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userOption = Integer.parseInt(userOptionString);
        if (userOption <= 0 || userOption > 6) {
            System.out.println("Enter only numbers between 1 to 6");
            adminOptions();
        }
        switch (userOption) {
            case 1:
                getDatasFromUser();
                System.out.println("Database Updated.");
                continueOrExit();
                break;
            case 2:
                viewDatabaseEntries();
                continueOrExit();
                break;
            case 3:
                try {
                    updateSpecificIdDetails();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                continueOrExit();
                break;
            case 4:
                deleteParticularData();
                continueOrExit();
                break;
            case 5:
                System.out.println("Logging out....");
                interactiveModelStart();
                break;
            case 6:
                System.out.println("Exiting Program....");
                System.exit(0);
        }
    }

    private void updateEmployeeDetails() {
        System.out.println("Please Specify the Data to be modified ");
        System.out.println("1 = NAME");
        System.out.println("2 = DATE OF BIRTH");
        System.out.println("3 = MOBILE NUMBER");
        System.out.println("4 = EMAIL-ID");
        System.out.println("5 = PASSWORD");
        System.out.println("6 = EXIT");
        System.out.println();
        System.out.print("Enter your option :");
        try {
            userOptionString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        count = 0;
        for (int i = 0; i < userOptionString.length(); i++) {
            if (Character.isDigit(userOptionString.charAt(i)))
                count++;
        }
        if (count != userOptionString.length()) {
            System.out.println("Enter only numbers between 1 to 5");
            adminOptions();
        }
        userOption = Integer.parseInt(userOptionString);
        if (userOption <= 0 || userOption > 5) {
            System.out.println("Enter only numbers between 1 to 5");
            adminOptions();
        }
        switch (userOption) {
            case 1:
                System.out.println("Enter the new Name ");
                try {
                    name = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                employeeOptions();
                break;
            case 2:
                System.out.println("Enter the new Date of Birth ");
                try {
                    dob = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                employeeOptions();
                break;
            case 3:
                System.out.println("Enter the new Mobile Number ");
                try {
                    mobile = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                employeeOptions();
                break;
            case 4:
                System.out.println("Enter the new Email-ID ");
                try {
                    mail = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                employeeOptions();
                break;
            case 5:
                System.out.println("Enter the new Password ");
                try {
                    password = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                employeeOptions();
                break;
            case 6:
                System.out.println("Exiting Update");
                employeeOptions();
                break;
        }
    }
    private void viewDatabaseEntriesForEmployee() {
        System.out.println("=============================================   Employee Details   ================================================================================");
        System.out.println();
        System.out.println("Id\tName\t\tDateOfBirth\tMobileNumber\t\tMail-Id\t\tDateOfJoining\tDesignation");
        System.out.println("===================================================================================================================================================");
        System.out.println("===================================================================================================================================================");
    }
    private void employeeOptions() {
        System.out.println("=========EMPLOYEE=========");
        System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("Enter your choice: ");
        System.out.println("1 = VIEW RECORD");
        System.out.println("2 = UPDATE RECORD");
        System.out.println("3 = LOG OUT");
        System.out.println("4 = EXIT");
        System.out.println();
        System.out.print("Enter your option : ");
        try {
            userOptionString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        count = 0;
        for (int i = 0; i < userOptionString.length(); i++) {
            if (Character.isDigit(userOptionString.charAt(i)))
                count++;
        }
        if (count != userOptionString.length()) {
            System.out.println("Enter only numbers between 1 to 4");
            adminOptions();
        }
        userOption = Integer.parseInt(userOptionString);
        if (userOption <= 0 || userOption > 4) {
            System.out.println("Enter only numbers between 1 to 4");
            adminOptions();
        }
        switch (userOption) {
            case 1:
                viewDatabaseEntriesForEmployee();
                employeeOptions();
                break;
            case 2:
                try {
                    updateEmployeeDetails();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                employeeOptions();
                break;
            case 3:
                System.out.println("Logging out....");
                interactiveModelStart();
                break;
            case 4:
                System.out.println("Exiting Program....");
                System.exit(0);
                break;
        }
    }

    private void validateEmployee() {
        System.out.println("Enter Employee EMail-id");
        try {
            employeeLoginIdString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (employeeLoginIdString.equals("")) {
            System.out.println("This is not a valid EMail-id");
            validateEmployee();
        } else {
            try {
                //count = getid
                if (count == 0) {
                    System.out.println("This EMail is Incorrecct or it does not present in the Database. Retry...");
                    validateEmployee();
                } else {
                    System.out.println("Enter Empolyee Password");
                    try {
                        employeeLoginPasswordString = bufferedReader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (employeeLoginPasswordString.equals("")) {
                        System.out.println("This is not a valid ID. Enter Employee ID and PASSWORD");
                        validateEmployee();
                    } else {
                        try {
                            //employeePasswordTemp = getpassword
                            if (employeePasswordTemp.equals(employeeLoginPasswordString)) {
                                employeeOptions();
                            } else {
                                System.out.println("The Entered password is not correct. Enter the employee ID and employee PASSWORD");
                                validateEmployee();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void validateAdmin() {
        System.out.println("Enter admin NAME");
        try {
            adminLoginNameString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!adminLoginNameString.equals(adminName)) {
            System.out.println("The Admin Name is Incorrect");
            validateAdmin();
        } else if (adminLoginNameString.equals("")) {
            System.out.println("The Admin Name is Incorrect");
            validateAdmin();
        } else {
            System.out.println("Enter admin PASSWORD");
            try {
                adminLoginPasswordString = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!adminLoginPasswordString.equals(adminPassword)) {
                System.out.println("The Admin Password is Incorrect Enter Admin NAME and PASSWORD");
                validateAdmin();
            } else if (adminLoginPasswordString.equals("")) {
                System.out.println("The Admin Password is Incorrect Enter Admin NAME and PASSWORD");
                validateAdmin();
            } else {
                adminOptions();
            }
        }
    }

    private void getUserOption() {
        System.out.print("Enter your choice : ");
        try {
            userOptionString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (userOptionString) {
            case "1":
                validateAdmin();
                break;
            case "2":
                validateEmployee();
                break;
            case "3":
                System.out.println("Exiting Application....");
                System.exit(0);
            default:
                System.out.println("This not a Valid Option choose 1 or 2 ");
                getUserOption();
                break;
        }
    }
    public void interactiveModelStart() {
        System.out.println("=========WELCOME==========");
        System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("1 = ADMIN LOGIN");
        System.out.println("2 = EMPLOYEE LOGIN");
        System.out.println("3 = EXIT APPLICATION");
        System.out.println("==========================");
        getUserOption();
    }

    public static void main(String[] args) {

        InterfaceForEmployeeManagementSystem interfaceForEmployeeManagementSystem = new EmployeeManagementSystem();
        interfaceForEmployeeManagementSystem.interactiveModelStart();
    }
}