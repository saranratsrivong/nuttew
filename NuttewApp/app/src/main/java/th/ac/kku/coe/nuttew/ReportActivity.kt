package th.ac.kku.coe.nuttew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
    }

    fun friendPage(view: View) {
        val intent = Intent(this,
            requestFriendActivity::class.java).apply {

        }
        startActivity(intent);
    }

    fun chatPage(view: View) {
        val intent = Intent(this,
            chatActivity::class.java).apply {

        }
        startActivity(intent);
    }

    fun settingsPage(view: View) {
        val intent = Intent(this,
            settingActivity::class.java).apply {

        }
        startActivity(intent);
    }

    fun HomePage(view: View) {
        val intent = Intent(this,
            homeActivity::class.java).apply {

        }
        startActivity(intent);
    }
}
