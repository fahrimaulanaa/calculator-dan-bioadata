package com.example.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editWidth: EditText
    private lateinit var editHeight: EditText
    private lateinit var editLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editWidth = findViewById(R.id.et_width)
        editHeight = findViewById(R.id.et_height)
        editLength = findViewById(R.id.et_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate) {
            val inputLength = editLength.text.toString().trim()
            val inputWidth = editWidth.text.toString().trim()
            val inputHeight = editHeight.text.toString().trim()

            var isEmptyFields = false
            var isInvalidDouble = false

            if (inputLength.isEmpty()) {
                isEmptyFields = true
                editLength.error = "Field ini tidak boleh kosong"
            }

            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                editWidth.error = "Field ini tidak boleh kosong"
            }

            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                editHeight.error = "Field ini tidak boleh kosong"
            }

            val length = toDouble(inputLength)
            val width = toDouble(inputWidth)
            val height = toDouble(inputHeight)

            if (length == null) {
                isInvalidDouble = true
                editLength.error = "Field ini harus berupa nomer yang valid"
            }

            if (width == null) {
                isInvalidDouble = true
                editWidth.error = "Field ini harus berupa nomer yang valid"
            }

            if (height == null) {
                isInvalidDouble = true
                editHeight.error = "Field ini harus berupa nomer yang valid"
            }

            if (!isEmptyFields && !isInvalidDouble) {
                val volume = length as Double * width as Double * height as Double
                tvResult.text = volume.toString()
            }
        }
    }

    private fun toDouble(inputWidth: String): Any? {
        return try {
            inputWidth.toDouble()
        } catch (e: NumberFormatException) {
            null
        }

    }
}