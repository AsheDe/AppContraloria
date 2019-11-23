package cu.edu.uo.informatizacion.contraloria.BaseDatos

import android.content.Context
import cu.edu.uo.informatizacion.contraloria.C_ODS
import cu.edu.uo.informatizacion.contraloria.Componente


class DB_Interfaz(var contexto: Context) {
     var basedatos:DB_Manager

        init {
            basedatos = DB_Manager(contexto, "CONTRALORIA", null, 1)
        }


    fun ObtenerComponentes(sector:Int) : List<Componente>{
        var bd = basedatos.writableDatabase
        var componentes= ArrayList<Componente>()
        var cursor = bd.rawQuery("SELECT * FROM COMPONENTES WHERE sector==$sector",null)
        if(cursor.moveToFirst())
        {

            do {
                var nombre = cursor.getString(0)
                var concepto = cursor.getString(1)
                var normas = cursor.getString(2)
                var fuente = cursor.getString(3)
                var sector = cursor.getInt(4)
                var imagen= cursor.getInt(5)
                var pdf= cursor.getString(6)
                componentes.add(Componente(nombre,concepto,normas,fuente,sector,imagen,pdf))
            }while (cursor.moveToNext())
        }

        bd.close()

        return componentes
    }


    fun ObtenerODS() : List<C_ODS>{
        var bd = basedatos.writableDatabase
        var componentes= ArrayList<C_ODS>()
        var cursor = bd.rawQuery("SELECT * FROM ODS",null)
        if(cursor.moveToFirst())
        {

            do {
                var texto = cursor.getString(0)
                var indicadores = cursor.getString(1)
                var imagen = cursor.getInt(2)

                componentes.add(C_ODS(texto,indicadores,imagen))
            }while (cursor.moveToNext())
        }

        bd.close()
        return componentes
    }
   // fun BD_Lista():Boolean = basedatos.isReady()

}