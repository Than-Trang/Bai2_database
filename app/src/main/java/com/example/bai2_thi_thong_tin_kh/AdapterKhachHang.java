package com.example.bai2_thi_thong_tin_kh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class AdapterKhachHang extends BaseAdapter {
    private Context context;
    private int Layout;
    private List<Thong_tin> listKhachHang;

    @Override
    public int getCount() {
        return listKhachHang.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder{
        EditText edtTenKH;
        EditText edtSDT;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder =new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(Layout,null);

            //anh xạ
            holder.edtTenKH= (EditText) convertView.findViewById(R.id.ten_kh);
            holder.edtTenKH = (EditText) convertView.findViewById(R.id.sdt_khach);
            convertView.setTag(holder);
        }
        else {
                holder = (ViewHolder) convertView.getTag();
        }
        //gán gia trị
        Thong_tin thongTin = listKhachHang.get(position);
        holder.edtTenKH.setText(thongTin.getTenKH());
        holder.edtSDT.setText(thongTin.getSdt());


        return convertView;
    }
}
