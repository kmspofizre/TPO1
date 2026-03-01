package domain;

class ITMOStudent extends Student {
    public ITMOStudent() {
        super("итмошник");
    }
    @Override
    public void doAction(Train train) {
        if (!backpack.isEmpty()) {
            backpack.remove(0);
        }
    }
}
