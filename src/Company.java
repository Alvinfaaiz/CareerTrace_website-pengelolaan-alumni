public class Company implements Searching, generateID {
    private String idCompany;
    private String name;
    private String location;
    private Alumni[] daftarKaryawan;
    private int jumlahAlumni;

    @Override
    public String generateID() {
        return "COMP-" + System.currentTimeMillis();
    }

    public Company(String idCompany, String name, String location, int kapasitas) {
        this.idCompany = generateID();
        this.name = name;
        this.location = location;
        this.daftarKaryawan = new Alumni[kapasitas];
        this.jumlahAlumni = 0;
    }

     public int getJumlahAlumni() {
        return jumlahAlumni;
    }

    public Alumni[] getDaftarKaryawan() {
        return daftarKaryawan;
    }

    public String getIdCompany() {
        return idCompany;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void tampilInfo() {
        System.out.println("=== Info Perusahaan ===");
        System.out.println("Nama     : " + name);
        System.out.println("Lokasi   : " + location);
        System.out.println("Jml Alumni Bekerja: " + jumlahAlumni);
    }

    @Override
    public void cekKeyword(String keyword){
        if (this.name.toLowerCase().contains(keyword.toLowerCase())) {
            System.out.println("Perusahaan ditemukan: " + this.name
                + " | Lokasi: " + location
                + " | Alumni: " + jumlahAlumni);
        } else {
            System.out.println("Keyword \"" + keyword
                + "\" tidak ditemukan di perusahaan: " + this.name);
        }
    }
}

