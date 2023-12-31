package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;

@ApplicationScoped
public class BookingService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public void createBooking(Booking entry) {
        entityManager.persist(entry);
    }

    @Transactional
    public void deleteBooking(Long id) {
        var entity = entityManager.find(Booking.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Booking updateBooking(Long id, Booking entry) {
        entry.setId(id);
        return entityManager.merge(entry);
    }

    @Transactional
    public List<Booking> findAll() {
        var query = entityManager.createQuery("FROM Booking", Booking.class);
        return query.getResultList();
    }

    @Transactional
    public Booking findBooking(Long id) {
        return entityManager.find(Booking.class, id);
    }

    @Transactional
    public void approveBooking(Long id) {
        var booking = findBooking(id);
        booking.setApproved(true);
        entityManager.merge(booking);
    }

    @Transactional
    public void rejectBooking(Long id) {
        var booking = findBooking(id);
        booking.setCancelled(true);
        entityManager.merge(booking);
    }
}
