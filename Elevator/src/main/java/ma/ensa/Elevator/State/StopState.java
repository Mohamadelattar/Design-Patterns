package ma.ensa.Elevator.State;

import ma.ensa.Elevator.Elevator;

public class StopState implements ElevatorState{


    @Override
    public void up(Elevator elevator, int where) {
        elevator.setElevatorState(new UpState());
        elevator.getElevatorState().up(elevator, where);
    }

    @Override
    public void down(Elevator elevator, int where) {
        elevator.setElevatorState(new DownState());
        elevator.getElevatorState().down(elevator,where);
    }

    @Override
    public void rest(Elevator elevator) {
        elevator.setElevatorState(new RestState());
    }

    @Override
    public void stop(Elevator elevator) {
        throw new IllegalStateException("Elevator already stopping");
    }


}
