public abstract class Personagem{
    private int Ataque;
    private int Defesa;
    private int PVD;
    private String Nome = "Greg";


    public abstract void atacar(Personagem personagem);

    public void defender(){
        System.out.println("Você defende!");
      setDefesa(getDefesa() + (getDefesa() * ((10/100) * getDefesa())));
  
    }
    
    public int getAtaque() {
        return Ataque;
    }
    public void setAtaque(int ataque) {
        Ataque = ataque;
    }
    public int getDefesa() {
        return Defesa;
    }
    public void setDefesa(int defesa) {
        Defesa = defesa;
    }
    public int getPVD() {
        return PVD;
    }
    public void setPVD(int pVD) {
        PVD = pVD;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String Nome) {
        Nome = "greg";
    }
    
    public Personagem(int Ataque, int Defesa, int PVD, String Nome) {
        this.Ataque = Ataque;
        this.Defesa = Defesa;
        this.PVD = PVD;
        this.Nome = Nome;
    }
}