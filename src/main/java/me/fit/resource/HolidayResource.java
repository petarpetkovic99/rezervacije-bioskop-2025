package me.fit.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import me.fit.restclient.CountryClient;
import me.fit.restclient.HolidayResponse;

@Path("/holidays")
public class HolidayResource {

    @Inject
    @RestClient
    CountryClient countryClient;

    @GET
    @Path("/{countryCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<HolidayResponse> getNextHolidays(@PathParam("countryCode") String countryCode) {
        return countryClient.getNextPublicHolidays(countryCode);
    }
}
