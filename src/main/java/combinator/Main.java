package combinator;

import combinator.CustomerRegistrationValidator.ValidationResult;

import java.time.LocalDate;

import static combinator.CustomerRegistrationValidator.*;
import static combinator.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public class Main {
  public static void main(String[] args) {
    Customer customer = new Customer(
        "Alice",
        "aliceemail.eu",
        "088888",
        LocalDate.of(2000, 1, 1)
    );

    // method
//    System.out.println(new CustomerValidatorService().isValid(customer));

    // combinator
    ValidationResult result = isEmailValid()
        .and(isPhoneValid())
        .and(isAdult())
        .apply(customer);

    System.out.println(result);

    if (result != SUCCESS) {
      throw new IllegalStateException(result.name());
    }
  }
}
