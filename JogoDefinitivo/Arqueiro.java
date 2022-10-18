public class Arqueiro extends Personagem {
    public Arqueiro(){
        super(20,30,160, "Arqueiro");
    }

    @Override
    public void atacar(Personagem personagem){
        int dano;
        dano = getAtaque() - personagem.getDefesa();

        if (dano>0){
            personagem.setPVD(personagem.getPVD() - dano);
            System.out.println("Você causou " + dano + "\n PVD restante: " + personagem.getPVD());
        }
        else {
            System.out.println("Errou");
        }
    }
}
