package ch.stqa.pft.addressbook.tests;


import ch.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupCreation(new GroupData("о, святые печеньки!", "о, святые печеньки!", "о, святые печеньки!"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }


}
