package cu.edu.uo.informatizacion.contraloria

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cu.edu.uo.informatizacion.contraloria.BaseDatos.DB_Interfaz
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Utiles.FullScreen(this)
        val context = this
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
            startActivity(Intent(context,Actividades::class.java))
            }
        }, 1000)

    }

    override fun onClick(v: View?) {

    }
}
