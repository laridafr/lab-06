package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
// This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
// is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
// This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
// Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        City calgary = new City("Calgary", "Alberta");

        assertFalse(cityList.hasCity(calgary));
        cityList.add(calgary);
        assertTrue(cityList.hasCity(calgary));
    }

    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        City calgary = new City("Calgary", "Alberta");
        cityList.add(calgary);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.hasCity(calgary));
        cityList.delete(calgary);
        assertFalse(cityList.hasCity(calgary));
        assertEquals(1, cityList.getCities().size());
    }

    @Test
    public void testDeleteException() {
        CityList cityList = mockCityList();
        City calgary = new City("Calgary", "Alberta");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(calgary);
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();
        City calgary = new City("Calgary", "Alberta");

        assertEquals(1, cityList.countCities());
        cityList.add(calgary);
        assertEquals(2, cityList.countCities());
    }
}
