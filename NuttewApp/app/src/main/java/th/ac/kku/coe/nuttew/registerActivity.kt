package th.ac.kku.coe.nuttew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_register.*

class registerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val textmail : EditText = findViewById(R.id.editText2)

        val name = intent.getStringExtra("Mail")

        textmail.setText(name)

        val register : Button = findViewById(R.id.signup)


        register.setOnClickListener { view ->

            signupClick()
        }

    }

    private fun signupClick(){
        val intent = Intent(this,homeActivity::class.java)
        startActivity(intent)
    }
}
