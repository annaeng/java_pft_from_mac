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
    if (app.db().contacts().size() == 0) {
      app.goTo().clickHomePage();
      app.contact().create(new ContactData().
              withFirstname("FN77").withLastname("LN77").withAddress("Happy st.77").withMobilePhone("777777777").withGroup("о, святые печеньки1"));
    }
  }

  @Test
  public void testContactDetails() {
    app.goTo().HomePage();
    ContactData contact = app.db().contacts().iterator().next();
    //ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoDetails = app.contact().infoFromDetails(contact);
    ContactData contactInfoEdit = app.contact().infoFromEdit(contact);

    //assertThat(contact.getAllDetails(), equalTo(mergeEdit(contactInfoEdit)));
    assertThat(mergeDetails(contactInfoDetails), equalTo(mergeEdit(contactInfoEdit)));
    verifyContactListInUI ();
  }

  private String mergeEdit(ContactData contactInfoEdit) {
    return Arrays.asList(contactInfoEdit.getFirstname(), contactInfoEdit.getLastname(), contactInfoEdit.getAddress(),
            contactInfoEdit.getHomePhone(), contactInfoEdit.getMobilePhone(), contactInfoEdit.getWorkPhone(),
            contactInfoEdit.getEmail1(), contactInfoEdit.getEmail2(), contactInfoEdit.getEmail3())
            .stream()
            .filter((s) -> !(s == null || s.equals("")))
            .map(ContactDetailsTest::cleaned)
            .collect(Collectors.joining(""));
  }

  private String mergeDetails(ContactData contactInfoDetails) {
    return Arrays.asList(contactInfoDetails.getAllDetails())
            .stream()
            .filter((s) -> !(s == null || s.equals("")))
            .map(ContactDetailsTest::cleaned)
            .collect(Collectors.joining(""));
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

