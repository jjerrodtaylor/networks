package edu.mason.insf.api;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/networks")
public class NetworkedREST {

    @GET
    @Path("/network/weights")
    public ServiceResponse sampleGetRequest()
    {
        return new ServiceResponse();
    }

    @POST
    @Path("/network/weights")
    public ServiceResponse samplePostRequest()
    {
        return new ServiceResponse();
    }
}
