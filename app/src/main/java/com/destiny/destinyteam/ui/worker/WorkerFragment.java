package com.destiny.destinyteam.ui.worker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.destiny.destinyteam.Adapter.AdapterMember;
import com.destiny.destinyteam.Model.MemberData;
import com.destiny.destinyteam.Model.MemberModel;
import com.destiny.destinyteam.R;

import java.util.ArrayList;

public class WorkerFragment extends Fragment {
    RecyclerView recyclerView;
    private ArrayList<MemberModel> pList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_worker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView =view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        pList.addAll(MemberData.getListData());
        AdapterMember cardViewAdapter = new AdapterMember(getContext());
        cardViewAdapter.setListMember(pList);
        recyclerView.setAdapter(cardViewAdapter);
    }
}