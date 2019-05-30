package com.aulestin.coach.vue;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.aulestin.coach.R;
import com.aulestin.coach.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.mControle = Controle.getInstance();
    }

    // Propriétés
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgBalance;
    private Controle mControle;

    /**
     * Initialisation des liens avec les objets graphiques
     */
    private void init(){
        txtPoids = (EditText)findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        txtAge = (EditText) findViewById(R.id.txtAge);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        lblIMG = (TextView) findViewById(R.id.lblIMG);
        imgBalance = (ImageView) findViewById(R.id.imgBalance);
        ecouteCalcul();
    }

    /**
     * Ecoute évènement sur bouton calcul
     */
    private void ecouteCalcul(){
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new Button.OnClickListener(){
            public void onClick (View v) {
                /** Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();*/
                Log.d("message", "** Clic ok sur le bouton calcul*******************");
                int poids = 0;
                int taille = 0;
                int age = 0;
                int sexe = 0;
                //  récupération des données saisies
                                try {
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                } catch (Exception e) {};
                if (rdHomme.isChecked()){
                    sexe=1;
                }
                //contrôle des données saisies
                if (poids==0 || taille==0 || age==0){
                    Toast.makeText(MainActivity.this, "Saisie incorrecte", Toast.LENGTH_SHORT).show();
                }else{
                    afficheResult(poids, taille,age,sexe);
                }
            }
        });
        }

    /**
     * affichage de l'IMG, du message et de l'image
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
        private void afficheResult(int poids, int taille, int age, int sexe){
            // création du profil et récupération des informations
            this.mControle.creerProfil(poids,taille,age,sexe);
            float img = this.mControle.getIMG();
            String message = this.mControle.getMessage();
            // Affichage
            if (message=="Normal"){
                imgBalance.setImageResource(R.drawable.normal);
                lblIMG.setTextColor(Color.GREEN);
            }else {
                lblIMG.setTextColor(Color.RED);
                if (message=="Trop faible") {
                    imgBalance.setImageResource(R.drawable.maigre);
                }else {
                    imgBalance.setImageResource(R.drawable.gros);
                }
            }
            lblIMG.setText(String.format("%.01f",img)+" : IMG "+message);
        }


}

