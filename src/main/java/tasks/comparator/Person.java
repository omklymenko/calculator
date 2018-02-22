package tasks.comparator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Person {

    private final String name;
    private final String surname;
    private final Date dateOfBirth;
    private final String residence;
    private final int favouriteNumber;

    private Person(PersonBuilder builder) {
        this.name = builder.nestedName;
        this.surname = builder.nestedSurname;
        this.dateOfBirth = builder.nestedDateOfBirth;
        this.residence = builder.nestedResidence;
        this.favouriteNumber = builder.nestedFavouriteNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getResidence() {
        return residence;
    }

    public int getFavouriteNumber() {
        return favouriteNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", dateOfBirth = " + new SimpleDateFormat("dd/MM/yyyy").format(dateOfBirth) +
                ", residence = '" + residence + '\'' +
                ", favouriteNumber = " + favouriteNumber +
                '}';
    }

    public static class PersonBuilder {

        private String nestedName;
        private String nestedSurname;
        private Date nestedDateOfBirth;
        private String nestedResidence;
        private int nestedFavouriteNumber;

        // Spring (имя не set) ???
        public PersonBuilder name(String name) {
            this.nestedName = name;
            return this;
        }

        public PersonBuilder surname(String surname) {
            this.nestedSurname = surname;
            return this;
        }

        public PersonBuilder dateOfBirth(String dateOfBirth) {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                this.nestedDateOfBirth= formatter.parse(dateOfBirth);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Only dd/MM/yyyy is acceptable");
            }
            return this;
        }

        public PersonBuilder residence(String residence) {
            this.nestedResidence = residence;
            return this;
        }

        public PersonBuilder favouriteNumber(int favouriteNumber) {
            if(favouriteNumber >= -100 && favouriteNumber <= 100) {
                this.nestedFavouriteNumber = favouriteNumber;
            } else {
                throw new IllegalArgumentException("Only -100 <= favouriteNumber <= 100 are acceptable");
            }
            return this;
        }

        public Person build(){
            if(nestedName != null && nestedSurname != null && nestedDateOfBirth != null) {
                return new Person(this);
            } else {
                throw new IllegalArgumentException("Name, Surname and Date of Birth are required");
            }
        }

    }

    static class NameComparator implements Comparator<Person> {
        public int compare(Person p1, Person p2)
        {
            return p1.getName().compareTo(p2.getName());
        }
    }

    static class SurnameComparator implements Comparator<Person> {
        public int compare(Person p1, Person p2)
        {
            return p1.getSurname().compareTo(p2.getSurname());
        }
    }

    static class PersonComparator implements Comparator<Person> {
        public int compare(Person person1, Person person2) {
            int c;
            c = person1.getName().compareTo(person2.getName());
            if (c == 0)
                c = person1.getSurname().compareTo(person2.getSurname());
            return c;
        }
    }

}
