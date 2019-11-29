package com.univalle.calculator_app;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView cajaRes;
    public double num1, num2, result, memoria;
    public boolean cambia;
    int ope;
    String opera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String send = "El resultado es: "+ result + "\nEl autor del programa es: Manuel Diaz";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,String.valueOf(send));
                startActivity(intent);
            }
        });

        if(savedInstanceState!=null){
            cajaRes = (TextView)findViewById(R.id.resultado);
            cajaRes.setText(savedInstanceState.getString("cajaRes"));
            num1 = savedInstanceState.getDouble("num1");
            num2 = savedInstanceState.getDouble("num2");
            memoria = savedInstanceState.getDouble("memoria");
            opera = savedInstanceState.getString("opera");
            cambia = savedInstanceState.getBoolean("cambia");
        }else{
            cajaRes = (TextView)findViewById(R.id.resultado);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("cajaRes",cajaRes.getText().toString());
        outState.putDouble("num1",num1);
        outState.putDouble("num2",num2);
        outState.putDouble("memoria",memoria);
        outState.putString("opera",opera);
        outState.putBoolean("cambia",cambia);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void butPoint (View view){
        String str = cajaRes.getText().toString();
        str = str + ".";
        cajaRes.setText(str);
    }

    public void but1 (View view){
        String str = cajaRes.getText().toString();
        str = str + "1";
        cajaRes.setText(str);
    }

    public void but2 (View view){
        String str = cajaRes.getText().toString();
        str = str + "2";
        cajaRes.setText(str);
    }

    public void but3 (View view){
        String str = cajaRes.getText().toString();
        str = str + "3";
        cajaRes.setText(str);
    }

    public void but4 (View view){
        String str = cajaRes.getText().toString();
        str = str + "4";
        cajaRes.setText(str);
    }

    public void but5 (View view){
        String str = cajaRes.getText().toString();
        str = str + "5";
        cajaRes.setText(str);
    }

    public void but6 (View view){
        String str = cajaRes.getText().toString();
        str = str + "6";
        cajaRes.setText(str);
    }

    public void but7 (View view){
        String str = cajaRes.getText().toString();
        str = str + "7";
        cajaRes.setText(str);
    }

    public void but8 (View view){
        String str = cajaRes.getText().toString();
        str = str + "8";
        cajaRes.setText(str);
    }

    public void but9 (View view){
        String str = cajaRes.getText().toString();
        str = str + "9";
        cajaRes.setText(str);
    }

    public void but0 (View view){
        String str = cajaRes.getText().toString();
        str = str + "0";
        cajaRes.setText(str);
    }

    public void capturaOpe(View view){
        try{
            num1 = Double.parseDouble(cajaRes.getText().toString());
            cambia = true;

            switch (view.getId()) {
                case R.id.butSuma:
                    opera = "suma";
                    break;
                case R.id.butResta:
                    opera = "resta";
                    break;
                case R.id.butMul:
                    opera = "multiplicacion";
                    break;
                case R.id.butDiv:
                    opera = "division";
                    break;
                case R.id.butPotencia:
                    opera = "potencia";
                    break;
            }
            cajaRes.setText("");
        }catch (Exception e){}
    }

    public void cuadrado(View view){
        try{
            num1 = Double.parseDouble(cajaRes.getText().toString());
            cajaRes.setText(String.valueOf(Math.pow(num1,2)));
        }catch (Exception e){}
    }

    public void raizCuadrada(View view){
        try{
            num1 = Double.parseDouble(cajaRes.getText().toString());
            cajaRes.setText(String.valueOf(Math.sqrt(num1)));
        }catch (Exception e){}

    }
    public void clear(View view){
        num1 = 0;
        num2 = 0;
        cajaRes.setText("");
        result = 0;
    }

    public void delete (View v){
        if (!cajaRes.getText().toString().equals("")){
            cajaRes.setText(cajaRes.getText().subSequence(0,cajaRes.getText().length()-1)+"");
        }
    }

    public void butEqual(View view){
        try{
            if(cambia){
                num2 = Double.parseDouble(cajaRes.getText().toString());
            }
            switch(opera){
                case "suma":
                    result = num1+num2;
                    break;
                case "resta":
                    result = num1-num2;
                    break;
                case "multiplicacion":
                    result = num1*num2;
                    break;
                case "division":
                    result = num1/num2;
                    break;
                case "potencia":
                    result = Math.pow(num1,num2);
                    break;
            }
        }catch (Exception e){}
        cajaRes.setText(String.valueOf(result));
        num1 = result;
        cambia = false;
    }

    public void butMC(View view){
        memoria = 0;
    }

    public void butMadd(View view){
        memoria = Double.parseDouble(cajaRes.getText().toString());
    }

    public void butMrecovery(View view){
        cajaRes.setText(String.valueOf(memoria));
    }
}
