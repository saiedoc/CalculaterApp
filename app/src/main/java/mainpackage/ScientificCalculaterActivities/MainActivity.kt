package mainpackage.ScientificCalculaterActivities

import ScientificCalculaterClasses.Calculater
import ScientificCalculaterClasses.ExpressionDAO
import ScientificCalculaterClasses.ExpressionDatabase
import ScientificCalculaterClasses.myExpression
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.room.Room
import java.time.LocalDate


class MainActivity : AppCompatActivity() {

    private lateinit var db : ExpressionDatabase

    private lateinit var expressionDao : ExpressionDAO

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
    lateinit var numpadDot : Button
    lateinit var numpadClear : Button
    lateinit var numpadEqual : Button
    lateinit var moreButton : Button
    lateinit var histButton : Button
    lateinit var calcResultText : EditText
    var moreButtonClicked : Boolean = false
    lateinit var context : Context

    // function that setups room database

    private fun setupDatabase() {

        db = Room.databaseBuilder(
                this,
                ExpressionDatabase::class.java, "expressionDatabase"
        ).allowMainThreadQueries().build()

        expressionDao = db.expressionDao()

    }


    // function that find the views of the layout
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
        numpadDot = findViewById(R.id.dot)
        numpadButtons.add(numpadDot)
        numpadButtons.add(numpadDivideOrLog)
        numpadClear = findViewById(R.id.numpadClear)
        numpadDelete = findViewById(R.id.delete)
        numpadEqual = findViewById(R.id.numpadEqual)
        moreButton = findViewById(R.id.moreButton)
        histButton = findViewById(R.id.histButton)
        calcResultText = findViewById(R.id.calcResult)

    }


    // Function which appends to calculation text according to user input

    private fun appendCalculaterText(buttonText : String){

        var oldString : String = calcResultText.getText().toString()

        if(buttonText.equals("SIN")
                ||buttonText.equals("COS")
                ||buttonText.equals("LOG"))
        {
            var newString : String = oldString + buttonText.toLowerCase() + "("
            calcResultText.setText(newString)
        }
        else if(buttonText.equals("√")){
            var newString : String = oldString + "sqrt("
            calcResultText.setText(newString)
        }
        else{
        var newString : String = oldString + buttonText.toLowerCase()
        calcResultText.setText(newString)
        }

    }

    // Function that deletes from calculation text when user clicks delete

    private fun deleteCalculaterText() {

        if (calcResultText.getText().isNotEmpty()) {
            if (calcResultText.getText().toString().last().toLowerCase() == 'N'.toLowerCase()
                    || calcResultText.getText().toString().last().toLowerCase() == 'S'.toLowerCase()
                    || calcResultText.getText().toString().last().toLowerCase() == 'G'.toLowerCase()
            ) {
                var newString: String = calcResultText.getText().toString().dropLast(3)
                calcResultText.setText(newString)
            } else {
                var newString: String = calcResultText.getText().toString().dropLast(1)
                calcResultText.setText(newString)
            }
        }

    }




    //Function that applies Alpha animation on calcResultText EditText

    private fun applyAlphaAnimationOnResultText(newText: String) : AlphaAnimation {
        val anim = AlphaAnimation(1.0f, 0.0f)
        anim.duration = 100
        anim.repeatCount = 1
        anim.repeatMode = Animation.REVERSE

        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation?) { }
            override fun onAnimationStart(animation: Animation?) { }
            override fun onAnimationRepeat(animation: Animation?) {
                calcResultText.setText(newText)
            }
        })

        return anim
    }



    //Function that clears the calculation text when user clicks C

    private fun clearCalculaterText(){

        calcResultText.startAnimation(applyAlphaAnimationOnResultText(""))

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

                    moreButton.setText(R.string.StringMore)
                    numpadDivideOrLog.setTextSize(14f)
                    numpadDivideOrLog.setText(R.string.StringDivide)
                    numpadMultiplyOrSqrt.setText(R.string.StringMultiply)
                    numpadAddOrSin.setTextSize(14f)
                    numpadAddOrSin.setText(R.string.StringAdd)
                    numpadSubtractOrCos.setTextSize(14f)
                    numpadSubtractOrCos.setText(R.string.StringSubtract)
                    moreButtonClicked = false

                }else{

                    moreButton.setText(R.string.StringBack)
                    numpadDivideOrLog.setTextSize(9f)
                    numpadDivideOrLog.setText(R.string.StringLOG)
                    numpadMultiplyOrSqrt.setText(R.string.StringSQRT)
                    numpadAddOrSin.setTextSize(9f)
                    numpadAddOrSin.setText(R.string.StringSIN)
                    numpadSubtractOrCos.setTextSize(9f)
                    numpadSubtractOrCos.setText(R.string.StringCOS)
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

        numpadEqual.setOnClickListener(object : View.OnClickListener {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onClick(view: View?) {
                var resultString : String = Calculater.getExpressionResult(calcResultText.getText().toString())
                if(resultString != "Wrong format."){
                var myExp : myExpression = myExpression(expressionString = calcResultText.getText().toString(),resultString = resultString, calculationDate = LocalDate.now().toString())
                expressionDao.insertExpression(myExp)}
                calcResultText.startAnimation(applyAlphaAnimationOnResultText(resultString))
            }

        })

        histButton.setOnClickListener(object : View.OnClickListener {

            override fun onClick(view: View?){
                val switchActivityIntent = Intent(this@MainActivity,ExpressionListActivity::class.java)
                startActivity(switchActivityIntent)
            }
        })

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        context = this
        findViews()
        setupDatabase()
        setupOnClickListeners()
    }
}
