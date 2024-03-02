package com.goiclone.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private String roomType;
    private BigDecimal roomPrice;

    @Lob
    private Blob photo;
    private boolean roomBooked = false;

    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;

    public Room() {
        this.bookings = new ArrayList<>();
    }

    public void addBookings(BookedRoom booking){
        if(booking == null){
            this.bookings = new ArrayList<>();
        }else{
            this.bookings.add(booking);
            booking.setRoom(this);
            roomBooked = true;
            booking.setBookingConfirmationCode(RandomStringUtils.random(10));
        }
    }

}
