package com.example.thehighbrow.visitormanagement

import android.content.Context
import android.net.Uri
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.user_row.view.*

import org.w3c.dom.Text

import java.util.ArrayList


internal class VisitorAdapter(var visitors: ArrayList<Visitor>) : RecyclerView.Adapter<VisitorAdapter.ViewHolder>() {

    lateinit var context : View

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): VisitorAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.user_row, viewGroup, false)
        context = view
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: VisitorAdapter.ViewHolder, i: Int) {

        viewHolder.name.text = visitors[i].getName()
        viewHolder.contact.text = visitors[i].getContact()
        viewHolder.host.text = visitors[i].getHost()
        //      String purl = visitors.get(i).getPhotoUrl();
        /*   if (Uri.parse(purl)!=null){
            Uri puri = Uri.parse(purl);
            Picasso.get().load(puri).into(viewHolder.photo);
        }
        else{*/



        //Glide.with(viewHolder.itemView).load(databaseVisitor).into(viewHolder.photo)


      //val imageuri = Uri.parse(visitors[i].getPhotoUrl())
        Picasso.get().load(visitors[i].getPhotoUrl()).into(viewHolder.photo)
        //viewHolder.photo.setImageBitmap(Picasso.get().load(visitors[i].getPhotoUrl()).get())
            //viewHolder.photo.setImageURI(imageuri);
        //     }


    }

    override fun getItemCount(): Int {
        return visitors.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var contact: TextView
        var host: TextView
        var photo: ImageView

        init {
            name = itemView.findViewById(R.id.namefield)
            contact = itemView.findViewById(R.id.contactfield)
            host = itemView.findViewById(R.id.hostfield)
            photo = itemView.findViewById(R.id.visitorphoto)

        }
    }

}
