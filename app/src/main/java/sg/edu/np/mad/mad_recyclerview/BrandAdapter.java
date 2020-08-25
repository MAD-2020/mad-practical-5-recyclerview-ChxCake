package sg.edu.np.mad.mad_recyclerview;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
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
            final int position) {
        String s = data.get(position);
        holder.txt.setText(s);
        final String ItemTitle = holder.txt.getText().toString();
        holder.view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Delete");
                builder.setMessage("Are you sure you want to delete"+ ItemTitle +"?");
                builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create();
                builder.show();
            }
        });

    }

    public int getItemCount() {
        return data.size();
    }
}

