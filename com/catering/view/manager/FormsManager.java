package com.catering.view.manager;

import com.catering.app.Application;
import com.catering.app.MainPanel;

/**
 * Kelas FormsManager bertugas mengatur pergantian tampilan (form) pada
 * aplikasi. Menggunakan pola Singleton agar hanya ada satu instance selama
 * aplikasi berjalan.
 */
public class FormsManager {

    // Instance tunggal FormsManager (Singleton)
    private static FormsManager instance;

    /**
     * Mendapatkan instance FormsManager. Jika belum ada, akan dibuat terlebih
     * dahulu.
     *
     * @return
     */
    public static FormsManager getInstance() {
        if (instance == null) {
            instance = new FormsManager();
        }
        return instance;
    }

    // Konstruktor privat/tanpa parameter (dibiarkan kosong)
    private FormsManager() {
    }

    // Referensi ke jendela utama dan panel utama
    private Application main;
    private MainPanel mainPanel;

    /**
     * Inisialisasi FormsManager dengan referensi Application dan MainPanel.
     * Biasanya dipanggil satu kali saat aplikasi mulai berjalan.
     *
     * @param main
     * @param mainPanel
     */
    public void initApplication(Application main, MainPanel mainPanel) {
        this.main = main;
        this.mainPanel = mainPanel;
    }

    /**
     * Menampilkan form utama (contoh: login, register). Diproses di thread
     * EventQueue agar aman untuk Swing.
     *
     * @param component
     */
    public void showForm(javax.swing.JComponent component) {
        java.awt.EventQueue.invokeLater(() -> {
            mainPanel.setForm(component); // Panel login/register ditempatkan di MainPanel
        });
    }

    /**
     * Menampilkan menu/sidebar setelah login berhasil.
     *
     * @param component
     */
    public void showMenu(javax.swing.JComponent component) {
        java.awt.EventQueue.invokeLater(() -> {
            mainPanel.setContentPanel(component); // Tampilkan Sidebar panel menu di MainPanel
        });
    }

    /**
     * Kosongkan tampilan menu (belum diimplementasikan). Bisa digunakan nanti
     * untuk logout atau reset tampilan.
     *
     * @param component
     */
    public void clearMenu(javax.swing.JComponent component) {
        java.awt.EventQueue.invokeLater(() -> {
            // Belum ada implementasi
        });
    }
}
