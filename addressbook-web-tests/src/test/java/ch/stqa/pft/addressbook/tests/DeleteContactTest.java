package ch.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {

  @Test
  public void testDeleteContact() {

    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().confirmContactDeletion();

  }
}
