package spyfallaplication;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 *
 * @author Vanessa Pessoa
 */
public class Servidor extends Thread {
     private static ServerSocket servidor;
     private static ArrayList<BufferedWriter> jogadores;

     private String nome;
     private Socket con;
     private InputStream input;
     private InputStreamReader inr;
     private BufferedReader bfr;
     
     private static int espiaoID;
     private static String lugarDaPartida;
     private static int lugarID;
     private static ArrayList<String> lugares = new ArrayList<>(5);
     private static SpyFallAplication jogo;
     public static ArrayList<Jogador> j = new ArrayList<Jogador>(4);
     
     
     private final int HOSPITAL = 0;
     private final int RESTAURANTE = 1;
     private final int ESCOLA = 2;
     private final int CONCERTO_MUSICAL = 3;
     private final int PRACA = 4;
     static int id;
    
     
     public Servidor(Socket con){
        this.con = con;
         try{
             // cria um objeto BufferedReader() que aponta para o stream do cliente socket
             this.input = con.getInputStream();
             this.inr = new InputStreamReader(input);
             bfr = new BufferedReader(inr);
         } catch(IOException ex){
             ex.printStackTrace();
         }
     }   
  
     public static void setJogador(Jogador jg){
         j.add(jg);
         jg.setID(j.size()-1);
         id = jg.getID();
         System.out.println(j.size());
        
    }
     
     public static int id(){
         return id;
     }
     
     
     public static int espiao(){
         System.out.println(espiaoID);
         return espiaoID;
     }
     
     public static int lugar(){
         System.out.println(lugarID);
         return lugarID;
     }
    
     
    private static void setLugares() {
        lugares.add("Hospital");
        lugares.add("Restaurante");
        lugares.add("Escola");
        lugares.add("Concerto Musical");
        lugares.add("Praça");
    }
     
     public static void sorteios() {
        
        // sortear espiao
        Sorteio sorteio1 = new Sorteio(4);
        sorteio1.run();
        espiaoID = sorteio1.getValor();
        
        System.out.println("ID do espiao = " + espiaoID);
        
        // sortear lugar
        Sorteio sorteio2 = new Sorteio(5);
        sorteio2.run();
        lugarID = sorteio2.getValor();
        lugarDaPartida = lugares.get(lugarID);
        
        System.out.println(lugarDaPartida);
    }
    
     @Override
     public void run(){
        try{
             String mensagem;
             OutputStream output = this.con.getOutputStream();
             Writer ouw = new OutputStreamWriter(output);
             BufferedWriter bfw = new BufferedWriter(ouw);
             jogadores.add(bfw);
             nome = mensagem = bfr.readLine();
                          
             while(!"Sair".equalsIgnoreCase(mensagem)){
                 mensagem = bfr.readLine();
                 enviar(bfw, mensagem);
             }
         } catch(IOException ex){
             ex.printStackTrace();
         }
     }
     
      public void enviar (BufferedWriter saida, String msg){
         BufferedWriter bws;
         
         for(BufferedWriter bw : jogadores){
             bws = (BufferedWriter)bw;
             
             if(!(saida == bws)){
                 try {
                     bw.write(  msg + "\n " );
                     bw.flush();
                 } catch (IOException ex) {
                     Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }   
     }
     
    public static void main(String[] args){
      try{
        servidor = new ServerSocket(12345);
        jogadores = new ArrayList<BufferedWriter>();
        jogo = new SpyFallAplication();
        
        setLugares();
        sorteios();
        
        
        while(true){
            System.out.println("Aguardando conexão...");
            Socket con = servidor.accept();
            System.out.println("Cliente Conectado...");

               
            Thread t = new Servidor(con);
            t.start();
               
        }
          
       } catch (HeadlessException | NumberFormatException | IOException ex){
           ex.printStackTrace();
       }
    }    
    
}
 
