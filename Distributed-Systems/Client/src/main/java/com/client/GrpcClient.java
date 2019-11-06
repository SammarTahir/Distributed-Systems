package com.client;

import com.grpcproject.User.APIResponse;
import com.grpcproject.User.LoginRequest;
import com.grpcproject.userGrpc;
import com.grpcproject.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	public static void main(String[] args) {
		
		String userID = "G00347526";
		String password = "G00347526";
		System.out.println("User ID = " + userID + "\nUser Password = " + password);

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);
		LoginRequest loginrequest = LoginRequest.newBuilder().setUsername(userID).setPassword(password).build();
		
		APIResponse response = userStub.login(loginrequest);
		System.out.println(response.getResponsemessage());
		

	}

}