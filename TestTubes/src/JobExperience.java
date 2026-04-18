import java.util.Date;

public class JobExperience {
    private String idJobExperience;
    private Industri industri;
    private String jabatan;
    private Company company;
    private Date startDate;
    private Date endDate;

     public JobExperience(String idJobExperience, Industri industri,
                         String jabatan, Company company,
                         Date startDate, Date endDate) {
        this.idJobExperience = idJobExperience;
        this.industri = industri;
        this.jabatan = jabatan;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getIdJobExperience() {
        return idJobExperience;
    }

    public Industri getIndustri() {
        return industri;
    }

    public String getJabatan() {
        return jabatan;
    }

    public Company getCompany() {
        return company;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setIndustri(Industri industri) {
        this.industri = industri;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return jabatan + " di " + company.getName()
            + " | Industri: " + industri
            + " | " + startDate + " s/d " + (endDate != null ? endDate : "sekarang");
    }
}
