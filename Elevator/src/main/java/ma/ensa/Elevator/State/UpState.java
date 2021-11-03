package ma.ensa.Elevator.State;
import ma.ensa.Elevator.Elevator;

public class UpState implements ElevatorState {
    @Override
    public void up(Elevator elevator, int where) {
        if(elevator.getCurrentFloor() != where) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
            up(elevator,where);
        } else {
            this.rest(elevator);
        }
    }

    @Override
    public void down(Elevator elevator, int where) {
        throw new IllegalStateException("Elevator is asending , Wait Please ...");
    }

    @Override
    public void rest(Elevator elevator) {
        elevator.setElevatorState(new RestState());
        if(elevator.getCurrentFloor() != elevator.getNumberOfFloors()) {
            elevator.setElevatorState(this); // Go to reach the top floor
        } else {
            elevator.setElevatorState(new DownState()); // Elevator reach the top floor , switch direction
        }
    }

    @Override
    public void stop(Elevator elevator) {
        
        elevator.setElevatorState(new StopState());
    }


}
