package com.boriyevfayz.practical_english.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.boriyevfayz.practical_english.R
import com.boriyevfayz.practical_english.SplashViewModel
import com.boriyevfayz.practical_english.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var _binding: FragmentSplashBinding
    private val mBinding get() = _binding

    companion object {
        private var instance: SplashFragment? = null

        fun getInstance(): SplashFragment {
            return if (instance != null) instance!! else {
                val newInstance = SplashFragment()
                instance = newInstance
                newInstance
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        val viewModel = ViewModelProvider(this)[SplashViewModel::class.java]
        viewModel.startTimer()
        viewModel.timer.observe(viewLifecycleOwner) { isTimeOut ->
            if (isTimeOut) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, HomeFragment()).commit()
            }
        }
        return mBinding.root
    }
}