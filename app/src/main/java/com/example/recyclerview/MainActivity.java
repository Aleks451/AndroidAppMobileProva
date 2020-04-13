package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemCllicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Button btnAdd;

    ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd=findViewById(R.id.btnList);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("Ann", "Johnson", "plane"));
                adapter.notifyDataSetChanged();

            }
        });

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        //layoutManager = new LinearLayoutManager(this);
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<>();
        people.add(new Person("WER", "Meow", "bus"));
        people.add(new Person("Men", "Sessa", "bus"));
        people.add(new Person("None", "NOMP", "plane"));
        people.add(new Person("Wont", "MOpr", "plane"));
        people.add(new Person("John", "Mnsi", "bus"));
        people.add(new Person("Can", "Mbh", "plane"));
        people.add(new Person("Beon", "Wert", "plane"));
        people.add(new Person("Won", "Qouhu", "bus"));
        people.add(new Person("John", "Don", "plane"));
        people.add(new Person("WER", "Meow", "bus"));
        people.add(new Person("Men", "Sessa", "bus"));
        people.add(new Person("None", "NOMP", "plane"));
        people.add(new Person("Wont", "MOpr", "plane"));
        people.add(new Person("John", "Mnsi", "bus"));
        people.add(new Person("Can", "Mbh", "plane"));
        people.add(new Person("Beon", "Wert", "plane"));
        people.add(new Person("Won", "Qouhu", "bus"));
        people.add(new Person("John", "Don", "plane"));
        people.add(new Person("WER", "Meow", "bus"));
        people.add(new Person("Men", "Sessa", "bus"));
        people.add(new Person("None", "NOMP", "plane"));
        people.add(new Person("Wont", "MOpr", "plane"));
        people.add(new Person("John", "Mnsi", "bus"));
        people.add(new Person("Can", "Mbh", "plane"));
        people.add(new Person("Beon", "Wert", "plane"));
        people.add(new Person("Won", "Qouhu", "bus"));

        adapter = new PersonAdapter(this, people);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Surname: " +people.get(index).getSurname(), Toast.LENGTH_SHORT).show();
    }
}
