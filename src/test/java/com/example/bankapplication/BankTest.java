package com.example.bankapplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BankTest {


  @Test
  public void testEconomyCreditOfferUsualCustomer() throws Exception {
    CreditOffer economyCreditOffer = new EconomyCreditOffer("1");
    Customer sonam = new Customer("Sonam",false);

    Customer sonam2 = new Customer("",false);

    assertEquals("1",economyCreditOffer.getId());
    assertEquals(true,economyCreditOffer.addCustomer(sonam));
    assertEquals(1,economyCreditOffer.getCustomersList().size());
    assertEquals("Sonam",economyCreditOffer.getCustomersList().get(0).getName());

    assertEquals(true,economyCreditOffer.removeCustomer(sonam));
    assertEquals(0,economyCreditOffer.getCustomersList().size());

    assertThrows(Exception.class,()->economyCreditOffer.addCustomer(sonam2));
  }

  @Test
  public void testEconomyCreditOfferVipCustomer() throws Exception {
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
  public void testBusinessCreditOfferUsualCustomer() throws Exception {
    CreditOffer businessCreditOffer = new BusinessCreditOffer("2");

    Customer sonam = new Customer("Sonam",false);

    assertEquals(false,businessCreditOffer.addCustomer(sonam));
    assertEquals(0,businessCreditOffer.getCustomersList().size());
    assertEquals(false,businessCreditOffer.removeCustomer(sonam));
    assertEquals(0,businessCreditOffer.getCustomersList().size());

  }

  @Test
  public void testBusinessCreditOfferVipCustomer() throws Exception {
    CreditOffer businessCreditOffer = new BusinessCreditOffer("2");

    Customer deepa = new Customer("Deepa",true);

    assertEquals(true,businessCreditOffer.addCustomer(deepa));
    assertEquals(1,businessCreditOffer.getCustomersList().size());
    assertEquals(false,businessCreditOffer.removeCustomer(deepa));
    assertEquals(1, businessCreditOffer.getCustomersList().size());

  }


}
