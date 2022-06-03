package com.apruett;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing class that helps to test the Person POJO object and the
 * error states that can occur.
 *
 * @author Anna Pruett
 */
public class PersonTest
{
    /**
     * Helps to test valid Person objects and their associated fields
     */
    @Test
    public void testValidPeople()
    {
        //Valid Person inputs, testing individual fields
        Person p1 = new Person(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");

        assertEquals(p1.getId(), 1);
        assertEquals(p1.getLastName(), "Pruett");
        assertEquals(p1.getFirstName(), "Anna");
        assertEquals(p1.getBirthday(), "04/29/2002");
        assertEquals(p1.getEmail(), "anna.pruett@oracle.com");
        assertEquals(p1.getLikes(), "Horses");
        assertEquals(p1.getCity(), "Raleigh");
        assertEquals(p1.getZipCode(), 27614);
        assertEquals(p1.getCompany(), "Oracle");

        Person p2 = new Person(2, "Pruett", "Jackson", "08/18/2003", "jackson.pruett@epicGames.com", "Rocks", "Raleigh", 27614, "Epic Games");

        assertEquals(p2.getId(), 2);
        assertEquals(p2.getLastName(), "Pruett");
        assertEquals(p2.getFirstName(), "Jackson");
        assertEquals(p2.getBirthday(), "08/18/2003");
        assertEquals(p2.getEmail(), "jackson.pruett@epicGames.com");
        assertEquals(p2.getLikes(), "Rocks");
        assertEquals(p2.getCity(), "Raleigh");
        assertEquals(p2.getZipCode(), 27614);
        assertEquals(p2.getCompany(), "Epic Games");


        //Ensure these do not throw any errors
        new Person(3, "Pruett", "Cindy", "05/10/1967", "nccindypruett@IBM.com", "Beaches", "Sunset Beach", 28468, "IBM");
        new Person(4, "Pruett", "Gregory", "06/13/1970", "ncgregpruett@lenovo.com", "Turtles", "Sunset Beach", 28468, "Lenovo");
        new Person(5, "Pruett", "Carly", "10/29/2020", "carly@gmail.com", "Dogs", "Raleigh", 27614, "Petco");
        new Person(6, "Pruett", "Rocco", "03/06/2017", "roccoPruett@pruett.com", "Hamsters", "Raleigh", 27614, "PetSmart");
        new Person(7, "Pruett", "Misty", "12/25/2014", "mistyPruett@pruett.com", "Mice", "Raleigh", 27614, "PetSmart");
        new Person(8, "Pruett", "Tobi", "10/01/2014", "mistyPruett@pruett.com", "Rats", "Raleigh", 27614, "PetSmart");
        new Person(9, "Pruett", "Ron", "05/23/1942", "ncronpruett@gmail.com", "Golf", "Shelby", 28150, "VMWare");
        new Person(1, "Pruett", "Beth", "07/02/1945", "ncbethpruett@gmail.com", "Flowers", "Shelby", 28150, "Public Library");
    }

    /**
     * Helps to test invalid first names of Person objects
     */
    @Test
    public void testInvalidFirstName()
    {
        try
        {
            new Person(1, "Pruett", "12345", "04/09/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: First name must only contain uppercase or lowercase letters.");
        }

        try
        {
            new Person(1, "Pruett", "", "04/09/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: First name field must not be blank.");
        }
    }

    /**
     * Helps to test invalid last names of Person objects
     */
    @Test
    public void testInvalidLastName()
    {
        try
        {
            new Person(1, "James", "Anna", "04/09/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Last name must be a Pruett surname.");
        }

        try
        {
            new Person(1, "", "Anna", "04/09/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Last name field must not be blank.");
        }
    }

    /**
     * Helps to test invalid emails of Person objects
     */
    @Test
    public void testInvalidEmail()
    {
        try
        {
            new Person(1, "Pruett", "Anna", "04/09/2002", "", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Email field must not be blank.");
        }

        try
        {
            new Person(1, "Pruett", "Anna", "04/09/2002", "annapruettoraclecom", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Email must contain an '@' and a '.'");
        }

        try
        {
            new Person(1, "Pruett", "Anna", "04/09/2002", "annapruett@oraclecom", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Email must contain an '@' and a '.'");
        }

        try
        {
            new Person(1, "Pruett", "Anna", "04/09/2002", "anna.pruettoracle.com", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Email must contain an '@' and a '.'");
        }

        try
        {
            new Person(1, "Pruett", "Anna", "04/09/2002", "anna.pruett@oraclecom", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Email must contain an '@' and a '.'");
        }

        try
        {
            new Person(1, "Pruett", "Anna", "04/09/2002", "anna.pruett@@@oraclecom", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Email must contain an '@' and a '.'");
        }
    }

    /**
     * Helps to test invalid zip codes of Person objects
     */
    @Test
    public void testInvalidZipcode()
    {
        try
        {
            new Person(1, "Pruett", "Anna", "04/09/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 0, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Must be a valid zipcode.");
        }

        try
        {
            new Person(1, "Pruett", "Anna", "04/09/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", -1, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Must be a valid zipcode.");
        }
    }

    /**
     * Helps to test invalid birthdays of Person objects
     */
    @Test
    public void testInvalidBirthday()
    {
        try
        {
            new Person(1, "Pruett", "Anna", "", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Birthday field must not be blank.");
        }

        try
        {
            new Person(1, "Pruett", "Anna", "04292002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }

        try
        {
            new Person(1, "Pruett", "Anna", "04/a9/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }

        try
        {
            new Person(1, "Pruett", "Anna", "04/09/200a", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }

        try
        {
            new Person(1, "Pruett", "Anna", "a4/09/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }
    }

    /**
     * Helps to test invalid cities of Person objects
     */
    @Test
    public void testInvalidCity()
    {
        try
        {
            new Person(1, "Pruett", "Anna", "04/09/2002", "anna.pruett@oracle.com", "Horses", "", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: City field must not be blank.");
        }
    }

    /**
     * Helps to test invalid likes of Person objects
     */
    @Test
    public void testInvalidLikes()
    {
        try
        {
            new Person(1, "Pruett", "Anna", "04/09/2002", "anna.pruett@oracle.com", "", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Likes field must not be blank.");
        }
    }

    /**
     * Helps to test invalid companies of Person objects
     */
    @Test
    public void testInvalidCompany()
    {
        try
        {
            new Person(1, "Pruett", "Anna", "04/09/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Company field must not be blank.");
        }
    }

    /**
     * Helps to test invalid id's of Person objects
     */
    @Test
    public void testInvalidId()
    {
        try
        {
            new Person(0, "Pruett", "Anna", "04/09/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Id must be greater than zero.");
        }

        try
        {
            new Person(-1, "Pruett", "Anna", "04/09/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Id must be greater than zero.");
        }
    }

    /**
     * Helps to test the setter method for the field of id in Person objects
     */
    @Test
    public void testSetId()
    {
        Person p1 = new Person(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");

        assertEquals(p1.getId(), 1);
        assertEquals(p1.getLastName(), "Pruett");
        assertEquals(p1.getFirstName(), "Anna");
        assertEquals(p1.getBirthday(), "04/29/2002");
        assertEquals(p1.getEmail(), "anna.pruett@oracle.com");
        assertEquals(p1.getLikes(), "Horses");
        assertEquals(p1.getCity(), "Raleigh");
        assertEquals(p1.getZipCode(), 27614);
        assertEquals(p1.getCompany(), "Oracle");

        p1.setId(2);

        assertEquals(p1.getId(), 2);

        try
        {
            p1.setId(0);
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Id must be greater than zero.");
        }

        try
        {
            p1.setId(-1);
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Id must be greater than zero.");
        }

        assertEquals(p1.getId(), 2);
    }

    /**
     * Helps to test the setter method for the field of last name in Person objects
     */
    @Test
    public void testSetLastname()
    {
        Person p1 = new Person(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");

        assertEquals(p1.getId(), 1);
        assertEquals(p1.getLastName(), "Pruett");
        assertEquals(p1.getFirstName(), "Anna");
        assertEquals(p1.getBirthday(), "04/29/2002");
        assertEquals(p1.getEmail(), "anna.pruett@oracle.com");
        assertEquals(p1.getLikes(), "Horses");
        assertEquals(p1.getCity(), "Raleigh");
        assertEquals(p1.getZipCode(), 27614);
        assertEquals(p1.getCompany(), "Oracle");

        try
        {
            p1.setLastName("");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Last name field must not be blank.");
        }

        assertEquals(p1.getLastName(), "Pruett");

        try
        {
            p1.setLastName("anna1");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Last name must only contain uppercase or lowercase letters.");
        }

        assertEquals(p1.getLastName(), "Pruett");

        try
        {
            p1.setLastName("Jones");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Last name must be a Pruett surname.");
        }

        assertEquals(p1.getLastName(), "Pruett");

        p1.setLastName("pruett");

        assertEquals(p1.getLastName(), "pruett");
    }

    /**
     * Helps to test the setter method for the field of first name in Person objects
     */
    @Test
    public void testSetFirstName()
    {
        Person p1 = new Person(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");

        assertEquals(p1.getId(), 1);
        assertEquals(p1.getLastName(), "Pruett");
        assertEquals(p1.getFirstName(), "Anna");
        assertEquals(p1.getBirthday(), "04/29/2002");
        assertEquals(p1.getEmail(), "anna.pruett@oracle.com");
        assertEquals(p1.getLikes(), "Horses");
        assertEquals(p1.getCity(), "Raleigh");
        assertEquals(p1.getZipCode(), 27614);
        assertEquals(p1.getCompany(), "Oracle");

        try
        {
            p1.setFirstName("");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: First name field must not be blank.");
        }

        assertEquals(p1.getFirstName(), "Anna");

        try
        {
            p1.setFirstName("anna1");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: First name must only contain uppercase or lowercase letters.");
        }

        assertEquals(p1.getFirstName(), "Anna");

        p1.setFirstName("Zoey");

        assertEquals(p1.getFirstName(), "Zoey");
    }

    /**
     * Helps to test the setter method for the field of birthday in Person objects
     */
    @Test
    public void testSetBirthday()
    {
        Person p1 = new Person(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");

        assertEquals(p1.getId(), 1);
        assertEquals(p1.getLastName(), "Pruett");
        assertEquals(p1.getFirstName(), "Anna");
        assertEquals(p1.getBirthday(), "04/29/2002");
        assertEquals(p1.getEmail(), "anna.pruett@oracle.com");
        assertEquals(p1.getLikes(), "Horses");
        assertEquals(p1.getCity(), "Raleigh");
        assertEquals(p1.getZipCode(), 27614);
        assertEquals(p1.getCompany(), "Oracle");

        try
        {
            p1.setBirthday("");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Birthday field must not be blank.");
        }

        assertEquals(p1.getBirthday(), "04/29/2002");

        try
        {
            p1.setBirthday("a");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }

        assertEquals(p1.getBirthday(), "04/29/2002");

        try
        {
            p1.setBirthday("04/29/200a");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }

        assertEquals(p1.getBirthday(), "04/29/2002");

        try
        {
            p1.setBirthday("04/292002");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }

        assertEquals(p1.getBirthday(), "04/29/2002");

        try
        {
            p1.setBirthday("04292002");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }

        assertEquals(p1.getBirthday(), "04/29/2002");

        try
        {
            p1.setBirthday("0429/2002");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }

        assertEquals(p1.getBirthday(), "04/29/2002");

        try
        {
            p1.setBirthday("a4/29/2002");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }

        assertEquals(p1.getBirthday(), "04/29/2002");

        try
        {
            p1.setBirthday("04/2a/2002");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }

        assertEquals(p1.getBirthday(), "04/29/2002");

        p1.setBirthday("05/05/2015");

        assertEquals(p1.getBirthday(), "05/05/2015");
    }

    /**
     * Helps to test the setter method for the field of email in Person objects
     */
    @Test
    public void testSetEmail()
    {
        Person p1 = new Person(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");

        assertEquals(p1.getId(), 1);
        assertEquals(p1.getLastName(), "Pruett");
        assertEquals(p1.getFirstName(), "Anna");
        assertEquals(p1.getBirthday(), "04/29/2002");
        assertEquals(p1.getEmail(), "anna.pruett@oracle.com");
        assertEquals(p1.getLikes(), "Horses");
        assertEquals(p1.getCity(), "Raleigh");
        assertEquals(p1.getZipCode(), 27614);
        assertEquals(p1.getCompany(), "Oracle");

        try
        {
            p1.setEmail("");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Email field must not be blank.");
        }

        try
        {
            p1.setEmail("anna@@pruett");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Email must contain an '@' and a '.'");
        }

        try
        {
            p1.setEmail("anna.caroline@pruett");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Email must contain an '@' and a '.'");
        }

        assertEquals(p1.getEmail(), "anna.pruett@oracle.com");

        p1.setEmail("ncannapruett@gmail.com");

        assertEquals(p1.getEmail(), "ncannapruett@gmail.com");
    }

    /**
     * Helps to test the setter method for the field of likes in Person objects
     */
    @Test
    public void testSetLikes()
    {
        Person p1 = new Person(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");

        assertEquals(p1.getId(), 1);
        assertEquals(p1.getLastName(), "Pruett");
        assertEquals(p1.getFirstName(), "Anna");
        assertEquals(p1.getBirthday(), "04/29/2002");
        assertEquals(p1.getEmail(), "anna.pruett@oracle.com");
        assertEquals(p1.getLikes(), "Horses");
        assertEquals(p1.getCity(), "Raleigh");
        assertEquals(p1.getZipCode(), 27614);
        assertEquals(p1.getCompany(), "Oracle");

        try
        {
            p1.setLikes("");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Likes field must not be blank.");
        }

        assertEquals(p1.getLikes(), "Horses");

        p1.setLikes("New York");

        assertEquals(p1.getLikes(), "New York");
    }

    /**
     * Helps to test the setter method for the field of city in Person objects
     */
    @Test
    public void testSetCity()
    {
        Person p1 = new Person(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");

        assertEquals(p1.getId(), 1);
        assertEquals(p1.getLastName(), "Pruett");
        assertEquals(p1.getFirstName(), "Anna");
        assertEquals(p1.getBirthday(), "04/29/2002");
        assertEquals(p1.getEmail(), "anna.pruett@oracle.com");
        assertEquals(p1.getLikes(), "Horses");
        assertEquals(p1.getCity(), "Raleigh");
        assertEquals(p1.getZipCode(), 27614);
        assertEquals(p1.getCompany(), "Oracle");

        try
        {
            p1.setCity("");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: City field must not be blank.");
        }

        assertEquals(p1.getCity(), "Raleigh");

        p1.setCity("New York");

        assertEquals(p1.getCity(), "New York");
    }

    /**
     * Helps to test the setter method for the field of zip code in Person objects
     */
    @Test
    public void testSetZipcode()
    {
        Person p1 = new Person(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");

        assertEquals(p1.getId(), 1);
        assertEquals(p1.getLastName(), "Pruett");
        assertEquals(p1.getFirstName(), "Anna");
        assertEquals(p1.getBirthday(), "04/29/2002");
        assertEquals(p1.getEmail(), "anna.pruett@oracle.com");
        assertEquals(p1.getLikes(), "Horses");
        assertEquals(p1.getCity(), "Raleigh");
        assertEquals(p1.getZipCode(), 27614);
        assertEquals(p1.getCompany(), "Oracle");

        try
        {
            p1.setZipCode(0);
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Must be a valid zipcode.");
        }

        assertEquals(p1.getZipCode(), 27614);

        try
        {
            p1.setZipCode(-1);
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Must be a valid zipcode.");
        }

        assertEquals(p1.getZipCode(), 27614);

        p1.setZipCode(11010);

        assertEquals(p1.getZipCode(), 11010);
    }

    /**
     * Helps to test the setter method for the field of company in Person objects
     */
    @Test
    public void testSetCompany()
    {
        Person p1 = new Person(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");

        assertEquals(p1.getId(), 1);
        assertEquals(p1.getLastName(), "Pruett");
        assertEquals(p1.getFirstName(), "Anna");
        assertEquals(p1.getBirthday(), "04/29/2002");
        assertEquals(p1.getEmail(), "anna.pruett@oracle.com");
        assertEquals(p1.getLikes(), "Horses");
        assertEquals(p1.getCity(), "Raleigh");
        assertEquals(p1.getZipCode(), 27614);
        assertEquals(p1.getCompany(), "Oracle");

        try
        {
            p1.setCompany("");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Company field must not be blank.");
        }

        assertEquals(p1.getCompany(), "Oracle");

        p1.setCompany("IBM");

        assertEquals(p1.getCompany(), "IBM");
    }

    @Test
    public void testToString()
    {
        Person p1 = new Person(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");

        assertEquals("Person{id=1, lastName='Pruett', firstName='Anna', birthday='04/29/2002', email='anna.pruett@oracle.com', likes='Horses', address='Raleigh', company='Oracle'}", p1.toString());
    }
}
