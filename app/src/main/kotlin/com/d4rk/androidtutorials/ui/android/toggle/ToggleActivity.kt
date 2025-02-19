package com.d4rk.androidtutorials.ui.android.toggle
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.d4rk.androidtutorials.R
import com.d4rk.androidtutorials.databinding.ActivityToggleBinding
import com.kieronquinn.monetcompat.app.MonetCompatActivity
import me.zhanghai.android.fastscroll.FastScrollerBuilder
class ToggleActivity : MonetCompatActivity() {
    private lateinit var binding : ActivityToggleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToggleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FastScrollerBuilder(binding.scrollView).useMd2Style().build()
        binding.switchMonet.setOnClickListener {
            Toast.makeText(this,  R.string.monetSwitchToast, Toast.LENGTH_SHORT).show()
        }
        binding.buttonToggle.setOnClickListener {
            Toast.makeText(this, R.string.appCompatToggleButtonToast, Toast.LENGTH_SHORT).show()
        }
        binding.switchMaterial.setOnClickListener {
            Toast.makeText(this, R.string.toast_switch_material, Toast.LENGTH_SHORT).show()
        }
        binding.materialSwitch.setOnClickListener {
            Toast.makeText(this, R.string.toast_material_switch, Toast.LENGTH_SHORT).show()
        }
        binding.floatingButtonShowSyntax.setOnClickListener {
            startActivity(Intent(this, ToggleCodeActivity::class.java))
        }
    }
}