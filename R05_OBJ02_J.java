/******************************************************************************
 * Rule 05. Object Orientation (OBJ)
 * OBJ02-J. Preserve dependencies in subclasses when changing superclasses
 * Failure to maintain all relevant invariants can cause security vulnerabilities.
 ******************************************************************************/
class CalendarSubclass extends Calendar {
  @Override public boolean after(Object when) {
    // Correctly calls Calendar.compareTo()
    if (when instanceof Calendar &&
        super.compareTo((Calendar) when) == 0) {
      return true;
    }
    return super.after(when);
  }
 
  @Override public int compareTo(Calendar anotherCalendar) {
    return compareDays(this.getFirstDayOfWeek(),
                       anotherCalendar.getFirstDayOfWeek());
  }
 
  private int compareDays(int currentFirstDayOfWeek,
                          int anotherFirstDayOfWeek) {
    return (currentFirstDayOfWeek > anotherFirstDayOfWeek) ? 1
           : (currentFirstDayOfWeek == anotherFirstDayOfWeek) ? 0 : -1;
  }
 
  public static void main(String[] args) {
    CalendarSubclass cs1 = new CalendarSubclass();
    cs1.setTime(new Date());
    // Date of last Sunday (before now)
    cs1.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    // Wed Dec 31 19:00:00 EST 1969
    CalendarSubclass cs2 = new CalendarSubclass();
    // Expected to print true
    System.out.println(cs1.after(cs2));
  }
 
  // Implementation of other Calendar abstract methods
}