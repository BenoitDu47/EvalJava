package fr.fms;

import java.util.Scanner;
import java.util.function.Predicate;

import fr.fms.dao.CustomerDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.dao.TrainingDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Training;
import fr.fms.entities.User;

public class TestShopTrainings extends Thread {
	public TestShopTrainings(String name) {
		super(name);
	}

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + " : " + new TrainingDao().read(1));
		System.out.println(this.getName() + " : " + new UserDao().read(1));
		System.out.println(this.getName() + " : " + new CustomerDao().read(1));
	}

	public static void main(String[] args) {
		// testThreads();
		testUserTraining(); // Davy Jones
		// new UserDao().create(new User("toto", "123", false));
		// testDaoFactory();

	}

	private static void testThreads() {
		TestShopTrainings t1 = new TestShopTrainings(" 1-");
		TestShopTrainings t2 = new TestShopTrainings(" 2-");
		TestShopTrainings t3 = new TestShopTrainings(" 3-");

		t1.start();
		t2.start();
		t3.start();

	}

	/**
	 * Une méthode qui teste la fonctionnalité des classes UserDao et TrainingDao en
	 * invitant l'utilisateur à saisir son identifiant et son mot de passe, puis
	 * tentez de trouver un utilisateur avec ces informations d'identification. Si
	 * l'utilisateur est trouvé, la méthode imprime tous les objets Training de la
	 * base de données, sinon il affiche "accès refusé !".
	 */
	private static void testUserTraining() {
		Scanner scan = new Scanner(System.in);
		UserDao userDao = new UserDao();
		System.out.println("saisissez votre identifiant :");
		String login = scan.nextLine();
		System.out.println("saisissez votre password :");
		String pwd = scan.nextLine();

		User user = userDao.findUserByCredentials(login, pwd);
		if (user != null) {
			for (Training training : new TrainingDao().readAll()) {
				System.out.println(training);
			}
		} else
			System.out.println("accès refusé !");
		scan.close();
	}

	/**
	 * Une méthode qui teste la fonctionnalité de la classe DaoFactory en créant et
	 * en utilisant des instances des classes UserDao et TrainingDao. La méthode
	 * imprime la durée de tous les entraînements d'une durée supérieure ou égale à
	 * 4, puis imprime tous les utilisateurs.
	 */
	private static void testDaoFactory() {
		Dao<User> userDao = DaoFactory.getUserDao();
		System.out.println("Temps de formation supérieure a un moi.");
		Predicate<Training> artPredicate = a -> a.getDuration() >= 4;
		DaoFactory.getTrainingDao().readAll().stream().filter(artPredicate).forEach(System.out::println);
		System.out.println("---------------------------------------------");
		userDao.readAll().forEach(user -> System.out.println(user));
	}
}
