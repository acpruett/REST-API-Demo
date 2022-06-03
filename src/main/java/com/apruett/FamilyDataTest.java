package com.apruett;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testing class that helps to test the family data information
 * that is being used to simulate a database functionality.
 *
 * @author Anna Pruett
 */
public class FamilyDataTest
{
    /** Helps to store the family data information */
    FamilyData familyData;

    /**
     * Before each method to allow the program to reset for every test
     */
    @BeforeEach
    public void reset()
    {
        familyData = FamilyData.getInstance();
    }

    /**
     * Testing the getFamily() constructor to ensure it creates the
     * family data with the correct person objects and fields.
     */
    @Test
    public void testGetFamilyData()
    {
        assertEquals("Anna", familyData.getFamily().get(0).getFirstName());
        assertEquals("Jackson", familyData.getFamily().get(1).getFirstName());
        assertEquals("Cindy", familyData.getFamily().get(2).getFirstName());
        assertEquals("Gregory", familyData.getFamily().get(3).getFirstName());
        assertEquals("Carly", familyData.getFamily().get(4).getFirstName());
        assertEquals("Rocco", familyData.getFamily().get(5).getFirstName());
        assertEquals("Misty", familyData.getFamily().get(6).getFirstName());
        assertEquals("Tobi", familyData.getFamily().get(7).getFirstName());
        assertEquals("Ron", familyData.getFamily().get(8).getFirstName());
        assertEquals("Beth", familyData.getFamily().get(9).getFirstName());
    }

    /**
     * Testing the getPersonById() method
     */
    @Test
    public void testGetPersonById()
    {
        assertEquals("Anna", familyData.getPersonById(1).getFirstName());

        try
        {
            familyData.getPersonById(0);
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Id must be greater than zero.");
        }

        try
        {
            familyData.getPersonById(-1);
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Id must be greater than zero.");
        }

        try
        {
            familyData.getPersonById(11);
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: This id is not a valid family member.");
        }
    }

    /**
     * Tests the searchFamilyFirstName() method
     */
    @Test
    public void testSearchFamilyFirstName()
    {
        try
        {
            familyData.searchFamilyFirstName("");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: First name field must not be blank.");
        }

        assertEquals(1, familyData.searchFamilyFirstName("Anna").get(0).getId());

        try
        {
            familyData.searchFamilyFirstName("Elise");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: No family members found with this first name.");
        }
    }

    /**
     * Tests the searchFamilyLikes() method
     */
    @Test
    public void testSearchFamilyLikes()
    {
        try
        {
            familyData.searchFamilyLikes("");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Likes field must not be blank.");
        }

        assertEquals(1, familyData.searchFamilyLikes("Horses").get(0).getId());

        try
        {
            familyData.searchFamilyLikes("Chicken");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: No family members found with these likes.");
        }
    }

    /**
     * Tests the searchFamilyCity() method
     */
    @Test
    public void testSearchFamilyCity()
    {
        try
        {
            familyData.searchFamilyCity("");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: City field must not be blank.");
        }

        assertEquals(2, familyData.searchFamilyCity("Raleigh").get(0).getId());

        try
        {
            familyData.searchFamilyCity("Chicken");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: No family members found with this city.");
        }
    }

    /**
     * Tests the searchFamilyCompany() method
     */
    @Test
    public void testSearchFamilyCompany()
    {
        try
        {
            familyData.searchFamilyCompany("");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: Company field must not be blank.");
        }

        assertEquals(1, familyData.searchFamilyCompany("Oracle").get(0).getId());

        try
        {
            familyData.searchFamilyCompany("New York");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: No family members found with this company.");
        }
    }

    /**
     * Tests the createPerson() method
     */
    @Test
    public void testCreatePerson()
    {
        try
        {
            familyData.createPerson(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: A family member with this id already exists.");
        }

        Person p1 = new Person(105, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");

        assertEquals(p1.toString(), familyData.createPerson(105, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle").toString());
    }

    /**
     * Tests the updatePerson() method
     */
    @Test
    public void testUpdatePerson()
    {
        try
        {
            familyData.updatePerson(15, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "Raleigh", 27614, "Oracle");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: A family member with this id does not exist.");
        }

        familyData.updatePerson(1, "Pruett", "Anna", "04/29/2002", "anna.pruett@oracle.com", "Horses", "New York", 27614, "Oracle");

        assertEquals(10, familyData.getFamily().size());

        Person p1 = familyData.getPersonById(1);

        assertEquals(p1.getId(), 1);
        assertEquals(p1.getLastName(), "Pruett");
        assertEquals(p1.getFirstName(), "Anna");
        assertEquals(p1.getBirthday(), "04/29/2002");
        assertEquals(p1.getEmail(), "anna.pruett@oracle.com");
        assertEquals(p1.getLikes(), "Horses");
        assertEquals(p1.getCity(), "New York");
        assertEquals(p1.getZipCode(), 27614);
        assertEquals(p1.getCompany(), "Oracle");
    }

    /**
     * Tests the deletePersonById() method
     */
    @Test
    public void testDeletePersonById()
    {
        try
        {
            familyData.deletePersonById(100);
        }
        catch(IllegalArgumentException e)
        {
            assertEquals(e.toString(), "java.lang.IllegalArgumentException: A family member with this id does not exist.");
        }

        assertTrue(familyData.deletePersonById(8));
    }
}