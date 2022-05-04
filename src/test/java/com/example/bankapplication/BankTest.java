package com.example.bankapplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankTest {

  // sHOW COLOURS
  // RED
  //REFACTOR
  @Test
  public void testEconomyCreditOfferUsualCustomer(){
    CreditOffer economyCreditOffer = new EconomyCreditOffer("1");
    Customer sonam = new Customer("Sonam",false);

    assertEquals("1",economyCreditOffer.getId());
    assertEquals(true,economyCreditOffer.addCustomer(sonam));
    assertEquals(1,economyCreditOffer.getCustomersList().size());
    assertEquals("Sonam",economyCreditOffer.getCustomersList().get(0).getName());

    assertEquals(true,economyCreditOffer.removeCustomer(sonam));
    assertEquals(0,economyCreditOffer.getCustomersList().size());
  }

  @Test
  public void testEconomyCreditOfferVipCustomer(){
    CreditOffer econmomyCreditOffer = new EconomyCreditOffer("1");
    Customer deepa = new Customer("Deepa",true);

    assertEquals("1",econmomyCreditOffer.getId());
    assertEquals(true,econmomyCreditOffer.addCustomer(deepa));
    assertEquals(1,econmomyCreditOffer.getCustomersList().size());
    assertEquals("Deepa",econmomyCreditOffer.getCustomersList().get(0).getName());

    assertEquals(false,econmomyCreditOffer.removeCustomer(deepa));
    assertEquals(1,econmomyCreditOffer.getCustomersList().size());
  }


  @Test
  public void testBusinessCreditOfferUsualCustomer(){
    CreditOffer businessCreditOffer = new BusinessCreditOffer("2");

    Customer sonam = new Customer("Sonam",false);

    assertEquals(false,businessCreditOffer.addCustomer(sonam));
    assertEquals(0,businessCreditOffer.getCustomersList().size());
    assertEquals(false,businessCreditOffer.removeCustomer(sonam));
    assertEquals(0,businessCreditOffer.getCustomersList().size());

  }

  @Test
  public void testBusinessCreditOfferVipCustomer(){
    CreditOffer businessCreditOffer = new BusinessCreditOffer("2");

    Customer deepa = new Customer("Deepa",true);

    assertEquals(true,businessCreditOffer.addCustomer(deepa));
    assertEquals(1,businessCreditOffer.getCustomersList().size());
    assertEquals(false,businessCreditOffer.removeCustomer(deepa));
    assertEquals(1, businessCreditOffer.getCustomersList().size());

  }


}
