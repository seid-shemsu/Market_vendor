package com.izhar.market.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.izhar.market.R;

public class Register extends AppCompatActivity {
    private EditText email, phone, password;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        register.setOnClickListener(v -> {
            if (isConnected()) {
                if (check()){
                    register(register);
                }
            }
            else {
                Snackbar.make(register, "Check your connection", BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });
    }

    private boolean check() {
        if (email.getText().toString().trim().isEmpty()) {
            email.setError("invalid email");
            return false;
        }
        if (password.getText().toString().trim().isEmpty()) {
            password.setError("empty password");
            return false;
        }
        String phone = this.phone.getText().toString();
        if (phone.length() != 13 || !phone.substring(0, 5).equalsIgnoreCase("+2519")) {
            this.phone.setError("invalid phone");
            return false;
        }
        return true;
    }


    public void login(View view) {
        startActivity(new Intent(this, Login.class));
        finish();
    }

    private void register(View view) {
        disableViews();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        DatabaseReference users = FirebaseDatabase.getInstance().getReference("users");
        auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnSuccessListener(authResult -> {
                    users.child(authResult.getUser().getUid()).child("phone").setValue(phone.getText().toString());
                    users.child(authResult.getUser().getUid()).child("password").setValue(password.getText().toString());
                    users.child(authResult.getUser().getUid()).child("email").setValue(email.getText().toString());
                    users.child(authResult.getUser().getUid()).child("uid").setValue(authResult.getUser().getUid());
                    users.child(authResult.getUser().getUid()).child("account_status").setValue("Not Active");
                    users.child(authResult.getUser().getUid()).child("expire_date").setValue("Not Set");
                    startActivity(new Intent(Register.this, Verify.class)
                            .putExtra("phone", phone.getText().toString()));
                    finish();
                })
                .addOnFailureListener(e -> {
                    enableViews();
                    Toast.makeText(Register.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                });

    }

    private void enableViews() {
        email.setEnabled(true);
        phone.setEnabled(true);
        password.setEnabled(true);
        register.setEnabled(true);
    }

    private void disableViews() {
        email.setEnabled(false);
        phone.setEnabled(false);
        password.setEnabled(false);
        register.setEnabled(false);
    }

    private boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
        int connected = 0;
        for (NetworkInfo networkInfo : info) {
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                connected = 1;
            }
        }
        return connected == 1;
    }
}