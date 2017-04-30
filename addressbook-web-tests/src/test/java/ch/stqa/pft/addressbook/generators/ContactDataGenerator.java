package ch.stqa.pft.addressbook.generators;

import ch.stqa.pft.addressbook.model.ContactData;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by annaryapolova on 30.04.17.
 */
public class ContactDataGenerator {

  @Parameter (names = "-cc", description = "Contact count")
  public int count;

  @Parameter (names = "-ff", description = "Target file")
  public String file;

  public static void main (String[] args) throws IOException {

    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    save(contacts, new File(file));
  }

  private void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
              contact.getFirstname(), contact.getLastname(), contact.getAddress(),
              contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
              contact.getEmail1(), contact.getEmail2(), contact.getEmail3()
      ));
    }
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {

    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData()
              .withFirstname(String.format("firstName %s", i)).withLastname(String.format("lastName %s", i)).withAddress(String.format("address %s", i))
              .withHomePhone(String.format("homePhone %s", i)).withMobilePhone(String.format("mobilePhone %s", i)).withWorkPhone(String.format("workPhone %s", i))
              .withEmail1(String.format("Email1 %s", i)).withEmail2(String.format("Email2 %s", i)).withEmail3(String.format("Email3 %s", i))
      );
    }
    return contacts;
  }
}
