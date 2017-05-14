package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import ch.stqa.pft.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class DeleteContactTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().clickHomePage();
      app.contact().create(new ContactData().
              withFirstname("FN77").withLastname("LN77").withAddress("Happy st.77").withMobilePhone("777777777")
              //.withGroup("о, святые печеньки1")
      );
    }
  }

  @Test
  public void testDeleteContact() {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();

    app.contact().delete(deletedContact);

    assertThat(app.contact().count(), equalTo(before.size() -1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUI ();
  }

}
