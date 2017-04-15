package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AddNewContactTest extends TestBase {

  @Test
  public void testAddNewContact() {

    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("FN88", null, "Happy st.77", "777777777", "о, святые печеньки1");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((Comparator<ContactData>)(o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


  }

}
