package finalsection;

import java.util.function.BiFunction;

public class Lambda {
  public static void main(String[] args) {
    System.out.println(upperCaseName.apply("Alex",20));
  }

  static BiFunction<String,Integer,String> upperCaseName = (name,age) -> {
    if (name.isBlank()) throw new IllegalArgumentException("");
    System.out.println(age);
    return name.toUpperCase();
  };
}
