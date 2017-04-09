package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by annaryapolova on 08.04.17.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupCreation(new GroupData("о, святые печеньки1", "о, святые печеньки3", "о, святые печеньки3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }


}
