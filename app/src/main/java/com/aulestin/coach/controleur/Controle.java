package com.aulestin.coach.controleur;

import com.aulestin.coach.modele.Profil;

/**
 * Created by Aulestin on 30/05/2019
 */
public final class Controle {

    private static Controle instance = null ;
    private Profil mProfil;

    /**
     * constructeur privé
     */
    private Controle (){
        super();
    }

    /**
     * Création de l'instance
     * @return instance
     */
    public static final Controle getInstance(){
        if (Controle.instance == null) {
            Controle.instance = new Controle();
        }
        return Controle.instance;
    }

    /**
     * Création du profil
     * @param poids en kg
     * @param taille en cm
     * @param age
     * @param sexe O pour femme 1 pour homme
     */
    public void creerProfil (Integer poids, Integer taille, Integer age, Integer sexe) {
        mProfil = new Profil(poids, taille, age, sexe);
    }

    /**
     * récupération img de Profil
     * @return img
     */
    public float getIMG(){
        return mProfil.getImg();
    }

    /**
     * récupération message de profil
     * @return message
     */
    public String getMessage(){
        return mProfil.getMessage();
    }

}
