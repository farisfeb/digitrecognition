/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.Arrays;

public class LVQ {

    //GLOBAL VARIABLE, kegunaan sesuai dengan nama
    public int[] dataUji = new int[6300];
    public int[][] dataLatih = new int[10][6300];
    public double[][] bobotDatalatih = new double[10][6300];
    public double[] jarak = new double[10];
    public double learningRate = 0.8;
    public int epoch = 100;
    public int hasil;
    public int angkaAsli;

    //konstruktor untuk menentukan angka yang di inputkan
    public LVQ(int angka) {
        this.angkaAsli = angka;
    }

    //memasukkan data latih dan dataUji ke array
    public void setData(int[] dataUji, int[][] dataLatih) {
        for (int i = 0; i < dataUji.length; i++) {
            this.dataUji[i] = dataUji[i];
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < dataLatih[0].length; j++) {
                this.dataLatih[i][j] = dataLatih[i][j];
            }
        }
    }

    //menampilkan biner dari gambar
    public void tampilBiner() {
        System.out.println();
        for (int i = 0; i < this.dataUji.length; i++) {
            System.out.print(this.dataUji[i]);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < this.dataLatih[0].length; j++) {
                System.out.print(this.dataLatih[i][j]);
            }
            System.out.println();
        }
    }

    //untuk menampilkan bobot
    public void tampilBobot() {
        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < this.bobotDatalatih[0].length; j++) {
                System.out.print(this.bobotDatalatih[i][j]);
            }
            System.out.println();
        }
    }

    //untuk menampilkan jarak
    void tampilJarak() {
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(this.jarak[i] + " " + i);
        }
    }

    //proses utama
    public void doIterasi() {
        setBobot();
        for (int i = 0; i <= epoch; i++) {
            System.out.print("Epoch ke-" + i);
            menghitungJarak();
            terdekat();
            updateBobot();
            this.learningRate = 0.96 * this.learningRate;
        }
        tampilJarak();
//        tampilBobot();
    }

    //set bobot awal
    public void setBobot() {
        for (int i = 0; i < bobotDatalatih.length; i++) {
            for (int j = 0; j < bobotDatalatih[0].length; j++) {
                bobotDatalatih[i][j] = Math.random();
            }
        }
    }

    //update bobot
    public void updateBobot() {
        if (this.hasil != this.angkaAsli) {
            for (int j = 0; j < this.bobotDatalatih[0].length; j++) {
                this.bobotDatalatih[this.hasil][j] = this.bobotDatalatih[this.hasil][j] - (this.learningRate * (this.dataLatih[this.hasil][j] - this.bobotDatalatih[this.hasil][j]));
            }
        } else if (this.hasil == this.angkaAsli) {
            for (int j = 0; j < this.bobotDatalatih[0].length; j++) {
                this.bobotDatalatih[this.hasil][j] = this.bobotDatalatih[this.hasil][j] + (this.learningRate * (this.dataLatih[this.hasil][j] - this.bobotDatalatih[this.hasil][j]));
            }
        }

    }

    //menghitung jarak dataUji
    public void menghitungJarak() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < this.dataUji.length; j++) {
                this.jarak[i] = Math.sqrt(Math.pow(this.dataUji[j] - this.bobotDatalatih[i][j], 2));
            }
        }
    }

    //untuk mencari jarak terdekat
    public void terdekat() {
        double[] tampung = {this.jarak[0], this.jarak[1], this.jarak[2], this.jarak[3], this.jarak[4],
            this.jarak[5], this.jarak[6], this.jarak[7], this.jarak[8], this.jarak[9]};
        double min = this.jarak[0];
        for (int i = 0; i < 10; i++) {
            if (tampung[i] <= min) {
                min = tampung[i];
                this.hasil = i;
            }

        }
        System.out.print(" Jarak terdekat = " + this.hasil + "\n");
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }
    public void setEpoch(int epoch) {
        this.epoch = epoch;
    }

}
