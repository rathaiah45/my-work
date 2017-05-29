package com.cts.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cts.form.Product;

@Path(value = "/product")
public class ProductRestService {

	@Path(value = "/add-product")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Product product) {
		return Response.status(200).entity(product).build();
	}
}
