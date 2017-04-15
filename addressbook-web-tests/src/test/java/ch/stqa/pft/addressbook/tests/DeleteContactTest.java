package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteContactTest extends TestBase {

  @Test
  public void testDeleteContact() {

    if (! app.getContactHelper().isThereAContact()) {
    app.getContactHelper().createContact(new ContactData("FN77", null, "Happy st.77", "777777777", "о, святые печеньки1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().confirmContactDeletion();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

  }
}
