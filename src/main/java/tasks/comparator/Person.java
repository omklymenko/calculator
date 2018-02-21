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

    public Person(String name, String surname, Date dateOfBirth, String residence, int favouriteNumber) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.residence = residence;
        this.favouriteNumber = favouriteNumber;
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
                e.printStackTrace();
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
                return new Person(nestedName, nestedSurname, nestedDateOfBirth, nestedResidence, nestedFavouriteNumber);
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

}
