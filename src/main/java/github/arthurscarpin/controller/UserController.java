package github.arthurscarpin.controller;

import github.arthurscarpin.domain.User;
import github.arthurscarpin.service.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @POST
    public Response create(User user) {
        return Response.status(Response.Status.CREATED).entity(service.create(user)).build();
    }

    @GET
    public Response findAll(
            @QueryParam("page") @DefaultValue("0") Integer page,
            @QueryParam("size") @DefaultValue("10") Integer size
    ) {
        return Response.ok(service.findAll(page, size)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") UUID id) {
        return Response.ok(service.finById(id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateById(@PathParam("id") UUID id, User user) {
        return Response.ok(service.updateById(id, user)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") UUID id) {
        service.deleteById(id);
        return Response.noContent().build();
    }
}
