//****************************************************************************
// File Name: AboutUSActivity
// Team Name:group 01
// Team Members: Stephanie Allen, Jose Barron, Emily Gutierrez-Alvarez, Jarrod Merryman
// Thomas Schroeder, and Christina Wade
// Class:CPSC 544-50
// Semester: Fall 2016
// Summary of Code in file: In this file you will find the business logic for the Help activity
// What this page does is it takes the back button that is found on the Help activity and it
// assigns it the job of returning to MainPage activity
// ****************************************************************************


package cpsc544.stacksort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Help extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String titleBarHelpPage = getString(R.string.titleBarHelpPage);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setTitle(titleBarHelpPage);                       // sets the title bar to a more

        Button getMain = (Button) findViewById(R.id.back_button);      //button definition
//*****************************************************************************************
// Below you will find the business logic for the back button found in Help activity
// What this button does is it takes you back to the MainPage
// ****************************************************************************************
        getMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View mView) {
                Intent main = new Intent(Help.this, MainPage.class);
                startActivity(main);
            }
        });
    }
}