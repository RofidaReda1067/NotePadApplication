/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notepad;

import com.sun.media.jfxmediaimpl.platform.Platform;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author Rofida
 */
public class Notepad extends Application {

    TextArea txtarea = new TextArea();
    MenuBar menubar = new MenuBar();
    Menu file = new Menu("File ");
    Menu edit = new Menu("Edit");
    Menu help = new Menu("Help");

    //////////file navbar////////
    MenuItem New = new MenuItem("New");
    /* New.setAccelerator(KeyCombination.keyCombination("Ctrl+n"));*/
    MenuItem Open = new MenuItem("Open");
    MenuItem Save = new MenuItem("Save");
    MenuItem Exit_btn = new MenuItem("Exit");
    //////////////////////////

    //////////////Edit navbar//////////
    MenuItem Undo = new MenuItem("Undo");
    /*New.setAccelerator(KeyCombination.keyCombination("Ctrl+z"));*/
    MenuItem Cut = new MenuItem("Cut");
    MenuItem Copy = new MenuItem("Copy");
    MenuItem Paste = new MenuItem("Paste");
    MenuItem Delete = new MenuItem("Delete");
    MenuItem SelectAll = new MenuItem("SelectAll");
    ////////////////////////

    //////////////////Help navbar///////////
    MenuItem About_Notepad = new MenuItem("Notepad");
    SeparatorMenuItem sp1 = new SeparatorMenuItem();
    SeparatorMenuItem sp2 = new SeparatorMenuItem();
    SeparatorMenuItem sp3 = new SeparatorMenuItem();
///////////////////

    @Override
    public void init() {
        ///MenuBar Part///

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        ///////////////////////////////NEW 
        New.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtarea.clear();
            }

        });
//////////////////////////Open////////////




        ///////////////////////////////exit
        Exit_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               primaryStage.close();
            }
        });
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        ///////////////////////////////Undo 
        Undo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtarea.undo();
            }
        });

///////////////////////////////Copy
        Copy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtarea.copy();
            }
        });

///////////////////////////////Cut 
        Cut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtarea.cut();
            }
        });

///////////////////////////////Paste
        Paste.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtarea.paste();
            }
        });

///////////////////////////////Delete 
        Delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtarea.deleteText(txtarea.getSelection());
            }
        });

///////////////////////////////SelectAll
        SelectAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtarea.selectAll();
            }
        });

//_______________________________________________________ MENU ________________________________________________
        file.getItems().addAll(New, Open, Save, Exit_btn);
//////////////separator//////////////
        file.getItems().add(3, sp1);
        edit.getItems().addAll(Undo, Cut, Copy, Paste, Delete, SelectAll);
        edit.getItems().add(1, sp2);
        edit.getItems().add(6, sp3);
        help.getItems().addAll(About_Notepad);
        menubar.getMenus().addAll(file, edit, help);
/////////////////////////////////////////////////////////////////////
New.setAccelerator(KeyCombination.keyCombination("Ctrl+r"));
/////////////////////////////////////////////////////////////////////
        BorderPane pane = new BorderPane();
        pane.setTop(menubar);
        pane.setCenter(txtarea);
        Scene s = new Scene(pane, 500, 500);
        Stage st = new Stage();
        primaryStage.setTitle("my notepad");
        primaryStage.setScene(s);
        primaryStage.show();






        
    
}
    public static void main(String[] args) {
        Application.launch(args);
    }

}
