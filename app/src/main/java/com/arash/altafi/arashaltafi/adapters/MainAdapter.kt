package com.arash.altafi.arashaltafi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.arashaltafi.R
import com.arash.altafi.arashaltafi.models.DataItem
import com.arash.altafi.arashaltafi.utils.Utility
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

class MainAdapter : RecyclerView.Adapter<priceHolder>() {
    
    var priceList : List<DataItem> ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): priceHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_price , parent , false)
        return priceHolder(view)
    }

    override fun onBindViewHolder(holder: priceHolder, position: Int) {
        val price = priceList?.get(position)

        //country name
        val counrty = price?.title?.replace("سامانه سنا" , "")
        holder.txtCountry.text = counrty
        holder.txtprice.text = Utility.priceConverter(price?.P.toString())

        //price? change
        if (price?.dt == "low") {
            holder.txtChange.text = Utility.updateLowArz(price?.D.toString())
            holder.imgStatus.setImageResource(R.drawable.ic_baseline_arrow_low)
        }
        else {
            holder.txtChange.text = Utility.updateHighArz(price?.D.toString())
            holder.imgStatus.setImageResource(R.drawable.ic_baseline_arrow_high)
        }

        //country flag
        if (price?.slug == "sana_buy_usd" || price?.slug == "sana_sell_usd") {
            holder.imgFlag.setImageResource(R.drawable.usa)
        }
        else if (price?.slug == "sana_buy_eur" || price?.slug == "sana_sell_eur") {
            holder.imgFlag.setImageResource(R.drawable.europe)
        }
        else if (price?.slug == "sana_buy_aed" || price?.slug == "sana_sell_aed") {
            holder.imgFlag.setImageResource(R.drawable.uae)
        }
        else if (price?.slug == "sana_buy_inr" || price?.slug == "sana_sell_inr") {
            holder.imgFlag.setImageResource(R.drawable.india)
        }
        else if (price?.slug == "sana_buy_try" || price?.slug == "sana_sell_try") {
            holder.imgFlag.setImageResource(R.drawable.turkey)
        }
        else if (price?.slug == "sana_buy_rub" || price?.slug == "sana_sell_rub") {
            holder.imgFlag.setImageResource(R.drawable.russia)
        }
        else if (price?.slug == "sana_buy_cny" || price?.slug == "sana_sell_cny") {
            holder.imgFlag.setImageResource(R.drawable.china)
        }
        else if (price?.slug == "sana_buy_krw" || price?.slug == "sana_sell_krw") {
            holder.imgFlag.setImageResource(R.drawable.republic_of_korea)
        }
        else if (price?.slug == "sana_buy_chf" || price?.slug == "sana_sell_chf") {
            holder.imgFlag.setImageResource(R.drawable.suisse)
        }
        else if (price?.slug == "sana_buy_jpy" || price?.slug == "sana_sell_jpy") {
            holder.imgFlag.setImageResource(R.drawable.japan)
        }
        else if (price?.slug == "sana_buy_cad" || price?.slug == "sana_sell_cad") {
            holder.imgFlag.setImageResource(R.drawable.canada)
        }
        else if (price?.slug == "sana_buy_gbp" || price?.slug == "sana_sell_gbp") {
            holder.imgFlag.setImageResource(R.drawable.england)
        }
        else if (price?.slug == "sana_buy_sek" || price?.slug == "sana_sell_sek") {
            holder.imgFlag.setImageResource(R.drawable.sverige)
        }
        else if (price?.slug == "sana_buy_nok" || price?.slug == "sana_sell_nok") {
            holder.imgFlag.setImageResource(R.drawable.noreg)
        }
        else if (price?.slug == "sana_buy_iqd") {
            holder.imgFlag.setImageResource(R.drawable.iraq)
        }
        else if (price?.slug == "sana_buy_aud") {
            holder.imgFlag.setImageResource(R.drawable.australia)
        }
        else {
            holder.imgFlag.setImageResource(R.drawable.ic_baseline_flag_24)
        }

    }

    override fun getItemCount(): Int = priceList!!.size
}

class priceHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    val txtCountry: TextView = itemView.findViewById(R.id.txt_country_arz_sarafi_meli)
    val txtChange: TextView = itemView.findViewById(R.id.txt_change_arz)
    val txtprice: TextView = itemView.findViewById(R.id.txt_price_arz_sarafi_meli)
    val imgStatus: ImageView = itemView.findViewById(R.id.img_status_arz)
    val imgFlag: ImageView = itemView.findViewById(R.id.img_flag)

}