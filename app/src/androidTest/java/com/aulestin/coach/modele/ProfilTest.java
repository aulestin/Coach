package com.aulestin.coach.modele;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aulestin on 30/05/2019
 */
public class ProfilTest {

    // création profil
    private Profil mProfil = new Profil(67,165,35,0);
    // résultat IMG
    private float img = (float)32.2;
    // message
    private String messaage = "Trop élevé";

    @Test
    public void getImg() {
        assertEquals(img, mProfil.getImg(),(float)0.1);
    }

    @Test
    public void getMessage() {
        assertEquals(messaage, mProfil.getMessage());
    }
}