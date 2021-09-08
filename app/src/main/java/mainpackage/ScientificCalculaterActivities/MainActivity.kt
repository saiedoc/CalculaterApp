package mainpackage.ScientificCalculaterActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {


    lateinit var numpadButtons : MutableList<Button>
    lateinit var numpad0 : Button
    lateinit var numpad1 : Button
    lateinit var numpad2 : Button
    lateinit var numpad3 : Button
    lateinit var numpad4 : Button
    lateinit var numpad5 : Button
    lateinit var numpad6 : Button
    lateinit var numpad7 : Button
    lateinit var numpad8 : Button
    lateinit var numpad9 : Button
    lateinit var numpadDelete : Button
    lateinit var numpadLeftCloseBracket : Button
    lateinit var numpadRightCloseBracket : Button
    lateinit var numpadAddOrSin : Button
    lateinit var numpadSubtractOrCos : Button
    lateinit var numpadMultiplyOrSqrt : Button
    lateinit var numpadDivideOrLog : Button
    lateinit var numpadClear : Button
    lateinit var moreButton : Button
    lateinit var calcResultText : EditText
    var moreButtonClicked : Boolean = false

    private fun findViews(){

        numpadButtons = ArrayList<Button>()
        numpad0 = findViewById(R.id.numpad0)
        numpadButtons.add(numpad0)
        numpad1 = findViewById(R.id.numpad1)
        numpadButtons.add(numpad1)
        numpad2 = findViewById(R.id.numpad2)
        numpadButtons.add(numpad2)
        numpad3 = findViewById(R.id.numpad3)
        numpadButtons.add(numpad3)
        numpad4 = findViewById(R.id.numpad4)
        numpadButtons.add(numpad4)
        numpad5 = findViewById(R.id.numpad5)
        numpadButtons.add(numpad5)
        numpad6 = findViewById(R.id.numpad6)
        numpadButtons.add(numpad6)
        numpad7 = findViewById(R.id.numpad7)
        numpadButtons.add(numpad7)
        numpad8 = findViewById(R.id.numpad8)
        numpadButtons.add(numpad8)
        numpad9 = findViewById(R.id.numpad9)
        numpadButtons.add(numpad9)
        numpadLeftCloseBracket = findViewById(R.id.LeftCloseBracket)
        numpadButtons.add(numpadLeftCloseBracket)
        numpadRightCloseBracket = findViewById(R.id.RightCloseBracket)
        numpadButtons.add(numpadRightCloseBracket)
        numpadAddOrSin = findViewById(R.id.numpadAddOrSin)
        numpadButtons.add(numpadAddOrSin)
        numpadSubtractOrCos = findViewById(R.id.numpadSubtractOrCos)
        numpadButtons.add(numpadSubtractOrCos)
        numpadMultiplyOrSqrt = findViewById(R.id.numpadMultiplyOrSqrt)
        numpadButtons.add(numpadMultiplyOrSqrt)
        numpadDivideOrLog = findViewById(R.id.numpadDivideOrLog)
        numpadButtons.add(numpadDivideOrLog)
        numpadClear = findViewById(R.id.numpadClear)
        numpadDelete = findViewById(R.id.delete)
        moreButton = findViewById(R.id.moreButton)
        calcResultText = findViewById(R.id.calcResult)

    }


    // Function which appends to calculation text according to user input

    private fun appendCalculaterText(buttonText : String){

        var oldString : String = calcResultText.getText().toString()
        var newString : String = oldString + buttonText
        calcResultText.setText(newString)

    }

    // Function that deletes from calculation text when user clicks delete

    private fun deleteCalculaterText(){

        var newString : String = calcResultText.getText().toString().dropLast(1)
        calcResultText.setText(newString)

    }

    //Function that clears the calculation text when user clicks C

    private fun clearCalculaterText(){

        calcResultText.setText("")

    }

    // Function which sets click listeners for numpad buttons that appends to the calculation text.

    private fun setupOnClickListenersForNumpadButtons(button : Button){

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                appendCalculaterText(button.getText().toString())
            }

        })

    }

    //Function that sets click listeners for all buttons

    private fun setupOnClickListeners(){

        for(button in numpadButtons){

           setupOnClickListenersForNumpadButtons(button)

        }
        moreButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {

                if(moreButtonClicked){


                    numpadDivideOrLog.setTextSize(14f)
                    numpadDivideOrLog.setText("/")
                    numpadMultiplyOrSqrt.setText("X")
                    numpadAddOrSin.setTextSize(14f)
                    numpadAddOrSin.setText("+")
                    numpadSubtractOrCos.setTextSize(14f)
                    numpadSubtractOrCos.setText("-")
                    moreButtonClicked = false

                }else{

                    numpadDivideOrLog.setTextSize(9f)
                    numpadDivideOrLog.setText("LOG")
                    numpadMultiplyOrSqrt.setText("√")
                    numpadAddOrSin.setTextSize(9f)
                    numpadAddOrSin.setText("SIN")
                    numpadSubtractOrCos.setTextSize(9f)
                    numpadSubtractOrCos.setText("COS")
                    moreButtonClicked = true

                }

            }

        })
        numpadDelete.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                deleteCalculaterText()
            }
        })
        numpadClear.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                clearCalculaterText()
            }
        })

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        findViews()
        setupOnClickListeners()
    }
}
