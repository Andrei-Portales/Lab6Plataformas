package com.portales.lab6plataformas.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.portales.lab6plataformas.Acerca.AcercadeFragment
import com.portales.lab6plataformas.Inicio.InicioFragment
import com.portales.lab6plataformas.Invitados.InvitadosFragment
import com.portales.lab6plataformas.R
import com.portales.lab6plataformas.Roles.RolesFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        /*
        invitadoViewModel = ViewModelProviders.of(this).get(InvitadoViewModel::class.java)

        invitadoViewModel.getAllInvitados().observe(this, object:Observer<List<Invitado>>{
            override fun onChanged(t: List<Invitado>?) {
                Toast.makeText(this@MainActivity,"onchanged",Toast.LENGTH_SHORT).show()
            }

        })

         */
        val actionBarDrawerToggle = ActionBarDrawerToggle(this,drawer_layout,toolbar,
            R.string.navigation_open,
            R.string.navigation_close
        )
        drawer_layout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,InicioFragment()).commit()
            nav_view.setCheckedItem(R.id.nav_inicio)
        }

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_inicio-> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,InicioFragment()).commit()
                R.id.nav_invitados -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    InvitadosFragment()
                ).commit()
                R.id.nav_roles -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,RolesFragment()).commit()
                R.id.nav_acercade -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,AcercadeFragment()).commit()
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

    }




    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
        super.onBackPressed()
    }


}
