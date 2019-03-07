package core.elements;

import core.SimpleDownloaderLauncher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class DownloaderUI extends GridPane {
	
	private SimpleDownloaderLauncher launcher;
	private Downloader downloader;
	
	private TextField searchField;
	private Button downloadButton;
	private Label title;
	
	public DownloaderUI(SimpleDownloaderLauncher launcher, Downloader downloader) {
		this.launcher = launcher;
		this.downloader = downloader;
		
		setPadding(new Insets(10, 10, 10, 10));
		setVgap(5);
		setHgap(5);
		
		initNodes();
	}
	
	public void initNodes() {
		title = new Label("Simple Downloader");
		title.setStyle("-fx-font-size: 15pt;");
		add(title, 0, 0);
		
		downloadButton = new Button("Download");
		downloadButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				downloader.Download(searchField.getText());
			}
		});
		add(downloadButton, 1, 1);
		
		searchField = new TextField();
		searchField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent t) {
				if (t.getCode() == KeyCode.ENTER) {
					downloader.Download(searchField.getText());
				}
			}
		});
		searchField.setPrefColumnCount(24);
		add(searchField, 0, 1);
	}
}
