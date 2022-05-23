package JavaChallenge;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id =0;

    public static void main(String[] args) {
        contacts = new ArrayList<>();
        System.out.println("Welcome to challenge");
        showInitialOpetion();
    }

    private static void showInitialOpetion() {
        System.out.println("Please select one: " +
                "\n\t1. Manage Contacts" +
                "\n\t2. Messages" +
                "\n\t3. Quit");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;
        }
    }

    private static void manageMessages() {
        System.out.println("Please Select one: " +
                "\n\t1. Show all Messages" +
                "\n\t2. Add a new Messages" +
                "\n\t3. Search for Messages");
        int choice  = scanner.nextInt();
        switch (choice){
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewMessage();
                break;
            default:
                showInitialOpetion();
                break;
        }

    }

    private static void sendNewMessage() {
        System.out.println("Who are going to send a message");
        String name = scanner.next();
        if (name.equals("")){
            System.out.println("Please enter the name");
            sendNewMessage();

        }else {
            boolean doesExit = false;

            for(Contact c:contacts){
                if (c.getName().equals(name)){
                  doesExit = true;
                }
            }
            if (doesExit){
                System.out.println("What are you going to say");
                String tetx = scanner.next();
                if (tetx.equals("")){
                    System.out.println("Enter some text!");
                    sendNewMessage();
                }else {
                    id++;
                    Message newMesssage = new Message(tetx,name,id);
                    for(Contact c : contacts){
                        if (c.getName().equals(name)){
                            ArrayList<Message> newMessages = c.getMessages();
                            newMessages.add(newMesssage);
                            Contact currentContact = c;
                            currentContact.setMessages(newMessages);
                            contacts.remove(c);
                            contacts.add(currentContact);

                        }
                    }
                     
                }
            }else {
                System.out.println("There is no such contact");
            }
        }
        showInitialOpetion();
    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Contact c:contacts) {
            allMessages.addAll(c.getMessages());
        }
        if (allMessages.size()>0){
            for (Message m: allMessages){
                m.getDetails();
                System.out.println("*************");
            }
        }else {
            System.out.println("you dont have any message");
        }
        showInitialOpetion();
    }

    private static void manageContacts() {
        System.out.println("Please Select one: " +
                "\n\t1. Show all contacts" +
                "\n\t2. Add a new contact" +
                "\n\t3. Search for contact" +
                "\n\t4. Delete a contact" +
                "\n\t5. Go back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOpetion();
                break;
        }
    }

    private static void deleteContact() {
        System.out.println("Please enter the name:");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name:");
            deleteContact();
        } else {
            boolean doesExit = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExit = true;
                    contacts.remove(c);
                }

            }
            if (!doesExit) {
                System.out.println("There is no such contacts");
            }
        }

        showInitialOpetion();
    }

    private static void searchForContact() {
        System.out.println("PLease enter the contact name:");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name:");
            searchForContact();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    c.getDetails();
                }
            }
            if (!doesExist) {
                System.out.println("There is no such contacts");
            }
        }
        showInitialOpetion();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact" +
                "\nPlease enter the contact name:");
        String name = scanner.next();
        System.out.println("Please enter contact's number:");
        String number = scanner.next();
        System.out.println("Please enter contact's email:");
        String email = scanner.next();

        if (name.equals("") || number.equals("") || email.equals("")) {
            System.out.println("Please enter the info");
            addNewContact();
        } else {

            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                }
            }
            if (doesExist){
                System.out.println("We have contact named "+ name+"saved on this device");
                addNewContact();
            }else {
                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                System.out.println(name+"Add Successfully");
            }

        }

        showInitialOpetion();
    }

    private static void showAllContacts() {
        for (Contact c : contacts) {
            c.getDetails();
            System.out.println("*******************");
        }
        showInitialOpetion();
    }


}
