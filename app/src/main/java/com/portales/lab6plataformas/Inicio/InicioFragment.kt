package com.portales.lab6plataformas.Inicio

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.portales.lab6plataformas.R
import com.portales.lab6plataformas.databinding.FragmentHomeBinding


class InicioFragment : Fragment() {

    private lateinit var viewModel: InicioViewModel

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        setHasOptionsMenu(true)

        viewModel = ViewModelProvider(this).get(InicioViewModel::class.java)

        // Set the viewmodel for databinding - this allows the bound layout access
        // to all the data in the VieWModel
        binding.homeViewModel = viewModel

         //Observer for the Game finished event
        viewModel.eventGoToRegister.observe(viewLifecycleOwner, Observer<Boolean> { hasFinished ->
            if (hasFinished) onGoToRegisterFragment()
        })

        return binding.root
    }

    private fun onGoToRegisterFragment() {
        findNavController().navigate(R.id.action_nav_home_to_register_fragment)
        viewModel.onGoToRegisterComplete()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_about) {
            findNavController().navigate(R.id.action_nav_home_to_about_fragment)
        }
        return super.onOptionsItemSelected(item)
    }
}

