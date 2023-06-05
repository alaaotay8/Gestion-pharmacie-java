package com.mycompany.gestionpharmacie;
import java.util.Scanner;

public class Pharmacie1 { 
   // une pharmacie c'est une liste de client et une liste de médicaments
  static Scanner scanner = new Scanner(System.in);
    
  private static Client[] clients ;
  private Medicament[] medicaments ;
  static int i=4;
  static int j=5;
 
  public Pharmacie1(Client[] cs, Medicament[] ms) {
    clients = cs;
    medicaments = ms;
  }
  
  public Client[] getClients() {
    return this.clients;
  }
 
  public Medicament[] getMedicaments() {
    return this.medicaments;
  }
 
  
  public void ajoutClient() {
      String no;
      System.out.println("\ndonner le nom du client :");
      no = scanner.next();
      for(int x=0 ; x<i ; x++) {
        if(no.equals(clients[x].getNom())) {
            System.out.println("\nle client déja existant");
            return;
        }
      }
      System.out.println("donner le crédit du client :");
      double c =scanner.nextDouble();
      Client ca = new Client(no ,c);
      clients[i]=ca;
      i++;
  }

 
  public void ajoutMedicament() {
      System.out.println("\ndonner le nom du Medicament :");
      String n = scanner.next();
      for(int x=0 ; x<j ; x++) {
        if(n.equals(medicaments[x].getNom())) {
            System.out.println("\nle Medicament déja existant");
            return;
        }
      }
       System.out.println("donner le prix du Medicament :");
       double p =scanner.nextDouble();
       System.out.println("donner la quantité du Medicament :");
       int s =scanner.nextInt();
       Medicament md = new Medicament(n,p,s);
       medicaments[j]= md;
       j++;
    }
  
  /**
   * Permet à un client d'acheter un médicament.
   * si le client est connu de la pharmacie, son crédit
   * va diminuer en fonction de son paiement.
   * Le stock associé au médicament va diminuer
     */
  public void achat() {
    Client client = this.lireClient();
    Medicament medicament = this.lireMedicament();
 
    double paiement = lirePaiement();
    int quantite = lireQuantite();
 
    if (quantite <= medicament.getStock()) {
      medicament.diminuerStock(quantite);
      client.augmenterCredit((medicament.getPrix() * quantite) - paiement);
    } else {
      System.out.println("\nAchat Impossible. Quantité insuffisante !!");
    }
  }
 
  /**
   * Permet à la pharmacie de s'approvisionner en un
   * médicament connu.
   */
  public void approvisionnement() {
    Medicament medicament = this.lireMedicament();
    System.out.println("Donner la Quantité : ");
    int quantite = GestionPharmacie.scanner.nextInt();
    medicament.augmenterStock(quantite);
  }
 
  /**
   * Affichage des stocks et des crédits de la pharmacie
   */
  public void affichage() {
 
    System.out.println("\n* Affichage des stocks :");
    for (int x = 0; x < j; x++) {
      System.out.println("Stock du médicament " + medicaments[x].getNom()
             + " : " + medicaments[x].getStock());
    }
 
    System.out.println("\n* Affichage des crédits(montant a payer ou reste(-)) :");
    for (int x = 0; x < i; x++) {
      System.out.println("Crédit du client " + clients[x].getNom()
             + " : " + clients[x].getCredit());
    }
  }
 
  /**
   * Retourne l'objet Client associé à un nom (String)
   * Le nom est lu et redemandé tant qu'il ne correspond
   * pas au nom d'un client connu de la pharmacie
   */
  public Client lireClient() {
    String n;
    int trouve = 0;
    Client c = null;
    
    while (trouve == 0){
      n = GestionPharmacie.scanner.nextLine();
      for (int x = 0; (trouve==0 && x < clients.length); x++) {
            if ((clients[x].getNom()).equals(n)) {
            trouve = 1;
            c = clients[x];
            }
      }
      if (trouve == 0) {
        System.out.println("Client inconnu. Veuilliez recommencer");
      }
    }
 
    return c;
  }
 
 /**
   * Retourne l'objet Medicament associé à un nom (String)
   * Le nom est lu et redemandé tant qu'il ne correspond
   * pas au nom d'un médicament connu de la pharmacie
   */
  public Medicament lireMedicament() {
    String nom;
    int trouve = 0;
    Medicament m=null ;
    
    do {
      System.out.println("Nom du medicament?:");
      nom = GestionPharmacie.scanner.nextLine();
      for (int x = 0; (trouve==0 && x < medicaments.length); x++) {
            if ((medicaments[x].getNom()).equals(nom)) {
                trouve = 1;
                m = medicaments[x];
            }
      }
      if (trouve == 0) {
        System.out.println("Médicament inconnu. Veuilliez recommencer\n");
      }
    } while (m==null);
 
    return m;
  }
 
  static double lirePaiement() {
    System.out.println("quel est le montant du paiement?");
    return GestionPharmacie.scanner.nextDouble();
  }
 
  static int lireQuantite() {
    System.out.println("quelle est la quantité achetée?");
    return GestionPharmacie.scanner.nextInt();
  }
 
}
