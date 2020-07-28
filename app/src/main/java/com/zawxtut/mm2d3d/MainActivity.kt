package com.zawxtut.mm2d3d

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    lateinit var tv:TextView
    lateinit var tv2:TextView
    lateinit var tv3:TextView
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv=findViewById(R.id.text1);
        tv2=findViewById(R.id.text2);
        tv3=findViewById(R.id.text3);
        progressBar=findViewById(R.id.mmyProgress);
       getConSettOne();
   }


    private fun  getConSettOne()  {
        val mmqueue = Volley.newRequestQueue(this)
        val mmurl = "https://mmlive2d3d.000webhostapp.com/"
        val mmstrRequest = StringRequest(
            Request.Method.GET,
            mmurl,
            Response.Listener { response ->
                progressBar!!.visibility = View.GONE
                try {
                    val jsonObject = JSONObject(response)
                   tv.setText(jsonObject.getString("RESULT"));
                    tv2.setText(jsonObject.getString("SET"));
                    tv3.setText(jsonObject.getString("VALUE"));
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { merror -> Log.d("error Resporn", merror.toString()) })
        mmqueue.add(mmstrRequest)
    }
}
