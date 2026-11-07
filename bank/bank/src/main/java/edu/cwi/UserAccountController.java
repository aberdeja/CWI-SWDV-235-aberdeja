package edu.cwi;

import io.javalin.http.Context;
import java.util.List;

public class UserAccountController {

    private final List<UserAccount> accounts;

    public UserAccountController() {
        this.accounts = List.of(
            new UserAccount("Alice", 1000.00, List.of("Transaction A1", "Transaction A2")),
            new UserAccount("Bob", 500.00, List.of("Transaction B1"))
        );
    }

    public void renderAccounts(Context ctx) {
        ctx.render("jte/accountsPage.jte", Map.of("title", "User Accounts", "accounts", accounts));
    }

    public UserAccount getAccount(String username) {
        return accounts.stream()
            .filter(account -> account.getUsername().equals(username))
            .findFirst()
            .orElse(null);
    }
}