package net.rest.ws.service;

import net.rest.ws.service.entities.Album;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/sampleservice")
public class SampleService {
    private static Map<String, Album> albums = new HashMap<String, Album>();

    static {
        Album album1 = new Album();
        album1.setAlbumId("1");
        album1.setTitle("Elephunk");
        album1.setGenre("HipHop");
        Calendar cal = Calendar.getInstance();
        cal.set(2003, 6, 24);
        album1.setDate(cal.getTime());
        albums.put(album1.getAlbumId(), album1);

        Album album2 = new Album();
        album2.setAlbumId("2");
        album2.setTitle("Demon Days");
        album2.setGenre("HipHop");
        cal.set(2005, 12, 6);
        album2.setDate(cal.getTime());
        albums.put(album2.getAlbumId(), album2);
    }

    @GET
    @Path("/albums")
    @Produces({ MediaType.APPLICATION_XML })
    public List<Album> listAlbums() {
        return new ArrayList<Album>(albums.values());
    }

    @GET
    @Path("/album/{albumId}")
    @Produces({ MediaType.APPLICATION_XML })
    public Album getAlbum(@PathParam("albumId") String albumId) {
        return albums.containsKey(albumId)? albums.get(albumId) : null;
    }

    @GET
    @Path("/albums/json")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public List<Album> listAlbumsJSON() {
        return listAlbums();
    }

    @GET
    @Path("/album/{albumId}/json")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Album getAlbumJSON(@PathParam("albumId") String albumId) {
        return getAlbum(albumId);
    }
}
