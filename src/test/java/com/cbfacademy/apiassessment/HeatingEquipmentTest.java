package com.cbfacademy.apiassessment;

import org.junit.Test;
import static org.junit.Assert.*;

public class ApplianceSelectionTest {

    @Test
    public void testCreateHeatPumpRecommendation_ValidInput() {
        ApplianceSelection applianceSelection = new ApplianceSelection();
        Recommendation recommendation = applianceSelection.createHeatPumpRecommendation(2);

        assertNotNull(recommendation);
        assertEquals("Heat Pump", recommendation.getType());
        assertEquals(1700, recommendation.getPrice());
    }

    @Test(expected = RuntimeException.class)
    public void testCreateHeatPumpRecommendation_InvalidInput() {
        ApplianceSelection applianceSelection = new ApplianceSelection();
        applianceSelection.createHeatPumpRecommendation(null);
    }

    @Test
    public void testCreateBoilerRecommendation_ValidInput() {
        ApplianceSelection applianceSelection = new ApplianceSelection();
        Recommendation recommendation = applianceSelection.createBoilerRecommendation(2, 10);

        assertNotNull(recommendation);
        assertEquals("Boiler", recommendation.getType());
        assertEquals(750, recommendation.getPrice());
    }

    @Test(expected = RuntimeException.class)
    public void testCreateBoilerRecommendation_InvalidInput() {
        ApplianceSelection applianceSelection = new ApplianceSelection();
        applianceSelection.createBoilerRecommendation(null, null);
    }

}

