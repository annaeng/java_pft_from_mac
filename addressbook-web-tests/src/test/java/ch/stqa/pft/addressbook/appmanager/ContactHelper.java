package ch.stqa.pft.addressbook.appmanager;

import ch.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    type(By.name("mobile"), contactData.getMobil());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
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
    confirmContactDeletion();
  }


  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value=' " + id + " ']")).click();
  }

  public void editContact(int index) {
    wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[*]/td[8]/a/img")).get(index).click();
  }

  public void editContactById(int id) {
    wd.findElement(By.xpath("//a[@href='edit.php?id="+id+"']")).click();
    //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void updateContact() { click(By.xpath("//div[@id='content']/form[1]/input[22]"));
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

  public void create(ContactData contact) {
    goToAddNewContact();
    fillNewContact(contact, true);
    submitNewContact();
    goToHomePage();
  }

  /**
  public void modify(ContactData contact) {
    editContact();
    fillNewContact(contact, false);
    updateContact();
  }
   **/

  public void modifyById(ContactData contact) {
    editContactById(contact.getId());
    fillNewContact(contact, false);
    updateContact();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> list() {
    List<ContactData> contacts= new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements( By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']") );

    for (WebElement element : elements) {
      String firstname = element.findElement( By.xpath(".//td[3]")).getText();
      String lastname = element.findElement( By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.xpath( ".//td[@class='center']/input")).getAttribute("value"));
      //int id = Integer.parseInt(element.findElement(By.xpath( "//table[@id='maintable']/tbody/tr[@name='entry']/td[@class='center']/input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }
  public Set<ContactData> all() {
    Set<ContactData> contacts= new HashSet<ContactData>();
    List<WebElement> elements = wd.findElements( By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']") );

    for (WebElement element : elements) {
      String firstname = element.findElement( By.xpath(".//td[3]")).getText();
      String lastname = element.findElement( By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.xpath( ".//td[@class='center']/input")).getAttribute("value"));
      //int id = Integer.parseInt(element.findElement(By.xpath( "//table[@id='maintable']/tbody/tr[@name='entry']/td[@class='center']/input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }

}


