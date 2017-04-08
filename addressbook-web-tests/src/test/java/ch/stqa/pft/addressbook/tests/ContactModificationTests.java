package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by annaryapolova on 08.04.17.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification () {

    //app.getNavigationHelper().goToHomePage();
    app.getContactHelper().editContact();
    app.getContactHelper().fillNewContact(new ContactData("FN11", "LN11", "Happy st.11", "1111111"));
    app.getContactHelper().updateContact();

  }

}
