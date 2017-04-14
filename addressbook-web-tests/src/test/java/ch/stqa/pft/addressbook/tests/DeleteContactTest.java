package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {

  @Test
  public void testDeleteContact() {

    int before = app.getContactHelper().getGroupCount();
    if (! app.getContactHelper().isThereAContact()) {
    app.getContactHelper().createContact(new ContactData("FN77", null, "Happy st.77", "777777777", "о, святые печеньки1"));
    }
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().confirmContactDeletion();
    int after = app.getContactHelper().getGroupCount();
    Assert.assertEquals( after, before -1 );

  }
}
