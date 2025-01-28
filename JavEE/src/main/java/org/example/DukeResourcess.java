package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.OPTIONS;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

@Path("dukes")
@Produces(MediaType.APPLICATION_JSON)
public class DukeResourcess {

    @OPTIONS
    public jakarta.ws.rs.core.Response options() {
        return jakarta.ws.rs.core.Response
                .ok()
                .header("Access-Control-Allow-Origin", "http://localhost:4200")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .build();
    }

    @GET
    public JsonArray dukes() {
        return Json.createArrayBuilder()
                .add(duke("Joseph", 19))
                .add(duke("Julian", 55))
                .add(duke("fabian", 69))
                .build();
    }

    private JsonObject duke(String name, int age) {
        return Json.createObjectBuilder()
                .add("name", name)
                .add("age", age)
                .build();
    }
}