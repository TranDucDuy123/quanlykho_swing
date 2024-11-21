package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.JDBCUtil;
import model.SanPham;

public class SanPhamDAO implements DAOInterface<SanPham> {

    public static SanPhamDAO getInstance() {
        return new SanPhamDAO();
    }

    @Override
    public int insert(SanPham sp) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO sanpham (maSanPham, tenSanpham, soLuong, gia, xuatXu, trangThai) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, sp.getMaSanPham());
            pst.setString(2, sp.getTenSanpham());
            pst.setInt(3, sp.getSoLuong());
            pst.setDouble(4, sp.getGia());
            pst.setString(5, sp.getXuatXu());
            pst.setInt(6, sp.getTrangThai());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public int update(SanPham sp) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE sanpham SET tenSanpham=?, soLuong=?, gia=?, xuatXu=?, trangThai=? WHERE maSanPham=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, sp.getTenSanpham());
            pst.setInt(2, sp.getSoLuong());
            pst.setDouble(3, sp.getGia());
            pst.setString(4, sp.getXuatXu());
            pst.setInt(5, sp.getTrangThai());
            pst.setString(6, sp.getMaSanPham());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public int delete(SanPham sp) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM sanpham WHERE maSanPham=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, sp.getMaSanPham());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public ArrayList<SanPham> selectAll() {
        ArrayList<SanPham> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM sanpham";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maSanPham = rs.getString("maSanPham");
                String tenSanpham = rs.getString("tenSanpham");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String xuatXu = rs.getString("xuatXu");
                int trangThai = rs.getInt("trangThai");
                SanPham sp = new SanPham(maSanPham, tenSanpham, soLuong, gia, xuatXu, trangThai);
                ketQua.add(sp);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public SanPham selectById(String maSanPham) {
        SanPham ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM sanpham WHERE maSanPham=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maSanPham);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String tenSanpham = rs.getString("tenSanpham");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String xuatXu = rs.getString("xuatXu");
                int trangThai = rs.getInt("trangThai");
                ketQua = new SanPham(maSanPham, tenSanpham, soLuong, gia, xuatXu, trangThai);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    public int updateSoLuong(String maSanPham, int soluong) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE sanpham SET soLuong=? WHERE maSanPham=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, soluong);
            pst.setString(2, maSanPham);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    public int deleteTrangThai(String maSanPham) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE sanpham SET trangThai=0 WHERE maSanPham=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maSanPham);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    public ArrayList<SanPham> selectAllExist() {
        ArrayList<SanPham> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM sanpham WHERE trangThai=1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maSanPham = rs.getString("maSanPham");
                String tenSanpham = rs.getString("tenSanpham");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String xuatXu = rs.getString("xuatXu");
                int trangThai = rs.getInt("trangThai");
                SanPham sp = new SanPham(maSanPham, tenSanpham, soLuong, gia, xuatXu, trangThai);
                ketQua.add(sp);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    public int getSl() {
        int soluong = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT COUNT(*) as soluong FROM sanpham WHERE trangThai=1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                soluong = rs.getInt("soluong");
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soluong;
    }
}
