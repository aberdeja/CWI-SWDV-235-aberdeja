package edu.cwi.data;
import java.util.List;
import org.apache.ibatis.annotations.*;

public interface AccountMapper {
    @Select("SELECT account_id as id, user_id, account_type, balance FROM accounts")
    List<Account> getAllAccounts();
 
    @Select("SELECT account_id as id, user_id, account_type, balance FROM accounts WHERE user_id = #{userId}")
    List<Account> getUserAccounts(int userId);

    @Select("SELECT account_id as id, user_id, account_type, balance FROM accounts WHERE account_id = #{accountId}")
    Account getAccount(int accountId);

    @Insert("INSERT INTO accounts (user_id, account_type, balance) VALUES (#{userId}, #{accountType}, #{balance})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Account account);

    @Update("UPDATE accounts SET balance = #{balance} WHERE account_id = #{id}")
    int update(Account account);

    @Delete("DELETE FROM accounts WHERE account_id = #{id}")
    int delete(int id);
}