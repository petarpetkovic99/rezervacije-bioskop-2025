package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import me.fit.model.Person;
import me.fit.model.Projection;
import me.fit.model.Reservation;
import me.fit.repository.CinemaRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import java.util.List;

@Path("/cinema/")
public class CinemaResource {

    @Inject
    private CinemaRepository cinemaRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addPerson")
    public Response addPerson(Person person) {
        Person p = cinemaRepository.createPerson(person);
        return Response.ok().entity(p).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addProjection")
    public Response addProjection(Projection projection) {
        Projection pr = cinemaRepository.createProjection(projection);
        return Response.ok().entity(pr).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addReservation")
    public Response addReservation(Reservation reservation) {
        Reservation r = cinemaRepository.createReservation(reservation);
        return Response.ok().entity(r).build();
    }

    @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllPersons")
	public Response getAllPersons() {
		List<Person> persons = cinemaRepository.getAllPersons();

		return Response.ok().entity(persons).build();
	}

}
