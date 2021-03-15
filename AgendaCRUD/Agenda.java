package AgendaCRUD;

public class Agenda {
    private int id;
    private String nome;
    private String sobrenome;
    private String nascimento;
    private String email;
    private String rotuloEmail;
    private String telefone;
    private String rotuloTelefone;

    public Agenda(){
        this.nome = "";
        this.sobrenome = "";
        this.nascimento = "";
        this.email = "";
        this.rotuloEmail = "";
        this.telefone = "";
        this.rotuloTelefone = "";
    }
    
    public Agenda(String nomeContato, String sobrenome, String nascimento, String email, String rotuloEmail, String telefone, String rotuloTelefone) {
        this.nome = nomeContato;
        this.sobrenome = sobrenome;
        this.nascimento = nascimento;
        this.email = email;
        this.rotuloEmail = rotuloEmail;
        this.telefone = telefone;
        this.rotuloTelefone = rotuloTelefone;
    }
    
    public Agenda(int id, String nomeContato, String sobrenome, String nascimento, String email, String rotuloEmail, String telefone, String rotuloTelefone) {
        this.id = id;
        this.nome = nomeContato;
        this.sobrenome = sobrenome;
        this.nascimento = nascimento;
        this.email = email;
        this.rotuloEmail = rotuloEmail;
        this.telefone = telefone;
        this.rotuloTelefone = rotuloTelefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRotuloEmail() {
        return rotuloEmail;
    }

    public void setRotuloEmail(String rotuloEmail) {
        this.rotuloEmail = rotuloEmail;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRotuloTelefone() {
        return rotuloTelefone;
    }

    public void setRotuloTelefone(String rotuloTelefone) {
        this.rotuloTelefone = rotuloTelefone;
    }
    
}
    
   
