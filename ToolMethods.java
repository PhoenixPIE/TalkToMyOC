/** This program contains methods that do not print large amounts of text. */
public class ToolMethods
{   
    private int affection = 0;//how much Polish likes the player;initially 0
    private int patience = 15;//how much longer Polish can tolerate the player; initially 15
    /** increases affection by 1 */
    public void afIn()
      {
        affection ++;
      }
    
    /** decreases affection by 1 */
    public void afDe()
      {  
        affection --;
      }
    
    /** decreases patience by 1 */
    public void paDe()
      {
        patience --;
      }
  
    /** checks if affection is high enough to unlock additional information */
    public boolean compareAffectionEnough()
      {
        return affection >= 10;
      }
  
    /** Checks if affection too low, thus if the player will get kicked out. */
    public boolean checkAffectionLow()
      {
        return affection < -5;
      }
  
    /**
     * Checks whether or not the current affection is greater than or equal to a specific number.
     * @param the desired number to compare the affection to
     * @return whether or not the current affection is greater than or equal to the int compare
     */
    public boolean compareAffection(int compare)
      {
        return affection >= compare;
      }
  
    /**
     * Checks if the current patience is low enough for the player to get kicked out
     */
    public boolean comparePatience()
      {
        return patience <= 0;
      }
  
    /**
     * Prints out all the options that the player can choose from at the moment. There is one println at the end of this.
     * @param these are all of the options. There will be at most five. If there are less options, input an empty String in the argument's place.
     */
    public void printOptions(String one, String two, String three, String four, String five)
      {
        System.out.print("\nOptions:\n");
        
        if (!(one.equals("")))
          {
            System.out.print("1. " + one);
          }
        if (!(two.equals("")))
          {
            System.out.print(" \n2. " + two);
          }
        if (!(three.equals("")))
          {
            System.out.print(" \n3. " + three);
          }
        if (!(four.equals("")))
          {
            System.out.print(" \n4. " + four);
          }
        if (!(five.equals("")))
          {
            System.out.print(" \n5. " + five);
          }
        System.out.println();
      }
  
    /** Prints out information in the check status option */
    public void checkStatus()
    {
        System.out.print("Affection: " + affection + "\nPatience: " + patience);
        System.out.print("\nAffection - how much the character likes you. It starts from zero and can either go up or down. If affection is greater than or equals 10,\n            you will get additional information. If affection goes below -5, you will get kicked out.");
        System.out.print("\nPatience - how long the character can still tolerate you before kicking you out. It starts at 15 and can only go down.\n           If you keep wasting the characters’ time, it might go down. If patience goes to 0 or below, you will get kicked out.");
      System.out.println();
    }
}