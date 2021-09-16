package ScientificCalculaterClasses

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(myExpression::class), version = 1)
abstract class ExpressionDatabase : RoomDatabase() {

    companion object {
        @Volatile private var instance: ExpressionDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
                ExpressionDatabase::class.java, "expressionDatabase")
                .build()
    }

    abstract fun expressionDao() : ExpressionDAO

}