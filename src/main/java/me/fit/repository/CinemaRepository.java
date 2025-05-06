package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Person;

@Dependent
public class CinemaRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Person createPerson(Person p) {
        return em.merge(p);
    }

}
