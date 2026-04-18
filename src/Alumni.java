public class Alumni extends User {
    private int enrollmentYear;
    private String major;
    private JobExperience[] jobExperience;
    private int jumlahJob;

    public Alumni(String idUser, String name, String email, String password,
                  int enrollmentYear, String major) {
        super(idUser, name, email, password);
        this.enrollmentYear = enrollmentYear;
        this.major = major;
        this.jobExperience = new JobExperience[20];
        this.jumlahJob = 0;
    }

    @Override
    public void getProfile() {
        System.out.println("=== Profile Alumni ===");
        System.out.println("Nama     : " + getName());
        System.out.println("Angkatan : " + enrollmentYear);
        System.out.println("Jurusan  : " + major);
    }

    public int getEnrollmentYear() { return enrollmentYear; }
    public String getMajor() { return major; }
    public JobExperience[] getJobExperience() { return jobExperience; }
    public int getJumlahJob() { return jumlahJob; }

    public void displayJobExperience() {
        System.out.println("=== Riwayat Pekerjaan: " + getName() + " ===");
        if (jumlahJob == 0) { System.out.println("Belum ada riwayat pekerjaan."); return; }
        for (int i = 0; i < jumlahJob; i++) {
            System.out.println((i+1) + ". " + jobExperience[i]);
        }
    }

    public void addJob(JobExperience job) {
        if (jumlahJob < jobExperience.length) {
            jobExperience[jumlahJob++] = job;
            System.out.println("Riwayat pekerjaan berhasil ditambahkan.");
        } else {
            System.out.println("Kapasitas penuh.");
        }
    }

    public void deleteJob(int index) {
        index = index - 1;
        if (index < 0 || index >= jumlahJob) {
            System.out.println("Index tidak valid."); return;
        }
        for (int i = index; i < jumlahJob - 1; i++) {
            jobExperience[i] = jobExperience[i + 1];
        }
        jobExperience[--jumlahJob] = null;
        System.out.println("Riwayat pekerjaan berhasil dihapus.");
    }

    public void deleteJobs(int[] indexes) {
        boolean[] hapus = new boolean[jumlahJob];
        for (int idx : indexes) {
            int i = idx - 1;
            if (i >= 0 && i < jumlahJob) hapus[i] = true;
        }
        JobExperience[] temp = new JobExperience[jobExperience.length];
        int newCount = 0;
        for (int i = 0; i < jumlahJob; i++) {
            if (!hapus[i]) temp[newCount++] = jobExperience[i];
        }
        this.jobExperience = temp;
        this.jumlahJob = newCount;
        System.out.println("Riwayat pekerjaan berhasil dihapus.");
    }
}