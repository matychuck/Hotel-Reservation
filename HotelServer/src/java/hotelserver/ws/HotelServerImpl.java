package hotelserver.ws;

import entities.Reservation;
import entities.Room;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import hotelserver.pdf.PDFGenerator;
import java.awt.Image;
import java.io.*;
import java.net.ProxySelector;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;

@MTOM
@WebService(endpointInterface = "hotelserver.ws.HotelServer")
@BindingType(value = SOAPBinding.SOAP12HTTP_MTOM_BINDING)
@HandlerChain(file="handler-chain.xml")
public class HotelServerImpl implements HotelServer{
    private int roomId = 1; // id pokoju
    private int reservationId = 1; // id rezerwacji
    private List<Room> roomList; // lista pokoi
    private List<Reservation> reservationList;
    private static String filePath = "C:\\Studia Magisterskie\\Semestr I\\HotelReservation\\HotelReservationProject\\HotelReservation\\HotelServer\\";
    
    public HotelServerImpl() {
        initHotel();
        System.out.println("Service created!");
    }
    
    @Override
    public String getServerName() {
        return "Hotel server";
    }

    // <editor-fold defaultstate="collapsed" desc="Pokoje">
    @Override
    public void addRoom(int roomNumber, int bedsAmount, double price, String notes) {
        Room newRoom = new Room(roomId, roomNumber, bedsAmount, price, notes);
        roomList.add(newRoom);
        roomId++;
    }
    
    @Override
    public boolean deleteRoom(int id) {
        if(!checkIfRoomExists(id)) return false;
        else if(!checkIfRoomHasReservations(id)) return false;
        else {
            roomList.removeIf(t -> t.getRoomId() == id);
            //roomList.remove(id-1);
            return true;
        }
    }
    
    @Override
    public Room getRoom(int id) {
        if(!checkIfRoomExists(id)) return null;
        else {
            for (Room room : roomList) {
                if (room.getRoomId()==id) {
                    return room;
                }
            }
        } 
        return null;
    }
    
    @Override
    public void editRoom(int id, int roomNumber, int bedsAmount, double price, String notes) {
        Room editedRoom = new Room(id, roomNumber, bedsAmount, price, notes);
            for (int i=0;i<roomList.size();i++) {
                if (roomList.get(i).getRoomId() == id) {
                    roomList.set(i,editedRoom);
                }
            }
        //roomList.set(id-1, editedRoom); 
    }
    
    @Override
    public List<Room> getRooms() {
        return roomList;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Rezerwacje">
    @Override
    public boolean addReservation(int roomId, Date dateFrom, Date dateTo) {
        if(!checkIfRoomExists(roomId)) return false;
        Room room = getRoom(roomId);
        boolean isAvailable = room.checkAvailability(dateFrom, dateTo);  // sprawdzenie czy pokoj jest dostepny w tym terminie
        if(!isAvailable) {
            System.out.println("AddReservation: Room is not available!");
            return false;
        }
        int daysAmount = (int)ChronoUnit.DAYS.between(convertToLocalDate(dateFrom), convertToLocalDate(dateTo));
        double price = room.getPrice()*daysAmount;       
        List<Reservation> roomReservations = room.getRoomReservations();
        Reservation newReservation = new Reservation(reservationId, roomId, dateFrom, dateTo, daysAmount, price);
        roomReservations.add(newReservation);
        room.setRoomReservations(roomReservations); // dodanie do listy rezerwacji danego pokoju
        reservationList.add(newReservation); // dodanie do listy wszystkich rezerwacji
        
        try {
            System.out.println("AddReservation: Start generating PDF file");
            PDFGenerator.generatePDF(newReservation, room.getRoomNumber(), filePath);
        }
        catch(Exception e) {
            System.out.println("AddReservation: Cannot generate PDF file");
        }
        
        reservationId++;
        return true;
    }
    
    @Override
    public List<Reservation> getRoomReservations(int roomId){
        return getRoom(roomId).getRoomReservations();
    }
    
    @Override
    public List<Reservation> getReservations() {
        return reservationList;
    }
    
    @Override
    public Reservation getReservation(int reservationId) {
        if(!checkIfReservationExists(reservationId)) return null;
        else {
            for (Reservation reservation : reservationList) {
                if (reservation.getReservationId()==reservationId) {
                    return reservation;
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean deleteReservation(int reservationId) {
        if(!checkIfReservationExists(reservationId)) return false;
        else {
            Reservation deletedReservation = getReservation(reservationId);
            Room reservedRoom = getRoom(deletedReservation.getRoomId());
            List<Reservation> roomReservations = reservedRoom.getRoomReservations();
            roomReservations.removeIf(item -> (item.getReservationId() == reservationId)); // usuniecie z listy rezerwacji danego pokoju
            reservationList.removeIf(t -> t.getReservationId() == reservationId);  // usuniecie z listy wszystkich rezerwacji
            reservedRoom.setRoomReservations(roomReservations); 
            roomList.set(reservedRoom.getRoomId()-1, reservedRoom); // zaktualizowanie danych na liscie pokoi
            return true;
        } 
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Pomocnicze">
    void initHotel() {
        roomList = new ArrayList<>();
        addRoom(11, 1, 50, "taras");
        addRoom(12, 1, 43, "");
        addRoom(13, 1, 56, "balkon");
        addRoom(14, 2, 98, "");
        addRoom(15, 2, 105, "");
        addRoom(16, 2, 99, "");
        addRoom(17, 3, 145, "");
        addRoom(18, 3, 160, "");
        addRoom(19, 3, 152, "");
        addRoom(20, 4, 189, "");
        addRoom(21, 4, 199, "");
        addRoom(22, 4, 202, "");
        
        reservationList = new ArrayList<>();
        try {
            String sDateFrom = "03/05/2020";
            Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse(sDateFrom);
            String sDateTo = "10/05/2020";
            Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse(sDateTo);
            addReservation(2, dateFrom, dateTo);
            
            sDateFrom = "07/05/2020";
            dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse(sDateFrom);
            sDateTo = "21/05/2020";
            dateTo = new SimpleDateFormat("dd/MM/yyyy").parse(sDateTo);
            addReservation(6, dateFrom, dateTo);
            
            sDateFrom = "13/05/2020";
            dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse(sDateFrom);
            sDateTo = "18/05/2020";
            dateTo = new SimpleDateFormat("dd/MM/yyyy").parse(sDateTo);
            addReservation(3, dateFrom, dateTo);
        }
        catch(Exception e) {
            System.out.println("InitHotel: cannot parse date!");
        }       
    }
    
    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
          .atZone(ZoneId.systemDefault())
          .toLocalDate();
    }
    
    // sprawdzenie czy pokoj istnieje
    public boolean checkIfRoomExists(int roomId){
        Optional<Room> checkRoom = roomList.stream().filter(item -> (item.getRoomId() == roomId)).findAny();
        if(!checkRoom.isPresent()) {  // sprawdzenie czy pokoj istnieje
            System.out.println("CheckIfRoomExists: Room with id "+roomId+" does not exist!");
            return false;
        }
        return true;
    }
    
    // sprawdzenie czy pokoj ma jakies rezerwacje
    public boolean checkIfRoomHasReservations(int roomId){
        Room testRoom = getRoom(roomId);
        int numberOfReservations = testRoom.getRoomReservations().size();
        if(numberOfReservations>0) {  
            System.out.println("CheckIfRoomHasReservations: Room with id "+roomId+" has "+numberOfReservations+" reservations!");
            return false;
        }
        return true;
    }
    
    // sprawdzenie czy rezerwacja istnieje
    public boolean checkIfReservationExists(int reservationId){
        Optional<Reservation> checkReservation = reservationList.stream().filter(item -> (item.getReservationId() == reservationId)).findAny();
        if(!checkReservation.isPresent()) {  // sprawdzenie czy rezerwacja istnieje
            System.out.println("CheckIfReservationExists: Reservation with id "+reservationId+" does not exist!");
            return false;
        }
        return true;
    }
    // </editor-fold>
    
    @Override
    public DataHandler downloadReservationConfirmation(int reservationId){
        try{
            /*String fileName = filePath+reservationId+".pdf";
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fis);
            byte[] fileBytes = new byte[(int) file.length()];
            inputStream.read(fileBytes);
            inputStream.close();     
            return fileBytes;*/
            String fileName = filePath+reservationId+".pdf";
            //File file = new File(fileName);
            //return file;
            DataSource dataSource = new FileDataSource(new File(fileName));
            return new DataHandler(dataSource);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
