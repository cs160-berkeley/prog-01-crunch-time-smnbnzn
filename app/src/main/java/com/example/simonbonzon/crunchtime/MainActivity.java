package com.example.simonbonzon.crunchtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;
import java.lang.*;


public class MainActivity extends AppCompatActivity {

    EditText calories;
    EditText pushups;
    EditText situps;
    EditText jumpingJacks;
    EditText jogging;
    EditText squats;
    EditText legLift;
    EditText plank;
    EditText pullups;
    EditText cycling;
    EditText walking;
    EditText swimming;
    EditText stairClimbing;
    double caloriesPerPushup = (double) 100/350;
    double caloriesPerSitup = (double) 100/200;
    double caloriesPerJumpingJack = (double) 100/10;
    double caloriesPerJogging = (double) 100/12;
    double caloriesPerSquat = (double) 100/225;
    double caloriesPerLegLift = (double) 100/25;
    double caloriesPerPlank = (double) 100/25;
    double caloriesPerPullup = (double) 100/100;
    double caloriesPerCycling = (double) 100/12;
    double caloriesPerWalking = (double) 100/20;
    double caloriesPerSwimming = (double) 100/13;
    double caloriesPerStairClimbing = (double) 100/15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pushups = (EditText) findViewById(R.id.pushupsEditText);
        situps = (EditText) findViewById(R.id.situpsEditText);
        jumpingJacks = (EditText) findViewById(R.id.jumpingJacksEditText);
        jogging = (EditText) findViewById(R.id.joggingEditText);
        calories = (EditText) findViewById(R.id.caloriesEditText);
        calories.setOnEditorActionListener(caloriesListener);
        pushups.setOnEditorActionListener(exerciseListener);
        situps.setOnEditorActionListener(exerciseListener);
        jumpingJacks.setOnEditorActionListener(exerciseListener);
        jogging.setOnEditorActionListener(exerciseListener);
        squats = (EditText) findViewById(R.id.squatsEditText);
        squats.setOnEditorActionListener(exerciseListener);
        legLift = (EditText) findViewById(R.id.legLiftEditText);
        legLift.setOnEditorActionListener(exerciseListener);
        plank = (EditText) findViewById(R.id.plankEditText);
        plank.setOnEditorActionListener(exerciseListener);
        pullups = (EditText) findViewById(R.id.pullupsEditText);
        pullups.setOnEditorActionListener(exerciseListener);
        cycling = (EditText) findViewById(R.id.cyclingEditText);
        cycling.setOnEditorActionListener(exerciseListener);
        walking = (EditText) findViewById(R.id.walkingEditText);
        walking.setOnEditorActionListener(exerciseListener);
        swimming = (EditText) findViewById(R.id.swimmingEditText);
        swimming.setOnEditorActionListener(exerciseListener);
        stairClimbing = (EditText)findViewById(R.id.stairClimbingEditText);
        stairClimbing.setOnEditorActionListener(exerciseListener);
    }

    public void updateExercises(double d) {
        Double pushupsDouble = d/caloriesPerPushup;
        pushups.setText(String.format("%d", pushupsDouble.intValue()));

        Double situpsDouble = d/caloriesPerSitup;
        situps.setText(String.format("%d", situpsDouble.intValue()));

        Double jumpingJacksDouble = d/caloriesPerJumpingJack;
        jumpingJacks.setText(String.format("%d", jumpingJacksDouble.intValue()));

        Double joggingDouble = d/caloriesPerJogging;
        jogging.setText(String.format("%d", joggingDouble.intValue()));

        Double squatsDouble = d/caloriesPerSquat;
        squats.setText(String.format("%d", squatsDouble.intValue()));

        Double legLiftDouble = d/caloriesPerLegLift;
        legLift.setText(String.format("%d", legLiftDouble.intValue()));

        Double plankDouble = d/caloriesPerPlank;
        plank.setText(String.format("%d", plankDouble.intValue()));

        Double pullupsDouble = d/caloriesPerPullup;
        pullups.setText(String.format("%d", pullupsDouble.intValue()));

        Double cyclingDouble = d/caloriesPerCycling;
        cycling.setText(String.format("%d", cyclingDouble.intValue()));

        Double walkingDouble = d/caloriesPerWalking;
        walking.setText(String.format("%d", walkingDouble.intValue()));

        Double swimmingDouble = d/caloriesPerSwimming;
        swimming.setText(String.format("%d", swimmingDouble.intValue()));

        Double stairClimbingDouble = d/caloriesPerStairClimbing;
        stairClimbing.setText(String.format("%d", stairClimbingDouble.intValue()));
    }

    public void updateCalories(double d) {
        Double i = d;
        calories.setText(String.format("%d", i.intValue()));
        updateExercises(d);
    }

    TextView.OnEditorActionListener caloriesListener = new TextView.OnEditorActionListener() {
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                CharSequence cals = v.getText();
                String calsString = cals.toString();
                if (calsString.equals("")) {
                    calsString = "0";
                    calories.setText(calsString);
                }
                double d = Double.parseDouble(calsString);
                updateExercises(d);
                handled = true;
            }
            return handled;
        }
    };

    TextView.OnEditorActionListener exerciseListener = new TextView.OnEditorActionListener() {
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                CharSequence exerciseNumber = v.getText();
                String exerciseNumberString = exerciseNumber.toString();
                if (exerciseNumberString.equals("")) {
                    exerciseNumberString = "0";
                }
                double exerciseDouble = Double.parseDouble(exerciseNumberString);
                double d = 0;
                switch (v.getId()) {
                    case R.id.pushupsEditText: d = exerciseDouble*caloriesPerPushup;
                        break;
                    case R.id.situpsEditText: d = exerciseDouble*caloriesPerSitup;
                        break;
                    case R.id.jumpingJacksEditText: d = exerciseDouble*caloriesPerJumpingJack;
                        break;
                    case R.id.joggingEditText: d = exerciseDouble*caloriesPerJogging;
                        break;
                    case R.id.squatsEditText: d = exerciseDouble*caloriesPerSquat;
                        break;
                    case R.id.legLiftEditText: d = exerciseDouble*caloriesPerLegLift;
                        break;
                    case R.id.plankEditText: d = exerciseDouble*caloriesPerPlank;
                        break;
                    case R.id.pullupsEditText: d = exerciseDouble*caloriesPerPullup;
                        break;
                    case R.id.cyclingEditText: d = exerciseDouble*caloriesPerCycling;
                        break;
                    case R.id.walkingEditText: d = exerciseDouble*caloriesPerWalking;
                        break;
                    case R.id.swimmingEditText: d = exerciseDouble*caloriesPerSwimming;
                        break;
                    case R.id.stairClimbingEditText: d = exerciseDouble*caloriesPerStairClimbing;
                        break;
                }
                updateCalories(d);
                handled = true;
            }
            return handled;
        }
    };
}
