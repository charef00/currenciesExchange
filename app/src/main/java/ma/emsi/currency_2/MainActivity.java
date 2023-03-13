package ma.emsi.currency_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText amount_2;
    Button btn_2;
    TextView txt_2;
    Spinner from;
    Spinner to;
    ArrayAdapter<CharSequence> model;
    String[] currencies={"MAD","USD","EUR"};
    String[] symbol={"Dh","$","€"};
    double[][] exchange= {
            {1,0.097,0.091},
            {10.34,1,0.94},
            {11.04,1.06,1}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_2=findViewById(R.id.btn_2);
        txt_2=findViewById(R.id.txt_2);
        from=findViewById(R.id.from_2);
        to=findViewById(R.id.to_2);
        amount_2=findViewById(R.id.amount_2);
        //model=new ArrayAdapter<String>(this, R.layout.item_file,currencies);
        model=ArrayAdapter.createFromResource(this,R.array.currencies,R.layout.item_file);
        from.setAdapter(model);
        to.setAdapter(model);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int rst=Integer.parseInt(amount_2.getText().toString());
                int f=Integer.parseInt(from.getSelectedItemId()+"");
                int t=Integer.parseInt(to.getSelectedItemId()+"");
                double cal=rst*exchange[f][t];
                txt_2.setText(cal+" "+symbol[t]);
            }
        });
    }
}