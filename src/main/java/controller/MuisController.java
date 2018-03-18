package controller;

import model.Muis;
import service.MuisService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/muis")
@Produces(MediaType.APPLICATION_JSON)
public class MuisController {

    @Inject
    MuisService muisService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newMuis(Muis muis){
        Muis newMuis;
        if(muis.getName().equals("Danny")
                || muis.getName().equals("danny")
                || muis.getName().contains("danny")
                || muis.getName().contains("Danny")){
            newMuis = muisService.addMuis(muis.getUsername(),muis.getPassword(),muis.getName(),muis.getAge(),muis.getNickname(), true);
        }
        else{
            newMuis = muisService.addMuis(muis.getUsername(),muis.getPassword(),muis.getName(),muis.getAge(),muis.getNickname());
        }
        if(newMuis == null) return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(newMuis).build();
    }
}
