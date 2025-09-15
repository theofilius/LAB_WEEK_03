package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private val coffeeTitle: TextView? get() = view?.findViewById(R.id.coffee_title)
    private val coffeeDesc: TextView? get() = view?.findViewById(R.id.coffee_desc)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = DetailFragmentArgs.fromBundle(requireArguments())
        setCoffeeData(args.coffeeId)
    }

    private fun setCoffeeData(id: Int) {
        when (id) {
            ListFragment.ID_AFFOGATO -> {
                coffeeTitle?.text = getString(R.string.affogato_title)
                coffeeDesc?.text  = getString(R.string.affogato_desc)
            }
            ListFragment.ID_AMERICANO -> {
                coffeeTitle?.text = getString(R.string.americano_title)
                coffeeDesc?.text  = getString(R.string.americano_desc)
            }
            ListFragment.ID_LATTE -> {
                coffeeTitle?.text = getString(R.string.latte_title)
                coffeeDesc?.text  = getString(R.string.latte_desc)
            }
        }
    }
}
