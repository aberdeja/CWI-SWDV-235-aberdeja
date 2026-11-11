package edu.cwi;

import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

import java.util.List;

import io.javalin.rendering.template.JavalinJte; // <-- import jte
import io.javalin.http.UnauthorizedResponse;
import io.javalin.http.staticfiles.Location;

public class App {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {

            config.staticFiles.add("/public", Location.CLASSPATH);

            config.fileRenderer(new JavalinJte()); // <-- set jte as the renderer

            config.routes.beforeMatched(ctx -> {
                if (ctx.routeRoles().isEmpty()) {
                    return; // if there are no route roles, we don't need to check anything
                }

                String role = ctx.cookieStore().get("user-role"); // get the role from the cookie store
                AppRole appRole = AppRole.valueOf(role);

                if (!ctx.routeRoles().contains(appRole)) {
                    throw new UnauthorizedResponse(); // deny access to the route if the user doesn't have the role
                }
            });

            config.routes.apiBuilder(() -> {
                path("/login", () -> {
                    post(AuthController::authenticate);
                });
                path("/logout", () -> {
                    get(AuthController::logout);
                });
                path("/account", List.of(AppRole.CUSTOMER), () -> {
                    get(AccountController::renderAccount); // requires CUSTOMER role
                });

                get("/unauthorized", ctx -> ctx.result("Unauthorized: Please log in."));
            });
        }).start(7070);

    }
}