package domain;

class MCStudent extends Student {
    public MCStudent() {
        super("мкновец");
    }
    @Override
    public void doAction(Train train) {
        if (!backpack.isEmpty()) backpack.remove(0);
    }
}
