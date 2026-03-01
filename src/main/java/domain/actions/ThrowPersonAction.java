package domain.actions;

import domain.entities.MCStudent;
import domain.entities.Train;

public class ThrowPersonAction implements Action {
    private Train train;

    public ThrowPersonAction(Train train) {
        this.train = train;
    }

    @Override
    public void execute() {
        train.getPassengers().stream()
                .filter(p -> p instanceof MCStudent)
                .findFirst()
                .ifPresent(victim -> train.removePassenger(victim));
    }
}