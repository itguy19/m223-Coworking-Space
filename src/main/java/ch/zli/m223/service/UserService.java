package ch.zli.m223.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.RoleEnum;

@ApplicationScoped
public class UserService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public ApplicationUser createUser(ApplicationUser user) {
        user.setRole(RoleEnum.MEMBER);
        
        Long amountOfUsers = entityManager
                .createNamedQuery("ApplicationUser.getAmountOfUsers", Long.class)
                .getSingleResult();
        if (amountOfUsers == 0) {
            user.setRole(RoleEnum.ADMIN);    
        }
        return entityManager.merge(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        var entity = entityManager.find(ApplicationUser.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public void updateUser(Long id, ApplicationUser user) {
        user.setId(id);
        user.setRole(RoleEnum.MEMBER);
        entityManager.merge(user);
    }

    public List<ApplicationUser> findAll() {
        var query = entityManager.createQuery("FROM ApplicationUser", ApplicationUser.class);
        return query.getResultList();
    }

    public Optional<ApplicationUser> findByEmail(String email) {
        return entityManager
                .createNamedQuery("ApplicationUser.findByEmail", ApplicationUser.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
}