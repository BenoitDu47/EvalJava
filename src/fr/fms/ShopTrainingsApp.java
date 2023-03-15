package fr.fms;

import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.authentication.Authenticate;
import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;
import fr.fms.entities.Training;

public class ShopTrainingsApp {
	private static Scanner scan = new Scanner(System.in);
	private static IBusinessImpl business = new IBusinessImpl();
	private static Authenticate authenticate = new Authenticate();
	public static final String TEXT_BLUE = "\u001B[36m";
	public static final String TEXT_RESET = "\u001B[0m";
	private static final String COLUMN_ID = "IDENTIFIANT";
	private static final String COLUMN_DESCRIPTION = "FORMATION";
	private static final String COLUMN_DISTENTIAL = "PRÉSENT";
	private static final String COLUMN_PRICE = "PRIX";
	private static final String COLUMN_DURATION = "NOMBRE DE SEMAINES";
	private static final String COLUMN_NAME = "NAME";
	final static int LONGUEUR_LIGNE = 60;

	private static int idUser = 0;
	private static String login = null;

	public static void main(String[] args) {
		System.out.println("Bonjour et bienvenu dans ma boutique, voici la liste de formation en stock\n");
		displayTrainings();
		int choice = 0;
		while (choice != 10) {
			displayMenu();
			choice = scanInt();
			switch (choice) {
			case 1:
				addTraining();
				break;
			case 2:
				removeTraining();
				break;
			case 3:
				displayCart(true);
				break;
			case 4:
				displayTrainings();
				break;
			case 5:
				displayCategories();
				break;
			case 6:
				displayWeyword();
				break;
			case 7:
				displayDistential();
				break;
			case 8:
				displayTrainingsByCategoryId();
				break;
			case 9:
				connection();
				break;
			case 10:
				System.out.println("à bientôt dans notre boutique :)");
				break;
			default:
				System.out.println("Veuillez saisir une valeur entre 1 et 9");
			}
		}
	}

	public static void displayMenu() {
		if (login != null)
			System.out.print(TEXT_BLUE + "Compte : " + login);
		System.out.println("\n\n" + "Pour réaliser une action, tapez le code correspondant");
		System.out.println("1 : Ajouter une formation au panier");
		System.out.println("2 : Retirer une formation du panier");
		System.out.println("3 : Afficher mon panier + total pour passer commande");
		System.out.println("4 : Afficher tous les formations en stock");
		System.out.println("5 : Afficher toutes les catégories en base");
		System.out.println("6 : Afficher les formation par mot-clef");
		System.out.println("7 : Afficher les formation en présentielles ou à distance");
		System.out.println("8 : Afficher tous les articles d'une catégorie");
		System.out.println("9 : Connexion(Deconnexion) à votre compte");
		System.out.println("10: sortir de l'application");
	}

	public static int scanInt() {
		while (!scan.hasNextInt()) {
			System.out.println("Saisissez une valeur entière svp");
			scan.next();
		}
		return scan.nextInt();
	}

	public static void displayTrainings() {
		System.out.println(Training.centerString(COLUMN_ID) + Training.centerString(COLUMN_DESCRIPTION)
				+ Training.centerString(COLUMN_DURATION) + Training.centerString(COLUMN_PRICE));
		business.readTrainings().forEach(System.out::println);
	}

	public static void addTraining() {
		System.out.println("Selectionner l'id de la formation à ajouter à votre panier");
		int id = scanInt();
		Training training = business.readOneTraining(id);
		if (training != null) {
			business.addToCart(training);
			displayCart(false);
		} else
			System.out.println("La formation que vous souhaitez ajouter n'existe pas, problème de saisi id");
	}

	private static void displayCart(boolean flag) {
		int totalQuantity = 0;
		if (business.isCartEmpty())
			System.out.println("PANIER VIDE");
		else {
			System.out.println("CONTENU DU PANIER :");
			String titles = Training.centerString(COLUMN_ID) + Training.centerString(COLUMN_DESCRIPTION)
					+ Training.centerString(COLUMN_DURATION) + Training.centerString(COLUMN_PRICE)
					+ Training.centerString("QUANTITE");
			System.out.println(titles);
			business.getCart().forEach(
					a -> System.out.println(a.toString() + Training.centerString(String.valueOf(a.getQuantity()))));
			if (flag) {
				System.out.println("MONTANT TOTAL : " + business.getTotal());
				System.out.println("Souhaitez vous passer commande ? Oui/Non :");
				if (scan.next().equalsIgnoreCase("Oui")) {
					nextStep();
				}
			}
		}
	}

	private static void nextStep() {
		if (login == null) {
			System.out.println("Vous devez être connecté pour continuer");
			connection();
		}
		if (login != null) {
			int idCustomer = newCustomer(idUser);
			if (idCustomer != 0) {
				int idOrder = business.order(idCustomer);
				if (idOrder == 0)
					System.out.println("pb lors du passage de commande");
				else {
					System.out.println("Votre commande a bien été validé, voici son numéro : " + idOrder);
					business.clearCart();
				}
			}
		}
	}

	private static void connection() {
		if (login != null) {
			System.out.println("Souhaitez vous vous déconnecter ? Oui/Non");
			String response = scan.next();
			if (response.equalsIgnoreCase("Oui")) {
				System.out.println("A bientôt " + login + TEXT_RESET);
				login = null;
				idUser = 0;
			}
		} else {
			System.out.println("saisissez votre login : ");
			String log = scan.next();
			System.out.println("saisissez votre password : ");
			String pwd = scan.next();

			int id = authenticate.existUser(log, pwd);
			if (id > 0) {
				login = log;
				idUser = id;
				System.out.print(TEXT_BLUE);
			} else {
				System.out.println("login ou password incorrect");
				System.out.println("Nouvel utilisateur, pour créer un compte, tapez ok");
				String ok = scan.next();
				if (ok.equalsIgnoreCase("ok")) {
					newUser();
				}
			}
		}
	}

	public static void newUser() {
		System.out.println("saisissez un login :");
		String login = scan.next();
		int id = authenticate.existUser(login);
		if (id == 0) {
			System.out.println("saisissez votre password :");
			String password = scan.next();
			authenticate.addUser(login, password);
			System.out.println("Ne perdez pas ces infos de connexion...");
			stop(2);
			System.out.println("création de l'utilisateur terminé, merci de vous connecter");
		} else
			System.out.println("Login déjà existant en base, veuillez vous connecter");
	}

	public static void stop(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static int newCustomer(int idUser) {
		System.out.println("Avez vous déjà un compte client ? saisissez une adresse email valide pour vérifier :");
		String email = scan.next();
		if (isValidEmail(email)) {
			Customer customer = authenticate.existCustomerByEmail(email);
			if (customer == null) {
				scan.nextLine();
				System.out.println("saisissez votre nom :");
				String name = scan.nextLine();
				System.out.println("saisissez votre prénom :");
				String fName = scan.next();
				System.out.println("saisissez votre tel :");
				String tel = scan.next();
				scan.nextLine();
				System.out.println("saisissez votre adresse :");
				String address = scan.nextLine();
				Customer cust = new Customer(name, fName, email, tel, address, idUser);
				if (authenticate.addCustomer(cust))
					return authenticate.existCustomerByEmail(email).getIdCustomer();
			} else {
				System.out.println("Nous allons associer la commande en cours avec le compte client : " + customer);
				return customer.getIdCustomer();
			}
		} else
			System.out.println("vous n'avez pas saisi un email valide");
		return 0;
	}

	public static boolean isValidEmail(String email) {
		String regExp = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z][a-z]+$";
		return email.matches(regExp);
	}

	public static void removeTraining() {
		System.out.println("Selectionner l'id de la formation à supprimer de votre panier");
		int id = scanInt();
		business.rmFromCart(id);
		displayCart(false);
	}

	private static void displayCategories() {
		System.out.println(Category.centerString(COLUMN_ID) + Category.centerString(COLUMN_NAME));
		business.readCategories().forEach(System.out::println);
		System.out.println("saisissez l'id d'un catégorie, pour avoir les détails");
		int id = scanInt();
		Category category = business.readOneCategory(id);
		if (category != null) {
			System.out.println(category.getName() + ":");
			int longueurTexte = category.getDescription().length();
			for (int i = 0; i < longueurTexte; i++) {
				System.out.print(category.getDescription().charAt(i));
				if ((i + 1) % LONGUEUR_LIGNE == 0) {
					System.out.print("\n");
				}
			}
		} else {
			System.out.println("cette catégorie n'existe pas !");
		}

	}

	private static void displayWeyword() {
		System.out.println("Saisissez un mot-clé:");
		String weyword = scan.next();
		ArrayList<Training> training = business.findTrainingByKeyword(weyword);
		if (training.isEmpty() != true) {
			System.out.printf("              AFFICHAGE PAR CATEGORIE    %n");
			System.out.printf("%-15s | %-35s | %-25s | %-15s %n", COLUMN_ID, COLUMN_DESCRIPTION, COLUMN_DURATION,
					COLUMN_PRICE);
			business.findTrainingByKeyword(weyword).forEach(a -> System.out.printf("%-15s | %-35s | %-25s | %-15s%n",
					a.getIdTraining(), a.getTrainingName(), a.getDuration(), a.getPrice()));
			;
		} else
			System.out.println("Aucune formation trouvé avec ce mot clé !");
	}

	private static void displayDistential() {
		Boolean present = true;
		String distentialInfo = null;
		System.out.println("Souhaitez vous voir les formations:\n" + "D pour Distancielle\n" + "P pour Présentielle");
		String value = scan.next();

		System.out.println(value);
		if (value.equalsIgnoreCase("p")) {
			present = false;
			distentialInfo = "Formations en Présentielle:";
		} else if (value.equalsIgnoreCase("d")) {
			distentialInfo = "Formations en Distancielle:";
		} else {
			System.out.println("Entrée non valide!");
			displayDistential();
			return;
		}

		System.out.println(distentialInfo);
		business.findTrainingByDistential(present).forEach(a -> System.out.printf("%-15s | %-35s | %-15s | %-15s%n",
				a.getIdTraining(), a.getTrainingName(), a.getDuration(), a.getPrice()));
	}

	private static void displayTrainingsByCategoryId() {
		displayCategories();
		System.out.println("saisissez l'id de la catégorie concerné");
		int id = scanInt();
		Category category = business.readOneCategory(id);
		if (category != null) {
			System.out.printf("              AFFICHAGE PAR CATEGORIE    %n");
			System.out.printf("                     %-10s               %n", category.getName());
			System.out.printf("------------------------------------------------------------%n");
			System.out.printf("%-15s | %-35s | %-15s | %-15s %n", COLUMN_ID, COLUMN_DESCRIPTION, COLUMN_DURATION,
					COLUMN_PRICE);
			System.out.printf("------------------------------------------------------------%n");
			business.readTrainingsByCatId(id).forEach(a -> System.out.printf("%-15s | %-35s | %-15s | %-15s%n",
					a.getIdTraining(), a.getTrainingName(), a.getDuration(), a.getPrice()));
		} else
			System.out.println("cette catégorie n'existe pas !");
	}

}
