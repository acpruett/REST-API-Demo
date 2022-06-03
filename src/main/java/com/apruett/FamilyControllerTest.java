package com.apruett;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyControllerTest
{
    @Test
    public void testIntro()
    {
        FamilyController fc = new FamilyController();

        assertEquals("Greetings from Anna's REST API family!", fc.intro());
    }

    @Test
    public void testIndex()
    {
        FamilyController fc = new FamilyController();

        assertEquals("Anna", fc.index().get(0).getFirstName());
    }
}