package com.itiudc.proyecto_breakingbad_rolonbarreto.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.itiudc.proyecto_breakingbad_rolonbarreto.R
import com.itiudc.proyecto_breakingbad_rolonbarreto.databinding.ActivityDetailCharacterBinding
import com.itiudc.proyecto_breakingbad_rolonbarreto.models.character
import com.itiudc.proyecto_breakingbad_rolonbarreto.viewModels.charactersViewModel

class DetailCharacterActivity : AppCompatActivity() {
    companion object {
        const val CHARACTER_KEY = "character_item"
    }

    private lateinit var binding: ActivityDetailCharacterBinding
    private lateinit var viewModel: charactersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityDetailCharacterBinding>(this, R.layout.activity_detail_character)
        val bundle: Bundle? = intent.extras

        if(bundle != null){
            val characterItem = bundle.getParcelable<character>(CHARACTER_KEY)

            Glide.with(binding.root)
                .load(characterItem?.img)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.characterImage)

            when(characterItem?.status){
                "Alive" -> {
                    Glide.with(binding.root)
                        .load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Heart_coraz%C3%B3n.svg/1200px-Heart_coraz%C3%B3n.svg.png")
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(binding.characterStatusImage)
                }
                "Deceased" ->{
                    Glide.with(binding.root)
                        .load("https://www.psdstamps.com/wp-content/uploads/2019/11/r.i.p.-stamp-png.png")
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(binding.characterStatusImage)

                }
                "Presumed dead" ->{
                    Glide.with(binding.root)
                        .load("https://www.seekpng.com/png/full/546-5463339_source-getrichbrothers-com-report-red-question-question-mark.png")
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(binding.characterStatusImage)

                }
            }



            binding.characterName.text = characterItem?.name
            binding.characterAlias.text = characterItem?.nickname
            binding.characterStatus.text = characterItem?.status
            binding.characterBirthday.text = characterItem?.birthday
            binding.characterPortrayed.text = characterItem?.portrayed
            var occupationText = characterItem?.occupation?.joinToString(", ").toString()
            binding.characterOcuppation.text = occupationText


        }
    }
}