/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class DigitRecognition {

    //array data yang sudah dikonversi menjadi satu dimensi
    public int[] dataUji = new int[6300];
    public int[][] dataLatih = new int[10][6300];
    public String dataUjiPath;
    public int angkaDataUji;//nilai angka sebenarnya

    public DigitRecognition(String dataUjiPath) throws IOException {
        ImageHelper imgHelper = new ImageHelper();
        //dataUji
        this.dataUjiPath = new File(dataUjiPath).getAbsolutePath();
        int[][] tempUji = imgHelper.getBinary(dataUjiPath);

        //dataLatih
        int[][]train1 = imgHelper.getBinary("train/train1.jpg");
        int[][]train2 = imgHelper.getBinary("train/train2.jpg");
        int[][]train3 = imgHelper.getBinary("train/train3.jpg");
        int[][]train4 = imgHelper.getBinary("train/train4.jpg");
        int[][]train5 = imgHelper.getBinary("train/train5.jpg");
        int[][]train6 = imgHelper.getBinary("train/train6.jpg");
        int[][]train7 = imgHelper.getBinary("train/train7.jpg");
        int[][]train8 = imgHelper.getBinary("train/train8.jpg");
        int[][]train9 = imgHelper.getBinary("train/train9.jpg");
        int[][]train10 = imgHelper.getBinary("train/train10.jpg");
        trainTo1Dimensi(tempUji, train1, train2,
                train3, train4, train5, train6, train7,
                train8, train9, train10);
        //set nilai angka sebenarnya
        cariBenar();
    }

    //method untuk mengubah array dua dimensi menjadi satu dimensi
    public int[] toSatuDimensi(int array[][]) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                temp.add(array[i][j]);
            }
        }

        int[] hasil = new int[temp.size()];
        for (int i = 0; i < hasil.length; i++) {
            hasil[i] = temp.get(i);
        }
        return hasil;
    }

    //method untuk mengubah semua dataUji array 2 dimensi menjadi 1 dimensi
    public void trainTo1Dimensi(int[][] uji, int[][] latih1, int[][] latih2,
            int[][] latih3, int[][] latih4, int[][] latih5, int[][] latih6,
            int[][] latih7, int[][] latih8, int[][] latih9, int[][] latih10) {
        this.dataUji = toSatuDimensi(uji);

        int[] hasiL0 = toSatuDimensi(latih1);
        for (int i = 0; i < hasiL0.length; i++) {
            this.dataLatih[0][i] = hasiL0[i];
        }

        int[] hasil1 = toSatuDimensi(latih2);
        for (int i = 0; i < hasil1.length; i++) {
            this.dataLatih[1][i] = hasil1[i];
        }

        int[] hasil2 = toSatuDimensi(latih3);
        for (int i = 0; i < hasil2.length; i++) {
            this.dataLatih[2][i] = hasil2[i];
        }

        int[] hasil3 = toSatuDimensi(latih4);
        for (int i = 0; i < hasil3.length; i++) {
            this.dataLatih[3][i] = hasil3[i];
        }

        int[] hasil4 = toSatuDimensi(latih5);
        for (int i = 0; i < hasil4.length; i++) {
            this.dataLatih[4][i] = hasil4[i];
        }

        int[] hasil5 = toSatuDimensi(latih6);
        for (int i = 0; i < hasil5.length; i++) {
            this.dataLatih[5][i] = hasil5[i];
        }

        int[] hasil6 = toSatuDimensi(latih7);
        for (int i = 0; i < hasil6.length; i++) {
            this.dataLatih[6][i] = hasil6[i];
        }

        int[] hasil7 = toSatuDimensi(latih8);
        for (int i = 0; i < hasil7.length; i++) {
            this.dataLatih[7][i] = hasil7[i];
        }

        int[] hasil8 = toSatuDimensi(latih9);
        for (int i = 0; i < hasil8.length; i++) {
            this.dataLatih[8][i] = hasil8[i];
        }

        int[] hasil9 = toSatuDimensi(latih10);
        for (int i = 0; i < hasil9.length; i++) {
            this.dataLatih[9][i] = hasil9[i];
        }
    }

    //untuk mengambil angka berapa yang di inputkan
    public void cariBenar() {
        if (this.dataUjiPath.equals(new File("test/test1.jpg").getAbsolutePath())) {
            this.angkaDataUji = 0;
        } else if (this.dataUjiPath.equals(new File("test/test2.jpg").getAbsolutePath())) {
            this.angkaDataUji = 1;
        } else if (this.dataUjiPath.equals(new File("test/test3.jpg").getAbsolutePath())) {
            this.angkaDataUji = 2;
        } else if (this.dataUjiPath.equals(new File("test/test4.jpg").getAbsolutePath())) {
            this.angkaDataUji = 3;
        } else if (this.dataUjiPath.equals(new File("test/test5.jpg").getAbsolutePath())) {
            this.angkaDataUji = 4;
        } else if (this.dataUjiPath.equals(new File("test/test6.jpg").getAbsolutePath())) {
            this.angkaDataUji = 5;
        } else if (this.dataUjiPath.equals(new File("test/test7.jpg").getAbsolutePath())) {
            this.angkaDataUji = 6;
        } else if (this.dataUjiPath.equals(new File("test/test8.jpg").getAbsolutePath())) {
            this.angkaDataUji = 7;
        } else if (this.dataUjiPath.equals(new File("test/test9.jpg").getAbsolutePath())) {
            this.angkaDataUji = 8;
        } else if (this.dataUjiPath.equals(new File("test/test10.jpg").getAbsolutePath())) {
            this.angkaDataUji = 9;
        } else if (this.dataUjiPath.equals(new File("test/test11.jpg").getAbsolutePath())) {
            this.angkaDataUji = 0;
        } else if (this.dataUjiPath.equals(new File("test/test12.jpg").getAbsolutePath())) {
            this.angkaDataUji = 1;
        } else if (this.dataUjiPath.equals(new File("test/test13.jpg").getAbsolutePath())) {
            this.angkaDataUji = 2;
        } else if (this.dataUjiPath.equals(new File("test/test14.jpg").getAbsolutePath())) {
            this.angkaDataUji = 3;
        } else if (this.dataUjiPath.equals(new File("test/test15.jpg").getAbsolutePath())) {
            this.angkaDataUji = 4;
        } else if (this.dataUjiPath.equals(new File("test/test16.jpg").getAbsolutePath())) {
            this.angkaDataUji = 5;
        } else if (this.dataUjiPath.equals(new File("test/test17.jpg").getAbsolutePath())) {
            this.angkaDataUji = 6;
        } else if (this.dataUjiPath.equals(new File("test/test18.jpg").getAbsolutePath())) {
            this.angkaDataUji = 7;
        } else if (this.dataUjiPath.equals(new File("test/test19.jpg").getAbsolutePath())) {
            this.angkaDataUji = 8;
        } else if (this.dataUjiPath.equals(new File("test/test20.jpg").getAbsolutePath())) {
            this.angkaDataUji = 9;
        } else if (this.dataUjiPath.equals(new File("test/test21.jpg").getAbsolutePath())) {
            this.angkaDataUji = 0;
        } else if (this.dataUjiPath.equals(new File("test/test22.jpg").getAbsolutePath())) {
            this.angkaDataUji = 1;
        } else if (this.dataUjiPath.equals(new File("test/test23.jpg").getAbsolutePath())) {
            this.angkaDataUji = 2;
        } else if (this.dataUjiPath.equals(new File("test/test24.jpg").getAbsolutePath())) {
            this.angkaDataUji = 3;
        } else if (this.dataUjiPath.equals(new File("test/test25.jpg").getAbsolutePath())) {
            this.angkaDataUji = 4;
        } else if (this.dataUjiPath.equals(new File("test/test26.jpg").getAbsolutePath())) {
            this.angkaDataUji = 5;
        } else if (this.dataUjiPath.equals(new File("test/test27.jpg").getAbsolutePath())) {
            this.angkaDataUji = 6;
        } else if (this.dataUjiPath.equals(new File("test/test28.jpg").getAbsolutePath())) {
            this.angkaDataUji = 7;
        } else if (this.dataUjiPath.equals(new File("test/test29.jpg").getAbsolutePath())) {
            this.angkaDataUji = 8;
        } else if (this.dataUjiPath.equals(new File("test/test30.jpg").getAbsolutePath())) {
            this.angkaDataUji = 9;
        }
    }

    public static void main(String[] args) throws IOException {
        //list objek
        ImageHelper imgHelper = new ImageHelper();
        DigitRecognition main = new DigitRecognition("test/test26.jpg");
        imgHelper.show(imgHelper.getBinary(main.dataUjiPath));//menampilkan gambar

        //proses utama
        LVQ lvq = new LVQ(main.angkaDataUji);
        lvq.setData(main.dataUji, main.dataLatih);
        lvq.doIterasi();

        System.out.println("Input angka = " + main.angkaDataUji);
        System.out.println("LVQ mendeteksi ini angka = " + lvq.hasil);
    }
}
