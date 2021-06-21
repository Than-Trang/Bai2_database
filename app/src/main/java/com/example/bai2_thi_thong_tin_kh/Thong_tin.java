package com.example.bai2_thi_thong_tin_kh;

public class Thong_tin {
    private int id;
    private String TenKH;
    private String Sdt;
    private String UuTien;
    private String DVThem;

    public Thong_tin(int id, String tenKH, String sdt, String uuTien, String DVThem) {
        this.id = id;
        TenKH = tenKH;
        Sdt = sdt;
        UuTien = uuTien;
        this.DVThem = DVThem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getUuTien() {
        return UuTien;
    }

    public void setUuTien(String uuTien) {
        UuTien = uuTien;
    }

    public String getDVThem() {
        return DVThem;
    }

    public void setDVThem(String DVThem) {
        this.DVThem = DVThem;
    }
}
