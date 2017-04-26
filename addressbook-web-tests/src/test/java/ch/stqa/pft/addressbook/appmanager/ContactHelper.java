package ch.stqa.pft.addressbook.appmanager;

import ch.stqa.pft.addressbook.model.ContactData;
import ch.stqa.pft.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by annaryapolova on 02.04.17.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitNewContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillNewContact(ContactData contactData, boolean creation) {

    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobilePhone());

    if (creation) {
      // new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }


  }

  public void confirmContactDeletion() {
    WebDriver.Timeouts timeouts = wd.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    wd.switchTo().alert().accept();
  }

  public void deleteContact() {
    click(By.xpath("//div/div[4]/form[2]/div[2]/input"));
  }

  public void delete(int index) {
    selectContact(index);
    deleteContact();
    confirmContactDeletion();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    contactCash = null;
    confirmContactDeletion();
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void editContact(int index) {
    wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[*]/td[8]/a/img")).get(index).click();
  }

  public void editContactById(int id) {
    wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();
    //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void updateContact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    WebDriver.Timeouts timeouts = wd.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
  }

  public void goToAddNewContact() {
    if (isElementPresent(By.name("submit"))) {
      return;
    }
    click(By.linkText("add new"));
  }

  public void goToHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home page"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void create(ContactData contact) {
    goToAddNewContact();
    fillNewContact(contact, true);
    submitNewContact();
    contactCash = null;
    goToHomePage();
  }

  public void modifyById(ContactData contact) {
    editContactById(contact.getId());
    fillNewContact(contact, false);
    updateContact();
    contactCash = null;
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));
    for (WebElement element : elements) {
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.xpath(".//td[@class='center']/input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }

  private Contacts contactCash = null;

  public Contacts all() {
    if (contactCash != null) {
      return new Contacts(contactCash);
    }

    contactCash = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));

    for (WebElement element : elements) {
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.xpath(".//td[@class='center']/input")).getAttribute("value"));
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      contactCash.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllPhones(allPhones).withAllEmails(allEmails));
    }
    return new Contacts(contactCash);
  }

  public ContactData infoFromEditForm(ContactData contact) {

    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    // Выходим из формы редактирования Контакта
    wd.navigate().back();
    // возвращаем предварительно заполненный список полей Контакта (множество значений) в таблицу контактов
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmail1(email).withEmail2(email2).withEmail3(email3);
  }

  //  это варианты выбора контакта по заданному иденитификатору
  public void initContactModificationById(int id) {
    // метод последовательных приближений
    // ищем checkbox
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    // Вверх на 2 уровня чтобы посчитать колонки td т.е. идём  к родителю tr
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    // Получаем список (множество) td
    List<WebElement> cells = row.findElements(By.tagName("td"));
    // Выбираем нужную колонку (8 номер счет идет от 0)
    cells.get(7).findElement(By.tagName("a")).click();
  }
  // примеры:
  //  wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a",id))).click();
  //  wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a",id))).click();
  //  wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();

}





