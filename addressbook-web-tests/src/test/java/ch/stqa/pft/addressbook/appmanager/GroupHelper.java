package ch.stqa.pft.addressbook.appmanager;

import ch.stqa.pft.addressbook.model.GroupData;
import ch.stqa.pft.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value= '" + id + "']")).click();
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

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupCreation(group);
    submitGroupCreation();
    groupCash = null;
    returnToGroupPage();
  }

  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupCreation(group);
    submitGroupModification();
    groupCash = null;
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    groupCash = null;
    returnToGroupPage();

  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Groups groupCash = null;

  public Groups all() {
    if (groupCash != null) {
      return new Groups(groupCash);
    }
    groupCash = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCash.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCash);
  }

}
