public class CareerStatistic {
    private Alumni[] alumniList;
    private int jumlahAlumni;

    public CareerStatistic(Alumni[] alumniList, int jumlahAlumni) {
        this.alumniList = alumniList;
        this.jumlahAlumni = jumlahAlumni;
    }

    // Fitur 11: Top 10 company dari seluruh alumni kampus
    public void getTopCompanies() {
        System.out.println("=== Top 10 Company (Seluruh Alumni Kampus) ===");
        hitungDanTampilTop10(null);
    }

    // Fitur 11: Top 10 company berdasarkan jurusan tertentu
    public void getTopCompaniesByJurusan(String jurusan) {
        System.out.println("=== Top 10 Company — Jurusan: " + jurusan + " ===");
        hitungDanTampilTop10(jurusan);
    }

    // Fitur 12: Distribusi perusahaan per jurusan (semua jurusan)
    public void tampilDistribusiByJurusan() {
        System.out.println("=== Distribusi Perusahaan per Jurusan ===");

        // Kumpulkan semua jurusan unik
        String[] jurusanList = new String[jumlahAlumni];
        int jumlahJurusan = 0;

        for (int i = 0; i < jumlahAlumni; i++) {
            if (alumniList[i] == null) continue;
            String major = alumniList[i].getMajor();
            boolean found = false;
            for (int j = 0; j < jumlahJurusan; j++) {
                if (jurusanList[j].equalsIgnoreCase(major)) {
                    found = true;
                    break;
                }
            }
            if (!found) jurusanList[jumlahJurusan++] = major;
        }

        // Tampilkan top company per jurusan
        for (int j = 0; j < jumlahJurusan; j++) {
            System.out.println("\n-- Jurusan: " + jurusanList[j] + " --");
            hitungDanTampilTop10(jurusanList[j]);
        }
    }

    // Fitur 13: Tampilkan info alumni berdasarkan jurusan
    public void tampilAlumniByJurusan(String jurusan) {
        System.out.println("=== Alumni Jurusan: " + jurusan + " ===");
        boolean ada = false;
        for (int i = 0; i < jumlahAlumni; i++) {
            if (alumniList[i] != null &&
                alumniList[i].getMajor().equalsIgnoreCase(jurusan)) {
                alumniList[i].getProfile();
                System.out.println("------------------------");
                ada = true;
            }
        }
        if (!ada) System.out.println("Tidak ada alumni dari jurusan " + jurusan);
    }

    // Fitur 14: Tampilkan alumni yang bekerja di perusahaan tertentu
    public void tampilAlumniByCompany(String namaCompany) {
        System.out.println("=== Alumni yang Bekerja di: " + namaCompany + " ===");
        boolean ada = false;
        for (int i = 0; i < jumlahAlumni; i++) {
            if (alumniList[i] == null) continue;
            JobExperience[] jobs = alumniList[i].getJobExperience();
            for (int j = 0; j < alumniList[i].getJumlahJob(); j++) {
                if (jobs[j] != null &&
                    jobs[j].getCompany().getName().equalsIgnoreCase(namaCompany)) {
                    System.out.println("- " + alumniList[i].getName()
                        + " | Jurusan: " + alumniList[i].getMajor()
                        + " | Angkatan: " + alumniList[i].getEnrollmentYear()
                        + " | Jabatan: " + jobs[j].getJabatan());
                    ada = true;
                    break;
                }
            }
        }
        if (!ada) System.out.println("Tidak ada alumni di perusahaan tersebut.");
    }

    // Helper internal
    private void hitungDanTampilTop10(String filterJurusan) {
        Company[] companyList = new Company[jumlahAlumni * 10];
        int[] count = new int[jumlahAlumni * 10];
        int jumlahCompany = 0;

        for (int i = 0; i < jumlahAlumni; i++) {
            Alumni alumni = alumniList[i];
            if (alumni == null) continue;
            if (filterJurusan != null &&
                !alumni.getMajor().equalsIgnoreCase(filterJurusan)) continue;

            JobExperience[] jobs = alumni.getJobExperience();
            for (int j = 0; j < alumni.getJumlahJob(); j++) {
                if (jobs[j] == null) continue;
                Company c = jobs[j].getCompany();

                int foundIdx = -1;
                for (int k = 0; k < jumlahCompany; k++) {
                    if (companyList[k].getIdCompany().equals(c.getIdCompany())) {
                        foundIdx = k;
                        break;
                    }
                }
                if (foundIdx == -1) {
                    companyList[jumlahCompany] = c;
                    count[jumlahCompany] = 1;
                    jumlahCompany++;
                } else {
                    count[foundIdx]++;
                }
            }
        }

        // Bubble sort descending
        for (int a = 0; a < jumlahCompany - 1; a++) {
            for (int b = 0; b < jumlahCompany - 1 - a; b++) {
                if (count[b] < count[b + 1]) {
                    int tmp = count[b]; count[b] = count[b+1]; count[b+1] = tmp;
                    Company tmpC = companyList[b];
                    companyList[b] = companyList[b+1];
                    companyList[b+1] = tmpC;
                }
            }
        }

        int tampil = Math.min(10, jumlahCompany);
        if (tampil == 0) { System.out.println("Tidak ada data."); return; }
        for (int i = 0; i < tampil; i++) {
            System.out.println((i+1) + ". " + companyList[i].getName()
                + " — " + count[i] + " alumni");
        }
    }
}