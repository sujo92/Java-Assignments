package com.company;

import java.util.logging.Logger;

public class RoomCarpet {
    private RoomDimension roomDimension;
    private int costPerSqFt;
    private final Logger logger = Logger.getLogger(RoomCarpet.class.getName());

    public RoomCarpet(RoomDimension roomDimension, int costPerSqFt) {
        this.roomDimension = roomDimension;
        this.costPerSqFt = costPerSqFt;
    }

    public int totalCarpetCost() {
        this.logger.info("calculating total cost");
        return this.roomDimension.area() * this.costPerSqFt;
    }
}
