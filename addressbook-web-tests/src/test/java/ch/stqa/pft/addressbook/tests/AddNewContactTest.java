package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase {

    @Test
    public void testAddNewContact() {

        int before = app.getContactHelper().getGroupCount();
        app.getContactHelper().createContact(new ContactData("FN77", null, "Happy st.77", "777777777", "о, святые печеньки1"));
        int after = app.getContactHelper().getGroupCount();
        Assert.assertEquals(after, before +1);

    }

}
