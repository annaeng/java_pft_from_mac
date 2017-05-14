package ch.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "addressbook")

@XStreamAlias("contact")

public class ContactData {
  @XStreamOmitField

  @Id
  @Column (name = "id")
  private int id;
  //private int id = Integer.MAX_VALUE;

  @Column (name = "firstname")
  private String firstname;

  @Column (name = "lastname")
  private String lastname;

  @Column (name = "nickname")
  private String nickName;

  //@Transient
  @Column (name = "address")
  @Type(type = "text")
  private String address;

  @Transient
  private String new_adress;

  @Transient
  private String mobil;

  @Column (name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Column (name = "home")
  @Type(type = "text")
  private String homePhone;

  @Column (name = "work")
  @Type(type = "text")
  private String workPhone;

  @Transient
  private String allPhones;

  @Column (name = "email")
  @Type(type = "text")
  private String email1;

  @Column (name = "email2")
  @Type(type = "text")
  private String email2;

  @Column (name = "email3")
  @Type(type = "text")
  private String email3;

  @Transient
  private String allEmails;

  @Transient
  private String allDetails;

  @Column (name = "photo")
  @Type(type = "text")
  private String photo;


  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();


  public File getPhoto() {
    return new File(photo);
  }
  public int getId() {return id;}

  public String getFirstname() {
    return firstname;
  }
  public String getLastname() {
    return lastname;
  }
  public String getNickName() {
    return nickName;
  }
  public String getAddress() {
    return address;
  }

  public String getMobil() {
    return mobil;
  }
  public String getMobilePhone() { return mobilePhone; }
  public String getHomePhone() { return homePhone; }
  public String getWorkPhone() { return workPhone; }
  public String getAllPhones() {
    return allPhones;
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

  public Groups getGroups() {
    return new Groups(groups);
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getAllDetails() {
    return allDetails;
  }


  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

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
  public ContactData withNickName(String nickName) {
    this.nickName = nickName;
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
  public ContactData withMobilePhone (String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }
  public ContactData withHomePhone (String homePhone) {
    this.homePhone = homePhone;
    return this;
  }
  public ContactData withWorkPhone (String workPhone) {
    this.workPhone = workPhone;
    return this;
  }
  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }
  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }
  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withAllDetails(String allDetails) {
    this.allDetails = allDetails;
    return this;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
    if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
    if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
    if (allPhones != null ? !allPhones.equals(that.allPhones) : that.allPhones != null) return false;
    if (email1 != null ? !email1.equals(that.email1) : that.email1 != null) return false;
    if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
    if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
    if (allEmails != null ? !allEmails.equals(that.allEmails) : that.allEmails != null) return false;
    return allDetails != null ? allDetails.equals(that.allDetails) : that.allDetails == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
    result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
    result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
    result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
    result = 31 * result + (email1 != null ? email1.hashCode() : 0);
    result = 31 * result + (email2 != null ? email2.hashCode() : 0);
    result = 31 * result + (email3 != null ? email3.hashCode() : 0);
    result = 31 * result + (allEmails != null ? allEmails.hashCode() : 0);
    result = 31 * result + (allDetails != null ? allDetails.hashCode() : 0);
    return result;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +


            ", address='" + address + '\'' +


            ", mobilePhone='" + mobilePhone + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", email1='" + email1 + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", allEmails='" + allEmails + '\'' +
            ", allDetails='" + allDetails + '\'' +
            '}';
  }

  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;
  }

}

