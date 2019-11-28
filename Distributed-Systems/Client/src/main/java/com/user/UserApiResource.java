package com.user;

import com.*;
import com.grpcproject.User.LoginRequest;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.ws.rs.Produces;

// To get user information add /users at the end of the URL
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

	// Using a hashMap to store all user information
	private HashMap<Integer, User> usersMap = new HashMap<>();
	
	String testUserId = "test1";

	
	
	// Testing Login user
	// private String testUserID = "test";
	// private String testPassword = "test";
	// LoginRequest loginrequest = LoginRequest.newBuilder().setUsername(testUserID ).setPassword(testPassword).build();
	
	User newUser;
	User testUser = new User(0, "Sammar", "email@email.com", "password");
	User testUser1 = new User(1, "Name", "email", "hashed", "salt");

	// Hard coded users for testing
	public UserApiResource() {
		usersMap.put(testUser.getUserId(), testUser);
		usersMap.put(testUser1.getUserId(), testUser1);
	}

	// Getting all user information
	@GET
	public Collection<User> getUser() {
		return usersMap.values();
	}

	// Getting user information sorting by userId
	@GET
	@Path("/{userId}")
	public Response getUserById(@PathParam("userId") int id) throws Exception {

		int id1 = usersMap.get(id).getUserId();

		if (id < 0 || id != id1) {
			throw new Exception();
		} else {
			return Response.status(Status.OK).entity(usersMap.get(id)).build();
		}

	}

	// Deleting user information by userId
	@DELETE
	@Path("{userId}")
	public Response deleteUser(@PathParam("userId") int id) throws Exception {

		if (id == usersMap.get(id).getUserId()) {
			usersMap.remove(id);
			return Response.ok(usersMap.values()).build();
		} else {

			return Response.status(Status.OK).entity(usersMap.get(id)).build();

		}
	}

	// Updated the user information by userId
	@PUT
	@Path("/{userId}")
	public Response updateUser(@PathParam("userId") int id, User user) throws Exception {

		newUser = user;

		newUser.setUserId(id);

		usersMap.replace(id, user);

		return Response.status(Status.OK).entity(usersMap.get(id)).build();
	}
	
	// Adding a new user with information and auto assigning userId 
	@POST
	public Response newUser(User user) throws Exception {

		int id = usersMap.size() + 1;

		user.setUserId(id);

		String uu = String.valueOf(user.getUserId());

		
		user.setHashedPassword(user.password);

		usersMap.put(id, user);

		return Response.created(new URI("/users/" + uu)).entity(usersMap.get(user.getUserId())).status(Status.CREATED)
				.build();

	}
}
