package examinformation;

public class ExamResult {

    int theory;
    int practice;

    public int getTheory() {
        return theory;
    }

    public int getPractice() {
        return practice;
    }

    public ExamResult(int theory, int practice) {
        this.theory = theory;
        this.practice = practice;
    }
}
