package com.projetos.todolist;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedHashMap;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("Bem vindo ao To-Do-List");
        int resposta = printMenu();

        ArrayList<Tasks> tarefas = new ArrayList<>();
        FilesUtils f = new FilesUtils("file.txt");
        f.readFileData(tarefas);
        ServicesInput servicesInput = new ServicesInput();
        while(resposta != 0){
            //Listando Ordenadamente:
            if(resposta == 1) Utils.SortingList(tarefas, servicesInput.inputSortingList());
            //Inserindo:
            else if(resposta == 2){
                Utils.insertOnList(tarefas,servicesInput.inputInsertOnList());
                Utils.sortList(tarefas);
            }
            //Atualizando:
            else if(resposta == 3){
                Utils.updatedList(tarefas);
                System.out.println("Suas tarefas foram atualizadas e inseridas no arquivo!");
            }
            //Excluindo Itens:
            else if(resposta == 4){
                Utils.removeOnList(tarefas,servicesInput.inputToRemove(tarefas));
                System.out.println("Seu item foi removido!");
            }

            //Voltando ao Menu:
            if(backOnMenu() == 0){
                resposta = printMenu();
            }
            else {
                resposta = 0;
            }
        }

        //Exporting Data at the End APP:
        f.exportData(tarefas);
    }


    //Front-End functions on Menu:
    public static int printMenu(){
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
    public static int backOnMenu(){
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.println("1 - Sair da Aplicação");
        Scanner input = new Scanner(System.in);
        int resposta = input.nextInt();
        if(resposta == 1){
            System.out.println("Encerrando suas Tarefas!");
        }
        return resposta;
    }

    //Inputs functions:

}
