package streams;

import java.util.List;

import static streams._Stream.Gender.*;

public class _Stream {
  public static void main(String[] args) {
    List<Person> people = List.of(
        new Person("John", MALE),
        new Person("Maria", FEMALE),
        new Person("Aisha", FEMALE),
        new Person("Alex", MALE),
        new Person("Alice", FEMALE),
        new Person("Nobby", NONE)
    );

    people.stream()
        .map(person -> person.name)
//        .mapToInt(String::length)
        .forEach(System.out::println);

    boolean containsOnlyFemales = people.stream()
        .allMatch(person -> FEMALE.equals(person.gender));

    boolean containsOnlyMales = people.stream()
        .allMatch(person -> MALE.equals(person.gender));

    boolean containsFemales = people.stream()
        .anyMatch(person -> NONE.equals(person.gender));

    boolean containsOnlyGender = people.stream()
        .noneMatch(person -> NONE.equals(person.gender));

    System.out.println(containsOnlyFemales);
    System.out.println(containsOnlyMales);
    System.out.println(containsFemales);
    System.out.println(containsOnlyGender);
  }

  static class Person {
    private final String name;
    private final Gender gender;

    public Person(String name, Gender gender) {
      this.name = name;
      this.gender = gender;
    }

    @Override
    public String toString() {
      return "Person{" +
          "name='" + name + '\'' +
          ", gender=" + gender +
          '}';
    }
  }

  enum Gender {
    MALE, FEMALE, NONE
  }
}
