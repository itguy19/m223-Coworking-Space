package ch.zli.m223.service;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.RoleEnum;
import ch.zli.m223.model.ApplicationUser;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.runtime.StartupEvent;

@IfBuildProfile("dev")
@ApplicationScoped
public class TestDataService {

  @Inject
  EntityManager entityManager;

  @Transactional
  void generateTestData(@Observes StartupEvent event) {
    
    var admin = new ApplicationUser();
    admin.setForename("Ferrari-Mafia");
    admin.setLastname("Pagani");
    admin.setEmail("test@test.com");
    admin.setPassword("test");
    admin.setRole(RoleEnum.ADMIN);
    entityManager.persist(admin);

    var mitglied = new ApplicationUser();
    mitglied.setForename("Xhao Fang");
    mitglied.setLastname("Huen Dong");
    mitglied.setEmail("xhaofanghuendong@gmail.com");
    mitglied.setPassword("obrigado56789");
    mitglied.setRole(RoleEnum.MEMBER);
    entityManager.persist(mitglied);

    var mitglied3 = new ApplicationUser();
    mitglied3.setForename("Alice");
    mitglied3.setLastname("Smith");
    mitglied3.setEmail("alice.smith@example.com");
    mitglied3.setPassword("password123");
    mitglied3.setRole(RoleEnum.MEMBER);
    entityManager.persist(mitglied3);

    var mitglied4 = new ApplicationUser();
    mitglied4.setForename("Bob");
    mitglied4.setLastname("Johnson");
    mitglied4.setEmail("bob.johnson@example.com");
    mitglied4.setPassword("letmein456");
    mitglied4.setRole(RoleEnum.MEMBER);
    entityManager.persist(mitglied4);

    var mitglied5 = new ApplicationUser();
    mitglied5.setForename("Charlie");
    mitglied5.setLastname("Brown");
    mitglied5.setEmail("charlie.brown@example.com");
    mitglied5.setPassword("abc123");
    mitglied5.setRole(RoleEnum.MEMBER);
    entityManager.persist(mitglied5);

    var buchung1 = new Booking();
    buchung1.setStartDateTime(LocalDateTime.now());
    buchung1.setEndDateTime(LocalDateTime.now().plusSeconds(150));
    buchung1.setCancelled(false); 
    buchung1.setApproved(false); 
    buchung1.setUser(admin);
    entityManager.persist(buchung1);

    var buchung2 = new Booking();
    buchung2.setStartDateTime(LocalDateTime.now());
    buchung2.setEndDateTime(LocalDateTime.now().plusSeconds(17));
    buchung2.setCancelled(false); 
    buchung2.setApproved(false); 
    buchung2.setUser(mitglied3);
    entityManager.persist(buchung2);

    var buchung3 = new Booking();
    buchung3.setStartDateTime(LocalDateTime.now());
    buchung3.setEndDateTime(LocalDateTime.now().plusSeconds(150));
    buchung3.setCancelled(false);
    buchung3.setApproved(false);
    buchung3.setUser(mitglied4);
    entityManager.persist(buchung3);

    var buchung4 = new Booking();
    buchung4.setStartDateTime(LocalDateTime.now());
    buchung4.setEndDateTime(LocalDateTime.now().plusSeconds(300));
    buchung4.setCancelled(false);
    buchung4.setApproved(false);
    buchung4.setUser(admin);
    entityManager.persist(buchung4);

    var buchung5 = new Booking();
    buchung5.setStartDateTime(LocalDateTime.now());
    buchung5.setEndDateTime(LocalDateTime.now().plusSeconds(450));
    buchung5.setCancelled(false);
    buchung5.setApproved(false);
    buchung5.setUser(mitglied5);
    entityManager.persist(buchung5);
  }
}
