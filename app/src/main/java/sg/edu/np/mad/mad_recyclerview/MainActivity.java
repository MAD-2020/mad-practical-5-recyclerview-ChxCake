package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonadd;
    RecyclerView RecyclerView;
    EditText editTextAdd;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonadd= findViewById(R.id.button);

        editTextAdd=findViewById(R.id.editTextTextEntered);

        final ArrayList<String> toDoList = new ArrayList<>();
        toDoList.add("Buy Milk");
        toDoList.add("Send postage");
        toDoList.add("Buy Android development book");

        RecyclerView=findViewById(R.id.recyclerView);
        final BrandAdapter mAdapter =
                new BrandAdapter(toDoList);

        LinearLayoutManager mLayoutManager =
                new LinearLayoutManager(this);

        RecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.setAdapter(mAdapter);

        buttonadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                toDoList.add(editTextAdd.getText().toString());
                mAdapter.notifyDataSetChanged();
            }
        });


    }

    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
    private void showNewEntry(RecyclerView rv, ArrayList data){
        //scroll to the last item of the recyclerview
        rv.scrollToPosition(data.size() - 1);

        //auto hide keyboard after entry
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
    }
}
