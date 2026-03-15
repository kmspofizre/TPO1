package domain.entities;
import domain.enums.ItemType;


public class Item extends Entity {
    private ItemType type;
    public Item(String name, ItemType type) {
        super(name);
        this.type = type;
    }
    public ItemType getType() { return type; }
}
