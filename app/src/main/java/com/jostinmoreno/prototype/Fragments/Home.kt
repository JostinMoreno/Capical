package com.jostinmoreno.prototype.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.jostinmoreno.prototype.R
import kotlinx.android.synthetic.main.fragment_home.*


class Home : Fragment() {
   lateinit var myFragment: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myFragment= inflater.inflate(R.layout.fragment_home, container, false)

        return myFragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        childFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayoutFragment,Ingresos())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        btn_nav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.ingresosFragment ->{
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayoutFragment,Ingresos())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.gastosFragment ->{
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayoutFragment,Gastos())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.reportesFragment ->{
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayoutFragment,Reportes())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.inventarioFragment ->{
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayoutFragment,Inventario())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

            }
            true
        }
    }


}