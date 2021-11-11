package org.larrieulacoste.noe.al.api;

public interface PaymentAPI {
    Boolean pay(String bankAccount, Double amount);
}
