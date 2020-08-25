package sg.edu.np.mad.mad_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BrandAdapter extends RecyclerView.Adapter<BrandViewHolder>{
    ArrayList<String> data;

    public BrandAdapter(ArrayList<String> input) {
        data = input;
    }

    public BrandViewHolder onCreateViewHolder(
            ViewGroup parent,
        int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.todo2layout,
                parent,
                false);
        return new BrandViewHolder(item);
    }
    public void onBindViewHolder(
            BrandViewHolder holder,
            int position) {
        String s = data.get(position);
        holder.txt.setText(s);

    }

    public int getItemCount() {
        return data.size();
    }
}

