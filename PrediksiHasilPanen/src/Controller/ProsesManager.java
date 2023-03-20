package Controller;

import java.util.ArrayList;
import java.util.Collections;

public class ProsesManager {

    public ArrayList<Double> mean;
    public ArrayList<Double> selisih;
    public ArrayList<Double> prediksi;
    public ArrayList<ArrayList> data_angka;

    //data yang telah dikirim dari button proses
    public void do_proses_prediksi(ArrayList<ArrayList> data) {
        //membikin array agar dapat dimasukan data
        data_angka = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            ArrayList<Double> data_angka_temp = new ArrayList<>();
            for (int j = 0; j < data.get(0).size(); j++) {
                double val = 0;
                //di try catch agar melihat datanya null atau tidak, dan akan mengubah data null menjadi 0
                try {
                    val = Double.parseDouble(data.get(i).get(j).toString());
                } catch (NumberFormatException e) {
                    System.err.println("konversi string to double gagal!");
                }
                data_angka_temp.add(val);
            }
            data_angka.add(data_angka_temp);
//            System.out.println(data_angka);
        }
//        ArrayList<ArrayList> rule = new ArrayList<>();
//        ArrayList<String> rule_temp = new ArrayList<>();
//        rule_temp.add("turun");
//        rule_temp.add("sedikit");
//        rule.add(rule_temp);
//
//        rule_temp = new ArrayList<>();
//        rule_temp.add("turun");
//        rule_temp.add("banyak");
//        rule.add(rule_temp);
//
//        rule_temp = new ArrayList<>();
//        rule_temp.add("naik");
//        rule_temp.add("sedikit");
//        rule.add(rule_temp);
//
//        rule_temp = new ArrayList<>();
//        rule_temp.add("naik");
//        rule_temp.add("banyak");
//        rule.add(rule_temp);
        
        //membuat nilai menjadi double
        double minimum_panen = Double.parseDouble(data_angka.get(0).get(0).toString());
        double maximum_panen = Double.parseDouble(data_angka.get(0).get(0).toString());
        double minimum_pemupukan = Double.parseDouble(data_angka.get(0).get(0).toString());
        double maximum_pemupukan = Double.parseDouble(data_angka.get(0).get(0).toString());

        //mencari nilai max min panen
        for (int i = 0; i < data_angka.size(); i++) {
            Double min_p = (Double) Collections.min(data_angka.get(i));
            if (minimum_panen >= min_p) {
                minimum_panen = min_p;
            }
            Double max_p = (Double) Collections.max(data_angka.get(i));
            if (maximum_panen <= max_p) {
                maximum_panen = max_p;
            }
        }
        //mencari nilai max min pemupukan
        for (int i = 0; i < data_angka.size(); i++) {
            Double min_pm = (Double) Collections.min(data_angka.get(i));
            if (minimum_pemupukan >= min_pm) {
                minimum_pemupukan = min_pm;
            }//System.out.println(data_angka);

            Double max_pm = (Double) Collections.max(data_angka.get(i));
            if (maximum_pemupukan <= max_pm) {
                maximum_pemupukan = max_pm;
            }//System.out.println(data_angka);
        }
        
        //membuat nilai max min untuk menjadi nilai pengkalian nantinya
        maximum_panen = 3537;
        minimum_panen = 1525;
        maximum_pemupukan = 244;
        minimum_pemupukan = 0;
        
//        maximum_panen = 4251;
//        minimum_panen = 1525;
//        maximum_pemupukan = 4251;
//        minimum_pemupukan = 1525;
        //prediksi
        
        System.out.println("");
        System.out.println("data_angka");
        System.out.println(data_angka);

        System.out.println("");
        System.out.println("");
        System.out.println(data_angka.size());
        System.out.println("-------------------------");

        ArrayList<ArrayList> hasil_rule = new ArrayList<>();
        prediksi = new ArrayList<>();
        //membikin array kembali untuk mencari nilai prediksi, hasil rule, alpa predikat dan nilai mean error
        for (int i = 0; i < data_angka.size(); i++) {
            ArrayList<Double> temp = new ArrayList<>();
            
            System.out.println("perulangan ke - "+i);
            System.out.println("");
            
            //rumus mencari nilai (defuzifikasi)
            double hasil_panen_turun = ((maximum_panen - Double.parseDouble(data_angka.get(i).get(0).toString())) / (maximum_panen - minimum_panen));
            double hasil_panen_naik = ((Double.parseDouble(data_angka.get(i).get(0).toString()) - minimum_panen) / (maximum_panen - minimum_panen));
            double pemupukan_sedikit = ((maximum_pemupukan - Double.parseDouble(data_angka.get(i).get(1).toString())) / (maximum_pemupukan - minimum_pemupukan));
            double pemupukan_banyak = ((Double.parseDouble(data_angka.get(i).get(1).toString()) - minimum_pemupukan) / (maximum_pemupukan - minimum_pemupukan));
            
            temp.add(hasil_panen_turun);
            temp.add(hasil_panen_naik);
            temp.add(pemupukan_sedikit);
            temp.add(pemupukan_banyak);
            
            //nilai dari rumus diatas
            System.out.println("hasil panen turun :");
            System.out.println(hasil_panen_turun);
            System.out.println("hasil panen naik :");
            System.out.println(hasil_panen_naik);
            System.out.println("pemupukan sedikit :");
            System.out.println(pemupukan_sedikit);
            System.out.println("pemupukan banyak :");
            System.out.println(pemupukan_banyak);
            hasil_rule.add(temp);
            System.out.println("");
            System.out.println("hasil_rule");
            System.out.println(hasil_rule);

            //mengambil nilai untuk menentukan nilai rule nantinya
            double x1 = Double.parseDouble(hasil_rule.get(i).get(0).toString());
            double x2 = Double.parseDouble(hasil_rule.get(i).get(1).toString());
            double x3 = Double.parseDouble(hasil_rule.get(i).get(2).toString());
            double x4 = Double.parseDouble(hasil_rule.get(i).get(3).toString());

            //mengambil nilai dari masing" rule untuk mendapatkan alpa predikat
            double R1 = (x1 < x3) ? (x1) : (x3);
            double R2 = (x1 < x4) ? (x1) : (x4);
            double R3 = (x2 < x3) ? (x2) : (x3);
            double R4 = (x2 < x4) ? (x2) : (x4);

            //rumus mencari nilai hasil dari alpa predikat dikali nilai minimum dan maximum panen
            double hasil_akhir_r1 = R1 * minimum_panen;
            double hasil_akhir_r2 = R2 * minimum_panen;
            double hasil_akhir_r3 = R3 * maximum_panen;
            double hasil_akhir_r4 = R4 * maximum_panen;
            double hasil_akhir = hasil_akhir_r1 + hasil_akhir_r2 + hasil_akhir_r3 + hasil_akhir_r4;

            System.out.println("hasil akhir = ");
            System.out.println(hasil_akhir);

            //total alpa predikat
            double hasil_alpa = R1 + R2 + R3 + R4;

            System.out.println("hasil alpa = ");
            System.out.println(hasil_alpa);

            //menentukan prediksi dari hasil bagi hasil akhir dan alpa predikat
            double prediksi_akhir = hasil_akhir / hasil_alpa;

            System.out.println("prediksi akhir = ");
            System.out.println(prediksi_akhir);

            System.out.println("--------------------------");

            prediksi.add(prediksi_akhir);
        }
        
        //mencari nilai error
        selisih = new ArrayList<>();
        for (int i = 0; i < prediksi.size(); i++) {
            double temp = Double.parseDouble(data_angka.get(i).get(2).toString()) - prediksi.get(i);
            selisih.add(temp);
//            System.out.println("-----------");
//            System.out.println(selisih);
//            System.out.println("-----------");
        }

        //mencari nilai rata" error
        mean = new ArrayList<>();
//        double rate_error = 0.0;
        for (int i = 0; i < selisih.size(); i++) {
//            rate_error += (selisih.get(i) / Double.parseDouble(data_angka.get(i).get(2).toString()))*100;
            mean.add(Math.abs(selisih.get(i) / Double.parseDouble(data_angka.get(i).get(2).toString())));
            System.out.println("-----------");
            System.out.println(mean);
            System.out.println("-----------");
        }

    }
}
