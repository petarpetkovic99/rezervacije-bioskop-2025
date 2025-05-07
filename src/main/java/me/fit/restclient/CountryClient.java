package me.fit.restclient;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import me.fit.restclient.CountryResponse;

@Path("/api/v3")
@RegisterRestClient(configKey = "country-info")
public interface CountryClient {

    @GET
    @Path("/AvailableCountries")
    List<CountryResponse> getAvailableCountries();

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    List<HolidayResponse> getNextPublicHolidays(@jakarta.ws.rs.PathParam("countryCode") String countryCode);
    
}

