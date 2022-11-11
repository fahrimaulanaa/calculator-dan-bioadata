package com.example.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Biodata : AppCompatActivity(), View.OnClickListener {

    private lateinit var editNamaDepan: EditText
    private lateinit var editNamaBelakang: EditText
    private lateinit var editAlamat: EditText
    private lateinit var editTelefon: EditText
    private lateinit var editTanggalLahir: EditText
    private lateinit var btnSimpan: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bioadata)

        editNamaDepan = findViewById(R.id.edt_namaDepan)
        editNamaBelakang = findViewById(R.id.edt_namaBelakang)
        editAlamat = findViewById(R.id.edt_alamat)
        editTelefon = findViewById(R.id.edt_phone)
        editTanggalLahir = findViewById(R.id.edt_date)
        btnSimpan = findViewById(R.id.btn_submit)
        tvResult = findViewById(R.id.tv_result)
        btnSimpan.setOnClickListener(this)



    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_submit) {
            val inputNamaDepan = editNamaDepan.text.toString().trim()
            val inputNamaBelakang = editNamaBelakang.text.toString().trim()
            val inputAlamat = editAlamat.text.toString().trim()
            val inputTelefon = editTelefon.text.toString().trim()
            val inputTanggalLahir = editTanggalLahir.text.toString().trim()

            var isEmptyFields = false
            var isInvalidDouble = false

            if (inputNamaDepan.isEmpty()) {
                isEmptyFields = true
                editNamaDepan.error = "Field ini tidak boleh kosong"
            }

            if (inputNamaBelakang.isEmpty()) {
                isEmptyFields = true
                editNamaBelakang.error = "Field ini tidak boleh kosong"
            }

            if (inputAlamat.isEmpty()) {
                isEmptyFields = true
                editAlamat.error = "Field ini tidak boleh kosong ya"
            }

            if (inputTelefon.isEmpty()) {
                isEmptyFields = true
                editTelefon.error = "Field ini tidak boleh kosong"
            }

            if (inputTanggalLahir.isEmpty()) {
                isEmptyFields = true
                editTanggalLahir.error = "Field ini tidak boleh kosong"
            }

            val namaDepan = toString(inputNamaDepan)
            val namaBelakang = toString(inputNamaBelakang)
            val alamat = toString(inputAlamat)
            val telefon = toString(inputTelefon)
            val tanggalLahir = toString(inputTanggalLahir)

            if (namaDepan == null) {
                isInvalidDouble = true
                editNamaDepan.error = "Field ini harus berupa nomer yang valid"
            }

            if (namaBelakang == null) {
                isInvalidDouble = true
                editNamaBelakang.error = "Field ini harus berupa nomer yang valid"
            }

            if (alamat == null) {
                isInvalidDouble = true
                editAlamat.error = "Field ini harus berupa nomer yang valid"
            }

            if (telefon == null) {
                isInvalidDouble = true
                editTelefon.error = "Field ini harus berupa nomer yang valid"
            }

            if (tanggalLahir == null) {
                isInvalidDouble = true
                editTanggalLahir.error = "Field ini harus berupa tanggal yang valid"
            }

            if (!isEmptyFields && !isInvalidDouble) {
                val result = "Nama Depan: $namaDepan, Nama Belakang: $namaBelakang, Alamat: $alamat, Nomor Telefon: $telefon, Tanggal Lahir: $tanggalLahir"
                tvResult.text = result.toString()
            }
        }
    }

    private fun toString(inputTanggalLahir: String): String {
        return inputTanggalLahir

    }

}