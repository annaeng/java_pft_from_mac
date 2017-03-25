package ch.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by annaryapolova on 25.03.17.
 */
public class PointTests {

  @Test
  public void testDistance(){

    Point p1 = new Point(2,6);
    Point p2 = new Point(4,3);

    Assert.assertEquals(p1.distance(p2), 3.605551275463989);
  }

  @Test
  public void testDistance1(){

    Point p1 = new Point(1,5);
    Point p2 = new Point(3,2);

    Assert.assertEquals(p1.distance(p2), 3.605551275463989);
  }

  @Test
  public void testDistance2(){

    Point p1 = new Point(2,4);
    Point p2 = new Point(4,3);

    Assert.assertEquals(p1.distance(p2), 2.23606797749979);
  }
}

