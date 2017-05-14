package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import ch.stqa.pft.addressbook.model.Contacts;
import ch.stqa.pft.addressbook.model.GroupData;
import ch.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by annaryapolova on 14.05.17.
 */
public class DeleteContactFromGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    // Если нет ни одного контакта - создадим
    if (app.db().contacts().size() == 0) {
      app.contact().clickAddNewContact();
      app.contact().create(new ContactData().withFirstname("FN").withLastname("LN"));
    }

    // Если нет ни одной группы создадём
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }


    // Если нет ни одного контакта - создаём контакт, сразу включив его в какую-то группу
    if (app.db().contacts().size() == 0) {
      Groups groups = app.db().groups();
      app.contact().clickAddNewContact();
      app.contact().create(new ContactData().withFirstname("FN").withLastname("LN").inGroup(groups.iterator().next()));
    }
  }

  @Test
  public void testDeleteContactFromGroup() {

    GroupData group = selectGroupToTest();
    Contacts groupContactsBefore = app.db().contactsInGroupByName(group.getName());

    ContactData contact = groupContactsBefore.iterator().next();
    Groups contactGroupsBefore = app.db().contactById(contact.getId()).getGroups();


    app.goTo().clickHomePage();
    app.contact().deleteContactFromGroup(contact, group);


    Contacts groupContactsAfter = app.db().contactsInGroupByName(group.getName());
    Groups contactGroupsAfter = app.db().contactById(contact.getId()).getGroups();


    // Проверки по данным контакта (группы в контакте)
    assertEquals(contactGroupsAfter.size(), contactGroupsBefore.size() - 1);
    assertThat(contactGroupsAfter, equalTo(contactGroupsBefore.without(app.db().groupByName(group.getName()))));

    // Проверки по данным группы (контакты в группе)
    assertEquals(groupContactsAfter.size(), groupContactsBefore.size() - 1);
    assertThat(groupContactsAfter, equalTo(groupContactsBefore.without(app.db().contactById(contact.getId()))));

  }

  private GroupData selectGroupToTest() {
    Groups groups = app.db().groups(); // Все существующие группы

    // Если в какой-то группе есть существующие контакты, то вернем ее
    for (GroupData group : groups) {
      if (app.db().contactsInGroupByName(group.getName()).size() > 0) {
        return group;
      }
    }
   /*
   * Если ни в одной из существующих групп нет существующих контактов, то выбирем любую
   * Добавим в нее любой контакт
   * И вернем эту группу
   */
    GroupData groupForTest = groups.iterator().next();
    Contacts contacts = app.db().contacts();
    app.contact().addContactToGroup(contacts.iterator().next(), groupForTest);
    app.goTo().clickHomePage();
    return groupForTest;
  }


}
