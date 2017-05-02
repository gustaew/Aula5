package Model;

public class Cliente {
	private int id;
	private String nome;
	private String email;
	
	public Cliente(int id, String nome, String email){
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	public Cliente(){
		this(0,"","");
	}
	
	public boolean verificaCliente(){
		if(id == 0 && nome == "" && email == ""){
			return true;
		} else {
			return false;
		}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
