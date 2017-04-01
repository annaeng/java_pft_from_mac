package ch.stqa.pft.addressbook.tests;


import ch.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupCreation(new GroupData("о, святые печеньки2!!", "о, святые печеньки2!!", "о, святые печеньки2!!"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }


}
