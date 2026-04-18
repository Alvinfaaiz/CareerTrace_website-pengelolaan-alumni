import java.util.Date;

public class EmailNotification {
    private String recipient;
    private String subject;
    private String body;
    private Date scheduleDate;

    // Fitur 9: set email yang akan dikirim
    public EmailNotification(String recipient, String subject,
                              String body, Date scheduleDate) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
        this.scheduleDate = scheduleDate;
    }

    public void setRecipient(String recipient) { this.recipient = recipient; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setBody(String body) { this.body = body; }
    public void setScheduleDate(Date scheduleDate) { this.scheduleDate = scheduleDate; }

    public String sendReminder(Alumni alumni) {
        System.out.println("Mengirim email ke : " + recipient);
        System.out.println("Subjek            : " + subject);
        System.out.println("Isi               : " + body);
        return "Reminder sent to " + recipient;
    }

    public void getResponse(Alumni alumni) {
        System.out.println("Respons diterima dari: " + recipient);
    }

    public void logNotification() {
        System.out.println("Log — Kepada: " + recipient
            + " | Subjek: " + subject
            + " | Jadwal: " + scheduleDate);
    }
}