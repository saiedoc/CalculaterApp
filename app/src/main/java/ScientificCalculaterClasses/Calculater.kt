package ScientificCalculaterClasses
import android.content.Context
import androidx.room.Room
import net.objecthunter.exp4j.*


class Calculater {



    companion object {

        // function that evaluates the expression and returns the result
        fun getExpressionResult(rawExpressionString: String): String {

            var expressionString: String = rawExpressionString.replace("x", "*")


            try {
                var expression: Expression = ExpressionBuilder(expressionString).build()
                var result: Double = expression.evaluate()
                return result.toString()
            } catch (e: Exception) {
                return "Wrong format."
            }
        }

    }


}