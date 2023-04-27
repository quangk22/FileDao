package Quang.dev;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//import advance.dev.Shape;

public class MainApp {
	public static void main(String[] args) {
		IManager manager = new Manager();
		try {
			FileInputStream fstream = new FileInputStream("input.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				switch (strLine) {
					case "#circle":
						manager.add(readCircle(br));
						break;
					case "#rect":
						manager.add(readRect(br));
						break;
					case "#triangle":
						manager.add(readTriangle(br));
						break;
					default:
						break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		print(manager);
	}

	private static void print(IManager manager) {
		// TODO Auto-generated method stub
		for (Shape shape : manager.all()) {
			System.out.println(shape);
		}
	}

	private static Shape readTriangle(BufferedReader br) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		double a = Double.parseDouble(br.readLine());
		double b = Double.parseDouble(br.readLine());
		double c = Double.parseDouble(br.readLine());
		return new Triangle(a, b, c);
	}

	private static Shape readRect(BufferedReader br) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		double a = Double.parseDouble(br.readLine());
		double b = Double.parseDouble(br.readLine());
		return new Rect(a, b);
	}

	private static Shape readCircle(BufferedReader br) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		double r = Double.parseDouble(br.readLine());
		return new Circle(r);
	}

}
