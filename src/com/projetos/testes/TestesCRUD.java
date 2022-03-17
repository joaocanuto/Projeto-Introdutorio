package com.projetos.testes;

import com.projetos.todolist.Tasks;
import com.projetos.todolist.Utils;
import org.junit.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestesCRUD {
    //
    // Given
    //
    private static ArrayList<Tasks> t = new ArrayList<>();
    @Before
    public void setUpBeforeClass() {
        Tasks temp = new Tasks("ToDoList","Desenvolver uma ToDoList em Grovy",5,"04/03/2022","Grovy","A Fazer");
        t.add(temp);
        Tasks temp1 = new Tasks("ToDoList","Desenvolver uma ToDoList em Java",3,"02/03/2022","JAVA","Fazendo");
        Tasks temp2 = new Tasks("Estudar Calculo", "Estudar calculo 2 pela lista do professor",2,"07/03/2022","UECE","A Fazer");
        t.add(temp1);
        t.add(temp2);
    }
    @Test
    public void testCreateListOfTask(){
        //verifica se a lista esta vazia:
        assertNotNull(t);
    }
    @Test
    public void testInsertAOnList(){
        t.add(new Tasks("GEMP", "Reunião com o GEMP",3,"05/03/2022","UECE", "A Fazer"));
        Tasks Output = t.get(t.size()-1);
        Tasks expectedOutput = new Tasks("GEMP", "Reunião com o GEMP",3,"05/03/2022","UECE", "A Fazer");
        assertEquals(Output,expectedOutput);
    }
    @Test
    public void testEraseAnElementOnList(){
        t.remove(t.size()-1);
        Tasks expectedOutput = new Tasks("ToDoList","Desenvolver uma ToDoList em Java",3,"02/03/2022","JAVA","Fazendo");
        Tasks Output = t.get(t.size()-1);
        assertEquals(Output,expectedOutput);
    }
}
