package org.mycompany.ressources;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mycompany.personsearch.Person;

@Path("/person")
@ApplicationScoped
public class PersonResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {
        return Person.listAll();
    }

    @GET
    @Path(("/eyes/{color}"))
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> findByColor(final @PathParam(value = "color") String color) {
        return Person.findByColor(color);
    }

    @GET
    @Path(("/birth/before/{year}"))
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getBeforeYear(final @PathParam(value = "year") int year) {
        return Person.getBeforeYear(year);
    }

}
