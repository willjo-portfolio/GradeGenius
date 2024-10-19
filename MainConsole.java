import java.util.Scanner;
import java.util.ArrayList;
/**
 * Title: GradeGenius (MyEducation BC)
 * 
 * 
 * Program Summary: This program is a grade analyze system that helps educators and students to manage and access to the grade of students. There are two major parts in this program: the teachers' part and the students' part. Teachers can access and modify the grades of all students in that class. Students can only access their own grades. Before students can login into their account, teachers has to add them into the class and assign them a password, which they can change later. Before a teacher can login into the system, a class has to be created, and a password has to be assigned.
 * 
 * 
 * Program Element List: ArrayList, replaceAll(), try-catch, scanner, InputMismatchException, for loop, if-else, switch, ArrayList.get(), Arraylist.add(), .nextInt().toString().
 *
 * @author Will
 * @version 1/9/2024
 */



class MainConsole {

  // Instant variables - global variables
  public ArrayList<Classroom> classList = new ArrayList<Classroom>();
  public Classroom selectedClass;


  // Constructor for MainConsole
  public MainConsole() {
    // none
  } // End of consructor MainConsole


  /*
   * Summary: This method is the student menu after students logged in. Three choices are provided, and other methods will be called depending on the choice.
   * Parameter(s): studentID of type int, classroom of type Classroom, keyboardinput of type Scanner, panel of type JFrameClassroom.
   * Return(s): int
   */
  public int studentMain(int studentID, Classroom classroom, Scanner keyboardinput, JFrameClassroom panel) {
    int logout = 1;
    int error = 0;
    Student student = classroom.studentList.get(studentID);
    panel.studentPanel(student);

    while (logout > 0) { // Loop for student menu
      switch (student.getStudentMainMenu(keyboardinput)) { // Switch for student menu 
        case "1":
        case "print":
        case "transcript":
        case "printtranscript":
          clearScreen();
          classroom.printingTranscript(student);
          panel.printingTranscript(student);
          break;

        case "2":
        case "change":
        case "password":
        case "changepassword":
          clearScreen();  
          error = classroom.updatePassword(student, keyboardinput);
          panel.updatePassword(student);
          if (error >= 0) { // Notice the password has been changed without the error
            System.out.println("\n\nPassword successfully updated!");
          } // End of if statement
          break;

        case "3":
        case "logout":
        case "exit":
          clearScreen();
          logout = -1;
          break;
        default:
          System.out.println("Invalid input.");
          break;
      } // End of switch
    } // End of while loop
    return 0;
  } // End of studentMain method





  /*
   * Summary: This method is for menu for the classroom either can choose to get students' analysis and letter grade.
   * Parameter(s): teacher of type Teacher, classroom of type Classroom, keyboardinput of type Scanner, panel of type JFrameClassroom.
   * Return(s): int
   */
  public int teacherAction(Teacher teacher, Classroom classroom, Scanner keyboardinput, JFrameClassroom panel) {
    int back = 1;


    if (classroom.studentList.size() < 1) { // Error message for if there is no student in the classroom
      System.out.print("\nNo Students.");
      return -1;
    } // End of if statement

    while (back > 0) { // Loop for classroom menu
      switch (teacher.getTeacherActionMenu(keyboardinput)) { // Switch for classroom menu
        case "1":
        case "get":
        case "analysis":
        case "getanalysis":
        case "min":
        case "max":
        case "avg":
          clearScreen();
          classroom.analysisList(keyboardinput, panel);
          break;
        case "2":
        case "letter":
        case "grade":
        case "lettergrade":
          clearScreen();
          classroom.getLetterGrade(keyboardinput, panel);
          break;

        case "3":
        case "back":
        case "main":
          clearScreen();
          back = -1;
          panel.teacherPanel(classroom);
          break;

        default:
          System.out.println("Invalid input.");
          break;
      } // End of switch
    } // End of while loop
    return 0;
  } // End of teacherAction method




  /*
   * Summary: This method is for teacher menu where they can add/get/update/delete students to the classroom.
   * Parameter(s): classroom of type Classroom, keyboardinput of type Scanner, panel of type JFrameClassroom.
   * Return(s): int
   */
  public int teacherMain(Classroom classroom, Scanner keyboardinput, JFrameClassroom panel) {
    Teacher teacher = classroom.teacher;
    int logout = 1;
    int error = 0;



    while (logout > 0) { // Loop for teacher menu
      switch (teacher.getTeacherMainMenu(keyboardinput)) { // Switch for teacher menu
        case "1":
        case "add":
        case "addstudent":
          clearScreen();
          error = classroom.addStudent(keyboardinput, panel);
          if (error >= 0) { // Notice the student has been added without the error
              System.out.println("\n\nStudent added successfully!");
            } // End of if statement 
            break;

        case "2":
        case "get":
        case "getstudent":
        case "action":
          clearScreen();
          panel.showAllStudent(classroom);
          error = classroom.getStudents(keyboardinput);
          if (error >= 0) { // Sucessfully go into the analysis menu
            this.teacherAction(teacher, classroom, keyboardinput, panel);
          } // End of if statement
          break;

        case "3":
        case "update":
        case "updatestudent":
          clearScreen();
          error = classroom.updateStudent(keyboardinput, panel);
          if (error >= 0) { // Sucessfully update the student
            System.out.println("\n\nStudent updated successfully!");
          } // End of if statement
          break;

        case "4":
        case "delete":
        case "deletestudent":
          clearScreen();
          error = classroom.deleteStudent(keyboardinput, panel);
          if (error >= 0) { // Sucessfully remove the student
            System.out.println("\n\nStudent removed successfully!");
          } // End of if statement
          break;

        case "5":
        case "logout":
        case "exit":
          clearScreen();
          logout = -1;
          break;

        default:
          System.out.println("Invalid input.");
          break;
      } // End of switch
    } // End of while loop
    return 0;
  } // End of teacherMain method




  /*
   * Summary: This method is for menu where teacher/student log-in to their account
   * Parameter(s): classroom of type Classroom, keyboardinput of type Scanner
   * Return(s): int
   */
  public int login(Classroom classroom, Scanner keyboardinput) {
    int selectInt;
    String select;
    
    System.out.print("\n\n== Welcome to " + classroom.getClassName() + " Class ==");
    System.out.print("\n\n** Login Panel **");
    System.out.print("\n\n[1] Educator \n[2] Student \n[3] Exit \n\nEnter choice: ");
    
    try {
      select = keyboardinput.nextLine();
      select.replaceAll(" ", "").toLowerCase();
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      select = "error";
    }


    switch (select.toLowerCase()) { // Switch for login menu
      case "1":
      case "educator":
        System.out.print("Password : ");
        try {
          select = keyboardinput.nextLine();
          select.replaceAll(" ", "").toLowerCase();
        } catch (Exception e) {
          System.out.print("Wrong input. Please try again.\n\n");
          keyboardinput.next();
          select = "error";
        }
        if (select.equals(classroom.teacher.getPassword())) { // If the password is correct, go to the teacher menu
          System.out.println("\n**Welcome to the teacher main.**");
          return -1; // -1 : educator
        } else {
          System.out.print("Invalid Password");
          return -2;
        } // End of if/else statement
      case "2":
      case "student": // id : student
        System.out.print("Student ID : ");
        try {
          selectInt = keyboardinput.nextInt();
          keyboardinput.nextLine();
        } catch (Exception e) {
          System.out.print("Wrong input. Please try again.\n\n");
          keyboardinput.next();
          selectInt = -1;
        }
        for (int i = 0; i < classroom.studentList.size(); i++) { // Loop for checking the student id/pw
          if (selectInt == classroom.studentList.get(i).getID()) { // If the ID is correct, can write their password
            System.out.print("Password : ");
            try {
              select = keyboardinput.nextLine();
              select.replaceAll(" ", "").toLowerCase();
            } catch (Exception e) {
              System.out.print("Wrong input. Please try again.\n\n");
              keyboardinput.next();
              select = "error";
            }

            if (select.equals(classroom.studentList.get(i).getPassword())) { // If the password is correct, go to the student menu
              return classroom.studentList.get(i).getID();
            } else {
              System.out.print("Invalid Password");
              return -2;
            } // End of if/else statement
          } // End of if statement
        } // End of for loop
        System.out.print("Invalid ID");
        return -2;
      case "3":
      case "exit":
      default:
        return -3;
    } // End of switch
  } // End of login method




  /*
   * Summary: This method is for menu where they can add/select the class that they want to log-in
   * Parameter(s): keyboardinput of type Scanner
   * Return(s): int
   */
  public int selectClass(Scanner keyboardinput) {
    String select;
    int i;


    while (true) { // Loop for selecting the class
      System.out.println("\n\n** Select Class **");
      for (i = 0; i < this.classList.size(); i++) { // Loop for displaying the class list
        System.out.print("\n[" + this.classList.get(i).classID + "] " + this.classList.get(i).className);
      } // End of for loop

      System.out.print("\n[" + (this.classList.size() + 1) + "] Add Class");
      System.out.print("\n[" + (this.classList.size() + 2) + "] EXIT");
      System.out.print("\n\nEnter choice: ");

      try {
        select = keyboardinput.nextLine();
        select.replaceAll(" ", "").toLowerCase();
      } catch (Exception e) {
        System.out.print("Wrong input. Please try again.\n\n");
        keyboardinput.next();
        select = "error";
      }

      if (select.equals(Integer.toString(this.classList.size() + 2)) || select.equals("exit")) { // If the user want to exit
        return -2;
      } // End of if statement

      if (select.equals(Integer.toString(this.classList.size() + 1)) || select.equals("add") || select.equals("addclass")) { // If the user want to add a class
        Classroom newClass = new Classroom(this.classList.size(), keyboardinput);

        this.classList.add(newClass);
        return -1;
      } // End of if statement

      for (i = 0; i < this.classList.size(); i++) { // Loop for checking the class id
        if (select.equals(this.classList.get(i).getClassName().replaceAll(" ", "").toLowerCase()) || Integer.toString(this.classList.get(i).classID).equals(select)) { // If the class id is correct, go to the class menu
          selectedClass = this.classList.get(i);
          return 0;
        }
      } // End of for loop

      System.out.print("Invalid Input");
      return -1;
    } // End of while loop
  } // End of selectClass method





    /*
   * Summary: This function prints out the title of program.
   * Parameter(s): none.
   * Return(s): none.
   */
  public static void titleClass() {
    System.out.println("░██████╗░██████╗░░█████╗░██████╗░███████╗░██████╗░███████╗███╗░░██╗██╗██╗░░░██╗░██████╗");
    System.out.println("██╔════╝░██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔════╝░██╔════╝████╗░██║██║██║░░░██║██╔════╝");
    System.out.println("██║░░██╗░██████╔╝███████║██║░░██║█████╗░░██║░░██╗░█████╗░░██╔██╗██║██║██║░░░██║╚█████╗░");
    System.out.println("██║░░╚██╗██╔══██╗██╔══██║██║░░██║██╔══╝░░██║░░╚██╗██╔══╝░░██║╚████║██║██║░░░██║░╚═══██╗");
    System.out.println("╚██████╔╝██║░░██║██║░░██║██████╔╝███████╗╚██████╔╝███████╗██║░╚███║██║╚██████╔╝██████╔╝");
    System.out.println("░╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░╚══════╝░╚═════╝░╚══════╝╚═╝░░╚══╝╚═╝░╚═════╝░╚═════╝░");
  } // End of titleClass function





  /*
   * Summary: This function prints out the welcome message of the program
   * Parameter(s): none.
   * Return(s): none.
   */
  public static void welcomeMsg() {
    System.out.println("Welcome to GradeGenius!"); // prints out welcome message of the program
    System.out.println("Hey Teachers!! Do you want to auto-calculate students mark?");
    System.out.println("Hey Students!! Do you want to know your grade right away?");
    System.out.println(
        "Then, this is for you!! Come and sign up for GradeGenius, your life will change!!\nEnjoy!!");
  } // End of welcomeMsg function





  /*
   * Summary: This function prints out the introduction of the program
   * Parameter(s): none.
   * Return(s): none.
   */
  public static void introClass() {
    System.out.println("\t\n [Introduction] -------------------------\t"); // prints out the introduction of the
    System.out.println("\t\n GradeGenius is a program that helps you manage your classroom. \n");
    System.out.println("\t\n Teachers can add the classroom as many as they want and organize the students' grades\n");
    System.out.println("\t\n They can see their classes' min/max/average of the total students' grade\n");
    System.out.println("\t\n For students, they can see their transcript right away and know their current grade\n");
    System.out.println("\t\n Recommend looking at JFrame together while exploring this program\n");
    System.out.println("\t\n ***For This Version, THE SPACING IS NOT ALLOWED (E.G. AP CSA --> APCSA), I deeply appreciate your patience in advance.***\n");
  } // End of introClass function





  /*
   * Summary: This function prints out the explaination of the program.
   * Parameter(s): none.
   * Return(s): none.
   */
  public static void explainationClass() {
    System.out.println("\t\n [Direction] -------------------------\t"); // prints out the explaination of the program.
    System.out.println("\t\n If you as a teacher of classroom, login to teacher menu, or as a student, login to student menu with your ID and password \n");
    System.out.println("\t\n Teacher must give the students' default password before they can login to their account \n");
    System.out.println("\t\n Teacher can manage the students, add, remove, and edit the scores with analysis(min/max/avg) in the teacher menu\n");
    System.out.println("\t\n When teacher write the students' grade, please write range from 0-100 \n");
    System.out.println("\t\n Students can print their transcipt (on the console) and reset thier password in the student menu\n");
  } // End of explainationClass function





  /*
   * Summary: This function prints out the thank you message of the program.
   * Parameter(s): none.
   * Return(s): none.
   */
  public static void thanksMsg() {
    System.out.println("\nThank you for using GradeGenius"); // prints out the thank you message
    System.out.println("We hope you enjoy and make sure you using this application without any difficulty.");
    System.out.println("We look forward to welcoming you back again, We will give the comfortable service again.");
  } // End of thanksMsg function




  /*
   * Summary: This method can clear screen (on Blue J)
   * Parameter(s): none.
   * Return(s): void
   */
  public void clearScreen() {
    System.out.print('\u000C');
  } // End of clearScreen function




  /*
   * Summary: This is the main of the program
   * Parameter(s): String[] args
   * Return(s): void
   */
  public static void main(String[] args) {
    Scanner keyboardinput = new Scanner(System.in); // calling keyboardinput
    JFrameClassroom panel = new JFrameClassroom();
    MainConsole mainConsole = new MainConsole();
    int selected, userType;

    System.out.println("\f"); // clears the terminal
    System.out.flush(); // clears the keyboardinput

    titleClass();
    welcomeMsg();
    introClass();

    Classroom newclass = new Classroom(mainConsole.classList.size(), keyboardinput);

    mainConsole.classList.add(newclass);


    while (true) { // Loop for the main menu
      mainConsole.clearScreen();
      explainationClass();
      panel.classroomList(mainConsole.classList);
      selected = mainConsole.selectClass(keyboardinput);
      if (selected >= 0) { // If the user select a class
        mainConsole.clearScreen();
        while (true) { // Loop for the class menu
          userType = mainConsole.login(mainConsole.selectedClass, keyboardinput); 
          if (userType >= -1) { // If the user is a teacher or a student
            mainConsole.clearScreen();
            switch (userType) { // Switch for the user type
              case -1:
                mainConsole.teacherMain(mainConsole.selectedClass, keyboardinput, panel);
                break;
              default:
                mainConsole.studentMain(userType, mainConsole.selectedClass, keyboardinput, panel);
                break;
            } // End of switch statement
          } else if (userType == -3) {
            break;
          } else {
            continue;
          } // End of if/else if, and else statement
        } // End of while loop
      } else if (selected == -1) {
        continue;
      } else {
        break;
      } // End of if/else if, and else statement
    } // End of while loop

    mainConsole.clearScreen();
    thanksMsg();

    keyboardinput.close();
  } // End of main method
} // End of class mainconsole





/*
 * 
 * Notes:
 * Lets add login and password.
 * Clear screen on each menu.
 * Lets add letter grade.
 * Give students their ID automatically
 *
 * Test Code: 
 *   ArrayList<<ArrayList<Arraylist<String>>>> Classes = new ArrayList<<ArrayList<Arraylist<String>>>> // too confusing, lets use an arraylist of objects instead.
* 
* public Float getGrade(int studentID) {
*  if (gradeList.containsKey(studentID)) {
*     return gradeList.get(studentID);
*   } else {
     return null;
*   }
* }
*/