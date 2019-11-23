package cu.edu.uo.informatizacion.contraloria

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import cu.bellalogica.jnjcuba2019.Reproductor

import kotlinx.android.synthetic.main.activity_video_ods.*

class Video_ODS : AppCompatActivity() {
    override fun onPause() {
        super.onPause()
        reproductor.releasePlayer()
    }

    lateinit var reproductor :Reproductor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_ods)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        reproductor = Reproductor(this,null)
        reproductor.Reproducir(video_ods,R.raw.onu_ods)

    }

}
