package cu.edu.uo.informatizacion.contraloria

import android.os.Parcel
import android.os.Parcelable

data class Componente(var nombre:String="", var concepto : String="", var normas :String="",
                      var fuentes :String="", var sector :Int=0,var imagen :Int=0, var pdf :String="") : Parcelable {
    override fun writeToParcel(dest: Parcel?, flags: Int) {
            dest?.writeString(nombre)
            dest?.writeString(concepto)
            dest?.writeString(normas)
            dest?.writeString(fuentes)
            dest?.writeInt(sector)
            dest?.writeInt(imagen)
            dest?.writeString(pdf)
    }
    constructor(parcel: Parcel) : this() {

        this.nombre = parcel.readString()
        this.concepto = parcel.readString()
        this.normas = parcel.readString()
        this.fuentes = parcel.readString()
        this.sector = parcel.readInt()
        this.imagen= parcel.readInt()
        this.pdf= parcel.readString()

    }
    override fun describeContents(): Int {
        return 0
    }
    companion object {

        @JvmField val CREATOR: Parcelable.Creator<Componente> = object : Parcelable.Creator<Componente> {
            override fun createFromParcel(`in`: Parcel): Componente {
                return Componente(`in`)
            }

            override fun newArray(size: Int): Array<Componente?> {
                return arrayOfNulls(size)
            }
        }
    }

}