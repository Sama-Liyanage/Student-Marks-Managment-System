import java.util.*;

class StudentManagement {
    //Add student without marks
    public static void addStudent(String[][] student) {
        Scanner input = new Scanner(System.in);
        System.out.print("\n-------------------------------------------------------------------------\n|");
        System.out.print("\t\t\tAdd new Student" + "\t\t\t\t\t|");
        System.out.print("\n-------------------------------------------------------------------------\n");

        L1:
        for (int i = 0; i < student.length; i++) {
            char yn = 'Y';
            do {
                System.out.print("\nEnter Student ID     : ");
                String number = input.next();
                L2:
                for (int j = 0; j < student.length; j++) {
                    if (number.equals(student[j][0])) {
                        System.out.println("The Student ID already exists");
                        i--;
                        continue L1;

                    } else if
                    (student[j][0].equals("0")) {
                        student[i][0] = number;
                    } else {
                        continue L2;
                    }

                }

                System.out.print("Enter Student Name   : ");
                student[i][1] = input.next();
            } while (i == student.length);
            System.out.print("Student has added successfully.Do you want to add new student? (Y/N)");
            yn = input.next().charAt(0);
            //Character validations should be added, but not showing in the demo
            yn = Character.toUpperCase(yn);
            if (yn == 'N') {
                clearConsole();
                printHome(student);
            } else if (yn == 'Y') {
                clearConsole();
                continue L1;
            }
        }
    }

    //Add students with marks
    public static void addStudentWithMarks(String[][] student) {
        Scanner input = new Scanner(System.in);
        System.out.print("\n-------------------------------------------------------------------------\n|");
        System.out.print("\t\t\tAdd new Student  With Marks\t\t\t|");
        System.out.println("\n-------------------------------------------------------------------------\n");

        L1:
        for (int i = 0; i < student.length; i++) {
            do {
                System.out.print("Enter Student ID  :");
                String number = input.next();
                L2:
                for (int j = 0; j < student.length; j++) {
                    if (number.equals(student[j][0])) {
                        System.out.println("The Student ID already exists");
                        i--;
                        continue L1;
                    } else if
                    (student[j][0].equals("0")) {
                        student[i][0] = number;
                    } else {
                        continue L2;
                    }
                }
                System.out.print("Enter Student Name  : ");
                student[i][1] = input.next();

                int marks1 = 0;
                L5:
                while (true) {
                    System.out.print("Programing Fundamentals Marks : ");
                    String pm = input.next();
                    marks1 = Integer.parseInt(pm);
                    if (marks1 < 0 || marks1 > 100) {
                        System.out.println("Invalid marks, please enter correct marks.\n");
                        continue L5;
                    }
                    student[i][2] = pm;
                    break L5;
                }
                int marks2 = 0;
                L6:
                while (true) {
                    System.out.print("Database Manage System Marks : ");
                    String db = input.next();
                    marks2 = Integer.parseInt(db);
                    if (marks2 < 0 || marks2 > 100) {
                        System.out.println("Invalid marks, please enter correct marks.\n");
                        continue L6;
                    }
                    student[i][3] = db;
                    break L6;
                }

            } while (i == student.length);

            System.out.print("Student has added successfully.Do you want to add new student? (Y/N) : ");
            char yn = input.next().charAt(0);
            //Character validations should be added, but not showing in the demo
            yn = Character.toUpperCase(yn);
            switch (yn) {
                case 'N':
                    clearConsole();
                    printHome(student);
                    break;
                case 'Y':
                    clearConsole();
                    continue L1;
            }
        }
    }
    //Add marks
    public static void addMarks(String[][] student) {
        Scanner input = new Scanner(System.in);
        System.out.print("\n-------------------------------------------------------------------------\n|");
        System.out.print("\t\t\tAdd  Marks" + "\t\t\t\t\t|");
        System.out.println("\n-------------------------------------------------------------------------\n");
        M1:
        for (int i = 0; i < student.length; i++) {
            do {
                System.out.print("Enter Student ID  :");
                String number = input.next();

                if (student[i][0].equals(number)) {
                    System.out.print("Student Name :" + student[i][1] + "\n");
                    int j = i;
                } else {
                    System.out.println("Invalid student ID.Do you want to search again? (Y/N)");
                    char yn = input.next().charAt(0);
                    yn = Character.toUpperCase(yn);

                    switch (yn) {
                        case 'Y':
                            i--;
                            continue M1;
                        case 'N':
                            printHome(student);
                            break;
                    }
                }
                if (student[i][2].equals("0")) {
                    int marks1 = 0;
                    L7:
                    while (true) {
                        System.out.print("Programing Fundamentals Marks : ");
                        String pm = input.next();
                        marks1 = Integer.parseInt(pm);
                        if (marks1 < 0 || marks1 > 100) {
                            System.out.println("Invalid marks, please enter correct marks.\n");
                            continue L7;
                        }
                        student[i][2] = pm;
                        break L7;
                    }
                    int marks2 = 0;
                    L8:
                    while (true) {
                        System.out.print("Database Management System Marks : ");
                        String db = input.next();
                        marks2 = Integer.parseInt(db);
                        if (marks2 < 0 || marks2 > 100) {
                            System.out.print("Invalid marks, please enter correct marks.\n");
                            continue L8;
                        }
                        student[i][3] = db;
                        break L8;
                    }
                } else{

                    System.out.print("This student marks have been already added.\nIf you want to update marks please use [4] update mark option\n");
                    System.out.print("Do you want to add marks for another student? (Y/N)");
                    char yn1 = input.next().charAt(0);
                    yn1 = Character.toUpperCase(yn1);
                    switch (yn1) {
                        case 'Y':
                            i--;
                            continue M1;
                        case 'N':
                            clearConsole();
                            printHome(student);
                    }         break;
                }
            } while (i == student.length);
            System.out.print("Marks have been added.Do you want to add marks for another student? (Y/N)");
            char yn = input.next().charAt(0);
            yn = Character.toUpperCase(yn);
            switch (yn) {
                case 'N':
                    clearConsole();
                    printHome(student);
                    break;
                case 'Y':
                    continue M1;
            }
        }
    }
    //Update student details
    public static void updateStudentDetails(String[][] student) {
        Scanner input = new Scanner(System.in);
        System.out.print("\n-------------------------------------------------------------------------\n|");
        System.out.print("\t\t\tUpdate Student Details\t\t\t\t|");
        System.out.print("\n-------------------------------------------------------------------------\n");

        M1:
        for (int i = 0; i < student.length; i++) {
            do {
                System.out.print("\nEnter Student ID  :");
                String number = input.next();

                if (student[i][0].equals(number)) {
                    System.out.print("Student Name :" + student[i][1] + "\n");
                    System.out.print("\nEnter new Student Name  :");
                    String newstudent = input.next();
                } else {
                    System.out.println("Invalid student ID.Do you want to search again? (Y/N)");
                    char yn = input.next().charAt(0);
                    yn = Character.toUpperCase(yn);
                    switch (yn) {
                        case 'Y':
                            i--;
                            continue M1;
                        case 'N':
                            printHome(student);
                            break;
                    }
                }
                System.out.print("Student Details has been updated successfully.\n" +
                        "Do you want to update another students details? (Y/N)");
                char yn = input.next().charAt(0);
                yn = Character.toUpperCase(yn);
                switch (yn) {
                    case 'N':
                        clearConsole();
                        printHome(student);
                        break;
                    case 'Y':
                        continue M1;
                }
            } while (i == student.length);
        }
    }

    //Printing menu
    public static void printHome(String[][] student0) {
        Scanner input = new Scanner(System.in);
        String[][] student = new String[100][4];
        student = student0;
        boolean x = true;
        System.out.print("\n-------------------------------------------------------------------------------------------------\n|");
        System.out.print("\t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM" + "\t\t\t\t\t|");
        System.out.println("\n-------------------------------------------------------------------------------------------------\n");
        System.out.print("[1]Add new student\t\t\t\t\t\t");
        System.out.print("[2]Add new students with Marks\n");
        System.out.print("[3]Add Marks\t\t\t\t\t\t\t");
        System.out.print("[4]Update Student Details\n");
        System.out.print("[5]Update Marks\t\t\t\t\t\t\t");
        System.out.print("[6]Delete Student\n");
        System.out.print("[7]Print Student Detail\t\t\t\t\t");
        System.out.print("[8]Print Student Ranks\n");
        System.out.print("[9]Best in Programming Fundamentals\t\t");
        System.out.println("[10]Best in Database Management System\n");

        System.out.println("[] print");
        System.out.print("Enter an option to continue > ");
        int num = input.nextInt();
        clearConsole();
        switch (num) {
            case 1:
                addStudent(student);
                break;
            case 2:
                addStudentWithMarks(student);
                break;
            case 3:
                addMarks(student);
                break;
            case 4:
                updateStudentDetails(student);
                break;
            case 5:
                updateMarks(student);
                break;
            case 6:
                deleteStudent(student);
                break;
            case 7:
                //printstudentDetails(student);
                break;
            case 8:
                printStudentRanks(student);
                break;
            case 9:
                bestProgrammingFundamentals(student);
                break;
            case 10:
                bestDatabaseManagementSystems(student);
                break;


        }
    }

    //Clearing the console
    public final static void clearConsole() {

        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

    public static void print2D(String[][] student) {
        System.out.println();
        for (int i = 0; i < student.length; i++) {
            for (int j = 0; j < student[i].length; j++) {
                System.out.print(student[i][j]);
            }
            System.out.println();
        }
        printHome(student);
    }

    //Update marks
    public static void updateMarks(String[][] student) {
        Scanner input = new Scanner(System.in);
        System.out.print("\n-------------------------------------------------------------------------\n|");
        System.out.print("\t\t\tUpdate Marks" + "\t\t\t\t\t|");
        System.out.println("\n-------------------------------------------------------------------------\n");
        M1:
        for (int i = 0; i < student.length; i++) {
            do {
                System.out.print("Enter Student ID  :");
                String number = input.next();

                if (student[i][0].equals(number)) {
                    System.out.println("Student Name :" + student[i][1] + "\n");
                    System.out.println("Programming Fundamentals Marks :" + student[i][2]);
                    System.out.println("Database Management System Marks :" + student[i][3]);
                    boolean x = true;
                    while (x) {
                        System.out.println("Enter new Programming Fundamentals Marks :");
                        String newPFMarks = input.next();
                        int marks = Integer.parseInt(newPFMarks);
                        if (marks < 0 || marks > 100) {
                            System.out.println("Invalid marks, please enter correct marks.\n");
                            continue;
                        }
                        student[i][2] = newPFMarks;
                        break;
                    }
                    while (x) {
                        System.out.print("Enter new Database Management Marks :");
                        String newDMMarks = input.next();
                        int marks = Integer.parseInt(newDMMarks);
                        if (marks < 0 || marks > 100) {
                            System.out.println("Invalid marks, please enter correct marks.\n");
                            continue;
                        }
                        student[i][3] = newDMMarks;
                        break;
                    }
                } else {
                    System.out.println("Invalid student ID.Do you want to search again? (Y/N)");
                    char yn = input.next().charAt(0);
                    yn = Character.toUpperCase(yn);
                    switch (yn) {
                        case 'Y':
                            i--;
                            continue M1;
                        case 'N':
                            printHome(student);
                            break;
                    }
                }
                System.out.print("Marks have been updated successfully.Do you want to update marks for another student? (Y/N)");
                char yn = input.next().charAt(0);
                yn = Character.toUpperCase(yn);
                switch (yn) {
                    case 'N':
                        clearConsole();
                        printHome(student);
                        break;
                    case 'Y':
                        continue M1;
                }
            } while (i == student.length);
        }
    }
    //deleteStudent
    public static void deleteStudent(String[][] student) {
        Scanner input = new Scanner(System.in);
        System.out.print("\n-------------------------------------------------------------------------\n|");
        System.out.print("\t\t\tdeleteStudent" + "\t\t\t\t\t|");
        System.out.println("\n-------------------------------------------------------------------------\n");
        String studentId = input.nextLine();
        if (!studentId.equals(null)) {
            for (int i = 0; i < student.length; i++) {
                if (student[i][0].equals(studentId)) {
                    for (int j = 0; j < student[i].length; j++) {
                        student[i][j] = "0";
                    }
                }
            }
            fillna(student);
            System.out.println("Student deleted successfully");
            System.out.println("\nDo you want to go to main menu?(y/n) ");
            String value = input.nextLine();
            if(value.equals("y")||value.equals("Y")){
                clearConsole();
                printHome(student);
            }
            return;
        } else {
            System.out.println("Invalid Student ID");
            printHome(student);
        }
    }

    public static void printStudentDetails(String[][] student) {
        Scanner input = new Scanner(System.in);

        System.out.print("\n-------------------------------------------------------------------------\n|");
        System.out.print("\t\t\tPRINT STUDENT DETAILS" + "\t\t\t\t\t|");
        System.out.println("\n-------------------------------------------------------------------------\n");

        M1:
        for (int i = 0; i < student.length; i++) {
            do {
                System.out.print("Enter Student ID  :");
                String number = input.next();
                if (student[i][0].equals(number)) {
                    System.out.println("Student Name :" + student[i][1] + "\n");
                    if (student[i][2].equals("0")) {
                        System.out.println("\nMarks yet to be added");
                    } else {
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("Programming Fundementals Marks    | " + student[i][2] + "|");
                        System.out.println("Database Management Systems Marks | " + student[i][3] + "|");
                        System.out.println("Total Marks                       | " + student[i][3]+student[i][2]+ "|");
                        int marks1 = Integer.parseInt(student[i][3]);
                        int marks2 = Integer.parseInt(student[i][3]);
                        System.out.println("Avg Marks                         | "+ (marks1+marks2)/2 + "|");
                        System.out.println("Rank                              | " + student[i][3]+ "|");
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                } else {
                    System.out.println("Invalid student ID.Do you want to search again? (Y/N)");
                    char yn = input.next().charAt(0);
                    yn = Character.toUpperCase(yn);
                    switch (yn) {
                        case 'Y':
                            i--;
                            continue M1;
                        case 'N':
                            printHome(student);
                            break;
                    }
                }
                System.out.print("Do you want to update marks for another students details? (Y/N)");
                char yn = input.next().charAt(0);
                yn = Character.toUpperCase(yn);
                switch (yn) {
                    case 'N':
                        clearConsole();
                        printHome(student);
                        break;
                    case 'Y':
                        continue M1;
                }
            } while (i == student.length);
        }
    }



    public static void fillna(String[][] student) {
        //Bubble sort to fill NaN(0) in the 2D array
        int n = student.length;
        String[] temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (student[j - 1][0].length() > student[j][0].length()) {
                    //swap elements
                    temp = student[j - 1];
                    student[j - 1] = student[j];
                    student[j] = temp;
                }

            }
        }
    }

    //print student ranks
    public static void printStudentRanks(String [][] student){
        Scanner input  = new Scanner(System.in);
        System.out.print("-----------------------------------------------------------------");
        System.out.print("\n|\t\t\tPRINT STUDENS' RANK\t\t\t|\n");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println();
        String [][] ranks = new String[student.length][3];
        double average=0;
        for(int i=0;i<student.length;i++){
            average  = (Double.parseDouble(student[i][2])+Double.parseDouble(student[i][3]));
            ranks[i][0] = student[i][0];
            ranks[i][1] = student[i][1];


        }
        rankSorter(ranks);
        //print the ranks
        int k = 0; //iterator
        for(String[] str: ranks){
            if(!str[0].equals("0") && !str[1].equals("0")){
                k++;
                System.out.println("Rank: "+k+" "+str[0]+" "+str[1]+" Average: "+str[3]);
            }
        }

        System.out.println("\nDo you want to go to the main menu?(y,n) ");

        String value = input.nextLine();
        if(value.equals("y")|| value.equals("Y")){
            clearConsole();
            printHome(student);
        }
        return;
    }

    //bubble sort for ranks
    public static void rankSorter(String[][] ranks){
        int n = ranks.length;
        String[] temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (Double.parseDouble(ranks[j - 1][2]) < Double.parseDouble(ranks[j][2])) {
                    //swap elements
                    temp = ranks[j - 1];
                    ranks[j - 1] = ranks[j];
                    ranks[j] = temp;
                }

            }
        }
    }

    //Best in programming fundamentals
    public static void bestProgrammingFundamentals(String [][] student){
        Scanner input  = new Scanner(System.in);
        System.out.print("---------------------------------------------------------------------------------");
        System.out.print("\n|\t\t\tBEST IN PROGRAMMING FUNDAMENTALS\t\t\t|\n");
        System.out.println("---------------------------------------------------------------------------------\n");
        System.out.println();
        double maxMarks  = 0;
        String student_id = "";
        String student_name = "";
        for(int i=0;i<student.length;i++){
            if(Double.parseDouble(student[i][2])>maxMarks){
                maxMarks = Double.parseDouble(student[i][2]);
                student_id = student[i][0];
                student_name = student[i][1];
            }
        }

        String[][] students_with_max_marks = new String[student.length][2];
        for(int i=0;i<students_with_max_marks.length;i++){
            students_with_max_marks[i][0] = "0";
            students_with_max_marks[i][1] = "0";
        }
        int j = 0;
        for(int i=0;i<student.length;i++){
            if(Double.parseDouble(student[i][2])==maxMarks){
                students_with_max_marks[j][0] = student[i][0];
                students_with_max_marks[j][1] = student[i][1];
                j++;
            }
        }

        System.out.println("Maximum mark for Programming Fundamentals: "+maxMarks);
        for(String[] str:students_with_max_marks){
            if(!str[0].equals("0") && !str[1].equals("0")){
                System.out.println(str[0]+"\t"+str[1]);
            }
        }

        System.out.println("\nDo you want to go to main menu?(y/n)");
        String value = input.nextLine();
        if(value.equals("y") || value.equals("Y")){
            clearConsole();
            printHome(student);
        }
        return;
    }

    //Best in database management systems
    public static void bestDatabaseManagementSystems(String [][] student){
        System.out.print("-----------------------------------------------------------------");
        System.out.print("\n|\t\t\tPRINT STUDENT DETAILS\t\t\t|\n");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println();

        double maxMarks  = 0;
        String student_id = "";
        String student_name = "";
        for(int i=0;i<student.length;i++){
            if(Double.parseDouble(student[i][3])>maxMarks){
                maxMarks = Double.parseDouble(student[i][3]);
                student_id = student[i][0];
                student_name = student[i][1];
            }
        }

        String[][] students_with_max_marks = new String[student.length][2];
        for(int i=0;i<students_with_max_marks.length;i++){
            students_with_max_marks[i][0] = "0";
            students_with_max_marks[i][1] = "0";
        }
        int j = 0;
        for(int i=0;i<student.length;i++){
            if(Double.parseDouble(student[i][3])==maxMarks){
                students_with_max_marks[j][0] = student[i][0];
                students_with_max_marks[j][1] = student[i][1];
                j++;
            }
        }

        System.out.println("Maximum mark for Programming Fundamentals: "+maxMarks);
        for(String[] str:students_with_max_marks){
            if(!str[0].equals("0") && !str[1].equals("0")){
                System.out.println(str[0]+"\t"+str[1]);
            }
        }
        Scanner input = new Scanner(System.in);
        System.out.println("\nDo you want to go to main menu?(y/n)");
        String value = input.nextLine();
        if(value.equals("y") || value.equals("Y")){
            clearConsole();
            printHome(student);
        }
        return;
    }






    public static void main(String[] args) {
        String[][] student = new String[100][4];

        for (int i = 0; i < student.length; i++) {
            for (int j = 0; j < student[i].length; j++) {
                student[i][j] = ("0");
            }
        }
        printHome(student);
    }
}
