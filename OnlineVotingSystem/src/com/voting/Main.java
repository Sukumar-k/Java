package com.voting;

import com.voting.dao.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        ElectionDAO electionDAO = new ElectionDAO();
        CandidateDAO candidateDAO = new CandidateDAO();
        VoteDAO voteDAO = new VoteDAO();

        System.out.println("Welcome to Online Voting System");
        System.out.println("1. Register\n2. Login\n3. Admin Login");

        int choice = sc.nextInt();
        sc.nextLine(); 
        
        if (choice == 1) {
            System.out.println("Enter Name:");
            String name = sc.nextLine();
            System.out.println("Enter Email:");
            String email = sc.nextLine();
            System.out.println("Enter Password:");
            String password = sc.nextLine();

            boolean success = userDAO.registerUser(name, email, password);
            if (success) {
                System.out.println("Registration Successful!");
            } else {
                System.out.println("Registration Failed! Email may already exist.");
            }
        } 
        else if (choice == 2) {
            System.out.println("Enter Email:");
            String email = sc.nextLine();
            System.out.println("Enter Password:");
            String password = sc.nextLine();

            int userId = userDAO.loginUser(email, password);
            if (userId > 0) {
                electionDAO.displayElections();
                System.out.print("Choose Election ID: ");
                int electionId = sc.nextInt();

                candidateDAO.displayCandidates(electionId);
                System.out.print("Enter Candidate ID to Vote: ");
                int candidateId = sc.nextInt();

                voteDAO.castVote(userId, electionId, candidateId);
            } else {
                System.out.println("Invalid Credentials!");
            }
        } 
        else if (choice == 3) {
            AdminMain.startAdminPanel();  
        } else {
            System.out.println("Invalid Choice! Exiting...");
        }
        sc.close();
    }
}
