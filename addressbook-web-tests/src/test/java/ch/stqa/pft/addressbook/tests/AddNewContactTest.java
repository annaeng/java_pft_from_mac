package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase {

    @Test
    public void testAddNewContact() {

        app.getNavigationHelper().goToAddNewContact();
        app.fillNewContact(new ContactData("FN77", "LN77", "Happy st.77", "777777777"));
        app.submitNewContact();
        app.getNavigationHelper().goToHomePage();
    }

}