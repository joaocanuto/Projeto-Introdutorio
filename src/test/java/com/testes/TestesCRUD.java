package com.testes;

import src.com.projetos.todolist.IFilesUtils;
import src.com.projetos.todolist.IServicesInput;
import src.com.projetos.todolist.Tasks;
import src.com.projetos.todolist.Utils;
import org.junit.*;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestesCRUD {
    //
    // Given
    //
    private static ArrayList<Tasks> tasksList = new ArrayList<>();

    @Before
    public void setUpBeforeClass() {
        Tasks temp = new Tasks("ToDoList","Desenvolver uma ToDoList em Grovy",5,"04/03/2022","Grovy","A Fazer");
        tasksList.add(temp);
        Tasks temp1 = new Tasks("ToDoList","Desenvolver uma ToDoList em Java",3,"02/03/2022","JAVA","Fazendo");
        Tasks temp2 = new Tasks("Estudar Calculo", "Estudar calculo 2 pela lista do professor",2,"07/03/2022","UECE","A Fazer");
        tasksList.add(temp1);
        tasksList.add(temp2);
    }
    @Test
    public void testCreateListOfTask(){
        //verifica se a lista esta vazia:
        assertNotNull(tasksList);
    }
    @Test
    public void insertOnListTest(){
        IServicesInput servicesInput = mock(IServicesInput.class);
        int sizeBeforeFunction = tasksList.size();
        Tasks Output = Utils.insertOnList(tasksList,servicesInput.inputInsertOnList());
        int sizeAfterFunction = tasksList.size();
        assertNotEquals(sizeBeforeFunction,sizeAfterFunction);
        System.out.println("Elementos podem ser inseridos na lista!");
    }
    @Test
    public void removeOnListTest(){
        IServicesInput servicesInput = mock(IServicesInput.class);
        int sizeBeforeFunction = tasksList.size();
        Tasks Output = Utils.insertOnList(tasksList,servicesInput.inputInsertOnList());
        int sizeAfterFunction = tasksList.size();
        assertNotEquals(sizeBeforeFunction,sizeAfterFunction);
        System.out.println("Elementos podem ser removidos da lista!");
    }
    @Test
    public void updateListTest(){
        IFilesUtils filesUtils = mock(IFilesUtils.class);
        filesUtils.exportData(tasksList);
        System.out.println("A lista está sendo exportada!");

    }
}
