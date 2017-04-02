package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by annaryapolova on 27.03.17.
 */
public class TestBase {

  public final ApplicationManager app = new ApplicationManager();
  // не знаю оставить или убрать: protected final ApplicationManager applicationManager = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }


}
