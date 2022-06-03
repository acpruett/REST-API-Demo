package com.apruett;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulates a database functionality and contains information of a
 * family of Person objects. The Person objects are stored within
 * a list called family and this information will be used for tasks
 * such as searching for family members based on their name, city,
 * company, or their likes. This information will also be used for
 * tasks such as deleting family members, updating family members,
 * or creating new family members.
 *
 * @author Anna Pruett
 */
public class FamilyData
{
    /** List that will store Person objects of the family */
    private List<Person> family;

    /** Helps to store the singleton instance of FamilyData */
    private static FamilyData instance = null;

    /**
     * Gets the singleton instance of the family's data so that
     * changes can be persisted across different HTTP requests
     * of the data.
     *
     * @return The familyData singleton instance containing the
     * People objects
     */
    public static FamilyData getInstance()
    {
        if(instance == null)
        {
            instance = new FamilyData(); //Making a singleton
        }

        return instance;
    }

    /**
     * Adds information of the family's data to the family
     * list. This constructor creates the new array list for the
     * family and gives it the declaration. This is what is simulating
     * the database functionality.
     */
    public FamilyData()
    {
        family = new ArrayList<Person>();

        // int id, String lastName, String firstName, String birthday, String email, String likes, String city, int zipCode, String company
        family.add(new Person(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle"));
        family.add(new Person(2, "Pruett", "Jackson", "08/18/2003", "jackson.pruett@epicGames.com", "Rocks", "Raleigh", 27614, "Epic Games"));
        family.add(new Person(3, "Pruett", "Cindy", "05/10/1967", "nccindypruett@IBM.com", "Beaches", "Sunset Beach", 28468, "IBM"));
        family.add(new Person(4, "Pruett", "Gregory", "06/13/1970", "ncgregpruett@lenovo.com", "Turtles", "Sunset Beach", 28468, "Lenovo"));
        family.add(new Person(5, "Pruett", "Carly", "10/29/2020", "carly@gmail.com", "Dogs", "Raleigh", 27614, "Petco"));
        family.add(new Person(6, "Pruett", "Rocco", "03/06/2017", "roccoPruett@pruett.com", "Hamsters", "Raleigh", 27614, "PetSmart"));
        family.add(new Person(7, "Pruett", "Misty", "12/25/2014", "mistyPruett@pruett.com", "Mice", "Raleigh", 27614, "PetSmart"));
        family.add(new Person(8, "Pruett", "Tobi", "10/01/2014", "mistyPruett@pruett.com", "Rats", "Raleigh", 27614, "PetSmart"));
        family.add(new Person(9, "Pruett", "Ron", "05/23/1942", "ncronpruett@gmail.com", "Golf", "Shelby", 28150, "VMWare"));
        family.add(new Person(10, "Pruett", "Beth", "07/02/1945", "ncbethpruett@gmail.com", "Flowers", "Shelby", 28150, "Library"));
    }

    /**
     * Getter method to help to get the family information and
     * return the list of Person objects.
     *
     * @return The list of Person objects that make up the family
     */
    public List<Person> getFamily()
    {
        return family;
    }

    /**
     * Helps to search through the database of the family information
     * of Person objects and find a given Person based on their
     * id. This method will return null if it is unable to find a
     * family member with the given id.
     *
     * @param id The id of the family member to get
     * @return The person with the given id in the family, or null
     * if a Person does not exist
     */
    public Person getPersonById(int id)
    {
        if(id <= 0)
        {
            throw new IllegalArgumentException("Id must be greater than zero.");
        }

        for(Person person : family)
        {
            if(person.getId() == id)
            {
                return person;
            }
        }

        throw new IllegalArgumentException("This id is not a valid family member.");
    }

    /**
     * Searches through the list of family data containing
     * the Person objects and finds the family members that
     * contain a given first name. These family members are then
     * added to a new list and returned. This method contains
     * error checking to ensure the given parameter is not
     * null or blank.
     *
     * @param searchTerm The first name to search for within the
     * family data
     * @return The list of family members with a given first name
     */
    public List<Person> searchFamilyFirstName(String searchTerm)
    {
        if(searchTerm == null || searchTerm.equals(""))
        {
            throw new IllegalArgumentException("First name field must not be blank.");
        }

        List<Person> searchedPeople = new ArrayList<Person>();

        int counter = 0;

        for(Person person : family)
        {
            if(person.getFirstName().equalsIgnoreCase(searchTerm))
            {
                searchedPeople.add(person);

                counter++;
            }
        }

        if(counter == 0)
        {
            throw new IllegalArgumentException("No family members found with this first name.");
        }
        else
        {
            return searchedPeople;
        }
    }

    /**
     * Searches through the list of family data containing
     * the Person objects and finds the family members that
     * contain a given like. These family members are then
     * added to a new list and returned. This method contains
     * error checking to ensure the given parameter is not
     * null or blank.
     *
     * @param searchTerm The likes to search for within the
     * family data
     * @return The list of family members with a given like
     */
    public List<Person> searchFamilyLikes(String searchTerm)
    {
        if(searchTerm == null || searchTerm.equals(""))
        {
            throw new IllegalArgumentException("Likes field must not be blank.");
        }

        List<Person> searchedPeople = new ArrayList<Person>();

        int counter = 0;

        for(Person person : family)
        {
            if(person.getLikes().equalsIgnoreCase(searchTerm))
            {
                searchedPeople.add(person);

                counter++;
            }
        }

        if(counter == 0)
        {
            throw new IllegalArgumentException("No family members found with these likes.");
        }
        else
        {
            return searchedPeople;
        }
    }

    /**
     * Searches through the list of family data containing
     * the Person objects and finds the family members that
     * contain a given city. These family members are then
     * added to a new list and returned. This method contains
     * error checking to ensure the given parameter is not
     * null or blank.
     *
     * @param searchTerm The city to search for within the
     * family data
     * @return The list of family members with a given city
     */
    public List<Person> searchFamilyCity(String searchTerm)
    {
        if(searchTerm == null || searchTerm.equals(""))
        {
            throw new IllegalArgumentException("City field must not be blank.");
        }

        List<Person> searchedPeople = new ArrayList<Person>();

        int counter = 0;

        for(Person person : family)
        {
            if(person.getCity().equalsIgnoreCase(searchTerm))
            {
                searchedPeople.add(person);

                counter++;
            }
        }

        if(counter == 0)
        {
            throw new IllegalArgumentException("No family members found with this city.");
        }
        else
        {
            return searchedPeople;
        }
    }

    /**
     * Searches through the list of family data containing
     * the Person objects and finds the family members that
     * contain a given company. These family members are then
     * added to a new list and returned. This method contains
     * error checking to ensure the given parameter is not
     * null or blank.
     *
     * @param searchTerm The company to search for within the
     * family data
     * @return The list of family members with a given company
     */
    public List<Person> searchFamilyCompany(String searchTerm)
    {
        if(searchTerm == null || searchTerm.equals(""))
        {
            throw new IllegalArgumentException("Company field must not be blank.");
        }

        List<Person> searchedPeople = new ArrayList<Person>();

        int counter = 0;

        for(Person person : family)
        {
            if(person.getCompany().equalsIgnoreCase(searchTerm))
            {
                searchedPeople.add(person);

                counter++;
            }
        }

        if(counter == 0)
        {
            throw new IllegalArgumentException("No family members found with this company.");
        }
        else
        {
            return searchedPeople;
        }
    }

    /**
     * Helps to create a new Person object and add it to the
     * family database. This method will delegate to the Person
     * constructor to handle any error checking relating to
     * creating the new Person.
     *
     * @param id The id of the person object being created
     * @param lastName The last name of the person object being created
     * @param firstName The first name of the person object being created
     * @param birthday The birthday of the person object being created
     * @param email The email of the person object being created
     * @param likes The likes of the person object being created
     * @param city The city of the person object being created
     * @param zipCode The zip code of the person object being created
     * @param company The company of the person object being created
     * @return The new Person object being created and added into
     * the family's data
     */
    public Person createPerson(int id, String lastName, String firstName, String birthday, String email, String likes, String city, int zipCode, String company)
    {
        Person newPerson = new Person(id, lastName, firstName, birthday, email, likes, city, zipCode, company);

        int count = 0;

        for(Person person : family)
        {
            if(person.getId() == id)
            {
                count++;
            }
        }

        if(count == 0)
        {
            family.add(newPerson);
        }
        else
        {
            throw new IllegalArgumentException("A family member with this id already exists.");
        }

        return newPerson;
    }

    /**
     * Helps to update one of the Person objects within the
     * family's data given a specific id. If the id does not
     * exist, then the method will return null.
     *
     * @param id The id of the Person in the family to update
     * @param lastName The last name of the Person in the family to update
     * @param firstName The first name of the Person in the family to update
     * @param birthday The birthday of the Person in the family to update
     * @param email The email of the Person in the family to update
     * @param likes The likes of the Person in the family to update
     * @param city The city of the Person in the family to update
     * @param zipCode zip code id of the Person in the family to update
     * @param company The company of the Person in the family to update
     * @return The newly updated Person object
     */
    public Person updatePerson(int id, String lastName, String firstName, String birthday, String email, String likes, String city, int zipCode, String company)
    {
        for(Person person : family)
        {
            if(person.getId() == id)
            {
                int personIndex = family.indexOf(person);

                person.setLastName(lastName);
                person.setFirstName(firstName);
                person.setBirthday(birthday);
                person.setEmail(email);
                person.setLikes(likes);
                person.setCity(city);
                person.setZipCode(zipCode);
                person.setCompany(company);

                family.set(personIndex, person);

                return person;
            }
        }

        throw new IllegalArgumentException("A family member with this id does not exist.");
    }

    /**
     * Helps to delete a Person from the family data given
     * a specific id. If a Person does not exist in the family
     * with the given id, then the method will throw an exception.
     * If a Person does exist with a given id, then the method
     * will return true.
     *
     * @param id The id of the Person to delete from the family
     * @return True if the method is able to find and delete a
     * given Person with a certain id from the family data
     */
    public boolean deletePersonById(int id)
    {
        int personIndex = -1;

        for(Person person : family)
        {
            if(person.getId() == id)
            {
                personIndex = family.indexOf(person);
            }
        }

        if(personIndex > -1)
        {
            family.remove(personIndex);

            return true;
        }

        throw new IllegalArgumentException("A family member with this id does not exist.");
    }
}
