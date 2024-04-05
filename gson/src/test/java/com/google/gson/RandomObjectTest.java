package com.google.gson;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomObjectTest {


    public class Voiture {
        private int nbPorte;
        private int nbPlaces;
        private Moteur moteur;
        public Voiture (int nbPorte, int nbPLace, Moteur moteur){
            this.nbPorte = nbPorte;
            this.nbPlaces = nbPLace;
            this.moteur = moteur;
        }
        public int getNbPlace(){
            return this.nbPlaces;
        }
        public int getNbPorte(){
            return this.nbPorte;
        }
        public Moteur getMoteur(){
            return this.moteur;
        }

    }

    @ToString
    public class Moteur {
        public Moteur(int chev){
            this.nbCheveaux = chev;
        }

        private int nbCheveaux;

        public int getNbCheveaux(){
            return this.nbCheveaux;
        }
    }

    @Test
    public void voitureTest(){
        Voiture v1 = new Voiture(2,5,new Moteur(100));
        Gson gson = new Gson();
        String json = gson.toJson(v1);
        Voiture v2 = gson.fromJson(json, Voiture.class);
        assertTrue(v1.getNbPorte()==v2.getNbPorte());
        assertTrue(v1.getNbPlace()==v2.getNbPlace());
        assertTrue(v1.getMoteur().getNbCheveaux() == v2.getMoteur().getNbCheveaux());
    }


}
