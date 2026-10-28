package edu.cwi;

import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

import io.javalin.rendering.template.JavalinJte; // <-- import jte

public class App 
{
    public static void main( String[] args )
    {
        var app = Javalin.create(config -> {

			config.fileRenderer(new JavalinJte()); // <-- set jte as the renderer

			config.routes.apiBuilder(() -> {
				crud("transactions/{id}", new TransactionsController()); 
			});
            
        }).start(7070);
    }
}