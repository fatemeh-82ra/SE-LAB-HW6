//package com.energy.management.main;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
//import java.io.PrintStream;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class MainTest {
//    private final InputStream originalIn = System.in;
//    private final PrintStream originalOut = System.out;
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//
//    @BeforeEach
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @AfterEach
//    public void restoreStreams() {
//        System.setOut(originalOut);
//        System.setIn(originalIn);
//    }
//
//    @Test
//    void testMainApplicationFlow() {
//        // Simulate a user session: 1. View, 2. Change State, 3. Change Policy, 4. Simulate, 0. Exit
//        String simulatedInput = "1\n2\nEco Mode\n3\nPeak Hours\n4\n10\n0\n";
//        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
//
//        // Run the main method
//        Main.main(null);
//
//        String output = outContent.toString();
//
//        // Assert that key messages were printed to the console
//        assertTrue(output.contains("System is currently Active."));
//        assertTrue(output.contains("Switching to Eco Mode: Only essential systems are ON."));
//        assertTrue(output.contains("Cost policy changed to Peak Hours Tariff."));
//        assertTrue(output.contains("Simulated Cost: 10000.0 Toman"));
//        assertTrue(output.contains("Exiting system."));
//    }
//}