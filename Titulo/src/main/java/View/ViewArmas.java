/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Dao.DaoArmas;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ViewArmas {
    DaoArmas daoArmas = new DaoArmas();
     Scanner sc = new Scanner(System.in);
     int escolha;
    
    public void TextArmas(){
        do{
        System.out.println("==========Armas=========");
        System.out.println("1 - Inserir uma arma");
        System.out.println("2 - Achar arma por ID");
        System.out.println("3 - Listar armas");
        System.out.println("4 - Atualizar arma");
        System.out.println("5 - deletar uam arma\n");
        System.out.println("0 - sair");
        
        System.out.println("O que deseja fazer:");
        escolha = sc.nextInt();
                  sc.nextLine();
                  
        switch (escolha) {
                case 0:
                    break;
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4: 
                    
                    break;
                default:
                    System.out.println("Essa opçao nao existe");                    
            }
        
        
        }while(escolha != 0);
    }
    
    public void InsertArma
}
