package th.ac.kku.coe.nuttew

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth



class logoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        auth = FirebaseAuth.getInstance()
    }



    private lateinit var auth: FirebaseAuth

    private lateinit var googleSignInClient: GoogleSignInClient


    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser




        if(currentUser != null){



            Handler().postDelayed({
                val intent = Intent(this,
                    homeActivity::class.java).apply {
                }

                startActivity(intent)
            }, 2500)

        }
        else {
            Handler().postDelayed({
                val intent = Intent(this,
                    loginActivity::class.java).apply {
                }

                startActivity(intent)
            }, 2500)

        }

    }

    companion object{
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }
}
