package com.example.labwork1.entities;

import lombok.Getter;
import lombok.Setter;

public class Calculation {
    @Getter
    @Setter
    private int x;

    public Calculation(int x) {
        this.x = x;
    }

/*    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }*/
}

