package com.example.embededsoftware

import android.app.Dialog
import android.content.Context
import android.widget.Button
import com.example.embededsoftware.fragments.AlramFragment
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class CustomDialog(context: Context) {
    private lateinit var database: DatabaseReference
    private val dialog = Dialog(context)

    //dialog를 생성한다. dialog의 역할은 리사이클러뷰에 저장된 택배 정보들을 제어 할 수 있게 한다. 수령 확인 여부를 확인하고 수령 확인 시간을 저장한다.
    fun MyDig(Key : String){
        dialog.setContentView(R.layout.dialog)
        dialog.setCancelable(true)
        dialog.show()

        database = Firebase.database.reference

        val CancelButton = dialog.findViewById<Button>(R.id.cancelBtn)
        val TakeButton = dialog.findViewById<Button>(R.id.takeCheckBtn)
        val TheftButton = dialog.findViewById<Button>(R.id.theftCheckBtn)

        //취소 버튼 눌렀을 때
        CancelButton.setOnClickListener {
            dialog.dismiss()
        }
        //지인수령 버튼 눌렀을 때
        TakeButton.setOnClickListener {
            database.child("data/${Key}/receive").setValue("수령 확인")
            database.child("data/${Key}/checkday").setValue(getDay())
            database.child("data/${Key}/checktime").setValue(getTime())
            dialog.dismiss()
        }

        //도난 버튼 눌렀을 때
        TheftButton.setOnClickListener {
            database.child("data/${Key}/receive").setValue("도난 확인")
            database.child("data/${Key}/checkday").setValue(getDay())
            database.child("data/${Key}/checktime").setValue(getTime())
            dialog.dismiss()
        }
    }

    //핸드폰의 현재 날짜 정보를 yyyy/MM/dd 형태로 가져온다.
    fun getDay() : String{
        val currentDateTime = Calendar.getInstance().time
        val dayText = SimpleDateFormat("yyyy/MM/dd", Locale.KOREA).format(currentDateTime)

        return dayText
    }
    //핸드폰의 시간 정보를 HH:mm:ss 형태로 가져온다.
    fun getTime() : String{
        val currentDateTime = Calendar.getInstance().time
        val timeText = SimpleDateFormat("HH:mm:ss", Locale.KOREA).format(currentDateTime)

        return timeText
    }
}