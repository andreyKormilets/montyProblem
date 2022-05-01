package domain.scenarios.montyHall;

import domain.scenarios.Scenario;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MontyHallProblemScenarioNotChangedChoice implements Scenario {

    @Override
    public boolean checkScenario() {
        int boxesAmount = 3;
        List<Box> boxes = new LinkedList<>();
        initBoxes(boxes, boxesAmount);
        int firstChoice = makeFirstChoice(boxes);
        openEmpty(boxes);
        return boxes.get(firstChoice).isContainMoney();
    }

    private void initBoxes(List<Box> boxes, int boxesAmount) {
        int NumberOfABoxWithMoney = new Random().nextInt(boxesAmount);
        for (int i = 0; i < boxesAmount; i++) {
            boxes.add(new Box(i == NumberOfABoxWithMoney));
        }
    }

    private int makeFirstChoice(List<Box> boxes) {
        int firstChoice = new Random().nextInt(3);
        boxes.get(firstChoice).chooseIt();
        return firstChoice;
    }

    private void openEmpty(List<Box> boxes) {
        List<Box> boxesForOpen = boxes.stream()
                .filter(box -> !box.isContainMoney())
                .filter(box -> !box.isChosen())
                .toList();
        int forOpen = new Random().nextInt(boxesForOpen.size());
        boxesForOpen.get(forOpen).open();
    }
}
