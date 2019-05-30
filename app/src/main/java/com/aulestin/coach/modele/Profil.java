package com.aulestin.coach.modele;

/**
 * Created by Aulestin on 30/05/2019
 */
public class Profil {

    public static final Integer minFemme = 15; // maigre si en dessous
    public static final Integer maxFemme = 30; // gros si au dessus
    public static final Integer minHomme = 10; // maigre si en dessous
    public static final Integer maxHomme = 25; // gros si au dessus

    // propriétés
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float img;
    private String message;

    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.calculImg();
        this.resultIMG();
    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public float getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }

    private void calculImg (){
        float tailleEnMetre = (float)taille/100;
        this.img = (float) (((1.2*poids) / (tailleEnMetre*tailleEnMetre)) + (0.23*age) - (10.83*sexe) - 5.4);
        }

        private void resultIMG() {
        Integer min;
        Integer max;

        if (sexe==0){ // c'est une femme
            min = minFemme;
            max = maxFemme;
        } else {      // c'est un homme
            min = minHomme;
            max = maxHomme;
        }
        // message correspondant
            message = "Normal";
            if (img<min){
                message = "Trop faible";
        } else {
                if (img>max) {
                    message = "Trop élevé";
                }
            }
        }

}
