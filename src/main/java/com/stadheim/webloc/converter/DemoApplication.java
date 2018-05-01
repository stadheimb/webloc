package com.stadheim.webloc.converter;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		System.out.println("Converting webloc files in: " + args[0]);
		File dir = new File(args[0]);

		for (File file : dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".webloc");
			}
		})) {
			System.out.println("[WEBLOC] " + file.getName());
			try {
				Webloc mac = new Webloc(file);
				mac.load();
				System.out.println("URL -> " + mac.toString());

				Winurl win = new Winurl(mac);
				win.move("winurls");
				win.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
