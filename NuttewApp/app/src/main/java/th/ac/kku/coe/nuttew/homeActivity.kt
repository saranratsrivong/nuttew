package th.ac.kku.coe.nuttew

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.Response
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class homeActivity : AppCompatActivity() {


    var test : String? = null
    var count : Int? = 0



    override fun onStart() {
        super.onStart()



        val database = Firebase.database

        val countroom = database.getReference("CountRoom/CountRoom")

        countroom.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
               val value = p0.getValue<Int>()

                count = value

            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        val myref = database.getReference("Room")

        myref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {

                for(i in 0..4)

                {
                    val room = p0.child(i.toString()).child("nameroom").getValue<String>()
                    val date = p0.child(i.toString()).child("date1").getValue<String>()
                    val detail = p0.child(i.toString()).child("detail1").getValue<String>()
                    val time1 = p0.child(i.toString()).child("time1").getValue<String>()
                    val place = p0.child(i.toString()).child("place1").getValue<String>()
                    val count = p0.child(i.toString()).child("number_user").getValue<Int>()
                    val host = p0.child(i.toString()).child("user_join").getValue<String>()






                    val layout6 : LinearLayout = findViewById(R.id.LayoutRoom6)
                    layout6.setTransitionVisibility(4)
                    val layout7 : LinearLayout = findViewById(R.id.LayoutRoom7)
                    layout7.setTransitionVisibility(4)
                    val layout8 : LinearLayout = findViewById(R.id.LayoutRoom8)
                    layout8.setTransitionVisibility(4)
                    val layout9 : LinearLayout = findViewById(R.id.LayoutRoom9)
                    layout9.setTransitionVisibility(4)
                    val layout10 : LinearLayout = findViewById(R.id.LayoutRoom10)
                    layout10.setTransitionVisibility(4)


                    if(i==0){
                        val roomname : TextView = findViewById(R.id.titletx1)
                        roomname.text = room.toString()
                        val place1 : TextView = findViewById(R.id.text_place1)
                        place1.text = place.toString()
                        val user1 : TextView = findViewById(R.id.user_host1)
                        user1.text = ""
                        val date1 : TextView = findViewById(R.id.text_date1)
                        date1.text = getString(R.string.text_date)+" "+date.toString()
                        val start_at : TextView = findViewById(R.id.text_time1)
                        start_at.text =getString(R.string.startTime)+" "+time1.toString()
                        val number_user : TextView = findViewById(R.id.text_people1)
                        number_user.text = getString(R.string.text_people)+" "+count.toString()+"/4"
                        val host1 : TextView = findViewById(R.id.user_host1)
                        if(host!=null){
                            val parts = host!!.toString().split(",")

                            host1.text = "by "+parts[0]
                        }



                    }

                    if(i==1){
                        val roomname : TextView = findViewById(R.id.titletx2)
                        roomname.text = room.toString()
                        val place1 : TextView = findViewById(R.id.text_place2)
                        place1.text = place.toString()
                        val user1 : TextView = findViewById(R.id.user_host2)
                        user1.text = ""
                        val date1 : TextView = findViewById(R.id.text_date2)
                        date1.text =  getString(R.string.text_date)+" "+date.toString()
                        val start_at : TextView = findViewById(R.id.text_time2)
                        start_at.text = getString(R.string.startTime)+" "+time1.toString()
                        val number_user : TextView = findViewById(R.id.text_people2)
                        number_user.text = getString(R.string.text_people)+" "+count.toString()+"/4"
                        val host1 : TextView = findViewById(R.id.user_host2)
                        if(host!=null){
                            val parts = host!!.toString().split(",")

                            host1.text = "by "+parts[0]
                        }



                    }
                    if(i==2){
                        val roomname : TextView = findViewById(R.id.titletx3)
                        roomname.text = room.toString()
                        val place1 : TextView = findViewById(R.id.text_place3)
                        place1.text = place.toString()
                        val user1 : TextView = findViewById(R.id.user_host3)
                        user1.text = ""
                        val date1 : TextView = findViewById(R.id.text_date3)
                        date1.text =  getString(R.string.text_date)+" "+date.toString()
                        val start_at : TextView = findViewById(R.id.text_time3)
                        start_at.text = getString(R.string.startTime)+" "+time1.toString()
                        val number_user : TextView = findViewById(R.id.text_people3)
                        number_user.text = getString(R.string.text_people)+" "+count.toString()+"/4"
                        val host1 : TextView = findViewById(R.id.user_host3)
                        if(host!=null){
                            val parts = host!!.toString().split(",")

                            host1.text = "by "+parts[0]
                        }

                    }
                    if(i==3){
                        val roomname : TextView = findViewById(R.id.titletx4)
                        roomname.text = room.toString()
                        val place1 : TextView = findViewById(R.id.text_place4)
                        place1.text = place.toString()
                        val user1 : TextView = findViewById(R.id.user_host4)
                        user1.text = ""
                        val date1 : TextView = findViewById(R.id.text_date4)
                        date1.text =  getString(R.string.text_date)+" "+date.toString()
                        val start_at : TextView = findViewById(R.id.text_time4)
                        start_at.text = getString(R.string.startTime)+" "+time1.toString()
                        val number_user : TextView = findViewById(R.id.text_people4)
                        number_user.text = getString(R.string.text_people)+" "+count.toString()+"/4"
                        val host1 : TextView = findViewById(R.id.user_host4)
                        if(host!=null){
                            val parts = host!!.toString().split(",")

                            host1.text = "by "+parts[0]
                        }

                    }
                    if(i==4){
                        val roomname : TextView = findViewById(R.id.titletx5)
                        roomname.text = room.toString()
                        val place1 : TextView = findViewById(R.id.text_place5)
                        place1.text = place.toString()
                        val user1 : TextView = findViewById(R.id.user_host5)
                        user1.text = ""
                        val date1 : TextView = findViewById(R.id.text_date5)
                        date1.text =  getString(R.string.text_date)+" "+date.toString()
                        val start_at : TextView = findViewById(R.id.text_time5)
                        start_at.text = getString(R.string.startTime)+" "+time1.toString()
                        val number_user : TextView = findViewById(R.id.text_people5)
                        number_user.text = getString(R.string.text_people)+" "+count.toString()+"/4"
                        val host1 : TextView = findViewById(R.id.user_host5)
                        if(host!=null){
                            val parts = host!!.toString().split(",")

                            host1.text = "by "+parts[0]
                        }

                    }

                }


            }
        })





    }







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }

    fun Layout1viewroom(view :View){
        val intent = Intent(this,roomActivity::class.java)
        intent.putExtra("Layout","0")
        startActivity(intent)
    }
    fun Layout2viewroom(view :View){
        val intent = Intent(this,roomActivity::class.java)
        intent.putExtra("Layout","1")
        startActivity(intent)
    }
    fun Layout3viewroom(view :View){
        val intent = Intent(this,roomActivity::class.java)
        intent.putExtra("Layout","2")
        startActivity(intent)
    }
    fun Layout4viewroom(view :View){
        val intent = Intent(this,roomActivity::class.java)
        intent.putExtra("Layout","3")
        startActivity(intent)
    }
    fun Layout5viewroom(view :View){
        val intent = Intent(this,roomActivity::class.java)
        intent.putExtra("Layout","4")
        startActivity(intent)
    }


    fun friendPage(view: View) {
        val intent = Intent(this,
            requestFriendActivity::class.java).apply {

        }
        startActivity(intent)
    }

    fun chatPage(view: View) {
        val intent = Intent(this,
            chatActivity::class.java).apply {

        }
        startActivity(intent)
    }

    fun settingsPage(view: View) {
        val intent = Intent(this,
            settingActivity::class.java).apply {

        }
        startActivity(intent)
    }

    fun createRoompage(view :View){
        val intent = Intent(this,
            createRoomActivity::class.java).apply {

        }
        startActivity(intent)
    }


}
