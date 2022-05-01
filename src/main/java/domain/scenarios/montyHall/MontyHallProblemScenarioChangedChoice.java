package domain.scenarios.montyHall;

import domain.scenarios.Scenario;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MontyHallProblemScenarioChangedChoice implements Scenario {

    @Override
    public boolean checkScenario() {
        int boxesAmount = 3;
        List<Box> boxes = new LinkedList<>();
        initBoxes(boxes, boxesAmount);
        makeFirstChoice(boxes);
        openEmpty(boxes);
        return makeSecondChoice(boxes);
    }

    private void initBoxes(List<Box> boxes, int boxesAmount) {
        int NumberOfABoxWithMoney = new Random().nextInt(boxesAmount);
        for (int i = 0; i < boxesAmount; i++) {
            boxes.add(new Box(i == NumberOfABoxWithMoney));
        }
    }

    private void makeFirstChoice(List<Box> boxes) {
        int firstChoice = new Random().nextInt(3);
        boxes.get(firstChoice).chooseIt();
    }

    private void openEmpty(List<Box> boxes) {
        List<Box> boxesForOpen = boxes.stream()
                .filter(box -> !box.isContainMoney())
                .filter(box -> !box.isChosen())
                .toList();
        int forOpen = new Random().nextInt(boxesForOpen.size());
        boxesForOpen.get(forOpen).open();
    }

    private boolean makeSecondChoice(List<Box> boxes) {
        List<Box> boxesForNewChoice = boxes.stream()
                .filter(box -> !box.isChosen())
                .filter(box -> !box.isOpen())
                .toList();
        int forNewChoice = new Random().nextInt(boxesForNewChoice.size());
        return boxesForNewChoice.get(forNewChoice).isContainMoney();
    }
}
