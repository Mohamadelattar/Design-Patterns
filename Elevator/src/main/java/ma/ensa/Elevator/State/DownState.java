package ma.ensa.Elevator.State;

import ma.ensa.Elevator.Elevator;

public class DownState implements ElevatorState{


    @Override
    public void up(Elevator elevator, int where) {
        new IllegalStateException("Elevetor is descending, Please Wait ...");
    }

    @Override
    public void down(Elevator elevator, int where) {
        if(elevator.getCurrentFloor() != where) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
            down(elevator,where);
        } else {
            this.rest(elevator);
        }
    }

    @Override
    public void rest(Elevator elevator) {
        elevator.setElevatorState(new RestState());
        if(elevator.getCurrentFloor() != 0) {
            elevator.setElevatorState(this);
        } else {
            elevator.setElevatorState(new UpState());
        }
    }

    @Override
    public void stop(Elevator elevator) {
        elevator.setElevatorState(new StopState());
    }


}
