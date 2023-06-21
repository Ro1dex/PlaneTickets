import java.util.Arrays;

public class TicketManager {
    private final TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] searchTickets(String departureAirport, String arrivalAirport) throws NotFoundException {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getAllTickets()) {
            if (matches(ticket, departureAirport,arrivalAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[result.length] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        if (result.length == 0){
            throw new NotFoundException("No tickets were found for such a flight");
        } else {
            return result;
        }
    }
    public boolean matches (Ticket ticket, String departureAirport, String arrivalAirport)  {
        return ticket.getDepartureAirport().contains(departureAirport) && ticket.getArrivalAirport().contains(arrivalAirport);
    }
}
