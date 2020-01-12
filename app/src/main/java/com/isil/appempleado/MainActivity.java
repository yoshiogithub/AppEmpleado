package com.isil.appempleado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    /*
    Desarrollar una aplicación móvil que permita realizar el cálculo del pago
    mensual de un empleado de una empresa. Dicho cálculo se realiza de la siguiente
     manera: el sueldo básico se calcula en base al número total de horas trabajadas
     basadas en una tarifa horaria. Al sueldo básico se le aplica una bonificación
     del 35% obteniéndose el sueldo bruto. Al sueldo bruto se le aplica un descuento
     del 12% obteniéndose el sueldo neto. Mostrar el sueldo básico, el sueldo bruto y
     el sueldo neto de un trabajador.
*/
    TextView resultado;
    EditText hora,tarifa;
    DecimalFormat df=new DecimalFormat("0.00");
    String mensaje="";
    double HORA,TARIFA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado=findViewById(R.id.txtresultado);
        hora=findViewById(R.id.txthora);
        tarifa=findViewById(R.id.txttarifa);
    }
    public void calcular(View view){
        if (hora.getText().toString().isEmpty() || tarifa.getText().toString().isEmpty()){
            mensaje="Debe completar todos los campos";
            resultado.setText(mensaje);
        }else{
            HORA=Double.parseDouble(hora.getText().toString());
            TARIFA=Double.parseDouble(tarifa.getText().toString());

        if(mensaje.isEmpty()){
            double s_basico=HORA*TARIFA;
            double bonificacion=s_basico*0.35;
            double s_bruto=s_basico+bonificacion;
            double descuento=s_bruto*0.12;
            double s_neto=s_bruto-descuento;

            String msg="";

            resultado.setText("SUELDO DE EMPLEADO : "+"\n"+"\n"+
                    "_________________________________"+"\n"+
                    "Sueldo Base : "+s_basico+" soles"+"\n"+
                    "Bonificacion : "+bonificacion+" soles"+"\n"+
                    "Sueldo Bruto　："+s_bruto+" soles"+"\n"+
                    "Descuento : "+descuento+" soles"+"\n"+
                    "Sueldo Neto : "+s_neto);
        }

        }

    }

}
