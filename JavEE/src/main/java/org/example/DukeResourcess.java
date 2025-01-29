package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import java.sql.*;

@Path("dukes")
@Produces(MediaType.APPLICATION_JSON)
public class DukeResourcess { // Fixed class name typo

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Jjwm20020";

    // Removed @OPTIONS method - now handled by CorsFilter

    @GET
    public Response getDukes() {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, age FROM dukes")) {

            while (rs.next()) {
                arrayBuilder.add(
                        Json.createObjectBuilder()
                                .add("name", rs.getString("name"))
                                .add("age", rs.getInt("age"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Database error").build();
        }

        // Removed CORS headers from response - now handled by CorsFilter
        JsonArray dukesArray = arrayBuilder.build();
        return Response.ok(dukesArray).build();
    }
}