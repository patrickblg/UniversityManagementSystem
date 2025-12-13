package com.example.UniversityManagementSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class UniversityManagementSystemApplication {

	public static void main(String[] args) {

        SpringApplication.run(UniversityManagementSystemApplication.class, args);

	}
    @EventListener(ApplicationReadyEvent.class)
    public void launchBrowser() {
        // This method runs automatically when the server is ready
        System.setProperty("java.awt.headless", "false"); // Ensures AWT can run
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI("http://localhost:8080/mainIndex"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
