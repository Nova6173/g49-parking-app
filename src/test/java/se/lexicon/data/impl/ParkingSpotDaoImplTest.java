package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.ParkingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingSpotDaoImplTest {
    private ParkingSpotDaoImpl testObject;
    @BeforeEach
    public void setUp() {
        testObject = new ParkingSpotDaoImpl();

    }

    @Test

    public void testCreateParkingSpot() {
        ParkingSpot parkingSpot = new ParkingSpot (1, 7777);
        ParkingSpot actualValue = testObject.create(parkingSpot);
        ParkingSpot expectedValue = parkingSpot;
        assertEquals(expectedValue, actualValue);

    }
   @Test
    public void testFindParkingSpotBySpotNumber() {
        ParkingSpot parkingSpot = new ParkingSpot (1, 7777);
        testObject.create(parkingSpot);
        Optional<ParkingSpot> actualValue = testObject.find(1);
        Optional<ParkingSpot> expectedValue = Optional.of(parkingSpot);
        assertEquals(expectedValue, actualValue);

    }
    @Test
    public void testFindNonExistentParkingSpot() {
        Optional<ParkingSpot> actualValue = testObject.find(1);
        Optional<ParkingSpot> expectedValue = Optional.empty();
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void testRemoveParkingSpot() {
        ParkingSpot parkingSpot = new ParkingSpot (1, 7777);
        testObject.create(parkingSpot);
        boolean actualValue = testObject.remove(1);
        boolean expectedValue = true;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testRemoveNonExistentParkingSpot() {
        boolean actualValue = testObject.remove(1);
        boolean expectedValue = false;
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void testFindAllParkingSpot() {
        ParkingSpot spotNumber = new ParkingSpot (1, 7777);
        ParkingSpot parkingSpot = new ParkingSpot (2, 7777);

        testObject.create(spotNumber);
        testObject.create(parkingSpot);

        List<ParkingSpot> actualValue = testObject.findAll();
        List<ParkingSpot> expectedValue = new ArrayList<>();
        expectedValue.add(spotNumber);
        expectedValue.add(parkingSpot);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testFindAllParkingSpotEmptyList() {
        List<ParkingSpot> actualValue = testObject.findAll();
        List<ParkingSpot> expectedValue = new ArrayList<>();
        assertEquals(expectedValue, actualValue);
    }

}
