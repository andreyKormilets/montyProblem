package domain;

import domain.scenarios.Scenario;

public class ScenarioRunner {
    public ResultStatistic runScenario(Scenario scenario, int iterationsCount) {
        int positiveResultsAmount = 0;
        int negativeResultsAmount = 0;
        for (int i = 0; i < iterationsCount; i++) {
            if (scenario.checkScenario()) {
                positiveResultsAmount++;
            } else {
                negativeResultsAmount++;
            }
        }
        return new ResultStatistic(positiveResultsAmount, negativeResultsAmount);
    }
}
