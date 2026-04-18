public class Admin extends User {
    private String jabatan;
    private Alumni[] daftarAlumni;
    private int jumlahAlumni;

    public Admin(String idUser, String name, String email,
                 String password, String jabatan, int kapasitas) {
        super(idUser, name, email, password);
        this.jabatan = jabatan;
        this.daftarAlumni = new Alumni[kapasitas];
        this.jumlahAlumni = 0;
    }

    @Override
    public void getProfile() {
        System.out.println("=== Profile Admin ===");
        System.out.println("Nama    : " + getName());
        System.out.println("Jabatan : " + jabatan);
    }

    public void tambahAlumni(Alumni alumni) {
        if (jumlahAlumni < daftarAlumni.length) {
            daftarAlumni[jumlahAlumni++] = alumni;
        }
    }

    public void deleteAlumni(String idAlumni) {
        for (int i = 0; i < jumlahAlumni; i++) {
            if (daftarAlumni[i] != null &&
                daftarAlumni[i].getIdUser().equals(idAlumni)) {
                for (int j = i; j < jumlahAlumni - 1; j++) {
                    daftarAlumni[j] = daftarAlumni[j + 1];
                }
                daftarAlumni[--jumlahAlumni] = null;
                System.out.println("Alumni berhasil dihapus.");
                return;
            }
        }
        System.out.println("Alumni tidak ditemukan.");
    }

    public void verifyAlumni(Alumni alumni) {
        System.out.println("Alumni " + alumni.getName() + " berhasil diverifikasi.");
    }

    // Fitur 1: cari alumni by nama via interface Searching
    public void cariAlumniByNama(String keyword) {
        System.out.println("=== Hasil Pencarian: \"" + keyword + "\" ===");
        boolean ada = false;
        for (int i = 0; i < jumlahAlumni; i++) {
            if (daftarAlumni[i] == null) continue;
            daftarAlumni[i].cekKeyword(keyword); // panggil interface
            if (daftarAlumni[i].getName().toLowerCase()
                    .contains(keyword.toLowerCase())) {
                daftarAlumni[i].getProfile();
                daftarAlumni[i].displayJobExperience();
                System.out.println("------------------------");
                ada = true;
            }
        }
        if (!ada) System.out.println("Tidak ada alumni dengan nama tersebut.");
    }

    public Alumni[] getDaftarAlumni() { return daftarAlumni; }
    public int getJumlahAlumni() { return jumlahAlumni; }
}