package tasks.comparator;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person.PersonBuilder().name("Tom").surname("Tom").dateOfBirth("2/12/1999").build();
        Person person2 = new Person.PersonBuilder().name("John").surname("John").dateOfBirth("13/09/1993").build();
        Person person3 = new Person.PersonBuilder().name("Donna").surname("Donna").dateOfBirth("21/10/1997").build();
        Person person4 = new Person.PersonBuilder().name("Tom").surname("John").dateOfBirth("2/12/1999").build();
        Person person5 = new Person.PersonBuilder().name("John").surname("Donna").dateOfBirth("13/09/1993").build();

        // 1
        List<Person> personList1 = new ArrayList<>(Arrays.asList(person1, person2, person3, person4, person5));
        Collections.sort(personList1, new Person.PersonComparator());
        for (Person person : personList1){
            System.out.println(person.toString());
        }
        System.out.println("**********");

        // 2
        List<Person> personList2 = new ArrayList<>(Arrays.asList(person1, person2, person3, person4, person5));
        personList2.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        for (Person person : personList2){
            System.out.println(person.toString());
        }
        System.out.println("**********");

        // 3
        List<Person> personList3 = new ArrayList<>(Arrays.asList(person1, person2, person3, person4, person5));
        personList3.sort(Comparator.comparing(Person::getName).thenComparing(Person::getSurname));
        for (Person person : personList3){
            System.out.println(person.toString());
        }
    }
}

