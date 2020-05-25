package com.portales.lab6plataformas.Registrar

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.portales.lab6plataformas.R
import com.portales.lab6plataformas.database.GuestDatabase
import com.portales.lab6plataformas.databinding.FragmentRegisterBinding


class RegistrarFragment : Fragment() {

    private lateinit var registrarViewModel: RegistrarViewModel

    private lateinit var binding : FragmentRegisterBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_register,
            container,
            false
        )

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val application = requireNotNull(this.activity).application

        // Create an instance of the View Model Factory
        val dataSource = GuestDatabase.getInstance(application).guestDatabaseDao
        val viewModelFactory = RegistrarViewModelFactory(dataSource)

        // Get a reference to the ViewModel associated with this fragment
        registrarViewModel = ViewModelProvider(this, viewModelFactory).get(RegistrarViewModel::class.java)

        // To use the View Model with dta binding, you have to explicitly
        // give the binding object a reference to it.
        binding.registerViewModel = registrarViewModel

        // Specify the fragment view as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner


        registrarViewModel.registeredComplete.observe(viewLifecycleOwner, Observer {
            if (it) {
                requireView().findNavController().navigate(R.id.action_register_fragment_to_result_fragment)
                registrarViewModel.finishRegister()
            }
        })


        registrarViewModel.guests.observe(viewLifecycleOwner, Observer {
            registrarViewModel.initialize(it)
            (activity as AppCompatActivity).supportActionBar?.title =
                getString(R.string.title_android_guest, registrarViewModel.guestCount, registrarViewModel.totalCount)
        })

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.register_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_yes) {
            registrarViewModel.updateCurrentGuest()
        }

        if(item.itemId == R.id.action_no) {
            registrarViewModel.updateCurrentGuestNo()
        }

        return super.onOptionsItemSelected(item)
    }

}

