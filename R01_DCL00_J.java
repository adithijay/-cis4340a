/******************************************************************************
 * Rule 01. Declarations and Initialization (DCL)
 * DCL00-J. Prevent class initialization cycles
 * Initialization of a class consists of executing its static initializers and the initializers for static fields (class variables) declared in the class.
 ******************************************************************************/
public class Cycle {
  private final int balance;
  private static final int deposit = (int) (Math.random() * 100); // Random deposit
  private static final Cycle c = new Cycle();  // Inserted after initialization of required fields
  public Cycle() {
    balance = deposit - 10; // Subtract processing fee
  }
 
  public static void main(String[] args) {
    System.out.println("The account balance is: " + c.balance);
  }
}
