import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    // Program ka counter invalid lines ko track karne ke liye
    private static int skippedLinesCount = 0;

    public static void main(String[] args) {
        String inputFile = "scores.txt";
        String outputFile = "report.txt";

        // Step 3: Read scores from file
        ArrayList<Integer> scoress = readScores(inputFile);

        

        // File edge case handling (Test 2 and Test 3 support)
        if (scoress.isEmpty()) {
            System.out.println("No valid numeric scores found to analyze.");
            return;
        }

        // Step 4: Calculate Average
        double avg = calculateAverage(scoress);

        // Step 5: Find Highest and Lowest Scores manually
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scoress) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }

        // Step 6: Count the Grade Bands
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int score : scoress) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        // Step 7: Write and Print Report
        writeReport(scoress, avg, highest, lowest, countA, countB, countC, countD, countF, outputFile);
    }

    // Step 3: Implement readScores using BufferedReader
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        skippedLinesCount = 0; // Reset counter for re-runs

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Skip blank lines
                if (line.isEmpty()) {
                    continue;
                }

                // Integer.parseInt inside try-catch
                try {
                    int score = Integer.parseInt(line);
                    scores.add(score);
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Invalid line skipped -> \"" + line + "\"");
                    skippedLinesCount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file " + filename + " was not found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return scores;
    }

    // Step 4: Implement calculateAverage
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    }

    // Step 7: Implement writeReport using BufferedWriter
    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low,
                                   int countA, int countB, int countC, int countD, int countF,
                                   String outputFile) {

        // Report String Formatting
        String report = String.format(
            "=== Grade Analysis Report ===%n" +
            "Total scores processed: %d%n" +
            "Invalid lines skipped:   %d%n%n" +
            "Average score:          %.2f%n" +
            "Highest score:          %d%n" +
            "Lowest score:           %d%n%n" +
            "Grade distribution:%n" +
            "  A (90-100):  %d%n" +
            "  B (80-89):   %d%n" +
            "  C (70-79):   %d%n" +
            "  D (60-69):   %d%n" +
            "  F (below 60):%d%n",
            scores.size(), skippedLinesCount, avg, high, low,
            countA, countB, countC, countD, countF
        );

        // Terminal par print karein
        System.out.print(report);

        // BufferedWriter ka istemal karke file mein save karein
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(report);
            System.out.println("\nReport successfully saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to report file: " + e.getMessage());
        }
    }
}