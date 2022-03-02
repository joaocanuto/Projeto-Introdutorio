package com.projetos.todolist;

import java.io.*;
import java.util.*;

public class FilesUtils {

    String filePath = null;

    public FilesUtils(String filePath) {
        this.filePath = filePath;
    }

    public void readFileData(ArrayList<Tasks> taf) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            //skip the first line:
            String line = null;
            // populate data from next line onwards
            while((line = br.readLine()) != null){
                String [] data = line.split(",");
                Tasks temp = new Tasks(data[0],data[1],Integer.parseInt(data[2]),data[3],data[4],data[5]);
                taf.add(temp);
            }
        }
        //System.out.println(taf);
    }

    public void exportData(ArrayList<Tasks> t){
        FilesUtils filesUtils = new FilesUtils("file.txt");
        File file = new File ("file.txt");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! Criamos um! Rode o programa novamente :)");
            //file.getParentFile().mkdirs();
        }
        for(Tasks a : t){
            printWriter.println(a);
        }

        printWriter.close ();


    }

    //FUNÇÃO EM DESENVOLVIMENTO :
    public String getHeaders() throws IOException{
        String line = readFirstLine(filePath);
        String [] header = line.split(",");
        StringBuffer sb = new StringBuffer();
        String header2 = null;
        int cnt = 0;
        for(String a : header){
            sb.append(a);
            cnt++;
            if(cnt != header.length)
                sb.append(",");
        }
        header2 = sb.toString();
        System.out.println(header2);
        List<String> values = new ArrayList<String>();
        values = Arrays.asList(header);
        return line;
    }
    static String readFirstLine(String path) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }


}
