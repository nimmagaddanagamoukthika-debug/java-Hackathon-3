
class Booking {
    String movieName;
    String customerName;
    double ticketPrice;
    int numberOfTickets;

    // Constructor 1: All booking details
    Booking(String customerName, String movieName,
            double ticketPrice, int numberOfTickets) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    // Constructor 2: Customer and movie details
    Booking(String customerName, String movieName) {
        this(customerName, movieName, 200.0, 1);
    }

    // Constructor 3: Customer, movie, and ticket count
    Booking(String customerName, String movieName,
            int numberOfTickets) {
        this(customerName, movieName, 200.0, numberOfTickets);
    }

    // Method 1: Book using the default ticket price
    void bookTickets() {
        displayBooking();
    }

    // Method 2: Book by specifying the number of tickets
    void bookTickets(int tickets) {
        numberOfTickets = tickets;
        displayBooking();
    }

    // Method 3: Book by specifying tickets and price
    void bookTickets(int tickets, double price) {
        numberOfTickets = tickets;
        ticketPrice = price;
        displayBooking();
    }

    // Calculate total booking amount
    double calculateTotal() {
        return ticketPrice * numberOfTickets;
    }

    // Calculate discount: 10% for 5 or more tickets
    double calculateDiscount() {
        if (numberOfTickets >= 5) {
            return calculateTotal() * 0.10;
        }
        return 0.0;
    }

    // Display booking summary
    void displayBooking() {
        System.out.println("Customer Name   : "
                + customerName.toUpperCase());

        System.out.println("Movie Name      : "
                + movieName.toUpperCase());

        System.out.printf("Ticket Price    : Rs. %.2f%n",
                ticketPrice);

        System.out.println("Number of Tickets: "
                + numberOfTickets);

        if (numberOfTickets <= 0) {
            System.out.println("Booking Status  : Invalid number of tickets");
            System.out.println();
            return;
        }

        double total = calculateTotal();
        double discount = calculateDiscount();
        double finalAmount = total - discount;

        System.out.println("Booking Status  : Booking Successful");
        System.out.printf("Total Amount    : Rs. %.2f%n", total);
        System.out.printf("Discount        : Rs. %.2f%n", discount);
        System.out.printf("Final Amount    : Rs. %.2f%n", finalAmount);
        System.out.println();
    }

    // Compare customer names
    boolean compareCustomer(Booking other) {
        return this.customerName.equalsIgnoreCase(
                other.customerName);
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("========== CINEMA TICKET BOOKING ==========");

        // Booking 1: Using the four-argument constructor
        Booking b1 = new Booking("Sneha", "Avatar", 200.0, 5);
        b1.displayBooking();

        // Booking 2: Using the three-argument constructor
        Booking b2 = new Booking("Arjun", "Avatar", 2);
        b2.bookTickets();

        // Booking 3: Using the two-argument constructor
        Booking b3 = new Booking("Sneha", "Avatar");
        b3.bookTickets(3, 250.0);

        // Compare customer names
        System.out.println("========== CUSTOMER COMPARISON ==========");

        if (b1.compareCustomer(b3)) {
            System.out.println("Both bookings belong to the same customer.");
        } else {
            System.out.println("Bookings belong to different customers.");
        }
    }
}
