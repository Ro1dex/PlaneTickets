public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTimeInMinutes;


    public Ticket(int id, int price, String departureAirport, String arrivalAirport, int travelTimeInMinutes) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.travelTimeInMinutes = travelTimeInMinutes;
    }

    public int getId() {
        return id;
    }

//    public int getPrice() {
//        return price;
//    }

    public String getDepartureAirport() {

        return departureAirport;
    }

    public String getArrivalAirport() {

        return arrivalAirport;
    }

   /* public int getTravelTimeInMinutes() {
        return travelTimeInMinutes;
    }*/

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price){
            return -1;
        }
        else if (this.price > o.price) {
            return  1;
        }
        else {
            return 0;
        }
    }
}
