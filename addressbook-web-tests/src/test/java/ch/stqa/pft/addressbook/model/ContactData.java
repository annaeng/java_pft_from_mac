package ch.stqa.pft.addressbook.model;

public class ContactData {
  private final String id;
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String mobil;
  private String group;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            '}';
  }

  public ContactData( String firstname, String lastname, String address, String mobil, String group) {
    this.id = null;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.mobil = mobil;
    this.group = group;
  }

  public ContactData(String id, String firstname, String lastname, String address, String mobil, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.mobil = mobil;
    this.group = group;
  }

  public String getId() {
    return id;
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

  public String getGroup() {
    return group;
  }

}
