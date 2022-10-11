import java.util.Scanner;

/**
 * This program contains a tutorial for the game
 */
class Tutorial {
  /**
   * GA introduces the tutorial and asks what you want
   */
  public void tutorialIntro() {
    String name = "???: ";
    Scanner input = new Scanner(System.in);
    String line = "";

    System.out.print(
        "...\n...\n...\nA young man with short, messy hair and honey-brown eyes pops up in front of you. He smiles as he adjusts the sideways baseball cap on his head.");
    line = input.nextLine();
    if (line.equals("quit")) {
      return;
    }
    
    System.out.print(name + "Hello! Welcome to the game!");
    line = input.nextLine();
    if (line.equals("quit")) {
      return;
    }
    
    System.out.print(name + "I shall now guide you through the basics of the game as well as what to expect.");
    line = input.nextLine();
    if (line.equals("quit")) {
      return;
    }
    
    System.out.print(name + "You can also enter \"quit\" at any time to exit the tutorial.");
    line = input.nextLine();
    if (line.equals("quit")) {
      return;
    }
    System.out.print(name + "(apparently I’m chosen because I’m the best in the bunch at being customer service??)");
    line = input.nextLine();
    
    if (line.equals("quit")) {
      return;
    }
    System.out.print(name + "Anyway, the game is divided into two main sections: the greeting stage and the main menu stage.\n     Do you want to go over the greeting stage? (y/n)");
    
    do {
      String choice = input.next();
      System.out.println();
    switch (choice) {
      case "quit":
        return;
        
      case "y":
        tutorialGreeting();
        tutorialMainMenu();
        return;
        
      case "n":
        System.out.print(name + "How about the main menu stage? (y/n)");
        
        do {
          choice = input.next();
        switch (choice) {
          case "quit":
            return;
            
          case "y":
            name = "GAE: ";
            System.out.print(name + "Just so you know, I am General American English (GAE).");
            line = input.nextLine();
            if (line.equals("quit")) {
              return;
            }
            tutorialMainMenu();
            return;
            
          case "n":
            System.out.println(name + "(if you don’t want to go over any of it, then why did you run the tutorial...)");
            line = input.nextLine();
            if (line.equals("quit")) {
              return;
            }
            System.out.println("...\n...\n...");
            return;

          default:
            System.out.print(name + "Um, that's kind of an invalid input...try again.");
            if (line.equals("quit")) {
              return;
            }
            break;
        }
           }
          while (!(line.equals("y")) && !(line.equals("n")));
        break;

      default:
        System.out.print(name + "Um, that's kind of an invalid input...try again.");
        if (line.equals("quit")) {
              return;
            }
    }
    }
    while (!(line.equals("y")) && !(line.equals("n")));
  }

  /**
   * GA introduces the player to the Greeting stage
   */
  public void tutorialGreeting() {
    String name = "???: ";
    Scanner input = new Scanner(System.in);
    ToolMethods obj = new ToolMethods();
    String line = "";

    System.out.println("\n" + name + "During the greeting stage, you meet the character for the first time. You get a brief description of their appearance before you greet them. There will be different options on how you greet them. When choosing an option, type the number before the option, then hit enter. Let’s try this out!");
    obj.printOptions("\"Hello!\" (type 1 and hit enter)", "\"Hi!\" (type 2 and hit enter)",
        "\"um...\" (type 3 and hit enter)", "", "");
    
    do {
      line = input.next();
      System.out.println();
      switch (line)
        {
          case "1":
            break;

          case "2":
            break;

          case "3":
            break;

          case "quit":
            return;

          default:
            System.out.print(name + "Um, that's kind of an invalid input...try again.");
            break;
        }
       }
      while ((!line.equals("1")) && (!line.equals("2")) && (!line.equals("3")));

    System.out.print(name + "Great job!");
    line = input.nextLine();
    line = input.nextLine();
    if (line.equals("quit")) {
      return;
    }
    
    System.out.println(name + "What you've probably noticed is that you don’t know the name of the character you are talking to yet.\n     After the initial greeting, you will have options to ask for the character’s name. Let’s give it a go!");
    obj.printOptions("\"What’s your name?\"", "\"Gimme your name.\"", "\"Name?\"", "", "");
    
    do {
      line = input.next();
      System.out.println();
      switch (line) {
        case "1":
          break;

        case "2":
          break;

        case "3":
          break;

        case "quit":
          return;

        default:
          System.out.print(name + "Um, that's kind of an invalid input...try again.");
          break;
      }
    }
      while (!(line.equals("1")) && !(line.equals("2")) && !(line.equals("3")));

    name = "Andrew: ";
    line = input.nextLine();
    if (line.equals("quit")) {
      return;
    }
    
    System.out.print(name + "My name is Andrew. Andrew Charles Richardson.");
    line = input.nextLine();
    if (line.equals("quit")) {
      return;
    }
    
    System.out.print(name + "Now you can see that the \"???\" before the colon finally changed, meaning you now know who you are talking to.");
    line = input.nextLine();
    if (line.equals("quit")) {
      return;
    }
    
    System.out.print(name + "You might be wondering, \"Wait, but I thought I was going to talk to a human version of a language. Why are you giving me a human name?\"");
    line = input.nextLine();
    if (line.equals("quit")) {
      return;
    }
    
    System.out.print(name + "Well, this is because it’d be kinda strange to ask a random person on the street what their name is and have them reply \"Punjabi.\"");
    line = input.nextLine();
    if (line.equals("quit")) {
      return;
    }
    
    System.out.println(name + "So, um, why don’t you ask me what language I am? Or, better yet, guess what language I am by typing an answer in? Type in your answer and hit enter.");

    boolean justGo = false;
    obj.printOptions("\"Ok, I’ll type it in.\"", "\"Why in the world do I have to type????????????\"", "", "", "");
    
    do {
      line = input.nextLine();
      System.out.println();
      switch (line) {
      case "quit":
        return;
          
      case "1":
        break;
          
        case "2":
        System.out.print(name + "This is because some characters may want you to type in what language you think they are. Just don’t be surprised if this happens. (type in your answer)");
          line = input.next();
          justGo = true;
        break;

        default:
          System.out.print(name + "Um, that's kind of an invalid input...try again.");
          break;
      }
    }
       while (!justGo && !(line.equals("1")) && !(line.equals("2")));
    
    name = "GAE: ";
    System.out.println();
    
    if (line.equalsIgnoreCase("English") || line.equalsIgnoreCase("GA") || line.equalsIgnoreCase("AE") || line.equalsIgnoreCase("GAE") || line.equalsIgnoreCase("General American English") || line.equalsIgnoreCase("General American")) {
      System.out.print(name + "Correct! I am General American English (GAE).");
    } 
    else {
      System.out.print(name + "Um, I’m actually General American English (GAE).");
    }
    line = input.nextLine();
    line = input.nextLine();
    if (line.equals("quit")) {
      return;
    }
    
    System.out.println(name + "Great! We have now finished the greeting stage.");
    line = input.nextLine();
    System.out.println(name + "The next stage is the main menu stage.");
  }

  /**
   * GA introduces the player to the main menu stage
   */
  public void tutorialMainMenu() {
    Scanner input = new Scanner(System.in);
    String line = "";
    String name = "GAE: ";
    input.nextLine();
    System.out.print(name + "When you get to this stage, there will be a long paragraph describing what to do, so here’s a brief summary: you will have three options: check, chat, and exit. Check will give you information about the character, chat will allow you to have conversations with the character, and exit will have you say goodbye to the character and leave the game. This stage will end if either the character gets tired of you or if you choose exit.");
    line = input.nextLine();
    if (line.equals("quit")) {
      return;
    }
    
    System.out.print(name + "And that is all! Hope you enjoy the game!");
    line = input.nextLine();
    System.out.print("...\n...\n...");
    return;
  }
}