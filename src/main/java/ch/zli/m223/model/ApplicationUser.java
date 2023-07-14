package ch.zli.m223.model;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries({@NamedQuery(name = "ApplicationUser.findByEmail",
    query = "SELECT u FROM ApplicationUser u WHERE u.email = :email"),
    @NamedQuery(name = "ApplicationUser.getAmountOfUsers",
    query = "SELECT count(*) FROM ApplicationUser")})
public class ApplicationUser {

  @Id
  @Inject
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private long id;

  @Inject
  @Column(nullable = false)
  private String forename;

  @Inject
  @Column(nullable = false)
  private String lastname;

  @Inject
  @Column(nullable = true)
  private String sex;

  @Inject
  @Column(nullable = true)
  private String bio;

  @Inject
  @Column(nullable = false)
  private int age;

  @Inject
  @Column(nullable = false, unique = true)
  private String email;

  @Inject
  @Column(nullable = false)
  private String password;

  @Inject
  @Enumerated(EnumType.STRING)
  private RoleEnum role;

  @Inject
  @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
  @JsonIgnore
  @Fetch(FetchMode.JOIN)
  private Set<Booking> bookings;

  public ApplicationUser() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return email;
  }

  public void setEmail(String username) {
    this.email = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public Set<Booking> getBookings() {
    return bookings;
  }

  public void setEntries(Set<Booking> bookings) {
    this.bookings = bookings;
  }

  public String getForename() {
    return forename;
  }

  public void setForename(String forename) {
    this.forename = forename;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setBookings(Set<Booking> bookings) {
    this.bookings = bookings;
  }
}
