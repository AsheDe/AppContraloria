package cu.edu.uo.informatizacion.contraloria

import android.Manifest
import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import kotlinx.android.synthetic.main.activity_detalles__componente.*
import android.util.Log
import com.bumptech.glide.Glide
import android.widget.Toast
import android.content.ActivityNotFoundException
import android.content.pm.PackageManager
import android.os.Environment
import android.os.Environment.getExternalStorageDirectory
import android.content.res.AssetManager
import android.support.v4.app.ActivityCompat
import android.view.SearchEvent
import android.widget.ImageView
import java.io.*
import android.support.v4.content.ContextCompat
import android.support.annotation.NonNull






class Detalles_Componente : AppCompatActivity() {

    val REQUEST_CODE_ASK = 1
    lateinit var componente : Componente
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles__componente)
        Utiles.FullScreen(this)
        var dirpicture = "${Environment.getExternalStorageDirectory()}/"

        var componente = intent.getParcelableExtra<Componente>("componente")
        // detalle_imagen.setImageResource(componente.imagen)
        // Glide.with(detalle_imagen).load(componente.imagen)

        Glide.with(this)
            .load(componente.imagen)
            .into(detalle_imagen)

        detalle_concepto.text = componente.concepto
        detalle_normas.text = "Normas: \n ${componente.normas}"
        detalle_nombre.text = componente.nombre
        detalle_fuentes.text = "Fuentes: \n ${componente.fuentes}"

        if (componente.sector == 0)
            detalle_nombre.setTextColor(resources.getColor(R.color.colorPrimary))
        else
            detalle_nombre.setTextColor(resources.getColor(R.color.colorAccent))

        detalle_ver_pdf.setOnClickListener {

            val hasSMSPermissionW = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            val hasSMSPermissionR = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)


         //   val hasSMSPermission = packageManager.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,packageName)
            if (hasSMSPermissionW != PackageManager.PERMISSION_GRANTED || hasSMSPermissionR != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this as Activity,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE),
                REQUEST_CODE_ASK
                )
            } else {
                var open = AbrirPDF(this)
                open.PdfOpen(componente.pdf)
            }




        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_CODE_ASK -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    // Rutina que se ejecuta al aceptar
                    var open = AbrirPDF(this)
                    open.PdfOpen(componente.pdf)
                  //  Toast.makeText(this, "Vuelva a intentar abrir el PDF", Toast.LENGTH_SHORT).show()
                } else {
                    // Permission Denied
                    Toast.makeText(this, "No se aceptó permiso de abrir el PDF", Toast.LENGTH_SHORT).show()
                }

            }

        }
    }







}
