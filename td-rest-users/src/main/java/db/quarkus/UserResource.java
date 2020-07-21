package db.quarkus;

import db.dao.UserDao;
import db.dto.UserDto;
import db.dto.UserMapper;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/users")
@Transactional
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class UserResource {
    @Inject
    UserMapper mapper;
    @Inject
    UserDao userDao;

    @GET
    @Path("people")
    public List<UserDto> all() {
        return mapper.toDto(userDao.findAll());
    }

    @GET
    @Path("people/by-name/{name}")
    public List<UserDto> findByName(@PathParam("name") final String name) {
        return mapper.toDto(userDao.findByName(name));
    }

    @GET
    @Path("person/{id}")
    public UserDto findById(@PathParam("id") final Long id) {
        final User p = userDao.findById(id);
        if (p == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);

        return mapper.toDto(p);
    }
}
