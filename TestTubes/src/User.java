public abstract class User implements Searching {
    private String idUser;
    private String name;
    private String email;
    private String password;

    public User(String idUser, String name, String email, String password) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getIdUser() {
        return idUser;
    }

    public void login(){
        System.out.println("Login berhasil");
    }

    public void logout(){
        System.out.println("Logout berhasil");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPw(String password) {
        this.password = password;
    }

    public abstract void getProfile();//abstract
    
    @Override
    public void cekKeyword(String keyword){
        if (this.name.toLowerCase().contains(keyword.toLowerCase())) {
            System.out.println("Keyword ditemukan pada nama: " + this.name);
        } else {
            System.out.println("Keyword tidak ditemukan pada nama: " + this.name);
        }
    }

}
