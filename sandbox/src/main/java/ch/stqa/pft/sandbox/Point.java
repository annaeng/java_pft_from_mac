package ch.stqa.pft.sandbox;

/**
 * Created by annaryapolova on 21.03.17.
 */
public class Point {

  public double x;
  public double y;


  //это конструктор = необычная функция. название как у класса и нет возвращаемого значения.
  //тип возвращаемого значения перед именем не уквзывается (double)
  // так же как и функция можкт принимать параметры. здесь double x double y
  public Point(double x, double y) {
    //дальше идет код который инициализирует  новый объект,т.е. заполняет его значениями
    //this это спец. переменная, кот. ссылается на конструируемый объект внутри конструктора
    //значение аттрибута создаваемого объекта = значению параметра переданного в конструктор
    this.x = x;
    this.y = y;
    //это метод, он ассоциирован с объектом , поэтому передавать объект в качестве параметра не нужно
    // (удалили их в скобочках)
    // обращаемся к ассоциируему объекту через ключевое слово this
  }
    // дальше p1 превратился в this, а p2 остался параметром)
  public double distance(Point p2) {
    return Math.sqrt( (p2.x - this.x)*(p2.x - this.x)+ (this.y - p2.y)*(this.y - p2.y) );

  }
}





