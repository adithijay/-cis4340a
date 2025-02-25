/******************************************************************************
 * Rule 09. Locking (LCK)
 * LCK10-J. Use a correct form of the double-checked locking idiom
 * The double-checked locking idiom is a software design pattern used to reduce the overhead of acquiring a lock by first testing the locking criterion 
 * without actually acquiring the lock. 
 ******************************************************************************/
// Double-checked locking idiom
final class Foo {
  private Helper helper = null;
  public Helper getHelper() {
    if (helper == null) {
      synchronized (this) {
        if (helper == null) {
          helper = new Helper();
        }
      }
    }
    return helper;
  }
 
  // Other methods and members...
}