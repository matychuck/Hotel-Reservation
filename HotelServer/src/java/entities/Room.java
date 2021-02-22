package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Room {
    int roomId; // roomId pokoju
    int roomNumber; // numer pokoju
    int bedsAmount; // liczba miejsc w pokoju
    double price; // cena za noc
    String notes; // dodatkowe informacje
    List<Reservation> roomReservations; // lista rezerwacji danego pokoju
    
    public Room() {}
    
    public Room(int id, int roomNumber, int bedsAmount, double price, String notes){
        this.roomId=id;
        this.roomNumber=roomNumber;
        this.bedsAmount=bedsAmount;
        this.price=price;
        this.notes=notes;
        this.roomReservations = new ArrayList<>();
    }
    
    public int getRoomId(){
        return roomId;
    }
    
    public void setRoomId(int roomId){
        this.roomId=roomId;
    }
    
    public int getRoomNumber(){
        return roomNumber;
    }
    
    public void setRoomNumber(int id){
        this.roomNumber=roomNumber;
    }
    
    public int getBedsAmount() {
        return bedsAmount;
    }
    
    public void setBedsAmount(int bedsAmount) {
        this.bedsAmount = bedsAmount;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price){
        this.price=price;
    }
    
    public String getNotes(){
        return notes;
    }
    
    public void setNotes(String notes){
        this.notes=notes;
    }
    
    public List<Reservation> getRoomReservations(){
        return roomReservations;
    }
    
    public void setRoomReservations(List<Reservation> roomReservations){
        this.roomReservations=roomReservations;
    }
    
    // sprawdzenie dostepnosci pokoju w podanym terminie
    public boolean checkAvailability(Date dateFrom, Date dateTo) {
        Date today = new Date();
        for(int i=0; i<this.roomReservations.size(); i++) {
            Reservation reservation = this.roomReservations.get(i);
            int firstTest = dateFrom.compareTo(reservation.dateFrom); // poczatek nowej rezerwacji i poczatek poprzedniej
            int secondTest = dateFrom.compareTo(reservation.dateTo); // poczatek nowej rezerwacji i koniec poprzedniej          
            int thirdTest = dateTo.compareTo(reservation.dateFrom); // koniec nowej rezerwacji i poczatek poprzedniej
            int fourthTest = dateTo.compareTo(reservation.dateTo); // koniec nowej rezerwacji i koniec poprzedniej
            int fifthTest = dateFrom.compareTo(today); // data poczatkowa i dzisiejsza
            int sixthTest = dateFrom.compareTo(dateTo); // poczatek i koniec nowej rezerwacji
            
            if(firstTest>=0 && fourthTest<=0) return false; // nowa rezerwacja zawiera sie w poprzedniej
            if(firstTest<=0 && fourthTest>=0) return false; // nowa rezerwacja zawiera poprzednia
            if(firstTest>=0 && secondTest<=0) return false; // nowa rezerwacja zaczyna sie w trakcie trwania poprzedniej
            if(thirdTest>=0 && fourthTest<=0) return false; // nowa rezerwacja konczy sie w trakcie trwania poprzedniej  
            if(fifthTest<0) return false; // rezerwacja wstecz nie jest mozliwa
            if(sixthTest>=0) return false; // data poczatkowa musi byc mniejsza od koncowej
        }
        return true;
    }
}
