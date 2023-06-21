import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketTest {
   Ticket ticket1 = new Ticket(203, 2655, "KGD", "LED", 145);
    Ticket ticket2 = new Ticket(993, 21200, "KGD", "VVO", 800);
   Ticket ticket3 = new Ticket(1, 23400, "KGD", "AUH", 800);
    Ticket ticket4 = new Ticket(4, 23400, "KGD", "VVO", 950);
    Ticket ticket5 = new Ticket(56, 19300, "KGD", "VVO", 1040);

    @Test
    public void shouldAddTicket() {
        TicketRepository repository = new TicketRepository();
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);
        repository.addTicket(ticket4);
        repository.addTicket(ticket5);
        Ticket[] exp = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] act = repository.getAllTickets();
        Assertions.assertArrayEquals(exp, act);


    }

    @Test
    public void shouldDelTicket() throws NotFoundException {
        TicketRepository repository = new TicketRepository();
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);
        repository.addTicket(ticket4);
        repository.addTicket(ticket5);
        repository.removeTicket(1);
        Ticket[] exp = {ticket1, ticket2, ticket3, ticket4};
        Ticket[] act = repository.getAllTickets();
    }

    @Test
    public void shouldComparePrices(){
     int exp = -1;
     Assertions.assertEquals(exp,ticket1.compareTo(ticket2));
     int exp1 = 1;
     Assertions.assertEquals(exp1, ticket3.compareTo(ticket1));
     int exp2 = 0;
     Assertions.assertEquals(exp2,ticket3.compareTo(ticket3));

    }
    @Test
    public void shouldThrowExceptionWhenDelWrongId() {
        TicketRepository repository = new TicketRepository();
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);
        repository.addTicket(ticket4);
        repository.addTicket(ticket5);

        Assertions.assertThrows(NotFoundException.class, () -> repository.removeTicket(0));

    }

    @Test
    public void shouldSearchTickets() throws NotFoundException {
        TicketRepository repository = new TicketRepository();
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);
        repository.addTicket(ticket4);
        repository.addTicket(ticket5);
        TicketManager manager = new TicketManager(repository);
        Ticket[] exp = { ticket5, ticket2, ticket4 };
        Ticket[] act = manager.searchTickets("KGD", "VVO");
        Assertions.assertArrayEquals(exp, act);
    }
    @Test
    public void shouldNotFindTickets() {
        TicketRepository repository = new TicketRepository();
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);
        repository.addTicket(ticket4);
        repository.addTicket(ticket5);
        TicketManager manager = new TicketManager(repository);
        Assertions.assertThrows(NotFoundException.class, () -> manager.searchTickets("HHO", "CHI"));
    }








}
