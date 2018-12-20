package com.example.thehighbrow.visitormanagement

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.thehighbrow.visitormanagement.R.id.gst
import com.squareup.picasso.Picasso
import org.w3c.dom.Text
import java.util.ArrayList

internal class DayAdapter (var dayvisitors: ArrayList<DayVisitor>) : RecyclerView.Adapter<DayAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): DayAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.day_row, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: DayAdapter.ViewHolder, i: Int) {

        viewHolder.name.text = dayvisitors[i].getName()
        viewHolder.contact.text = dayvisitors[i].getContact()
        viewHolder.email.text = dayvisitors[i].getEmail()
        viewHolder.gst.text = dayvisitors[i].getGst()
        viewHolder.invoice.text = dayvisitors[i].getInvoice()
        //      String purl = visitors.get(i).getPhotoUrl();
        /*   if (Uri.parse(purl)!=null){
            Uri puri = Uri.parse(purl);
            Picasso.get().load(puri).into(viewHolder.photo);
        }
        else{*/
        //   val imageuri = Uri.parse(visitors[i].getPhotoUrl())
        Picasso.get().load(dayvisitors[i].getPhotoUrl()).into(viewHolder.photo)
        //    viewHolder.photo.setImageURI(imageuri);
        //     }


    }

    override fun getItemCount(): Int {
        return dayvisitors.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var contact: TextView
        var email: TextView
        var photo: ImageView
        var gst: TextView
        var invoice: TextView


        init {
            name = itemView.findViewById(R.id.namefield)
            contact = itemView.findViewById(R.id.contactfield)
            email = itemView.findViewById(R.id.hostfield)
            photo = itemView.findViewById(R.id.visitorphoto)
            gst = itemView.findViewById(R.id.gstfield)
            invoice = itemView.findViewById(R.id.invoicefield)


        }
    }

}
