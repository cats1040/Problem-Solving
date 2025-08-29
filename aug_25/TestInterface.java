interface I {
  public void foo();
  public void bar();
}

public class TestInterface implements I {
  public void foo() {
    System.out.println("Hello");
  }
  
  /**
  public void bar() {
    System.out.println("Bye");
  }
  */

  public static void main(String[] args) {
    TestInterface t = new TestInterface();
    t.foo();
  }
}
