package ch.stqa.pft.addressbook.appmanager;

import ch.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

  public void fillNewContact(ContactData contactData) {

    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobil());

  }

  public void confirmContactDeletion() {
    WebDriver.Timeouts timeouts = wd.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    wd.switchTo().alert().accept();
  }

  public void deleteContact() {
    click(By.xpath("//div/div[4]/form[2]/div[2]/input"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void editContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void updateContact() { click(By.xpath("//div[@id='content']/form[1]/input[22]"));

  }
}
