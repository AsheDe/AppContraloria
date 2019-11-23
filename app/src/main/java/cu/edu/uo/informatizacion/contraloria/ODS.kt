package cu.edu.uo.informatizacion.contraloria

import android.os.Bundle
import android.app.Activity
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import cu.bellalogica.jnjcuba2019.Reproductor
import cu.edu.uo.informatizacion.contraloria.BaseDatos.DB_Interfaz

import kotlinx.android.synthetic.main.activity_ods.*

class ODS : AppCompatActivity() {
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==R.id.video_ods)
            Utiles.AbrirActividad(this,Video_ODS::class.java)
        if(item?.itemId==android.R.id.home)
            NavUtils.navigateUpFromSameTask(this)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_video,menu);

        return true;
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ods)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var db = DB_Interfaz(this)
//TODO  PONER IMAGENES
        listado_odss.adapter = Adaptador_ListaODS(db.ObtenerODS(),this)
        listado_odss.layoutManager = StaggeredGridLayoutManager(resources.getInteger(R.integer.cols_ods),StaggeredGridLayoutManager.VERTICAL)
    }

}
