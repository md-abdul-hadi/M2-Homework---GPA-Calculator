package com.example.gpa_abdul_calculator

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.gpa_abdul_calculator.ui.theme.GPA_Abdul_CalculatorTheme



class MainActivity<Button : View?> : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(/* savedInstanceState = */ savedInstanceState)
        setContentView(R.layout.activity_main)


        // Accessing views using their IDs
        val computeButton = findViewById<Button>(R.id.computeGpaButton)
        val gpaResult = findViewById<TextView>(R.id.gpaResult)
        val course1Grade = findViewById<EditText>(R.id.course1Grade)
        val course2Grade = findViewById<EditText>(R.id.course2Grade)
        val course3Grade = findViewById<EditText>(R.id.course3Grade)
        val course4Grade = findViewById<EditText>(R.id.course4Grade)
        val course5Grade = findViewById<EditText>(R.id.course5Grade)
        val rootView = findViewById<View>(android.R.id.content)

        // Setting OnClickListener on Compute GPA button
        if (computeButton != null) {
            computeButton.setOnClickListener {
                // Validating if all fields are filled
                if (course1Grade.text.toString().isEmpty() ||
                    course2Grade.text.toString().isEmpty() ||
                    course3Grade.text.toString().isEmpty() ||
                    course4Grade.text.toString().isEmpty() ||
                    course5Grade.text.toString().isEmpty()) {
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Parsing input grades to numbers
                val grade1 = course1Grade.text.toString().toFloat()
                val grade2 = course2Grade.text.toString().toFloat()
                val grade3 = course3Grade.text.toString().toFloat()
                val grade4 = course4Grade.text.toString().toFloat()
                val grade5 = course5Grade.text.toString().toFloat()

                // Calculating GPA
                val totalGrades = grade1 + grade2 + grade3 + grade4 + grade5
                val gpa = totalGrades / 5

                // Displaying GPA
                gpaResult.text = String.format("GPA: %.2f", gpa)

                // Changing background color based on GPA value
                when {
                    gpa < 60 -> rootView.setBackgroundColor(Color.RED)
                    gpa < 80 -> rootView.setBackgroundColor(Color.YELLOW)
                    else -> rootView.setBackgroundColor(Color.GREEN)
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GPA_Abdul_CalculatorTheme {
        Greeting("Android")
    }
}