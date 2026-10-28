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
                span(transaction)
            )

        ).render().toString();
            
        
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
            each(this.transactions.values(), t -> li(t))
        ),
        form().withMethod("post").with(
            button("Add Transaction").withType("submit")
        )
            )
        ).render().toString();
    }
    @Override
    // TransactionController.java
    public void getAll(Context ctx) {
        // Use ctx to render all transactions html
        ctx.render("jte/transactionsPage.jte", Map.of("transactions", transactions));
    }

    @Override
    public void getOne(Context ctx, String resourceId) {

        String user = transactions.get(resourceId);

        if (user != null) {
            // Use ctx to render transaction html
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void create(Context ctx) {

        String body = ctx.body();
        String id = String.valueOf(transactions.size() + 1);

        transactions.put(id, body);

		// Use ctx to render all transactions html
    }

    @Override
    public void update(Context ctx, String resourceId) {

        if (transactions.containsKey(resourceId)) {
            transactions.put(resourceId, ctx.body());

            // Use ctx to render all transactions html
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void delete(Context ctx, String resourceId) {

        transactions.remove(resourceId);
}
}