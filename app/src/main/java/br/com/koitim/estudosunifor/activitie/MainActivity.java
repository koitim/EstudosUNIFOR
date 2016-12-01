package br.com.koitim.estudosunifor.activitie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.com.koitim.estudosunifor.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = (RecyclerView) findViewById(R.id.main_recyclerview_category);
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
//        rvCategory.setAdapter();
    }
}
