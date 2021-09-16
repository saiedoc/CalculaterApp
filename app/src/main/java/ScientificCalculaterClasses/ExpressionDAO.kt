package ScientificCalculaterClasses

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExpressionDAO {

    @Query("SELECT * FROM myExpression")
    fun getExpressions(): List<myExpression>

    @Insert
    fun insertExpression(myExpression: myExpression)

    @Delete
    fun deleteExpression(myExpression: myExpression)


}