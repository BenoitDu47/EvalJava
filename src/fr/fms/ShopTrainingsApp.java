package fr.fms;

import java.util.Scanner;

import fr.fms.authentication.Authenticate;
import fr.fms.business.IBusinessImpl;

public class ShopTrainingsApp {
	private static Scanner scan = new Scanner(System.in);
	private static IBusinessImpl business = new IBusinessImpl();
	private static Authenticate authenticate = new Authenticate();

}
