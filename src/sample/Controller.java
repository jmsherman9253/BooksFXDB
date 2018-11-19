package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.*;

public class Controller {
/*
Initialize the fxml features.
 */
    @FXML
    private Label lblFirstName;
    @FXML
    private Label lblLastName;
    @FXML
    private Label lblAuthorID;
    @FXML
    private Label lblSearchFirst;
    @FXML
    private Label lblSearchLast;
    @FXML
    private Label lblSearchID;
    @FXML
    private Label lblMessage;
    @FXML
    private TextField txtSearch;


    @FXML
    void connectButtonHandler(ActionEvent event) {
        /*
        -Method will handle the connect all button... sets author id, first, and last name
        -Resets the message label after each press of any button so that the current
        message is up to date
         */
        lblMessage.setText("Message Center");
        final String DATABASE_URL = "jdbc:derby:Lib\\books";
        final String SELECT_QUERY =
                "SELECT authorID, firstName, lastName FROM authors";
        // use try-with-resources to connect to and query the database
        try (
                // Statments 1,3,4 here are very important for database work
                Connection connection = DriverManager.getConnection(
                        DATABASE_URL, "deitel", "deitel");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_QUERY))
        {
            resultSet.next();
            lblFirstName.setText(resultSet.getString(2));
            lblLastName.setText(resultSet.getString(3));
            lblAuthorID.setText(resultSet.getString(1));
        } // AutoCloseable objects' close methods are called now
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }

    @FXML
    void connectFirstNameHandler(ActionEvent event){
        /*
        -connects the first name label
        -Resets the message label after each press of any button so that the current
        message is up to date
         */
        lblMessage.setText("Message Center");
        final String DATABASE_URL = "jdbc:derby:Lib\\books";
        final String SELECT_QUERY =
                "SELECT authorID, firstName, lastName FROM authors";
        // use try-with-resources to connect to and query the database
        try (
                // Statments 1,3,4 here are very important for database work
                Connection connection = DriverManager.getConnection(
                        DATABASE_URL, "deitel", "deitel");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_QUERY))
        {
            resultSet.next();
            lblFirstName.setText(resultSet.getString(2));
        } // AutoCloseable objects' close methods are called now
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }

    @FXML
    void connectLastNameHandler(ActionEvent event){
        /*
        -connects the last name label
        -Resets the message label after each press of any button so that the current
        message is up to date
         */
        lblMessage.setText("Message Center");
        final String DATABASE_URL = "jdbc:derby:Lib\\books";
        final String SELECT_QUERY =
                "SELECT authorID, firstName, lastName FROM authors";
        // use try-with-resources to connect to and query the database
        try (
                // Statments 1,3,4 here are very important for database work
                Connection connection = DriverManager.getConnection(
                        DATABASE_URL, "deitel", "deitel");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_QUERY))
        {
            resultSet.next();
            lblLastName.setText(resultSet.getString(3));
        } // AutoCloseable objects' close methods are called now
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }

    @FXML
    void connectAuthorIDHandler(ActionEvent event){
        /*
        -connects the author id label
        -Resets the message label after each press of any button so that the current
        message is up to date
         */
        lblMessage.setText("Message Center");
        final String DATABASE_URL = "jdbc:derby:Lib\\books";
        final String SELECT_QUERY =
                "SELECT authorID, firstName, lastName FROM authors";
        // use try-with-resources to connect to and query the database
        try (
                // Statments 1,3,4 here are very important for database work
                Connection connection = DriverManager.getConnection(
                        DATABASE_URL, "deitel", "deitel");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_QUERY))
        {
            resultSet.next();
            lblAuthorID.setText(resultSet.getString(1));
        } // AutoCloseable objects' close methods are called now
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }

    @FXML
    void searchIDHandler(ActionEvent event){
        /*
        -Intended to search the database by the author id to select a specific
        author
        -user will enter the author id into the text field and then search
        -Resets the message label after each press of any button so that the current
        message is up to date
         */
        lblMessage.setText("Message Center");
        int id = Integer.parseInt(txtSearch.getText());
        txtSearch.setText("");

        if(id <= 5){
            System.out.println(id);
            System.out.println("The Author Id is: " + id);

            //enter code to search the database for the authors id, then
            //output the results into the labels

            lblSearchFirst.setText("found first name");
            lblSearchLast.setText("found last name");
            lblSearchID.setText("confirmed author ID");
        }else{
            lblMessage.setText("Author ID entered is not within the range");
        }
    }

    @FXML
    void resetLabelsHandler(ActionEvent event){
        /*
        resets all labels
         */
        lblFirstName.setText("First Name");
        lblLastName.setText("Last Name");
        lblAuthorID.setText("Author ID");
        lblSearchFirst.setText("Search First");
        lblSearchLast.setText("Search Last");
        lblSearchID.setText("Search ID");
        lblMessage.setText("Message Center");
    }

}

