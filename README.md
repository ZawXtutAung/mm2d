# mm2d
mm2d
```kotlin
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
