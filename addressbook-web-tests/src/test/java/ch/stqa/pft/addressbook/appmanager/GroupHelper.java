package ch.stqa.pft.addressbook.appmanager;

import ch.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by annaryapolova on 02.04.17.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);

  }

  public void initGroupCreation() {
    click(By.name("new"));

  }

  public void fillGroupCreation(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void selectGroup()  {

    click(By.name("selected[]"));
    //WebDriver.Timeouts timeouts = wd.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
    //wd.findElement(By.xpath("//div[@id='content']/form/input[2]"));
    WebDriver.Timeouts timeouts = wd.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    wd.findElement(By.linkText("group page"));
  }

  public void returnToGroupPage() {
    WebDriver.Timeouts timeouts = wd.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    wd.findElement(By.linkText("group page"));
    click(By.linkText("group page"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }
}
