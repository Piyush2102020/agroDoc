package com.example.agrodoc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.internal.cache.DiskLruCache;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText n,p,k;
    Spinner region,soilType;
    Button calculate;
    ArrayList<String>soil;
    FloatingActionButton btn;
    ArrayList<DataModel>list;
    RecyclerView recyclerView;
    TextView output;
    DatabaseReference reference;
    Adapter adapter;
    ArrayList<String>regionKList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        soil=new ArrayList<>();
        btn=findViewById(R.id.zone);
        list=new ArrayList<>();
        adapter=new Adapter(getApplicationContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        regionKList=new ArrayList<>();
        n=findViewById(R.id.nitrogen);
        p=findViewById(R.id.p);
        k=findViewById(R.id.k);
        region=findViewById(R.id.region);
        soilType=findViewById(R.id.soilType);
        calculate=findViewById(R.id.calculate);


        // Create AlertDialog
        View dialogView = getLayoutInflater().inflate(R.layout.dialog, null);

        // Create AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();

        reference= FirebaseDatabase.getInstance().getReferenceFromUrl("your database url here");



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),zone.class));
            }
        });
        reference.child("out").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String crop=snapshot.getValue().toString();
                    DataModel dataModel=new DataModel(crop);
                    list.add(dataModel);
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        regionKList.add("Central plateau and hills region");
        regionKList.add("East coast plains and hills region");
        regionKList.add("Eastern himalayan region");
        regionKList.add("Eastern plateau and hills region");
        regionKList.add("Gujarat plains and hills region");
        regionKList.add("Lower gangetic plain region");
        regionKList.add("Middle gangetic plain region");
        regionKList.add("Southern plateau and hills region");
        regionKList.add("Trans gangetic plain region");
        regionKList.add("Upper gangetic plain region");
        regionKList.add("West coast plains and ghat region");
        regionKList.add("Western dry region");
        regionKList.add("Western himalayan region");
        regionKList.add("Western plateau and hills region");
        regionKList.add("Island region");

        soil.add("Alluvial");
        soil.add("Red");
        soil.add("Black");
        soil.add("Brown");
        soil.add("Coastal");
        soil.add("Dessert");
        soil.add("Yellow");
        soil.add("Tarai");


        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,regionKList);
        ArrayAdapter<String> soilAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,soil);


        soilType.setAdapter(soilAdapter);
        region.setAdapter(regionAdapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                // Get text from EditText fields
                String nitrogenText = n.getText().toString();
                String phText = p.getText().toString();
                String kaText = k.getText().toString();


                // Check if EditText fields are empty or non-numeric
                int nitrogen = TextUtils.isEmpty(nitrogenText) ? 0 : Integer.parseInt(nitrogenText);
                int ph = TextUtils.isEmpty(phText) ? 0 : Integer.parseInt(phText);
                int ka = TextUtils.isEmpty(kaText) ? 0 : Integer.parseInt(kaText);

                // Get selected values from Spinners
                String reg = region.getSelectedItem().toString();
                String st = soilType.getSelectedItem().toString();

                // Create DataModel object
                Map<String,String> map=new HashMap<>();
                map.put("n",String.valueOf(nitrogen));
                map.put("p",String.valueOf(ph));
                map.put("k",String.valueOf(ka));
                map.put("s",st.toLowerCase());
                map.put("r",reg.toLowerCase());

                reference.child("prediction").setValue(map);

            }
        });

        recyclerView.setAdapter(adapter);
    }






}