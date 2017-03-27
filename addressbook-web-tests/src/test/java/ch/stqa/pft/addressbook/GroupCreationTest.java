package ch.stqa.pft.addressbook;


import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    goToGroupPage();
    initGroupCreation();
    fillGroupCreation(new GroupData("о, святые печеньки10!", "о, святые печеньки10!", "о, святые печеньки10!"));
    submitGroupCreation();
    returnToGroupPage();
  }


}
