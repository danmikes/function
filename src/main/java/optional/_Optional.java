package optional;

import java.util.Optional;

public class _Optional {
  public static void main(String[] args) {
    Optional.ofNullable(null)
        .ifPresentOrElse(
            email -> System.out.println("sending email to " + email),
            () -> System.out.println("cannot send email"));
  }
}
