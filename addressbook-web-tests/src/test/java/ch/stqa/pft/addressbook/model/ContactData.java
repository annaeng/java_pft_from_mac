package ch.stqa.pft.addressbook.model;

public class ContactData {

  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String group;
  private String address;
  private String mobil;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;

  public String getWorkPhone() { return workPhone; }

  public  ContactData withWorkPhone (String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public String getMobilePhone() { return mobilePhone; }

  public  ContactData withMobilePhone (String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public String getHomePhone() { return homePhone; }

  public  ContactData withHomePhone (String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public int getId() {return id;}

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;

  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }


  public ContactData withMobil(String mobil) {
    this.mobil = mobil;
    return this;
  }


  public ContactData withGroup(String group) {
    this.group = group;
    return this;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

}

