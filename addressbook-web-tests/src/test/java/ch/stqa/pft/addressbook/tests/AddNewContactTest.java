package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddNewContactTest extends TestBase {

  @Test
  public void testAddNewContact() {

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactData("FN77", null, "Happy st.77", "777777777", "о, святые печеньки1"));
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
