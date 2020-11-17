package com.example.nhanvien;

public class nhanvien {
    private int manv;
    private String hoten;
    private String donvi;
    private String gioitinh;

    public nhanvien(int manv, String hoten, String donvi, String gioitinh) {
        this.manv = manv;
        this.hoten = hoten;
        this.donvi = donvi;
        this.gioitinh = gioitinh;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        return "nhanvien{" +
                "manv=" + manv +
                ", hoten='" + hoten + '\'' +
                ", donvi='" + donvi + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                '}';
    }
}
