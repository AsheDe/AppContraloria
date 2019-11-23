package cu.edu.uo.informatizacion.contraloria

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide

class Adaptador_Componentes(var activity:Activity,var lista:List<Componente> ) : RecyclerView.Adapter<Adaptador_Componentes.HC>() {

     override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): HC {
         var vista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_componentes,viewGroup,false);
         return HC(vista);
     }

     override fun getItemCount(): Int = 5

     override fun onBindViewHolder(hc: HC, p1: Int) {
         hc.itemView.setOnClickListener {

             val intent = Intent(it.context, Detalles_Componente::class.java)
             intent.putExtra("componente",lista.get(p1))
             it.context.startActivity(intent)
             activity.overridePendingTransition(R.anim.desplazamiento_lateral, 0)


             }

         hc.texto.text = lista.get(p1).concepto
         hc.nombre.text = lista.get(p1).nombre
         if(lista.get(p1).sector==0)
            hc.nombre.setTextColor( activity.resources.getColor(R.color.colorPrimary))
         else
             hc.nombre.setTextColor(activity.resources.getColor(R.color.colorAccent))
        //Glide.with(hc.imagen).load(lista.get(p1).imagen)
        // hc.imagen.setImageResource(lista.get(p1).imagen)
         Glide.with(activity)
             .load(lista.get(p1).imagen)
             .into(hc.imagen)
     }



     class HC(item:View) : RecyclerView.ViewHolder(item) {
     var imagen = item.findViewById(R.id.imagen_componente) as ImageView
     var texto = item.findViewById(R.id.texto_componente) as TextView
     var nombre = item.findViewById(R.id.nombre_componente) as TextView


    }
}
