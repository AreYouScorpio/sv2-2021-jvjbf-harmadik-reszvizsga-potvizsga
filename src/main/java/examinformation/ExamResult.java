package examinformation;

public class ExamResult {

    private int theory;
    private int practice;

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

    public int getPoints() {
        return theory + practice;
    }
}
