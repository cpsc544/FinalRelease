//****************************************************************************
// File Name: MainPage
// Team Name:group 01
// Team Members: Stephanie Allen, Jose Barron, Emily Gutierrez-Alvarez, Jarrod Merryman
// Thomas Schroeder, and Christina Wade
// Class:CPSC 544-50
// Semester: Fall 2016
// Summary of Code in file: In this file you will find the business logic for the MainPage
// The business logic that is included here is for the exit button, sort button, help button, about
// us button, clear button, the user input text field, and the user output text field.
// ****************************************************************************

package cpsc544.stacksort;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.text.TextWatcher;


public class MainPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String titleMain = getString(R.string.titleMain); //takes the title from strings xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        setTitle(titleMain);                                // sets the title bar to a more

// *******************************************************************************************
// Below you will find variable definitions, and variable initializations
// ************************************************************************************

        ImageButton getHelp = (ImageButton) findViewById(R.id.helpBtn);         // defines the help button
        ImageButton getAbout = (ImageButton) findViewById(R.id.aboutButton);    // defines the about button
        Button exitApp = (Button) findViewById(R.id.exitButton);                // defines the exit button
        Button clearArray = (Button) findViewById(R.id.clearBtn);               // defines the clear button
        final Button getSort = (Button) findViewById(R.id.sortBtn);             // defines the sort button
        final EditText in;                                                      // initializes user input
        in = (EditText) findViewById(R.id.userInput);                           // defines the user input
        final TextView out;                                                     // initializes the output
        out = (TextView) findViewById(R.id.userOutput);                         // defines user output
        final int minLimit;                                                     // initializes the lower limit of array
        minLimit = 1;                                                           // value for minimum limit
        final Button sortingButton = (Button) findViewById(R.id.sortBtn);       // initializes sort button
        sortingButton.setEnabled(false);                                        // disables sort button

// *************************************************************************************************
// the textwatcher below is used to check to see when to disable the sort button as well as display
// the value that the user inputs back to the user.
// *************************************************************************************************
        in.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                out.setText(in.getText().toString());           // this is where the array is taken and show to the user
                                                                // as soon as the array is longer than minLimit the button is
                                                                // enabled
                boolean isReady =in.getText().toString().length()> minLimit;
                getSort.setEnabled(isReady);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
// ***********************************************************************************
// The following lines of code are for the clear button, it makes it so that the
// clear button sets the user input as well as the output to blank
// **********************************************************************************
        clearArray.setOnClickListener(new View.OnClickListener() {

            public void onClick(View kView) {
                out.setText("");
                in.setText("");
            }
        });
//***************************************************************************************
        // This is the exit button business logic, it closes the application
//***************************************************************************************

        exitApp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View lView) {
                finish();
                moveTaskToBack(true);
            }
        });


//***************************************************************************************
// the following lines of code are to make the help button take you to the help activity
//***************************************************************************************
        getHelp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View mView) {
                Intent help = new Intent(MainPage.this, Help.class);
                startActivity(help);
            }
        });
//****************************************************************************************
// The following lines of code are to make the about button take you to the about us page
//***************************************************************************************
        getAbout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View nView) {
                Intent about = new Intent(MainPage.this, AboutUSActivity.class);
                startActivity(about);
            }
        });


//****************************************************************************************
// Below is the business side logic of the sort button.  When the user clicks it the first thing
// the button does is clear the output area, following that it converts the value inputted into
// an int array.  It then takes the array and prints it to the user and then finally performs
// an insertion sort algorithm and displays the result of every iteration to the user
//***************************************************************************************

        sortingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String display = in.getText().toString();  // converts input from editText to String
                out.setText("");                           // this is to clear old entries
                int length = display.length();             // will be the length of the array
                int array[] = new int[length];             // this is to store the input string into
                String toSort = getString(R.string.firstOutput);

                /********** this for loop converts the string into an integer array ************/
                for (int count = 0; count < length; count++) {
                    array[count] = Integer.parseInt(display.substring(count, count + 1));
                }

// **************************************************************************
// The following few lines of code simply take the array that was inputted by
// the user and prints it out for the user.
// **************************************************************************
                out.append(toSort);                      // prints out "to sort array:"
                for(int count = 0; count < length; count++)
                    out.append( array[count] + " ");                // prints array
// ***************************************************************************
// The lines of code found below are the insertion sort
// ***************************************************************************

                for ( int count = 1; count < length; count++)               // this for loop goes through the
                {                                                           // whole unsorted array
                    int sorted = array[count];                              // initializes and identifies sorted
                    int index = count - 1;                                  // initializes and gives value to index
                    while ( (index > -1) && ( array[index] > sorted ) )     // compares a value to the next value
                    {
                        array[index + 1] = array[index];                    // if the value is less than initial value
                        index--;                                            // the values get swapped
                    }
                    array[index + 1]= sorted;                               // gives value to sorted array
                    out.append(getString(R.string.blankLine));              // goes to the next line before every printed value
                    for(int newCount= 0; newCount < length; newCount++)     // prints array value and a space between each value
                    {
                        out.append(array[newCount] + " ");
                    }
                }
            }
        });
    }
}



