package com.example.android.volleyballscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    int pointsTeamA = 0;
    int pointsTeamB = 0;
    int setsTeamA = 0;
    int setsTeamB = 0;
    String middleScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Save current values when rotating screen
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(valueOf(pointsTeamA), pointsTeamA);
        savedInstanceState.putInt(valueOf(pointsTeamB), pointsTeamB);
        savedInstanceState.putInt(valueOf(setsTeamA), setsTeamA);
        savedInstanceState.putInt(valueOf(setsTeamB), setsTeamB);
        savedInstanceState.putString(String.valueOf(middleScreen), middleScreen);

        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Restore current values when rotating screen
     */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
          super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        pointsTeamA = savedInstanceState.getInt(valueOf(pointsTeamA));
        pointsTeamB = savedInstanceState.getInt(valueOf(pointsTeamB));
        setsTeamA = savedInstanceState.getInt(valueOf(setsTeamA));
        setsTeamB = savedInstanceState.getInt(valueOf(setsTeamB));
        middleScreen = savedInstanceState.getString(String.valueOf(middleScreen));
    }

         /**
         * Increase the score for team A by 1 point
         */
    public void addOneForTeamA(View view) {
        pointsTeamA = pointsTeamA + 1;
        middleScreen = "Game in progress";
        displayPointsForTeamA(pointsTeamA);
        displayMiddleScreen(middleScreen);

        if (pointsTeamA >= 15 & pointsTeamA - pointsTeamB>=2) {
            finishGameTieA();
        }

        if (pointsTeamA >= 25 & pointsTeamA - pointsTeamB>=2) {
            finishGameNormalA();
        }
    }

    /**
     * Checks if the game is finished after team A gained 15th point
     */
    public void finishGameTieA() {
        if (setsTeamA + setsTeamB >= 4) {
            setsTeamA = 3;
            middleScreen = "Team A won the game";
            displaySetsForTeamA(setsTeamA);
            displayPointsForTeamA(pointsTeamA);
            displayMiddleScreen(middleScreen);

            //Disable buttons
            Button addPointsTeamA = (Button) findViewById(R.id.add_one_team_a);
            Button addPointsTeamB = (Button) findViewById(R.id.add_one_team_b);
            Button resetPoints = (Button) findViewById(R.id.reset_points);
            addPointsTeamA.setEnabled(false);
            addPointsTeamB.setEnabled(false);
            resetPoints.setEnabled(false);
        }
        else {
            displayPointsForTeamA(pointsTeamA);
        }
    }

    /**
     * Checks if the game is finished after team A gained 25th point
     */
    public void finishGameNormalA() {
        if (setsTeamA >= 2) {
            setsTeamA = 3;
            middleScreen = "Team A won the game";
            displaySetsForTeamA(setsTeamA);
            displayPointsForTeamA(pointsTeamA);
            displayMiddleScreen(middleScreen);

            //Disable buttons
            Button addPointsTeamA = (Button) findViewById(R.id.add_one_team_a);
            Button addPointsTeamB = (Button) findViewById(R.id.add_one_team_b);
            Button resetPoints = (Button) findViewById(R.id.reset_points);
            addPointsTeamA.setEnabled(false);
            addPointsTeamB.setEnabled(false);
            resetPoints.setEnabled(false);
        }
        else {
            setsTeamA = setsTeamA + 1;
            pointsTeamA = 0;
            pointsTeamB = 0;
            displaySetsForTeamA(setsTeamA);
            displayPointsForTeamA(pointsTeamA);
            displayPointsForTeamB(pointsTeamB);
        }
    }

    /**
     * Displays the given number of points for Team A.
     */
    public void displayPointsForTeamA(int pointsTeamA) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_points);
        scoreView.setText(valueOf(pointsTeamA));
    }

    /**
     * Displays the given number of sets for Team A.
     */
    public void displaySetsForTeamA(int setsTeamA) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_sets);
        scoreView.setText(valueOf(setsTeamA));
    }

    /**
     * Increase the score for team B by 1 point
     */
    public void addOneForTeamB(View view) {
        pointsTeamB = pointsTeamB + 1;
        middleScreen = "Game in progress";
        displayPointsForTeamB(pointsTeamB);
        displayMiddleScreen(middleScreen);

        if (pointsTeamB >= 15 & pointsTeamB - pointsTeamA>=2) {
            finishGameTieB();
        }

        if (pointsTeamB >= 25 & pointsTeamB - pointsTeamA>=2) {
            finishGameNormalB();
        }
    }

    /**
     * Checks if the game is finished after team B gained 15th point
     */
    private void finishGameTieB() {
        if (setsTeamA + setsTeamB >= 4) {
            setsTeamB = 3;
            middleScreen = "Team B won the game";
            displaySetsForTeamB(setsTeamB);
            displayPointsForTeamB(pointsTeamB);
            displayMiddleScreen(middleScreen);

            //Disable buttons
            Button addPointsTeamA  = (Button) findViewById(R.id.add_one_team_a);
            Button addPointsTeamB = (Button) findViewById(R.id.add_one_team_b);
            Button resetPoints = (Button) findViewById(R.id.reset_points);
            addPointsTeamA.setEnabled(false);
            addPointsTeamB.setEnabled(false);
            resetPoints.setEnabled(false);
        }
        else {
            displayPointsForTeamB(pointsTeamB);
        }
    }

    /**
     * Checks if the game is finished after team B gained 25th point
     */
    public void finishGameNormalB() {
        if (setsTeamB >= 2) {
            setsTeamB = 3;
            middleScreen = "Team B won the game";
            displaySetsForTeamB(setsTeamB);
            displayPointsForTeamB(pointsTeamB);
            displayMiddleScreen(middleScreen);

            //Disable buttons
            Button addPointsTeamA = (Button) findViewById(R.id.add_one_team_a);
            Button addPointsTeamB = (Button) findViewById(R.id.add_one_team_b);
            Button resetPoints = (Button) findViewById(R.id.reset_points);
            addPointsTeamA .setEnabled(false);
            addPointsTeamB.setEnabled(false);
            resetPoints.setEnabled(false);
        }
        else {
            setsTeamB = setsTeamB + 1;
            pointsTeamA = 0;
            pointsTeamB = 0;
            displaySetsForTeamB(setsTeamB);
            displayPointsForTeamA(pointsTeamA);
            displayPointsForTeamB(pointsTeamB);
        }
    }

    /**
     * Displays the given number of points for Team B.
     */
    public void displayPointsForTeamB(int pointsTeamB) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_points);
        scoreView.setText(valueOf(pointsTeamB));
    }

    /**
     * Displays the given number of sets for Team B.
     */
    public void displaySetsForTeamB(int setsTeamB) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_sets);
        scoreView.setText(valueOf(setsTeamB));
    }

    /**
     * Displays the text in the middle of the screen.
     */
    public void displayMiddleScreen(String message) {
        TextView middleScreen;
        middleScreen = (TextView) findViewById(R.id.text_middle);
        middleScreen.setText(message);
    }

    /**
     * Resets points for both teams.
     */
    public void resetPoints(View view) {
        pointsTeamA = 0;
        pointsTeamB = 0;
        displayPointsForTeamA(pointsTeamA);
        displayPointsForTeamB(pointsTeamB);

        //Enable buttons back
        Button addPointsTeamA = (Button) findViewById(R.id.add_one_team_a);
        Button addPointsTeamB = (Button) findViewById(R.id.add_one_team_b);
        addPointsTeamA.setEnabled(true);
        addPointsTeamB.setEnabled(true);
    }

    /**
     * Resets all the scores for both teams.
     */
    public void resetAll(View view) {
        pointsTeamA = 0;
        pointsTeamB = 0;
        setsTeamA = 0;
        setsTeamB = 0;
        middleScreen = "Let\'s start the game!";
        displayPointsForTeamA(pointsTeamA);
        displayPointsForTeamB(pointsTeamB);
        displaySetsForTeamA(setsTeamA);
        displaySetsForTeamB(setsTeamB);
        displayMiddleScreen(middleScreen);

        //Enable buttons back
        Button addPointsTeamA = (Button) findViewById(R.id.add_one_team_a);
        Button addPointsTeamB = (Button) findViewById(R.id.add_one_team_b);
        Button resetPoints = (Button) findViewById(R.id.reset_points);
        addPointsTeamA.setEnabled(true);
        addPointsTeamB.setEnabled(true);
        resetPoints.setEnabled(true);
    }
}
