# Livecoding-ASD-BAB6

Live Coding Algoritma dan Struktur Data BAB 6 tentang ADT Circular Linked List.

## Soal Live Coding 2 ASD BAB 6:

### ✦︎ Deskripsi
Sebagai panitia resmi F1 Grand Prix, tugasnya adalah menyusun aplikasi pemantau balapan yang memodelkan lintasan melingkar sebagai circular single linked list dengan satu node sentinel bernama “START” sebagai garis start/finish. Circular list menjaga agar setelah mobil terakhir selalu kembali ke awal, dan “START” menjadi acuan konsisten untuk menghitung lap ketika pembalap melintasinya.

### ✦︎ Tujuan
Bangun circular single linked list berurutan START → mobil1 → mobil2 → … → mobilN → kembali ke START. Proses perintah sampai ada pembalap yang mencapai L lap; saat itu balapan langsung berhenti dan pemenang diumumkan.

### ✦︎ Perintah
+ DRIVE S K
  - Temukan node pembalap bernama S, lalu lepas S dari rantai tanpa merusak sifat melingkar.
  - Anggap S “melaju” melewati tepat K node berikutnya searah pointer next, satu per satu, dimulai dari node yang semula berada tepat setelah S.
  - Setiap kali salah satu dari K node yang dilewati adalah “START”, tambah lap[S] sebanyak 1.
  - Setelah melewati K node, sisipkan kembali S tepat setelah node terakhir yang dilewati.
  - Jika K = 0, tidak terjadi perpindahan maupun penambahan lap.
  - Jika setelah perintah ini lap[S] mencapai L, balapan berakhir saat itu juga dan pemenang diumumkan.

**Catatan penting:**
+ Node sentinel “START” tidak pernah dipindahkan atau dihapus.
+ Setelah setiap relinking, circularity wajib terjaga: node terakhir menunjuk kembali ke “START”.

### ✦︎ Format masukan
+ Baris 1: N L

  N = jumlah pembalap pada starting grid, L = target jumlah lap untuk menang
  
+ Baris 2: N string nama pembalap unik tanpa spasi, urutan dari depan ke belakang grid.

  Dibentuk circular list: START → nama1 → nama2 → … → namaN → START.
  
+ Baris 3: Q (banyak perintah).
+ Baris 4.: setiap baris adalah “DRIVE S K” dengan S = nama pembalap yang pasti ada saat perintah diterima, K = bilangan bulat K ≥ 0.

### ✦︎ Format keluaran
+ Begitu sebuah perintah menyebabkan lap[S] = L untuk pembalap S, cetak satu baris: WINNER S
+ lalu hentikan simulasi (perintah berikutnya diabaikan).

### ✦︎ Constraint
+ 1 ≤ N ≤ 200000
+ 1 ≤ L ≤ 10^9
+ 0 ≤ K ≤ 10^9
+ 1 ≤ Q ≤ 200000
+ Implementasi wajib circular single linked list satu arah dengan satu node sentinel “START”. Operasi lepaskan–sisip harus menjaga pointer next sehingga rantai tetap melingkar, dan perhitungan lap hanya bertambah ketika S melewati “START” saat melintasi K node.

### ✦︎ Contoh input

6 3

Verstappen Leclerc Norris Hamilton Sainz Perez

6

DRIVE Verstappen 6

DRIVE Norris 2

DRIVE Verstappen 6

DRIVE Hamilton 1

DRIVE Verstappen 6

DRIVE Sainz 10

### ✦︎ Contoh output
WINNER Verstappen

### ✦︎ Penjelasan langkah demi langkah
+ Keadaan awal

  Posisi sekarang: START → Verstappen → Leclerc → Norris → Hamilton → Sainz → Perez → START; semua lap 0.

1. DRIVE Verstappen 6

    Lepas Verstappen, lintasi 6 node mulai dari Leclerc: Leclerc → Norris → Hamilton → Sainz → Perez → START (melewati START sekali, lap Verstappen=1), sisipkan Verstappen setelah START.

    Posisi sekarang: START → Verstappen → Leclerc → Norris → Hamilton → Sainz → Perez → START; lap: Verstappen=1, lainnya 0.

2. DRIVE Norris 2

    Lepas Norris, lintasi 2 node mulai dari Hamilton: Hamilton → Sainz (tidak melewati START), sisipkan Norris setelah Sainz.

    Posisi sekarang: START → Verstappen → Leclerc → Hamilton → Sainz → Norris → Perez → START; lap: Verstappen=1, lainnya 0.

3. DRIVE Verstappen 6

    Lepas Verstappen, lintasi 6 node mulai dari Leclerc: Leclerc → Hamilton → Sainz → Norris → Perez → START (melewati START sekali, lap Verstappen=2), sisipkan Verstappen setelah START.
  
    Posisi sekarang: START → Verstappen → Leclerc → Hamilton → Sainz → Norris → Perez → START; lap: Verstappen=2, lainnya 0.

4. DRIVE Hamilton 1

    Lepas Hamilton, lintasi 1 node mulai dari Sainz: Sainz (bukan START), sisipkan Hamilton setelah Sainz.
  
    Posisi sekarang: START → Verstappen → Leclerc → Sainz → Hamilton → Norris → Perez → START; lap: Verstappen=2, lainnya 0.

5. DRIVE Verstappen 6

    Lepas Verstappen, lintasi 6 node mulai dari Leclerc: Leclerc → Sainz → Hamilton → Norris → Perez → START (melewati START sekali, lap Verstappen=3=L), sisipkan Verstappen setelah START dan balapan langsung berhenti.

    Posisi finis: START → Verstappen → Leclerc → Sainz → Hamilton → Norris → Perez → START; pemenang: Verstappen (lap=3).

6. DRIVE Sainz 10

    Tidak dieksekusi karena pemenang sudah ditentukan pada langkah sebelumnya sesuai aturan penghentian segera.

