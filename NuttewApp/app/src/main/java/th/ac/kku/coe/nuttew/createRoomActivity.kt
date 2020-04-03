package th.ac.kku.coe.nuttew

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


data class Inforoom(
    var nameroom : String? ="",
    var date1 : String? = "",
    var time1 : String? = "",
    var place1 : String? = "",
    var detail1 : String? = "",
    var user_join : String?= "",
    var number_user : Int = 1

)

var count : Int ?= 3



class createRoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_room)

        val buttoncreate : Button = findViewById(R.id.button_create)

        val database = Firebase.database

        val myref = database.getReference("CountRoom/CountRoom")

        myref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {

                val value = p0.getValue<Int>()

               count = value



            }
        })


        buttoncreate.setOnClickListener { v ->
            createroom()
        }

    }


    fun createroom()
    {
        val mRootRef : DatabaseReference = FirebaseDatabase.getInstance().getReference()

        val createnewRoom : DatabaseReference = mRootRef.child("Room")

        val roomname : EditText = findViewById(R.id.edit_nameroom)

        val date : EditText =findViewById(R.id.edit_date)

        val times : EditText = findViewById(R.id.edit_time)

        val place : EditText = findViewById(R.id.edit_place)

        val detail : EditText = findViewById(R.id.edit_details)

        val sp : SharedPreferences = getSharedPreferences("Username", Context.MODE_PRIVATE)



        val inforoom = Inforoom(roomname.text.toString(),date.text.toString(),times.text.toString(),place.text.toString(),detail.text.toString(),sp.getString("myUsername","")+",",1)

        val childUpdates = HashMap<String, Any>()

        childUpdates["/CountRoom"] = count!!+1


        val updateRoom : DatabaseReference = mRootRef.child("CountRoom")

       updateRoom.updateChildren(childUpdates)



        createnewRoom.child((count).toString()).setValue(inforoom)


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
