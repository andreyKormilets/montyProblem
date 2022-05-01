package domain.scenarios.montyHall;

public class Box {
    private final boolean containMoney;
    private boolean isOpen;
    private boolean isChosen;

    Box(boolean containMoney) {
        this.containMoney = containMoney;
        this.isOpen = false;
        this.isChosen = false;
    }

    public void open() {
        this.isOpen = true;
    }

    public void chooseIt() {
        this.isChosen = true;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean isChosen() {
        return isChosen;
    }

    public boolean isContainMoney() {
        return this.containMoney;
    }
}
