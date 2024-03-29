import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilterFile {
    public static void main(String[] args) {
        String inputFile = "ssp.txt"; // Change this to your input file path
        String outputFile = "outputFinal.html"; // Change this to your output HTML file path
        String baseURL = "https://www.instagram.com/"; // Base URL to prepend

        try {
            // Open input file for reading
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            // Open output file for writing
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            // Write HTML header
            writer.write("<html><head><title>Clickable URLs</title></head><body>");

            String line;
            while ((line = reader.readLine()) != null) {
                // Trim the line and check if it's not empty
                line = line.trim();
                if (!line.isEmpty()) {
                    // Check if the line starts with a numeric character
                    if (!Character.isDigit(line.charAt(0))) {
                        // Create clickable hyperlink
                        writer.write("<a href=\"" + baseURL + line + "/\">" + line + "</a><br>");
                    }
                }
            }

            // Write HTML footer
            writer.write("</body></html>");

            // Close resources
            reader.close();
            writer.close();

            System.out.println("Lines modified and clickable URLs added successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
