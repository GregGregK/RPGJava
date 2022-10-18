public class Mago extends Personagem{
    public Mago(){
        super(20,10,200, "Mago");
    }

    @Override
    public void atacar(Personagem personagem){
        int dano;
        dano = getAtaque() - personagem.getDefesa();

        if (dano>0){
            personagem.setPVD(personagem.getPVD() - dano);
            System.out.println("Você causou " + dano + "\nPVD restante: " +personagem.getPVD());
        }
        else {
            System.out.println("Errou");
        }
    }
}
