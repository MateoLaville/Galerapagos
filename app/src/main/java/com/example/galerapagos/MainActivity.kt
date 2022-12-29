package com.example.galerapagos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var weatherList = mutableListOf("0", "0", "0", "1", "1", "1", "2", "2", "2", "3", "3")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherText: TextView = findViewById(R.id.weather)
        weatherList.shuffle()

        val index = (6..11).random()
        weatherList.add(index, "2 - Storm")
        weatherText.text = weatherList[0]
    }

    fun incrDay(view: android.view.View) {
        val dayText: TextView = findViewById(R.id.day)
        val weatherText: TextView = findViewById(R.id.weather)
        var day = Integer.parseInt(dayText.text.toString())
        var weather: String? = null

        if(day < 12)
            day++
        weather = weatherList[day-1]

        dayText.text = "$day"
        weatherText.text = weather
    }
    fun decrDay(view: android.view.View) {
        val dayText: TextView = findViewById(R.id.day)
        val weatherText: TextView = findViewById(R.id.weather)
        var day = Integer.parseInt(dayText.text.toString())
        var weather: String? = null

        if(day > 1)
            day--
        weather = weatherList[day-1]

        dayText.text = "$day"
        weatherText.text = weather
    }

    fun incrFood(view: android.view.View) {
        val foodText: TextView = findViewById(R.id.food)
        var food = Integer.parseInt(foodText.text.toString())

        if(food < 36)
            food++

        foodText.text = "$food"
    }
    fun decrFood(view: android.view.View) {
        val foodText: TextView = findViewById(R.id.food)
        var food = Integer.parseInt(foodText.text.toString())

        if(food > 0)
            food--

        foodText.text = "$food"
    }

    fun incrWater(view: android.view.View) {
        val waterText: TextView = findViewById(R.id.water)
        var water = Integer.parseInt(waterText.text.toString())

        if(water < 36)
            water++

        waterText.text = "$water"
    }
    fun decrWater(view: android.view.View) {
        val waterText: TextView = findViewById(R.id.water)
        var water = Integer.parseInt(waterText.text.toString())

        if(water > 0)
            water--

        waterText.text = "$water"
    }

    fun incrWood(view: android.view.View) {
        val woodText: TextView = findViewById(R.id.wood)
        val raftText: TextView = findViewById(R.id.raft)
        var wood = Integer.parseInt(woodText.text.toString())
        var raft = Integer.parseInt(raftText.text.toString())

        if(wood < 5 && raft < 12) {
            wood++
        }
        else {
            wood = 0
            if(raft < 12) {
                raft++
                raftText.text = "$raft"
            }
        }

        woodText.text = "$wood"
    }
    fun decrWood(view: android.view.View) {
        val woodText: TextView = findViewById(R.id.wood)
        val raftText: TextView = findViewById(R.id.raft)
        var wood = Integer.parseInt(woodText.text.toString())
        var raft = Integer.parseInt(raftText.text.toString())

        if(wood > 0) {
            wood--
        }
        else {
            wood = 5
            if(raft > 0) {
                raft--
                raftText.text = "$raft"
            }
        }

        woodText.text = "$wood"
    }

    fun incrRaft(view: android.view.View) {
        val raftText: TextView = findViewById(R.id.raft)
        var raft = Integer.parseInt(raftText.text.toString())

        if(raft < 12)
            raft++

        raftText.text = "$raft"
    }
    fun decrRaft(view: android.view.View) {
        val raftText: TextView = findViewById(R.id.raft)
        var raft = Integer.parseInt(raftText.text.toString())

        if(raft > 0)
            raft--

        raftText.text = "$raft"
    }
}