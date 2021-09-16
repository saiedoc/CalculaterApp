package mainpackage.ScientificCalculaterActivities
import ScientificCalculaterClasses.myExpression
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpressionListAdapter(private val mList: ArrayList<myExpression>) : RecyclerView.Adapter<ExpressionListAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.single_expression, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.expressionText.setText(ItemsViewModel.expressionString)
        holder.expressionResult.setText(ItemsViewModel.resultString)
        holder.expressionDate.setText(ItemsViewModel.calculationDate.toString())

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val expressionText : TextView = itemView.findViewById(R.id.expressionText)
        val expressionResult : TextView = itemView.findViewById(R.id.resultText)
        val expressionDate : TextView = itemView.findViewById(R.id.expressionDate)
    }
}