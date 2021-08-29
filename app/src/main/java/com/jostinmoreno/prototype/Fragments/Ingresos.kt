package com.jostinmoreno.prototype.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jostinmoreno.prototype.Adapters.RecyclerAdapter
import com.jostinmoreno.prototype.Class.CardViews
import com.jostinmoreno.prototype.R
import kotlinx.android.synthetic.main.fragment_ingresos.*
import kotlinx.android.synthetic.main.item_recycler_cardview.*


class Ingresos : Fragment() {
    lateinit var myFragment: View
   lateinit var  cardlist: ArrayList<CardViews>
   lateinit var  cardAdapter: RecyclerAdapter
    lateinit var  productList: ArrayList<CardViews>
   lateinit var  recyclerItemAdapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myFragment= inflater.inflate(R.layout.fragment_ingresos, container, false)
        return myFragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        cardlist= arrayListOf()
        productList= arrayListOf()
        Data()

        recyclerIngresos.layoutManager = LinearLayoutManager(this.context)
        cardAdapter = RecyclerAdapter(cardlist)
        recyclerIngresos.adapter = cardAdapter

        /*recyclerItem.layoutManager = LinearLayoutManager(this.context)
        recyclerItemAdapter = RecyclerAdapter(productList)
        recyclerItem.adapter = recyclerItemAdapter*/
    }

    private fun Data()
    {
        val ganancia: Double
        val porcentaje: Double
        val ganlastyear: Double
        val ventas:Int
        val porcVentas: Double
        val price: Double
        ganancia=120.0
        porcentaje= 5.5
        ganlastyear= 100.0
        ventas=150
        porcVentas=2.3
        price=40.80
        cardlist.add(CardViews("$${ganancia.toString()}","${porcentaje.toString()}%","Compared to ($${ganlastyear} last year)","","",
            R.drawable.up,R.drawable.up,"","","",0))

        cardlist.add(CardViews("","","","$${ventas.toString()}","${porcVentas.toString()}%",
            R.drawable.up,R.drawable.up,"","","",1))

        cardlist.add(CardViews("","","","","",
            R.drawable.up,R.drawable.up,"","","",2))

        productList.add(CardViews("","","","","",
            R.drawable.up,R.drawable.up,"Nike Air","Nike","$${price.toString()}",3))

        productList.add(CardViews("","","","","",
            R.drawable.up,R.drawable.up,"Jordan Air","Jordan","$${(price+20.4).toString()}",3))



    }

}