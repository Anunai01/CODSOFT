import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private String cardNumber = "5040936076591368";
    private String pin = "8547";
    private double balance = 10000.0;

    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        JOptionPane.showMessageDialog(null, "Deposit successful. New balance: ₹" + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrawal successful. New balance: ₹" + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds.");
        }
    }

    public String miniStatement() {
        return "Mini Statement:\nTransaction 1: ₹100 deposited\nTransaction 2: ₹50 withdrawn";
    }

    public void fastCash() {
        double withdrawalAmount = 100;
        if (balance >= withdrawalAmount) {
            balance -= withdrawalAmount;
            JOptionPane.showMessageDialog(null, "Fast Cash: ₹" + withdrawalAmount + " withdrawn. New balance: $" + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds for Fast Cash.");
        }
    }
}

class ATMSimulator extends JFrame implements ActionListener {
    private BankAccount bankAccount;
    private JTextField tf1;
    private JPasswordField tf2;

    public ATMSimulator() {
        bankAccount = new BankAccount();
        setContentPane(new JLabel(new ImageIcon("aaaresize.jpg")));
        setTitle("ATM System");
        setSize(550,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Arial", Font.BOLD, 30));
        l1.setBounds(80, 30, 380, 40);

        JLabel l2 = new JLabel("CARD");
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setBounds(80, 100, 100, 30);

        JLabel l3 = new JLabel("PIN");
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setBounds(80, 150, 100, 30);

        tf1 = new JTextField();
        tf1.setFont(new Font("Arial", Font.BOLD, 20));
        tf1.setBounds(200, 100, 200, 30);

        tf2 = new JPasswordField();
        tf2.setFont(new Font("Arial", Font.BOLD, 20));
        tf2.setBounds(200, 150, 200, 30);

        JButton b1 = new JButton("Login");
        b1.setBounds(80, 220, 100, 30);
        b1.setActionCommand("Login");

        JButton b2 = new JButton("Reset");
        b2.setBounds(220, 220, 100, 30);
        b2.setActionCommand("Reset");

        JButton b3 = new JButton("Register");
        b3.setBounds(360, 220, 100, 30);
        b3.setActionCommand("Register");

        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(b1);
        add(b2);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Login")) {
            String cardNo = tf1.getText();
            char[] pinChars = tf2.getPassword();
            String pin = new String(pinChars);

            if (cardNo.equals("5040936076591368") && pin.equals("8547")) {
                setVisible(false);
                new ATMGUIFrame(bankAccount).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
            }
        } else if (ae.getActionCommand().equals("Reset")) {
            tf1.setText("");
            tf2.setText("");
        } else if (ae.getActionCommand().equals("Register")) {
            JOptionPane.showMessageDialog(null, "Registration functionality to be implemented.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ATMSimulator::new);
    }
}

class ATMGUIFrame extends JFrame implements ActionListener {
    private BankAccount bankAccount;

    public ATMGUIFrame(BankAccount account) {
        bankAccount = account;

        setTitle("ATM Options");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setContentPane(new JLabel(new ImageIcon("aaa.jpg")));
        JLabel l1=new JLabel("Please Select Your Transaction");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton checkBalanceButton = new JButton("Check Balance");
        JButton miniStatementButton = new JButton("Mini Statement");
        JButton fastCashButton = new JButton("Fast Cash");
        JButton exitButton = new JButton("Exit");
        l1.setFont(new Font("Arial",Font.BOLD,40));
        l1.setBounds(150,30,700,40);
        depositButton.setBounds(125,150,250,50);
        withdrawButton.setBounds(125,220,250,50);
        miniStatementButton.setBounds(125,290,250,50);
        checkBalanceButton.setBounds(600,150,250,50);
        fastCashButton.setBounds(600,220,250,50);
        exitButton.setBounds(600,290,250,50);
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        checkBalanceButton.addActionListener(this);
        miniStatementButton.addActionListener(this);
        fastCashButton.addActionListener(this);
        exitButton.addActionListener(this);
        add(l1);
        add(depositButton);
        add(withdrawButton);
        add(checkBalanceButton);
        add(miniStatementButton);
        add(fastCashButton);
        add(exitButton);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Deposit")) {
            String depositAmountString = JOptionPane.showInputDialog("Enter the deposit amount:");
            if (depositAmountString != null) {
                try {
                    double depositAmount = Double.parseDouble(depositAmountString);
                    bankAccount.deposit(depositAmount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
                }
            }
        } else if (e.getActionCommand().equals("Withdraw")) {
            String withdrawAmountString = JOptionPane.showInputDialog("Enter the withdrawal amount:");
            if (withdrawAmountString != null) {
                try {
                    double withdrawAmount = Double.parseDouble(withdrawAmountString);
                    bankAccount.withdraw(withdrawAmount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
                }
            }
        } else if (e.getActionCommand().equals("Check Balance")) {
            double balance = bankAccount.getBalance();
            JOptionPane.showMessageDialog(null, "Your balance: ₹" + balance);
        } else if (e.getActionCommand().equals("Mini Statement")) {
            String statement = bankAccount.miniStatement();
            JOptionPane.showMessageDialog(null, statement);
        } else if (e.getActionCommand().equals("Fast Cash")) {
            bankAccount.fastCash();
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }
}

