package com.voting;

import com.voting.dao.AdminDAO;
import com.voting.dao.ElectionDAO;
import com.voting.dao.CandidateDAO;
import java.util.Scanner;

public class AdminMain {
    public static void startAdminPanel() {  
        Scanner sc = new Scanner(System.in);
        AdminDAO adminDAO = new AdminDAO();
        ElectionDAO electionDAO = new ElectionDAO();
        CandidateDAO candidateDAO = new CandidateDAO();

        System.out.println("Enter Admin Username:");
        String username = sc.nextLine();
        System.out.println("Enter Admin Password:");
        String password = sc.nextLine();

        boolean isAdmin = adminDAO.loginAdmin(username, password);
        if (!isAdmin) {
            System.out.println("Invalid Admin Credentials!");
            return;
        }

        System.out.println("Admin Login Successful!");
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Election");
            System.out.println("2. Add Candidate");
            System.out.println("3. View Elections");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.println("Enter Election Name:");
                String electionName = sc.nextLine();
                electionDAO.addElection(electionName);
                System.out.println("Election Added Successfully!");
            } 
            else if (choice == 2) {
                System.out.println("Enter Election ID:");
                int electionId = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Candidate Name:");
                String candidateName = sc.nextLine();
                System.out.println("Enter Party:");
                String party = sc.nextLine();

                candidateDAO.addCandidate(electionId, candidateName, party);
                System.out.println("Candidate Added Successfully!");
            } 
            else if (choice == 3) {
                electionDAO.displayElections();
            } 
            else if (choice == 4) {
                System.out.println("Exiting Admin Panel...");
                break;
            } 
            else {
                System.out.println("Invalid Choice!");
            }
        }
        sc.close();
    }
}
