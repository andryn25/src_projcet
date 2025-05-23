package com.catering.model.dao.impl;

class MenuDaoImpl implements com.catering.model.dao.MenuDao {
    private java.sql.Connection connection;

    public MenuDaoImpl(java.sql.Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertMenu(com.catering.model.Menu menu) {
        java.lang.String sql = "INSERT INTO menus (nama, deskripsi, harga, ketersediaan, kategori) VALUES (?, ?, ?, ?, ?)";
        try (java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, menu.getNama());
            stmt.setString(2, menu.getDeskripsi());
            stmt.setDouble(3, menu.getHarga());
            stmt.setBoolean(4, menu.getKetersediaan());
            stmt.setString(5, menu.getKategori());
            stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMenu(com.catering.model.Menu menu) {
        java.lang.String sql = "UPDATE menus SET nama = ?, deskripsi = ?, harga = ?, ketersediaan = ?, kategori = ? WHERE id = ?";
        try (java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, menu.getNama());
            stmt.setString(2, menu.getDeskripsi());
            stmt.setDouble(3, menu.getHarga());
            stmt.setBoolean(4, menu.getKetersediaan());
            stmt.setString(5, menu.getKategori());
            stmt.setInt(6, menu.getId());
            stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu(java.lang.String nama) {
        java.lang.String sql = "DELETE FROM menus WHERE nama = ?";
        try (java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nama);
            stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public com.catering.model.Menu getMenuById(java.lang.Integer id) {
        java.lang.String sql = "SELECT * FROM menus WHERE id = ?";
        com.catering.model.Menu menu = null;
        try (java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (java.sql.ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    menu = new com.catering.model.Menu();
                    menu.setId(rs.getInt("id"));
                    menu.setNama(rs.getString("nama"));
                    menu.setDeskripsi(rs.getString("deskripsi"));
                    menu.setHarga(rs.getDouble("harga"));
                    menu.setKetersediaan(rs.getBoolean("ketersediaan"));
                    menu.setKategori(rs.getString("kategori"));
                }
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public java.util.List<com.catering.model.Menu> getAllMenus() {

        java.lang.String sql = "SELECT * FROM menus";
        java.util.List<com.catering.model.Menu> menus = new java.util.ArrayList<>();
        try (java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
                java.sql.ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                com.catering.model.Menu menu = new com.catering.model.Menu();
                menu.setId(rs.getInt("id"));
                menu.setNama(rs.getString("nama"));
                menu.setDeskripsi(rs.getString("deskripsi"));
                menu.setHarga(rs.getDouble("harga"));
                menu.setKetersediaan(rs.getBoolean("ketersediaan"));
                menu.setKategori(rs.getString("kategori"));
                menus.add(menu);
            }

        } catch (java.sql.SQLException e) {

            e.printStackTrace();
        }
        return menus;
    }

    @Override
    public com.catering.model.Menu getMenuByNama(java.lang.String nama) {
        java.lang.String sql = "SELECT * FROM menus WHERE nama = ?";
        com.catering.model.Menu menu = null;
        try (java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nama);
            try (java.sql.ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    menu = new com.catering.model.Menu();
                    menu.setId(rs.getInt("id"));
                    menu.setNama(rs.getString("nama"));
                    menu.setDeskripsi(rs.getString("deskripsi"));
                    menu.setHarga(rs.getDouble("harga"));
                    menu.setKetersediaan(rs.getBoolean("ketersediaan"));
                    menu.setKategori(rs.getString("kategori"));
                }
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

}
