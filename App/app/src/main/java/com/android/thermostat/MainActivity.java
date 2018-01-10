package com.android.thermostat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private static final int MINIMUM_TEMPERATURE = 18;
  private static final int MAXIMUM_TEMPERATURE = 30;


  private TextView temperatureDisplay;
  private Button plusButton;
  private Button minusButton;
  private Button resetButton;

  private int temperature;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // locate and label views
    temperatureDisplay = findViewById(R.id.temperature_value);
    plusButton = findViewById(R.id.button_add);
    minusButton = findViewById(R.id.button_minus);
    resetButton = findViewById(R.id.button_reset);

    // set minimum temperature & update text
    temperature = MINIMUM_TEMPERATURE;
    temperatureDisplay.setText(String.valueOf(temperature));

    // set click listeners
    plusButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        increaseTemperature();
      }
    });

    minusButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        decreaseTemperature();
      }
    });

    resetButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        resetTemperature();
      }
    });
  }

  private void increaseTemperature() {
    // if the current temperature is below the maximum temperature
    if (temperature < MAXIMUM_TEMPERATURE) {
      // increase temperature by 1
      temperature++;
    }
    // update the display
    temperatureDisplay.setText(String.valueOf(temperature));
  }

  private void decreaseTemperature() {
    // if the current temperature is above the minimum temperature
    if (temperature > MINIMUM_TEMPERATURE) {
      // decrease temperature by 1
      temperature--;
    }
    // update the display
    temperatureDisplay.setText(String.valueOf(temperature));
  }

  private void resetTemperature() {
    // reset the temperature value to the minimum temperature
    temperature = MINIMUM_TEMPERATURE;
    // update the display
    temperatureDisplay.setText(String.valueOf(temperature));
    // show a toast to inform user
    Toast.makeText(this, "Temperature Reset", Toast.LENGTH_SHORT).show();
  }
}
