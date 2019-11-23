package cu.edu.uo.informatizacion.contraloria
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_portada.*
import kotlinx.android.synthetic.main.app_bar_portada.*

import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.ImageView
import android.content.Intent
import android.net.Uri
import android.preference.PreferenceManager
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import cu.edu.uo.informatizacion.contraloria.BaseDatos.DB_Interfaz


class Portada : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portada)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, bottom_bar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        var unidad = intent.getIntExtra("unidad",0)

        ////  recycler
        var bd = DB_Interfaz(this)


        listado_componentes.adapter = Adaptador_Componentes(this,bd.ObtenerComponentes(unidad))
        listado_componentes.layoutManager = LinearLayoutManager(this)


    }

    override fun onPostResume() {
        super.onPostResume()
    }



    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


  /*  override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }*/

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
       when (item.itemId) {
           R.id.menu_presentacion->Utiles.AbrirActividad(this,Actividades::class.java)
           R.id.menu_mision->Utiles.AbrirActividad(this,Mision::class.java)
           R.id.menu_guia_auxiliar->Utiles.AbrirActividad(this,Guia_Aux::class.java)
           R.id.menu_buenas_practicas->Utiles.AbrirActividad(this,BuenasPracticas::class.java)
         //  R.id.menu_codigo_etica->Utiles.AbrirActividad(this,CodigoEtica::class.java)
           R.id.menu_ods->Utiles.AbrirActividad(this,ODS::class.java)
           R.id.menu_guia_autocontrol->Utiles.AbrirActividad(this,GuiaAutocontrol::class.java)

           R.id.menu_portal_nacional -> {
               Snackbar.make(drawer_layout,"Debe encender los datos móviles",Snackbar.LENGTH_LONG).show()
               val uri = Uri.parse("http://www.contraloria.gob.cu")
               val intent = Intent(Intent.ACTION_VIEW, uri)
               startActivity(intent)
           }
       }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}

/*R.id.menu_comunicar -> {
              val emailIntent = Intent(Intent.ACTION_SEND)
              emailIntent.data = Uri.parse("mailto:claudia.lopez@uo.edu.cu")
              emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("sheyla.lageyre@uo.edu.cu", "yudelm@uo.edu.cu"))
              emailIntent.putExtra(Intent.EXTRA_SUBJECT, "App - Arte Móvil")
              emailIntent.type = "message/rfc822"
              startActivity(Intent.createChooser(emailIntent, "Email"))
          }*/
