package mk.ukim.finki.emt.reservation.domain.model;

public enum  ReservationStatus {
    //se ceka da se podigne
    Processing,
    //koga ce ja podigne knigata
    Confirmed,
    //Koga ce mu istece vremeto za vrakjanje na knigata
    Expired,
    //Koga knigata e vratena
    Returned,
    //koga nema da ja podigne ili ke ja otkaze
    Cancelled
}
