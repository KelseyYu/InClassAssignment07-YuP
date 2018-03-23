package com.example.mac.inclassassignment07_yup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SecondActivity extends AppCompatActivity {
    Animal animal = new Animal("name","kind",2,true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        final RadioGroup radioGroup =(RadioGroup) findViewById(R.id.m_radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged (RadioGroup group, int checkedId){
                switch (checkedId){
                    case R.id.mammal_radio_button:
                        animal.setKind("Mammal");
                        break;

                    case R.id.nonmammal_radio_button:
                        animal.setKind("Non-mammal");
                        break;
                }

            }
        });

        Button submitButton = (Button)findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener (){

            public void onClick(View view) {
                //Name EditText
                EditText name = (EditText) findViewById(R.id.animal_edit_text);
                animal.setAnimalName(name.getText().toString()) ;


                //hasFur checkbox
                CheckBox checkbox = findViewById(R.id.has_fur);
                if (checkbox.isChecked()) {
                    animal.setHasFur(true);
                } else {
                    animal.setHasFur(false);
                }

                Intent intent = new Intent();
                intent.putExtra(Keys.ANIMAL, animal);
                setResult(RESULT_OK,intent);
                finish();
            }


        });


    }


}
