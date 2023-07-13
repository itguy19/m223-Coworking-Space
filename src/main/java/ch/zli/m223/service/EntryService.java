package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Entry;

@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry", Entry.class);
        return query.getResultList();
    }

    // Delete 
    @Transactional
    public Entry deleteEntry(Long id) {
        Entry entry = entityManager.find(Entry.class, id);
        if (entry != null) {
            entityManager.remove(entry);
        }
        return entry;
    }

    // Edit entry
    @Transactional
    public Entry editEntry(Entry updatedEntry) {
        Entry entry = entityManager.find(Entry.class, updatedEntry.getId());
        if (entry != null) {
            entry.setCheckOut(updatedEntry.getCheckOut());
            entry.setCheckIn(updatedEntry.getCheckIn());
            entityManager.merge(entry);
        }
        return entry;
    }
}
