package examinformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ExamService {


    private Map<String, ExamResult> results = new TreeMap<>();
    private int theoryMax;
    private int practiceMax;

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
            throw new IllegalArgumentException("Cannot read file: " + inputfile);
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

    public List<String> findPeopleFailed() {
        int passPractice = (int) Math.ceil(practiceMax * 0.51);
        int passTheory = (int) Math.ceil(theoryMax * 0.51);
        return results.entrySet().stream()
                .filter(e -> e.getValue().getPractice() < passPractice || e.getValue().getTheory() < passTheory)
                .map(e -> e.getKey()).toList();
    }

    public String findBestPerson() {
        int passPractice = (int) Math.ceil(practiceMax * 0.51);
        int passTheory = (int) Math.ceil(theoryMax * 0.51);
        return results.entrySet().stream()
                .filter(e -> !(e.getValue().getPractice() < passPractice || e.getValue().getTheory() < passTheory))
                .sorted((e1, e2) -> e2.getValue().getPoints() - e1.getValue().getPoints())
                .map(e -> e.getKey())
                .findFirst()
                .get();
    }
}
