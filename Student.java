
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
  public ArrayList<Integer> classrooms;
  public int studentID;
  public String studentName;
  public int grade;
  public String password;

  public ArrayList<Double> score = new ArrayList<Double>();

  public Student(int studentID, String studentName, int grade, String password, double projectScore,
      double assignmentScore, double termOne, double termTwo) {
    this.studentID = studentID;
    this.studentName = studentName;
    this.grade = grade;
    this.password = password;
    this.score.add(projectScore);
    this.score.add(assignmentScore);
    this.score.add(termOne);
    this.score.add(termTwo);
  }

  public void printTranscript() {
    System.out.print("\n" + studentID);
    System.out.print("\t\t" + studentName);
    System.out.print("\t\t\t" + score.get(0));
    System.out.print("\t\t\t" + score.get(1));
    System.out.print("\t\t\t\t" + score.get(2));
    System.out.println("\t\t\t" + score.get(3));
    System.out.print("---------------------------------------------------------------------------------------");
  }
  
  public void printStudent(String type) {
    if (!type.equals("all")) {
      System.out.println("Student List : \n");
      System.out.print("ID");
      System.out.print("\t\tName");
      System.out.print("\t\t\tGrade");
      System.out.print("\t\tProject");
      System.out.print("\t\tAssignment");
      System.out.print("\t\tTerm 1");
      System.out.print("\t\tTerm 2");
    }
    System.out.print("\n" + studentID);
    System.out.print("\t\t" + studentName);
    System.out.print("\t\t\t" + grade);
    System.out.print("\t\t" + score.get(0));
    System.out.print("\t\t\t" + score.get(1));
    System.out.print("\t\t\t" + score.get(2));
    System.out.println("\t\t" + score.get(3));
    System.out.print("---------------------------------------------------------------------------------------");
  }

  public int getID() {
    return this.studentID;
  }

  public String getPassword() {
    return this.password;
  }

  public String getName() {
    return this.studentName;
  }

  public double getAvgOfAll() {
    double sum = 0;
    for (int i = 0; i < score.size(); i++) {
      sum += score.get(i);
    }
    return sum / score.size();
  }

  public String getStudentMainMenu(Scanner keyboardinput) {
    String select;
    
    System.out.println("\n\n<Student Main Menu>\n");
    System.out
        .println("[1] Print Transcript \n[2] Change Password\n[3] Logout");
    System.out.print("\nPlease select an option: ");
    try {
      select = keyboardinput.nextLine();
      select.replaceAll(" ", "").toLowerCase();
      return select;
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      return "error";
    }
  }
}
