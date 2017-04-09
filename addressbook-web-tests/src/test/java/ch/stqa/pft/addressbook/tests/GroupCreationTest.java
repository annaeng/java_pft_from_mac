package ch.stqa.pft.addressbook.tests;


import ch.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData("о, святые печеньки1!!", null, null));

  }


}
