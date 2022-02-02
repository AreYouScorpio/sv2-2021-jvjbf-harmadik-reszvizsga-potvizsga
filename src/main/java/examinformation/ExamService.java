package examinformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ExamService {


    private Map<String, ExamResult> results = new TreeMap<>();
    int theoryMax;
    int practiceMax;

    public int getTheoryMax() {
        return theoryMax;
    }

    public int getPracticeMax() {
        return practiceMax;
    }

    public void readFromFIle(Path inputfile) {
        boolean header = true;
        try (
                BufferedReader br = Files.newBufferedReader(inputfile)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (header)
                    parseHeader(line);
                else
                    parseLine(line);
                header = false;
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.");
        }
    }

    private void parseHeader(String line) {
        String[] tempMaxPoints = line.split(" ");
        theoryMax = Integer.parseInt(tempMaxPoints[0]);
        practiceMax = Integer.parseInt(tempMaxPoints[1]);
    }

    private void parseLine(String line) {
        String[] temp = line.split(";");
        String name = temp[0];
        temp = temp[1].split(" ");
        int theory = Integer.parseInt(temp[0]);
        int practice = Integer.parseInt(temp[1]);

        if (!results.containsKey(name)) {
            results.put(name, new ExamResult(theory, practice));
        }
    }

    public Map<String, ExamResult> getResults() {
        return results;
    }


}
