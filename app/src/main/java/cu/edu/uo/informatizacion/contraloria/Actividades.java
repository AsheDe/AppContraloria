package cu.edu.uo.informatizacion.contraloria;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import cu.edu.uo.informatizacion.contraloria.BaseDatos.DB_Interfaz;

import java.util.Timer;
import java.util.TimerTask;

public class Actividades extends AppCompatActivity implements View.OnClickListener {

    final int REQUEST_CODE_ASK = 1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);
       Utiles.FullScreen(this);
        DB_Interfaz bd = new DB_Interfaz(this) ;

        findViewById(R.id.ver_empresarial).setOnClickListener (this);
        findViewById(R.id.ver_presupuestada).setOnClickListener (this);

        int hasSMSPermissionW = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int hasSMSPermissionR = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);


        //   val hasSMSPermission = packageManager.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,packageName)
        if (hasSMSPermissionW != PackageManager.PERMISSION_GRANTED || hasSMSPermissionR != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this ,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_CODE_ASK
            ) ;
        } else {
            AbrirPDF pdf = new AbrirPDF(this);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_ASK) {
            {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    // Rutina que se ejecuta al aceptar
                    //   var open = AbrirPDF(this)
                    // open.PdfOpen(componente.pdf)
                    AbrirPDF pdf = new AbrirPDF(this);
                  //  Toast.makeText(this, "Podrá abrir los PDF´s", Toast.LENGTH_SHORT).show();
                } else {
                    // Permission Denied
                    Toast.makeText(this, "No se aceptó permiso, no se podrá abrir el PDF", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent =new  Intent(this,Portada.class) ;
        if(v.getId()== R.id.ver_empresarial){
                intent.putExtra("unidad",0);
            }
            else if(v.getId()== R.id.ver_presupuestada){
                intent.putExtra("unidad",1) ;
            }
        startActivity(intent) ;
        overridePendingTransition(R.anim.desplazamiento_lateral, 0) ;
    }
}
