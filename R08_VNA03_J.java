/******************************************************************************
 * Rule 08. Visibility and Atomicity (VNA)
 * VNA03-J. Do not assume that a group of calls to independently atomic methods is atomic
 * When presented with a set of operations, where each is guaranteed to be atomic, it is tempting to assume that a single operation consisting of individually atomic 
 * operations is guaranteed to be collectively atomic without additional locking. 
 ******************************************************************************/
final class Adder {
  private final AtomicReference<BigInteger> first;
  private final AtomicReference<BigInteger> second;
 
  public Adder(BigInteger f, BigInteger s) {
    first  = new AtomicReference<BigInteger>(f);
    second = new AtomicReference<BigInteger>(s);
  }
 
  public void update(BigInteger f, BigInteger s) { // Unsafe
    first.set(f);
    second.set(s);
  }
 
  public BigInteger add() { // Unsafe
    return first.get().add(second.get());
  }
}