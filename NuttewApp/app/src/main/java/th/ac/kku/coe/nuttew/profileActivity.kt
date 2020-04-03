package th.ac.kku.coe.nuttew

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class profileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val sp : SharedPreferences = getSharedPreferences("Username", Context.MODE_PRIVATE)

        val atprofile : TextView = findViewById(R.id.username_profile)
        atprofile.text = getString(R.string.username_profile)+sp.getString("myUsername","")
        val profile : TextView = findViewById(R.id.text_name_profile)
        profile.text =  sp.getString("myUsername","")

    }

    fun gotosetting(view : View){
        val intent = Intent(this,
            settingActivity::class.java).apply {

        }
        startActivity(intent);
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
