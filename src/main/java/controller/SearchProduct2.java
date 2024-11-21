package controller;

import dao.SanPhamDAO;
import java.util.ArrayList;
import model.SanPham;

/**
 *
 * @author DELL
 */
public class SearchProduct2 {

    public static SearchProduct2 getInstance() {
        return new SearchProduct2();
    }

    public ArrayList<SanPham> searchTatCa(String text) {
        ArrayList<SanPham> result = new ArrayList<>();
        ArrayList<SanPham> arrsp = SanPhamDAO.getInstance().selectAllExist();
        for (var sp : arrsp) {
            if (sp.getTrangThai() == 1) {
                if (sp.getMaSanPham().toLowerCase().contains(text.toLowerCase()) || sp.getTenSanpham().toLowerCase().contains(text.toLowerCase())
                        || sp.getXuatXu().toLowerCase().contains(text.toLowerCase())) {
                    result.add(sp);
                }
            }
        }
        return result;
    }

    public ArrayList<SanPham> searchMaSanPham(String text) {
        ArrayList<SanPham> result = new ArrayList<>();
        ArrayList<SanPham> arrsp = SanPhamDAO.getInstance().selectAllExist();
        for (var sp : arrsp) {
            if (sp.getTrangThai() == 1) {
                if (sp.getMaSanPham().toLowerCase().contains(text.toLowerCase())) {
                    result.add(sp);
                }
            }
        }
        return result;
    }

    public ArrayList<SanPham> searchTenSanPham(String text) {
        ArrayList<SanPham> result = new ArrayList<>();
        ArrayList<SanPham> arrsp = SanPhamDAO.getInstance().selectAllExist();
        for (var sp : arrsp) {
            if (sp.getTrangThai() == 1) {
                if (sp.getTenSanpham().toLowerCase().contains(text.toLowerCase())) {
                    result.add(sp);
                }
            }
        }
        return result;
    }

    public ArrayList<SanPham> searchSoLuong(String text) {
        ArrayList<SanPham> result = new ArrayList<>();
        ArrayList<SanPham> arrsp = SanPhamDAO.getInstance().selectAllExist();
        for (var sp : arrsp) {
            if (sp.getTrangThai() == 1) {
                if (text.length() != 0) {
                    if (sp.getSoLuong() > Integer.parseInt(text)) {
                        result.add(sp);
                    }
                } else {
                    result.add(sp);
                }
            }
        }
        return result;
    }

    public ArrayList<SanPham> searchDonGia(String text) {
        ArrayList<SanPham> result = new ArrayList<>();
        ArrayList<SanPham> arrsp = SanPhamDAO.getInstance().selectAllExist();
        for (var sp : arrsp) {
            if (sp.getTrangThai() == 1) {
                if (text.length() != 0) {
                    if (sp.getGia() > Integer.parseInt(text)) {
                        result.add(sp);
                    }
                } else {
                    result.add(sp);
                }
            }
        }
        return result;
    }

    public ArrayList<SanPham> searchXuatXu(String text) {
        ArrayList<SanPham> result = new ArrayList<>();
        ArrayList<SanPham> arrsp = SanPhamDAO.getInstance().selectAllExist();
        for (var sp : arrsp) {
            if (sp.getXuatXu().toLowerCase().contains(text.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }

    public ArrayList<SanPham> searchDaXoa(String text) {
        ArrayList<SanPham> result = new ArrayList<>();
        ArrayList<SanPham> arrsp = SanPhamDAO.getInstance().selectAll();
        for (var sp : arrsp) {
            if (sp.getTrangThai() == 0) {
                if (sp.getMaSanPham().toLowerCase().contains(text.toLowerCase())) {
                    result.add(sp);
                }
            }
        }
        return result;
    }

    public SanPham searchId(String text) {
        SanPham result = null;
        ArrayList<SanPham> arrsp = SanPhamDAO.getInstance().selectAllExist();
        for (var sp : arrsp) {
            if (sp.getMaSanPham().toLowerCase().contains(text.toLowerCase())) {
                return sp;
            }
        }
        return null;
    }
}
