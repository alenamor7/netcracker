package com.netcracker.restSimple;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/calc")
public class CalculationRestService {
    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String addGet(@PathParam("a") double a, @PathParam("b") double b) {
        double result = a + b;
        return createHtml(result);
    }

    @POST
    @Path("/add/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPost(@PathParam("a") double a, @PathParam("b") double b) {
        double result = a + b;
        return Response.status(201).entity(createHtml(result)).build();
    }

    @GET
    @Path("/subtract/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String subtractGet(@PathParam("a") double a, @PathParam("b") double b) {
        double result = a - b;
        return createHtml(result);
    }

    @POST
    @Path("/subtract/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response subtractPOST(@PathParam("a") double a, @PathParam("b") double b) {
        double result = a - b;
        return Response.status(201).entity(createHtml(result)).build();
    }

    @GET
    @Path("/multiply/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String multiplyGet(@PathParam("a") double a, @PathParam("b") double b) {
        double result = a * b;
        return createHtml(result);
    }

    @POST
    @Path("/multiply/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response multiplyPOST(@PathParam("a") double a, @PathParam("b") double b) {
        double result = a * b;
        return Response.status(201).entity(createHtml(result)).build();
    }

    @GET
    @Path("/divide/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String divideGet(@PathParam("a") double a, @PathParam("b") double b) {
        double result = 0;
        if(b != 0) {
            result = a / b;
        }
        return createHtml(result);
    }

    @POST
    @Path("/divide/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dividePOST(@PathParam("a") double a, @PathParam("b") double b) {
        double result = 0;
        if(b != 0) {
            result = a / b;
        }
        return Response.status(201).entity(createHtml(result)).build();
    }




    public String createHtml(double result) {
        String html = "<html>" +
                "<title>" + "Let's calculate together" + "</title>" +
                "<body>" + result + "</body>" +
                "</html>";
        return html;
    }
}
