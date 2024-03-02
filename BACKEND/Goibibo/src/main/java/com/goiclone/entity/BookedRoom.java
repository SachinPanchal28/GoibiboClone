package com.goiclone.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column(name = "checkIn")
    private LocalDate checkInDate;

    @Column(name = "checkOut")
    private LocalDate checkOutDate;

    private String guestFullName;
    private String guestEmail;

    @Column(name = "children")
    private int numOfChildren;

    @Column(name = "totalGuest")
    private int totalNumOfGuest;

    @Column(name = "adults")
    private int numOfAdults;

    @Column(name = "confirmationCode")
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId")
    private Room room;

    private void calculateTotalNumOfGuests(){
        this.totalNumOfGuest = this.numOfChildren + this.numOfAdults;
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumOfGuests();
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumOfGuests();
    }


}
