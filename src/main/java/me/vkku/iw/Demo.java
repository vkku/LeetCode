package me.vkku.iw;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Demo {
    @Getter
    static class Person{
        String name;
        int age;
    }
    static class PersonComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.age - o2.age;
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        Collections.sort(persons, new PersonComparator());
        Collections.sort(persons, Comparator.comparing(Person::getAge)
                .thenComparing((Person::getName)));
        Collections.sort(persons, (Person p1, Person p2) -> {return Integer.compare(p1.age, p2.age);});

    }

    @Getter
    static class Player implements Comparable<Player>{

        String name;
        int rank;
        @Override
        public int compareTo(Player o) {
            return Integer.compare(getRank(), o.getRank());
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", rank=" + rank +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Player player = (Player) o;
            return rank == player.rank && Objects.equals(name, player.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, rank);
        }
    }
}
