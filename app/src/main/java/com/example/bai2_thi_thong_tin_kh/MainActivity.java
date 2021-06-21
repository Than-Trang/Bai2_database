package com.example.bai2_thi_thong_tin_kh;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Database database;
    EditText edt1,edt2;
    RadioButton rdo1,rdo2,rdo3;
    CheckBox cb1,cb2,cb3;
    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        database = new Database(this,"Thongtinkháchhàng.sqlite",null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS ThongTinKhachHang( id INTEGER PRIMARY KEY AUTOINCREMENT, TenKH VARCHAR(50)," +
                "Sdt VARCHAR(10), UuTien VARCHAR(20), DVThem VARCHAR(20)) ");

        Them();
        Xem();
    }
    public void AnhXa(){
        edt1 = (EditText) findViewById(R.id.ten_kh);
        edt2 = (EditText) findViewById(R.id.sdt_khach);
        rdo1 = (RadioButton) findViewById(R.id.nguoi_gia);
        rdo2 = (RadioButton) findViewById(R.id.tre_nho);
        rdo3 = (RadioButton) findViewById(R.id.co);
        cb1 = (CheckBox) findViewById(R.id.an_com);
        cb2 = (CheckBox) findViewById(R.id.dieu_hoa);
        cb3 = (CheckBox) findViewById(R.id.nong_lanh);
        btn1 = (Button) findViewById(R.id.btn_Them);
        btn2 = (Button) findViewById(R.id.btn_Xem);
        btn3 = (Button) findViewById(R.id.btn_Xoa);
    }
    public boolean KiemTra(){
        //dữ liệu nhập vào có trống hay ko
        String duLieu1 = edt1.getText().toString().trim();
        String duLieu2 = edt2.getText().toString().trim();
        if( duLieu1.length() ==0 || duLieu2.length() ==0) {
            return false;
        }
        return true;
    }
    public boolean KiemTra2(){
        //kiểm tra xem còn ô nào chưa tích ko
        if( (rdo1.isChecked() || rdo2.isChecked() || rdo3.isChecked()) && ( cb1.isChecked()|| cb2.isChecked() || cb3.isChecked()) ){
            return true;
        }
        return false;
    }
    public boolean KiemTraVietHoa(EditText edt1){
        String A= this.edt1.getText().toString().trim();
        int k = 0;
        int a = A.length();
        for(int i=0;i<a; i++){
            if( A.charAt(i) == ' ' && A.charAt(i+1) != ' ' ){
                String tam= A.substring(k,i+1);
                k=i+1;
                if(tam.charAt(0) >64 && tam.charAt(0)<97){
                    return true;
                }

            }
        }
        return false;
    }
    public void Them(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!KiemTra() || !KiemTra2()){
                    Toast.makeText(MainActivity.this,"Vui lòng nhập đầy đủ nội dung",Toast.LENGTH_LONG).show();
                }
                if(!KiemTraVietHoa(edt1)){
                    Toast.makeText(MainActivity.this,"Vui long viết hoa tên riêng",Toast.LENGTH_LONG).show();
                }
                else {
                    String TenKhach = edt1.getText().toString().trim();
                    String sdt=edt2.getText().toString().trim();
                    String rdo = null;
                    String cb = null;
                    if( rdo1.isChecked()) rdo = rdo1.getText().toString();
                    if( rdo2.isChecked()) rdo = rdo2.getText().toString();
                    if( rdo3.isChecked()) rdo = rdo3.getText().toString();
                    if( cb1.isChecked()) cb = cb1.getText().toString();
                    if( cb2.isChecked()) cb = cb2.getText().toString();
                    if( cb3.isChecked()) cb = cb3.getText().toString();
                    if( cb1.isChecked() && cb2.isChecked()){
                        cb = cb2.getText().toString()+ ", "+ cb1.getText().toString();
                    }
                    if( cb3.isChecked() && cb2.isChecked()){
                        cb = cb3.getText().toString()+ ", "+ cb2.getText().toString();
                    }
                    if( cb1.isChecked() && cb3.isChecked()){
                        cb = cb3.getText().toString()+ ", "+ cb1.getText().toString();
                    }
                    if( cb1.isChecked() && cb2.isChecked() && cb3.isChecked()){
                        cb = cb2.getText().toString() +", "+ cb1.getText().toString() +", "+cb3.getText().toString() ;
                    }
                    database.QueryData("INSERT INTO ThongTinKhachHang (TenKH,Sdt,UuTien,DVThem) VALUES('"+TenKhach+"','"+sdt+"','"+rdo+"','"+cb+"')");

                }
            }
        });

    }


    public void Xem(){
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor dataKhachHang = database.getData("SELECT * FROM ThongTinKhachHang");
                dataKhachHang.moveToFirst();
                while (!dataKhachHang.isAfterLast()){
                    int Idkh = dataKhachHang.getInt(0);
                    String Tenkh = dataKhachHang.getString(1);
                    String sdthoai = dataKhachHang.getString(2);
                    String UT = dataKhachHang.getString(3);
                    String DVT = dataKhachHang.getString(4);
                    if( Idkh == 3){
                        Toast.makeText(MainActivity.this,"Id ="+ Idkh +"\n"+ Tenkh+ "\n"+ sdthoai +"\n" + UT + "\n"+ DVT,Toast.LENGTH_LONG).show();
                    }
                    dataKhachHang.moveToNext();
                }

            }
        });

    }
}