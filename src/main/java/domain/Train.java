package domain;

import java.util.ArrayList;
import java.util.List;

class Train {
    private List<Student> passengers = new ArrayList<>();
    public void addPassenger(Student s) {
        passengers.add(s);
    }
    public void removePassenger(Student s) {
        passengers.remove(s);
    }
    public List<Student> getPassengers() {
        return passengers;
    }
}