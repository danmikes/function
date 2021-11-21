package combinator;

import java.time.LocalDate;

public class Customer {
  private final String name;
  private final String email;
  private final String phone;
  private final LocalDate birth;

  public Customer(String name, String email, String phone, LocalDate birth) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.birth = birth;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public LocalDate getBirth() {
    return birth;
  }
}
