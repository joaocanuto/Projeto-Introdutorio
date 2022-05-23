package src.com.projetos.todolist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Utils{

    //List Functions on TasksList:
    public static void updatedList(ArrayList<Tasks> tarefas) throws IOException {
        FilesUtils f = new FilesUtils("file.txt");
        f.exportData(tarefas);
        System.out.println("Lista Exportada/Atualizada com sucesso!");
    }
    public static void sortList(ArrayList<Tasks> tarefas){
        ArrayList<Tasks> myList = new ArrayList<Tasks>(tarefas);
        Collections.sort(tarefas);
    }
    public static void showList(ArrayList<Tasks> tarefas){
        System.out.println("Tarefas: ");
        int cnt = 1;
            for(Tasks t : tarefas){
                System.out.println(cnt + ". "+ t.toString());
                cnt++;
            }
    }
    public static Tasks insertOnList(ArrayList<Tasks> tarefas, Tasks inserted){
        tarefas.add(inserted);
        return inserted;
    }
    public static Tasks removeOnList(ArrayList<Tasks> tarefas, Tasks removed){
        tarefas.remove(removed);
        return removed;
    }
    public static void SortingList(ArrayList<Tasks> tarefas, int index){

        if(index == 1){
            LinkedHashSet<String> categorias = new LinkedHashSet<>();
            for(Tasks a : tarefas){
                categorias.add(a.getCateg());
            }
            System.out.println("Listando por Categoria:");
            int cnt1 = 1;
            for(String s : categorias){
                System.out.println("Categoria: " + s + " :");
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
        else if(index == 2){
            LinkedHashSet<Integer> prioridades = new LinkedHashSet<>();
            for(Tasks a : tarefas){
                prioridades.add(a.getPrior());
            }

            System.out.println("Listando por Prioridade:");
            int cnt1 = 1;

            for(int i : prioridades){
                System.out.println("Prioridade " + i + " :");
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

    //Exceptions Functions:
    public static void noInput(String r){
        Scanner input = new Scanner(System.in);
        while(r == null){
            System.out.println("Por favor, digite uma entrada válida: ");
            r = input.nextLine();
        }
    }

}
