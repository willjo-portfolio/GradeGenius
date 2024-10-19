
import java.util.Scanner;

public class Teacher {

  // Member
  public String name;
  public String password;

  // Constructor

  public Teacher(Scanner keyboardinput) {
    String input;
    System.out.print("Enter teacher name: ");

    try {
      input = keyboardinput.nextLine();
      this.name = input;
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      return;
    }

    System.out.print("Enter teacher password: ");
    try {
      input = keyboardinput.nextLine();
      this.password = input;
    } catch (Exception e) {
      System.out.print("Wrong input. Please try again.\n\n");
      keyboardinput.next();
      return;
    }
  }

  // Method

  public String getTeacherActionMenu(Scanner keyboardinput) {
    System.out.println("\n\n<Teacher Action Menu>\n");
    System.out.println("[1] Get Analysis (Min Max Avg) \n[2] Letter Grade of All Students\n[3] Back to Main Menu");
    System.out.print("\nPlease select an option: ");
    String select;
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

  public String getTeacherMainMenu(Scanner keyboardinput) {
    System.out.println("\n\n<Teacher Main Menu>\n");
    System.out
        .println("[1] ADD Student \n[2] Get Students and Analysis\n[3] Update Student\n[4] Delete Student\n[5] Logout");
    System.out.print("\nPlease select an option: ");
    String select;
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

  public String getPassword() {
    return this.password;
  }
}
