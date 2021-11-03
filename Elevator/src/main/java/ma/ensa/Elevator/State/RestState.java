package ma.ensa.Elevator.State;

import ma.ensa.Elevator.Elevator;

public class RestState implements ElevatorState {


    @Override
    public void up(Elevator elevator, int where) {
        elevator.setElevatorState(new UpState());
        elevator.getElevatorState().up(elevator,where);
    }

    @Override
    public void down(Elevator elevator, int where) {
        elevator.setElevatorState(new DownState());
        elevator.getElevatorState().down(elevator,where);
    }

    @Override
    public void rest(Elevator elevator) {
        throw new IllegalStateException("Elevator already resting. ");
    }

    @Override
    public void stop(Elevator elevator) {
        elevator.setElevatorState(new StopState());
    }


}
