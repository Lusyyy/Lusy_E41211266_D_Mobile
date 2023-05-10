package com.example.usingpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class succes extends AppCompatActivity {
Button back;
TextView tete;
SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes);
        sessionManager = new SessionManager(succes.this);

        // Cek apakah user sudah login atau belum
        if (!sessionManager.isLogin()) {
            // Jika belum login, pindahkan ke halaman login
           movetoLogin();
        }

        tete = findViewById(R.id.textView6);
        tete.setText("Selamat "+ sessionManager.getUserDetail().get(SessionManager.USERNAME) + "  berhasil login alhamdulillah");
        back = findViewById(R.id.logout);
 back.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         sessionManager.logoutSession();
         movetoLogin();

     }
 });


    }
    private void movetoLogin() {
        Intent intent = new Intent(succes.this, login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}