package ch.stqa.pft.sandbox;

public class AnnasProgramPoint {

  public static void main(String[] args) {
    //distance(5, 3);
    // в круглых скобках значения которые передаются в параметры функции distance
    double p1 = 5;
    double p2 = 3;
    System.out.println("Расстояние между точками " + p1 + " и " + p2 + " равно " + distance (p1, p2) );

  }

  public static double distance(double p1, double p2) {
    // в круглых скобках параметры функции distance
    return p1 - p2;

  }
}


/**public static double distance(Point p1, Point p2) {
 которая вычисляет расстояние между двумя точками. Для вычисления квадратного корня можно использовать функцию Math.sqrt

 //3. Сделать запускаемый класс, то есть содержащий функцию public static void main(String[] args) {...}
 //и при помощи него убедиться, что функция вычисления расстояния между точками действительно работает. Результат вычисления выводить на экран и контролировать визуально.

 String distance = "Расстояние между точками ";
 double p1 = 1;
 double p2 = 5;
 double d = p2 - p1;
 System.out.println(distance + p1 + " и " + p2 + " = " + d);
 */
/**public static double distance(Point p1, Point p2) {
 которая вычисляет расстояние между двумя точками. Для вычисления квадратного корня можно использовать функцию Math.sqrt

 //3. Сделать запускаемый класс, то есть содержащий функцию public static void main(String[] args) {...}
 //и при помощи него убедиться, что функция вычисления расстояния между точками действительно работает. Результат вычисления выводить на экран и контролировать визуально.

 String distance = "Расстояние между точками ";
 double p1 = 1;
 double p2 = 5;
 double d = p2 - p1;
 System.out.println(distance + p1 + " и " + p2 + " = " + d);
 */
