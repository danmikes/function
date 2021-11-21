package _interface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
  public static void main(String[] args) {
    Customer maria = new Customer("Maria", "88888");

    // method
    greetCustomer(maria);
    greetCustomer2(maria, false);

    // function
    greetCustomerConsumer.accept(maria);
    greetCustomerConsumer2.accept(maria, false);
  }

  // function
  static Consumer<Customer> greetCustomerConsumer = customer ->
      System.out.println("Hello "
          + customer.customerName
          + ", thank you for registering phone number "
          + customer.customerPhone);

  static BiConsumer<Customer, Boolean> greetCustomerConsumer2 = (customer, showPhone) ->
      System.out.println("Hello "
          + customer.customerName
          + ", thank you for registering phone number "
          + (showPhone ? customer.customerPhone : "*****"));

  // method
  static void greetCustomer(Customer customer) {
    System.out.println("Hello "
        + customer.customerName
        + ", thank you for registering phone number "
        + customer.customerPhone);
  }

  static void greetCustomer2(Customer customer, boolean showPhone) {
    System.out.println("Hello "
        + customer.customerName
        + ", thank you for registering phone number "
        + (showPhone ? customer.customerPhone : "*****"));
  }

  static class Customer {
    private final String customerName;
    private final String customerPhone;

    public Customer(String customerName, String customerPhone) {
      this.customerName = customerName;
      this.customerPhone = customerPhone;
    }
  }
}
