//Import statement
import java.util.ArrayList;
import javax.swing.*; // JFrame
// import javax.swing.event.DocumentListener;
// import javax.swing.text.Document;
// import javax.swing.event.DocumentEvent;

import java.awt.*;
// import java.net.URI;
// import java.net.URISyntaxException;
// import java.io.IOException;

public class JFrameClassroom {

  // Member

  static JFrame frame = new JFrame("Assignment 6 Classroom");
  static JPanel mainHeader = new JPanel();
  static JPanel mainBody = new JPanel();
  static JLabel headerTitle = new JLabel("Sign in Console :)");
  static JLabel userName = new JLabel("Corrent User : ");
  static JLabel classroomName = new JLabel("Classroom");

  static String studentTableHeader = "<html><br><br><table><tr><th>ID</th><th>Name</th><th>Grade</th><th>Project</th><th>Assignment</th><th>Term 1</th><th>Term 2</th></tr>";
  static String LetterHeader = "<html><br><br><table><tr><th>ID</th><th>Name</th><th>Project</th><th>Assignment</th><th>Term 1</th><th>Term 2</th></tr>";
  static String averageHeader = "<html><br><br><table><tr><th>Project</th><th>Assignment</th><th>Term 1</th><th>Term 2</th></tr>";
  static String minmaxHeader = "<html><br><br><table><tr><th>Student ID</th><th>Stucent Name</th><th>Test Type</th><th>Score</th></tr>";

  // Constructor

  public JFrameClassroom() {
    // JFrameContinents jframeContinents = new JFrameContinents();
    
    frame.setSize(300, 300);
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    mainHeader.add(headerTitle);
    
    
    frame.add(mainHeader, BorderLayout.NORTH);
    frame.add(mainBody, BorderLayout.CENTER);
    frame.setVisible(true);
  }

  public void classroomList(ArrayList<Classroom> classList) {
    frame.setSize(500, 300);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>Classroom List</h1></html>");
    mainHeader.add(title);
    String body = "<html><br><br>";
    for(int i = 0; i < classList.size(); i++) {
      body += "<h3>" + classList.get(i).className+"</h3><br>";
    }
    String footer = "</html>";
    JLabel showBody = new JLabel(body + footer);
      mainBody.add(showBody);
    SwingUtilities.updateComponentTreeUI(frame);
  }

  public void teacherPanel(Classroom classroom) {
    frame.setSize(500, 200);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>Hello, " + classroom.teacher.name + " Teacher !</h1></html>");
    mainHeader.add(title);

    SwingUtilities.updateComponentTreeUI(frame);
  }

  public void showAllStudent(Classroom classroom) {
    frame.setSize(500, 500);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>" + classroom.className + " Student List</h1></html>");
    mainHeader.add(title);
    String body = studentTableHeader;
    for(int i = 0; i < classroom.studentList.size(); i++) {
      body += "<tr><td>" + classroom.studentList.get(i).studentID+"</td>";
      body += "<td>" + classroom.studentList.get(i).studentName+"</td>";
      body += "<td>" + classroom.studentList.get(i).grade+"</td>";
      body += "<td>" + classroom.studentList.get(i).score.get(0)+"</td>";
      body += "<td>" + classroom.studentList.get(i).score.get(1)+"</td>";
      body += "<td>" + classroom.studentList.get(i).score.get(2)+"</td>";
      body += "<td>" + classroom.studentList.get(i).score.get(3)+"</td></tr>";
    }
    String footer = "</table></html>";
    JLabel showBody = new JLabel(body + footer);
    mainBody.add(showBody);
    SwingUtilities.updateComponentTreeUI(frame);
  }

  public void showAddedStudent(Student student) {
    frame.setSize(500, 300);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>Student Added Successfully</h1></html>");
    mainHeader.add(title);
    String body = studentTableHeader;
      body += "<tr><td>" + student.studentID+"</td>";
      body += "<td>" + student.studentName+"</td>";
      body += "<td>" + student.grade+"</td>";
      body += "<td>" + student.score.get(0)+"</td>";
      body += "<td>" + student.score.get(1)+"</td>";
      body += "<td>" + student.score.get(2)+"</td>";
      body += "<td>" + student.score.get(3)+"</td></tr>";
    String footer = "</table></html>";
    JLabel showBody = new JLabel(body + footer);
    mainBody.add(showBody);
    SwingUtilities.updateComponentTreeUI(frame);
  }

  public void showDeletedStudent(Student student) {
    frame.setSize(500, 300);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>Student Deleted Successfully</h1></html>");
    mainHeader.add(title);
    String body = studentTableHeader;
      body += "<tr><td>" + student.studentID+"</td>";
      body += "<td>" + student.studentName+"</td>";
      body += "<td>" + student.grade+"</td>";
      body += "<td>" + student.score.get(0)+"</td>";
      body += "<td>" + student.score.get(1)+"</td>";
      body += "<td>" + student.score.get(2)+"</td>";
      body += "<td>" + student.score.get(3)+"</td></tr>";
    String footer = "</table></html>";
    JLabel showBody = new JLabel(body + footer);
    mainBody.add(showBody);
    SwingUtilities.updateComponentTreeUI(frame);
  }

  public void showUpdatedStudent(Student student) {
    frame.setSize(500, 300);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>Student Updated Successfully</h1></html>");
    mainHeader.add(title);
    String body = studentTableHeader;
      body += "<tr><td>" + student.studentID+"</td>";
      body += "<td>" + student.studentName+"</td>";
      body += "<td>" + student.grade+"</td>";
      body += "<td>" + student.score.get(0)+"</td>";
      body += "<td>" + student.score.get(1)+"</td>";
      body += "<td>" + student.score.get(2)+"</td>";
      body += "<td>" + student.score.get(3)+"</td></tr>";
    String footer = "</table></html>";
    JLabel showBody = new JLabel(body + footer);
    mainBody.add(showBody);
    SwingUtilities.updateComponentTreeUI(frame);
  }

  public void showAvgOfAll(Double project,Double assignment,Double termOne,Double termTwo, String classroomName) {
    frame.setSize(500, 300);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>" + classroomName + " Student Score Averages</h1></html>");
    mainHeader.add(title);
    String body = averageHeader;
      body += "<tr><td>" + project + "</td>";
      body += "<td>" + assignment + "</td>";
      body += "<td>" + termOne + "</td>";
      body += "<td>" + termTwo + "</td></tr>";
    String footer = "</table></html>";
    JLabel showBody = new JLabel(body + footer);
    mainBody.add(showBody);
    SwingUtilities.updateComponentTreeUI(frame);
  }

  public void showMinAll(ArrayList<Student> studentList, ArrayList<Integer> minStudentIds, ArrayList<Double> minScores, String classroomName) {
    ArrayList<String> testType = new ArrayList<String>();
    testType.add("Project");
    testType.add("Assignment");
    testType.add("Term 1");
    testType.add("Term 2");
    frame.setSize(500, 300);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>" + classroomName + " Class Student Minimum Scores</h1></html>");
    mainHeader.add(title);
    String body = minmaxHeader;
    for(int i = 0; i < studentList.size(); i++){
      body += "<tr><td>" + studentList.get(minStudentIds.get(i)).studentID + "</td>";
      body += "<td>" + studentList.get(minStudentIds.get(i)).studentName + "</td>";
      body += "<td>" + testType.get(i) + "</td>";
      body += "<td>" + minScores.get(i) + "</td></tr>";
    }
    String footer = "</table></html>";
    JLabel showBody = new JLabel(body + footer);
    mainBody.add(showBody);
    SwingUtilities.updateComponentTreeUI(frame);
  }

  public void showMaxAll(ArrayList<Student> studentList, ArrayList<Integer> maxStudentIds, ArrayList<Double> maxScores, String classroomName) {
    ArrayList<String> testType = new ArrayList<String>();
    testType.add("Project");
    testType.add("Assignment");
    testType.add("Term 1");
    testType.add("Term 2");
    frame.setSize(500, 300);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>" + classroomName + " Class Student Minimum Scores</h1></html>");
    mainHeader.add(title);
    String body = minmaxHeader;
    for(int i = 0; i < studentList.size(); i++){
      body += "<tr><td>" + studentList.get(maxStudentIds.get(i)).studentID + "</td>";
      body += "<td>" + studentList.get(maxStudentIds.get(i)).studentName + "</td>";
      body += "<td>" + testType.get(i) + "</td>";
      body += "<td>" + maxScores.get(i) + "</td></tr>";
    }
    String footer = "</table></html>";
    JLabel showBody = new JLabel(body + footer);
    mainBody.add(showBody);
    SwingUtilities.updateComponentTreeUI(frame);
  }

  public void showLetterGradeOfStudent(Student student) {
    frame.setSize(500, 300);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>" + student.studentName + "'s Letter Grades</h1></html>");
    mainHeader.add(title);
    String body = LetterHeader;
      body += "<tr><td>" + student.studentID+"</td>";
      body += "<td>" + student.studentName+"</td>";
      body += "<td>" + this.getLetter(student.score.get(0))+"</td>";
      body += "<td>" + this.getLetter(student.score.get(1))+"</td>";
      body += "<td>" + this.getLetter(student.score.get(2))+"</td>";
      body += "<td>" + this.getLetter(student.score.get(3))+"</td></tr>";
    String footer = "</table></html>";
    JLabel showBody = new JLabel(body + footer);
    mainBody.add(showBody);
    SwingUtilities.updateComponentTreeUI(frame);
  }

  public void showLetterGradeOfAll(ArrayList<Student> studentList, String classroomName) {
    frame.setSize(500, 500);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>" + classroomName + " Class Students Letter Grades</h1></html>");
    mainHeader.add(title);
    String body = LetterHeader;
    for(int i = 0; i < studentList.size(); i++){
      body += "<tr><td>" + studentList.get(i).studentID + "</td>";
      body += "<td>" + studentList.get(i).studentName + "</td>";
      body += "<td>" + this.getLetter(studentList.get(i).score.get(0))+"</td>";
      body += "<td>" + this.getLetter(studentList.get(i).score.get(1))+"</td>";
      body += "<td>" + this.getLetter(studentList.get(i).score.get(2))+"</td>";
      body += "<td>" + this.getLetter(studentList.get(i).score.get(3))+"</td></tr>";
    }
    String footer = "</table></html>";
    JLabel showBody = new JLabel(body + footer);
    mainBody.add(showBody);
    SwingUtilities.updateComponentTreeUI(frame);
  }

  private String getLetter(double grade) {
    // double avg = studentList.get(i).getAvgOfAll();
    if (grade >= 96) {
      return "A+";
    } else if (grade >= 93) {
      return "A";
    } else if (grade >= 90) {
      return "A-";
    } else if (grade >= 86) {
      return "B+";
    } else if (grade >= 80) {
      return "B";
    } else if (grade >= 76) {
      return "B-";
    } else if (grade >= 67) {
      return "C+";
    } else if (grade >= 60) {
      return "C";
    } else if (grade >= 50) {
      return "C-";
    } else {
      return "F";
    }
  }

  public void studentPanel(Student student) {
    frame.setSize(500, 200);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>Hello, " + student.studentName + " !</h1></html>");
    mainHeader.add(title);

    SwingUtilities.updateComponentTreeUI(frame);
  }

  public void printingTranscript(Student student){
    frame.setSize(500, 300);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>" + student.studentName + "'s Transcript</h1></html>");
    mainHeader.add(title);
    String body = LetterHeader;
      body += "<tr><td>" + student.studentID+"</td>";
      body += "<td>" + student.studentName+"</td>";
      body += "<td>" + student.score.get(0)+"</td>";
      body += "<td>" + student.score.get(1)+"</td>";
      body += "<td>" + student.score.get(2)+"</td>";
      body += "<td>" + student.score.get(3)+"</td></tr>";
      body += "<tr><td>" + "" + "</td>";
      body += "<td>" + "" + "</td>";
      body += "<td>" + this.getLetter(student.score.get(0))+"</td>";
      body += "<td>" + this.getLetter(student.score.get(1))+"</td>";
      body += "<td>" + this.getLetter(student.score.get(2))+"</td>";
      body += "<td>" + this.getLetter(student.score.get(3))+"</td></tr>";
    String footer = "</table></html>";
    JLabel showBody = new JLabel(body + footer);
    mainBody.add(showBody);
    SwingUtilities.updateComponentTreeUI(frame);
  }

  public void updatePassword(Student student) {
    frame.setSize(500, 200);
    mainHeader.removeAll();
    mainBody.removeAll();
    JLabel title = new JLabel("<html><h1>" + student.studentName + "'s Password <br>Changed Successfully !</h1></html>");
    mainHeader.add(title);

    SwingUtilities.updateComponentTreeUI(frame);
  }
}
