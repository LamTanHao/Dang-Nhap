package com.example.student.myapplication;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    EditText edt_username,edt_pass,edttk,edtmk;
    Button btndangnhap,btndangky,btnHuy,btnDongY;
    String ten,mk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();


        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dailog = new Dialog(MainActivity.this);
                dailog.setTitle("xu ly hop thoai");
                dailog.setCancelable(false);
                dailog.setContentView(R.layout.customdailog);
                final EditText edttk = (EditText)dailog.findViewById(R.id.edttk);
                final EditText edtmk = (EditText)dailog.findViewById(R.id.edtmk);
                Button btnhuy = (Button)dailog.findViewById(R.id.btnHuy);
                Button btndongy = (Button)dailog.findViewById(R.id.btnDongY);
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();

                        edt_username.setText(ten);
                        edt_pass.setText(mk);

                        dailog.cancel();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dailog.cancel();
                    }
                });
                dailog.show();
            }
        });

        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt_username.getText().length() != 0 && edt_pass.getText().length() !=0) {
                    if (edt_username.getText().toString().equals(ten) && edt_pass.getText().toString().equals(mk))
                        ;
                    Toast.makeText(MainActivity.this, "Ban dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                }

            else{
                if(edt_username.getText().toString().equals("Hao") && edt_pass.getText().toString().equals("123")){
                    Toast.makeText(MainActivity.this, "Ban dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    }else {
                    Toast.makeText(MainActivity.this, "Ban dang nhap that bai", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Moi ban nhap du thong tin", Toast.LENGTH_SHORT).show();
                }
            }

        }});

    }

    private void AnhXa() {
        edt_username = (EditText)findViewById(R.id.edt_username);
        edt_pass=(EditText)findViewById(R.id.edt_pass);
        btndangky=(Button)findViewById(R.id.btnDangky);
        btndangnhap=(Button)findViewById(R.id.btndangnhap);



    }
}
