package model;

import java.util.Objects;

public class SanPham {
    private String maSanPham;
    private String tenSanpham;
    private int soLuong;
    private double gia;
    private String xuatXu;
    private int trangThai;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanpham, int soLuong, double gia, String xuatXu, int trangThai) {
        this.maSanPham = maSanPham;
        this.tenSanpham = tenSanpham;
        this.soLuong = soLuong;
        this.gia = gia;
        this.xuatXu = xuatXu;
        this.trangThai = trangThai;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanpham() {
        return tenSanpham;
    }

    public void setTenSanpham(String tenSanpham) {
        this.tenSanpham = tenSanpham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    // Phương thức xuất sản phẩm (trừ số lượng khi xuất hàng)
    public void xuatHang(int soLuongXuat) {
        this.soLuong -= soLuongXuat;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSanPham=" + maSanPham + ", tenSanpham=" + tenSanpham + ", soLuong=" + soLuong + ", gia=" + gia + ", xuatXu=" + xuatXu + ", trangThai=" + trangThai + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.maSanPham);
        hash = 37 * hash + Objects.hashCode(this.tenSanpham);
        hash = 37 * hash + this.soLuong;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.gia) ^ (Double.doubleToLongBits(this.gia) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.xuatXu);
        hash = 37 * hash + this.trangThai;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SanPham other = (SanPham) obj;
        if (this.soLuong != other.soLuong) {
            return false;
        }
        if (Double.doubleToLongBits(this.gia) != Double.doubleToLongBits(other.gia)) {
            return false;
        }
        if (this.trangThai != other.trangThai) {
            return false;
        }
        if (!Objects.equals(this.maSanPham, other.maSanPham)) {
            return false;
        }
        if (!Objects.equals(this.tenSanpham, other.tenSanpham)) {
            return false;
        }
        return Objects.equals(this.xuatXu, other.xuatXu);
    }
}
 