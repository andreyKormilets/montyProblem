import domain.ResultStatistic;
import domain.ScenarioRunner;
import domain.scenarios.montyHall.MontyHallProblemScenarioChangedChoice;
import domain.scenarios.montyHall.MontyHallProblemScenarioNotChangedChoice;

public class ApplicationRunner {

    public static void main(String[] args) {
        int iterationsAmount = 10000000;
        if (args.length > 0 && args[0] != null) {
            try {
                iterationsAmount = Integer.parseInt(args[0]);
            } catch (NumberFormatException nfe) {
                System.out.println("wrong argument : " + args[0]);
            }
        }
        System.out.println("iterations amount : " + iterationsAmount);
        ScenarioRunner runner = new ScenarioRunner();
        ResultStatistic changedChoiceStatistic = runner.runScenario(new MontyHallProblemScenarioChangedChoice(), iterationsAmount);
        ResultStatistic notChangedChoiceStatistic = runner.runScenario(new MontyHallProblemScenarioNotChangedChoice(), iterationsAmount);
        System.out.println("Probability of success for monty hall problem with Changed choice : " + changedChoiceStatistic.getProbabilityOfSuccess());
        System.out.println("Probability of success for monty hall problem with not Changed choice : " + notChangedChoiceStatistic.getProbabilityOfSuccess());
    }
}
