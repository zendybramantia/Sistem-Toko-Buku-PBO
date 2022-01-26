package Controller;

import Object.Employee;
import Model.BukuModel;
import Model.KategoriModel;
import View.TambahBukuView;
import Object.Buku;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TambahBukuController implements ActionListener {
    TambahBukuView tambahBukuView;
    private BukuModel bukuModel;
    private KategoriModel kategoriModel;
    private Employee user;
    public TambahBukuController(Employee user) {
        this.user = user;
        tambahBukuView = new TambahBukuView();
        tambahBukuView.setVisible(true);
        tambahBukuView.addListener(this);
        bukuModel = new BukuModel();
        kategoriModel = new KategoriModel();
        tambahBukuView.fillCbKategori(kategoriModel.getDataKategori());
        tambahBukuView.getLabelISBN1().setVisible(false);
    }

    private Buku addBuku(){
        String namaKategori = tambahBukuView.getCbKategori().getSelectedItem().toString();
        String tahunTerbit = tambahBukuView.getCbTahun().getSelectedItem() +"-"+ tambahBukuView.getCbBulan().getSelectedItem()+"-"+tambahBukuView.getCbTanggal().getSelectedItem();

        Buku buku = new Buku(tambahBukuView.getTfISBN().getText(),
                kategoriModel.getIDKategori(namaKategori),
                tambahBukuView.getTfJudul().getText(),
                tambahBukuView.getTfPenulis().getText(),
                tambahBukuView.getTfPenerbit().getText(), tahunTerbit,
                Integer.parseInt(tambahBukuView.getTfHarga().getText()),
                (Integer)(tambahBukuView.getSpinnerStok().getValue()));
        return buku;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionEvent = e.getSource();
        if (actionEvent == tambahBukuView.getButtonKonfirmasi()){
            if (tambahBukuView.getTfISBN().getText().isEmpty() ||
                    tambahBukuView.getTfJudul().getText().isEmpty() ||
                    tambahBukuView.getTfPenulis().getText().isEmpty() ||
                    tambahBukuView.getTfPenerbit().getText().isEmpty() ||
                    tambahBukuView.getTfHarga().getText().isEmpty() ||
                    tambahBukuView.getCbKategori().getSelectedItem().toString() == "Pilih Kategori"){
                JOptionPane.showMessageDialog(tambahBukuView, "field tidak boleh kosong");
            }else{
                try {
                    bukuModel.addBuku(addBuku());
                    JOptionPane.showMessageDialog(tambahBukuView, "Buku berhasil ditambahkan");
                    new BukuController(user);
                    tambahBukuView.dispose();
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(tambahBukuView, "Input tidak valid");
                }
            }
        }else if(e.getSource() == tambahBukuView.getButtonKembali()){
            new BukuController(user);
            tambahBukuView.dispose();
        }
    }
}
