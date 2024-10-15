package com.example.assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText emt_password,confirm_password,mail_id,username;
    CheckBox box;
    Button account_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        emt_password=findViewById(R.id.emt_password);
        confirm_password=findViewById(R.id.confirm_password);
        mail_id=findViewById(R.id.mail_id);
        username=findViewById(R.id.username);
        box=findViewById(R.id.box);
        account_button=findViewById(R.id.account_button);
        account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void checkCredentials() {
        String inputusername=username.getText().toString();
        String inputmail_id=mail_id.getText().toString();
        String inputemt_password=emt_password.getText().toString();
        String inputconfirm_password=confirm_password.getText().toString();
        boolean right=box.isChecked();
        if(inputusername.isEmpty()){
            showError(username,"Enter username");
        } else if (!inputmail_id.contains("@gmail.com")) {
            showError(mail_id,"Email id is not valid");
        } else if (inputemt_password.isEmpty()) {
            showError(emt_password,"Enter password");

        } else if (inputconfirm_password.isEmpty() || !inputconfirm_password.equals(inputemt_password)) {
            showError(confirm_password,"Password didnot match");

        } else if (!right) {
            Toast.makeText(this, "Accept terms and conditions", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show();
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}