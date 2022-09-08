import com.house.*;

public class Main {

    public static void main(String[] args) {
        House[] houses = generateNewArray();
        printFlatsWithGivenCountRooms(houses, 2);
        printFlatsWithGivenCountRoomsAndFloorBetween(houses, 5, 3,5);
        printFlatsWithBiggerSquare(houses,70);

    }

    public static House[] generateNewArray() {
        return new House[] {
                new House(1, 26, 42, 1 , 3, "Lukasha"),
                new House(2, 12, 24, 2 , 2, "Stepana Banderu"),
                new House(3, 69, 73, 3 , 5, "Zerbino"),
                new House(4, 31, 30, 2 , 2, "Lukasha"),
                new House(5, 41, 76, 4 , 5, "Stepana Banderu"),
                new House(6, 22, 90, 5 , 5, "Stepana Banderu"),
        };
    }
    static void printFlatsWithGivenCountRooms(House[] array, int count) {
        System.out.printf("Flats that have a given count of rooms %d:\n", count);
        for (House house : array)
            if (house.getRoomsCount() == count)
                System.out.println(house);
    }

    static void printFlatsWithGivenCountRoomsAndFloorBetween(House[] array, int count, int floorBegin, int floorEnd) {
        System.out.printf("Flats that have a given count of rooms %d and are located on a floor that is in a given interval - begin[%d] end[%d]:\n", count,floorBegin,floorEnd);
        for (House house : array)
            if (house.getRoomsCount() == count && (house.getFloor() >= floorBegin && house.getFloor() <= floorEnd))
                System.out.println(house);
    }

    static void printFlatsWithBiggerSquare(House[] array, int square) {
        System.out.printf("Flats that have a bigger square that given %d:\n", square);
        for (House house : array)
            if (house.getSquare() > square)
                System.out.println(house);
    }
}
