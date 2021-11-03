package ma.ensa.Elevator.Factory;
import ma.ensa.Elevator.Elevator;

/**
 * Elevator Factory is an interface with it the Building class can create Elevator objects
 */
public interface ElevatorFactory {

    public Elevator createElevator(String identifier, int numberOfFloors);

}
