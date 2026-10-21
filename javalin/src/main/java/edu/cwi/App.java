package edu.cwi;

import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var app = Javalin.create(config -> {
            config.routes.get("/", ctx -> ctx.result("Hello, World!"));
        }).start(7070);
    }
}
