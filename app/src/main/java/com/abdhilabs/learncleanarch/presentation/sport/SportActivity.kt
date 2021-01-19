package com.abdhilabs.learncleanarch.presentation.sport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.abdhilabs.domain.vo.Result
import com.abdhilabs.learncleanarch.R
import com.abdhilabs.learncleanarch.databinding.ActivitySportBinding
import com.abdhilabs.learncleanarch.helper.extension.snackBarError
import com.abdhilabs.learncleanarch.helper.extension.toast
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class SportActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var binding: ActivitySportBinding
    private lateinit var vm: SportViewModel
    private lateinit var adapterSport: SportAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sport)
        vm = ViewModelProvider(this, factory)[SportViewModel::class.java]
        vm.getAllSports()
        observeSport()
        adapterSport = SportAdapter()
        binding.rvSport.adapter = adapterSport
    }

    private fun observeSport() {
        vm.sports.observe(this) {
            when (it) {
                is Result.Loading -> toast("Loading")
                is Result.Success -> adapterSport.refreshItems(it.data)
                is Result.Error -> binding.root.snackBarError("Error: ${it.errorMessage}")
            }

        }
    }
}