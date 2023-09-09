package io.ladans.pokedex.repositories

import dagger.hilt.android.scopes.ActivityScoped
import io.ladans.pokedex.data.remote.PokeApi
import io.ladans.pokedex.data.remote.responses.Pokemon
import io.ladans.pokedex.data.remote.responses.PokemonList
import io.ladans.pokedex.utils.Resource
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
){

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Erro desconhecido")
        }

        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(name: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(name)
        } catch (e: Exception) {
            return Resource.Error("Erro desconhecido")
        }

        return Resource.Success(response)
    }
}