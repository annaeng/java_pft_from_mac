package ch.stqa.pft.addressbook;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String mobil;

  public ContactData(String firstname, String lastname, String address, String mobil) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.mobil = mobil;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getMobil() {
    return mobil;
  }
}
