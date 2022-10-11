import java.util.Scanner;

/**
 * This program contains methods that print out a lot of text. These methods are separate from the main method so that if any similar games are made in the future, these methods can be called.
 */
public class StageMethods {
  private Scanner scanner = new Scanner(System.in);

  /**
   * Records the player's name
   * @return the player's name
   */
  public String enterName() {
    System.out.print("Please enter your name: ");
    String name = scanner.next();
    System.out.println("\nHello, " + name + ", let us begin...");
    scanner.nextLine();
    scanner.nextLine();
    System.out.print("\n\n");
    return name;
  }

  /**
   * Counts spaces in a String and returns them. Used when the dialogue line is
   * too long and needs to start on the next line.
   * 
   * @param a String that is not full of spaces, or in this game, a name
   * @return a String with the same number of charactes but they are all spaces
   */
  public String nameSpaces(String n) {
    String spaces = "";
    for (int i = 0; i < n.length() - 1; i++) {
      spaces += " ";
    }
    return spaces;
  }

  /**
   * Prints out welcoming text
   */
  public void helloWelcome() {
    String line = "";
    System.out.print("Hello! Welcome to this talk-to-my-oc game! (press enter to continue; enter \"skip\" to skip the instructions) ");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print("This is a texted-based game, so there will be a LOT of reading (and a lot of keyboard action).");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print("Here is how things work:");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print(
        "1. The context of this game is that you are currently chatting with a digital personification of the Polish language. You can talk to her and get more information about her.");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print("2. Every option will have a number before it. Choose the number you want and hit enter.");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print(
        "3. Narration stuff will be in normal text. When you speak, it will be in quotation marks. When the character speaks, it will be their name + : + dialogue.");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print(
        "4. When you interact with Polish, her affection may change. You start at 0, and the number changes from there.\n   If the affection is too low, she will kick you out and refuse to talk to you. If the affection is high enough, you might get additional information that you wouldn’t otherwise.\n   The dialogue will tell you how affection changes after each option, so don’t worry about guessing what the computer is doing.");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print(
        "5. Note: the way affection changes may not always be obvious.\n   Remember, some characters might find negative remarks funny while some characters might find positive comments threatening.\n   Some characters might be impatient and will dislike you for wasting time. So be careful!\n   (you can find clues on how their affection (and possible additional meters) changes by checking them)");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print("If you find any bugs, please report them to me, and I will fix them as fast as I can.");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print("(you can also view the endings you reached in the endings.txt file)");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print("Enjoy!");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
  }

  /**
   * Prints out information in the main menu screen
   */
  public void mainMenuText() {
    String line = "";
    System.out.print("\n\n\nYou have now entered the main menu stage of this game. (enter \"skip\" to skip the instructions) ");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print("\nIn this stage, you will be given 3 options: check, chat, and exit.");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print(
        "\nIn the check option, you can either check the character or the status.\nIf you check on the character, you will be given basic information about the character, such as their name, where they are from, and a sentence summarizing their personality.\n\nThere will also be hints on how to interact with the character as well as what information you need to unlock.\n\nWhen information is unlocked, the text in the check option will change.\n\nIf you check on the status, you will be given the value of different variables (such as affection) and information on what they mean.");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print(
        "\n\nIn the chat option, you will be given 3 options: random question, about their life, and to use the information you got from the random question option.\n\nIn random question, the machine will ask a random question that will not immediately decrease affection.\n\nIn about their life, they will give you information that they are comfortable giving at the current affection level.\n\nBe aware that not every positive comment is going to increase affection and not every negative comment is going to decrease affection.");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print("\nIn the exit option, you...well, say bye to the character. The character will say bye to you as well.");
    line = scanner.nextLine();
    if (line.equals("skip"))
    {
      return;
    }
    System.out.print("\nAnd that is it!\n\n");
  }
}