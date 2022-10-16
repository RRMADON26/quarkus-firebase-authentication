package com.rrmadon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.security.Authenticated;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Authenticated
public class ExampleResource {

	@Inject
	ObjectMapper objectMapper;

	@Inject
	JsonWebToken jsonWebToken;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() throws JsonProcessingException {
		return objectMapper.writeValueAsString(jsonWebToken);
	}
}