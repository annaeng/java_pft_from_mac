package ch.stqa.pft.sandbox;

public class AnnasProgramPoint {

  public static void main(String[] args) {

    Point p1 = new Point (2, 6);
    Point p2 = new Point (4, 3);

    System.out.println("Расстояние между точкой с координатами " + "x = " + p1.x + " ; " + "y = " + p1.y + " и " +
            "точкой с координатами " + "x = " + p2.x + " ; " + "y = " + p2.y + " равно " + distance (p1, p2) );
  }

  public static double distance (Point p1, Point p2) {

    return Math.sqrt( (p2.x - p1.x)*(p2.x - p1.x)+ (p1.y - p2.y)*(p1.y - p2.y) );
  }
}



