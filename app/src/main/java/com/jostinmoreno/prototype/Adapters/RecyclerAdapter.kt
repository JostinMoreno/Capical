package com.jostinmoreno.prototype.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jostinmoreno.prototype.Class.CardViews
import com.jostinmoreno.prototype.R
import kotlinx.android.synthetic.main.item_compared_cardview.view.*
import kotlinx.android.synthetic.main.item_grapic_cardview.view.*
import kotlinx.android.synthetic.main.item_products_cardview.view.*

private const val POST_TYPE_CARD1:Int=0
private const val POST_TYPE_CARD2:Int=1
private const val POST_TYPE_CARD3:Int=2
private const val POST_TYPE_CARD4:Int=3

class RecyclerAdapter(val cardview:ArrayList<CardViews>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var onClickListener: RecyclerAdapter.OnClickListener?= null

    class card1(itemView:View): RecyclerView.ViewHolder(itemView)
    {
        fun bind(cardviews:CardViews)
        {
            itemView.txtGanancia.text= cardviews.Ganancia
            itemView.txtPorcentaje.text= cardviews.porcentaje
            itemView.txtGananciaprev.text =cardviews.Gananciaprev
        }
    }

    class card2(itemView:View): RecyclerView.ViewHolder(itemView)
    {
        fun bind(cardviews:CardViews)
        {
            itemView.txtSales.text =cardviews.Ventas
            itemView.txtPorcentajeVentas.text =cardviews.porctVentas
        }
    }

    class card3(itemView:View): RecyclerView.ViewHolder(itemView)
    {
        fun bind(cardviews:CardViews)
        {

        }
    }

    class card4(itemView:View): RecyclerView.ViewHolder(itemView)
    {
        fun bind(cardviews:CardViews)
        {
            itemView.txtModel.text =cardviews.model
            itemView.txtBrand.text =cardviews.brand
            itemView.txtPrice.text =cardviews.price
        }
    }

    /*inner class RecyclerHolder(val view: View):RecyclerView.ViewHolder(view){
        fun render()
        {

        }


    }*/
    interface OnClickListener{
        fun onClick()
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener= onClickListener
    }

    override fun getItemViewType(position: Int): Int {
        if(cardview[position].type==0L)
        {
            return POST_TYPE_CARD1
        }else if (cardview[position].type==1L){
            return  POST_TYPE_CARD2
        }else if (cardview[position].type==2L){
            return  POST_TYPE_CARD3
        }else{
            return POST_TYPE_CARD4
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType== POST_TYPE_CARD1)
        {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_compared_cardview,parent,false)
            return card1(view)
        }else if (viewType== POST_TYPE_CARD2){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grapic_cardview,parent,false)
            return card2(view)

        }else if (viewType== POST_TYPE_CARD3){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_cardview,parent,false)
            return card3(view)

        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_products_cardview,parent,false)
            return card3(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position)== POST_TYPE_CARD1){
            (holder as card1).bind(cardview[position])
        }else if(getItemViewType(position)== POST_TYPE_CARD2){
            (holder as card2).bind(cardview[position])
        }else if(getItemViewType(position)== POST_TYPE_CARD3){
            (holder as card3).bind(cardview[position])
        }else{
            (holder as card4).bind(cardview[position])
        }
    }

    override fun getItemCount(): Int {
        return cardview.size
    }
}