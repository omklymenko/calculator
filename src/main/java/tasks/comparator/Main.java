package tasks.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person.PersonBuilder().name("Tom").surname("Tom").dateOfBirth("2/12/1999").build();
        Person person2 = new Person.PersonBuilder().name("John").surname("John").dateOfBirth("13/09/1993").build();
        Person person3 = new Person.PersonBuilder().name("Donna").surname("Donna").dateOfBirth("21/10/1997").build();

        List<Person> personList = new ArrayList<>(Arrays.asList(person1, person2, person3));
        Collections.sort(personList, new Person.NameComparator());
        System.out.println(personList.get(0).getName());
        System.out.println(personList.get(1).getName());
        System.out.println(personList.get(2).getName());
    }
}
