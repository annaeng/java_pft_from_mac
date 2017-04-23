package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import ch.stqa.pft.addressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewContactTest extends TestBase {

  @Test
  public void testAddNewContact() {

    Contacts before = app.contact().all();
    ContactData contact = new ContactData().
            withFirstname("FN1").withLastname("LN1").withAddress("Happy st.1").withMobil("1111").withGroup("о, святые печеньки1");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

  @Test
  public void testBadAddNewContact() {

    Contacts before = app.contact().all();
    ContactData contact = new ContactData().
            withFirstname("FN1'").withLastname("LN1").withAddress("Happy st.1").withMobil("1111").withGroup("о, святые печеньки1");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

}

