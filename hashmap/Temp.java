public class Temp {
  public static void main(String[] args) {
    Integer i = new Integer(10);
    Integer j = new Integer(10);

    assert i.equals(j) == true;
    assert i.hashCode() == j.hashCode();

    Boolean x = true;
    Boolean y = false;   
    
    System.out.println(x.hashCode());
    System.out.println(y.hashCode());
  }
}
