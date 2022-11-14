package com.example.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.app.DatePickerDialog
import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.Calendar

class Biodata : AppCompatActivity(), View.OnClickListener {

    var editDate : EditText? = null
    var textView : TextView? = null
    var cal = Calendar.getInstance()
    private lateinit var etNamaDepan: EditText
    private lateinit var etNamaBelakang: EditText
    private lateinit var etTanggalLahir: EditText
    private lateinit var etAlamat: EditText
    private lateinit var etTelefon: EditText
    private lateinit var btnSubmit: Button
    private lateinit var tvResult: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bioadata)

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        etNamaDepan = findViewById(R.id.edt_namaDepan)
        etNamaBelakang = findViewById(R.id.edt_namaBelakang)
        etTanggalLahir = findViewById(R.id.edt_date)
        etAlamat = findViewById(R.id.edt_alamat)
        etTelefon = findViewById(R.id.edt_phone)
        btnSubmit = findViewById(R.id.btn_submit)
        tvResult = findViewById(R.id.tv_result)
        btnSubmit.setOnClickListener(this)
        etTanggalLahir.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@Biodata,
                        dateSetListener,
                        // set DatePickerDialog to point to today's date when it loads up
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

    }

    private fun updateDateInView() {
        val myFormat = "MM/dd/yy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, java.util.Locale.US)
        etTanggalLahir.setText(sdf.format(cal.getTime()))
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_submit) {
            val namaDepan = etNamaDepan.text.toString().trim()
            val namaBelakang = etNamaBelakang.text.toString().trim()
            val tanggalLahir = etTanggalLahir.text.toString().trim()
            val alamat = etAlamat.text.toString().trim()
            val telefon = etTelefon.text.toString().trim()

            tvResult.text = """"
                Nama Depan : $namaDepan
                Nama Belakang : $namaBelakang
                Tanggal Lahir : $tanggalLahir
                Alamat : $alamat
                Telefon : $telefon
            """.trimIndent()
        }
    }
}




