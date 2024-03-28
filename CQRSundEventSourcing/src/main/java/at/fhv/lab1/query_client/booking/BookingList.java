package at.fhv.lab1.query_client.booking;

import java.util.ArrayList;

public class BookingList {
    private static class Entry extends Booking{
        Entry nextStartDate;
        Entry nextEndDate;

        public Entry(Booking booking) {
            super(booking.getReservationNumber(), booking.getRoomNumber(), booking.getStartDate(), booking.getEndDate(), booking.getCustomer());
        }
    }

    private static BookingList instance;
    private Entry headStartDate;
    private Entry headEndDate;

    private BookingList(){

    }

    public static BookingList initialize(){
        if(instance == null){
            instance = new BookingList();
        }

        return instance;
    }

    public void insert(Booking booking){
        Entry entry = new Entry(booking);

        if(headStartDate == null || entry.getStartDate() < headStartDate.getStartDate()){
            entry.nextStartDate = headStartDate;
            headStartDate = entry;
        }else{
            Entry current = headStartDate;
            Entry prev = null;

            while(current != null && current.getStartDate() < entry.getStartDate()){
                prev = current;
                current = current.nextStartDate;
            }

            entry.nextStartDate = current;
            prev.nextStartDate = entry;
        }


        if(headEndDate == null || entry.getEndDate() < headEndDate.getEndDate()){
            entry.nextEndDate = headEndDate;
            headEndDate = entry;
        }else{
            Entry current = headEndDate;
            Entry prev = null;

            while(current != null && current.getEndDate() < entry.getEndDate()){
                prev = current;
                current = current.nextEndDate;
            }

            entry.nextEndDate = current;
            prev.nextEndDate = entry;
        }
    }

    public void delete(int reservationNumber){
        Entry current = headStartDate;
        Entry prev = null;

        while(current != null && current.getReservationNumber() != reservationNumber){
            prev = current;
            current = current.nextStartDate;
        }

        if(current != null){
            if(prev == null){
                headStartDate = current.nextStartDate;
            }else{
                prev.nextStartDate = current.nextStartDate;
            }
        }

        current = headEndDate;
        prev = null;

        while(current != null && current.getReservationNumber() != reservationNumber){
            prev = current;
            current = current.nextEndDate;
        }

        if(current != null){
            if(prev == null){
                headEndDate = current.nextEndDate;
            }else{
                prev.nextEndDate = current.nextEndDate;
            }
        }
    }

    public ArrayList<Booking> getBookings(long startDate, long endDate){
        Entry current = headStartDate;

        while(current != null && current.getStartDate() < startDate){
            current = current.nextStartDate;
        }

        ArrayList<Booking> bookings = new ArrayList<>();

        while(current != null && current.getStartDate() <= endDate){
            bookings.add(current);
            current = current.nextStartDate;
        }

        current = headEndDate;

        while(current != null && current.getEndDate() < startDate){
            current = current.nextEndDate;
        }

        while(current != null && current.getEndDate() <= endDate){
            if(!bookings.contains(current)){
                bookings.add(current);
            }
            current = current.nextEndDate;
        }

        return bookings;
    }

}
