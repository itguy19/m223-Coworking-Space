package ch.zli.m223.model;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
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
  @Column(nullable = false)
  private String sex;

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
  @Column(nullable = false)
  private boolean isAdmin;

  @Inject
  @OneToMany(mappedBy = "applicationUser")
  @JsonIgnore
  @Fetch(FetchMode.JOIN)
  private Set<Booking> bookings;

  //public ApplicationUser(String email, String password) {
  //  this.email = email;
  //  this.password = password;
  //}

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

  public Set<Booking> getBookings() {
    return bookings;
  }

  public void setEntries(Set<Booking> bookings) {
    this.bookings = bookings;
  }

}
