package com.example.galerapagos

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var weatherList = mutableListOf("0", "0", "0", "1", "1", "1", "2", "2", "2", "3", "3")
    var woodChances = mutableListOf(1, 0, 0, 0, 0, 0)
    var fishList = mutableListOf(1, 1, 1, 2, 2, 3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherList.shuffle()

        val weatherText: TextView = findViewById(R.id.weather)
        val indexStorm = (6..11).random()
        weatherList.add(indexStorm, "2 - Tempête")
        weatherText.text = weatherList[0]
    }

    fun rejouer(view: android.view.View) {

        weatherList.removeAll(setOf("2 - Tempête"))
        weatherList.shuffle()

        val weatherText: TextView = findViewById(R.id.weather)
        val newIndexStorm = (6..11).random()
        weatherList.add(newIndexStorm, "2 - Tempête")
        weatherText.text = weatherList[0]

        val dayText: TextView = findViewById(R.id.day)
        val foodText: TextView = findViewById(R.id.food)
        val waterText: TextView = findViewById(R.id.water)
        val woodText: TextView = findViewById(R.id.wood)
        val raftText: TextView = findViewById(R.id.raft)

        val fishText: TextView = findViewById(R.id.fish)

        val woodToSearchText: TextView = findViewById(R.id.woodToSearch)
        val resultWoodText: TextView = findViewById(R.id.resultWood)

        dayText.text = "1"
        foodText.text = "0"
        waterText.text = "0"
        woodText.text = "0"
        raftText.text = "0"

        fishText.text = ""

        woodToSearchText.text = "0"
        resultWoodText.text = ""
    }

    /* // // // // // // // //
        // Jour & Meteo //
    // // // // // // // // */

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

    /* // // // // // // // // // //
        // Nourriture & Eau //
    // // // // // // // // // // */

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
    fun toFish(view: android.view.View) {
        val fishText: TextView = findViewById(R.id.fish)
        var fish = fishList.random()

        fishText.text = "$fish" + " poisson(s) pêché(s) !"
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

    /* // // // // // // // // // //
        // Bois & Radeaux //
    // // // // // // // // // // */

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


    fun incrWoodToSearch(view: android.view.View) {
        val woodToSearchText: TextView = findViewById(R.id.woodToSearch)
        var woodToSearch = Integer.parseInt(woodToSearchText.text.toString())

        if(woodToSearch < 5)
            woodToSearch++

        woodToSearchText.text = "$woodToSearch"
    }
    fun decrWoodToSearch(view: android.view.View) {
        val woodToSearchText: TextView = findViewById(R.id.woodToSearch)
        var woodToSearch = Integer.parseInt(woodToSearchText.text.toString())

        if(woodToSearch > 0)
            woodToSearch--

        woodToSearchText.text = "$woodToSearch"
    }
    fun searchWood(view: android.view.View) {
        val woodToSearchText: TextView = findViewById(R.id.woodToSearch)
        var woodToSearch = Integer.parseInt(woodToSearchText.text.toString())
        val resultWoodText: TextView = findViewById(R.id.resultWood)
        var resultWood = 0
        var success = "Réussite !"

        woodChances.shuffle()


        for(i in 0 until woodToSearch) {
            resultWood += woodChances[i]
        }
         if (resultWood == 1)
             success = "Echec ! Vous êtes empoisonné..."

        resultWoodText.text = success
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

    /* // // // // // // //
        // Sauver //
    // // // // // // // */

    fun takeScreenshotOfView(view: View, height: Int, width: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val bgDrawable = view.background
        if (bgDrawable != null) {
            bgDrawable.draw(canvas)
        } else {
            canvas.drawColor(Color.WHITE)
        }
        view.draw(canvas)
        return bitmap
    }
}