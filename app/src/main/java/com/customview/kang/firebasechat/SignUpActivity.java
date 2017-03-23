package com.customview.kang.firebasechat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    Button btnSignUp;
    EditText editId, editPw, editConfirm, editName;

    FirebaseDatabase database;
    DatabaseReference roomRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSignUp = (Button)findViewById(R.id.btnSignUp);
        editId = (EditText)findViewById(R.id.editId);
        editPw = (EditText)findViewById(R.id.editPw);
        editConfirm = (EditText)findViewById(R.id.editConfirm);
        editName = (EditText)findViewById(R.id.editName);

        btnSignUp.setOnClickListener(listener);

        database = FirebaseDatabase.getInstance();
        roomRef = database.getReference("user");
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String userid = editId.getText().toString();
            String userPw = editPw.getText().toString();
            String userName = editName.getText().toString();
            String userConfirm = editConfirm.getText().toString();

            DatabaseReference msgRef = roomRef;

            Map<String, String> msgMap = new HashMap<>();
            msgMap.put("name", userName);
            msgMap.put("password",userPw);

            Map<String, Object> keyMap = new HashMap<>();

            keyMap.put(userid , msgMap);

            msgRef.updateChildren(keyMap);

            finish();
        }
    };
}
