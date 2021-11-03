package ma.ensa.Elevator;

import ma.ensa.Elevator.State.ElevatorState;
import ma.ensa.Elevator.State.RestState;

public class Elevator {
    private String id;
    private int currentFloor;
    private ElevatorState elevatorState;
    private int numberOfFloors;

    public Elevator(String id, int currentFloor, ElevatorState elevatorState, int numberOfFloors) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.elevatorState = elevatorState;
        this.numberOfFloors = numberOfFloors;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "id='" + id + '\'' +
                ", currentFloor=" + currentFloor +
                ", elevatorState=" + elevatorState +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
