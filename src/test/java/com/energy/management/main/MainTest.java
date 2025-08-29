package com.energy.management.main;

import com.energy.management.context.BuildingEnergyContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("".getBytes());
    private final Scanner scanner = new Scanner(System.in);

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(System.in);
        outContent.reset();
    }

    private void simulateUserInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testChangeStateToEcoMode() {
        simulateUserInput("1\n2\n5\n"); 
        Main.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("Switching to Eco Mode: Only essential systems are ON."));
        assertTrue(output.contains("خروج از برنامه..."));
    }

    @Test
    public void testChangeCostStrategyToPeakHours() {
        simulateUserInput("2\n2\n5\n");
        Main.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("Cost policy changed to Peak Hours Tariff."));
        assertTrue(output.contains("خروج از برنامه..."));
    }

    @Test
    public void testViewCurrentStatus() {
        simulateUserInput("3\n5\n");
        Main.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("System is currently Active."));
        assertTrue(output.contains("خروج از برنامه..."));
    }

    @Test
    public void testSimulateCost() {
        simulateUserInput("4\n10\n5\n"); 
        Main.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("هزینه برای 10 واحد: 5000.0 تومان")); 
        assertTrue(output.contains("خروج از برنامه..."));
    }

    @Test
    public void testInvalidMenuOption() {
        simulateUserInput("6\n5\n");
        Main.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("گزینه نامعتبر!"));
        assertTrue(output.contains("خروج از برنامه..."));
    }

    @Test
    public void testInvalidInputHandling() {
        simulateUserInput("abc\n5\n");
        Main.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("ورودی نامعتبر! لطفاً یک عدد وارد کنید."));
        assertTrue(output.contains("خروج از برنامه..."));
    }

    @Test
    public void testInvalidStateSelection() {
        simulateUserInput("1\n4\n5\n");
        Main.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("گزینه نامعتبر!"));
        assertTrue(output.contains("خروج از برنامه..."));
    }

    @Test
    public void testInvalidUnitsInSimulation() {
        simulateUserInput("4\n-5\n5\n");
        Main.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("مقدار مصرف نمی‌تواند منفی باشد!"));
        assertTrue(output.contains("خروج از برنامه..."));
    }
}