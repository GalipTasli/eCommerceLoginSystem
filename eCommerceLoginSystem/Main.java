package eCommerceLoginSystem;

import java.util.Scanner;

import eCommerceLoginSystem.business.concretes.GoogleAdaptManager;
import eCommerceLoginSystem.business.concretes.UserManager;
import eCommerceLoginSystem.dataAccess.concretes.UserDao;
import eCommerceLoginSystem.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		String name;
		String surname;
		String email;
		String password;
		Scanner scan = new Scanner(System.in);
		GoogleAdaptManager googleAdaptManager= new GoogleAdaptManager();
		System.out.println("HOÞGELDÝNÝZ");
		System.out.println("isminizi giriniz");
		name=scan.next();
		System.out.println("soyisminizi giriniz");
		surname=scan.next();
		System.out.println("e-mail adrsinizi giriniz");
		email= scan.next();
		System.out.println("parolanýzý giriniz");
		password= scan.next();
		User user = new User(name,surname,email,password) ;
		UserManager userManager = new UserManager();
		userManager.CheckEmailIfCorrect(user);
		System.out.println("***************************");
		userManager.CheckEmailIfCorrect2(user);
		System.out.println("***************************");
		userManager.CheckNameAndSurnameIfCorrect(user);
		System.out.println("***************************");
		userManager.CheckPasswordIfLenth(user);
		System.out.println("***************************");
		userManager.EmailFormat(user,googleAdaptManager);
		System.out.println("***************************");
		userManager.Login(user);
		System.out.println("***************************");
		userManager.Register(user);
		System.out.println("***************************");
		userManager.SendVerificationMessage(user);
		System.out.println("***************************");
		UserDao usermanagerdao= new UserDao();
		System.out.println("***************************");
		usermanagerdao.add(user);
		System.out.println("***************************");
		usermanagerdao.getAll();
		System.out.println("***************************");
		usermanagerdao.update(user);
		System.out.println("***************************");
		usermanagerdao.delete(user);
		System.out.println("***************************");
		GoogleAdaptManager googleAdaptManager2 = new GoogleAdaptManager();
		googleAdaptManager2.connectGoogle(user);
		
		

	}

}
