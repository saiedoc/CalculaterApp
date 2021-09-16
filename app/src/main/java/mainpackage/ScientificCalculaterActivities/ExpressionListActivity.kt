package mainpackage.ScientificCalculaterActivities

import ScientificCalculaterClasses.ExpressionDAO
import ScientificCalculaterClasses.ExpressionDatabase
import ScientificCalculaterClasses.myExpression
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class ExpressionListActivity : AppCompatActivity() {

    private var expressionList : ArrayList<myExpression> = ArrayList()
    private lateinit var expressionRecyclerView : RecyclerView
    private lateinit var expressionRecyclerAdapter : ExpressionListAdapter

    private lateinit var db : ExpressionDatabase

    private lateinit var expressionDao : ExpressionDAO


    // function that setups room database

    private fun setupDatabase() {

        db = Room.databaseBuilder(
                this,
                ExpressionDatabase::class.java, "expressionDatabase"
        ).allowMainThreadQueries().build()

        expressionDao = db.expressionDao()

    }


    // function that gets the expressions history from the room database
    private fun getData(){
        expressionList = expressionDao.getExpressions() as ArrayList<myExpression>
    }

    // function to find the views of the layout
    private fun findViews(){
        expressionRecyclerView = findViewById(R.id.recyclerView)
    }

    //function to setup the recyclerView
    private fun buildRecyclerView(){

        expressionRecyclerAdapter = ExpressionListAdapter(expressionList)
        expressionRecyclerView.setAdapter(expressionRecyclerAdapter)
        expressionRecyclerView.setLayoutManager(LinearLayoutManager(this))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expression_list)
        findViews()
        setupDatabase()
        getData()
        buildRecyclerView()

    }


}