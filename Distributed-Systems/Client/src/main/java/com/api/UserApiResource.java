package com.api;

import java.util.Collection;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;



@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {
	
	private HashMap<Integer, User> usersMap = new HashMap<>();

	User testArtist = new User(1, "The GZA", "HipHop", "password");
    usersMap.put(testUser.getUserId(), testUser);
    
    @GET
    public Collection<User> getUser() {
        // artistsMap.values() returns Collection<Artist>
        // Collection is the interface implemented by Java collections like ArrayList, LinkedList etc.
        // it's basically a generic list.
        // https://docs.oracle.com/javase/7/docs/api/java/util/Collection.html
        
        return usersMap.values();
    }
}

