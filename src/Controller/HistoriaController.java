package Controller;

import Model.Inimigo;
import Model.Batalha;
import Model.Heroi;
import Model.PocaoDeCura;
import Model.PocaoDeForca;
import Util.Log;
import View.HistoriaView;

public class HistoriaController {
    private HistoriaView view;

    public HistoriaController(HistoriaView view) {
        this.view = view;
    }

    public void iniciar(Heroi heroi) {
        Log.registrar("O capitulo um foi iniciado.");
        boolean querSair = view.perguntarSimNao("O dia está tão bonito lá fora, deseja sair para uma caminhada? (sim/não)");

        if (querSair) {
            view.mostrarMensagem("Você decide sair para uma caminhada pelo reino!");
        } else {
            view.mostrarMensagem("Sua esposa decide que você VAI sair para uma caminhada pelo reino...");
        }

        Inimigo goblin = new Inimigo("Goblin", 40, 1, 5, "Terreste");
        Log.registrar("O inimigo " + goblin.getNome() + " foi criado");

        view.mostrarMensagem("Você escuta um barulho vindo da moita do seu lado.");
        view.mostrarMensagem("Você decide verificar a origem do barulho");
        view.mostrarMensagem("UM GOBLIN DEVIDAMENTE ARMADO COM UMA TESOURA SEM PONTA VERMELHA DA TILIBRA");

        Batalha primeiraBatalha = new Batalha(heroi, goblin);

        BatalhaController batalhaController = new BatalhaController(primeiraBatalha);

        String resultado = "";

        try {
            resultado = batalhaController.iniciar();
            Log.registrar("A batalha contra " + goblin.getNome() + " foi iniciada!");
        } catch (Exception e) {
            view.mostrarMensagem("Ocorreu um erro durante a batalha: " + e.getMessage());
            Log.registrar("Ocorreu um erro durante a batalha: " + e.getMessage());
            Log.fechar();
            view.gameOver();
        }

        if ("vitoria".equals(resultado)) {
            view.mostrarMensagem("Você lutou bravamente e derrotou o malvado goblin!");
            Log.registrar("O herói venceu a batalha contra " + goblin.getNome());
            capituloDois(heroi);
        } else if ("fugiu".equals(resultado)) {
            view.mostrarMensagem("Você tenta correr para fugir do goblin");
            view.mostrarMensagem("Mas tropeça em uma pedra e cai de cara no chão!");
            view.mostrarMensagem("O goblin observa, confuso, e decide terminar o serviço.");
            view.mostrarMensagem("Você morreu de forma... pouco heroica.");
            Log.registrar("O herói perdeu a batalha contra " + goblin.getNome());
            Log.fechar();
            view.gameOver();
        } else {
            Log.registrar("O herói perdeu a batalha contra " + goblin.getNome());
            Log.fechar();
            view.gameOver();
        }

    }

    private void capituloDois(Heroi heroi) {
        Log.registrar("O capitulo dois foi iniciado.");
        view.mostrarMensagem("Após derrotar o goblin, você encontra uma poção de cura.");
        PocaoDeCura pocaoCura = new PocaoDeCura("Poção de cura", "Essa poção te cura :)", 10);
        pocaoCura.mostrarItem();
        heroi.getInventario().adicionarItem(pocaoCura);
        Log.registrar("Foi adicionado o item: " + pocaoCura.getNome() + " no inventário do herói;" );

        view.mostrarMensagem("Agora seria um bom momento para dar uma olhada na sua mochina");

        boolean verInventario = view.perguntarSimNao("Deseja abrir sua mochila para ver seus itens? (sim/não)");

        if (verInventario) {
            InventarioController inventarioController = new InventarioController(heroi.getInventario());
            inventarioController.abrirInventario(heroi);
            Log.registrar("O herói abriu a mochila");
        } else {
            view.mostrarMensagem("Você decide seguir em frente sem olhar sua mochila...");
        }

        view.mostrarMensagem("Mesmo depois de encontrar um inimigo no seu caminho, decide seguir com sua caminhada pelo reino e adentra a floresta");

        view.mostrarMensagem("Você chega a uma clareira iluminada pelo sol e vê um pedestal antigo com uma caixa coberta de runas brilhantes.");
        view.mostrarMensagem("Uma inscrição nas runas diz: 'Aquele que ousar, encontrará o que merece... ou talvez não.'");

        boolean abrirCaixa = view.perguntarSimNao("Você quer abrir a caixa? (sim/não)");

        if (abrirCaixa) {
            view.mostrarMensagem("Você se aproxima e cuidadosamente tenta abrir a caixa...");
            Log.registrar("O herói escolheu abrir a caixa misteriosa");
            double chance = Math.random();

            if (chance < 0.4) {
                view.mostrarMensagem("A caixa se abre! Dentro dela você encontra uma Poção de Força!");
                PocaoDeForca pocaoForca = new PocaoDeForca(
                        "Poção de Força",
                        "Uma poção mágica que aumenta sua força temporariamente.",
                        5
                );
                heroi.getInventario().adicionarItem(pocaoForca);
                Log.registrar("O herói encontrou o item: " + pocaoForca.getNome() + " dentro da caixa misteriosa");

                boolean usarAgora = view.perguntarSimNao("Deseja usar a Poção de Força agora? (sim/não)");
                if (usarAgora) {
                    pocaoForca.usar(heroi);
                    heroi.getInventario().getItens().remove(pocaoForca);
                    Log.registrar("O herói usou o item: " + pocaoForca.getNome());
                } else {
                    view.mostrarMensagem("Você guarda a poção para usar em outro momento.");
                }

            } else if (chance < 0.8) {
                view.mostrarMensagem("Um feitiço de choque se ativa! Você leva 5 de dano, mas consegue se esquivar a tempo de não perder nada mais.");
                heroi.receberDano(5);
                Log.registrar("O herói sofreu com um feitiço de choque da caixa misteriosa");
            } else {
                view.mostrarMensagem("Um pó colorido explode da caixa e cobre você da cabeça aos pés! Nenhum dano, mas você fica parecendo um arco-íris ambulante!");
                Log.registrar("O herói encontrou pó colorido dentro da caixa misteriosa");
            }

        } else {
            view.mostrarMensagem("Você decide ignorar a caixa e continua sua jornada pela floresta, cauteloso mas curioso sobre o que poderia ter dentro.");
            Log.registrar("O herói escolheu por ignorar a caixa misteriosa");
        }


        view.mostrarMensagem("Mais adiante, a trilha leva você a uma ponte de madeira suspensa sobre um rio agitado.");
        view.mostrarMensagem("O sol está começando a se pôr, e sombras dançam entre as árvores... A aventura continua!");

        view.mostrarMensagem("Você pisa com cuidado na velha ponte de madeira...");
        view.mostrarMensagem("O vento sopra forte, e um som pesado ecoa sob a ponte...");
        view.mostrarMensagem("Um enorme Troll da Ponte salta das sombras!");

        Inimigo troll = new Inimigo("Troll da Ponte", 60, 2, 8, "Terrestre");
        Log.registrar("O inimigo " + troll.getNome() + " foi criado");

        Batalha segundaBatalha = new Batalha(heroi, troll);
        BatalhaController SegundaBatalhaController = new BatalhaController(segundaBatalha);

        String resultado = "";
        try {
            resultado = SegundaBatalhaController.iniciar();
            Log.registrar("A batalha contra " + troll.getNome() + " foi iniciada");
        } catch (Exception e) {
            view.mostrarMensagem("Ocorreu um erro durante a batalha: " + e.getMessage());
            Log.registrar("Ocorreu um erro durante a batalha: " + e.getMessage());
            Log.fechar();
            view.gameOver();
        }

        if (resultado.equals("vitoria")) {
            view.mostrarMensagem("O Troll da Ponte cai com um rugido, afundando no rio. Você atravessa a ponte vitorioso!");
            heroi.subirNivel();
            Log.registrar("O herói venceu a batalha contra " + troll.getNome());
            capituloTres(heroi);
        } else if (resultado.equals("fugiu")) {
            view.mostrarMensagem("Você tenta correr de volta, mas o Troll quebra a ponte com um golpe!");
            Log.registrar("O herói perdeu a batalha contra " + troll.getNome());
            Log.fechar();
            view.gameOver();
        } else {
            view.mostrarMensagem("O Troll ergue sua clava e... tudo escurece.");
            Log.registrar("O herói perdeu a batalha contra " + troll.getNome());
            Log.fechar();
            view.gameOver();
        }
    }

    private void capituloTres(Heroi heroi) {
        Log.registrar("O capitulo três foi iniciado.");
        view.mostrarMensagem("Você segue pela ponte, ainda sentindo o calor da batalha em suas mãos.");
        view.mostrarMensagem("A água do rio reflete o pôr do sol... mas o vento muda, trazendo um cheiro estranho de enxofre.");

        view.mostrarMensagem("Agora seria um bom momento para dar uma olhada na sua mochina");

        boolean verInventario = view.perguntarSimNao("Deseja abrir sua mochila para ver seus itens? (sim/não)");

        if (verInventario) {
            InventarioController inventarioController = new InventarioController(heroi.getInventario());
            inventarioController.abrirInventario(heroi);
            Log.registrar("O herói abriu a mochila");
        } else {
            view.mostrarMensagem("Você decide seguir em frente sem olhar sua mochila...");
        }

        view.mostrarMensagem("O caminho à frente se transforma em solo queimado — árvores carbonizadas e pedras derretidas.");
        view.mostrarMensagem("O chão treme sob seus pés enquanto o céu escurece.");
        view.mostrarMensagem("Do topo da montanha, uma sombra colossal se ergue...");
        view.mostrarMensagem("Um DRAGÃO VERMELHO aparece rugindo, cuspindo chamas que iluminam toda a planície!");
        view.mostrarDragao();

        Inimigo dragao = new Inimigo("Dragão Vermelho", 80, 5, 15, "Aéreo");
        Log.registrar("O inimigo: " + dragao.getNome() + " foi criado");
        Batalha batalhaFinal = new Batalha(heroi, dragao);
        BatalhaController batalhaController = new BatalhaController(batalhaFinal);

        String resultado = "";

        try {
            resultado = batalhaController.iniciar();
            Log.registrar("A batalha contra " + dragao.getNome() + " foi iniciada");
        } catch (Exception e) {
            view.mostrarMensagem("Ocorreu um erro durante a batalha: " + e.getMessage());
            Log.registrar("Ocorreu um erro durante a batalha: " + e.getMessage());
            Log.fechar();
            view.gameOver();
        }
        if (resultado.equals("vitoria")) {
            view.mostrarMensagem("Com um golpe final, você crava sua espada entre as escamas do dragão!");
            view.mostrarMensagem("O monstro ruge, se contorce... e finalmente desaba, fazendo o chão tremer uma última vez.");
            view.esperar(2000);
            view.mostrarMensagem("Silêncio. O fogo se apaga. Você venceu.");
            view.mostrarMensagem("A lenda do herói que derrotou o Dragão Vermelho ecoará por toda a eternidade!");
            view.mostrarMensagem("FIM DE JOGO - PARABÉNS, CAMPEÃO!");
            Log.registrar("O herói venceu o jogo!");
            Log.fechar();
            view.finalGame();
        } else if (resultado.equals("fugiu")) {
            view.mostrarMensagem("Você tenta fugir... mas o dragão abre suas asas e bloqueia o céu inteiro.");
            view.mostrarMensagem("Com um único sopro flamejante, tudo ao seu redor vira cinzas.");
            Log.registrar("O herói perdeu a batalha contra " + dragao.getNome());
            Log.fechar();
            view.gameOver();
        } else {
            view.mostrarMensagem("O rugido do dragão é a última coisa que você ouve...");
            view.mostrarMensagem("Seu corpo é engolido pelas chamas.");
            Log.registrar("O herói perdeu a batalha contra " + dragao.getNome());
            Log.fechar();
            view.gameOver();
        }
    }
}
