package ch.stqa.pft.sandbox;

/**
 * Created by annaryapolova on 19.03.17.
 */
public class Rectangle {
  public double a;
  public double b;

  public Rectangle(double a, double b) {
    this.a = a;
    this.b = b;
  }
  public double area () {
    return this.a * this.b;
  }
}
