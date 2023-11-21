package com.cbfacademy.apiassessment;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import com.cbfacademy.apiassessment.model.Appliance;
import com.cbfacademy.apiassessment.model.HeatPump;
import com.cbfacademy.apiassessment.repository.ApplianceRepository;
import com.cbfacademy.apiassessment.service.ApplianceSelection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class ApplianceSelectionTest {

    @Mock
    private ApplianceRepository repository;

    @InjectMocks
    private ApplianceSelection applianceSelection;

    @BeforeEach
    void setUp() throws IOException {
        // Mock data setup
        List<Appliance> appliances = Arrays.asList(
                new Appliance("Heat pump 1000", "This is the heat pump 1000", "HeatPump",2),
                new Appliance("Heat pump 1000", "This is the heat pump 1000", "HeatPump",13),
                new Appliance("Razar Boiler 15", "This is the Boiler made by Razar", "Boiler",15),
                new Appliance("Razar Boiler 10", "This is the Boiler made by Razar", "Boiler",10),
                new Appliance("Jameson MCHP 2.5", "This is the micro-CHP made by Jameson", "MCHP",8),
                new Appliance("Jameson MCHP 3.5", "This is the micro-CHP made by Jameson", "MCHP",15)
                );

        when(repository.readAll()).thenReturn(appliances);
    }

    @ParameterizedTest
    @MethodSource("heatPumpInputAndOutput")
    @DisplayName("return valid heat pump recommendation for valid input")
    public void returnValidHeatPumpRecommendation(Integer numberOfRooms, Integer numberOfRadiators, String expectedType) throws IOException {
        Appliance recommendation = applianceSelection.createHeatPumpRecommendation(numberOfRooms, numberOfRadiators);
        assertNotNull(recommendation);
        assertThat(recommendation.getType(), is(expectedType));
    }

    static Stream<Arguments> heatPumpInputAndOutput() {
        return Stream.of(
                Arguments.arguments(2, 0, "HeatPump"),
                Arguments.arguments(3, 0, "HeatPump"),
                Arguments.arguments(4, 0, "HeatPump")
        );
    }

    @ParameterizedTest
    @MethodSource("boilerInputAndOutput")
    @DisplayName("return boiler recommendation for valid input")
    public void returnValidBoilerRecommendation(Integer numberOfRooms, Integer numberOfRadiators, String expectedType) throws IOException {
        Appliance recommendation = applianceSelection.createBoilerRecommendation(numberOfRooms, numberOfRadiators);
        assertNotNull(recommendation);
        assertThat(recommendation.getType(), is(expectedType));
    }

    static Stream<Arguments> boilerInputAndOutput() {
        return Stream.of(
                Arguments.arguments(2, 10, "Boiler"),
                Arguments.arguments(3, 15, "Boiler"),
                Arguments.arguments(4, 20, "Boiler")
        );
    }

    @ParameterizedTest
    @MethodSource("mchpInputAndOutput")
    @DisplayName("return MCHP recommendation for valid input")
    public void returnValidMchpRecommendation(Integer numberOfRooms, Integer numberOfRadiators, String expectedType) throws IOException {
        Appliance recommendation = applianceSelection.createMchpRecommendation(numberOfRooms, numberOfRadiators);
        assertNotNull(recommendation);
        assertThat(recommendation.getType(), is(expectedType));
    }

    static Stream<Arguments> mchpInputAndOutput() {
        return Stream.of(
                Arguments.arguments(2, 0, "MCHP"),
                Arguments.arguments(3, 0, "MCHP"),
                Arguments.arguments(4, 0, "MCHP")
        );
    }
}
