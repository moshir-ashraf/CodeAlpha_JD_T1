/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package task1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Task1 extends Application {
    public static Stage movingStage = new Stage();
    public static ArrayList<Teacher> teachers;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        movingStage = mainMenu(primaryStage);
        movingStage.getIcons().add(new Image(new FileInputStream("images\\online-course.png")));
        movingStage.setTitle("Student Grade Tracker");
        movingStage.show();
    }
    public static Button createRoundedButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font("Constantia", 20));
        button.setStyle("-fx-background-color: #31B3C0; -fx-text-fill: white; -fx-background-radius: 20;");
        button.setPadding(new Insets(10));
        button.setMinWidth(150);
        button.setMinHeight(40);
        button.setOnMouseEntered(event -> button.setStyle("-fx-background-color: #BAD8DA; -fx-text-fill: white; -fx-background-radius: 20;"));
        button.setOnMouseExited(event -> button.setStyle("-fx-background-color: #31B3C0; -fx-text-fill: white; -fx-background-radius: 20;"));
        return button;
    }
    public static TextField createTextFieldWithPlaceholder(String placeholder,char t) {
        TextField textField = new TextField();
        textField.setPromptText(placeholder); 
        textField.setPrefHeight(40);
        textField.setPrefWidth(200);
        if(t == 's'){
        textField.setMaxHeight(30);
        textField.setMaxWidth(300);
        }
        if(t == 'p'){
        textField.setMaxHeight(15);
        textField.setMaxWidth(100);
        textField.setEditable(false);
        }
        textField.setAlignment(Pos.CENTER);
        return textField;
    }
    public static Stage mainMenu(Stage stage) throws FileNotFoundException{
        Image image = new Image(new FileInputStream("images\\renan-kamikoga-KxCq-xveKcU-unsplash.jpg"));
        BackgroundImage background = new BackgroundImage(image,
              BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(100,100, true, true, true, false));
        Background backgroundObj = new Background(background);
        Button loginButton = createRoundedButton("Log In");
        loginButton.setOnAction(e-> {
            try {
                movingStage = (logIn(stage));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Task1.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button signUpButton = createRoundedButton("Sign Up");
        signUpButton.setOnAction(e-> {
            try {
                movingStage = (signUp(stage));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Task1.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button exitButton = createRoundedButton("Exit");
        exitButton.setOnAction(e -> stage.close());
        VBox menu = new VBox(20);
        menu.setAlignment(Pos.CENTER);
        menu.getChildren().addAll(loginButton, signUpButton, exitButton);
        Label l1 = new Label("Student Gra");
        l1.setFont(Font.font("Impact", 40));
        l1.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        Label l2 = new Label("de Tracker");
        l2.setFont(Font.font("Impact", 40));
        l2.setStyle("-fx-font-weight: bold; -fx-text-fill: #F7BC6E;");
        HBox title = new HBox(l1,l2);
        title.setAlignment(Pos.CENTER);
        VBox root = new VBox(title,menu);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setBackground(backgroundObj);
        Scene scene = new Scene(root, 765, 600); 
         scene.setOnKeyPressed(e->{
       if(e.getCode() == KeyCode.ENTER) loginButton.fire();
       if(e.getCode() == KeyCode.ESCAPE) exitButton.fire();
       });
        stage.setScene(scene);
        stage.setResizable(false);
        return stage;
    }
    public static Button btn2 (String txt , char t, int dt){
       Button button = new Button(txt);
       button.setFont(Font.font("Constantia", 20));
       button.setPadding(new Insets(10));
       VBox.setMargin(button, new Insets(5, 0, 0, 0));
       if(t == 'l'){
         button.setMinWidth(200);
       button.setMinHeight(40);
       if(dt == 1 ){
       button.setStyle("-fx-background-color: #B6BFAB; -fx-text-fill: white; -fx-background-radius: 5;");
       button.setOnMouseEntered(event -> button.setStyle("-fx-background-color: #9EA694; -fx-text-fill: white; -fx-background-radius: 5;"));
       button.setOnMouseExited(event -> button.setStyle("-fx-background-color: #B6BFAB; -fx-text-fill: white; -fx-background-radius: 5;"));
       }
       if(dt == 2){
        button.setStyle("-fx-background-color: #CA5023; -fx-text-fill: white; -fx-background-radius: 5;");
       button.setOnMouseEntered(event -> button.setStyle("-fx-background-color: #9E4220; -fx-text-fill: white; -fx-background-radius: 5;"));
       button.setOnMouseExited(event -> button.setStyle("-fx-background-color: #CA5023; -fx-text-fill: white; -fx-background-radius: 5;")); 
       }
       }
       if(t=='s'){
             button.setMinWidth(200);
       button.setMinHeight(40);
           if(dt==1){
        button.setStyle("-fx-background-color: #EFA751; -fx-text-fill: white; -fx-background-radius: 5;"); 
        button.setOnMouseEntered(event -> button.setStyle("-fx-background-color: #C98D45; -fx-text-fill: white; -fx-background-radius: 5;"));
       button.setOnMouseExited(event -> button.setStyle("-fx-background-color: #EFA751; -fx-text-fill: white; -fx-background-radius: 5;"));
       }
           if(dt ==2){
            button.setStyle("-fx-background-color: #A3DCE5; -fx-text-fill: white; -fx-background-radius: 5;"); 
        button.setOnMouseEntered(event -> button.setStyle("-fx-background-color: #91C2CA; -fx-text-fill: white; -fx-background-radius: 5;"));
       button.setOnMouseExited(event -> button.setStyle("-fx-background-color: #A3DCE5; -fx-text-fill: white; -fx-background-radius: 5;"));
       
           }
       }
       if(t=='i'){
            button.setMaxWidth(90);
       button.setMaxHeight(5); 
       button.setFont(Font.font("Constantia", 14));
       button.setStyle("-fx-background-color: #6CA4C2; -fx-text-fill: white; -fx-background-radius: 5;"); 
          button.setOnMouseEntered(event -> button.setStyle("-fx-background-color: #437E9E; -fx-text-fill: white; -fx-background-radius: 5;"));
       button.setOnMouseExited(event -> button.setStyle("-fx-background-color: #6CA4C2; -fx-text-fill: white; -fx-background-radius: 5;"));
       }
        return button;
    }
    public static Stage logIn (Stage stage) throws FileNotFoundException{
       Image image = new Image(new FileInputStream("images\\robert-bagramov-NCfSF2B_htQ-unsplash.jpg"));
       ImageView im = new ImageView(image);
       im.setFitHeight(600); 
       im.setPreserveRatio(true);
       im.setSmooth(true); 
       im.setCache(true); 
       Label l1 = new Label("Teacher LogIn Form");
       l1.setAlignment(Pos.CENTER);
       l1.setFont(Font.font("Impact", 19));
       l1.setStyle("-fx-text-fill: #CA5023;");
       VBox.setMargin(l1, new Insets(0, 5, 10, 20));
       TextField emailField = createTextFieldWithPlaceholder("Enter your Email",'l');
       TextField passwordField = createTextFieldWithPlaceholder("Enter your Password",'l');
       Button backButton = btn2("Back",'l',2);
       Button nextButton = btn2("Log In",'l',1);
        Label error = new Label();
       nextButton.setOnAction(e->{
       int temp = login(emailField.getText(),passwordField.getText());
       if(temp >= 0) try {
           movingStage = profile(stage,temp);
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Task1.class.getName()).log(Level.SEVERE, null, ex);
       }
       else if(temp == -3) error.setText("INVALID DATA ENTRY");
       else if(temp == -2) error.setText("PASSWORD INCORRECT");
       else error.setText("Teacher not Registered");
       });

       backButton.setOnAction(e -> {
           try {
               movingStage = mainMenu(stage);
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Task1.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
       VBox form = new VBox(50,l1,emailField,passwordField,nextButton,backButton,error);
       form.setAlignment(Pos.CENTER_LEFT);
       form.setPadding(new Insets(90));
       form.setSpacing(5.5);
       HBox root = new HBox(form,im);
       root.setAlignment(Pos.TOP_RIGHT);
       root.setStyle("-fx-background-color: white;");
       Scene scene = new Scene(root, 765, 600); 
       scene.setOnKeyPressed(e->{
       if(e.getCode() == KeyCode.ENTER) nextButton.fire();
       if(e.getCode() == KeyCode.ESCAPE) backButton.fire();
       });
       stage.setScene(scene);
       return stage; 
    }
    public static Stage signUp (Stage stage) throws FileNotFoundException{
        Image image = new Image(new FileInputStream("images\\moren-hsu-VLaKsTkmVhk-unsplash.jpg"));
        ImageView view = new ImageView(image);
        view.setOpacity(0.5);
        view.setFitHeight(600);
        view.setPreserveRatio(true);
        view.setSmooth(true);
        view.setCache(true);
        view.setScaleZ(-1);
        Label l1 = new Label("Teacher SignUp Form");
       l1.setAlignment(Pos.CENTER);
       l1.setFont(Font.font("Impact", 19));
       l1.setStyle("-fx-text-fill: #CA5023;");
       TextField nameField = createTextFieldWithPlaceholder("Enter your Name",'s');
       TextField emailField = createTextFieldWithPlaceholder("Enter your Email",'s');
       TextField passwordField = createTextFieldWithPlaceholder("Enter your Password",'s');
       Button backButton = btn2("Back",'s',1);
       backButton.setOnAction(e -> {
           try {
               movingStage = mainMenu(stage);
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Task1.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
       Label error = new Label();
       Button nextButton = btn2("Sign Up",'s',2);
       nextButton.setOnAction(e->{
       int temp = signup(nameField.getText(),emailField.getText(),passwordField.getText());
       if(temp>=0) try {
           movingStage = profile(stage,temp);
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Task1.class.getName()).log(Level.SEVERE, null, ex);
       }
       else if(temp == -2) error.setText("INVALID DATA ENTRY");
       else error.setText("Teacher is already Registered");
       
       });
        VBox form = new VBox(l1,nameField,emailField,passwordField,nextButton,backButton,error);
        form.setAlignment(Pos.CENTER);
        form.setStyle("-fx-background-color: white;");
        form.setMaxSize(400,400);
        form.setSpacing(10);
        StackPane root = new StackPane(view,form);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 765, 600); 
         scene.setOnKeyPressed(e->{
       if(e.getCode() == KeyCode.ENTER) nextButton.fire();
       if(e.getCode() == KeyCode.ESCAPE) backButton.fire();
       });
        stage.setScene(scene);
        return stage;
    }
    
    public static Stage profile(Stage stage,int index) throws FileNotFoundException{
        Image image = new Image(new FileInputStream("images\\inaki-del-olmo-NIJuEQw0RKg-unsplash.jpg"));
        ImageView view = new ImageView(image);
        view.setOpacity(0.6);
        view.setFitHeight(600);
        view.setPreserveRatio(true);
        view.setSmooth(true);
        view.setCache(true);
        view.setScaleZ(-1);
        ImageView icon = new ImageView(new Image(new FileInputStream("images\\graduation-hat.png")));
        icon.setFitHeight(30);
        icon.setPreserveRatio(true);
        TextField nameField = createTextFieldWithPlaceholder(teachers.get(index).getName(),'p');
        TextField emailField = createTextFieldWithPlaceholder(teachers.get(index).getEmail(),'p');
        TextField passwordField = createTextFieldWithPlaceholder(new String(new char[teachers.get(index).getPassword().length()]).replace('\0', '*'),'p');
        Button editInfo = btn2("Edit",'i',0);
        editInfo.setOnAction(e->{
            if(editInfo.getText().equals("Edit")){
        nameField.setEditable(true);
        emailField.setEditable(true);
        passwordField.setEditable(true);
        editInfo.setText("Save");
            }
           if(editInfo.getText().equals("Save")){
                teachers.get(index).setName(nameField.getText());
                teachers.get(index).setEmail(emailField.getText());
                teachers.get(index).setPassword(passwordField.getText());
                nameField.setEditable(false);
                emailField.setEditable(false);
                passwordField.setText(new String(new char[teachers.get(index).getPassword().length()]).replace('\0', '*'));
                passwordField.setEditable(false);
                editInfo.setText("Edit");
           }
        });
        VBox info = new VBox(icon,nameField,emailField,passwordField,editInfo);
        info.setSpacing(2);
        info.setPadding(new Insets(1.5));
        info.setAlignment(Pos.CENTER);
        info.setStyle("-fx-background-color: #DFD7C8;");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        GridPane.setConstraints(info, 0, 0); // column=0, row=0
        grid.getChildren().add(info);
        StackPane root = new StackPane(view,grid);
        Scene scene = new Scene (root,765,600);
        stage.setScene(scene);
        return stage;
    }
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        teachers = Teacher.load("teachers.bin");
        if(teachers == null) teachers = new ArrayList<>();
        System.out.println(teachers.toString());
        launch(args);
        Teacher.save(teachers, "teachers.bin");
    }
    
    public static int login(String email, String password){
        if(!Validation.validateEmail(email) || password.length()<Validation.PASSMIN) return -3;
        for(short i=0; i<teachers.size(); i++){
            if(teachers.get(i).getEmail().equals(email)){
                if(teachers.get(i).getPassword().equals(password)) return i;
                return -2;
            } 
        }
        return -1;
    }
    public static int signup(String name, String email, String password){
        if(!(Validation.validateEmail(email) && Validation.validateName(name) && Validation.validatePassword(password, name, email))) return -2;
        for(short i=0; i<teachers.size(); i++){
            if(teachers.get(i).getEmail().equals(email)) return -1;
        }
        teachers.add(new Teacher(name,email,password));
        return teachers.size()-1;
    }
}
