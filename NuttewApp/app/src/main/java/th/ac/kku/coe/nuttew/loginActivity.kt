package th.ac.kku.coe.nuttew

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.firebase.ui.auth.data.model.User
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import java.util.*


class loginActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }

    private lateinit var auth: FirebaseAuth

    private lateinit var googleSignInClient: GoogleSignInClient



// ...
// Initialize Firebase Auth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val gmailButton: ImageButton = findViewById(R.id.imageButton)

        val registerButton : Button = findViewById(R.id.button2)

        val loginuser : Button = findViewById(R.id.button)



        // Configure Google Sign In
        // Configure Google Sign In

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()




        googleSignInClient = GoogleSignIn.getClient(this, gso)


        loginuser.setOnClickListener { view ->

        }

        gmailButton.setOnClickListener{ view ->

            signInwithGmail()
        }

        registerButton.setOnClickListener { view ->

            registeruser()
        }

        auth = FirebaseAuth.getInstance()


        val database = Firebase.database
        val myRef = database.getReference("emailuser")




    }

    private fun signInwithGmail() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent,RC_SIGN_IN)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {


            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {

                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)

            } catch (e: ApiException) {

                Toast.makeText(this,"Fail1",Toast.LENGTH_LONG).show()

            }


        }
    }




    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {


        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)



        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val user = auth.currentUser


                    //Toast.makeText(this,acct.email,Toast.LENGTH_LONG).show()  //get email

                    val intent = Intent(this,registerActivity::class.java)
                    intent.putExtra("kkumail",acct.email.toString())
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this,"Fail",Toast.LENGTH_LONG).show()

                }

                // ...
            }
    }


    public override fun onStart() {
        super.onStart()
        /*
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser

        if(currentUser != null ){
            val intent = Intent(this,
                homeActivity::class.java).apply {

            }
            startActivity(intent)
        }*/
    }




    private fun registeruser(){

        val intent = Intent(this,registerActivity::class.java)
        startActivity(intent)

    }


}
