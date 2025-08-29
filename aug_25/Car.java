public class Car {
  private int size;
  private int color;

  Car(int size, int color) {
    this.size = size;
    this.color = color;
  }

  public int getSize() {
    return this.size;
  }

  public int getColor() {
    return this.color;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public boolean equals(Object o) {
    Car c = (Car) o;
    if (this.size == c.getSize() && this.color == c.getColor()) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Car car1 = new Car(5, 6);
    Car car2 = new Car(5, 6);

    System.out.println(car1 == car2);
    System.out.println(car1.equals(car2));
  }
}
