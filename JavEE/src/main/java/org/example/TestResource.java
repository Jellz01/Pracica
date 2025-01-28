package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("test")
public class TestResource {
    @GET
    public String test() {
        return "Works!";
    }
}