package io.keepcoding.rgs.everpobre.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.keepcoding.rgs.everpobre.R;
import io.keepcoding.rgs.everpobre.adapters.NotebookAdapter;
import io.keepcoding.rgs.everpobre.model.Notebooks;
import io.keepcoding.rgs.everpobre.model.db.dao.NotebookDAO;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotebooksFragment extends Fragment {

    @Bind(R.id.fragment_notebooks_recycler_view)
    RecyclerView notebooksRecyclerView;

    public NotebooksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notebooks, container, false);
        ButterKnife.bind(this, view);

        notebooksRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        NotebookDAO notebookDAO = new NotebookDAO();
        Notebooks notebooks = notebookDAO.query();
        NotebookAdapter adapter = new NotebookAdapter(notebooks, getActivity());

        notebooksRecyclerView.setAdapter(adapter);

        return view;
    }
}
