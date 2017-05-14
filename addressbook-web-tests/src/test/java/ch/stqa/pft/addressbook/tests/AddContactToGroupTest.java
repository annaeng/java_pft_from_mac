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
public class AddContactToGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    // Если нет ни одного контакта - создадим
    if (app.db().contacts().size() == 0) {
      app.contact().clickAddNewContact();
      app.contact().create(new ContactData().withFirstname("FN").withLastname("LN"));
    }

    // Если нет ни одной группы - создадим
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testContactAddToGroup() {

    ContactData contact = selectContactToTest();
    GroupData group = selectGroupToTest(contact);

    Groups contactGroupsBefore = app.db().contactById2(contact.getId()).getGroups();
    Contacts groupContactsBefore = app.db().contactsInGroupByName(group.getName());

    app.goTo().clickHomePage();
    app.contact().addContactToGroup(contact, group);

    Groups contactGroupsAfter = app.db().contactById(contact.getId()).getGroups();
    Contacts groupContactsAfter = app.db().contactsInGroupByName(group.getName());

    // Проверки по данным контакта (группы в контакте)
    assertEquals(contactGroupsAfter.size(), contactGroupsBefore.size() + 1);
    assertThat(contactGroupsAfter, equalTo(contactGroupsBefore.withAdded(app.db().groupByName(group.getName()))));

    // Проверки по данным группы (контакты в группе)
    assertEquals(groupContactsAfter.size(), groupContactsBefore.size() + 1);
    assertThat(groupContactsAfter, equalTo(groupContactsBefore.withAdded(app.db().contactById(contact.getId()))));

  }

  private ContactData selectContactToTest() {
    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();
    /*
    * Ищем контакт, в котором количество групп меньше, чем всего есть групп.
    * Такой контакт можно будет добавить в еще одну группу.
    * Если такой контакт найдется, то вернем его.
    */
    for (ContactData contact : contacts) {
      if (contact.getGroups().size() < groups.size()) {
        return contact;
      }
    }
    /*
    * Если нужного контакта не нашлось, то создадим новый вообще без групп
    * И вернем его
    */
    app.contact().clickAddNewContact();
    app.contact().create(new ContactData().withFirstname("FN!!!").withLastname("LN!!!"));
    Contacts contactsWithAded = app.db().contacts();

    return app.db().contactById(contactsWithAded.stream().mapToInt((c) -> c.getId()).max().getAsInt());
  }

  private GroupData selectGroupToTest(ContactData contact) {
    Groups allGroups = app.db().groups(); // Все группы, которые есть в приложении
    Groups contactGroups = app.db().contactById(contact.getId()).getGroups(); // Группы, которые есть в тестовом контакте

    // Переберем все группы контакта и "выкинем" их из общего списка групп
    for (GroupData group : contactGroups) {
      allGroups.remove(group);
    }

    // Теперь в общем списке групп только те группы, которых нет у данного контакта
    return allGroups.iterator().next();
  }

}
