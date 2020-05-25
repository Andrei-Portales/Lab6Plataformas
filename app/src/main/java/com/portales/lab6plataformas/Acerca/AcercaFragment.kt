package com.portales.lab6plataformas.Acerca

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.portales.lab6plataformas.R


class AcercaFragment : Fragment() {

    private lateinit var acercaViewModel: AcercaViewModel

    override fun onCreateView(inflater: LayoutInflater,
                                container: ViewGroup?, savedInstanceState: Bundle?): View? {
        acercaViewModel =
                ViewModelProviders.of(this).get(AcercaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_about, container, false)
        val textView: TextView = root.findViewById(R.id.text_title)
        acercaViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
