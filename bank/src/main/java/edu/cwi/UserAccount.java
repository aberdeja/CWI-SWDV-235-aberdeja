package edu.cwi;
import java.util.Map;
import java.text.DecimalFormat;


    public record UserAccount(String id, String name, AppRole role, double balance, Map<String, String> transactions) {
        public String getFormattedBalance() {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            return df.format(balance);
        }
    }