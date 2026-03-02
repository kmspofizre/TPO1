package domain.entities;

import domain.enums.StudentStatus;

import java.util.ArrayList;
import java.util.List;

public class Train extends Entity {
    private List<Student> passengers = new ArrayList<>();
    public Train() { super("Поезд"); }

    public void addPassenger(Student s) { passengers.add(s); }
    public void removePassenger(Student s) {
        s.setStatus(StudentStatus.EJECTED);
        passengers.remove(s);
    }
    public List<Student> getPassengers() { return passengers; }
}
