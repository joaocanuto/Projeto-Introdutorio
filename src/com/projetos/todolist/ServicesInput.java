package com.projetos.todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class ServicesInput implements IServicesInput{
    @Override
    public Tasks inputInsertOnList(){
        Scanner input = new Scanner(System.in);
        System.out.println("Diga qual tarefa você quer inserir: ");
        String r1 = input.nextLine();
        Utils.noInput(r1);
        System.out.println("Diga qual a descrição da tarefa: ");
        String r2 = input.nextLine();
        Utils.noInput(r2);
        System.out.println("Diga qual a prioridade da tarefa: ");
        String r3 = input.nextLine();
        int n = Integer.parseInt(r3);
        //verifica se a prioridade está entre 0 e 5:
        while(n < 1 || n > 5){
            System.out.println("Sua prioridade dever se encaixar entre 1 - 5");
            System.out.println("Insira novamente!");
            r3 = input.nextLine();
            n = Integer.parseInt(r3);
        }
        System.out.println("Diga qual a data de entrega da tarefa: ");
        String r4 = input.nextLine();
        Utils.noInput(r4);
        System.out.println("Diga qual a categoria da sua tarefa: ");
        String r5 = input.nextLine();
        Utils.noInput(r5);
        System.out.println("Diga qual o estado da sua tarefa: ");
        String r6 = input.nextLine();
        Utils.noInput(r6);
        Tasks inputIn = new Tasks(r1,r2,n,r4,r5,r6);
        return inputIn;
    }
    @Override
    public Tasks inputToRemove(ArrayList<Tasks> tarefas){
        int indexOfItem;
        System.out.println("Qual tarefa você deseja remover ?");
        Utils.showList(tarefas);
        System.out.println("Digite a posição dela na lista: ");
        Scanner input = new Scanner(System.in);
        indexOfItem = input.nextInt();
        indexOfItem--;

        return tarefas.get(indexOfItem);
    }
    @Override
    public int inputSortingList(){
        System.out.println("Deseja listar por:");
        System.out.println("1. Categoria");
        System.out.println("2. Prioridade ");
        System.out.println("Digite sua opção a baixo: ");
        Scanner input = new Scanner(System.in);
        int indexAnswer = input.nextInt();

        return indexAnswer;
    }
}
