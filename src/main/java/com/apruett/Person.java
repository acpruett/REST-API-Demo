package com.apruett;

/**
 * A POJO class that represents a Person object, which contains a person's
 * id, last name, first name, birthday, email, likes, city, zipcode,
 * and company. This class handles the error checking for all of these
 * fields and contains a constructor with all fields.
 *
 * @author Anna Pruett
 */
public class Person
{
    /** Helps to store the id of the person */
    private int id;

    /** Helps to store the last name of the person */
    private String lastName;

    /** Helps to store the first name of the person */
    private String firstName;

    /** Helps to store the birthday of the person */
    private String birthday;

    /** Helps to store the email of the person */
    private String email;

    /** Helps to store the likes of the person */
    private String likes;

    /** Helps to store the city of the person */
    private String city;

    /** Helps to store the zipCode of the person */
    private int zipCode;

    /** Helps to store the company of the person */
    private String company;

    /**
     * Constructor to help create a person object with all of the
     * information needed for a person, such as their id,
     * first name, last name, birthday, email, likes, city, zip code,
     * and company
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
     */
    public Person(int id, String lastName, String firstName, String birthday, String email, String likes, String city, int zipCode, String company)
    {
        if(id <= 0)
        {
            throw new IllegalArgumentException("Id must be greater than zero.");
        }

        if(lastName == null || lastName.equals(""))
        {
            throw new IllegalArgumentException("Last name field must not be blank.");
        }

        if(firstName == null || firstName.equals(""))
        {
            throw new IllegalArgumentException("First name field must not be blank.");
        }

        if(birthday == null || birthday.equals(""))
        {
            throw new IllegalArgumentException("Birthday field must not be blank.");
        }

        if(email == null || email.equals(""))
        {
            throw new IllegalArgumentException("Email field must not be blank.");
        }

        if(likes == null || likes.equals(""))
        {
            throw new IllegalArgumentException("Likes field must not be blank.");
        }

        if(city == null || city.equals(""))
        {
            throw new IllegalArgumentException("City field must not be blank.");
        }

        if(company == null || company.equals(""))
        {
            throw new IllegalArgumentException("Company field must not be blank.");
        }

        if(zipCode <= 0)
        {
            throw new IllegalArgumentException("Must be a valid zipcode.");
        }

        if(!lastName.equalsIgnoreCase("pruett"))
        {
            throw new IllegalArgumentException("Last name must be a Pruett surname.");
        }

        if(!isLetter(firstName))
        {
            throw new IllegalArgumentException("First name must only contain uppercase or lowercase letters.");
        }

        if(birthday.charAt(2) != '/' || birthday.charAt(5) != '/' || !isDigit(birthday.substring(0, 2)) || !isDigit(birthday.substring(3, 5)) || !isDigit(birthday.substring(6, 10)))
        {
            throw new IllegalArgumentException("Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }

        int counterForEmailAtSign = 0;
        for(int i = 0; i < email.length(); i++)
        {
            if("@".equals(email.substring(i, i + 1)))
            {
                counterForEmailAtSign++;
            }
        }

        if(counterForEmailAtSign != 1)
        {
            throw new IllegalArgumentException("Email must contain an '@' and a '.'");
        }

        int atSignIndex = 0;
        int periodIndex = 0;
        for(int i = 0; i < email.length(); i++)
        {
            if("@".equals(email.substring(i, i + 1)))
            {
                atSignIndex = i;
            }
            if(".".equals(email.substring(i, i + 1)))
            {
                periodIndex = i;
            }
        }

        if(periodIndex < atSignIndex)
        {
            throw new IllegalArgumentException("Email must contain an '@' and a '.'");
        }

        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.email = email;
        this.likes = likes;
        this.city = city;
        this.zipCode = zipCode;
        this.company = company;
    }

    /**
     * Getter method for the field of a person's last name
     *
     * @return The last name of the person
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Helps to set the last name of the person. Contains error checking
     * for the field of the last name parameter
     *
     * @param lastName The last name to set for the person
     */
    public void setLastName(String lastName)
    {
        if(lastName == null || lastName.equals(""))
        {
            throw new IllegalArgumentException("Last name field must not be blank.");
        }

        if(!isLetter(lastName))
        {
            throw new IllegalArgumentException("Last name must only contain uppercase or lowercase letters.");
        }

        if(!lastName.equalsIgnoreCase("pruett"))
        {
            throw new IllegalArgumentException("Last name must be a Pruett surname.");
        }

        this.lastName = lastName;
    }

    /**
     * Helps to determine if a certain string contains only
     * digits of 0 through 9
     *
     * @param value The string to check the value of
     * @return true if the string only contains digits of 0 through 9
     */
    public boolean isDigit(String value) {
        return value.matches("[0-9]+");
    }

    /**
     * Helps to determine if a certain string contains only
     * uppercase or lowercase letters
     *
     * @param value The string to check the value of
     * @return true if the string only contains uppercase or lowercase letters
     */
    public boolean isLetter(String value) {
        return value.matches("[a-zA-Z]+");
    }

    /**
     * Getter method for the field of a person's first name
     *
     * @return The first name of the person
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Helps to set the first name of the person. Contains error checking
     * for the field of the first name parameter
     *
     * @param firstName The first name to set for the person
     */
    public void setFirstName(String firstName)
    {
        if(firstName == null || firstName.equals(""))
        {
            throw new IllegalArgumentException("First name field must not be blank.");
        }

        if(!isLetter(firstName))
        {
            throw new IllegalArgumentException("First name must only contain uppercase or lowercase letters.");
        }

        this.firstName = firstName;
    }

    /**
     * Getter method for the field of a person's birthday
     *
     * @return The birthday of the person
     */
    public String getBirthday()
    {
        return birthday;
    }

    /**
     * Helps to set the birthday of the person. Contains error checking
     * for the field of the birthday parameter
     *
     * @param birthday The birthday to set for the person
     */
    public void setBirthday(String birthday)
    {
        if(birthday == null || birthday.equals(""))
        {
            throw new IllegalArgumentException("Birthday field must not be blank.");
        }

        if(birthday.length() != 10)
        {
            throw new IllegalArgumentException("Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }

        if(birthday.charAt(2) != '/' || birthday.charAt(5) != '/' || !isDigit(birthday.substring(0, 2)) || !isDigit(birthday.substring(3, 5)) || !isDigit(birthday.substring(6, 10)))
        {
            throw new IllegalArgumentException("Birthday must be in the form of month/day/year. Example: 04/29/2002");
        }

        this.birthday = birthday;
    }

    /**
     * Getter method for the field of a person's email
     *
     * @return The email of the person
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Helps to set the email of the person. Contains error checking
     * for the field of the email parameter
     *
     * @param email The email to set for the person
     */
    public void setEmail(String email)
    {
        if(email == null || email.equals(""))
        {
            throw new IllegalArgumentException("Email field must not be blank.");
        }

        int counterForEmailAtSign = 0;
        for(int i = 0; i < email.length(); i++)
        {
            if("@".equals(email.substring(i, i + 1)))
            {
                counterForEmailAtSign++;
            }
        }

        if(counterForEmailAtSign != 1)
        {
            throw new IllegalArgumentException("Email must contain an '@' and a '.'");
        }

        int atSignIndex = 0;
        int periodIndex = 0;
        for(int i = 0; i < email.length(); i++)
        {
            if("@".equals(email.substring(i, i + 1)))
            {
                atSignIndex = i;
            }
            if(".".equals(email.substring(i, i + 1)))
            {
                periodIndex = i;
            }
        }

        if(periodIndex < atSignIndex)
        {
            throw new IllegalArgumentException("Email must contain an '@' and a '.'");
        }

        this.email = email;
    }

    /**
     * Getter method for the field of a person's city
     *
     * @return The city of the person
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Helps to set the city of the person. Contains error checking
     * for the field of the city parameter
     *
     * @param city The city to set for the person
     */
    public void setCity(String city)
    {
        if(city == null || city.equals(""))
        {
            throw new IllegalArgumentException("City field must not be blank.");
        }

        this.city = city;
    }

    /**
     * Getter method for the field of a person's zip code
     *
     * @return The zip code of the person
     */
    public int getZipCode()
    {
        return zipCode;
    }

    /**
     * Helps to set the zip code of the person. Contains error checking
     * for the field code of the zip code parameter
     *
     * @param zipCode The zip code to set for the person
     */
    public void setZipCode(int zipCode)
    {
        if(zipCode <= 0)
        {
            throw new IllegalArgumentException("Must be a valid zipcode.");
        }

        this.zipCode = zipCode;
    }

    /**
     * Getter method for the field of a person's company
     *
     * @return The company of the person
     */
    public String getCompany()
    {
        return company;
    }

    /**
     * Helps to set the company of the person. Contains error checking
     * for the field of the company parameter
     *
     * @param company The company to set for the person
     */
    public void setCompany(String company)
    {
        if(company == null || company.equals(""))
        {
            throw new IllegalArgumentException("Company field must not be blank.");
        }

        this.company = company;
    }

    /**
     * Getter method for the field of a person's id
     *
     * @return The id of the person
     */
    public int getId()
    {
        return id;
    }

    /**
     * Helps to set the id of the person. Contains error checking
     * for the field of the id parameter
     *
     * @param id The id to set for the person
     */
    public void setId(int id)
    {
        if(id <= 0)
        {
            throw new IllegalArgumentException("Id must be greater than zero.");
        }

        this.id = id;
    }

    /**
     * Getter method for the field of a person's likes
     *
     * @return The likes of the person
     */
    public String getLikes()
    {
        return likes;
    }

    /**
     * Helps to set the likes of the person. Contains error checking
     * for the field of the likes parameter
     *
     * @param likes The likes to set for the person
     */
    public void setLikes(String likes)
    {
        if(likes == null || likes.equals(""))
        {
            throw new IllegalArgumentException("Likes field must not be blank.");
        }

        this.likes = likes;
    }

    /**
     * Generated toString for the Person POJO
     *
     * @return the generated toString for the Person POJO
     */
    @Override
    public String toString()
    {
        return "Person{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", likes='" + likes + '\'' +
                ", address='" + city + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
