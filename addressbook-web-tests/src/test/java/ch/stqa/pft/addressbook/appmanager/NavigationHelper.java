package ch.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by annaryapolova on 02.04.17.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {super (wd);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new")) ) {
      return;
    }
      click(By.linkText("groups"));
    }

  public void HomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }
  public void clickHomePage() {
    click(By.xpath(".//*[@id='nav']/ul/li[1]/a"));
    //click(By.linkText("home"));
  }

}
