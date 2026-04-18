import java.util.Date;

public class App {
    public static void main(String[] args) {

        separator("SETUP DATA");

        // ===== COMPANY =====
        Company google    = new Company("C001", "Google", "California, USA", 100);
        Company tokopedia = new Company("C002", "Tokopedia", "Jakarta, Indonesia", 100);
        Company pertamina = new Company("C003", "Pertamina", "Jakarta, Indonesia", 100);
        Company gojek     = new Company("C004", "Gojek", "Jakarta, Indonesia", 100);
        Company microsoft = new Company("C005", "Microsoft", "Washington, USA", 100);

        // ===== JOB EXPERIENCE =====
        // Buat tanggal sederhana pakai Date()
        Date jan2020 = new Date(120, 0, 1);  // 2020-01-01
        Date jan2022 = new Date(122, 0, 1);  // 2022-01-01
        Date jan2023 = new Date(123, 0, 1);  // 2023-01-01
        Date jan2024 = new Date(124, 0, 1);  // 2024-01-01

        JobExperience je1 = new JobExperience("JE001", Industri.TEKNOLOGI,
                "Software Engineer", google, jan2020, jan2022);
        JobExperience je2 = new JobExperience("JE002", Industri.TEKNOLOGI,
                "Backend Developer", tokopedia, jan2022, null);
        JobExperience je3 = new JobExperience("JE003", Industri.PERMINYAKAN,
                "Drilling Engineer", pertamina, jan2020, jan2023);
        JobExperience je4 = new JobExperience("JE004", Industri.TEKNOLOGI,
                "Android Developer", gojek, jan2023, null);
        JobExperience je5 = new JobExperience("JE005", Industri.TEKNOLOGI,
                "Data Analyst", google, jan2022, null);
        JobExperience je6 = new JobExperience("JE006", Industri.TEKNOLOGI,
                "Cloud Engineer", microsoft, jan2020, jan2024);
        JobExperience je7 = new JobExperience("JE007", Industri.TEKNOLOGI,
                "ML Engineer", google, jan2023, null);
        JobExperience je8 = new JobExperience("JE008", Industri.PERMINYAKAN,
                "Process Engineer", pertamina, jan2022, null);

        // ===== ALUMNI =====
        Alumni budi  = new Alumni("A001", "Budi Santoso",  "budi@email.com",  "pass1", 2018, "Teknik Informatika");
        Alumni sari  = new Alumni("A002", "Sari Dewi",     "sari@email.com",  "pass2", 2019, "Sistem Informasi");
        Alumni andi  = new Alumni("A003", "Andi Wijaya",   "andi@email.com",  "pass3", 2018, "Teknik Informatika");
        Alumni rina  = new Alumni("A004", "Rina Putri",    "rina@email.com",  "pass4", 2020, "Teknik Kimia");
        Alumni doni  = new Alumni("A005", "Doni Budiman",  "doni@email.com",  "pass5", 2019, "Teknik Informatika");
        Alumni hapus = new Alumni("A006", "Alumni Salah",  "hapus@email.com", "pass6", 2017, "Teknik Sipil");

        budi.addJob(je1);
        budi.addJob(je2);
        sari.addJob(je5);
        andi.addJob(je6);
        andi.addJob(je7);
        rina.addJob(je3);
        rina.addJob(je8);
        doni.addJob(je4);

        // ===== ADMIN =====
        Admin admin = new Admin("ADM001", "Dr. Hendra", "hendra@kampus.ac.id",
                "adminpass", "Kepala Career Center", 50);
        admin.tambahAlumni(budi);
        admin.tambahAlumni(sari);
        admin.tambahAlumni(andi);
        admin.tambahAlumni(rina);
        admin.tambahAlumni(doni);
        admin.tambahAlumni(hapus);

        // ===== CAREER STATISTIC =====
        CareerStatistic stat = new CareerStatistic(
                admin.getDaftarAlumni(), admin.getJumlahAlumni());

        // ===== EMAIL NOTIFICATION =====
        EmailNotification email = new EmailNotification(
                "budi@email.com", "Update Data Alumni",
                "Halo Budi, mohon perbarui data riwayat pekerjaan Anda.",
                new Date());

        // ============================================================
        separator("FITUR 2 — TAMPIL PROFILE ALUMNI");
        budi.getProfile();

        separator("FITUR 4 — TAMPIL PROFILE ADMIN");
        admin.getProfile();

        separator("FITUR 5 — INFO PERUSAHAAN (LOKASI + JUMLAH ALUMNI)");
        google.tampilInfo();
        pertamina.tampilInfo();

        separator("FITUR 6 — TAMPIL RIWAYAT PEKERJAAN ALUMNI");
        budi.displayJobExperience();
        rina.displayJobExperience();

        separator("FITUR 7 — ALUMNI TAMBAH RIWAYAT PEKERJAAN");
        JobExperience jeNew = new JobExperience("JE009", Industri.KEUANGAN,
                "Financial Analyst", new Company("C006", "Bank Mandiri", "Jakarta", 50),
                jan2024, null);
        sari.addJob(jeNew);
        sari.displayJobExperience();

        separator("FITUR 8 — ALUMNI HAPUS SATU RIWAYAT PEKERJAAN");
        System.out.println("Sebelum hapus:");
        budi.displayJobExperience();
        budi.deleteJob(1); // hapus index ke-1
        System.out.println("Sesudah hapus:");
        budi.displayJobExperience();

        separator("FITUR 8 — ALUMNI HAPUS LEBIH DARI SATU RIWAYAT PEKERJAAN");
        System.out.println("Sebelum hapus:");
        andi.displayJobExperience();
        andi.deleteJobs(new int[]{1, 2}); // hapus index 1 dan 2
        System.out.println("Sesudah hapus (semua terhapus):");
        andi.displayJobExperience();

        separator("FITUR 9 — SET & KIRIM EMAIL NOTIFICATION");
        email.logNotification();
        email.sendReminder(budi);

        separator("FITUR 1 — CARI ALUMNI BY NAMA (via interface Searching)");
        admin.cariAlumniByNama("Budi");

        separator("FITUR 1 — CARI ALUMNI BY NAMA — TIDAK DITEMUKAN");
        admin.cariAlumniByNama("Joko");

        separator("FITUR 3 — ADMIN HAPUS ALUMNI YANG SALAH");
        System.out.println("Sebelum hapus, jumlah alumni: " + admin.getJumlahAlumni());
        admin.deleteAlumni("A006");
        System.out.println("Sesudah hapus, jumlah alumni: " + admin.getJumlahAlumni());

        // Rebuild stat setelah hapus
        stat = new CareerStatistic(admin.getDaftarAlumni(), admin.getJumlahAlumni());

        separator("FITUR 15 — INPUT RIWAYAT KERJA (kategori industri + tanggal)");
        // Simulasi input: budi tambah job baru dengan semua field
        JobExperience jeDetail = new JobExperience(
                "JE010",
                Industri.TEKNOLOGI,          // set kategori industri
                "Senior Engineer",
                google,
                jan2023,                     // set mulai bekerja
                null                         // null = masih bekerja
        );
        budi.addJob(jeDetail);
        budi.displayJobExperience();

        separator("FITUR 6 — CARI NAMA PERUSAHAAN (via interface Searching)");
        google.cekKeyword("Google");
        google.cekKeyword("Amazon");
        pertamina.cekKeyword("Pertam");

        separator("FITUR 11 — TOP 10 COMPANY SELURUH ALUMNI KAMPUS");
        // Tambahkan kembali job andi agar data lebih kaya
        andi.addJob(je6);
        andi.addJob(je7);
        stat = new CareerStatistic(admin.getDaftarAlumni(), admin.getJumlahAlumni());
        stat.getTopCompanies();

        separator("FITUR 11 — TOP 10 COMPANY BY JURUSAN TEKNIK INFORMATIKA");
        stat.getTopCompaniesByJurusan("Teknik Informatika");

        separator("FITUR 11 — TOP 10 COMPANY BY JURUSAN TEKNIK KIMIA");
        stat.getTopCompaniesByJurusan("Teknik Kimia");

        separator("FITUR 12 — DISTRIBUSI PERUSAHAAN PER JURUSAN");
        stat.tampilDistribusiByJurusan();

        separator("FITUR 13 — ALUMNI BY JURUSAN");
        stat.tampilAlumniByJurusan("Teknik Informatika");

        separator("FITUR 14 — ALUMNI BY COMPANY");
        stat.tampilAlumniByCompany("Google");
        stat.tampilAlumniByCompany("Pertamina");
    }

    // Helper untuk pemisah output
    static void separator(String judul) {
        System.out.println("\n============================================================");
        System.out.println("  " + judul);
        System.out.println("============================================================");
    }
}