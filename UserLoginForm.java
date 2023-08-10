import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextArea displayArea;

    public UserLoginForm() {
        setTitle("User Login Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        panel.add(usernameLabel);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        panel.add(passwordLabel);
        panel.add(passwordField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                insertDataIntoDatabase(username, password);
            }
        });

        JButton showDatabaseButton = new JButton("Show Database");
        showDatabaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayDatabaseContents();
            }
        });

        panel.add(submitButton);
        panel.add(showDatabaseButton);

        add(panel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void insertDataIntoDatabase(String username, String password) {
        // ... Previous database insertion code ...

        // Display success message in the text area
        displayArea.setText("Data inserted successfully!");
    }

    private void displayDatabaseContents() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String pass = "root";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
            String selectQuery = "SELECT * FROM student1";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder result = new StringBuilder();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                result.append("ID: ").append(id).append(", Username: ").append(username).append(", Password: ").append(password).append("\n");
            }

            displayArea.setText(result.toString());

            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while connecting to the database.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserLoginForm form = new UserLoginForm();
            form.setVisible(true);
        });
    }
}
