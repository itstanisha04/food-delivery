package com.example.myfood.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfood.R;
import com.example.myfood.adapters.HomeHorAdapter;
import com.example.myfood.adapters.HomeVerAdapter;
import com.example.myfood.adapters.UpdateVerticalRec;
import com.example.myfood.databinding.FragmentHomeBinding;
import com.example.myfood.models.HomeHorModel;
import com.example.myfood.models.HomeVerModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {


    RecyclerView homeHorizontalRec, homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    //////vertical
    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        //////////horizontal
        homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new HomeHorModel(R.drawable.pizza1, "pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.burger1, "HamBurger"));
        homeHorModelList.add(new HomeHorModel(R.drawable.fries1, "Fries"));
        homeHorModelList.add(new HomeHorModel(R.drawable.icecream1, "Ice Cream"));
        homeHorModelList.add(new HomeHorModel(R.drawable.sandwich1, "Sandwich"));

        homeHorAdapter = new HomeHorAdapter(this, getActivity(), homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        ////////////vertical
        homeVerModelList = new ArrayList<>();

//
//
//        homeVerModelList.add(new HomeVerModel(R.drawable.pizza1, "Pizza", "4.4", "Min - $45", "10:00 - 22:00"));
//        homeVerModelList.add(new HomeVerModel(R.drawable.pizza2, "Pizza", "4.4", "Min - $45", "10:00 - 22:00"));
//        homeVerModelList.add(new HomeVerModel(R.drawable.pizza3, "Pizza", "4.4", "Min - $45", "10:00 - 22:00"));
//        homeVerModelList.add(new HomeVerModel(R.drawable.pizza4, "Pizza", "4.4", "Min - $45", "10:00 - 22:00"));

        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
//        homeVerticalRec.setHasFixedSize(true);
//        homeVerticalRec.setNestedScrollingEnabled(false);

        return root;
    }


    @Override
    public void callback(int position, ArrayList<HomeVerModel> list) {

        homeVerAdapter = new HomeVerAdapter(getContext(), list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);
    }
}