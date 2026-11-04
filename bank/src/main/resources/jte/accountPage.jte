<%-- Java imports --%>
@import java.util.Map
@import edu.cwi.UserAccount

<%-- Parameters --%>
@param String title
@param UserAccount account

@template.jte.accountLayout(
    title = title,
    account = @`@template.jte.userAccount(account.name(), account.getFormattedBalance())`,
    detail = @`@template.jte.transactionsList(account.transactions())`
)