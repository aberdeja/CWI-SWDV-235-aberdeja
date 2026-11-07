package edu.cwi;

import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

import java.util.List;

import io.javalin.rendering.template.JavalinJte; // <-- import jte

public class App {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {

            config.fileRenderer(new JavalinJte()); // <-- set jte as the renderer

            config.routes.apiBuilder(() -> {
                path("/account", List.of(AppRole.CUSTOMER), () -> {
                    get(AccountController::renderAccount); // requires CUSTOMER role
                });

                get("/unauthorized", ctx -> ctx.result("Unauthorized: Please log in."));
            });
        }).start(7070);

    }
}