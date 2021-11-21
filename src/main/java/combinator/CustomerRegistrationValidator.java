package combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinator.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator
    extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

  static CustomerRegistrationValidator isEmailValid() {
    return customer -> customer.getEmail().contains("@") ?
        SUCCESS : EMAIL_INVALID;
  }

  static CustomerRegistrationValidator isPhoneValid() {
    return customer -> customer.getPhone().startsWith("+0") ?
        SUCCESS : PHONE_INVALID;
  }

  static CustomerRegistrationValidator isAdult() {
    return customer -> Period.between(customer.getBirth(), LocalDate.now()).getYears() > 16 ?
        SUCCESS : NOT_ADULT;
  }

  default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
    return customer -> {
      ValidationResult result = this.apply(customer);
      return result.equals(SUCCESS) ? other.apply(customer) : result;
    };
  }

  enum ValidationResult {
    SUCCESS,
    PHONE_INVALID,
    EMAIL_INVALID,
    NOT_ADULT
  }
}
