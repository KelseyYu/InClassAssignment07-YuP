package com.example.mac.inclassassignment07_yup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton =(Button) findViewById(R.id.add_animal_button);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                addAnimal(this);
            }

        }) ;
    }

    public void addAnimal(View.OnClickListener view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, RequestCode.ADD_ANIMAL);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RequestCode.ADD_ANIMAL && resultCode == RESULT_OK) {
            Animal animal = (Animal) data.getSerializableExtra(Keys.ANIMAL);
            display(animal);
        }
    }
    protected void display(Animal animal){
        TextView textView = findViewById(R.id.display_text_view);
        textView.setText("Animal: " + animal.getAnimalName() +
                       "\nNumber of legs: " + animal.getLegs() +
                        "\nHas Fur? " + animal.hasFur() +
                        "\nKind: " + animal.getKind());
    }



}
