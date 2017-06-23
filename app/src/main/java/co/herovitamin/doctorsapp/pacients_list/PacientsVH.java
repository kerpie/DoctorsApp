package co.herovitamin.doctorsapp.pacients_list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.herovitamin.doctorsapp.R;
import co.herovitamin.doctorsapp.model.Pacient;

/**
 * Created by kerry on 23/06/17.
 */

public class PacientsVH extends RecyclerView.ViewHolder {

    @BindView(R.id.pacient_name)
    TextView name;
    @BindView(R.id.pacient_result)
    TextView result;

    public PacientsVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Pacient pacient){
        this.name.setText(pacient.getName());
        this.result.setText(pacient.predict() + "%");
    }
}
