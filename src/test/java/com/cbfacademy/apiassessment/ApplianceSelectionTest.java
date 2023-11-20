package com.cbfacademy.apiassessment;

import com.cbfacademy.apiassessment.model.Recommendation;
import com.cbfacademy.apiassessment.service.ApplianceSelection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
;

@DisplayName("The ApplianceSection class Test")
public class ApplianceSelectionTest {

    @ParameterizedTest
    @MethodSource("heatPumpInputAndOutput")
    @DisplayName("return valid heat pump recommendation for valid input")
    public void returnValidHeatPumpRecommendation(Integer numberOfRooms, Integer numberOfRadiators, int expectedPrice) {
        ApplianceSelection applianceSelection = new ApplianceSelection();
        Recommendation recommendation = applianceSelection.createHeatPumpRecommendation(numberOfRooms, numberOfRadiators);
        assertThat(recommendation.getPrice(), is(expectedPrice));
    }

    static Stream<Arguments> heatPumpInputAndOutput() {
        // This assumes that the number radiators for heat pumps is 0
        return Stream.of(
                arguments(2, 1700), // This assumes that the number radiators for heat pumps is 0
                arguments(3, 2400),
                arguments(4, 3100)
        );
    }


    @ParameterizedTest
    @MethodSource("boilerInputAndOutput")
    @DisplayName("return boiler recommendation for valid input")
    public void returnValidBoilerRecommendation(Integer numberOfRooms, Integer numberOfRadiators, int expectedPrice) {
        ApplianceSelection applianceSelection = new ApplianceSelection();
        Recommendation recommendation = applianceSelection.createBoilerRecommendation(numberOfRooms, numberOfRadiators);
        assertThat(recommendation.getPrice(), is(expectedPrice));
    }

    static Stream<Arguments> boilerInputAndOutput() {
        return Stream.of(
                arguments(2, 10, 750),
                arguments(3, 11, 1150),
                arguments(4, 21, 1550)
        );
    }


    @ParameterizedTest
    @MethodSource("mchpInputAndOutput")
    @DisplayName("return MCHP recommendation for valid input")
    public void returnValidMchpRecommendation(Integer numberOfRooms,Integer numberOfRadiators ,int expectedPrice) {
        ApplianceSelection applianceSelection = new ApplianceSelection();
        Recommendation recommendation = applianceSelection.createMchpRecommendation(numberOfRooms, numberOfRadiators);
        assertThat(recommendation.getPrice(), is(expectedPrice));
    }

    static Stream<Arguments> mchpInputAndOutput() {
        return Stream.of(
                arguments(2, 900),
                arguments(3, 1300),
                arguments(4, 1700)

        );
    }
}

