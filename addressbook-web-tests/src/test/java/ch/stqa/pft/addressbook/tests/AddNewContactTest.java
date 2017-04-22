package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class AddNewContactTest extends TestBase {

  @Test
  public void testAddNewContact() {

    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().
            withFirstname("FN1").withLastname("LN1").withAddress("Happy st.1").withMobil("1111").withGroup("о, святые печеньки1");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);

  }


}
