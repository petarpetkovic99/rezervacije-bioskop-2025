package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Person;
import me.fit.model.Projection;
import me.fit.model.Reservation;
import me.fit.model.Movie;
import java.util.List;
import java.util.HashSet;

@Dependent
public class CinemaRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Person createPerson(Person p) {
        return em.merge(p);
    }

    @Transactional
    public Projection createProjection(Projection pr) {
        return em.merge(pr);
    }

    @Transactional
    public Reservation createReservation(Reservation r) {
        return em.merge(r);
    }

    @Transactional
    public Movie createMovie(Movie m) {
        return em.merge(m);
    }

    @Transactional
	public List<Person> getAllPersons() { 
		List<Person> persons = em.createNamedQuery(Person.GET_ALL_PERSONS, Person.class).getResultList();

		for (Person person : persons) {
			List<Reservation> reservations = em.createNamedQuery(Reservation.GET_RESERVATIONS_FOR_PERSON, Reservation.class).setParameter("id", person.getId()).getResultList();
			person.setReservations(new HashSet<>(reservations));
		}

		return persons;
	}

    @Transactional
    public List<Movie> getAllMoviesByGenre(String genre) {
        return em.createQuery("Select m from Movie m where m.genre = :genre", Movie.class).setParameter("genre", genre).getResultList();
    }

}
