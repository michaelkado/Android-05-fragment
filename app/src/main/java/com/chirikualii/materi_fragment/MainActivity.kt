package com.chirikualii.materi_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.chirikualii.materi_fragment.databinding.ActivityMainBinding
import com.chirikualii.materi_fragment.favorit.FavoritFragment
import com.chirikualii.materi_fragment.home.HomeFragment
import com.chirikualii.materi_fragment.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val HomeFragment = HomeFragment()
    private val FavoritFragment = FavoritFragment()
    private val ProfileFragment = ProfileFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCurrentFragment(HomeFragment)

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menuHome -> {
                    setCurrentFragment(HomeFragment)
                true
            }
                R.id.menuFavorit ->{
                    setCurrentFragment(FavoritFragment)
                true
            }
                R.id.menuProfile ->{
                    setCurrentFragment(ProfileFragment)
                true
            }
            else -> {
                false
            }
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(
            R.id.fragmentContainer,fragment
        )
        fragmentTransaction.commit()

    }
}