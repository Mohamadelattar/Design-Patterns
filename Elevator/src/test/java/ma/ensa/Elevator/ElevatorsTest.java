package ma.ensa.Elevator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ElevatorsTest {
    @Test
    public void the_closest_elevator_to_top_floor_should_arrive_first() {
        int numberOfFloors = 10;
        Building building = new Building(numberOfFloors, "id1:1", "id2:6");// "[elevator_id]:[elevator_current_floor]"

        String idOfFirstAvailableElevator = building.requestElevator(); // a request is by default from top floor

        assertEquals("id2", idOfFirstAvailableElevator);
    }

    @Test
    public void elevators_going_down_arrive_last_to_top_floor() {
        Building building = new Building(10, "id1:1", "id2:6");
        building.move("id2", "DOWN"); // tell the elevator "id2" to move "DOWN".

        String idOfFirstAvailableElevator = building.requestElevator();

        assertEquals("id1", idOfFirstAvailableElevator);
    }

    @Test
    public void elevators_going_up_should_arrive_to_top_floor_before_those_going_down() {
        Building building = new Building(10, "id1:1", "id2:6");
        building.move("id1", "UP");
        building.move("id2", "DOWN");

        String idOfFirstAvailableElevator = building.requestElevator();

        assertEquals("id1", idOfFirstAvailableElevator);
    }

    @Test
    public void elevators_going_up_should_be_compared_to_those_resting() {
        Building building = new Building(10, "id1:1", "id2:6", "id3:5");
        building.move("id1", "UP");
        building.move("id2", "DOWN");

        String idOfFirstAvailableElevator = building.requestElevator();

        assertEquals("id3", idOfFirstAvailableElevator);
    }

    @Test
    public void elevators_going_up_and_not_stopping_should_arrive_first_to_top_floor() {
        Building building = new Building(10, "id1:1", "id2:6", "id3:5");
        building.move("id1", "UP");
        building.move("id2", "DOWN");
        building.move("id3", "UP");
        building.stopAt("id3", 7); // request elevator "id3" to stop at level 7

        String idOfFirstAvailableElevator = building.requestElevator();

        assertEquals("id1", idOfFirstAvailableElevator);
    }

    @Test
    public void can_request_elevator_in_middle_of_building() {
        Building building = new Building(10, "id1:1", "id2:6");

        String idOfFirstAvailableElevator = building.requestElevator(5); // the request is made at the 5th floor

        assertEquals("id2", idOfFirstAvailableElevator); // "id2" is the closest elevator to 5th floor
    }
}
