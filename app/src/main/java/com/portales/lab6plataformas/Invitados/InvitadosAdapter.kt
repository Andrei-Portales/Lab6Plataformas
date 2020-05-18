package com.portales.lab6plataformas.Invitados

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portales.lab6plataformas.R
import kotlinx.android.synthetic.main.invitado_model.view.*

class InvitadosAdapter(private var context: Context, private var lista : List<Invitado>):
    RecyclerView.Adapter<InvitadosAdapter.ViewHolder>() {

    inner class ViewHolder(var view: View):RecyclerView.ViewHolder(view){
        fun create(pos:Int){

            view.txtId.setText((pos + 1).toString())
            view.txtNombre.setText(lista.get(pos).nombre)
            view.txtTelefono.setText(lista.get(pos).telefono)
            view.txtCorreo.setText(lista.get(pos).correo)
            view.txtRol.setText(lista.get(pos).rol)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.invitado_model,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.create(position)
    }
}