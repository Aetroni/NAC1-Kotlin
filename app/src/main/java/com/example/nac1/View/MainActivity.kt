package com.example.nac1.View

import android.accessibilityservice.GestureDescription
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.nac1.Model.CardItem
import com.example.nac1.Presenter.CardAdapter
import com.example.nac1.Presenter.Presenter
import com.example.nac1.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), MainView {

    private var mAdapter: CardAdapter? = null
    private lateinit var mainPresenter: Presenter
    private lateinit var context: Context
    private var listCardsFill = ArrayList<CardItem>()

    var timerText: TextView? = null
    var stopStartButton: Button? = null

    var timer: Timer? = null
    var timerTask: TimerTask? = null
    var time = 0.0

    var timerStarted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        context = this
        mainPresenter = Presenter(this)

        timerText = findViewById<View>(R.id.timerText) as TextView
        stopStartButton = findViewById<View>(R.id.startStopButton) as Button
        timer = Timer()
    }


    override fun requestData(listCards: ArrayList<CardItem>) {
        this.listCardsFill = listCards
        mAdapter =
            CardAdapter(listCardsFill, context, this)
        grid_main_cards.adapter = mAdapter
    }

    override fun cardClickOk(idImgCard: Int) {
        Log.d("TAG", "Click en item: $idImgCard")

        for (card in listCardsFill){
            if(card.imgInit.equals(idImgCard)){
                card.isVisible = true
            }
        }
        mAdapter!!.notifyDataSetChanged()
    }

    override fun cardClickFail() {
        Log.d("TAG", "Waiting...")
        var handler = Handler()
        handler.postDelayed(Runnable {
            mAdapter!!.notifyDataSetChanged()
        }, 2000)
    }

    abstract class CountUpTimer protected constructor(private val duration: Long) :
        CountDownTimer(duration, INTERVAL_MS) {
        abstract fun onTick(second: Int)
        override fun onTick(msUntilFinished: Long) {
            val second = ((duration - msUntilFinished) / 1000).toInt()
            onTick(second)
        }

        override fun onFinish() {
            onTick(duration / 1000)
        }

        companion object {
            private const val INTERVAL_MS: Long = 1000
        }
    }

    override fun sendActionMain(cardOption: Int, indexArray: Int) {
        mainPresenter.validateClikcs(cardOption, indexArray)
    }








    fun startStopTapped(view: View?) {
        if (timerStarted == false) {
            timerStarted = true
            setButtonUI("STOP", R.color.black);
            startTimer()
        } else {
            timerStarted = false
            setButtonUI("FINISH", R.color.black);
            timerTask?.cancel()


        }
    }

    private fun setButtonUI(start: String, color: Int) {
        stopStartButton?.setText(start)
        stopStartButton?.setTextColor(ContextCompat.getColor(this, color))
    }

    private fun startTimer() {
        timerTask = object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    time++
                    timerText!!.text = getTimerText()
                }
            }
        }
        timer?.scheduleAtFixedRate(timerTask, 0, 1000)
    }


    private fun getTimerText(): String? {
        val rounded = Math.round(time).toInt()
        val seconds = rounded % 86400 % 3600 % 60
        val minutes = rounded % 86400 % 3600 / 60
        val hours = rounded % 86400 / 3600
        return formatTime(seconds, minutes, hours)
    }

    private fun formatTime(seconds: Int, minutes: Int, hours: Int): String? {
        return String.format("%02d", hours) + " : " + String.format(
            "%02d",
            minutes
        ) + " : " + String.format("%02d", seconds)
    }
}
