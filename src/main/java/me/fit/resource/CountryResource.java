package me.fit.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import me.fit.restclient.CountryClient;
import me.fit.restclient.CountryResponse;

@Path("/countries")
public class CountryResource {

    @Inject
    @RestClient
    CountryClient countryClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountryResponse> getAllCountries() {
        return countryClient.getAvailableCountries();
    }
}
