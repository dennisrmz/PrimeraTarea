package sv.edu.bitlab.desafio.dennis.Models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import sv.edu.bitlab.desafio.R

class RecyclerAdapter(var accounts: MutableList<Account>, listener: ViewHolderListener) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return accounts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = accounts.get(position)
        holder.bind(item)
    }



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var accountName = view.findViewById<TextView>(R.id.textNombre)
        var accountEmail = view.findViewById<TextView>(R.id.textEmail)
        var accountPhone =  view.findViewById<TextView>(R.id.textTelefono)
        var accountFoundOutBy = view.findViewById<TextView>(R.id.textEnteraste)
        var accountImage = view.findViewById<ImageView>(R.id.imageView)


        fun bind(cuenta: Account){

        }
 }

    class ViewHolderListener {

    }

}