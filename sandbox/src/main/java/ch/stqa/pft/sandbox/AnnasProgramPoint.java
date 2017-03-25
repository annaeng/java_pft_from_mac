package ch.stqa.pft.sandbox;

public class AnnasProgramPoint {

  public static void main(String[] args) {
    // создаем переменную p1
    Point p1 = new Point (2,6);
    // это были аттрибуты которые теперь заполняются в конструкторе
    // p1.x = 2;
    // p1.y = 6;
    Point p2 = new Point (4,3);
    //p2.x = 4;
    //p2.y = 3;

                                                                  // обращаемся к аттрибуту x через переменную p1
    System.out.println(" Точка P1 имеет координаты: " + " x1 = " + p1.x + " ; " + " y1 = " + p1.y );
    System.out.println(" Точка P2 имеет координаты: " + " x2 = " + p2.x + " ; " + " y2 = " + p2.y );

    //мы не передаем p1 больше в качестве параментра, а указываем его перед названием метода
    //это работает так:
    //java находит функцию (distanse) которая находится в классе соответствующем этому объекту(p1), т.е. в классе Point
    System.out.println(" Расстояние между точками " + " равно " + p1.distance(p2));
  }

 // public static double distance (Point p1 , Point p2) {
   // return Math.sqrt( (p2.x - p1.x)*(p2.x - p1.x)+ (p1.y - p2.y)*(p1.y - p2.y) );


}

//p1.distance(p2)

// Square s = new Square(5);
// System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

