package ch.stqa.pft.addressbook.appmanager;

import ch.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by annaryapolova on 02.04.17.
 */
public class ContactHelper {

  private FirefoxDriver wd;

  public ContactHelper(FirefoxDriver wd) {
   this.wd = wd;
  }

  public void submitNewContact() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillNewContact(ContactData contactData) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
      wd.findElement(By.name("address")).click();
      wd.findElement(By.name("address")).clear();
      wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(contactData.getMobil());
  }

  public void confirmContactDeletion() {
    WebDriver.Timeouts timeouts = wd.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    wd.switchTo().alert().accept();
  }

  public void deleteContact() {
    wd.findElement(By.xpath("//div/div[4]/form[2]/div[2]/input")).click();
  }

  public void selectContact() {
    wd.findElement(By.name("selected[]")).click();
    //groupHelper.selectGroup();
    //после выделения GroupHelper подставилось почему то Group
  }
}
