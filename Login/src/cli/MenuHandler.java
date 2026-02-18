package cli;

import core.Command;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuHandler {
    private final List<Command> commands = new ArrayList<>();
    private final Scanner scanner;
    private boolean running = true;
    private User currentUser;

    public MenuHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        while (running) {
            showMenu();
            int choice = getUserChoice();
            executeChoice(choice);
        }
    }

    public void showMenu() {
        System.out.println("\n--- MENU ---");
        for (int i = 0; i < commands.size(); i++) {
            System.out.println((i + 1) + ". " + commands.get(i).getLabel());
        }
        System.out.println("0. Quitter");
        System.out.println("Votre choix : ");
    }

    private int getUserChoice() {
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void executeChoice(int choice) {
        if (choice == 0){
            running = false;
            System.out.println("\n--- Merci & Au revoir ---\n");
        } else if (choice > 0 && choice <= commands.size()) {
            commands.get(choice - 1).execute();
        } else  {
            System.out.println("\n--- Choix Invalide ---\n");
        }
    }

    public void addCommand(Command cmd) {
        this.commands.add(cmd);
    }
}