package com.example.bankapplication;

public class EconomyCreditOffer extends CreditOffer {

  public EconomyCreditOffer(String id) {
    super(id);
  }

  @Override
  public boolean addCustomer(Customer customer) throws Exception {
    if (customer.getName().isEmpty()) {
      throw new Exception("Customer name should not be empty");
    }
    return customersList.add(customer);
  }

  @Override
  public boolean removeCustomer(Customer customer) {
    if (!customer.isVip()) {
      return customersList.remove(customer);
    }
    return false;
  }
}
