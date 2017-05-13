package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import ch.stqa.pft.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by annaryapolova on 08.04.17.
 */
public class ContactModificationTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().clickHomePage();
      app.contact().create(new ContactData().
              withFirstname("FN77").withLastname("LN77").withAddress("Happy st.77").withMobilePhone("777777777").withGroup("о, святые печеньки1"));
    }

  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
            withId(modifiedContact.getId()).withFirstname("FNmod").withLastname("LN1mod").withAddress("Happy st.11mod").withMobilePhone("1111111mod");
    app.goTo().clickHomePage();
    app.contact().modifyById(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    //assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}
