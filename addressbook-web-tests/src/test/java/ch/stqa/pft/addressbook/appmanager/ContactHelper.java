package ch.stqa.pft.addressbook.appmanager;

import ch.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void editContact(int index) {
    //wd.findElements(By.class("centre")).get(index).click();
    //*[@id="maintable"]/tbody/tr[4]/td[8]/a
    //*[@id="maintable"]/tbody/tr[5]/td[8]/a
    wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[*]/td[8]/a/img")).get(index).click();
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

  public void createContact(ContactData contact) {
    goToAddNewContact();
    fillNewContact(contact, true);
    submitNewContact();
    goToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }


  public List<ContactData> getContactList() {
    List<ContactData> contacts= new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements( By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']") );

    for (WebElement element : elements) {
      //String firstname = element.findElement( By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']/td[3]")).getText();
      String id = element.findElement(By.xpath( "//table[@id='maintable']/tbody/tr[@name='entry']/td[@class='center']")).getAttribute("value");
      ContactData contact = new ContactData(id, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}


