package com.hotel.entities;

public class Request {
    private long id;
    private long userId;
    private long roomId;

    public Request(long id, long userId, long roomId) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
    }

    public Request() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}
