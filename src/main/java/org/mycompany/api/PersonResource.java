package org.mycompany.api;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;
import org.mycompany.entity.PersonEntity;


@Path("/person")
@ApplicationScoped
public class PersonResource {

    private static final Logger LOG = Logger.getLogger(PersonResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonEntity> getAll() {
        LOG.info("GET All Person : ");
        return PersonEntity.listAll();
    }

    @GET
    @Path(("/eyes/{color}"))
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonEntity> findByColor(final @PathParam(value = "color") String color) {
        LOG.info( String.format("Find All Person with a color  : ", color));
        return PersonEntity.findByColor(color);
    }

    @GET
    @Path(("/birth/before/{year}"))
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonEntity> getBeforeYear(final @PathParam(value = "year") int year) {
        LOG.info( String.format("GET All Person with a year  : ", year));
        return PersonEntity.getBeforeYear(year);
    }

}
