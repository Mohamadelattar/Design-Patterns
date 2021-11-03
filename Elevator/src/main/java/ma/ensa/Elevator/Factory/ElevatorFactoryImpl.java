package ma.ensa.Elevator.Factory;

import ma.ensa.Elevator.Elevator;
import ma.ensa.Elevator.State.DownState;

/**
 * ElevatorFactoryImpl
 */
public class ElevatorFactoryImpl implements ElevatorFactory {
    private static ElevatorFactoryImpl instance = null;

    public static  ElevatorFactoryImpl getInstance() {
        if(instance == null)
            instance = new ElevatorFactoryImpl();
            return instance;
    }

    /**
     *
     * @param identifier the String contains Elevator's informations (id , currentFloor)
     * @param numberOfFloors
     * @return Elevator object
     */
    @Override
    public Elevator createElevator(String identifier, int numberOfFloors) {
        String id = identifier.split(":")[0];
        int currentFloor = Integer.valueOf(identifier.split(":")[1]);
        return new Elevator(id,currentFloor,new DownState(),numberOfFloors);
    }
}
