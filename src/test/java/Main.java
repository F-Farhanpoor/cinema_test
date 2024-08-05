import com.example.cinema_test.model.entity.Seat;

public class Main {
    public static void main(String[] args) {

        Seat seat1 =
                Seat
                        .builder()
                        .seatNumber(1)
                        .label("A1")
                        .status(true)
                        .deleted(false)
                        .description("test")
                        .build();

        Seat seat2 =
                Seat
                        .builder()
                        .seatNumber(2)
                        .label("A2")
                        .status(true)
                        .deleted(false)
                        .description("test")
                        .build();




    }
}
