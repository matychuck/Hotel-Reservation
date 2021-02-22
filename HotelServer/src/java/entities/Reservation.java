package entities;

import java.util.Date;

public class Reservation {
    int reservationId; // reservationId rezerwacji
    int roomId; // reservationId pokoju
    Date dateFrom; // początek rezerwacji
    Date dateTo; // koneic rezerwacji
    int daysAmount; // liczba dni wynajmu
    double price; // cena za pobyt
    
    public Reservation() {}
    
    public Reservation(int id, int roomId, Date dateFrom, Date dateTo, int daysAmount, double price){
        this.reservationId=id;
        this.roomId=roomId;
        this.dateFrom=dateFrom;
        this.dateTo=dateTo;
        this.daysAmount=daysAmount;
        this.price=price;
    }
    
    public int getReservationId(){
        return reservationId;
    }
    
    public void setReservationId(int reservationId){
        this.reservationId=reservationId;
    }
    
    public int getRoomId(){
        return roomId;
    }
    
    public void setRoomId(int roomId){
        this.roomId=roomId;
    }
    
    public Date getDateFrom(){
        return dateFrom;
    }
    
    public void setDateFrom(Date dateFrom) {
        this.dateFrom=dateFrom;
    }
    
     public Date getDateTo(){
        return dateTo;
    }
    
    public void setDateTo(Date dateTo) {
        this.dateTo=dateTo;
    }
    
    public int getDaysAmount() {
        return daysAmount;
    }
    
    public void setDaysAmount(int daysAmount){
        this.daysAmount=daysAmount;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price){
        this.price=price;
    }
}
