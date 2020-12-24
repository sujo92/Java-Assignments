package com.company;

import java.awt.*;

public class FabricFactory {
    public CarpetFabric getFabric(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("N")){
            return new Nylon();

        } else if(shapeType.equalsIgnoreCase("W")){
            return new Wool();

        } else if(shapeType.equalsIgnoreCase("P")){
            return new Polyester();
        }
        return null;
    }
}
