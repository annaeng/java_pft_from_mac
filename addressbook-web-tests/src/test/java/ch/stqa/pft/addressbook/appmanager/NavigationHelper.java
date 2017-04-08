package ch.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by annaryapolova on 02.04.17.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {super (wd);
  }

  public void goToGroupPage() {
    click(By.linkText("groups"));
    WebDriver.Timeouts timeouts = wd.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
  }

  public void goToHomePage() {
      click(By.linkText("home page"));
  }

  public void goToAddNewContact() {
      click(By.linkText("add new"));
  }
}

