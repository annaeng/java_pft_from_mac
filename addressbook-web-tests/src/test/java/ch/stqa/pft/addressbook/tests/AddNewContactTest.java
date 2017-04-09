package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase {

    @Test
    public void testAddNewContact() {

        app.getNavigationHelper().goToAddNewContact();
        app.getContactHelper().fillNewContact(new ContactData("FN77", null, "Happy st.77", "777777777"));
        app.getContactHelper().submitNewContact();
        app.getNavigationHelper().goToHomePage();
    }

}
