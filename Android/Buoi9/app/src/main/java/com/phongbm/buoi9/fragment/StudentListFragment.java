package com.phongbm.buoi9.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.phongbm.buoi9.AppDatabase;
import com.phongbm.buoi9.R;
import com.phongbm.buoi9.Student;
import com.phongbm.buoi9.adapter.StudentAdapter;

import java.util.List;

public class StudentListFragment extends BaseFragment implements View.OnClickListener {
    private RecyclerView lvStudent;
    private List<Student> data;
    private StudentAdapter adapter;
    private FloatingActionButton btnAdd;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_student;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvStudent = findViewById(R.id.lv_student);
        adapter = new StudentAdapter(getContext());
        lvStudent.setAdapter(adapter);
        getData();

        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);
    }

    public void getData() {
        data = AppDatabase.getInstance(getContext()).getStudentDao().getAll();
        adapter.setData(data);
    }

    @Override
    public void onClick(View v) {
        showEdit(null);
    }

    private void showEdit(Student student){
        getParent().getFmEditStudent().setStudent(student);
        getParent().showFragment(getParent()
                .getFmEditStudent());
    }
}
