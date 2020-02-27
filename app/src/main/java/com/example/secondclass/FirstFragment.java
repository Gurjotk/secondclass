package com.example.secondclass;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FirstFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
   // private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;
Button btn_go;
private NavController nav;
ArrayList<Pokemon_> parray;
Recadapter adapter;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

     nav= Navigation .findNavController(getActivity(),R.id.nav_host_fragment_container);
   // btn_go= view.findViewById(R.id.firstFragment);
    //btn_go.setOnClickListener(new View.OnClickListener() {
    //    @Override
      //  public void onClick(View v) {
        //    nav.navigate(R.id.secondFragment);

      //  }
   // });
        DataService service = RetrofitClientInstance.getRetrofitInstance().create(DataService.class);
        Call<Pokemon> call=service.getAllPokemons();
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon pOkemon = response.body();
                try {
                    parray = new ArrayList<>(pOkemon.getPokemon());
                    generateView(parray,view);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });
    }
    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position= viewHolder.getAdapterPosition();
            Toast.makeText(getActivity().getApplicationContext(),parray.get(position).getName(),Toast.LENGTH_LONG).show();
Bundle b= new Bundle();
b.putParcelable("data",parray.get(position));
nav.navigate(R.id.secondFragment,b);
        }
    };

public void generateView(ArrayList<Pokemon_>parray, View view){
        adapter =new Recadapter(parray,getActivity().getApplicationContext());
    LinearLayoutManager manager =new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
    RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
    recyclerView.setLayoutManager(manager);
    recyclerView.setAdapter(adapter);
    adapter.setClickListener(onClickListener);


}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


}
