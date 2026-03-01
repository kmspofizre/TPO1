package domain;

class YSDAStudent extends Student {
    public YSDAStudent() {
        super("шадовец");
    }

    @Override
    public void doAction(Train train) {
        train.getPassengers().stream()
                .filter(p -> p instanceof MCStudent)
                .findFirst()
                .ifPresent(train::removePassenger);
    }
}