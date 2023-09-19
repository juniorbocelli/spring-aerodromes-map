package com.juniorbocelli.xmobotscase.aerodrome.utils;

public class Test {
    public static void main(String[] args) {
        String description = "AUTH/COOR APP ANAPOLIS E ACC BRASILIA ACONTECERA CENTRO COORD 030220S/0600246W (ANAPOLIS, GO) RAIO 12KM RTO";

        System.out.println(description);

        CoordenateTools coordenateTools = new CoordenateTools(description);
        System.out.println(coordenateTools.isSecondPattern());
        System.out.println(coordenateTools.getDmsString());
    };
}
