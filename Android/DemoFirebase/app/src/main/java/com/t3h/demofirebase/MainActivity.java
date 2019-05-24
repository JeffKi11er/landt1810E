package com.t3h.demofirebase;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.t3h.demofirebase.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnSuccessListener<Void>, OnFailureListener, ValueEventListener, AdapterChat.ItemClickListener {

    private ActivityMainBinding binding;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference;
    private AdapterChat adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

        adapter = new AdapterChat(this);
        adapter.setListener(this);
        binding.lvChat.setAdapter(adapter);

        reference = database.getReference("Chat");
        reference.addValueEventListener(this);

        binding.imSend.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String msg = binding.edtMsg.getText().toString();
        if (msg.isEmpty()) {
            Toast.makeText(this, "Message must not empty",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        Chat chat = new Chat();
        chat.setMessage(msg);
        chat.setName("BacNV");
        reference.child(chat.getId() + "").setValue(chat)
                .addOnSuccessListener(this)
                .addOnFailureListener(this);
    }

    @Override
    public void onSuccess(Void aVoid) {
        Toast.makeText(this, "Successfully!",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(@NonNull Exception e) {
        Toast.makeText(this, e.getMessage(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        ArrayList<Chat> arr = new ArrayList<>();

        for (DataSnapshot data : dataSnapshot.getChildren()){
            Chat chat = data.getValue(Chat.class);
            arr.add(chat);
        }
        adapter.setData(arr);
        binding.lvChat.scrollToPosition(arr.size()-1);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }

    @Override
    public void onItemClick(Chat chat) {
        reference.child(chat.getId()+"").removeValue()
                .addOnFailureListener(this)
                .addOnSuccessListener(this);
    }
}
