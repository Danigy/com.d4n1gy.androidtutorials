package com.d4rk.androidtutorials.ui.android.textbox.tabs
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.d4rk.androidtutorials.R
import com.d4rk.androidtutorials.databinding.FragmentTextboxCodeBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import me.zhanghai.android.fastscroll.FastScrollerBuilder
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
class TextboxTabCodeFragment : Fragment() {
    private lateinit var _binding: FragmentTextboxCodeBinding
    private val binding get() = _binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTextboxCodeBinding.inflate(inflater, container, false)
        FastScrollerBuilder(binding.textboxScrollView).useMd2Style().build()
        MobileAds.initialize(requireContext())
        val adRequestBuilder = AdRequest.Builder().build()
        binding.adView.loadAd(adRequestBuilder)
        val inputStream: InputStream = resources.openRawResource(R.raw.text_textbox_kotlin)
        val byteArrayOutputStream = ByteArrayOutputStream()
        var i: Int
        try {
            i = inputStream.read()
            while (i != - 1) {
                byteArrayOutputStream.write(i)
                i = inputStream.read()
            }
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        binding.textboxCodeText.text = byteArrayOutputStream.toString()
        return binding.root
    }
}