package week2;

public class RowingBoat {
    // have at least five instance variables on your class.
    String name;
    String brand;
    int num_people;
    String row_type;
    String color;
    int year_made;

    public RowingBoat(String name, String brand, int num_people, String row_type, String color,
            int year_made) {
        this.name = name;
        this.brand = brand;
        this.num_people = num_people;
        this.row_type = row_type;
        this.color = color;
        this.year_made = year_made;

    }

    public static void main(String[] args) {
        // create at least 3 instances of your class.

        RowingBoat boat1 = new RowingBoat("Voyager", "Empacher", 8, "sweeping", "blue", 2019);
        RowingBoat boat3 = new RowingBoat("Glider", "Resolute", 4, "sweeping", "black", 2021);
        RowingBoat boat2 = new RowingBoat("Captain", "Vespoli", 2, "sculling", "white", 2020);

        System.out.println("Our nicest boat is called the " + boat1.name + " and it is a " + boat1.color + " "
                + boat1.brand + ". It has " + boat1.num_people + " and was made in " + boat1.year_made + ".");
        System.out.println("Our newest is called the " + boat2.name + " and it is a " + boat2.color + " " + boat2.brand
                + ". It has " + boat2.num_people + " in " + boat2.row_type + " style and was made in " + boat2.year_made
                + ".");
        System.out.println("Our fastest boat is called the " + boat3.name + " and it is a " + boat3.color + " "
                + boat3.brand + ". It has " + boat3.num_people + " in " + boat3.row_type + " style and was made in "
                + boat3.year_made + ".");

    }
}