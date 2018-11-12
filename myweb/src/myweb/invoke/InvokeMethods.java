package myweb.invoke;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/invoke")
public class InvokeMethods {

	@Path("/stringclean")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnStringClean(@QueryParam("input") String input) {
		
		String r;
		try {
					//return a error if input is missing from the url string
					if(input == null) {
						return Response.status(400).entity("Error: please specify input for this search").build();
					}
					
					r = Utilities.stringClean(input);
					
				}
				catch (Exception e) {
					e.printStackTrace();
					return Response.status(500).entity("Server was not able to process your request").build();
				}
		
		return Response.ok(r).build();
	}
	
	@Path("/maxblock")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnMaxBlock(@QueryParam("input") String input) {
		
		Integer r;
		try {
			//return a error if input is missing from the url string
			if(input == null) {
				return Response.status(400).entity("Error: please specify input for this search").build();
			}
			
			r = Utilities.maxBlock(input);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}

        return Response.ok(r.toString()).build();
	}
	
	@Path("/reorderblock")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnReorderBlock(@QueryParam("input") String input) {
		
		String r;
		try {
			//return a error if input is missing from the url string
			if(input == null) {
				return Response.status(400).entity("Error: please specify input for this search").build();
			}
			
			r = Utilities.reorderBlock(input);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}

        return Response.ok(r).build();
	}
}
