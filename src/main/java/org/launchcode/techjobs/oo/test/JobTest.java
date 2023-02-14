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
        Job job = new Job();
        Job jobTwo = new Job();
        assertNotEquals(job.getId(), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job test = new Job("Product tester", new Employer ("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test instanceof Job);
        assertTrue(test.getEmployer() instanceof Employer);
        assertTrue(test.getLocation() instanceof Location);
        assertTrue(test.getPositionType() instanceof PositionType);
        assertTrue(test.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", test.getName());
        assertEquals("ACME", test.getEmployer().getValue());
        assertEquals("Desert", test.getLocation().getValue());
        assertEquals("Quality control", test.getPositionType().getValue());
        assertEquals("Persistence", test.getCoreCompetency().getValue());

    }
    @Test
    public void testJobsForEquality(){
        Job jobEquality = new Job("Product tester", new Employer ("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobEquality2 = new Job("Product tester", new Employer ("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    assertFalse(jobEquality2.equals(jobEquality));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobLine = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = jobLine.toString();
        assertEquals('\n', jobString.charAt(0));
        assertEquals('\n', jobString.charAt(jobString.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobLabel = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String correctString =
                "\n" +
                        "ID: " + jobLabel.getId() + "\n" +
                        "Name: " + jobLabel.getName()  + "\n" +
                        "Employer: " + jobLabel.getEmployer()  + "\n" +
                        "Location: " + jobLabel.getLocation() + "\n" +
                        "Position Type: " + jobLabel.getPositionType()  + "\n" +
                        "Core Competency: " + jobLabel.getCoreCompetency()  + "\n";
        assertEquals(jobLabel.toString(), correctString);

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job jobEmpty = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(jobEmpty.toString(), "OOPS! This job does not seem to exist.");

        Job thatJob = new Job("", new Employer("ACME"), new Location(""), new PositionType(""), new CoreCompetency(""));
        String expectedString =
                "\n" +
                        "ID: " + thatJob.getId() + "\n" +
                        "Name: " + "Data not available"  + "\n" +
                        "Employer: " + thatJob.getEmployer()  + "\n" +
                        "Location: " + "Data not available" + "\n" +
                        "Position Type: " + "Data not available"  + "\n" +
                        "Core Competency: " + "Data not available"  + "\n";
        assertEquals(thatJob.toString(), expectedString);

        Job theOtherJob = new Job("Product tester", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String predictedString =
                "\n" +
                        "ID: " + theOtherJob.getId() + "\n" +
                        "Name: " + theOtherJob.getName()  + "\n" +
                        "Employer: " + "Data not available"  + "\n" +
                        "Location: " + "Data not available" + "\n" +
                        "Position Type: " + "Data not available"  + "\n" +
                        "Core Competency: " + "Data not available"  + "\n";
        assertEquals(theOtherJob.toString(), predictedString);
    }
}
