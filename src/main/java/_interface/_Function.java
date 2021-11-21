package _interface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
  static Function<Integer, Integer> plus1 =
      number -> number + 1;
  static Function<Integer, Integer> mult10 =
      number -> number * 10;

  public static void main(String[] args) {
    // method
    System.out.println(plus1(1));
    System.out.println(plus1multX(1, 10));

    // function
    System.out.println(plus1.apply(1));
    System.out.println(mult10.apply(plus1.apply(1)));
    System.out.println(plus1mult10.apply(1));
    System.out.println(plus1multX.apply(1, 10));
  }

  // function
  static Function<Integer, Integer> plus1mult10 =
      plus1.andThen(mult10);

  static BiFunction<Integer, Integer, Integer> plus1multX =
      (numPlus1, numTimesX) -> (numPlus1 + 1) * numTimesX;

  // method
  static int plus1(int number) {
    return number + 1;
  }

  static int plus1multX(int number, int numTimes) {
    return (number + 1) * numTimes;
  }
}
