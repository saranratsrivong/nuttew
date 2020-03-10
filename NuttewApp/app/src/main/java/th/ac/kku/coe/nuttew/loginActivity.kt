package th.ac.kku.coe.nuttew

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth



class loginActivity : AppCompatActivity() {

    companion object{
        private const val RC_SIGN_IN = 123
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val gmailButton: ImageButton = findViewById(R.id.imageButton)

        val registerButton : Button = findViewById(R.id.button2)


        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()



        gmailButton.setOnClickListener{ view ->

            loginwithKKU()

        }

        registerButton.setOnClickListener { view ->

            registeruser()
        }

    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)


           // Toast.makeText(this,"RC_OK",Toast.LENGTH_LONG)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser

                Toast.makeText(this,"ok",Toast.LENGTH_LONG).show()
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
               // Toast.makeText(this,"fail",Toast.LENGTH_LONG).show()

                val intent = Intent(this,registerActivity::class.java)
                intent.putExtra("Mail","thaniya@kkumail.com")
                startActivity(intent)
            }
        }
    }



    private fun loginwithKKU()
    {

        val providers = arrayListOf(
            AuthUI.IdpConfig.GoogleBuilder().build()


        )

        startActivityForResult(
            AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).build(),
            RC_SIGN_IN
        )
    }

    private fun registeruser(){

        val intent = Intent(this,registerActivity::class.java)
        startActivity(intent)

    }


}
