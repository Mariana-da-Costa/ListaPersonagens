package com.example.listapersonagens.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.bumptech.glide.Glide
import com.example.listapersonagens.R
import com.example.listapersonagens.databinding.FragmentCharactersBinding
import com.example.listapersonagens.model.response.Character
import com.example.listapersonagens.model.domain.Disney
import com.example.listapersonagens.model.domain.RickAndMorty
import com.example.listapersonagens.model.mapper.DisneyMapper
import com.example.listapersonagens.model.mapper.RickAndMortyMapper
import com.example.listapersonagens.model.response.DisneyCharactersResult
import com.example.listapersonagens.model.response.RickyAndMortyCharacter
import com.example.listapersonagens.model.response.RickyAndMortyResult
import com.example.listapersonagens.network.service.DisneyService
import com.example.listapersonagens.network.service.RickyAndMortyService
import com.example.listapersonagens.repository.DisneyRepository
import com.example.listapersonagens.utils.gone
import com.example.listapersonagens.utils.visible
import com.example.listapersonagens.viewmodel.DisneyViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharactersFragment : Fragment() {
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewmodel: DisneyRepository

    private val retrofitRickyAndMorty: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val rickyAndMortyService: RickyAndMortyService =
        retrofitRickyAndMorty.create(RickyAndMortyService::class.java)

    private val charactersAdapter = CharactersAdapter()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupViewModel()
    }

    private fun setupViewModel() {
        viewmodel = ViewModelProvider(this, DisneyViewModel.Factory(DisneyRepository())).get(
            DisneyViewModel::class.java
        )
    }

    private fun setupView() {
        with(binding) {
            rvCharacters.adapter = charactersAdapter
            rgCharacterType.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbCharacterTypeDisney -> {
                        CoroutineScope(Dispatchers.IO).launch(Dispatchers.Main) {
                            pbLoadingCharacters.visible()
                            tvCharactersTypeTitle.text = Disney.title
                            llCharactersTypeHeader.background = AppCompatResources.getDrawable(
                                requireContext(),
                                Disney.colorRes
                            )
                            setupGlide(Disney.imageUrl)
                            val disneyCharacters = viewmodel.returnDisney().getCharacters()
                            val transformedDisneyList =
                                DisneyMapper().transform(disneyCharacters.data)
                            submitList(transformedDisneyList)
                        }
                    }
                    R.id.rbCharacterTypeRickyAndMorty -> {
                        CoroutineScope(Dispatchers.IO).launch(Dispatchers.Main) {
                            pbLoadingCharacters.visible()
                            tvCharactersTypeTitle.text = RickAndMorty.title
                            llCharactersTypeHeader.background = AppCompatResources.getDrawable(
                                requireContext(),
                                RickAndMorty.colorRes
                            )
                            setupGlide(RickAndMorty.imageUrl)
                            val rickyAndMortyCharacters = rickyAndMortyService.getCharacters()
                            val transformedRickList =
                                RickAndMortyMapper().transform(rickyAndMortyCharacters.results)
                            submitList(transformedRickList)
                        }
                    }
                }
            }
        }
    }

//Foram criadas as classes abaixo para melhorar a manutenabilidade do código e separa as responsabilidades
//das funções, usando o princípio da responsabilidade única. Segue o pilar do encapsulamento da POO.
//Pela classe extender de Fragment(), ela segue o pilar da herança da POO

    private fun setupGlide(type: String) {
        Glide.with(binding.root)
            .load(type)
            .error(R.drawable.ic_launcher_background)
            .into(binding.ivCharactersTypeImage)
    }

    private fun submitList(list: List<Character>) {
        charactersAdapter.submitList(list)
        binding.pbLoadingCharacters.gone()
    }
}
