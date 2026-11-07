package edu.cwi;

import io.javalin.http.Context;
import java.util.Optional;

public class AuthController {

    public static Optional<UserAccount> getUser(String userId) {
        // Sample data for demonstration purposes
        if ("1".equals(userId)) {
            return Optional.of(new UserAccount("Alice", 1000.00, null));
        } else if ("2".equals(userId)) {
            return Optional.of(new UserAccount("Bob", 500.00, null));
        }
        return Optional.empty();
    }

    public static void login(Context ctx) {
        String userId = ctx.formParam("user-id");
        ctx.cookieStore().set("user-id", userId);
        ctx.redirect("/account");
    }

    public static void logout(Context ctx) {
        ctx.cookieStore().clear();
        ctx.redirect("/");
    }
}