package domain.actions;

import domain.entities.Student;
import domain.enums.ItemType;

public class ThrowItemAction implements Action {
    private Student initiator;
    private ItemType targetType;

    public ThrowItemAction(Student initiator, ItemType targetType) {
        this.initiator = initiator;
        this.targetType = targetType;
    }

    @Override
    public void execute() {
        initiator.getBackpack().removeIf(item -> item.getType() == targetType);
    }
}