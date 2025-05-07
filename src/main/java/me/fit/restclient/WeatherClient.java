package me.fit.restclient;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/weather")
@RegisterRestClient(configKey = "weather")
public interface WeatherClient {

    @GET
    @Path("/{city}")
    WeatherResponse getForecast(@PathParam("city") String city);

}
