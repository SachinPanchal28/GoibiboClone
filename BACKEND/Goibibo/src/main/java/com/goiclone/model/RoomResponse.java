package com.goiclone.model;

import com.goiclone.entity.BookedRoom;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class RoomResponse {
    private Long roomId;
    private String roomType;
    private BigDecimal roomPrice;
    private String photo;
    private boolean roomBooked = false;
    private List<BookingResponse> bookings;

    public RoomResponse(Long roomId, String roomType, BigDecimal roomPrice) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public RoomResponse(Long roomId, String roomType, BigDecimal roomPrice,
                        byte[] photoByte, boolean roomBooked, List<BookingResponse> bookings) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.photo = photoByte != null ? Base64.encodeBase64String(photoByte) : null;
        this.roomBooked = roomBooked;
        this.bookings = bookings;
    }

}
