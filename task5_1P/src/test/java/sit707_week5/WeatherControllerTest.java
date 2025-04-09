package sit707_week5;

import org.junit.*;
import java.util.*;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static List<Double> hourlyTemperatures;

    @BeforeClass
    public static void setUpBeforeClass() {
        // Arrange: Initialize controller and cache all hourly temps once
        wController = WeatherController.getInstance();
        hourlyTemperatures = new ArrayList<>();

        int nHours = wController.getTotalHours();
        for (int i = 0; i < nHours; i++) {
            hourlyTemperatures.add(wController.getTemperatureForHour(i + 1));
        }
    }

    @AfterClass
    public static void tearDownAfterClass() {
        // After: Cleanup
        if (wController != null) {
            wController.close();
        }
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "s224078886";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Fuk Sang Wong";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        // Act
        double expectedMin = Collections.min(hourlyTemperatures);

        // Assert
        Assert.assertEquals(expectedMin, wController.getTemperatureMinFromCache(), 0.01);
    }

    @Test
    public void testTemperatureMax() {
        // Act
        double expectedMax = Collections.max(hourlyTemperatures);

        // Assert
        Assert.assertEquals(expectedMax, wController.getTemperatureMaxFromCache(), 0.01);
    }

    @Test
    public void testTemperatureAverage() {
        // Act
        double sum = 0;
        for (double temp : hourlyTemperatures) {
            sum += temp;
        }
        double expectedAverage = sum / hourlyTemperatures.size();

        // Assert
        Assert.assertEquals(expectedAverage, wController.getTemperatureAverageFromCache(), 0.01);
    }
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
