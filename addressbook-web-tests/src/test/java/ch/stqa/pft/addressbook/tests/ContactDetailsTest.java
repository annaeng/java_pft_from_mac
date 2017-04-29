package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by annaryapolova on 29.04.17.
 */
public class ContactDetailsTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().
              withFirstname("FN77").withLastname("LN77").withAddress("Happy st.77").withMobilePhone("777777777").withGroup("о, святые печеньки1"));
    }
  }

  @Test
  public void testContactDetails() {
    app.goTo().goToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData allDetails = app.contact().infoFromDetails(contact);
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllDetails(), equalTo(mergeDetails(contactInfoFromEditForm)));
    assertThat(allDetails.getAllDetails(), equalTo(mergeDetails(contactInfoFromEditForm)));
    //assertThat(mergeDetails(allDetails), equalTo(mergeDetails(contactInfoFromEditForm)));

  }

  private String mergeDetails(ContactData contact) {
    return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(),
            contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
            contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream()
            .filter((s) -> !(s == null || s.equals("")))
            .map(ContactDetailsTest::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String data) {
    return data.replaceAll("\\s", "").replaceAll("[-()]", "").replaceAll("H:", "").replaceAll("M:", "").replaceAll("W:", "");
  }


  // Создаем список - Превращаем в поток - выкидываем элементы равные "" или null
  // filter с параметрами: анонимная ф-я которая на вход принимает строку и возвращает True или False
  // получили поток где нет пустых строк,
  // а фун-й мар() применяем ко всем эл-м потока ф-ю ( cleaned() по Регулярным выражениям )  и возвращаем обработанный поток
  // и склеиваем их вместе collect(Collectors.joining("\n"))

}

