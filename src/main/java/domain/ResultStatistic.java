package domain;

public class ResultStatistic {
    private final int positiveResultsAmount;
    private final int negativeResultsAmount;

    ResultStatistic(int positiveResultsAmount, int negativeResultsAmount) {
        this.positiveResultsAmount = positiveResultsAmount;
        this.negativeResultsAmount = negativeResultsAmount;
    }

    public int getPositiveResultsAmount() {
        return positiveResultsAmount;
    }

    public int getNegativeResultsAmount() {
        return negativeResultsAmount;
    }

    public double getProbabilityOfSuccess() {
        return (double) positiveResultsAmount / (double) (positiveResultsAmount + negativeResultsAmount);
    }
}
