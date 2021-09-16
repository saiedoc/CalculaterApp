package ScientificCalculaterClasses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
@Entity
data class myExpression(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "expression_id") val expression_id: Int,
        @ColumnInfo(name = "expression") val expressionString: String?,
        @ColumnInfo(name = "result") val resultString: String?,
        @ColumnInfo(name = "calculation_date") val calculationDate : String?

) {
        constructor(expressionString: String, resultString: String, calculationDate: String) : this(0,expressionString,resultString,calculationDate)
}