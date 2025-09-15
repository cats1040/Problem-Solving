public class B {
  private int x;

  B(int x) {
    this.x = x;
  }

  public static void main(String[] args) {
    B b1 = new B(1);
    B b2 = new B(2);

    System.out.println(b1.hashCode());
    System.out.println(b2.hashCode());
  }
}
