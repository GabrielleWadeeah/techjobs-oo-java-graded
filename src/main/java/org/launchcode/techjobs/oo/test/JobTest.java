package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job bestJob = new Job();
        Job worstJob = new Job();

        //id values are not the same
        assertNotEquals(bestJob.getId(), worstJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().toString(), "ACME");
        assertEquals(testJob.getLocation().toString(), "Desert");
        assertEquals(testJob.getPositionType().toString(), "Quality control");
        assertEquals(testJob.getCoreCompetency().toString(), "Persistence");

    }

    @Test
    public void testJobsForEquality(){
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // id values are not the same
        assertFalse(jobOne.equals(jobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals('\n', testJob2.toString().charAt(0));
        assertEquals('\n', testJob2.toString().charAt(testJob2.toString().length() -1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("\nID: " + testJob3.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", testJob3.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob4 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));


        assertEquals("\nID: " + testJob4.getId() + "\nName: Product tester\nEmployer: Data not available\nLocation: Desert\nPosition Type: Data not available\nCore Competency: Persistence\n", testJob4.toString());

    }
}
