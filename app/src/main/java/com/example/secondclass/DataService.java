package com.example.secondclass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("E14trR2lD")
    Call<Pokemon> getAllPokemons();
}
