package com.example.actividad3;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private EditText dataEditText;
    private ListView shoppingListView;
    private ArrayList<String> shoppingList;
    private ArrayAdapter<String> shoppingListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dataEditText = findViewById(R.id.dataEditText);
        shoppingListView = findViewById(R.id.shoppingListView);


        shoppingList = new ArrayList<>();
        shoppingListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shoppingList);
        shoppingListView.setAdapter(shoppingListAdapter);

        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newItem = dataEditText.getText().toString();
                if (!newItem.isEmpty()) {
                    shoppingList.add(newItem);
                    shoppingListAdapter.notifyDataSetChanged(); // Notificar al adaptador que se han agregado nuevos datos
                    dataEditText.setText(""); // Limpiar el EditText
                }
            }
        });
    }
}






