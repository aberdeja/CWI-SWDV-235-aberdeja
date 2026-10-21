package edu.cwi;

import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {

            config.routes.get("/hello/{name}", ctx -> {
                String name = ctx.pathParam("name");
                ctx.result("Hello, " + name + "!");

            });

            config.routes.get("/hello/{name}/html", ctx -> {
                ctx.html("<html><head><title>Javalin Intro</title></head><body><h1>Hello, " + ctx.pathParam("name")
                        + "!</h1></body></html>");
            });

        }).start(7000);

    }
}
