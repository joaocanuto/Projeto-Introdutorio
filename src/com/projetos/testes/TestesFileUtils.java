package com.projetos.testes;

import com.projetos.todolist.FilesUtils;
import com.projetos.todolist.Tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TestesFileUtils {
    public static void main(String[] args) throws IOException {

        FilesUtils filesUtils = new FilesUtils("file.txt");
        ArrayList<Tasks> taf = new ArrayList<>();
        filesUtils.readFileData(taf);
        //List<String> teste = new ArrayList<String>();
        ArrayList<Tasks> ToDoList = new ArrayList<>();
        Tasks t = new Tasks("ZG","Projeto",3,"02/03/2022","Projeto","Fazendo");
        Tasks z = new Tasks("ZGG","Projetou",4,"05/03/2022","Projeto","Fazendo");

        //ToDoList.add(filesUtils.getHeaders());
        //ToDoList.addAll(filesUtils.readFileData());
        //System.out.println((filesUtils.readFileData()));

        ToDoList.add(t);
        ToDoList.add(z);

        File file = new File ("file.txt");

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! Criamos um! Rode o programa novamente :)");
            //file.getParentFile().mkdirs();
        }
        for(Tasks a : ToDoList){
            printWriter.println(a);
        }

        printWriter.close ();
    }

}
