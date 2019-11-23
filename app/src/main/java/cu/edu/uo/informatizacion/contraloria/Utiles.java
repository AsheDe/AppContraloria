package cu.edu.uo.informatizacion.contraloria;

import android.Manifest;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.circularreveal.CircularRevealCompat;
import android.support.design.circularreveal.CircularRevealWidget;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by yudel on 08/11/2017.
 */
public class Utiles {

    static public void FullScreen(AppCompatActivity actividad)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                actividad.getWindow().setStatusBarColor(Color.TRANSPARENT);
                actividad.getWindow()
                        .getDecorView()
                        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            } else {
                actividad.getWindow()
                        .setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
    }

    public static <T extends View & CircularRevealWidget> void circularRevealCrecer(@NonNull final T circularRevealWidget) {
        if(Build.VERSION.SDK_INT >=21) {
            circularRevealWidget.post(new Runnable() {
                @Override
                public void run() {
                    int viewWidth = circularRevealWidget.getWidth();
                    int viewHeight = circularRevealWidget.getHeight();

                    int viewDiagonal = (int) Math.sqrt(viewWidth * viewWidth + viewHeight * viewHeight);

                    final AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(
                            CircularRevealCompat.createCircularReveal(circularRevealWidget, viewWidth / 2, viewHeight / 2, 2, viewDiagonal / 2),
                            ObjectAnimator.ofArgb(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, Color.TRANSPARENT , Color.TRANSPARENT ));

                    animatorSet.setDuration(900);
                    animatorSet.start();
                }
            });
        }

        AlertDialog.Builder alert ;


    }


    public static <T extends View & CircularRevealWidget> void circularRevealDeCrecer(@NonNull final T circularRevealWidget) {
        if(Build.VERSION.SDK_INT >=21) {
            circularRevealWidget.post(new Runnable() {
                @Override
                public void run() {
                    int viewWidth = circularRevealWidget.getWidth();
                    int viewHeight = circularRevealWidget.getHeight();

                    int viewDiagonal = (int) Math.sqrt(viewWidth * viewWidth + viewHeight * viewHeight);

                    final AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(
                            CircularRevealCompat.createCircularReveal(circularRevealWidget, viewWidth / 2, viewHeight / 2, viewDiagonal / 2 ,10 ),
                            ObjectAnimator.ofArgb(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, Color.TRANSPARENT, Color.BLACK));

                    animatorSet.setDuration(900);
                    animatorSet.start();
                }
            });
        }
    }

    static public void AbrirActividad(Activity vieja, Class nuevaactividad){
        Intent intent = new Intent(vieja.getBaseContext(),nuevaactividad);
        vieja.startActivity(intent);
        vieja.overridePendingTransition(R.anim.desplazamiento_lateral,0);


    }



  /*  static public void DrawerLayout(MenuItem item, Context contexto, DrawerLayout drawer){

        int id = item.getItemId();

        if (id == R.id.temas) {
            contexto.startActivity(new Intent(contexto, TEMAS.class));
            // Handle the camera action
        } else if (id == R.id.cuestionario) {
            contexto.startActivity(new Intent(contexto, Cuestionario.class));
        } else if (id == R.id.figuras) {
            contexto.startActivity(new Intent(contexto, PersonajeListActivity.class));
        }
        else if (id == R.id.creditos) {

        }

        drawer.closeDrawer(GravityCompat.START);
    }
*/
    static public void CambiardeColor(Integer color, View vista)
    {
        vista.setBackgroundResource(color);
    }

   static public void EnviarSMS(final int telefono, Context contexto) {

        int hasSMSPermission = ActivityCompat.checkSelfPermission(contexto, Manifest.permission.SEND_SMS);
       final int REQUEST_CODE_ASK_PERMISSIONS_SMS = 1;
        if (hasSMSPermission != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions((Activity) contexto, new String[]{Manifest.permission.SEND_SMS}, REQUEST_CODE_ASK_PERMISSIONS_SMS);
        }
        else
        {
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setData(Uri.parse("sms:+" + telefono));
            contexto.startActivity(smsIntent);

        }
    }

    static public void Llamar(final String telefono, Context contexto)
    {

        int hasCALLPermission = ActivityCompat.checkSelfPermission(contexto, Manifest.permission.CALL_PHONE);
        final int REQUEST_CODE_ASK_PERMISSIONS_CALL = 7;
        if (hasCALLPermission != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions((Activity) contexto, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS_CALL);

        }
        else {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:+" + telefono));
            contexto.startActivity(callIntent);
        }
    }

    /*static public void setLocale(Context context,String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(context, Portada.class);
        context.startActivity(refresh);
        ((Activity) context).finish();
    }*/
    static  public void PonerIdioma(Context contexto,String idioma)
    {
        Resources res = contexto.getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = new Locale(idioma.toLowerCase());
        res.updateConfiguration(conf, dm);
    }

   /* static public  void CambiarIdiomas(final Context contexto, final Class clase)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setTitle(contexto.getResources().getString(R.string.cambiaridioma));
        CharSequence[]idiomas = new CharSequence[]{"Español","English","Deutsch"} ;
        builder.setItems(idiomas, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String cambioidioma= "es" ;
                switch (which)
                {
                    case 0:
                    {
                        cambioidioma = "es" ;
                        break;
                    }
                    case 1:
                    {
                        cambioidioma = "en" ;
                        break;
                    }
                    case 2:
                    {
                        cambioidioma = "de" ;
                        break;
                    }

                }
                PreferenceManager.getDefaultSharedPreferences(contexto).edit().putString("idioma",cambioidioma).commit();
                Intent refrescar = new Intent(contexto,clase);
                // refrescar.putExtra("idioma","en");
                contexto.startActivity(refrescar);
            }

        });

        builder.setPositiveButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
       // builder.create();
        AlertDialog dilogo =  builder.create();
        dilogo.show();
       // return builder ;
    } */
}
