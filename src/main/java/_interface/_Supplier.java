package _interface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
  public static void main(String[] args) {
    // method
    System.out.println(getDBConnectionUrl());

    // function
    System.out.println(getDBConnectionUrlSupplier.get());
  }

  // function
  static Supplier<List<String>> getDBConnectionUrlSupplier = () ->
      List.of(
          "jdbc://localhost:5432/users",
          "jdbc://localhost:5432/items");

  // method
  static List<String> getDBConnectionUrl() {
    return List.of(
        "jdbc://localhost:5432/users",
        "jdbc://localhost:5432/items");
  }
}
