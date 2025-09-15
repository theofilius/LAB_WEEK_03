package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    companion object {
        const val ID_AFFOGATO = 1
        const val ID_AMERICANO = 2
        const val ID_LATTE = 3
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv = view.findViewById<RecyclerView>(R.id.rvCoffee)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.addItemDecoration(
            DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
        )

        val data = listOf(
            Coffee(ID_AFFOGATO,  R.string.affogato_title,  R.string.affogato_desc),
            Coffee(ID_AMERICANO, R.string.americano_title, R.string.americano_desc),
            Coffee(ID_LATTE,     R.string.latte_title,     R.string.latte_desc)
        )

        rv.adapter = CoffeeAdapter(items = data) { coffee ->
            val action = ListFragmentDirections.actionListToDetail(coffee.id)
            findNavController().navigate(action)
        }
    }
}
