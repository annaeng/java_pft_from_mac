package ch.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by annaryapolova on 02.04.17.
 */
public class NavigationHelper {


  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
    WebDriver.Timeouts timeouts = wd.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
  }

  public void goToHomePage() {
      wd.findElement(By.linkText("home page")).click();
  }

  public void goToAddNewContact() {
      wd.findElement(By.linkText("add new")).click();
  }
}

