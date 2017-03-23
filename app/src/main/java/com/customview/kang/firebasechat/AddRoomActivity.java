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

public class AddRoomActivity extends AppCompatActivity {

    EditText editRoomName;
    Button btnAddRoom;

    FirebaseDatabase database;
    DatabaseReference roomRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);

        editRoomName = (EditText)findViewById(R.id.editRoomName);
        btnAddRoom = (Button)findViewById(R.id.btnAddRoom);

        database = FirebaseDatabase.getInstance();
        roomRef = database.getReference("room");

        btnAddRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roomName = editRoomName.getText().toString();
                //String roomKey = roomRef.push().getKey();

                DatabaseReference msgRef = roomRef;

                Map<String, Object> msgMap = new HashMap<>();
                msgMap.put(roomName,roomName);

                msgRef.updateChildren(msgMap);

                finish();
            }
        });
    }
}
