package de.exxcellent.challenge;

import de.exxcellent.challenge.DataAnalysis.DataAnalyzer;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        String mainResources = "src/main/resources/de/exxcellent/challenge/";
        String weatherCSVpath = mainResources + "weather.csv";
        String footballCSVpath = mainResources + "football.csv";
        DataAnalyzer weatherDataAnalyzer = new DataAnalyzer(weatherCSVpath);
        DataAnalyzer footballDataAnalyzer = new DataAnalyzer(footballCSVpath);

        String dayWithSmallestTempSpread = weatherDataAnalyzer
                .getTargetWithSmallestSpread("Day", "MxT", "MnT");     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);


        String teamWithSmallestGoalSpread = footballDataAnalyzer
                .getTargetWithSmallestSpread("Team", "Goals", "Goals Allowed"); // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
