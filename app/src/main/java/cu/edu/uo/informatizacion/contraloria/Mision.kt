package cu.edu.uo.informatizacion.contraloria

import android.os.Bundle
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mision.*

class Mision : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mision)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
