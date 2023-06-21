import java.util.Arrays;

public class TicketRepository {
    private  Ticket[] tickets;

    public TicketRepository() {
        this.tickets = new Ticket[0];
    }

    public void addTicket(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++){
            tmp[i] = tickets [i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeTicket(int id) throws NotFoundException {
        if (findById(id)!= null) {
            Ticket ticketToRemove = findById(id);
            Ticket[] tmp = new Ticket[tickets.length - 1];
            int copyToIndex = 0;
            for (Ticket ticket : tickets) {
                if (ticket != ticketToRemove) {
                    tmp[copyToIndex++] = ticket;
                }
            }
            tickets = tmp;
        } else throw new NotFoundException("Element with id: " + id + " not found");
    }

    public Ticket[] getAllTickets() {
        return tickets;
    }
    public Ticket findById(int id)  {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
       return null;

    }
}

