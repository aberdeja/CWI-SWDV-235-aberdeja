package edu.cwi;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import static j2html.TagCreator.*;

public class TransactionsController implements CrudHandler {
    private final Map<String, String> transactions = new ConcurrentHashMap<>();


    public TransactionsController() {
        transactions.put("1", "Transaction 1");
        transactions.put("2", "Transaction 2");
    }

    private String renderSingleTransactions(String id) {
        String transaction = transactions.get(id);

        return html(
            head(
                title("Transaction " + id),
                link().withRel("stylesheet").withHref("/css/main.css")
            ),
            body(
                h1("Transaction Detail"),
                p(transaction),
                a("Back to Transactions").withHref("/transactions")
            )
        ).render();
    }

    private String renderTransactions() {
        return html(
            head(
                title("Transactions"),
                link().withRel("stylesheet").withHref("/css/main.css")
            ),
            body(
                h1("Transactions"),
                ul(
                    each(this.transactions.entrySet(), entry ->
                        li(
                            a(entry.getValue()).withHref("/transactions/" + entry.getKey()),
                            form().withMethod("post")
                                .withAction("/transactions/" + entry.getKey())
                                .with(
                                    input().withType("hidden").withName("_method").withValue("DELETE"),
                                    button("Delete").withType("submit")
                                )
                        )
                    )
                ),
                form().withMethod("post").withAction("/transactions").with(
                    input().withType("text").withName("transaction").withPlaceholder("Add a transaction"),
                    button("Add Transaction").withType("submit")
                )
            )
        ).render();
    }
    @Override
    public void getAll(Context ctx) {
        ctx.html(renderTransactions());
    }

    @Override
    public void getOne(Context ctx, String resourceId) {
        String transaction = transactions.get(resourceId);

        if (transaction != null) {
            ctx.html(renderSingleTransactions(resourceId));
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void create(Context ctx) {
        String body = ctx.formParam("transaction");
        if (body == null) {
            body = ctx.body();
        }

        if (body == null || body.isBlank()) {
            ctx.status(400).result("Transaction cannot be empty");
            return;
        }

        String id = String.valueOf(transactions.size() + 1);
        transactions.put(id, body.trim());
        ctx.redirect("/transactions");
    }

    @Override
    public void update(Context ctx, String resourceId) {
        if (transactions.containsKey(resourceId)) {
            String body = ctx.formParam("transaction");
            if (body == null) {
                body = ctx.body();
            }

            if (body == null || body.isBlank()) {
                ctx.status(400).result("Transaction cannot be empty");
                return;
            }

            transactions.put(resourceId, body.trim());
            ctx.redirect("/transactions/" + resourceId);
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void delete(Context ctx, String resourceId) {
        if (transactions.remove(resourceId) != null) {
            ctx.redirect("/transactions");
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }
}