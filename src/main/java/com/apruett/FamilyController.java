package com.apruett;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

/**
 * The controller for the Family project that helps to take in
 * HTTP requests and handle them accordingly and delegate to other classes
 * and methods. This controller allows for PUT, POST, DELETE, and GET
 * operations to be performed on the data.
 *
 * @author Anna Pruett
 */
@RestController
public class FamilyController
{
    /**
     * Helps to get a singleton instance of the family's data so that
     * changes can be persisted across different HTTP requests of the data.
     */
    FamilyData familyData = FamilyData.getInstance();

    /**
     * GET request when there is no specified URL endpoint. This
     * method does not retrieve any resources or data.
     *
     * @return A string with the welcome message of the program
     */
    @GetMapping("/")
    public String intro()
    {
        return "Greetings from Anna's REST API family!";
    }

    /**
     * GET request when the specified URL endpoint is "family". This
     * method retrieves all the data from the FamilyData singleton instance
     * and then returns it to the user.
     *
     * @return the list of the family's data of the stored Person objects or
     * null if the family does not contain any data
     */
    @GetMapping("/family")
    public List<Person> index()
    {
        try
        {
            return familyData.getFamily();
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString(), e);
        }
    }

    /**
     * GET request when the specified URL endpoint is "family" and
     * an id has been specified within the URL. This method retrieves
     * data about a certain Person object within a family given their
     * id and then returns that Person object.
     *
     * @param id The id to search through the family to find
     * @return The Person object of the family member with that id,
     * or null if one does not exist
     */
    @GetMapping("/family/{id}")
    public Person show(@PathVariable String id)
    {
        int personId = Integer.parseInt(id);

        try
        {
            return familyData.getPersonById(personId);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString(), e);
        }
    }

    /**
     * POST request to search through the family data information
     * and return the Person objects that contain a given
     * first name from the request body. This request contains a
     * specified endpoint of "family/search/firstName" to help
     * specify when to call this method.
     *
     * @param body The request body that will contain the first name of the person object
     * @return the Person objects that contain a given first name from the request body
     */
    @PostMapping("/family/search/firstName")
    public List<Person> searchFirstName(@RequestBody Map<String, String> body)
    {
        String searchTerm = body.get("text");

        try
        {
            return familyData.searchFamilyFirstName(searchTerm);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString(), e);
        }
    }

    /**
     * POST request to search through the family data information
     * and return the Person objects that contain a given
     * city from the request body. This request contains a
     * specified endpoint of "family/search/city" to help
     * specify when to call this method.
     *
     * @param body The request body that will contain the city of the person object
     * @return the Person objects that contain a given city from the request body
     */
    @PostMapping("/family/search/city")
    public List<Person> searchCity(@RequestBody Map<String, String> body)
    {
        String searchTerm = body.get("text");

        try
        {
            return familyData.searchFamilyCity(searchTerm);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString(), e);
        }
    }

    /**
     * POST request to search through the family data information
     * and return the Person objects that contain a given
     * likes from the request body. This request contains a
     * specified endpoint of "family/search/likes" to help
     * specify when to call this method.
     *
     * @param body The request body that will contain the likes of the person object
     * @return the Person objects that contain a given likes from the request body
     */
    @PostMapping("/family/search/likes")
    public List<Person> searchLikes(@RequestBody Map<String, String> body)
    {
        String searchTerm = body.get("text");

        try
        {
            return familyData.searchFamilyLikes(searchTerm);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString(), e);
        }
    }

    /**
     * POST request to search through the family data information
     * and return the Person objects that contain a given
     * company from the request body. This request contains a
     * specified endpoint of "family/search/company" to help
     * specify when to call this method.
     *
     * @param body The request body that will contain the company of the person object
     * @return the Person objects that contain a given company from the request body
     */
    @PostMapping("/family/search/company")
    public List<Person> searchCompany(@RequestBody Map<String, String> body)
    {
        String searchTerm = body.get("text");

        try
        {
            return familyData.searchFamilyCompany(searchTerm);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString(), e);
        }
    }

    /**
     * POST request that helps to create a new Person object and
     * store it into the family of data. This request contains
     * a specified endpoint of "family". This method will then
     * return the newly creater Person object.
     *
     * @param body The request body that will contain all the information for a Person object
     * @return The newly created Person object
     */
    @PostMapping("/family/create")
    public Person createPerson(@RequestBody Map<String, String> body)
    {
        int id = Integer.parseInt(body.get("id"));
        String lastName = body.get("lastName");
        String firstName = body.get("firstName");
        String birthday = body.get("birthday");
        String email = body.get("email");
        String likes = body.get("likes");
        String city = body.get("city");
        int zipCode = Integer.parseInt(body.get("zipCode"));
        String company = body.get("company");

        try
        {
            return familyData.createPerson(id, lastName, firstName, birthday, email, likes, city, zipCode, company);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString(), e);
        }
    }

    /**
     * PUT request that helps to update one of the Person objects within
     * the family data. If a Person does not exist with the given id
     * in the family, the method will then return null. This request
     * contains a specified endpoint of "family" followed by the given
     * id number of the Person to search for to update.
     *
     * @param id The id of the Person to search for in the family
     * @param body The request body that will store the new information for the Person object
     * @return The newly updated Person, or null if the id did not exist in the family
     */
    @PutMapping("/family/update/{id}")
    public Person update(@PathVariable String id, @RequestBody Map<String, String> body)
    {
        int personId = Integer.parseInt(id);

        String lastName = body.get("lastName");
        String firstName = body.get("firstName");
        String birthday = body.get("birthday");
        String email = body.get("email");
        String likes = body.get("likes");
        String city = body.get("city");
        int zipCode = Integer.parseInt(body.get("zipCode"));
        String company = body.get("company");

        try
        {
            return familyData.updatePerson(personId, lastName, firstName, birthday, email, likes, city, zipCode, company);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString(), e);
        }
    }

    /**
     * DELETE request that helps to delete a specific Person from the
     * family data. The method will not attempt to delete if the given
     * id from the parameter does not exist within the family data. This
     * request contains a specified endpoint of "family" followed by the
     * id of the Person that will be removed from the family data.
     *
     * @param id The id of the Person to be removed from the family data
     * @return True if the Person was able to be removed from the family data, null
     * if the id of the Person did not exist within the family data
     */
    @DeleteMapping("family/delete/id/{id}")
    public boolean delete(@PathVariable String id)
    {
        int personId = Integer.parseInt(id);

        try
        {
            return familyData.deletePersonById(personId);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString(), e);
        }
    }
}
