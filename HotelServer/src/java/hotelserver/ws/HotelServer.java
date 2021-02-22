package hotelserver.ws;

import entities.Reservation;
import entities.Room;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
//@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL) 
public interface HotelServer {
    
    // zwraca nazwe serwera
    @WebMethod
    public String getServerName();

    // <editor-fold defaultstate="collapsed" desc="Pokoje">
    // dodawanie pokoju
    @WebMethod
    public void addRoom(@WebParam(name="roomNumber") int roomNumber, // numer pokoju
                        @WebParam(name="bedsAmount") int bedsAmount, // liczba miejsc do spania
                        @WebParam(name="price") double price, // cena za noc
                        @WebParam(name="notes") String notes); // dodatkowe informacje
    
    // usuwanie pokoju, jak sie powiedzie to zwraca true
    @WebMethod
    public boolean deleteRoom(@WebParam(name="roomId") int id); // id pokoju
    
    // zwraca pokoj o danym id
    @WebMethod
    public Room getRoom(@WebParam(name="roomId") int id); // id pokoju
    
    // edytowanie pokoju
    @WebMethod
    public void editRoom(@WebParam(name="roomId") int id, // id pokoju
                         @WebParam(name="roomNumber") int roomNumber, // nowy numer pokoju
                         @WebParam(name="bedsAmount") int bedsAmount, // nowa liczba miejsc do spania
                         @WebParam(name="price") double price, // nowa cena
                         @WebParam(name="notes") String notes); // nowe dodatkowe informacje
    
    // zwraca liste wszystkich pokoi
    @WebMethod
    public List<Room> getRooms();
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Rezerwacje">
    // dodawanie rezerwacji, jak sie powiedzie to zwraca true
    @WebMethod
    public boolean addReservation(@WebParam(name="roomId") int roomId, // id pokoju
                                  @WebParam(name="dateFrom") Date dateFrom, // poczatek rezerwacji
                                  @WebParam(name="dateTo") Date dateTo); // koniec rezerwacji
    
    // zwraca liste rezerwacji danego pokoju
    @WebMethod
    public List<Reservation> getRoomReservations(@WebParam(name="roomId") int roomId); // id pokoju
    
    // zwraca liste wszystkich rezerwacji
    @WebMethod
    public List<Reservation> getReservations(); 
    
    // zwraca rezerwacje o danym id
    @WebMethod
    public Reservation getReservation(@WebParam(name="reservationId") int reservationId);
    
     // usuwanie rezerwacji, jak sie powiedzie to zwraca true
    @WebMethod
    public boolean deleteReservation(@WebParam(name="reservationId") int reservationId); // id rezerwacji
    // </editor-fold>  
    
     public DataHandler downloadReservationConfirmation(@WebParam(name="reservationId") int reservationId);
}
