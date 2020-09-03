package com.example.girishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    TextInputLayout regName,regUsername,regEmail,regPhoneNo,regPassword;
    Button regBtn,regLoginBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //hooks to all elemnet xml code se jo bhi id li bnayi gyi hai unko FID se lena java code
        regName=findViewById(R.id.name);
        regUsername=findViewById(R.id.username);
        regEmail=findViewById(R.id.email);
        regPhoneNo=findViewById(R.id.phoneNo);
        regPassword=findViewById(R.id.password);
        regBtn=findViewById(R.id.reg_btn);
        regLoginBtn=findViewById(R.id.login_screen);


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("users");
                // get all value from the text field

                String name =regName.getEditText().getText().toString();
                String username=regUsername.getEditText().getText().toString();
                String email=regEmail.getEditText().getText().toString();
                String phoneNo=regPhoneNo.getEditText().getText().toString();
                String password=regPassword.getEditText().getText().toString();

                UserHelperClass helperClass =new UserHelperClass(name,username,email,phoneNo,password);

                reference.child(phoneNo).setValue(helperClass);
            }
        });


    }
}