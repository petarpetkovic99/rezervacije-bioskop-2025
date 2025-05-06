package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import me.fit.model.Person;
import me.fit.repository.CinemaRepository;

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

}
