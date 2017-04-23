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
  private String allPhones;
  private String new_adress;
  private String email1;
  private String email2;
  private String email3;
  private String allEmails;

  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }


  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withNew_adress(String new_adress) {
    this.new_adress = new_adress;
    return this;
  }
  public String getNew_adress() {
    return new_adress;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }



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

