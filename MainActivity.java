package com.example.exp10;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // creating variables for our edittext, button and dbhandler
    private EditText nameEdt, rollNumberEdt, branchEdt, emailEdt, cgpaEdt;
    private Button addUserBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        nameEdt = findViewById(R.id.idEdtName);
        rollNumberEdt = findViewById(R.id.idEdtRollNumber);
        branchEdt = findViewById(R.id.idEdtBranch);
        emailEdt = findViewById(R.id.idEdtEmail);
        cgpaEdt = findViewById(R.id.idEdtCGPA);
        addUserBtn = findViewById(R.id.idBtnAddUser);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add user button.
        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // below line is to get data from all edit text fields.
                String userName = nameEdt.getText().toString();
                String userRollNumber = rollNumberEdt.getText().toString();
                String userBranch = branchEdt.getText().toString();
                String userEmail = emailEdt.getText().toString();
                String userCGPA = cgpaEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (userName.isEmpty() || userRollNumber.isEmpty() || userBranch.isEmpty() || userEmail.isEmpty() || userCGPA.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // user to sqlite data and pass all our values to it.
                dbHandler.addNewUser(userName, userRollNumber, userBranch, userEmail, userCGPA);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "User has been added.", Toast.LENGTH_SHORT).show();
                nameEdt.setText("");
                rollNumberEdt.setText("");
                branchEdt.setText("");
                emailEdt.setText("");
                cgpaEdt.setText("");
            }
        });
    }
}
