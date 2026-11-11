package edu.cwi;

import java.util.Map;

import io.javalin.http.Context;

public class AccountController {
    public static void renderAccount(Context ctx) {
        // get the user id from the cookie 
        // use the user id to get the user account from the AuthController
        // if there's a user, render the accountpage.jte with the user account
        // otherwise, redirect to the unauthorized page

        String userId = ctx.cookieStore().get("user-id");

        if (userId == null || userId.isBlank()) {
            ctx.redirect("/unauthorized");
            return;
        }

        UserAccount account = AuthController.getUserAccount(userId);

        if (account == null) {
            ctx.redirect("/unauthorized");
            return;
        }

        ctx.render("jte/accountPage.jte", Map.of("account", account));



}

}
