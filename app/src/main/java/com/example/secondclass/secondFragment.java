package com.example.secondclass;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class secondFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   // private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    //private String mParam1;
   // private String mParam2;

private NavController nav;
ImageView imgv;
TextView txt_pname,txt_desc,txt_type,txt_height,txt_Weight,txt_ability;


    public secondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       nav= Navigation.findNavController(getActivity(),R.id.nav_host_fragment_container);
       Pokemon_ p= getArguments().getParcelable("data");

       imgv= view.findViewById(R.id.pkd_imgv);
       txt_pname= view.findViewById(R.id.pkd_txtpname);
       txt_desc= view.findViewById(R.id.pkd_txtpdesc);
       txt_type = view.findViewById(R.id.pkd_txtptype);
       txt_ability= view.findViewById(R.id.pkd_txtpability);
       txt_height= view.findViewById(R.id.pkd_txtpheight);
       txt_Weight= view.findViewById(R.id.pkd_txtpweight);

       genView(p);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
public void genView(Pokemon_ p){
    Picasso.get().load(p.getImage()).into(imgv);
    txt_pname.setText(p.getName());
    txt_desc.setText(p.getDescription());
    txt_type.setText("type:"+p.getType());
    txt_ability.setText("ability:"+p.getAbility());
    txt_Weight.setText("Height:"+p.getWeight());
    txt_height.setText("Weight:"+p.getHeight());

}

}
