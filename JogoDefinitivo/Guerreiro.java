public class Guerreiro extends Personagem {

    public Guerreiro(){
        super(30,20,180, "Guerreiro");
    }
    public void mostrarStatus(){
        System.out.printf("O Guerreiro possui %s de ataque, %d de defesa (%s de vida)",getAtaque(), getDefesa(), getPVD());
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
