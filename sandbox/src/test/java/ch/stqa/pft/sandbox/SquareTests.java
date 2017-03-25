package ch.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by annaryapolova on 21.03.17.
 * в классе кот содержит тесты делать main не нужно тк запускается тестовый framework testNG он находит все тесты выполняет их,
 * генерирует отчет
 * здесь пишем только методы, в отчете каждый метод это отдельный тест
 */
public class SquareTests {
  //аннотация для FW что это тест, вверху появляется import
  @Test
  public void testArea() {
    // создаем новый квадрат со стороной 5
    Square s = new Square(5);
    //спец вспомогат класс Assert
    Assert.assertEquals(s.area(), 25.0);

  }

}

