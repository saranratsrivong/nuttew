package th.ac.kku.coe.nuttew

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth



class settingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        auth = FirebaseAuth.getInstance()


    }


    private lateinit var auth: FirebaseAuth

    private lateinit var googleSignInClient: GoogleSignInClient

    private fun signOut() {
        // Firebase sign out
        auth.signOut()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        googleSignInClient.revokeAccess()


        val intent = Intent(this,
            loginActivity::class.java).apply {

        }
        startActivity(intent)

    }

    fun profilePage(view: View) {
        val intent = Intent(this,
            profileActivity::class.java).apply {

        }
        startActivity(intent);
    }

    fun reportPage(view : View){
        val intent = Intent(this,ReportActivity::class.java).apply {

        }
        startActivity(intent)
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
        startActivity(intent)
    }

    fun logoutfun(view : View){

        signOut()

    }




    companion object{
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }
}
