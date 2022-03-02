package com.projetos.todolist;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedHashMap;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("Bem vindo ao To-Do-List");
        int resposta = Utils.printarMenu();

        ArrayList<Tasks> tarefas = new ArrayList<>();
        FilesUtils f = new FilesUtils("file.txt");
        f.readFileData(tarefas);

        while(resposta != 0){

            //Listando:
            if(resposta == 1) Utils.listarOrdenadamente(tarefas);
            //Inserindo:
            else if(resposta == 2) Utils.inserir(tarefas);
            //Atualizando:
            else if(resposta == 3) Utils.atualizarLista(tarefas);
            //Excluindo Itens:
            else if(resposta == 4) Utils.excluir(tarefas);

            if(Utils.voltarMenu() == 0){
                resposta = Utils.printarMenu();
            }
            else {
                resposta = 0;
            }
        }
        //System.out.println(tarefas);
        f.exportData(tarefas);

    }
}
