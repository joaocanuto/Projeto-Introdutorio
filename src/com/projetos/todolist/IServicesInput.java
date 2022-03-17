package com.projetos.todolist;

import java.util.ArrayList;

public interface IServicesInput {
    Tasks inputInsertOnList();
    Tasks inputToRemove(ArrayList<Tasks> tarefas);
    int inputSortingList();

}
