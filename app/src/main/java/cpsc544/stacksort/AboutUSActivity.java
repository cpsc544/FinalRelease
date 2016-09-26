//****************************************************************************
// File Name: AboutUSActivity
// Team Name:group 01
// Team Members: Stephanie Allen, Jose Barron, Emily Gutierrez-Alvarez, Jarrod Merryman
// Thomas Schroeder, and Christina Wade
// Class:CPSC 544-50
// Semester: Fall 2016
// Summary of Code in file: In this file you will find the business logic for the AboutUsActivity
// What this page does is it takes the back button that is found on the AboutUSActivity and it
// assigns it the job of returning to MainPage activity
// ***************************************************************************


package cpsc544.stacksort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AboutUSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String titleBar = getString(R.string.titleBarAbout);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        setTitle(titleBar);                       // sets the title bar to a more
                                                                // appealing name

//**********************************************************************************
        // The following makes it so that the back button goes back to the main page
//**********************************************************************************
        Button getMain = (Button) findViewById(R.id.back_btn);              // button definition
        // business logic
        getMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View mView) {
                Intent main = new Intent(AboutUSActivity.this, MainPage.class);
                startActivity(main);
            }
        });
    }
}
