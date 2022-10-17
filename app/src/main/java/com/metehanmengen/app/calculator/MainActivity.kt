package com.metehanmengen.app.calculator

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.metehanmengen.app.calculator.data.Sign
import com.metehanmengen.app.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var result = "" //butonlardan girilen değerler ve sonuç resultta gösteriliyor. ilk operand girildikten sonra değer temp'e atanıyor.
    private var temp = ""   // ilk girilen değer temp'e atanıyor, işlemlerde birinci operand temp ikinci operand result olup sonuç result'a atanıyor.
    private lateinit var sign : Sign  // işlemin işareti enum türünden değerde tutuluyor.

    private fun equalButtonClickCallback() // işlemler
    {
        var x = temp.toDouble()
        var y = result.toDouble()

        when(sign) {
            Sign.ADD -> x += y
            Sign.SUBTRACT -> x -= y
            Sign.MULTIPLY -> x *= y
            Sign.DIVIDE -> x /= y
            Sign.LESS_OR_EQUALS -> if (x > y) x = y
            Sign.REMAIN -> x %= y
        }

        result = x.toString()
        temp = ""
        initEditTextNumbers()
    }


    private fun initButtonEqual()
    {
        binding.buttonEqual.setOnClickListener { check -> equalButtonClickCallback() }
    }

    private fun initButtonNine() = binding.buttonNine.setOnClickListener { result += 9; initEditTextNumbers()}
    private fun initButtonEight() = binding.buttonEight.setOnClickListener { result += 8; initEditTextNumbers()}
    private fun initButtonSeven() = binding.buttonSeven.setOnClickListener { result += 7; initEditTextNumbers()}
    private fun initButtonSix() = binding.buttonSix.setOnClickListener { result += 6; initEditTextNumbers()}
    private fun initButtonFive() = binding.buttonFive.setOnClickListener { result += 5; initEditTextNumbers()}
    private fun initButtonFour() = binding.buttonFour.setOnClickListener { result += 4; initEditTextNumbers()}
    private fun initButtonThree() = binding.buttonThree.setOnClickListener { result += 3; initEditTextNumbers()}
    private fun initButtonTwo() = binding.buttonTwo.setOnClickListener { result += 2; initEditTextNumbers()}
    private fun initButtonOne() = binding.buttonOne.setOnClickListener { result += 1; initEditTextNumbers()}
    private fun initButtonZero() = binding.buttonZero.setOnClickListener { result += 0; initEditTextNumbers()}


    private fun initButtonSubtract() = binding.buttonSubtract.setOnClickListener {temp = result; result = ""; sign = Sign.SUBTRACT; initEditTextNumbers()}
    private fun initButtonAdd() = binding.buttonAdd.setOnClickListener {temp = result; result = ""; sign = Sign.ADD; initEditTextNumbers()}
    private fun initButtonMultiply() = binding.buttonMultiply.setOnClickListener {temp = result; result = ""; sign = Sign.MULTIPLY; initEditTextNumbers()}
    private fun initButtonDivide() = binding.buttonDivide.setOnClickListener {temp = result; result = ""; sign = Sign.DIVIDE; initEditTextNumbers()}
    private fun initButtonLessThanOrEqual() = binding.buttonLessThanOrEqual.setOnClickListener {temp = result; result = ""; sign = Sign.LESS_OR_EQUALS; initEditTextNumbers()}
    private fun initButtonRemain() = binding.buttonRemaining.setOnClickListener {temp = result; result = ""; sign = Sign.REMAIN; initEditTextNumbers()}
    private fun initButtonPoint() = binding.buttonPoint.setOnClickListener { if (!result.contains(".")) result += "."; initEditTextNumbers()}


    private fun initButtonClear() = binding.buttonClear.setOnClickListener { check -> binding.editTextNumberDecimal.setText(""); result = ""; temp = "" }
    private fun initEditTextNumbers() = binding.editTextNumberDecimal.setText(result.toString())


    private fun initViews()
    {
        initEditTextNumbers()
        initButtonClear()
        initButtonDivide()
        initButtonAdd()
        initButtonMultiply()
        initButtonSubtract()
        initButtonRemain()
        initButtonLessThanOrEqual()
        initButtonPoint()
        initButtonZero()
        initButtonOne()
        initButtonTwo()
        initButtonThree()
        initButtonFour()
        initButtonFive()
        initButtonSix()
        initButtonSeven()
        initButtonEight()
        initButtonNine()
        initButtonEqual()
    }


    private fun initBinding()
    {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initialize()
    {
        initBinding()
        initViews()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()

    }
}