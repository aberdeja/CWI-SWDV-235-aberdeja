package edu.cwi.data;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface TransactionMapper {
    @Select("SELECT transaction_id as id, account_id, transaction_type, amount, timestamp FROM transactions")
    List<Transaction> getAllTransactions();

    @Select("SELECT transaction_id as id, account_id, transaction_type, amount, timestamp FROM transactions WHERE account_id = #{accountId}")
    List<Transaction> getAccountTransactions(int accountId);

    @Select("SELECT transaction_id as id, account_id, transaction_type, amount, description, created_at FROM transactions WHERE transaction_id = #{id}")
    Transaction getTransaction(int transactionId);

    @Insert("INSERT INTO transactions (account_id, transaction_type, amount, description, created_at) VALUES (#{accountId}, #{transactionType}, #{amount}, #{description}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Transaction transaction);

    @Delete("DELETE FROM transactions WHERE account_id = #{id}")
    int delete(int id);
}
