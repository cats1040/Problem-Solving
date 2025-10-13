public class Student implements Comparable<Student>, Iterable<Student> {
  // here we are using implements
  // implements allows multiple parents
  private int rollNumber;
  private String name;

  @Override
  public int compareTo(Student s) {
    return this.rollNumber - s.rollNumber;
  }

  public static void main(String[] args) {
    BST<Student, Integer> bst = new BST<Student, Integer>();
  }
}
