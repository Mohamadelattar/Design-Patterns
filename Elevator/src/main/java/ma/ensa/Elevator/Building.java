package ma.ensa.Elevator;

import ma.ensa.Elevator.Factory.ElevatorFactory;
import ma.ensa.Elevator.Factory.ElevatorFactoryImpl;
import java.util.*;

public class Building {
    private int numberOfFloors;
    private List<Elevator> elevators;
    private ElevatorFactory elevatorFactory = ElevatorFactoryImpl.getInstance();

    public Building(int numberOfFloors, String... elevators) {
        this.numberOfFloors = numberOfFloors;
        this.elevators = new ArrayList<Elevator>();
        Arrays.stream(elevators)
                .forEach(elevator -> {
               this.elevators.add(this.elevatorFactory.createElevator(elevator,numberOfFloors));
        });
    }
    public String requestElevator() {
        Elevator elevator = null;
        int minDistance = this.numberOfFloors;
        for(Elevator e : this.elevators ) {
            System.out.println(e.toString());
            if(this.numberOfFloors - e.getCurrentFloor() < minDistance) {
                minDistance = this.numberOfFloors - e.getCurrentFloor();
                elevator = e;
            }
        }
        return elevator.getId();
    }
    public String requestElevator(int floor) {
        Elevator elevator = null;
        int minDistance = floor;
        for(Elevator e : this.elevators ) {
             System.out.println(e.toString());
            if(Math.abs(floor - e.getCurrentFloor()) < minDistance) {
                minDistance = Math.abs(floor - e.getCurrentFloor()) ;
                elevator = e;
            }
        }
        return elevator.getId();
    }

    public void move(String id, String action) {
        for(Elevator elevator : this.elevators) {
            if(elevator.getId().equals(id)) {
                switch (action) {
                    case "DOWN":
                        elevator.getElevatorState().down(elevator,1);
                    break;
                    case "UP":
                        elevator.getElevatorState().up(elevator,this.numberOfFloors);
                    break;
                    default:
                        throw  new IllegalArgumentException("Elevator can only move DOWN or UP");
                }

            }
        }
    }

    public void stopAt(String id, int floor) {
        for(Elevator elevator : this.elevators) {
            if(elevator.getId().equals(id)) {
                elevator.getElevatorState().stop(elevator);
                elevator.setCurrentFloor(floor);
            }
        }
    }
}
