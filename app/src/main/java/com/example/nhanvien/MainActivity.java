package com.example.nhanvien;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnthem, btnsua, btnxoa, btnthoat;
    EditText edtnhapma, edthoten;
    ListView lv;
    RadioGroup rdg;
    RadioButton rdnam, rdnu;
    Spinner spn;
    ArrayList<nhanvien> nvlist = new ArrayList<>();
    ArrayList<String> st_list;
    String[] dvlist;
    String donvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnthem = (Button) findViewById(R.id.them);
        btnsua = (Button) findViewById(R.id.sua);
        btnxoa = (Button) findViewById(R.id.xoa);
        edtnhapma = (EditText) findViewById(R.id.editext);
        edthoten = (EditText) findViewById(R.id.hoten);
        lv = (ListView) findViewById(R.id.listnhanvien);
        rdg = (RadioGroup) findViewById(R.id.radiogroup);
        spn = (Spinner) findViewById(R.id.spinner);
        rdnam = (RadioButton) findViewById(R.id.nam);
        rdnu = (RadioButton) findViewById(R.id.nu);
        btnthoat = (Button) findViewById(R.id.buttonthoat);
        add();
        delete();


        // thoát
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });
        //cho class nhân viên hiện thị lên spinner
        dvlist = getResources().getStringArray(R.array.Listdonvi);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dvlist);
        spn.setAdapter(adapter);

        //lấy dữ liệu lựa chọn để hiện thị lên
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donvi = dvlist[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void delete() {
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtnhapma.setText("");
                edthoten.setText("");
                rdg.check(R.id.nam);
                edtnhapma.requestFocus();
            }
        });
    }

    private void add() {
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st_list = new ArrayList<>();
                int ms = Integer.parseInt(edtnhapma.getText().toString());
                String ht = edthoten.getText().toString();
                String gt = ((RadioButton) findViewById(rdg.getCheckedRadioButtonId())).getText().toString();
                nhanvien nv = new nhanvien(ms, ht, gt, donvi);
                nvlist.add(nv);
                for (nhanvien nv1 : nvlist)
                    st_list.add(nv1.toString());
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, st_list);
                lv.setAdapter(adapter);

                // xóa thông tin nhân viên
                lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        st_list.remove(i);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
            }
        });
    }
}
