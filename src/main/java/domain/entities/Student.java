package domain.entities;

import domain.enums.StudentStatus;

import java.util.ArrayList;
import java.util.List;

public abstract class Student extends Entity {
    protected List<Item> backpack = new ArrayList<>();
    protected StudentStatus status = StudentStatus.ON_BOARD;

    public Student(String name) { super(name); }
    public void addToBackpack(Item item) { backpack.add(item); }
    public List<Item> getBackpack() { return backpack; }
    public void setStatus(StudentStatus status) { this.status = status; }
    public StudentStatus getStatus() { return status; }
}