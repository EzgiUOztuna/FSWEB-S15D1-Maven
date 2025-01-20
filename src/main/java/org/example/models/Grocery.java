package org.example.models;

import java.util.*;

public class Grocery {
    // Static listeyi tanımlıyoruz
    public static List<String> groceryList = new ArrayList<>();

    // Kullanıcıdan veri almak için startGrocery metodu
    public void startGrocery() {
        Scanner scanner = new Scanner(System.in);  // Scanner nesnesi

        // Sonsuz döngü, kullanıcı çıkana kadar seçim yapabilir
        while (true) {
            System.out.println("0 - Uygulamayı Durdur");
            System.out.println("1 - Eleman Ekle");
            System.out.println("2 - Eleman Sil");
            System.out.println("3 - Listeyi Yazdır (Sıralı)");
            System.out.print("Bir seçenek girin: ");

            int choice = scanner.nextInt(); // Kullanıcıdan seçim alıyoruz
            scanner.nextLine(); // Enter tuşu sonrası satır sonu karakterini temizliyoruz

            switch (choice) {
                case 0:
                    System.out.println("Uygulama durduruluyor...");
                    return; // Uygulama sonlanır
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz (virgülle ayırın):");
                    String input1 = scanner.nextLine(); // Kullanıcıdan input alıyoruz
                    addItems(input1); // Elemanları ekliyoruz
                    break;
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz (virgülle ayırın):");
                    String input2 = scanner.nextLine(); // Kullanıcıdan input alıyoruz
                    removeItems(input2); // Elemanları siliyoruz
                    break;
                case 3:
                    printSorted(); // Listeyi sıralayıp yazdırıyoruz
                    break;
                default:
                    System.out.println("Geçersiz seçenek, tekrar deneyin.");
            }
        }
    }

    // Eleman ekleme metodu
    public static void addItems(String input) {
        String[] items = input.split(","); // Virgülle ayırarak elemanları alıyoruz
        for (String item : items) {
            item = item.trim(); // Elemanlardaki gereksiz boşlukları temizliyoruz
            if (!item.isEmpty() && !groceryList.contains(item)) {
                groceryList.add(item); // Elemanı listeye ekliyoruz
                Collections.sort(groceryList);
                System.out.println(item + " eklendi.");
            } else {
                System.out.println(item + " zaten listede var veya geçersiz bir giriş.");
            }
        }
    }

    // Eleman silme metodu
    public static void removeItems(String input) {
        String[] items = input.split(","); // Virgülle ayırarak elemanları alıyoruz
        for (String item : items) {
            item = item.trim(); // Elemanlardaki gereksiz boşlukları temizliyoruz
            if (groceryList.contains(item)) {
                groceryList.remove(item); // Elemanı listeden çıkarıyoruz
                System.out.println(item + " silindi.");
            } else {
                System.out.println(item + " listede bulunamadı.");
            }
        }
    }

    // Listeyi sıralayıp ekrana yazdırma metodu
    public static void printSorted() {
        Collections.sort(groceryList); // Listeyi sıralıyoruz
        System.out.println("Sıralanmış Liste:");
        for (String item : groceryList) {
            System.out.println(item); // Her bir elemanı ekrana yazdırıyoruz
        }
    }

    // Liste içinde elemanın olup olmadığını kontrol etme metodu
    public static boolean checkItemIsInList(String product) {
        if (groceryList.contains(product)) {
            System.out.println(product + " bulunuyor.");
            return true;
        } else {
            System.out.println(product + " bulunmuyor.");
            return false;
        }
    }


}
