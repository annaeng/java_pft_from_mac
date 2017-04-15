package ch.stqa.pft.addressbook.tests;

import ch.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

/**
 * Created by annaryapolova on 08.04.17.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup (new GroupData("о, святые печеньки1!!", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() -1 );
    app.getGroupHelper().initGroupModification();
    // Далее при модификации сохраняем старый id!
    GroupData group = new GroupData(before.get(before.size() -1).getId(),"о, святые печеньки1", "о, святые печеньки3", "о, святые печеньки3");
    app.getGroupHelper().fillGroupCreation(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() );

    before.remove(before.size() -1);
    before.add(group);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}
