package me.fit.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import me.fit.restclient.WeatherClient;
import me.fit.restclient.WeatherResponse;

@Path("/getForecast")
public class WeatherResource {

    @Inject
    @RestClient
    WeatherClient weatherClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForecast(@QueryParam("city") String city) {
        WeatherResponse weatherResp = (WeatherResponse) weatherClient.getForecast(city);

        return Response.ok().entity(weatherResp).build();
    }

    // @POST
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response add
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(@QueryParam("city") String city) {
        WeatherResponse weatherResp = (WeatherResponse) weatherClient.getForecast(city);

        return Response.ok().entity(weatherResp).build();
    }
    
}
