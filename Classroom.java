import java.util.ArrayList;
import java.util.Scanner;

public class Classroom {

  // Members
  public int classID;
  public String className;
  public Teacher teacher;
  public ArrayList<Student> studentList = new ArrayList<Student>();
  public int maximumStudents = 30;

  // Constructor
  public Classroom(int classListSize, Scanner keyboardinput) {
    // Init Student
    Student newStudent = new Student(0, "Daniel", 9, "11111111", 84, 72, 88, 90);
    Student newStudent2 = new Student(1, "Kelly", 11, "22222222", 92, 99.5, 83, 100);
    Student newStudent3 = new Student(2, "John", 10, "33333333", 73.5, 98, 84.9, 93);
    
    this.classID = classListSize+1;
    System.out.print("\nClass name: ");
    try {
      this.className = keyboardinput.nextLine();
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      return;
    }

    System.out.print("Class maximum students: ");
    try {
      this.maximumStudents = keyboardinput.nextInt();
        keyboardinput.nextLine();
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      return;
    }

    Teacher teacher = new Teacher(keyboardinput);
    this.teacher = teacher;


    this.studentList.add(newStudent);
    this.studentList.add(newStudent2);
    this.studentList.add(newStudent3);
  }

  // Editing Methods. Student use only.
  public void printingTranscript(Student student) {
    System.out.print("ID");
    System.out.print("\t\tName");
    System.out.print("\t\tProject");
    System.out.print("\t\tAssignment");
    System.out.print("\t\tTerm 1");
    System.out.print("\t\tTerm 2");

    student.printTranscript();
    System.out.print("\n" + student.studentID);
    System.out.print("\t\t" + student.studentName);
    System.out.print("\t\t\t" + this.getLetter(student.score.get(0)));
    System.out.print("\t\t\t" + this.getLetter(student.score.get(1)));
    System.out.print("\t\t\t\t" + this.getLetter(student.score.get(2)));
    System.out.println("\t\t\t" + this.getLetter(student.score.get(3)));
    System.out.print("---------------------------------------------------------------------------------------");
  }

  public int updatePassword(Student student, Scanner keyboardinput) {
    System.out.println("Enter current password: ");
    String passwordInput;
    try {
      passwordInput = keyboardinput.nextLine();
      passwordInput.replaceAll(" ", "").toLowerCase();
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      passwordInput = "error";
    }

    if (student.password.equals(passwordInput)) {
      System.out.println("Enter New Password: ");
      try {
        passwordInput = keyboardinput.nextLine();
        passwordInput.replaceAll(" ", "").toLowerCase();
      } catch (Exception e) {
        System.out.print("Wrong input. Please try again.\n\n");
        keyboardinput.next();
        passwordInput = "error";
      }
      System.out.println("Enter Password Again for Validation: ");
      String passwordInputAgain;
      try {
        passwordInputAgain = keyboardinput.nextLine();
        passwordInputAgain.replaceAll(" ", "").toLowerCase();
      } catch (Exception e) {
        System.out.print("Wrong input. Please try again.\n\n");
        keyboardinput.next();
        passwordInputAgain = "error";
      }
      if (passwordInput.equals(passwordInputAgain)) {
        student.password = passwordInput;
        return 0;
      } else {
        System.out.println("Passwords do not match.");
        return -1;
      }
    } else {
      System.out.println("Incorrect password.");
      return -1;
    }
  }

  // Editing Methods. Teacher use only.
  public void getLetterGrade(Scanner keyboardinput, JFrameClassroom panel) {
    String select, studentSelected;
    System.out.println("\n\n<Letter Grade>\n");
    System.out.println("[1] Get All \n[2] Pick a Student");
    System.out.print("\nPlease select an option: ");

    try {
      select = keyboardinput.nextLine();
      select.replaceAll(" ", "").toLowerCase();
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      select = "error";
    }

    switch (select) {
      case "1":
      case "all":
      case "getall":
        this.getLetterGrageOfAll();
        panel.showLetterGradeOfAll(studentList, className);
        break;
      case "2":
      case "pick":
      case "student":
      case "pickstudent":
      case "pickastudent":
        System.out.print("\nPlease enter the student's ID or Name: ");
        try {
          studentSelected = keyboardinput.nextLine();
          studentSelected.replaceAll(" ", "").toLowerCase();
        } catch (Exception e) {
          System.out.print("Wrong input. Please try again.\n\n");
          keyboardinput.next();
          studentSelected = "error";
        }
    
        int error = this.getLetterGrageOfStudent(studentSelected, panel);
        if (error < 0) {
          System.out.println("Student not found.");
        }
        break;
      default:
        break;
    }
  }

  public void analysisList(Scanner keyboardinput, JFrameClassroom panel) {
    String select;

    System.out.println("\n\n<Analysis>\n");
    System.out.println("[1] Get Average \n[2] Get Minimums\n[3] Get Maximums");
    System.out.print("\nPlease select an option: ");

    try {
      select = keyboardinput.nextLine();
      select.replaceAll(" ", "").toLowerCase();
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      select = "error";
    }

    switch (select) {
      case "1":
      case "avg":
      case "average":
      case "getavg":
      case "getaverage":
        this.getAvgOfAll(panel);
        break;
      case "2":
      case "min":
      case "minimum":
      case "getmin":
      case "getminimum":
        this.getMinOfAll(panel);
        break;
      case "3":
      case "max":
      case "maximum":
      case "getmax":
      case "getmaximum":
        this.getMaxOfAll(panel);
        break;
      default:
        break;
    }
    ;
  }

  public int getStudents(Scanner keyboardinput) {
    
    if (studentList.size() < 1) {
      System.out.print("\nNo Students.");
      return -1;
    }

    System.out.println("Student List : \n");
    System.out.print("ID");
    System.out.print("\t\tName");
    System.out.print("\t\t\tGrade");
    System.out.print("\t\tProject");
    System.out.print("\t\tAssignment");
    System.out.print("\t\tTerm 1");
    System.out.print("\t\tTerm 2");

    for (int i = 0; i < studentList.size(); i++) {
      studentList.get(i).printStudent("all");
    }
    return 0;
  }

  public int deleteStudent(Scanner keyboardinput, JFrameClassroom panel) {
    getStudents(keyboardinput);
    System.out.print("\nEnter Student Name or ID to delete: ");
    String name ;

    try {
      name = keyboardinput.nextLine();
      name.replaceAll(" ", "").toLowerCase();
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      name = "error";
    }

    for (int i = 0; i < studentList.size(); i++) {
      if (name.equals(studentList.get(i).getName().replaceAll(" ", "").toLowerCase())
          || Integer.toString(studentList.get(i).studentID).equals(name)) {
        studentList.get(i).printStudent("single");
        panel.showDeletedStudent(studentList.get(i));
        studentList.remove(i);
        return 0;
      }
    }
    System.out.print("\nStudent Not Found.");
    return -1;
  }

  public int updateStudent(Scanner keyboardinput, JFrameClassroom panel) {
    getStudents(keyboardinput);
    String name;
    int selectedStudentIndex = -1;

    System.out.print("\nEnter Student Name or ID to update: ");

    try {
      name = keyboardinput.nextLine();
      name.replaceAll(" ", "").toLowerCase();
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      name = "error";
    }


    for (int i = 0; i < studentList.size(); i++) {
      if (name.equals(studentList.get(i).getName().replaceAll(" ", "").toLowerCase())
          || Integer.toString(studentList.get(i).studentID).equals(name)) {
        selectedStudentIndex = i;
      }
    }

    if (selectedStudentIndex >= 0) {
      System.out.print("\nEnter Student new Grade (8 to 12): ");
      int grade;
      try {
        grade = keyboardinput.nextInt();
        keyboardinput.nextLine();
      } catch (Exception e) {
        System.out.print("Wrong input. Please try again.\n\n");
        keyboardinput.next();
        return -1;
      }

      if (grade < 8 || grade > 12) {
        System.out.println("\nInvalid Grade");
        return -1;
      }

      System.out.print("\nProject Score (0 to 100): ");
      double projectScore;
      try {
        projectScore = getDouble(keyboardinput);
      } catch (Exception e) {
        System.out.print("Wrong input. Please try again.\n\n");
        keyboardinput.next();
        return -1;
      }
      if (projectScore < 0 || projectScore > 100) {
        System.out.println("\nInvalid Grade");
        return -1;
      }

      System.out.print("\nAssignment Score (0 to 100): ");
      double assignmentScore;
      try {
        assignmentScore = getDouble(keyboardinput);
      } catch (Exception e) {
        System.out.print("Wrong input. Please try again.\n\n");
        keyboardinput.next();
        return -1;
      }
      if (assignmentScore < 0 || assignmentScore > 100) {
        System.out.println("\nInvalid Grade");
        return -1;
      }

      System.out.print("\nTerm 1 Score (0 to 100): ");
      double termOne;
      try {
        termOne = getDouble(keyboardinput);
      } catch (Exception e) {
        System.out.print("Wrong input. Please try again.\n\n");
        keyboardinput.next();
        return -1;
      }
      if (termOne < 0 || termOne > 100) {
        System.out.println("\nInvalid Grade");
        return -1;
      }

      System.out.print("\nTerm 2 Score (0 to 100): ");
      double termTwo;
      try {
        termTwo = getDouble(keyboardinput);
      } catch (Exception e) {
        System.out.print("Wrong input. Please try again.\n\n");
        keyboardinput.next();
        return -1;
      }
      if (termTwo < 0 || termTwo > 100) {
        System.out.println("\nInvalid Grade");
        return -1;
      }

      studentList.get(selectedStudentIndex).grade = grade;
      studentList.get(selectedStudentIndex).score.set(0, projectScore);
      studentList.get(selectedStudentIndex).score.set(1, assignmentScore);
      studentList.get(selectedStudentIndex).score.set(2, termOne);
      studentList.get(selectedStudentIndex).score.set(3, termTwo);

      panel.showUpdatedStudent(studentList.get(selectedStudentIndex));
      return 0;
    } else {
      System.out.print("\nStudent Not Found.");
      return -1;
    }
  }

  public int addStudent(Scanner keyboardinput, JFrameClassroom panel) {
    String userAnswer, password, name;
    int studentID, grade, i;
    double projectScore, assignmentScore, termOne, termTwo;
    Student newStudent;
    boolean nowInput = true;

    if (studentList.size() > maximumStudents) {
      System.out.print("\nMaximum Students Reached.");
      return -1;
    }

    studentID = studentList.size();
    System.out.print("\nEnter Student Name: ");

    try {
      name = keyboardinput.nextLine();
      name.replaceAll(" ", "").toLowerCase();
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      name = "error";
    }

    if (studentList.size() > 0) {
      for (i = 0; i < studentList.size(); i++) {
        if (name.equals(studentList.get(i).getName())) {
          System.out.println("\nStudent already exists");
          return -1;
        }
      }
    }

    System.out.print("\nEnter Student Grade (8 to 12): ");
    try {
      grade = keyboardinput.nextInt();
        keyboardinput.nextLine();
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      return -1;
    }


    if (grade < 8 || grade > 12) {
      System.out.println("\nInvalid Grade");
      return -1;
    }

    System.out.print("\nSet Student Default Password: ");
    try {
      password = keyboardinput.nextLine();
      password.replaceAll(" ", "").toLowerCase();
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      password = "error";
    }

    System.out.print("\nDo you wish to enter the student's score now?(Y/N): ");
    try {
      userAnswer = keyboardinput.nextLine();
      userAnswer.replaceAll(" ", "").toLowerCase();
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      userAnswer = "n";
    }
    

    if (userAnswer.equals("n") || userAnswer.equals("no")) {
      System.out.print("\nStudent's marks are setted to zero, you can update them later.");
      nowInput = false;
    } 

    System.out.print(nowInput ? "\nProject Score (0 to 100): " : "");
    projectScore = nowInput ? getDouble(keyboardinput) : 0;
    if (projectScore < 0 || projectScore > 100) {
      System.out.println("\nInvalid Grade");
      return -1;
    }

    System.out.print(nowInput ? "\nAssignment Score (0 to 100): " : "");
    assignmentScore = nowInput ? getDouble(keyboardinput)  : 0;
    if (assignmentScore < 0 || assignmentScore > 100) {
      System.out.println("\nInvalid Grade");
      return -1;
    }

    System.out.print(nowInput ? "\nTerm 1 Score (0 to 100): " : "");
    termOne = nowInput ? getDouble(keyboardinput)  : 0;
    if (termOne < 0 || termOne > 100) {
      System.out.println("\nInvalid Grade");
      return -1;
    }

    System.out.print(nowInput ? "\nTerm 2 Score (0 to 100): " : "");
    termTwo = nowInput ? getDouble(keyboardinput)  : 0;
    if (termTwo < 0 || termTwo > 100) {
      System.out.println("\nInvalid Grade");
      return -1;
    }

    newStudent = new Student(studentID, name, grade, password, projectScore, assignmentScore, termOne,
        termTwo);
    studentList.add(newStudent);
    panel.showAddedStudent(newStudent);
    studentList.get(studentList.size() - 1).printStudent("single");
    return 0;
  }

  private Double getDouble(Scanner keyboardinput) {
    Double input;

    try {
      input = keyboardinput.nextDouble();
      keyboardinput.nextLine();
      return input;
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      return -1.0;
    }
  }

  // Just use in Classroom Class
  private void getAvgOfAll(JFrameClassroom panel) {
    double sumProject = 0, sumAssignment = 0, sumTermOne = 0, sumTermTwo = 0;
    for (int i = 0; i < studentList.size(); i++) {
      sumProject += studentList.get(i).score.get(0);
      sumAssignment += studentList.get(i).score.get(1);
      sumTermOne += studentList.get(i).score.get(2);
      sumTermTwo += studentList.get(i).score.get(3);
    }
    System.out.println("\nAverage Project Score: " + sumProject / studentList.size());
    System.out.println("Average Assignment Score: " + sumAssignment / studentList.size());
    System.out.println("Average Term 1 Score: " + sumTermOne / studentList.size());
    System.out.println("Average Term 2 Score: " + sumTermTwo / studentList.size());

    panel.showAvgOfAll(sumProject / studentList.size(), sumAssignment / studentList.size(), sumTermOne / studentList.size(), sumTermTwo / studentList.size(), className);
  }

  private void getMinOfAll(JFrameClassroom panel) {
    int minStudentIndex = 0;
    ArrayList<Integer> minStudentIds = new ArrayList<Integer>();
    ArrayList<Double> minScores = new ArrayList<Double>();

    for (int j = 0; j < 4; j++) {
      double min = studentList.get(0).score.get(j);
      for (int i = 0; i < studentList.size(); i++) {
        if (studentList.get(i).score.get(j) < min) {
          minStudentIndex = i;
        }
      }
      switch (j) {
        case 0:
          System.out.print("\nMinimum Project Score");
          System.out.print("\tStudent Name: " + studentList.get(minStudentIndex).studentName);
          System.out.print("\tScore: " + min);
          minStudentIds.add(minStudentIndex);
          minScores.add(min);
          break;
        case 1:
          System.out.print("\nMinimum Assignment Score");
          System.out.print("\tStudent Name: " + studentList.get(minStudentIndex).studentName);
          System.out.print("\tScore: " + min);
          minStudentIds.add(minStudentIndex);
          minScores.add(min);
          break;
        case 2:
          System.out.print("\nMinimum Term 1 Score");
          System.out.print("\tStudent Name: " + studentList.get(minStudentIndex).studentName);
          System.out.print("\tScore: " + min);
          minStudentIds.add(minStudentIndex);
          minScores.add(min);
          break;
        case 3:
          System.out.print("\nMinimum Term 2 Score");
          System.out.print("\tStudent Name: " + studentList.get(minStudentIndex).studentName);
          System.out.print("\tScore: " + min);
          minStudentIds.add(minStudentIndex);
          minScores.add(min);
          break;
        default:
          break;
      }
    }
    panel.showMinAll(studentList, minStudentIds, minScores, className);
  }

  private void getMaxOfAll(JFrameClassroom panel) {
    int maxStudentIndex = 0;
    ArrayList<Integer> maxStudentIds = new ArrayList<Integer>();
    ArrayList<Double> maxScores = new ArrayList<Double>();

    for (int j = 0; j < 4; j++) {
      double max = studentList.get(0).score.get(j);
      for (int i = 0; i < studentList.size(); i++) {
        if (studentList.get(i).score.get(j) >= max) {
          maxStudentIndex = i;
        }
      }
      switch (j) {
        case 0:
          System.out.print("\nMinimum Project Score");
          System.out.print("\tStudent Name: " + studentList.get(maxStudentIndex).studentName);
          System.out.print("\tScore: " + max);
          maxStudentIds.add(maxStudentIndex);
          maxScores.add(max);
          break;
        case 1:
          System.out.print("\nMinimum Assignment Score");
          System.out.print("\tStudent Name: " + studentList.get(maxStudentIndex).studentName);
          System.out.print("\tScore: " + max);
          maxStudentIds.add(maxStudentIndex);
          maxScores.add(max);
          break;
        case 2:
          System.out.print("\nMinimum Term 1 Score");
          System.out.print("\tStudent Name: " + studentList.get(maxStudentIndex).studentName);
          System.out.print("\tScore: " + max);
          maxStudentIds.add(maxStudentIndex);
          maxScores.add(max);
          break;
        case 3:
          System.out.print("\nMinimum Term 2 Score");
          System.out.print("\tStudent Name: " + studentList.get(maxStudentIndex).studentName);
          System.out.print("\tScore: " + max);
          maxStudentIds.add(maxStudentIndex);
          maxScores.add(max);
          break;
        default:
          break;
      }
    }
    panel.showMaxAll(studentList, maxStudentIds, maxScores, className);
  }

  private void getLetterGrageOfAll() {

    System.out.println("Student Letter Grage List : \n");
    System.out.print("ID");
    System.out.print("\t\tName");
    System.out.print("\t\tProject");
    System.out.print("\t\tAssignment");
    System.out.print("\t\tTerm 1");
    System.out.print("\t\tTerm 2");

    for (int i = 0; i < studentList.size(); i++) {
      System.out.print("\n" + studentList.get(i).studentID);
      System.out.print("\t\t" + studentList.get(i).studentName);
      System.out.print("\t\t\t" + this.getLetter(studentList.get(i).score.get(0)));
      System.out.print("\t\t\t" + this.getLetter(studentList.get(i).score.get(1)));
      System.out.print("\t\t\t\t" + this.getLetter(studentList.get(i).score.get(2)));
      System.out.println("\t\t\t" + this.getLetter(studentList.get(i).score.get(3)));
      System.out.print("---------------------------------------------------------------------------------------");
    }
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

  private int getLetterGrageOfStudent(String selectedStudent, JFrameClassroom panel) {
    for (int i = 0; i < studentList.size(); i++) {
      if (studentList.get(i).studentName.replaceAll(" ", "").toLowerCase().equals(selectedStudent)
          || Integer.toString(studentList.get(i).studentID).equals(selectedStudent)) {
            panel.showLetterGradeOfStudent(studentList.get(i));
        System.out.print("ID");
        System.out.print("\t\tName");
        System.out.print("\t\tProject");
        System.out.print("\t\tAssignment");
        System.out.print("\t\tTerm 1");
        System.out.print("\t\tTerm 2");

        System.out.print("\n" + studentList.get(i).studentID);
        System.out.print("\t\t" + studentList.get(i).studentName);
        System.out.print("\t\t\t" + this.getLetter(studentList.get(i).score.get(0)));
        System.out.print("\t\t\t" + this.getLetter(studentList.get(i).score.get(1)));
        System.out.print("\t\t\t\t" + this.getLetter(studentList.get(i).score.get(2)));
        System.out.println("\t\t\t" + this.getLetter(studentList.get(i).score.get(3)));
        System.out.print("---------------------------------------------------------------------------------------");
        return 0;
      }
    }
    return -1;
  }

  public String getClassName() {
    return className;
  }

  public Teacher getTeacher() {
    return teacher;
  }
}
