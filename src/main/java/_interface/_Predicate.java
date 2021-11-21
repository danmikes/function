package _interface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
  public static void main(String[] args) {
    // method
    System.out.println("no predicate");
    System.out.println(isPhoneValid("07000"));
    System.out.println(isPhoneValid("09000"));
    System.out.println(isPhoneValid("070000"));

    // function
    System.out.println("predicate");
    System.out.println(isPhoneValid.test("07000"));
    System.out.println(isPhoneValid.test("09000"));
    System.out.println(isPhoneValid.test("070000"));

    System.out.println(
        "is phone valid and contains number 3 = " +
            isPhoneValid.and(containsNumber3).test("07003"));

    System.out.println(
        "is phone valid and contains number 3 = " +
            isPhoneValid.and(containsNumber3).test("07000"));

    System.out.println(
        "is phone valid and contains number 3 = " +
            isPhoneValid.or(containsNumber3).test("07003"));

    System.out.println(
        "is phone valid and contains number 3 = " +
            containsNumberX.test("07003","3"));
  }

  // function
  static Predicate<String> isPhoneValid =
      phone -> phone.startsWith("07") && phone.length() == 5;

  static Predicate<String> containsNumber3 =
      phone -> phone.contains("3");

  static BiPredicate<String,String> containsNumberX =
      (phone, digit) -> phone.contains(digit);

  // method
  static boolean isPhoneValid(String phone) {
    return phone.startsWith("07") && phone.length() == 5;
  }
}
