package ma.ensa.Elevator.State;

import ma.ensa.Elevator.Elevator;

public interface ElevatorState {
    void up(Elevator elevator, int where);

    void down(Elevator elevator, int where);

    void rest(Elevator elevator);

    void stop(Elevator elevator);
}
