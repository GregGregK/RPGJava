import java.util.ArrayList;
import java.util.Random;

public class Dragao extends Personagem{
    public Dragao(){
        super(30,10,300, "Dragao");
    }

    @Override
    public void atacar(Personagem personagem) {
        int dano;
        dano = getAtaque() - personagem.getDefesa();
        if (dano>0){
            personagem.setPVD(personagem.getPVD() - dano);
            System.out.println("O dragao causou " + dano + "\n PVD restante: " + personagem.getPVD());
        }
        else {
            System.out.println("Dragao errou");
        }
    }

    public Personagem escolhaDragao(ArrayList<Personagem> guilda) {
        int max = guilda.size() - 1;
        int min = 0;
        int range = max - min + 1;
        int posicaoArray = (int) (Math.random() * range);

        System.out.println("\nO Dragão ataca o " + guilda.get(posicaoArray).getNome());
        return guilda.get(posicaoArray);
    } 
}