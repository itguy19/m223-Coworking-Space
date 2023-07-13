package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.AuthService;
import ch.zli.m223.service.BookingService;

@Path("/bookings/")
@Tag(name = "Bookings", description = "Handling of bookings")
public class BookingController {

    @Inject
    BookingService bookingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Entries.", description = "Returns a list of all entries.")
    public List<Booking> index() {
        return bookingService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new booking.", description = "Creates a new booking and returns the newly added booking.")
    public Booking create(Booking booking) {
       return bookingService.createEntry(entry);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Deletes a booking.", description = "Deletes a booking and returns the deleted booking.")
    public Booking delete(@PathParam("id") Long id) {
       return bookingService.deleteEntry(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Edits a booking.", description = "Edits a booking and returns the edited booking.")
    public Booking edit(Booking entry) {
       return bookingService.editEntry(entry);
    }
}
