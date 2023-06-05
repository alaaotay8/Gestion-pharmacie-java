package com.mycompany.gestionpharmacie;
import java.util.Scanner;

public class GestionPharmacie {
    
    static Client[] clients = new Client[10];
    static Medicament[] medicaments = new Medicament[50];
    

    protected static Scanner scanner = new Scanner(System.in); 
  /**
   * Le programme principal  crée un objet Pharmacie
   * sur lequel les opérations suivantes peuvent être effectuées:
   * - achat (d'un médicament par un client), 
   * - approvisionnement (ajout d'un médicament au stock)
   * - affichage (des données relatives à la pharmacie
   */
  public static void main(String args[]) {
    
    
    clients[0] = new Client("Alaa", 40.0);
    clients[1] = new Client("Yasmeen", 50.0);
    clients[2] = new Client("Mounib", 0.0);
    clients[3] = new Client("Aymen", 10.0);
    clients[4] = new Client("Mariem", 5.0);
 
    medicaments[0] = new Medicament("Aspiron", 20.40, 5);
    medicaments[1] = new Medicament("Rhinoplexil", 19.15, 4);
    medicaments[2] = new Medicament("Panadol",6.50 , 5);
    medicaments[3] = new Medicament("Glamoxil",16.70 , 15);
    medicaments[4] = new Medicament("Fervex",10.95 , 8);
    medicaments[5] = new Medicament("Paracetamol",18.20 , 6);
    
    Pharmacie1 p = new Pharmacie1(clients, medicaments);
    System.out.println("\n------------- Mini Projet Java -------------");
    System.out.println("------------ Gestion de pharmacie ------------");
    System.out.println("<< Alaa Otay >> (cpi2) ");
    int choix;
    do {
      choix = menu();
 
      switch (choix) {
      case 1:
        p.ajoutClient();
        break;
      case 2:
        p.ajoutMedicament();
        break;
      case 3:
        p.achat();
        break;
      case 4:
        p.approvisionnement();
        break;
      case 5:
        p.affichage();
        break;
      case 6:
        quitter();
        break;
      }
    } while (choix < 7);
  }
  // Les méthodes utilitaires
  static int menu() {
    int choix = 0;
    System.out.println();
    System.out.println();
    System.out.println("1 : ajouter un nouveau client");
    System.out.println("2 : ajouter un nouveau medicament");
    System.out.println("3 : Achat de médicament");
    System.out.println("4 : Approvisionnement en  médicaments");
    System.out.println("5 : Etats des stocks et des crédits");
    System.out.println("6 : Quitter");
    System.out.println();
    while ((choix != 1) && (choix != 2) && (choix != 3) && (choix != 4) && (choix != 5) && (choix != 6)) {
      System.out.print("choisir une option : ");
      choix = scanner.nextInt();
    }
    return choix;
  }
 
  static void quitter() {
    System.out.println("Programme terminé!");
    return ;
  }
}
 
// Les classes d'objets