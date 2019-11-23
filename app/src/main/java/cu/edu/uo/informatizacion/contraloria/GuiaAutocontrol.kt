package cu.edu.uo.informatizacion.contraloria

import android.os.Bundle
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_guia_autocontrol.*

class GuiaAutocontrol : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guia_autocontrol)
       supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
