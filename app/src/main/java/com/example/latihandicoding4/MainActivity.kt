package com.example.latihandicoding4

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvSepatu : RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rvSepatu = findViewById(R.id.rv_sepatu)
        rvSepatu.setHasFixedSize(true)

        list.addAll(getListHero())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_list ->{
                rvSepatu.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid ->{
                rvSepatu.layoutManager = GridLayoutManager(this,2)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun getListHero(): ArrayList<Hero>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_deskripsi)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Hero>()
        for (i in dataName.indices){
            val sepatu = Hero(dataName[i],dataDescription[i],dataPhoto.getResourceId(i,-1))
            listHero.add(sepatu)
        }
        return listHero
    }

    private fun showRecyclerList(){
        rvSepatu.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvSepatu.adapter = listHeroAdapter
    }
}