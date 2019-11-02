package sv.edu.bitlab.desafio.dennis

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import sv.edu.bitlab.desafio.R
import sv.edu.bitlab.desafio.dennis.Models.Account

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    var accounts: MutableList<Account> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(accounts : MutableList<Account>, context: Context){
        this.accounts = accounts
        this.context = context

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return accounts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = accounts.get(position)
        holder.bind(item, context)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val nombre = view.findViewById<TextView>(R.id.textNombre)
            val correo = view.findViewById<TextView>(R.id.textEmail)
            val numero = view.findViewById<TextView>(R.id.textTelefono)
            val enteraste = view.findViewById<TextView>(R.id.textEnteraste)
            val avatar = view.findViewById<ImageView>(R.id.imageView)

        fun bind(account : Account, context: Context){
            nombre.text = account.accountName
            correo.text = account.accountEmail
            numero.text = account.accountPhone
            enteraste.text = account.accountFoundOutBy
            avatar.loadUrl(account.accountImage)
        }
        fun ImageView.loadUrl(url: String){
            Picasso.with(context).load(url).into(this)
        }
    }

}