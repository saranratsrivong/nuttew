package th.ac.kku.coe.nuttew

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.indexOf
import android.view.View
import android.widget.TextView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class roomActivity : AppCompatActivity() {

    var number : Int =0
    var str : String? =""
    var str1 : String?= ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)


        val database = Firebase.database
        val myref = database.getReference("Room")

        val check = intent.getStringExtra("Layout")
        str = check
        myref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {

                val room = p0.child(check).child("nameroom").getValue<String>()
                val date = p0.child(check).child("date1").getValue<String>()
                val detail = p0.child(check).child("detail1").getValue<String>()
                val time1 = p0.child(check).child("time1").getValue<String>()
                val place = p0.child(check).child("place1").getValue<String>()
                val number_user = p0.child(check).child("number_user").getValue<Int>()
                val userall = p0.child(check).child("user_join").getValue<String>()

                str1 = userall





                val textuser1 : TextView = findViewById(R.id.text_user1)
                val textuser2 : TextView = findViewById(R.id.text_user2)
                val textuser3 : TextView = findViewById(R.id.text_user3)



                val host : TextView = findViewById(R.id.text_phone)

                if(userall !=null){
                    val parts = userall!!.toString().split(",")
                    host.text = parts[0]

                    textuser1.text = parts[1]
                }


                number = number_user!!

                val titletext : TextView = findViewById(R.id.text_title_room)
                titletext.text = room.toString()
                val subject : TextView = findViewById(R.id.text_subject)
                subject.text  = detail.toString()
                val location : TextView = findViewById(R.id.text_location)
                location.text = place.toString()
                val time2 : TextView = findViewById(R.id.text_time_to_time)
                time2.text = time1.toString()
                val date1 : TextView = findViewById(R.id.text_date)
                date1.text = date.toString()
                val count_person: TextView = findViewById(R.id.text_count_person)
                count_person.text = number_user.toString()+"/4"





            }
        })

    }

    fun joinroom(view :View){


        val childUpdates = HashMap<String, Any>()


        val sp : SharedPreferences = getSharedPreferences("Username", Context.MODE_PRIVATE)

        childUpdates["/"+str+"/number_user"] = number+1
        childUpdates["/"+str+"/user_join"] = str1+sp.getString("myUsername","")+","


        val mRootRef : DatabaseReference = FirebaseDatabase.getInstance().getReference()

        val updateRoom : DatabaseReference = mRootRef.child("Room")

        updateRoom.updateChildren(childUpdates)

        val intent = Intent(this,homeActivity::class.java)

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
        startActivity(intent);
    }




}
