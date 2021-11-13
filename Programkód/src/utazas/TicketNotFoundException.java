package utazas;
public class TicketNotFoundException extends Exception { 
    public TicketNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}