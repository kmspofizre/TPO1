package domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Student {
    protected String name;
    protected List<String> backpack = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }
    public void addToBackpack(String item) {
        backpack.add(item);
    }
    public abstract void doAction(Train train);
    public String getName() {
        return name;
    }
}
