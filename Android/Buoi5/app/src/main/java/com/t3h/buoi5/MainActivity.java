package com.t3h.buoi5;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FaceAdapter.FaceItemListener {
    private ArrayList<Face> data;
    private FaceAdapter adapter;
    private RecyclerView lvFace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initViews();
    }

    private void initViews() {
        lvFace = findViewById(R.id.lv_face);
        adapter = new FaceAdapter(this, data);
        lvFace.setAdapter(adapter);
        adapter.setListener(this);
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new Face(R.drawable.sad, "Sad"));
        data.add(new Face(R.drawable.boss, "Boss"));
        data.add(new Face(R.drawable.confuse, "Confuse"));
        data.add(new Face(R.drawable.love, "Love"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.sad, "Sad"));
        data.add(new Face(R.drawable.boss, "Boss"));
        data.add(new Face(R.drawable.confuse, "Confuse"));
        data.add(new Face(R.drawable.love, "Love"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.sad, "Sad"));
        data.add(new Face(R.drawable.boss, "Boss"));
        data.add(new Face(R.drawable.confuse, "Confuse"));
        data.add(new Face(R.drawable.love, "Love"));
        data.add(new Face(R.drawable.what, "What"));
    }

    @Override
    public void onClick(int position) {
        Snackbar.make(lvFace, data.get(position).getName()
                , Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onLongClick(final int position) {
        new AlertDialog.Builder(this)
                .setTitle("Delete")
                .setMessage("Do you want to delete")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        data.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setCancelable(false)
                .show();
    }
}
