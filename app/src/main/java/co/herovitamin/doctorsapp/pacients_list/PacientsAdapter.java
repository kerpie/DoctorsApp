package co.herovitamin.doctorsapp.pacients_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.zip.Inflater;

import co.herovitamin.doctorsapp.R;
import co.herovitamin.doctorsapp.model.Pacient;

/**
 * Created by kerry on 23/06/17.
 */

public class PacientsAdapter extends RecyclerView.Adapter<PacientsVH> {

    ArrayList<Pacient> items;

    public PacientsAdapter(ArrayList<Pacient> items) {
        this.items = items;
    }

    @Override
    public PacientsVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PacientsVH(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.pacients_item, parent, false)
            );
    }

    @Override
    public void onBindViewHolder(PacientsVH holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
