package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by annaryapolova on 08.04.17.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification () {

    //app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("FN77", null, "Happy st.77", "777777777", "о, святые печеньки1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContact(before.size() - 1);
    app.getContactHelper().fillNewContact(new ContactData("FN12", "LN12", "Happy st.11", "1111111", null), false);
    app.getContactHelper().updateContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

  }

}
