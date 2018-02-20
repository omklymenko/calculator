package tasks.comparator;

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
            this.nestedName = nestedName;
            return this;
        }

        public PersonBuilder surname(String surname) {
            this.nestedSurname = nestedSurname;
            return this;
        }

        public PersonBuilder dateOfBirth(Date dateOfBirth) {
            this.nestedDateOfBirth = nestedDateOfBirth;
            return this;
        }

        public PersonBuilder residence(String residence) {
            this.nestedResidence = nestedResidence;
            return this;
        }

        public PersonBuilder favouriteNumber(int favouriteNumber) {
            this.nestedFavouriteNumber = nestedFavouriteNumber;
            return this;
        }

        public Person build(){
            return new Person(nestedName, nestedSurname,nestedDateOfBirth, nestedResidence, nestedFavouriteNumber);
        }

    }

}
