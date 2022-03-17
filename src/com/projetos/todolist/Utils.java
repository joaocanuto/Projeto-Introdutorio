package com.projetos.todolist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Utils{
    public static int printarMenu(){
        System.out.println("");
        System.out.println("O que deseja fazer ?");
        System.out.println("0 - Sair do Programa");
        System.out.println("1 - Listar as Tarefas");
        System.out.println("2 - Inserir nova Tarefa");
        System.out.println("3 - Atualizar lista");
        System.out.println("4 - Excluir tarefa");
        Scanner input = new Scanner(System.in);
        int resposta = input.nextInt();
        if(resposta == 0){
            System.out.println("Encerrando suas Tarefas e Exportando seus dados :)!");
        }
        return resposta;
    }

    public static int voltarMenu(){
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.println("1 - Sair da Aplicação");
        Scanner input = new Scanner(System.in);
        int resposta = input.nextInt();
        if(resposta == 1){
            System.out.println("Encerrando suas Tarefas!");
        }
        return resposta;
    }
    public static void atualizarLista(ArrayList<Tasks> tarefas) throws IOException {
        FilesUtils f = new FilesUtils("file.txt");
        f.exportData(tarefas);
        System.out.println("Lista Exportada/Atualizada com sucesso!");
    }
    public static void ordenaLista(ArrayList<Tasks> tarefas){
        ArrayList<Tasks> myList = new ArrayList<Tasks>(tarefas);
        Collections.sort(tarefas);
    }
    public static void listar(ArrayList<Tasks> tarefas){
        System.out.println("Tarefas: ");
        int cnt = 1;
            for(Tasks t : tarefas){
                System.out.println(cnt + ". "+ t.toString());
                cnt++;
            }
    }
    public static void inserir(ArrayList<Tasks> tarefas){
        Scanner input = new Scanner(System.in);
        System.out.println("Diga qual tarefa você quer inserir: ");
        String r1 = input.nextLine();
        noInput(r1);
        System.out.println("Diga qual a descrição da tarefa: ");
        String r2 = input.nextLine();
        noInput(r2);
        System.out.println("Diga qual a prioridade da tarefa: ");
        String r3 = input.nextLine();
        System.out.println("Diga qual a data de entrega da tarefa: ");
        String r4 = input.nextLine();
        noInput(r4);
        System.out.println("Diga qual a categoria da sua tarefa: ");
        String r5 = input.nextLine();
        noInput(r5);
        System.out.println("Diga qual o estado da sua tarefa: ");
        String r6 = input.nextLine();
        noInput(r6);
        int n = Integer.parseInt(r3);
        Tasks inserted = new Tasks(r1,r2,n,r4,r5,r6);
        tarefas.add(inserted);
        ordenaLista(tarefas);
        //System.out.println(tarefas);
    }
    public static void excluir(ArrayList<Tasks> tarefas){
        System.out.println("Qual tarefa você deseja remover ?");
        listar(tarefas);
        System.out.println("Digite a posição dela na lista: ");
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        r--;
        Tasks removed = tarefas.get(r);
        tarefas.remove(r);
    }
    public static void noInput(String r){
        Scanner input = new Scanner(System.in);
        while(r == null){
            System.out.println("Por favor, digite uma entrada válida: ");
            r = input.nextLine();
        }
    }

    public static void listarOrdenadamente(ArrayList<Tasks> tarefas){
        System.out.println("Deseja listar por:");
        System.out.println("1. Categoria");
        System.out.println("2. Prioridade ");
        System.out.println("Digite sua opção a baixo: ");
        Scanner input = new Scanner(System.in);
        int r1 = input.nextInt();

        LinkedHashSet<String> categorias = new LinkedHashSet<>();
        for(Tasks a : tarefas){
            categorias.add(a.getCateg());
        }

        if(r1 == 1){
            System.out.println("Listando por Categoria:");
            int cnt1 = 1;
            for(String s : categorias){
                System.out.println("**Categoria: " + s + " :");
                int cnt2 = 1;
                for(Tasks t : tarefas){
                    if(s.equals(t.getCateg())){
                        System.out.println("---"+ cnt1 + "."+ cnt2 + ": "+ t.toString());
                    }
                    cnt2++;
                }
                cnt1++;
            }
        }
        else if(r1 == 2){
            System.out.println("Listando por Prioridade:");
            int cnt1 = 1;

            LinkedHashSet<Integer> prioridades = new LinkedHashSet<>();
            for(Tasks a : tarefas){
                prioridades.add(a.getPrior());
            }

            for(int i : prioridades){
                System.out.println("**Prioridade " + i + " :");
                int cnt2 = 1;
                for(Tasks t : tarefas){
                    if(i == t.getPrior()){
                        System.out.println("---"+ cnt1 + "."+ cnt2 + ": "+ t.toString());
                        cnt2++;
                    }
                }
                cnt1++;
            }
        }
    }
}
