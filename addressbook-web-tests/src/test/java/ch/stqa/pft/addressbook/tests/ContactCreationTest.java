package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import ch.stqa.pft.addressbook.model.Contacts;
import ch.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    File photo = new File("src/test/resources/stru.png");
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData().withFirstname("FN1").withLastname("LN1").withAddress("Happy st.1").withMobilePhone("1111").withPhoto(photo)});
    list.add(new Object[] {new ContactData().withFirstname("FN2").withLastname("LN2").withAddress("Happy st.2").withMobilePhone("2222").withPhoto(photo)});
    list.add(new Object[] {new ContactData().withFirstname("FN3").withLastname("LN3").withAddress("Happy st.3").withMobilePhone("3333").withPhoto(photo)});
    return list.iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    Contacts before = app.contact().all();
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    //assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }


  @Test (enabled = false)
  public void testBadAddNewContact() {

    Contacts before = app.contact().all();
    ContactData contact = new ContactData().
            withFirstname("FN1'").withLastname("LN1").withAddress("Happy st.1").withMobil("1111").withGroup("о, святые печеньки1");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

  @Test (enabled = false)
  public void testCurrentDir() {
    File currentDir = new File (".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }



}

