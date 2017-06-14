package com.cts.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cts.domain.Employee;

@Path("/hello")
public class HelloWorldController {

	@GET
	@Path(value = "/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee hello(@PathParam("name") String name) {
		Employee e = new Employee();
		e.setName(name);
		return e;
	}
}
