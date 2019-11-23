package cu.edu.uo.informatizacion.contraloria

import android.content.Intent
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Adaptador_ListaODS (var lista:List<C_ODS>,var actividad: AppCompatActivity) : RecyclerView.Adapter <Adaptador_ListaODS.AdptVH>(){
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): AdptVH {
        var vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ods,parent,false);
        return Adaptador_ListaODS.AdptVH(vista)
    }

    override fun getItemCount()=lista.size

    override fun onBindViewHolder(hc: AdptVH, p1: Int) {
       hc.itemView.setOnClickListener {
           var dial = AlertDialog.Builder(it.context)
           dial.setMessage("${lista.get(p1).texto} \n\n ${lista.get(p1).indicadores}")
            dial.setCancelable(true)
           dial.create().show()
        }

        hc.texto.text = lista.get(p1).texto
        hc.indicadores.text = lista.get(p1).indicadores

        //Glide.with(hc.imagen).load(lista.get(p1).imagen)
        // hc.imagen.setImageResource(lista.get(p1).imagen)
        Glide.with(actividad)
            .load(lista.get(p1).imagen)
            .into(hc.imagen)
    }


    class AdptVH(var vista: View) : RecyclerView.ViewHolder(vista){
        var texto = vista.findViewById<TextView>(R.id.texto_ods)
        var indicadores = vista.findViewById<TextView>(R.id.indicadores_ods)
        var imagen = vista.findViewById<ImageView>(R.id.imagen_ods)
    }
}