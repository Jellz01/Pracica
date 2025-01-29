package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

            public static void main(String[] args) {
                String url = "jdbc:postgresql://localhost:5432/postgres";
                String user = "postgres";
                String password = "Jjwm20020";

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    System.out.println("Connected to PostgreSQL successfully!");
                } catch (Exception e) {
                    System.out.println("Connection failed!");
                    e.printStackTrace();
                }
            }
        }


