package Controller;

import Object.Employee;
import Object.Buku;
import Model.BukuModel;
import Model.KategoriModel;
import View.TambahBukuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditBukuController implements ActionListener {
    TambahBukuView tambahBukuView;
    BukuModel bukuModel;
    KategoriModel kategoriModel;
    private Buku buku;
    private Employee user;
    public EditBukuController(Buku buku, Employee user) {
        this.user = user;
        this.buku = buku;
        tambahBukuView = new TambahBukuView();
        tambahBukuView.setVisible(true);
        tambahBukuView.addListener(this);
        bukuModel = new BukuModel();
        kategoriModel = new KategoriModel();
        tambahBukuView.getTfISBN().setVisible(false);
        tambahBukuView.getLabelISBN().setVisible(false);
        tambahBukuView.setLabelISBN1("      " + buku.getISBN());
        tambahBukuView.fillCbKategori(kategoriModel.getDataKategori());
        tambahBukuView.fillTextField(buku);
    }
    private Buku addBuku(){
        String namaKategori = tambahBukuView.getCbKategori().getSelectedItem() +"";
        String tahunTerbit = tambahBukuView.getCbTahun().getSelectedItem() +"-"+ tambahBukuView.getCbBulan().getSelectedItem()+"-"+tambahBukuView.getCbTanggal().getSelectedItem();

        Buku buku = new Buku(this.buku.getISBN(),
                kategoriModel.getIDKategori(namaKategori),
                tambahBukuView.getTfJudul().getText(),
                tambahBukuView.getTfPenulis().getText(),
                tambahBukuView.getTfPenerbit().getText(), tahunTerbit,
                Integer.parseInt(tambahBukuView.getTfHarga().getText()),
                Integer.parseInt(tambahBukuView.getSpinnerStok().getValue().toString()));
        return buku;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionEvent = e.getSource();
        if (actionEvent == tambahBukuView.getButtonKonfirmasi()){
            if (tambahBukuView.getTfJudul().getText().isEmpty() ||
                    tambahBukuView.getTfPenulis().getText().isEmpty() ||
                    tambahBukuView.getTfPenerbit().getText().isEmpty() ||
                    tambahBukuView.getTfHarga().getText().isEmpty() ||
                    tambahBukuView.getCbKategori().getSelectedItem().toString() == "Pilih Kategori"){
                JOptionPane.showMessageDialog(tambahBukuView, "field tidak boleh kosong");
            }else{
                bukuModel.editBuku(addBuku());
                JOptionPane.showMessageDialog(tambahBukuView, "Buku Berhasil Diedit");
                new BukuController(user);
                tambahBukuView.dispose();
            }
        }else if(e.getSource() == tambahBukuView.getButtonKembali()){
            new BukuController(user);
            tambahBukuView.dispose();
        }
    }
}
