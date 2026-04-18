public class Company implements Searching{
    private String idCompany;
    private String name;
    private String location;
    private Alumni[] daftarKaryawan;
    private int jumlahKaryawan;

    public Company(String idCompany, String name, String location, int kapasitas) {
        this.idCompany = idCompany;
        this.name = name;
        this.location = location;
        this.daftarKaryawan = new Alumni[kapasitas];
        this.jumlahKaryawan = 0;
    }

     public int getJumlahAlumni() {
        return jumlahKaryawan;
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
        System.out.println("Jml Alumni Bekerja: " + jumlahKaryawan);
    }

    @Override
    public void cekKeyword(String keyword){
        if (this.name.toLowerCase().contains(keyword.toLowerCase())) {
            System.out.println("Perusahaan ditemukan: " + this.name
                + " | Lokasi: " + location
                + " | Alumni: " + jumlahKaryawan);
        } else {
            System.out.println("Keyword \"" + keyword
                + "\" tidak ditemukan di perusahaan: " + this.name);
        }
    }
}

