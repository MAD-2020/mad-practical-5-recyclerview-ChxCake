package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class BrandViewHolder extends RecyclerView.ViewHolder{
    TextView txt;
    CheckBox checkbox;
    View view;
    public BrandViewHolder (View itemView){
        super(itemView);
        txt=itemView.findViewById(R.id.textViewThis);
        checkbox=itemView.findViewById(R.id.checkBoxLayoutTwo);
        view=itemView;
    }
}
