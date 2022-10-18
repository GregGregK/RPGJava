import java.util.ArrayList;
import java.util.Scanner;

public class GameController {


    //Setar arraylist dentro <> esta a classe que estará no array e fora o nome do array
    private ArrayList<Personagem> guilda;

    //guilda = quantidade
    int guildaPersonagens = 0;
    
    public GameController(){
        guilda = new ArrayList<>();
    }


    public void inicio(){
        System.out.println("Herois POO");
        System.out.println("Você é o líder de um time de cavaleiros e precisa escolher entre os melhores para derrotar o dragão");
        System.out.println("[1] Começar Jornada - [2] Conhecer sua equipe - [3] Conheça seu inimigo - [4] Sair");

        Scanner inicio1 = new Scanner(System.in);
        int escolha = inicio1.nextInt();
        if (escolha == 1){
            guildaPersonagens = 0;
            criarGuilda(guilda);
        }
        else if (escolha == 2) {
            System.out.println("O Guerreiro possui 30 de ataque, 20 de defesa, e 180 de vida\nO Mago possui 30 de ataque 10 de defesa, e 200 de vida\nO Arqueiro Possui 20 de ataque 30 de defesa, e 160 de vida ");
            inicio();
        }
        else if (escolha == 3){
            System.out.println("Seu inimigo possui 30 de taque 30 de defesa e 300 de vida");
            inicio();
        }
        else if(escolha == 4){
            System.out.println("Até a próxima!");
            System.exit(0);

        }
        else{
            System.out.println("Não entendi sua resposta!");
        }
    }

    public void criarGuilda(ArrayList<Personagem> guilda){
        boolean adicionarGuilda;
        int guildaMax = 3;
        

        do {
            adicionarGuilda = true;

            System.out.println("Escolha um personagem entre seus favoritos == [0] Se não lembra deles! == \n[1]Mago,\n[2]Arqueiro,\n[3]Guerreiro");
            Scanner guildaEscolhida = new Scanner(System.in);
            int escolha = guildaEscolhida.nextInt();
            
            switch(escolha) {
                case 1:
                System.out.println("Você escolheu o Mago!");
                guilda.add(new Mago());
                break;

                case 2:
                System.out.println("Você escolheu o Arqueiro!");
                guilda.add(new Arqueiro());
                break;

                case 3:
                System.out.println("Você escolheu o Guerreiro!");
                guilda.add(new Guerreiro());
                break;

                case 0:
                System.out.println("O Guerreiro possui 30 de ataque, 20 de defesa, e 180 de vida\nO Mago possui 30 de ataque 10 de defesa, e 200 de vida\nO Arqueiro Possui 20 de ataque 30 de defesa, e 160 de vida ");
                criarGuilda(guilda);
                break;

                default:
                System.err.println("Oque você está fazendo?");

            }

            guildaPersonagens += 1;

            if (guildaPersonagens >= guildaMax){
                System.out.println("Limite atingido");
                iniciarJornada();
                break;
            }

            System.out.println("Deseja adicionar um novo membro à equipe?\n [1]Sim, [2]Não");
            Scanner novoMembro = new Scanner(System.in);
            int criarGuilda = novoMembro.nextInt();

            if (criarGuilda == 2){
                adicionarGuilda = false;
                iniciarJornada();
            }
        } while( adicionarGuilda== true);
        
    }

    
    public void escolherArma(Personagem p) {
        Scanner inputArma = new Scanner(System.in);
        boolean opcaoInvalida;
        Arma arma = new Arma(0,0, "");

        if (p.getClass().getSimpleName() == "Guerreiro") {
            do {
                opcaoInvalida = false;
                System.out.println("[Escolha uma das opcoes de arma: \n [1] Espada , [2] Machado");
                int armaEscolhida = inputArma.nextInt();
                if (armaEscolhida == 1) {
                    arma = new Arma(10, 15, "Espada");
                    System.out.println("Espada");
                } else if (armaEscolhida == 2) {
                    arma = new Arma(17, 8, "Machado");
                    System.out.println("Machado");
                } else {
                    System.out.println("Nao existe essa arma");
                    opcaoInvalida = true;
                }
            } while (opcaoInvalida);

        } else if (p.getClass().getSimpleName() == "Mago") {
            do {
                opcaoInvalida = false;
                System.out.println("Escolha uma das opcoes de arma:\n [1] Varinha , [2] Cajado");
                int armaEscolhida = inputArma.nextInt();
                if (armaEscolhida == 1) {
                    arma = new Arma(16, 19, "Varinha");
                    System.out.println("Varinha");
                } else if (armaEscolhida == 2) {
                    arma = new Arma(13, 12, "Cajado");
                    System.out.println("Cajado");
                } else {
                    System.out.println("Nao existe essa arma");
                    opcaoInvalida = true;
                }
            } while (opcaoInvalida);
        } else if (p.getClass().getSimpleName() == "Arqueiro") {
            do {
                opcaoInvalida = false;
                System.out.println("Escolha uma das opcoes de arma:\n [1] Arco Longo , [2] Balestra");
                int armaEscolhida = inputArma.nextInt();
                if (armaEscolhida == 1) {
                    arma = new Arma(12, 13, "Arco Longo");
                    System.out.println("Arco");
                } else if (armaEscolhida == 2) {
                    arma = new Arma(15, 10, "Balestra");    
                    System.out.println("Balestra");             
                } else {
                    System.out.println("Nao existe essa arma");
                    opcaoInvalida = true;
                }
            } while (opcaoInvalida);
        }

        p.setAtaque(arma.getAtaqueArma() + p.getAtaque());
        p.setDefesa(arma.getDefesaArma() + p.getDefesa());
        System.out.println("Voce escolheu" + arma.getNome() + "com" + arma.getAtaqueArma() +  "e" + arma.getDefesaArma()    );
    } 

    public void turno(ArrayList<Personagem> guilda, Dragao dragao){
        System.out.println("== COMBATE INTENSO INICIANDO ==");
        boolean guildaVivos;
        do {
            guildaVivos = true;
            for (Personagem personagem : guilda) {
                System.out.println("Oque está pensando?\n[1] - Atacar , [2] - Defender");
                Scanner turn = new Scanner(System.in);
                int turnEscolha = turn.nextInt();
                boolean escolhaInvalida = true;

                while (escolhaInvalida == true) {
                    if (turnEscolha == 1) {
                        personagem.atacar(dragao);
                        escolhaInvalida = false;
                    } else if (turnEscolha == 2) {
                        personagem.defender();
                        escolhaInvalida = false;
                    } else {
                        System.out.println("Oque voce está fazendo? Foco na batalha");
                        escolhaInvalida = true;
                    }
                }

            }

            if (dragao.getPVD() <= 0){
                System.out.println("O dragão morre.");
                guildaVivos = false;
                System.exit(0);
            }

            dragao.atacar(dragao.escolhaDragao(guilda));
            for (Personagem personagem : guilda) {
                if (personagem.getPVD() <= 0){
                  System.out.println("O personagem " + personagem.getNome() + " morreu");
                      guilda.remove(personagem);
                        guildaVivos = false;
                 } else{
                    guildaVivos = true;
                 } 
                 
              }
    
            
            
        } while(guildaVivos);
        

    }
    public void iniciarJornada(){
        turno(guilda, new Dragao());
    }
} 



