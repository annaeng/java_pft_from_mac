package ch.stqa.pft.addressbook.appmanager;

import ch.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by annaryapolova on 02.04.17.
 */
public class GroupHelper {
  private FirefoxDriver wd;

  public GroupHelper(FirefoxDriver wd) {
    this.wd = wd;

  }

  public void initGroupCreation() {
    wd.findElement(By.name("new")).click();

  }

  public void fillGroupCreation(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void selectGroup()  {

    wd.findElement(By.name("selected[]")).click();
    //WebDriver.Timeouts timeouts = wd.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
  }

  public void deleteSelectedGroups() {
    wd.findElement(By.name("delete")).click();
    //wd.findElement(By.xpath("//div[@id='content']/form/input[2]"));
    WebDriver.Timeouts timeouts = wd.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    wd.findElement(By.linkText("group page"));
  }

  public void returnToGroupPage() {
    WebDriver.Timeouts timeouts = wd.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    wd.findElement(By.linkText("group page"));
    wd.findElement(By.linkText("group page")).click();

  }
}
