import java.util.Scanner;
import java.util.Random;
import java.io.*;

/**
 * This class contains the main method used to play the game
 */
public class Main {
  /**
   * The main method to run the game
   */
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    String input = "";
    String polName = "???: ";
    ToolMethods obj = new ToolMethods();
    StageMethods stg = new StageMethods();
    Tutorial tut = new Tutorial();
    Random randomObj = new Random();

    File file = new File("endings.txt");
    FileWriter fw = new FileWriter(file, true);
    PrintWriter pw = new PrintWriter(fw);

    //all the questions in the random questions option
    String[] questions = { "\"Do you want to watch a Czech puppet show or go to a Yiddish theater right now?\"",
        "\"On a scale of Chinese to Tsez, how many cases do you have? Don’t say Polish.\"",
        "\"Just looking at the word “Polish” itself and ignoring everything else, what are your preferred pronouns?\"",
        "\"Why are you not demanding me to use Pani?\"",
        "\"Would you be more angry if I address you with polski/polszczyzna/Polish + diminutive * 2 or with human name + diminutive * 2 (with no Pani)?\"",
        "\"How can you fight when you have hair in your face? Isn’t that the most annoying thing possible?\"",
        "\"Why would you fight with long hair? Won’t the enemy just grab your hair as a handle and/or chop it off in the process?\"",
        "\"Does that long-haired guy out the window look like Hungarian?\"",
        "\"What do you think Italian does as a living?\"",
        "\"What was Yiddish’s job again?\"",
        "\"I’ve heard that Hungarian is mean and hostile. Is that true?\"" };

    stg.helloWelcome();
    boolean ranTutorial = false;
    boolean humanName = false;//whether the player knows Polish's human name
    boolean mrn = false;//whether the player can access info mrn
    boolean doneMrn = false;

    boolean ask = false;//for the "ask another question?" part
    boolean yesItsFine = false;//for the "ask another question?" part

    System.out.print("\nEnter tutorial? The tutorial is pretty long for this game though. (y/n) ");
    do {
      input = scanner.next();
      switch (input) {
        case "y":
          tut.tutorialIntro();
          ranTutorial = true;
          break;
          
        case "n":
          break;
        default:
          System.out.println("(Invalid input)");
      }
    }
    while (!(input.equals("y")) && !(input.equals("n")));

    System.out.println();
    String name = stg.enterName();
    String spaces = stg.nameSpaces(name);

    boolean trueIdentity = false;// whether the player knows she's Polish

    // initial greeting stage
    System.out.print("You sit down at a table.");
    scanner.nextLine();
    scanner.nextLine();
    System.out.print("The person before you is a blond-haired woman who should be in her min-twenties.");
    scanner.nextLine();
    System.out.print("Her hair is tied back in two long braids, while a black bow sits on the side of her head.");
    scanner.nextLine();
    System.out.print("Her blue eyes look toward you.");
    scanner.nextLine();
    System.out.print(polName + "What?\n");

    obj.printOptions("Greet in Polish", "Greet in English", "Say \"what?\"", "", "");
    do {
      input = scanner.next();
      System.out.println();
      switch (input) {
        // greet in Polish
        case "1":
          System.out.print(polName + "...Dzień dobry.");
          scanner.nextLine();
          scanner.nextLine();
          System.out.print(polName + "...");
          scanner.nextLine();
          System.out.print(polName + "I didn’t know you speak Polish. (affection + 1)");
          obj.afIn();
          scanner.nextLine();
          System.out.println();
          break;
        // just greeting
        case "2":
          System.out.print("She nods her head.");
          scanner.nextLine();
          System.out.println();
          break;
        // ...
        case "3":
          System.out.print(polName + "...");
          scanner.nextLine();
          scanner.nextLine();
          System.out.println(polName + "If you’re not going to talk to me, then get lost. (patience - 1)");
          obj.paDe();
          System.out.println();
          break;

        default:
          System.out.println("(Invalid input)");
      }
    } while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));

    // giving name
    obj.printOptions("\"So...what's your name?\"", "\"Um, my name is " + name + ". What about you?\"",
        "\"My name is " + name + ", but...you're not human, are you?\"", "", "");
    do {
      input = scanner.next();
      System.out.println();
      switch (input) {
        case "1":
          polName = "Malina: ";
          spaces = stg.nameSpaces(polName);
          humanName = true;
          System.out.print(polName + "...Malina. Malina Stanisławska.\n");
          obj.printOptions("\"My name is " + name + ".\"", "\"...\"", "", "", "");
          
          do {
            input = scanner.next();
            System.out.println();
            switch (input) {
              case "1":
                System.out.print("She nods her head.");
                scanner.nextLine();
                break;

              case "2":
                // doesn't give name
                System.out.println(polName + "What, you’re not telling me yours? (patience - 1)");
                obj.paDe();
                obj.printOptions("\"My name is " + name + ".\"", "\"...\"", "", "", "");
                do {
                  input = scanner.next();
                  System.out.println();
                  switch (input) {
                    case "1":
                      System.out.println("She nods her head.");
                      scanner.nextLine();
                      break;

                    case "2":
                      System.out.println(polName + "Really? I don’t have time for this. (patience -1)");
                      obj.paDe();
                      obj.printOptions("\"My name is " + name + ".\"", "\"...\"", "", "", "");
                      do {
                        input = scanner.next();
                        System.out.println();
                        switch (input) {
                          case "1":
                            System.out.println("She nods her head.");
                            scanner.nextLine();
                            break;

                          case "2":
                            System.out.println(polName + "...Whatever. Do what you want. (patience - 1)");
                            obj.paDe();
                            scanner.nextLine();
                            break;

                          default:
                            System.out.println("(Invalid input)");
                            break;
                        }
                        break;
                      }
                      while (!(input.equals("1")) && !(input.equals("2")));
                      break;

                    default:
                      System.out.println("(Invalid input)");
                  }
                }
                while (!(input.equals("1")) && !(input.equals("2")));
                break;

              default:
                System.out.println("(Invalid input)");
                break;
            }
          }
          while (!(input.equals("1")) && !(input.equals("2")));
          break;

        case "2":
          // asks and gives name
          polName = "Malina: ";
          humanName = true;
          spaces = stg.nameSpaces(name);
          System.out.print(polName + "Malina Stanisławska.");
          scanner.nextLine();
          break;

        case "3":
          //not human
          System.out.println(polName + "...? Explain.");
          obj.printOptions("\"You're a language, right?\"", "\"You're an angel, right?\"",
              "\"You're the Devil, right?\"",
              "", "");
          do {
            input = scanner.next();
            System.out.println();
            switch (input) {
              case "1": //a language
                System.out.println(polName + "If you say so, then tell me, which language am I? I'll give you a hint: \"I'll grind in the quern and you'll rest.\" (type in your answer)");
                String langGuess = "";
                boolean langCorrect = false;
                int guesses = 0;
                do {
                  if (guesses == 3) {
                    System.out.println(polName + "You know what, I'm done with your guessing. Stop pretending like you know me and get lost. Don't see me ever again.");
                    scanner.nextLine();
                    System.out.println("\nEnding: Please read the instructions!");
                    pw.println("Please read the instructions!");
                    pw.close();
                    System.exit(0);
                  }
                  langGuess = scanner.next();
                  if (!(langGuess.equalsIgnoreCase("polish")) && !(langGuess.equalsIgnoreCase("Polski")) && !(langGuess.equalsIgnoreCase("Polszczyzna"))) {
                    System.out.println(polName + "Wrong.  (affection -1) (patience -1) (type in your answer)");
                    obj.afDe();
                    obj.paDe();
                    guesses++;
                  } 
                  else if (guesses == 0) {
                    System.out.print("\n" + polName + "Oh, so you know me. (affection + 1)");
                    obj.afIn();
                    scanner.nextLine();
                    scanner.nextLine();
                    System.out.print(polName + "I guess that’s to be expected though...I am quite well known.");
                    scanner.nextLine();
                    langCorrect = true;
                    trueIdentity = true;
                  } 
                  else {
                    System.out.print(polName + "Oh, so you do know me after all...or are you just guessing?");
                    scanner.nextLine();
                    langCorrect = true;
                    trueIdentity = true;
                  }
                } while (!langCorrect);
                obj.printOptions("\"Can I call you Polski?\"", "\"Can I call you Polszczyzna?\"", "\"What's your human name?\"", "", "");
                do {
                  input = scanner.next();
                  System.out.println("\n");
                  switch (input) {
                    case "1":
                      if (obj.compareAffection(2)) {
                        polName = "Polski: ";
                        spaces = stg.nameSpaces(polName);
                        System.out.print(polName + "Sure, why not.");
                        scanner.nextLine();
                      } 
                      else {
                        polName = "Polszczyzna: ";
                        spaces = stg.nameSpaces(polName);
                        System.out.print(polName + "No. Go with Polszczyzna.");
                        scanner.nextLine();
                      }
                      break;

                    case "2":
                      if (obj.compareAffection(2)) {
                        polName = "Polski: ";
                        spaces = stg.nameSpaces(polName);
                        System.out.print(polName + "No. Go with Polski.");
                        scanner.nextLine();
                      }
                      else {
                        polName = "Polszczyzna: ";
                        spaces = stg.nameSpaces(polName);
                        System.out.print(polName + "Sure, why not.");
                        scanner.nextLine();
                      }
                      break;

                    case "3":
                      obj.afDe();
                      System.out.print(polName + "??!");
                      scanner.nextLine();
                      scanner.nextLine();
                      System.out.print(polName + "Why would you  ask for my human name if you already know I’m the Polish language?? Just go with Polish! (affection -1)\n");
                      obj.printOptions("\"But I wanna know...\"", "\"Ok, Polski.\"", "\"Ok, Polszczyzna.\"", "", "");

                      do {
                        input = scanner.next();
                        System.out.println("\n");
                        switch (input) {
                          case "1":
                            System.out.print(polName + "...fine.  It’s Malina Stanisławska.");
                            humanName = true;
                            scanner.nextLine();
                            break;
                            
                          case "2":
                            if (obj.compareAffection(2)) {
                              polName = "Polski: ";
                              spaces = stg.nameSpaces(polName);
                              System.out.println("She nods her head.");
                              scanner.nextLine();
                            }
                            else {
                              polName = "Polszczyzna: ";
                              spaces = stg.nameSpaces(polName);
                              System.out.println(polName + "No. Go with Polszczyzna.");
                              scanner.nextLine();
                            }
                            break;

                          case "3":
                            if (obj.compareAffection(2)) {
                              polName = "Polski: ";
                              spaces = stg.nameSpaces(polName);
                              System.out.println(polName + "No, go with Polski.");
                              scanner.nextLine();
                            }
                            else {
                              polName = "Polszczyzna: ";
                              spaces = stg.nameSpaces(polName);
                              System.out.println("She nods her head.");
                              scanner.nextLine();
                              break;
                            }

                          default:
                            System.out.println("(Invalid input)");
                            break;

                        }
                      }
                      while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                      break;

                    default:
                      System.out.print("(Invalid input)");
                      break;
                  }
                }
                while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                break;

              case "2":
                //an angel
                System.out.println(polName + "Huh? Do I look like an angel?");
                obj.printOptions("\"Yeah.\"", "\"Nah, just kidding.\"", "\"No, you look like a winged hussar.\"", "",
                    "");
                do {
                  input = scanner.next();
                  System.out.println();
                  switch (input) {
                    case "1":
                      System.out.println(polName + "Heh, interesting. Maybe I should have worn my wings today. Then I’d really look like an angel. (affection + 1)");
                      obj.afIn();
                      scanner.nextLine();
                      break;

                    case "2":
                      System.out.println(polName + "Then stop wasting my time. (patience -1)");
                      obj.paDe();
                      scanner.nextLine();
                      break;

                    case "3":
                      System.out.println(polName + "Heh, thanks. Maybe I should have worn my hussar wings today. Then I’d really look like a winged hussar. (affection + 2)");
                      obj.afIn();
                      obj.afIn();
                      scanner.nextLine();
                      break;

                    default:
                      System.out.println("(Invalid input)");
                  }
                }
                while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                break;

              case "3":
                System.out.print(polName + "Huh? Do I look like the Devil?");
                obj.printOptions("\"Yeah.\"", "\"Nah, just kidding.\"", "\"No, you look worse than the Devil.\"", "",
                    "");
                do {
                  input = scanner.next();
                  System.out.println();
                  switch (input) {
                    case "1":
                      System.out.println(polName + "...let me rephrase that: to who do I look like the Devil?");
                      obj.printOptions("\"???\"", "\"Me.\"", "\"Everyone.\"", "(type in answer)", "");
                      input = scanner.next();
                      guesses = 0;
                      
                      while (!input.equals("4")) {
                        obj.paDe();
                        System.out.println(polName + "Wrong. (patience --) (type in answer)");
                        input = scanner.next();
                      }
                      String theDevil = "";
                      theDevil = scanner.next();
                      
                      if (theDevil.equalsIgnoreCase("Russian") || theDevil.equalsIgnoreCase("German")
                          || theDevil.equalsIgnoreCase("Deutsch") || theDevil.equalsIgnoreCase("Russkij")
                          || theDevil.equalsIgnoreCase("Русский")) {
                        System.out.println(polName + "Correct. (affection + 1)");
                        obj.afIn();
                        scanner.nextLine();
                      } 
                      else {
                        System.out.print(polName + "...");
                        scanner.nextLine();
                        scanner.nextLine();
                        System.out.print(polName + "For a moment there, I actually thought that you would start a meaningful conversation. But, looks like I’m wrong.");
                        scanner.nextLine();
                        System.out.print(polName + "Do what you want, but don’t expect anything.");
                        scanner.nextLine();
                        break;
                      }
                      input = "1";
                      break;

                    case "2":
                      System.out.print("\n");
                      obj.paDe();
                      System.out.print(polName + "Then stop wasting my time. (patience -1)");
                      scanner.nextLine();
                      break;

                    case "3":
                      System.out.println();
                      System.out.println(polName + "...let me rephrase that: to who do I look worse than the Devil??");
                      obj.printOptions("\"???\"", "\"Me.\"", "\"Everyone.\"", "(type in answer)", "");
                      input = scanner.next();
                      guesses = 0;
                      
                      while (!input.equals("4")) {
                        obj.paDe();

                        System.out.println(polName + "Wrong. (patience --) (type in answer)");
                        guesses++;
                        input = scanner.next();
                      }
                      theDevil = "";
                      theDevil = scanner.next();
                      
                      if (theDevil.equalsIgnoreCase("Russian") || theDevil.equalsIgnoreCase("German")
                          || theDevil.equalsIgnoreCase("Deutsch")
                          || theDevil.equalsIgnoreCase("Russkij") || theDevil.equalsIgnoreCase("Русский")) {
                        System.out.println(polName + "Correct. (affection + 1)");
                        obj.afIn();
                        scanner.nextLine();
                      } 
                      else {
                        System.out.println(polName + "...");
                        scanner.nextLine();
                        scanner.nextLine();
                        System.out.println(polName + "For a moment there, I actually thought that you would start a meaningful conversation. But, looks like I’m wrong.");
                        scanner.nextLine();
                        System.out.print(polName + "Do what you want, but don’t expect anything.");
                        scanner.nextLine();
                        break;
                      }
                      break;

                    default:
                      System.out.println("(Invalid input)");
                  }
                }
                while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                break;

              default:
                System.out.print("(Invalid input) ");
            }
          } while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
      }
    } while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));

    if (!trueIdentity && !humanName) {
      obj.printOptions("\"So what is your name?\"", "", "", "", "");
      do {
        input = scanner.next();
        if (input.equals("1")) {
          polName = "Malina: ";
          spaces = stg.nameSpaces(polName);
          System.out.println(polName + "Malina. Malina Stanisławska.");
          input = scanner.nextLine();
          humanName = true;
          break;
        } 
        else {
          System.out.println("(Invalid input");
        }
      } while (!(input.equals("1")));
    }

    // main menu stage
    stg.mainMenuText();
    boolean quit = false;
    while (!quit) {
      obj.printOptions("Chat", "Check", "Exit", "", "");
      do {
        input = scanner.next();
        System.out.println();
        switch (input) {
          case "1":// chat
            if (!trueIdentity) {
              obj.printOptions("True identity", "", "", "", "");
              do {
                input = scanner.next();
                System.out.println("\n");
                switch (input) {
                  case "1":
                    System.out.print(polName + "So you realized that I'm hiding something.");
                    scanner.nextLine();
                    scanner.nextLine();
                    System.out.println(polName + "The truth will shock you, but I could give you a clue. \"Come, let me grind, and you take a rest.\" What am I?");

                    int guesses = 0;
                    boolean correct = false;
                    do {
                      input = scanner.next();
                      
                      if ((input.equalsIgnoreCase("Polish") || input.equalsIgnoreCase("Polski")
                          || input.equalsIgnoreCase("Polszczyzna"))) {
                        polName = "Polish: ";
                        spaces = stg.nameSpaces(polName);
                        System.out.println(polName + "Correct. Hope that clears things up.");
                        scanner.nextLine();
                        System.out.print("\n");
                        trueIdentity = true;
                        correct = true;
                      } 
                      else {
                        obj.paDe();
                        System.out.println(polName + "Wrong. (patience -1)");
                        guesses++;
                      }
                      
                      if (guesses == 3) {
                        System.out.println(polName + "...");
                        scanner.nextLine();
                        scanner.nextLine();
                        System.out.println(polName + "Fine. I'll tell you the truth.");
                        scanner.nextLine();
                        polName = "Polish: ";
                        spaces = stg.nameSpaces(polName);
                        System.out.print(polName + "I am the Polish language.");
                        scanner.nextLine();
                        System.out.print(polName + "Yes, you heard me right. I. Am. A. Language. Hope that clears things up.");
                        scanner.nextLine();
                        trueIdentity = true;
                        correct = true;
                      }
                    } while (!correct);
                    break;

                  default:
                    System.out.print("(Invalid input) ");
                    break;
                }
                input = "1";
              }
              while (!(input.equals("1")));
            }
            else {
              obj.printOptions("Random question (choose this option to randomly ask a question that will not lower affection or patience!)", "About her life", "Use the info you got in the random question section to increase affection!!", "", "");
              int randomize = 0;
              do {
                input = scanner.next();
                System.out.println();
                switch (input) {
                  case "1":
                    String yesOrNo = "";
                    
                    do {
                      System.out.println();
                      if (!obj.compareAffectionEnough()) {
                        randomize = randomObj.nextInt(8);
                      } 
                      else {
                        randomize = randomObj.nextInt(11);
                      }
                      String got = questions[randomize];
                      System.out.println(name + ": " + got);
                      
                      switch (randomize) {
                        case 0:
                          System.out.println(polName + "I want to watch Czech’s puppet show with a script written by Yiddish.");
                          if (!doneMrn) {
                            System.out.print(" (gained info: mrn)");
                          }
                          scanner.nextLine();
                          mrn = true;
                          break;

                        case 1:
                          System.out.println(polName + "Georgian. (7)");
                          scanner.nextLine();
                          break;

                        case 2:
                          System.out.println(polName + "He/her depending on register.");
                          if (polName.contains("Polski")) {
                            scanner.nextLine();
                            System.out.println();
                            System.out.print(polName + "You know what pronouns you (technically) should use to address me now, right?\n");
                            obj.printOptions("\"He/him.\"", "\"She/her.\"", "", "", "");
                            do {
                              input = scanner.next();
                              System.out.println("\n");
                              switch (input) {
                                case "1":
                                  System.out.print(polName + "She nods.");
                                  break;

                                case "2":
                                  System.out.print(polName + "Can’t believe you don’t know this.");
                                  break;

                                default:
                                  System.out.print("(Invalid input)");
                              }
                            }
                            while (!(input.equals("1")) && !(input.equals("2")));
                          }
                          else if (polName.contains("Polszczyzna")) {
                            scanner.nextLine();
                            System.out.println();
                            System.out.print(polName + "You know what pronouns you (technically) should use to address me now, right?\n");
                            obj.printOptions("\"He/him.\"", "\"She/her.\"", "", "", "");
                           
                            do {
                              input = scanner.next();
                              System.out.println("\n");
                              switch (input) {
                                case "1":
                                  System.out.print(polName + "Can't believe you don't know this.");
                                  break;

                                case "2":
                                  System.out.print(polName + "She nods.");
                                  break;

                                default:
                                  System.out.print("(Invalid input)");
                              }
                            } 
                            while (!(input.equals("1")) && !(input.equals("2")));
                          }
                          scanner.nextLine();
                          break;

                        case 3:
                          System.out.print("She facepalms.");
                          scanner.nextLine();
                          scanner.nextLine();
                          System.out.println(polName + "Because you’re not referring to me in the third person, moron.");
                          scanner.nextLine();
                          break;

                        case 4:
                          System.out.print(polName + "Equally angry, but I’d be more surprised that you came up with double diminutives for them both.");
                          scanner.nextLine();
                          break;

                        case 5:
                          System.out.print(polName + "What makes you think that I don’t have clips in my pockets at all times so that I can clip my hair back whenever I get into combat?");
                          scanner.nextLine();
                          scanner.nextLine();
                          System.out.println(polName + "Plus it’s fiction so no one cares.");
                          scanner.nextLine();
                          break;

                        case 6:
                          System.out.print(polName + "1. There’s a reason why I fight on a horse and/or with a saber.");
                          scanner.nextLine();
                          scanner.nextLine();
                          System.out.println(polName + "2. My hair is harder than steel and can’t be cut off.");
                          scanner.nextLine();
                          System.out.print(polName + "Russian tried cutting it off once and failed miserably.");
                          scanner.nextLine();
                          System.out.print(polName + "3. It’s fiction, idiot.");
                          scanner.nextLine();
                          break;

                        case 7:
                          System.out.print("She looks out the window and squints.");
                          scanner.nextLine();
                          scanner.nextLine();
                          System.out.println(polName + "Nah, he’s too meek. Hungarian’s way more intimidating than that.");
                          scanner.nextLine();
                          break;

                        case 8:
                          System.out.print(polName + "I’ve heard she’s a waitress/artist, but I’m convinced that all she does is sell vegetables.");
                          scanner.nextLine();
                          break;

                        case 9:
                          System.out.print(polName + "Last time I saw him he worked at a fast food restaurant.");
                          scanner.nextLine();
                          scanner.nextLine();
                          System.out.println(polName + "...while writing stuff for theaters at night.");
                          scanner.nextLine();
                          break;

                        case 10:
                          System.out.print(polName + "He is aggressive and skeptical, yes, but he’s not that terrible.");
                          scanner.nextLine();
                          scanner.nextLine();
                          System.out.println(polName + "Plenty of languages, myself included, have worked with him, and found him to be pretty willing to get to know others.");
                          scanner.nextLine();
                          System.out.print(polName + "He just...doesn’t negotiate. Or compromise.");
                          scanner.nextLine();
                          break;
                      }
                      System.out.print("\nAsk another question? (y/n)");
                      ask = false;
                      yesItsFine = false;
                      do {
                        yesOrNo = scanner.next();
                        System.out.println();
                        switch (yesOrNo) {
                          case "y":
                            ask = true;
                            yesItsFine = true;
                            break;

                          case "n":
                            yesItsFine = true;
                            break;

                          default:
                            System.out.print("(Invalid input)");
                        }
                      }
                      while (!yesItsFine);
                    } while (ask);
                    break;

                  case "2":// about her life
                    System.out.println(polName + "My life? What about it?");
                    obj.printOptions("\"When were you born?\"", "\"How’s it like being a language?\"", "\"What’s your relationship with other languages?\"", "\"Can you quickly go over your history?\"", "\"I want to learn more about you...personally.\"");
                    do {
                      input = scanner.next();
                      System.out.println();
                      switch (input) {
                        case "1":// when were you born
                          System.out.println(polName + "The early 12th century.");
                          obj.printOptions("\"Wow, you’re old.\"", "\"Wow, you’re young.\"", "\"Huh, same age as me.\"", "", "");
                          
                          do {
                            input = scanner.next();
                            System.out.println();
                            switch (input) {
                              case "1":
                                System.out.print(polName + "Compared to who?");
                                
                                do {
                                  obj.printOptions("\"Huh?\"", "\"The entire world.\"", "\"Bulgarian\"", "\"Um...Yiddish?\"", "");
                                  input = scanner.next();
                                  System.out.println("\n");
                                  switch (input) {
                                    case "1":
                                      System.out.print(polName + "Answer me.");
                                      break;

                                    case "2":
                                      obj.paDe();
                                      if (obj.comparePatience()) {
                                        System.out.print("\n" + polName + "You know what, I’m done with your time wasting. Get lost. Don’t see me ever again.");
                                        scanner.nextLine();
                                        System.out.print("...\nEnding: Annoyed");
                                        pw.println("Annoyed");
                                        pw.close();
                                        System.exit(0);
                                      }
                                      System.out.print(polName + "Lazy answer. (patience -1)");
                                      break;

                                    case "3":
                                      obj.paDe();
                                      if (obj.comparePatience()) {
                                        System.out.print("\n" + polName + "You know what, I’m done with your time wasting. Get lost. Don’t see me ever again.");
                                        scanner.nextLine();
                                        System.out.print("...\nEnding: Annoyed");
                                        pw.println("Annoyed");
                                        pw.close();
                                        System.exit(0);
                                      }
                                      System.out.print(polName + "Wrong. (patience -1)");
                                      break;

                                    case "4":
                                      break;

                                    default:
                                      System.out.print("(Invalid input)");
                                  }
                                  System.out.print("\n\n");
                                }
                                while (!input.equals("4"));
                                System.out.print(polName + "Correct.");
                                scanner.nextLine();
                                break;

                              case "2":
                                System.out.print(polName + "Compared to who?");
                                
                                do {
                                  obj.printOptions("\"Huh?\"", "\"The entire world.\"", "\"Bulgarian\"", "\"Um...Yiddish?\"", "");
                                  input = scanner.next();
                                  System.out.println("\n");
                                  switch (input) {
                                    case "1":
                                      System.out.print(polName + "Answer me.");
                                      break;

                                    case "2":
                                      obj.paDe();
                                      if (obj.comparePatience()) {
                                        System.out.print("\n" + polName + "You know what, I’m done with your time wasting. Get lost. Don’t see me ever again.");
                                        scanner.nextLine();
                                        System.out.print("...\nEnding: Annoyed");
                                        pw.println("Annoyed");
                                        pw.close();
                                        System.exit(0);
                                      }
                                      System.out.print(polName + "Lazy answer. (patience -1)");
                                      break;

                                    case "3":
                                      break;

                                    case "4":
                                      obj.paDe();
                                      if (obj.comparePatience()) {
                                        System.out.print("\n" + polName + "You know what, I’m done with your time wasting. Get lost. Don’t see me ever again.");
                                        scanner.nextLine();
                                        System.out.print("...\nEnding: Annoyed");
                                        pw.println("Annoyed");
                                        pw.close();
                                        System.exit(0);
                                      }
                                      System.out.print(polName + "Wrong. (patience -1)");
                                      break;

                                    default:
                                      System.out.print("(Invalid input)");
                                  }
                                }
                                while (!input.equals("3"));
                                System.out.print("\n\n" + polName + "Correct.");
                                scanner.nextLine();
                                break;

                              case "3":
                                System.out.print("\n" + polName + "Oh, ok.");
                                scanner.nextLine();
                                break;

                              default:
                                System.out.print("(Invalid input) ");
                                break;
                            }
                            input = "1";
                          }
                          while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                          break;

                        case "2":// how's it like being a language
                          System.out.println();
                          System.out.println(polName + "The biggest difference between languages and humans is that languages can’t die unless there are no more speakers.No matter what physical pain languages go through, as long as there are still speakers, we cannot taste the sweet release of death.");
                          scanner.nextLine();
                          scanner.nextLine();
                          System.out.println(polName + "Some languages hate it but others like it because they want to live.");
                          obj.printOptions("\"Do you like the fact that you can’t die?\"", "\"I wanna be a language now...\"", "(don’t say anything)", "", "");
                          
                          do {
                            input = scanner.next();
                            System.out.println("\n");
                            switch (input) {
                              case "1":
                                System.out.print(polName + "Yes. Absolutely.");
                                scanner.nextLine();
                                scanner.nextLine();
                                System.out.println(polName + "I wanna annoy the crap out of German and Russian for the rest of their petty lives.");
                                obj.printOptions("\"That’s great.\"", "\"That’s terrible.\"", "(don’t say anything)", "", "");
                                
                                do {
                                  input = scanner.next();
                                  System.out.println("\n");
                                  switch (input) {
                                    case "1":
                                      System.out.print(polName + "Of course it is. (affection +1)");
                                      obj.afIn();
                                      scanner.nextLine();
                                      break;

                                    case "2":
                                      obj.afDe();
                                      if (obj.checkAffectionLow()) {
                                        System.out.print("\n" + polName + "You know what, I’m sick of you and your disgusting face. Get lost. Don’t see me ever again.");
                                        scanner.nextLine();
                                        System.out.print("...\nEnding: Disgusted");
                                        pw.println("Disgusted");
                                        pw.close();
                                        System.exit(0);
                                      }
                                      System.out.print(polName + "You’ll never understand me, mortal. (affection -1)");
                                      scanner.nextLine();
                                      break;

                                    default:
                                      System.out.print("(Invalid input)");
                                  }
                                }
                                while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                                break;

                              case "2":
                                System.out.print(polName + "...should I call you determined or a masochist?");
                                scanner.nextLine();
                                break;

                              case "3":
                                break;

                              default:
                                System.out.print("(Invalid input)");
                                break;
                            }
                          } 
                          while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                          System.out.println();

                          System.out.print(polName + "When people learn about this, they either think that we are gods or that we are witches. There’s no in-between.");
                          scanner.nextLine();
                          scanner.nextLine();
                          System.out.println(polName + "They usually envy our long lives while forgetting that most of us live in eternal misery, aka no recognition and face oppression from pretty much everyone else.");
                          obj.printOptions("\"Do you live in eternal misery?\"", "\"Are you one of the oppressors?\"", "\"Wait, what happens when humans think you are gods?\"", "\"Wait, what happens when humans think you are witches?\"", "(don’t say anything)");
                          
                          do {
                            input = scanner.next();
                            System.out.println("\n");
                            switch (input) {
                              case "1":
                                System.out.print(polName + "No. Ukrainian does, though.");
                                scanner.nextLine();
                                break;

                              case "2":
                                obj.afDe();
                                if (obj.checkAffectionLow()) {
                                  System.out.print("\n" + polName + "You know what, I’m sick of you and your disgusting face. Get lost. Don’t see me ever again.");
                                  scanner.nextLine();
                                  System.out.print("...\nEnding: Disgusted");
                                  pw.println("Disgusted");
                                  pw.close();
                                  System.exit(0);
                                }
                                System.out.print(polName + "I am not one of them. (affection -1)");
                                scanner.nextLine();
                                break;

                              case "3":
                                System.out.print(polName + "Random people show up at our doorsteps to either give food, pray, or try to kill us. Or they shove us poisoned food after praying to us.");
                                scanner.nextLine();
                                scanner.nextLine();
                                System.out.println(polName + "This one person legit demanded me to answer their prayer at midnight.");
                                scanner.nextLine();
                                break;

                              case "4":
                                System.out.print(polName + "Depends on the region. It can range anywhere from being highly respected to being burnt on a stake.");
                                scanner.nextLine();
                                break;

                              case "5":
                                break;

                              default:
                                System.out.print("(Invalid input)");
                            }
                          }
                          while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3"))&& !(input.equals("4")) && !(input.equals("5")));
                          System.out.print("\n");
                          scanner.nextLine();
                          System.out.print(polName + "...");
                          scanner.nextLine();
                          System.out.println(polName + "What, you have questions?");
                          boolean question = true;
                          
                          do {
                            obj.printOptions("\"What would happen if a language fell in love with a human?\"", "\"Can languages physically give birth?\"", "\"If languages can’t die, can they then just not eat/drink at all and survive?\"", "\"What happens to the corpse when languages die?\"", "\"No more questions.\"");
                            
                            do {
                              input = scanner.next();
                              System.out.println();
                              switch (input) {
                                case "1":// in love
                                  System.out.println(polName + "Languages don’t. We can’t form strong emotional bonds with humans.");
                                  scanner.nextLine();
                                  scanner.nextLine();
                                  System.out.println(polName + "Thus we live with much less suffering and don’t mourn upon seeing most deaths.");
                                  obj.printOptions("\"No...I wanted to marry this language...\"", "\"No...I wanted to backstab this language and make them hate me.\"", "\"Yeah I want to be a language.\"", "(don’t say anything)", "");
                                  
                                  do {
                                    input = scanner.next();
                                    System.out.println("\n");
                                    switch (input) {
                                      case "1":
                                        System.out.print("\n" + polName + "Lol no you impractical dreamer.");
                                        break;

                                      case "2":
                                        System.out.print("\n" + polName + "I mean you still can. Just be a bitch and everyone will hate you.");
                                        obj.printOptions("\"So everyone will hate me if I act like you?\"", "\"So everyone will hate me if I act like the language in question?\"", "(don't say anything)", "", "");
                                        
                                        do {
                                          input = scanner.next();
                                          System.out.println("\n");
                                          switch (input) {
                                            case "1":
                                              System.out.print(polName + "You-");
                                              scanner.nextLine();
                                              scanner.nextLine();
                                              System.out.println(polName + "...'re not wrong.");
                                              scanner.nextLine();
                                              System.out.print(polName + "I’m angry but you have a point.");
                                              break;

                                            case "2":
                                              System.out.println(polName + "Well if you want to anger a bitch, then you have to be even worse than them.");
                                              scanner.nextLine();
                                              scanner.nextLine();
                                              System.out.println(polName + "I recommend reading up on German to get inspiration.");
                                              break;

                                            case "3":
                                              break;

                                            default:
                                              System.out.print("(Invalid input) ");
                                          }
                                        }
                                        while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                                        break;

                                      case "3":// wanna be a lang
                                        System.out.println(polName + "That...could mean a lot of different things.");
                                        break;

                                      case "4":
                                        break;

                                      default:
                                        System.out.print("(Invalid input)");
                                    }
                                  }
                                  while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")));
                                  scanner.nextLine();
                                  break;

                                case "2": // family
                                  System.out.println(polName + "No, we can’t. New languages just pop out of nowhere.\n");
                                  obj.printOptions("\"So is family still a thing?\"", "\"What about periods then?\"", "\"But due to the law of conservation of matter, matter cannot be created nor destroyed...\"", "(don’t say anything)", "");
                                  
                                  do {
                                    input = scanner.next();
                                    System.out.println("\n");
                                    switch (input) {
                                      case "1":
                                        System.out.println(polName + "Languages don’t feel familial bonds like humans do. We see each other as competitors and rivals instead of kin.");
                                        scanner.nextLine();
                                        scanner.nextLine();
                                        System.out.println(polName + "Plus, no one remembers how languages came to be or exactly how old anyone is anyway.");
                                        scanner.nextLine();
                                        break;
                                    
                                      case "2":
                                        System.out.println(polName + "Not a thing.");
                                        scanner.nextLine();

                                      case "3":
                                        obj.paDe();
                                        if (obj.comparePatience()) {
                                          System.out.print("\n" + polName + "You know what, I’m done with your time wasting. Get lost. Don’t see me ever again.");
                                          scanner.nextLine();
                                          System.out.print("...\nEnding: Annoyed");
                                          pw.println("Annoyed");
                                          pw.close();
                                          System.exit(0);
                                        }
                                        System.out.println(polName + "Shut up you’re annoying. (patience -1)");
                                        scanner.nextLine();
                                        break;

                                      case "4":
                                        break;

                                      default:
                                        System.out.print("(Invalid input)");
                                        break;
                                    }
                                  }
                                  while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                                  break;

                                case "3":// can't die
                                  System.out.println(polName + "Well yes, but no one wants to starve and be dehydrated for longer than they need to.");
                                  scanner.nextLine();
                                  scanner.nextLine();
                                  System.out.println(polName + "(Yiddish did try doing this to save money though)");
                                  break;

                                case "4":// corpse
                                  System.out.print(polName + "The corpse barely rots. If a language goes extinct, then the corpse rots some more.");
                                  scanner.nextLine();
                                  scanner.nextLine();
                                  System.out.println(polName + "The corpse will still remain intact though until everyone forgets that the language ever existed.");
                                  scanner.nextLine();
                                  System.out.print(polName + "Then, the corpse will completely rot and disappear.");
                                  obj.printOptions("\"Sounds awful.\"", "\"Sounds amazing.\"", "\"Are there any examples?\"", "(don't say anything)", "");
                                  do {
                                    input = scanner.next();
                                    System.out.println();
                                    switch (input) {
                                      case "1":
                                        System.out.println(polName + "Sure is.");
                                        break;

                                      case "2":
                                        obj.afDe();
                                        if (obj.checkAffectionLow()) {
                                          System.out.print("\n" + polName + "You know what, I’m sick of you and your disgusting face. Get lost. Don’t see me ever again.");
                                          scanner.nextLine();
                                          System.out.print("...\nEnding: Disgusted");
                                          pw.println("Disgusted");
                                          pw.close();
                                          System.exit(0);
                                        }
                                        System.out.println(polName + "Then how about you completely rotting and disappearing? I’d be glad to initiate the process. (affection -1)");
                                        break;

                                      case "3":// examples
                                        System.out.println(polName + "Hebrew died a long time ago but recently revived. His corpse slowly repaired his tissue to bring him back to life.");
                                        scanner.nextLine();
                                        scanner.nextLine();
                                        System.out.println(polName + "Now, he’s better than ever.");
                                        break;

                                      case "4":
                                        break;

                                      default:
                                        System.out.println("(Invalid input)");
                                    }
                                  } 
                                  while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                                  break;

                                case "5":
                                  question = false;
                                  break;

                                default:
                                  System.out.print("(Invalid input)");
                                  break;
                              }
                            }
                            while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")) && !(input.equals("5")));
                          } 
                          while (question);
                          break;

                        case "3":// realationship with other languages
                          if (obj.compareAffectionEnough()) {
                            System.out.print("\n" + polName + "...");
                            scanner.nextLine();
                            System.out.println(polName + "You can figure it out on your own.");
                          }
                          else {
                            System.out.print("\n" + polName + "I’m not answering this one.");
                          } 
                          scanner.nextLine();
                          break;

                        case "4":// history
                          if (obj.compareAffectionEnough()) {
                            System.out.println(polName + "There’s a library down the street. With free Wi-Fi. Do what you will.");
                          } 
                          else {
                            System.out.println(polName + "What, you think I’m your history teacher?? Do your own research!");
                          } 
                          scanner.nextLine();
                          break;

                        case "5":
                          System.out.print("\n" + polName + "So you want to find my weaknesses and exploit them? Not happening.\n");
                          obj.printOptions("\"No, I’m just interested in you.\"", "\"Ok, I won’t ask.\"", "\"Busted...\"", "", "");
                          
                          do {
                            input = scanner.next();
                            System.out.println("\n");
                            switch (input) {
                              case "1":// interested in you
                                System.out.print(polName + "Interested in what?\n");
                                obj.printOptions("\"I said, you.\"", "\"Your human name.\"",
                                    "\"Your job and hobbies.\"", "\"Where you live.\"",
                                    "\"How you feel about...\" (see more options)");
                                
                                do {
                                  input = scanner.next();
                                  System.out.println();
                                  switch (input) {
                                    case "1":// in you
                                      System.out.print(polName + "Depending on what you mean, my reply is either \"get lost\" or \"fuck off.\"");
                                      scanner.nextLine();
                                      break;

                                    case "2":// your name
                                      if (!humanName)// agreed to go by Polish
                                      {
                                        System.out.print("\n" + polName + "Why do you want to know??");
                                        scanner.nextLine();
                                        scanner.nextLine();
                                        System.out.print(polName + "...");
                                        scanner.nextLine();
                                        System.out.println(polName + "Ugh fine. It’s Malina Stanisławska. Happy?");
                                        humanName = true;
                                        scanner.nextLine();
                                      }
                                      
                                      else {
                                        System.out.print("\n" + polName + "I already gave you my human name.");
                                        obj.printOptions("\"True...\"", "\"Your name is so good. I want to know why you chose this.\"", "\"Your name is so bad. I want to know why you didn’t choose anything else.\"", "\"No, I want to know what others think about your name.\"", "\"No, I want to know how languages and/or Phoenix choose human names in general.\"");
                                        
                                        do {
                                          input = scanner.next();
                                          System.out.println("\n");
                                          switch (input) {
                                            case "1":
                                              break;

                                            case "2":
                                              System.out.println(polName + "I chose it because it’s a name. Happy?");
                                              scanner.nextLine();
                                              scanner.nextLine();
                                              System.out.println("Looks like she’s hiding a smile. (affection +1)");
                                              obj.afIn();
                                              break;

                                            case "3":
                                              obj.afDe();
                                              if (obj.checkAffectionLow()) {
                                                System.out.print("\n" + polName + "You know what, I’m sick of you and your disgusting face. Get lost. Don’t see me ever again.");
                                                scanner.nextLine();
                                                System.out.print("...\nEnding: Disgusted");
                                                pw.println("Disgusted");
                                                pw.close();
                                                System.exit(0);
                                              }
                                              System.out.print(
                                                  polName + "Shut up before I lash out on your name. (affection -1)");
                                              break;

                                            case "4":// what others think
                                              System.out.print(polName + "Like who?");
                                              obj.printOptions("\"German and Russian.\"", "\"Czech.\"", "\"Yiddish.\"",
                                                  "\"Kashubian and Belarusian.\"", "\"Latin.\"");
                                              
                                              do {
                                                input = scanner.next();
                                                System.out.println("\n");
                                                switch (input) {
                                                  case "1":// Ger and Rus
                                                    System.out.print("She smiles.");
                                                    scanner.nextLine();
                                                    scanner.nextLine();
                                                    System.out.println(polName + "They absolutely hate my name. Russian hates how my surname is the name of a saint (Stanislav), and German is PISSED that my Christian name is Luiza.");
                                                    scanner.nextLine();
                                                    System.out.print(polName + "As time went on, German’s rage over my name kept increasing. Every time some German-speaking person named Ludwig becomes famous/important, she would send me an angry letter/telegraph/text message demanding me to change my name.");
                                                    scanner.nextLine();
                                                    System.out.println(polName + "I always reply by saying that her human name of choice (Waltraud Mathilde Dietrich) denies her religious beliefs. Gets her every time.");
                                                    obj.printOptions("\"Is German always that angry?\"",
                                                        "\"I didn’t know that German cared about names that much.\"",
                                                        "\"Why does German’s human name of choice deny her religious beliefs?\"",
                                                        "\"Wait, why doesn’t German just name herself Ludwig to get you angry enough to change your name?\"",
                                                        "(don’t say anything)");
                                                    
                                                    do {
                                                      input = scanner.next();
                                                      System.out.println("\n");
                                                      switch (input) {
                                                        case "1":// always angry
                                                          System.out.print(polName + "To me, yes.");
                                                          obj.printOptions("\"That’s horrible.\"", "\"Ha, you deserve it.\"", "\"What about to other languages?\"", "(don't say anything)", "");
                                                          
                                                          do {
                                                            input = scanner.next();
                                                            System.out.println("\n");
                                                            switch (input) {
                                                              case "1":
                                                                System.out.print(polName + "At least someone has brain cells. (affection +1)");
                                                                obj.afIn();
                                                                scanner.nextLine();
                                                                break;

                                                              case "2":
                                                                obj.afDe();
                                                                if (obj.checkAffectionLow()) {
                                                                  System.out.print("\n" + polName + "You know what, I’m sick of you and your disgusting face. Get lost. Don’t see me ever again.");
                                                                  scanner.nextLine();
                                                                  System.out.print("...\nEnding: Disgusted");
                                                                  pw.println("Disgusted");
                                                                  pw.close();
                                                                  System.exit(0);
                                                                }
                                                                System.out.print(polName + "You deserve it. (affection -1)");
                                                                scanner.nextLine();
                                                                break;

                                                              case "3":// to others
                                                                System.out.print(polName + "Uhh...pretty much the same, now that I think of it.");
                                                                scanner.nextLine();
                                                                scanner.nextLine();
                                                                System.out.println(polName + "Probably because her way of becoming a lingua franca is too aggressive.");
                                                                scanner.nextLine();
                                                                break;

                                                              case "4":
                                                                break;

                                                              default:
                                                                System.out.print("(Invalid input)");
                                                                break;
                                                            }
                                                          } 
                                                          while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")));
                                                          break;

                                                        case "2":// cared?
                                                          System.out
                                                              .print(polName + "She doesn’t. She’s just mad at me.");
                                                          scanner.nextLine();
                                                          scanner.nextLine();
                                                          System.out.println(polName + "...and Russian, apparently.\n");
                                                          obj.printOptions("\"Why Russian?\"", "(don't say anything)", "", "", "");
                                                          
                                                          do {
                                                            input = scanner.next();
                                                            System.out.println("\n");
                                                            switch (input) {
                                                              case "1":
                                                                System.out.print("She shrugs.");
                                                                scanner.nextLine();
                                                                System.out.println(polName + "Something about his first name Fyodor sounding like Theodoric or whatever.");
                                                                scanner.nextLine();
                                                                break;

                                                              case "2":
                                                                break;

                                                              default:
                                                                System.out.print("(Invalid input) ");
                                                                break;
                                                            }
                                                            input = "1";
                                                          } 
                                                          while (!(input.equals("1")) && !(input.equals("2")));
                                                          break;

                                                        case "3":// reli
                                                          System.out.print(polName + "She’s protestant.");
                                                          obj.printOptions("\"No wonder.\"", "\"I don’t understand. Can you elaborate?\"", "", "", "");
                                                          
                                                          do {
                                                            input = scanner.next();
                                                            System.out.println("\n");
                                                            switch (input) {
                                                              case "1":
                                                                break;

                                                              case "2":
                                                                obj.paDe();
                                                                if (obj.comparePatience()) {
                                                                  System.out.print("\n" + polName + "You know what, I’m done with your time wasting. Get lost. Don’t see me ever again.");
                                                                  scanner.nextLine();
                                                                  System.out.print("...\nEnding: Annoyed");
                                                                  pw.println("Annoyed");
                                                                  pw.close();
                                                                  System.exit(0);
                                                                }
                                                                System.out.print(polName + "No. Do your own research. (patience - 1)");
                                                                scanner.nextLine();
                                                                break;

                                                              default:
                                                                System.out.print("(Invalid input)");
                                                            }
                                                          } 
                                                          while (!(input.equals("1")) && !(input.equals("2")));
                                                          break;

                                                        case "4":// name herself
                                                          System.out.print(polName + "Because Phoenix decided my name first and wants to avoid using multiple names from the same name tree.");
                                                          scanner.nextLine();
                                                          scanner.nextLine();
                                                          System.out.println(polName + "(She also said something about a well-known anime character being named Ludwig? I don’t get it.)");
                                                          scanner.nextLine();
                                                          break;

                                                        case "5":
                                                          break;
                                                      }
                                                    }
                                                    while (!(input.equals("1")) && !(input.equals("2"))
                                                        && !(input.equals("3")) && !(input.equals("4"))
                                                        && !(input.equals("5")));
                                                    break;

                                                  case "2":// czech
                                                    System.out.print(polName + "Czech’s cool with it, like she always is.");
                                                    scanner.nextLine();
                                                    if (obj.compareAffectionEnough()) {
                                                      System.out.println("She hesitates, but continues.");
                                                      scanner.nextLine();
                                                      System.out.print(polName + "Honestly, I’m amazed at how calm she is...or at least what she appears to be.");
                                                      scanner.nextLine();
                                                      System.out.print(polName + "Throughout all the centuries that I’ve known her for, she only flipped out once.");
                                                      scanner.nextLine();
                                                      System.out.print(polName + "I wasn’t there, so I don’t know all the details, but I heard it’s because Latin refused to deliver masses in Czech.");
                                                      scanner.nextLine();
                                                      System.out.print(polName + "(She was protestant at the time, so this makes even less sense.)");
                                                      scanner.nextLine();
                                                      System.out.print(polName + "But, I do know that she became atheist afterwards, and still is today.");
                                                      scanner.nextLine();
                                                    }
                                                    break;

                                                  case "3":// Ydd
                                                    System.out.print(polName + "Yiddish was super excited that my given name is Malina. He said that I’m just as kind as my name suggests, and somehow got me a bowl of raspberries during a blizzard.");
                                                    scanner.nextLine();
                                                    scanner.nextLine();
                                                    System.out.println(polName + "The raspberries tasted amazing, but I still don’t know how he did it up to this day.");
                                                    scanner.nextLine();
                                                    break;

                                                  case "4":// csb and bel
                                                    System.out.print(polName + "They didn’t care. Kashubian was just surprised that my name isn’t Jadwiga while Belarusian rolled her eyes and left.");
                                                    scanner.nextLine();
                                                    scanner.nextLine();
                                                    System.out.println(polName + "Guess she didn’t like me banging on her window at midnight just to tell her my human name.");
                                                    scanner.nextLine();
                                                    break;

                                                  case "5":// Latin
                                                    System.out.print("She slightly lowers her head and looks down.");
                                                    scanner.nextLine();
                                                    scanner.nextLine();
                                                    System.out.println(polName + "I don’t know...I just hope she’s not upset that my given name isn’t Christian...");
                                                    scanner.nextLine();
                                                    break;

                                                  default:
                                                    System.out.print("(Invalid input)");
                                                }
                                              } 
                                              while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")) && !(input.equals("5")));
                                              break;

                                            case "5":// how are names chosen
                                              System.out.print(polName + "It’s mainly up to Phoenix, actually. We can protest but mostly go with it.");
                                              scanner.nextLine();
                                              scanner.nextLine();
                                              System.out.println(polName + "You should see her list of naming rules. She calls it her \"17 Points\".");
                                              scanner.nextLine();
                                              System.out.println(polName  + "The rules range anywhere from \"no cognates\" to \"no intentional naming after famous people.\" Heard it’s to minimize the confusion of the reader.");
                                              obj.printOptions("\"What about the Chinese translation then?\"", "\"Wouldn’t that quickly deplete the possible names?\"", "(don't say anything)", "", "");
                                              
                                              do {
                                                input = scanner.next();
                                                System.out.println("\n");
                                                switch (input) {
                                                  case "1":// cn
                                                    System.out.print(polName + "She says that the Chinese translation of human names in the same \"natural class\" \"cannot simultaneously start with the same syllables on the segmental level and have the same number of syllables\". It’s apparently also to minimize the confusion of the reader.");
                                                    obj.printOptions("\"Wouldn’t that quickly deplete the possible names?\"", "(don't say anything)", "", "", "");
                                                    
                                                    do {
                                                      input = scanner.next();
                                                      System.out.println("\n");
                                                      switch (input) {
                                                        case "1":
                                                          System.out.print(polName + "Well yes, but she seems fine with it.");
                                                          scanner.nextLine();
                                                          scanner.nextLine();
                                                          System.out.println(polName + "(It does end up with Dutch being named “bright hostage” (Gijsberta) though)");
                                                          scanner.nextLine();
                                                          break;

                                                        case "2":
                                                          break;

                                                        default:
                                                          System.out.print("(Invalid input)");
                                                      }
                                                    }
                                                    while (!(input.equals("1")) && !(input.equals("2")));
                                                    break;

                                                  case "2":// deplete
                                                    System.out.print(polName + "Well yes, but she seems fine with it.");
                                                    scanner.nextLine();
                                                    scanner.nextLine();
                                                    System.out.println(polName + "(It does end up with Dutch being named “bright hostage” (Gijsberta) though)");
                                                    scanner.nextLine();
                                                    break;

                                                  case "3":// don't say anything
                                                    break;

                                                  default:
                                                    System.out.print("(Invalid input) ");
                                                    break;
                                                }
                                              }
                                              while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                                              break;

                                            default:
                                              System.out.print("(Invalid input)");
                                          }
                                        } while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")) && !(input.equals("5")));
                                        break;
                                      } 
                                      break;

                                    case "3":// job and hobbies
                                      obj.afDe();
                                      if (obj.checkAffectionLow()) {
                                        System.out.print("\n" + polName + "You know what, I’m sick of you and your disgusting face. Get lost. Don’t see me ever again.");
                                        scanner.nextLine();
                                        System.out.print("...\nEnding: Disgusted");
                                        pw.println("Disgusted");
                                        pw.close();
                                        System.exit(0);
                                      }
                                      System.out.println(polName + "That’s none of your business. (affection -1)");
                                      obj.printOptions("\"But I wanna know...\"", "\"It’s for an interview.\"", "(don’t say anything)", "", "");
                                      
                                      do {
                                        input = scanner.next();
                                        System.out.println("\n");
                                        switch (input) {
                                          case "1":// wanna know
                                            obj.paDe();
                                            if (obj.comparePatience()) {
                                              System.out.print("\n" + polName + "You know what, I’m done with your time wasting. Get lost. Don’t see me ever again.");
                                              scanner.nextLine();
                                              System.out.print("...\nEnding: Annoyed");
                                              pw.println("Annoyed");
                                              pw.close();
                                              System.exit(0);
                                            }
                                            System.out.print(polName + "Shut up. (patience -1)");
                                            scanner.nextLine();
                                            break;

                                          case "2":// interview
                                            obj.afDe();
                                            if (obj.checkAffectionLow()) {
                                              System.out.print("\n" + polName + "You know what, I’m sick of you and your disgusting face. Get lost. Don’t see me ever again.");
                                              scanner.nextLine();
                                              System.out.print("...\nEnding: Disgusted");
                                              pw.println("Disgusted");
                                              pw.close();
                                              System.exit(0);
                                            }
                                            obj.paDe();
                                            if (obj.comparePatience()) {
                                              System.out.print("\n" + polName + "You know what, I’m done with your time wasting. Get lost. Don’t see me ever again.");
                                              scanner.nextLine();
                                              System.out.print("...\nEnding: Annoyed");
                                              pw.println("Annoyed");
                                              pw.close();
                                              System.exit(0);
                                            }
                                            System.out.print(polName + "Don’t act like I’m stupid.” (affection -1) (patience -1).");
                                            scanner.nextLine();
                                            break;

                                          case "3":
                                            break;

                                          default:
                                            System.out.print("(Invalid input) ");
                                        }
                                      }
                                      while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                                      break;

                                    case "4":// where you live
                                      obj.afDe();
                                      obj.afDe();
                                      if (obj.checkAffectionLow()) {
                                        System.out.print("\n" + polName + "You know what, I’m sick of you and your disgusting face. Get lost. Don’t see me ever again.");
                                        scanner.nextLine();
                                        System.out.print("...\nEnding: Disgusted");
                                        pw.println("Disgusted");
                                        pw.close();
                                        System.exit(0);
                                      }
                                      System.out.println(polName + "Fuck off. (affection -2)");
                                      scanner.nextLine();
                                      break;

                                    case "5":// how you feel about...
                                      System.out.println();
                                      obj.printOptions("\"Latin’s death.\"", "\"Your experience with Yiddish’s near-death(s).\"", "\"Russian’s 180 (sort of).\"", "\"Your 180 on Kashubian.\"", "\"The fact that you are a fictional character trapped inside a screen with no means of escape and is completely at the mercy of the developer making this stupid game\n  and me who can change the code however I want so I can do whatever I want because I know java and -\"");
                                      
                                      do {
                                        input = scanner.next();
                                        System.out.println("\n");
                                        switch (input) {
                                          case "1":// Latin's death
                                            System.out.print("She slams the table and stands up.");
                                            scanner.nextLine();
                                            scanner.nextLine();
                                            System.out.println(polName + "Why do you have to bring this up!?!? We were just having a normal conversation.");
                                            scanner.nextLine();
                                            System.out.print("You look up, only to see her barely holding back tears.");
                                            scanner.nextLine();
                                            System.out.print(polName + "I...I...");
                                            scanner.nextLine();
                                            System.out.print("She tugs you by the collar and shoves you out of the room.");
                                            scanner.nextLine();
                                            System.out.print("Before you could turn your head, you hear her cold voice.");
                                            scanner.nextLine();
                                            System.out.print(polName + "Farewell.");
                                            scanner.nextLine();
                                            System.out.print("The door locks behind you.");
                                            scanner.nextLine();
                                            System.out.print("\n\nEnding: Heartbroken\n*Note: Poland is very Catholic and Polish remains the Slavic language that received most influence from Latin (even after small-scale language purism movements).");
                                            pw.println("Heartbroken");
                                            pw.close();
                                            System.exit(0);
                                            break;

                                          case "2":// ydd
                                            System.out.print(polName + "That’s...oh boy.");
                                            scanner.nextLine();
                                            scanner.nextLine();
                                            System.out.println(polName + "I knew he was an endangered language at first sight. He crossed the border into Poland, barely escaping from Western Europe.");
                                            scanner.nextLine();
                                            System.out.print(polName + "I expected him to die soon, but...he didn’t.");
                                            scanner.nextLine();
                                            System.out.print(polName + "He kept thanking me for \"saving\" him and offered to work for me.");
                                            scanner.nextLine();
                                            System.out.print(polName + "He got well enough that I thought he wouldn’t die...");
                                            scanner.nextLine();
                                            System.out.print(polName + "Until the Haskalah, that is.");
                                            scanner.nextLine();
                                            System.out.print(polName + "I had other problems to deal with, so I barely met him.");
                                            scanner.nextLine();
                                            System.out.print(polName + "But every time I did, his smile just kept getting hollower.");
                                            scanner.nextLine();
                                            System.out.print(polName + "There were multiple times when he looked injured and about to break down, but he managed not to.");
                                            scanner.nextLine();
                                            System.out.print(polName + "I...really felt bad for him, and thought he would die right there.");
                                            scanner.nextLine();
                                            System.out.print(polName + "Then...well, he left my realm of control.");
                                            scanner.nextLine();
                                            System.out.print(polName + "I didn’t hear much from then on, but I did want him to be safe.");
                                            scanner.nextLine();
                                            System.out.print(polName + "(Luckily he went to America.)");
                                            scanner.nextLine();
                                            System.out.print(polName + "Decades later, when I learned that he was alive and well, I was...astonished.");
                                            scanner.nextLine();
                                            System.out.print(polName + "I didn’t know what to feel...and don’t even know now.");
                                            scanner.nextLine();
                                            System.out.print(polName + "He still speaks Polish and is good to me, so I guess I should move on.");
                                            scanner.nextLine();
                                            System.out.print(polName + "(Just like he did.)");
                                            scanner.nextLine();
                                            System.out.print(polName + "I guess my best answer to your question is...\"I don’t know.\"");
                                            scanner.nextLine();
                                            System.out.print("She sighs.");
                                            scanner.nextLine();
                                            System.out.print(polName + "...");
                                            scanner.nextLine();
                                            System.out.print(polName + "Thanks for letting me ramble. (affection +1)");
                                            obj.afIn();
                                            System.console().readLine();
                                            break;

                                          case "3":// rus
                                            System.out.print(polName + "Oh, the guy who absolutely dreads me but once admired me? Can’t forget that.");
                                            scanner.nextLine();
                                            scanner.nextLine();
                                            System.out.println(polName + "He used to learn from me, but now he constantly wants to kill me, and I also want to kill him.");
                                            scanner.nextLine();
                                            System.out.print(polName + "The only thing preventing that is geography.");
                                            scanner.nextLine();
                                            obj.printOptions("\"I thought he always hated you and just pretended to be nice.\"", "\"I thought he always admired you and is just pretending to hate you.\"", "\"I don’t think geography is the problem here...\"", "(don’t say anything)", "");
                                            
                                            do {
                                              input = scanner.next();
                                              System.out.println("\n");
                                              switch (input) {
                                                case "1":// hated
                                                  System.out.print(polName + "Never underestimate my charm.");
                                                  scanner.nextLine();
                                                  break;

                                                case "2":// tsun
                                                  System.out.print(polName + "Wrong. We actually do hate each other.");
                                                  scanner.nextLine();
                                                  System.out.println(polName + "Central/Eastern Europe is the wrong place to look for tsunderes.");
                                                  obj.printOptions("\"Does that mean that Western Europe is where I should look for tsunderes?\"", "(don't say anything)", "", "", "");
                                                  
                                                  do {
                                                    input = scanner.next();
                                                    System.out.println("\n");
                                                    switch (input) {
                                                      case "1":
                                                        System.out.print(polName + "You, could say that, yeah.");
                                                        scanner.nextLine();
                                                        break;

                                                      case "2":
                                                        break;

                                                      default:
                                                        System.out.print("(Invalid input) ");
                                                        break;
                                                    }
                                                  } while (!(input.equals("1")) && !(input.equals("2")));
                                                  break;

                                                case "3":// geo not prob
                                                  obj.paDe();
                                                  if (obj.comparePatience()) {
                                                    System.out.print("\n" + polName + "You know what, I’m done with your time wasting. Get lost. Don’t see me ever again.");
                                                    scanner.nextLine();
                                                    System.out.print("...\nEnding: Annoyed");
                                                    pw.println("Annoyed");
                                                    pw.close();
                                                    System.exit(0);
                                                  }
                                                  System.out.println(polName + "Yes yes languages don’t die like that I know you’re annoying. (patience -1)");
                                                  scanner.nextLine();
                                                  break;

                                                case "4":
                                                  break;

                                                default:
                                                  System.out.print("(Invalid input)");
                                                  break;
                                              }
                                            } 
                                            while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3"))
                                                && !(input.equals("4")));
                                            break;

                                          case "4":// csb
                                            System.out.print(polName + "I actually didn’t plan that out at all. It just happened. I still can’t explain it.");
                                            scanner.nextLine();
                                            scanner.nextLine();
                                            System.out.println(polName + "You should've seen the look on his face though. It was priceless.");
                                            scanner.nextLine();
                                            System.out.print(polName + "He stared at me for five whole minutes when I told him he was official. I tried so hard not to laugh.");
                                            scanner.nextLine();
                                            System.out.print(polName  + "He’s still confused but seems to like it. That’s what matters anyway...maybe.");
                                            break;

                                          case "5":// DDLC. This part is so good that I want her to say this entire thing before checking patience and affection
                                            System.out.print("She slams the table and stands up.");
                                            scanner.nextLine();
                                            scanner.nextLine();
                                            System.out.println(polName + "Ugh will you shut up?? Stop acting like I’m stupid and know nothing. (affection -2) (patience -2)");
                                            obj.afDe();
                                            obj.afDe();
                                            obj.paDe();
                                            obj.paDe();
                                            scanner.nextLine();
                                            System.out.print(polName + "Listen, this is no Doki Doki. There’s none of the \"virtual reality\" and \"simulation in a computer\" nonsense. It’s just a game made for fun and to give insight about all the characters involved.");
                                            scanner.nextLine();
                                            if (obj.checkAffectionLow()) {
                                              System.out.print("\n" + polName + "I’m sick of you and your disgusting face. Get lost. Don’t see me ever again.");
                                              scanner.nextLine();
                                              System.out.print("...\nEnding: Disgusted but meta");
                                              pw.println("Disgusted but meta");
                                              pw.close();
                                              System.exit(0);
                                            }
                                            
                                            if (obj.comparePatience()) {
                                              System.out.print("\n" + polName + "I’m done with your time wasting. Get lost. Don’t see me ever again.");
                                              scanner.nextLine();
                                              System.out.print("...\nEnding: Annoyed but meta");
                                              pw.println("Annoyed but meta");
                                              pw.close();
                                              System.exit(0);
                                            }
                                            
                                            if (ranTutorial) {
                                              System.out.print(polName + "And I’m not the only one aware of this. Remember the tutorial guy? He knows everything too.");
                                              scanner.nextLine();
                                              System.out.print(polName + "In fact, I bet he’s playing this game right now. Heard (from Yiddish) that he’s into this kind of stuff.");
                                              scanner.nextLine();
                                            }
                                            
                                            System.out.print(polName + "So quit. It. Now.");
                                            scanner.nextLine();
                                            System.out.print("She sits back down.");
                                            scanner.nextLine();
                                            break;

                                          default:
                                            System.out.print("(Invalid input)");
                                            break;
                                        }
                                      }
                                      while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")) && !(input.equals("5")));
                                      break;

                                    default:
                                      System.out.print("(Invalid input)");
                                      break;
                                  }
                                } while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")) && !(input.equals("5")));
                                break;

                              case "2":
                                break;

                              case "3":
                                break;

                              default:
                                System.out.print("(Invalid input)");
                                break;
                            }
                            input = "1";
                          } 
                          while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")) && !(input.equals("5")));
                          break;
                      }
                    }
                    while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")) && !(input.equals("5")));
                    input = "1";
                    break;

                  case "3":// gained info
                    if (mrn && !doneMrn) {
                      System.out.println();
                      obj.printOptions("What would happen if Czech and Yiddish collaborated and produced a puppet show? (mrn)", "", "", "", "");
                      do {
                        input = scanner.next();
                        System.out.println();
                        System.out.println(polName + "Who would initiate the process?");
                        obj.printOptions("\"Czech would initiate it.\"", "\"Yiddish would initiate it.\"", "\"You’d initiate it.\"", "", "");
                        do {
                          input = scanner.next();

                          System.out.println("\n");
                          switch (input) {
                            case "1":// cz
                              System.out.print(polName + "Nope, she doesn’t like collaboration.");
                              break;

                            case "2":// ydd
                              System.out.print(polName + "Nope, he doesn’t have the courage to ask her.");
                              break;

                            case "3":// you
                              System.out.print(polName + "You’re not wrong. (affection +1)");
                              obj.afIn();
                              break;

                            default:
                              System.out.print("(Invalid input)");
                          }
                          scanner.nextLine();
                        }
                        while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                        System.out.println();

                        System.out.print(polName + "I have a rough idea of the genre and the overall focal points. Wanna guess?\n");
                        obj.printOptions("\"It’s a domestic drama focusing on class struggles.\"", "\"It’s a comedic satire bitterly criticizing totalitarian rule and assimilation.\"", "\"It’s an absurdist piece including mental breakdowns due to trauma.\"", "", "");

                        do {
                          input = scanner.next();
                          System.out.println("\n");
                          switch (input) {
                            case "1":// class
                              System.out
                                  .print(polName + "Czech’s ok with that, but Yiddish would think it’s \"overdone\".");
                              break;

                            case "2":// satire
                              System.out.print(polName + "Seems about right. (affection + 1)");
                              obj.afIn();
                              scanner.nextLine();
                              System.out.print(polName + "It sounds boring, but they always find a way to spice up such content.");
                              break;

                            case "3":// trauma
                              System.out.print(polName + "Yiddish would LOVE to make that, but Czech would laugh and say it’s \"unrelatable.\"");
                              break;

                            default:
                              System.out.print("(Invalid input)");
                          }
                        } 
                        while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                        scanner.nextLine();
                        System.out.println();

                        System.out.println(polName + "Wonder what they'll say when they read each other’s written works...");
                        obj.printOptions("\"They’d be amazed at the other’s skill or lack there of.\"", "\"They’d be horrified at how different the other’s style is.\"", "\"They likely won’t be able to read the other’s handwriting.\"", "", "");
                        
                        do {
                          input = scanner.next();
                          System.out.println("\n");
                          switch (input) {
                            case "1":// skill
                              System.out.print(polName + "This reaction’s too intuitive.");
                              break;

                            case "2":// style
                              System.out.print(polName + "Obviously.");
                              break;

                            case "3":// handwriting
                              System.out.print(polName + "They likely won’t be reading any handwriting, but I do like imagining them being completely lost.” (affection +1)");
                              obj.afIn();
                              break;

                            default:
                              System.out.print("(Invalid input)");
                          }
                        }
                        while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                        scanner.nextLine();
                        System.out.println();

                        System.out.println(polName + "Who would they invite to proofread it though...");
                        obj.printOptions("\"No one.\"", "\"You.\"", "\"General American English.\"", "\"Slovak.\"", "");
                        
                        do {
                          input = scanner.next();
                          System.out.println("\n");
                          switch (input) {
                            case "1":// no one
                              System.out.print(polName + "Yeah, I can imagine Yiddish getting awkward when Czech hands the writing to someone else.");
                              break;

                            case "2":// pol
                              System.out.print(polName + "I do hope so. (affection +1)");
                              obj.afIn();
                              break;

                            case "3":// GAE
                              System.out.println(polName + "More like him \"volunteering\" to proofread it and getting all excited over this \"legendary crossover\".");
                              obj.printOptions("\"Does he actually think it’s \"legendary\"?\"", "\"Why would he get excited?\"", "(don’t say anything)", "", "");
                              
                              do {
                                input = scanner.next();
                                System.out.println("\n");
                                switch (input) {
                                  case "1":// legendary
                                    System.out.print(polName + "No. He just likes hyperboles.");
                                    break;

                                  case "2":// excited
                                    System.out.print(polName + "(according to Yiddish) he always does.");
                                    break;

                                  case "3":
                                    break;

                                  default:
                                    System.out.print("(Invalid input) ");
                                }
                              }
                              while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
                              break;

                            case "4":// slk
                              System.out.print(polName + "Not probable but an interesting proposal. From what I heard from Czech, Slovak would look ultra confused, then reluctantly start reading, and finally reply “it’s alright” while looking like he just wants to go home.");
                              scanner.nextLine();
                              System.out.println(polName + "Yiddish would be cringing the entire time before whispering an apology to Slovak as they part.");
                              break;

                            default:
                              System.out.print("(Invalid input) ");
                              break;
                          }
                        } 
                        while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")));
                        scanner.nextLine();
                        System.out.println();

                        System.out.print(polName + "I know where they will showcase this piece first. What do you think?\n");
                        obj.printOptions("\"Prague.\"", "\"New York.\"", "\"Warsaw.\"", "\"On Czech’s and Yiddish’s respective Youtube channels.\"", "");
                        
                        do {
                          input = scanner.next();
                          System.out.println("\n");
                          switch (input) {
                            case "1":// prague
                              System.out.print(polName + "Yiddish doesn’t spend that much money on a plane ticket.");
                              break;

                            case "2":// NY
                              System.out.print(polName + "Czech’s not traveling that far.");
                              break;

                            case "3":// warsaw
                              System.out.print(polName + "That’s...not happening.");
                              break;

                            case "4":// YT
                              System.out.print(polName + "It will be the first and only video on Yiddish’s channel. (affection +1)");
                              obj.afIn();
                              break;

                            default:
                              System.out.print("(Invalid input) ");
                          }
                        } 
                        while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")));
                        scanner.nextLine();
                        System.out.println();

                        System.out.print(polName + "I do want them to collaborate now, but I can’t find the words.");
                        scanner.nextLine();
                        scanner.nextLine();
                        System.out.println(polName + "Oh well, maybe I will tomorrow.");
                        scanner.nextLine();
                        System.out.print("Topic complete!! (affection + 1)");
                        obj.afIn();
                        scanner.nextLine();
                        System.out.println();
                        doneMrn = true;
                        input = "1";
                      }
                      while (!(input.equals("1")));
                    } 
                    else {
                      System.out.print("There are currently no pieces of information that you can use.");
                      scanner.nextLine();
                    }
                    break;

                  default:
                    System.out.print("(Invalid input) ");
                    break;
                }
                input = "1";
              }
              while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
            }
            break;

          case "2": // check
            System.out.println();
            obj.printOptions("Check character", "Check status", "", "", "");
            
            do {
              input = scanner.next();
              System.out.println("\n");
              switch (input) {
                case "1":// character
                  if (!trueIdentity) {
                    System.out.print("Malina Stanisławska, a Lechitic (part of West Slavic) woman. She does not like wasting time but is willing to provide you with insight of this fictional world.\nMalina does not seem to be her real name, though...");
                  } 
                  else {
                    System.out.print("The Polish language (polski, język polski, or polszczyzna), a Lechitic (part of West Slavic) language. She might seem like an average national language nowadays, but she used to be a glorious lingua franca throughout Eastern and Balkan Europe.\nShe does not like wasting time but is willing to provide you with insight of this fictional world.\nHer natural enemies are Standard High German (SHG) and Russian.");
                  }
                  scanner.nextLine();
                  System.out.println("\n");
                  break;

                case "2":// status
                  obj.checkStatus();
                  scanner.nextLine();
                  break;

                default:
                  System.out.print("(Invalid input) ");
              }
            } 
            while (!(input.equals("1")) && !(input.equals("2")));
            break;

          case "3":// exit
            System.out.print("Are you sure you want to exit? (y/n)");
            
            do {
              System.out.println();
              input = scanner.next();
              switch (input) {
                case "y":
                  System.out.print("\n" + polName + "Oh, you’re leaving?");
                  scanner.nextLine();
                  scanner.nextLine();
                  
                  if (obj.compareAffectionEnough()) {
                    System.out.print(polName + "Well, see you next time.");
                    System.console().readLine();
                    System.out.println("Ending: Friends now!!...maybe.");
                    pw.println("Friends now!!...maybe.");
                    pw.close();
                  } 
                  else {
                    System.out.print(polName + "Well, bye then.");
                    System.console().readLine();
                    System.out.print("Ending: Nothing special");
                    pw.println("Nothing special");
                    pw.close();
                  }
                  System.exit(0);
                  break;

                case "n":
                  break;

                default:
                  System.out.print("(Invalid input)");
                  break;

              }
            }
            while (!(input.equals("y")) && !(input.equals("n")));
            break;

          default:
            System.out.print("(Invalid input) ");
            break;
        }
        input = "1";
      } while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));
    }
  }
}