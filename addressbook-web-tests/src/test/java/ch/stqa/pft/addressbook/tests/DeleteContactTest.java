package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.tests.TestBase;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {

  @Test
  public void testDeleteContact() {


    app.selectContact();
    app.deleteContact();
    app.confirmContactDeletion();


  }

}
