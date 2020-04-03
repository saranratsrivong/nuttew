package th.ac.kku.coe.nuttew

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

data class Infouser(
    var username : String? ="",
    var kkumail : String? = "",
    var ID : String? = "",
    var pass : String? = ""

)

class registerActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //val textmail : EditText = findViewById(R.id.editText2)
        val username : EditText = findViewById(R.id.editText_username)
        val textmail : EditText = findViewById(R.id.editText_email)
        val idnumner : EditText = findViewById(R.id.editText_id)
        val password : EditText = findViewById(R.id.editText_password)
        val confirmpassword : EditText = findViewById(R.id.editText_confirmPassword)

        val name = intent.getStringExtra("kkumail")


        if(name != null){
            textmail.setText(name)
        }


        val register : Button = findViewById(R.id.signup)


        register.setOnClickListener { view ->

            signupClick()
        }

    }


    

    private fun signupClick(){
        val mRootRef : DatabaseReference = FirebaseDatabase.getInstance().getReference()

        val informationuser : DatabaseReference = mRootRef.child("information")

        val username : EditText = findViewById(R.id.editText_username)
        val textmail : EditText = findViewById(R.id.editText_email)
        val idnumner : EditText = findViewById(R.id.editText_id)
        val password : EditText = findViewById(R.id.editText_password)
        val confirmpassword : EditText = findViewById(R.id.editText_confirmPassword)


        val sp : SharedPreferences = getSharedPreferences("Username",Context.MODE_PRIVATE)
        val editor1 : SharedPreferences.Editor = sp.edit()
        editor1.clear()
        editor1.putString("myUsername",username.text.toString())
        editor1.commit()



        val infouser = Infouser(username.text.toString(),textmail.text.toString(),idnumner.text.toString(),password.text.toString())
        informationuser.push().setValue(infouser)



        val intent = Intent(this,homeActivity::class.java)
        startActivity(intent)
    }
}
