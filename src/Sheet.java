import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.Flow;


public class Sheet extends Application {
	static BorderPane bPane;
	static FlowPane pages;
	static Scene scene;
	static Stage stage;


	@Override
	public void start(Stage staeg) throws Exception{

		//<editor-fold desc="Global setup">
		stage = staeg;
		bPane = new BorderPane();
		scene = new Scene(bPane);
		pages = new FlowPane();
		Page Main = new Page("Main");
		Page Skills = new Page("Skills");
		Page Features = new Page("Features");
		Page Spells = new Page("Spells");
		Page Resources = new Page("Resources");
		Page Equipment = new Page("Equipment");
		Page Inventory = new Page("Inventory");
		Page Notes = new Page("Notes");
		Page Options = new Page("Options");
		pages.getChildren().addAll(Main, Skills, Features, Spells, Resources, Equipment, Inventory, Notes, Options);
		bPane.setTop(pages);
		stage.setTitle("5e Character Sheet");
		stage.setScene(scene);
		//</editor-fold>

		//<editor-fold desc="Main setup">
		Main.pane.setSpacing(5);
		SimpleIntegerProperty Strength = new SimpleIntegerProperty(10);
		SimpleIntegerProperty StrengthMod = new SimpleIntegerProperty(0);
		StrengthMod.bind(Strength.subtract(10).divide(2));
		TextField Str = new TextField(((Integer)10).toString());
		Text str = new Text(" Bonus: 0");
		Str.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,2}([\\.]\\d{0,0})?")) {
					Str.setText(oldValue);
				}
				else if (newValue.length() > 0){
					Strength.set(Integer.parseInt(newValue));
					str.setText(" Bonus: " + ((Integer)((Strength.intValue() - 10) / 2)).toString()+"\t");
				} else {
					str.setText(" Bonus:\t");
				}
			}
		});


		SimpleIntegerProperty Dexterity = new SimpleIntegerProperty(10);
		SimpleIntegerProperty DexterityMod = new SimpleIntegerProperty(0);
		DexterityMod.bind(Dexterity.subtract(10).divide(2));
		TextField Dex = new TextField(((Integer)10).toString());
		Text dex = new Text(" Bonus: 0");
		Dex.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,2}([\\.]\\d{0,0})?")) {
					Dex.setText(oldValue);
				}else if (newValue.length() > 0){
					Dexterity.set(Integer.parseInt(newValue));
					dex.setText(" Bonus: " + ((Integer)((Dexterity.intValue() - 10) / 2)).toString()+"\t");
				} else {
					dex.setText(" Bonus:\t");
				}
			}
		});

		SimpleIntegerProperty Constitution = new SimpleIntegerProperty(10);
		SimpleIntegerProperty ConstitutionMod = new SimpleIntegerProperty(0);
		ConstitutionMod.bind(Constitution.subtract(10).divide(2));
		TextField Con = new TextField(((Integer)10).toString());
		Text con = new Text(" Bonus: 0");
		Con.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,2}([\\.]\\d{0,0})?")) {
					Con.setText(oldValue);
				}
				else if (newValue.length() > 0){
					Constitution.set(Integer.parseInt(newValue));
					con.setText(" Bonus: " + ((Integer)((Constitution.intValue() - 10) / 2)).toString()+"\t");
				} else {
					con.setText(" Bonus:\t");
				}
			}
		});

		SimpleIntegerProperty Intelligence = new SimpleIntegerProperty(10);
		SimpleIntegerProperty IntelligenceMod = new SimpleIntegerProperty(0);
		IntelligenceMod.bind(Intelligence.subtract(10).divide(2));
		TextField Int = new TextField(((Integer)10).toString());
		Text intt = new Text(" Bonus: 0");
		Int.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,2}([\\.]\\d{0,0})?")) {
					Int.setText(oldValue);
				}
				else if (newValue.length() > 0){
					Intelligence.set(Integer.parseInt(newValue));
					intt.setText(" Bonus: " + ((Integer)((Intelligence.intValue() - 10) / 2)).toString()+"\t");
				} else {
					intt.setText(" Bonus:\t");
				}
			}
		});

		SimpleIntegerProperty Wisdom = new SimpleIntegerProperty(10);
		SimpleIntegerProperty WisdomMod = new SimpleIntegerProperty(0);
		WisdomMod.bind(Wisdom.subtract(10).divide(2));
		TextField Wis = new TextField(((Integer)10).toString());
		Text wis = new Text(" Bonus: 0");
		Wis.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,2}([\\.]\\d{0,0})?")) {
					Wis.setText(oldValue);
				}
				else if (newValue.length() > 0){
					Wisdom.set(Integer.parseInt(newValue));
					wis.setText(" Bonus: " + ((Integer)((Wisdom.intValue() - 10) / 2)).toString()+ "\t");
				} else {
					wis.setText(" Bonus:\t" );
				}
			}
		});

		SimpleIntegerProperty Charisma = new SimpleIntegerProperty(10);
		SimpleIntegerProperty CharismaMod = new SimpleIntegerProperty(0);
		CharismaMod.bind(Charisma.subtract(10).divide(2));
		TextField Cha = new TextField(((Integer)10).toString());
		Text cha = new Text(" Bonus: 0");
		Cha.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,2}([\\.]\\d{0,0})?")) {
					Cha.setText(oldValue);
				}
				else if (newValue.length() > 0){
					Charisma.set(Integer.parseInt(newValue));
					cha.setText(" Bonus: " + ((Integer)((Charisma.intValue() - 10) / 2)).toString() + "\t");
				} else {
					cha.setText(" Bonus:\t");
				}
			}
		});
		TextField name = new TextField();
		TextField race = new TextField();
		stage.titleProperty().bind(name.textProperty());
		TextField playerClass = new TextField();
		TextField level = new TextField("1");

		SimpleIntegerProperty Level = new SimpleIntegerProperty(1);
		SimpleIntegerProperty ProfBonus = new SimpleIntegerProperty(2);
		Text profBonus = new Text("+2");

		level.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,2}([\\.]\\d{0,0})?")) {
					level.setText(oldValue);
				}
				else if (newValue.length() > 0){
					int temp =Integer.parseInt(newValue);
					Level.set(temp);
					temp = (int) (1+ Math.ceil(((float)temp)/4));
					ProfBonus.set(temp);
					profBonus.setText("+" + String.valueOf(temp));

				}
				else {
					Level.set(0);
					ProfBonus.set(2);
					profBonus.setText("+2");
				}
			}
		});
		Str.setPrefWidth(35);
		Dex.setPrefWidth(35);
		Con.setPrefWidth(35);
		Int.setPrefWidth(35);
		Wis.setPrefWidth(35);
		Cha.setPrefWidth(35);
		level.setPrefWidth(35);
		profBonus.prefWidth(35);
		TextField gender = new TextField();
		TextField background = new TextField();
		TextField speed = new TextField();
		speed.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,3}([\\.]\\d{0,0})?")) {
					speed.setText(oldValue);
				}
			}
		});
		speed.setPrefWidth(50);
		ComboBox<String> alignment = new ComboBox<>();
		alignment.getItems().addAll("Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil");
		Main.pane.getChildren().add(new FlowPane(
				new HBox(new Text("Name: "), name),
				new HBox(new Text("Class: "), playerClass),
				new HBox(new Text("Background: "), background),
				new HBox(new Text("Alignment: "), alignment),
				new HBox(new Text("Gender: "), gender),
				new HBox(new Text("Race: "), race),
				new HBox(new Text("Speed: "), speed),
				new HBox(new Text("Level: "), level),
				new HBox(new Text(" Proficiency Bonus: "),profBonus)
		));
		TextField hp = new TextField();
		hp.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,3}([\\.]\\d{0,0})?")) {
					hp.setText(oldValue);
				}
			}
		});
		hp.setPrefWidth(50);
		TextField currentHP = new TextField();

		currentHP.setPrefWidth(50);
		TextField tempHP = new TextField();
		tempHP.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,3}([\\.]\\d{0,0})?")) {
					tempHP.setText(oldValue);
				}
			}
		});
		tempHP.setPrefWidth(50);
		RadioButton pass1 = new RadioButton();
		RadioButton pass2 = new RadioButton();
		RadioButton pass3 = new RadioButton();
		RadioButton fail1 = new RadioButton();
		RadioButton fail2 = new RadioButton();
		RadioButton fail3 = new RadioButton();
		HBox deathSaves = new HBox(new Text("\tSTABLE "), pass3,pass2,pass1, new Text(" Death Saving Throws "),fail1,fail2,fail3, new Text(" DEAD"));
		currentHP.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,3}([\\.]\\d{0,0})?")) {
					currentHP.setText(oldValue);
				}else if (newValue.compareTo("0") <= 0){deathSaves.setVisible(true);}
				else {
					deathSaves.setVisible(false);
					pass1.setSelected(false);
					pass2.setSelected(false);
					pass3.setSelected(false);
					fail1.setSelected(false);
					fail2.setSelected(false);
					fail3.setSelected(false);
				}
			}
		});
		Main.pane.getChildren().addAll(new FlowPane(
			new HBox(new Text("Max Hit Points: "), hp),
			new HBox(new Text("Current Hit Points: "), currentHP),
			new HBox(new Text("Temporary Hit Points: "), tempHP)
		), deathSaves);

		RadioButton strSave = new RadioButton("Proficient? Bonus:");
		RadioButton dexSave = new RadioButton("Proficient? Bonus:");
		RadioButton conSave = new RadioButton("Proficient? Bonus:");
		RadioButton intSave = new RadioButton("Proficient? Bonus:");
		RadioButton wisSave = new RadioButton("Proficient? Bonus:");
		RadioButton chaSave = new RadioButton("Proficient? Bonus:");
		Text strSaveMod = new Text("0");
		Text dexSaveMod = new Text("0");
		Text conSaveMod = new Text("0");
		Text intSaveMod = new Text("0");
		Text wisSaveMod = new Text("0");
		Text chaSaveMod = new Text("0");
		strSaveMod.textProperty().bind(Bindings.when(strSave.selectedProperty()).then(ProfBonus.add(StrengthMod).asString()).otherwise(StrengthMod.asString()));
		dexSaveMod.textProperty().bind(Bindings.when(dexSave.selectedProperty()).then(ProfBonus.add(DexterityMod).asString()).otherwise(DexterityMod.asString()));
		conSaveMod.textProperty().bind(Bindings.when(conSave.selectedProperty()).then(ProfBonus.add(ConstitutionMod).asString()).otherwise(ConstitutionMod.asString()));
		intSaveMod.textProperty().bind(Bindings.when(intSave.selectedProperty()).then(ProfBonus.add(IntelligenceMod).asString()).otherwise(IntelligenceMod.asString()));
		wisSaveMod.textProperty().bind(Bindings.when(wisSave.selectedProperty()).then(ProfBonus.add(WisdomMod).asString()).otherwise(WisdomMod.asString()));
		chaSaveMod.textProperty().bind(Bindings.when(chaSave.selectedProperty()).then(ProfBonus.add(CharismaMod).asString()).otherwise(CharismaMod.asString()));
		Main.pane.getChildren().add(new FlowPane(new Text("Strength:\t\t"), Str, str, new Text("\tSaving Throw: "), strSave, strSaveMod));
		Main.pane.getChildren().add(new FlowPane(new Text("Dexterity:\t\t"), Dex, dex, new Text("\tSaving Throw: "), dexSave, dexSaveMod));
		Main.pane.getChildren().add(new FlowPane(new Text("Constitution:\t"), Con, con, new Text("\tSaving Throw: "), conSave, conSaveMod));
		Main.pane.getChildren().add(new FlowPane(new Text("Intelligence:\t"), Int, intt, new Text("\tSaving Throw: "), intSave, intSaveMod));
		Main.pane.getChildren().add(new FlowPane(new Text("Wisdom:\t\t"), Wis, wis, new Text("\tSaving Throw: "), wisSave, wisSaveMod));
		Main.pane.getChildren().add(new FlowPane(new Text("Charisma:\t\t"), Cha, cha, new Text("\tSaving Throw: "), chaSave, chaSaveMod));
		TextArea languageProficiencies = new TextArea();
		languageProficiencies.prefWidthProperty().bind(stage.widthProperty());
		languageProficiencies.setWrapText(true);
		languageProficiencies.textProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				Text heightMan = new Text(newValue.toString());
				heightMan.setWrappingWidth(languageProficiencies.getWidth());
				languageProficiencies.setPrefHeight(heightMan.getLayoutBounds().getHeight() * 9 / 8);
			}
		});
		languageProficiencies.setPrefHeight(0);
		TextArea weaponProficiencies = new TextArea();
		weaponProficiencies.prefWidthProperty().bind(stage.widthProperty());
		weaponProficiencies.setWrapText(true);
		weaponProficiencies.textProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				Text heightMan = new Text(newValue.toString());
				heightMan.setWrappingWidth(weaponProficiencies.getWidth());
				weaponProficiencies.setPrefHeight(heightMan.getLayoutBounds().getHeight() * 9 / 8);
			}
		});
		weaponProficiencies.setPrefHeight(0);
		TextArea armorProficiencies = new TextArea();
		armorProficiencies.prefWidthProperty().bind(stage.widthProperty());
		armorProficiencies.setWrapText(true);
		armorProficiencies.textProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				Text heightMan = new Text(newValue.toString());
				heightMan.setWrappingWidth(armorProficiencies.getWidth());
				armorProficiencies.setPrefHeight(heightMan.getLayoutBounds().getHeight() * 9 / 8);
			}
		});
		armorProficiencies.setPrefHeight(0);
		TextArea toolProficiencies = new TextArea();
		toolProficiencies.prefWidthProperty().bind(stage.widthProperty());
		toolProficiencies.setWrapText(true);
		toolProficiencies.textProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				Text heightMan = new Text(newValue.toString());
				heightMan.setWrappingWidth(toolProficiencies.getWidth());
				toolProficiencies.setPrefHeight(heightMan.getLayoutBounds().getHeight() * 9 / 8);
			}
		});
		toolProficiencies.setPrefHeight(0);
		Main.pane.getChildren().add(new FlowPane(new Text("Languages"), languageProficiencies));
		Main.pane.getChildren().add(new FlowPane(new Text("Weapon Proficiencies"),weaponProficiencies));
		Main.pane.getChildren().add(new FlowPane(new Text("Armor Proficiencies"), armorProficiencies));
		Main.pane.getChildren().add(new FlowPane(new Text("Tool Proficiencies"), toolProficiencies));
		Main.fire();
		//</editor-fold>

		//<editor-fold desc="Skills setup">
		Skills.pane.setSpacing(5);
		Skill acrobatics = new Skill();
		acrobatics.bonus.bind(
				Bindings.when(acrobatics.none.selectedProperty()).then(DexterityMod).otherwise(
						Bindings.when(acrobatics.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(DexterityMod)).otherwise(
								Bindings.when(acrobatics.full.selectedProperty()).then(ProfBonus.add(DexterityMod)).otherwise(ProfBonus.multiply(2).add(DexterityMod))
						)));

		Text Acrobatics = new Text();
		Acrobatics.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(acrobatics.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Acrobatics:\t\t"),acrobatics.none,acrobatics.half,acrobatics.full,acrobatics.twice,Acrobatics));


		Skill animal_handling = new Skill();
		animal_handling.bonus.bind(
				Bindings.when(animal_handling.none.selectedProperty()).then(WisdomMod).otherwise(
						Bindings.when(animal_handling.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(WisdomMod)).otherwise(
								Bindings.when(animal_handling.full.selectedProperty()).then(ProfBonus.add(WisdomMod)).otherwise(ProfBonus.multiply(2).add(WisdomMod))
						)));

		Text Animal_Handling = new Text();
		Animal_Handling.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(animal_handling.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Animal_Handling:\t"),animal_handling.none,animal_handling.half,animal_handling.full,animal_handling.twice,Animal_Handling));


		Skill arcana = new Skill();
		arcana.bonus.bind(
				Bindings.when(arcana.none.selectedProperty()).then(IntelligenceMod).otherwise(
						Bindings.when(arcana.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(IntelligenceMod)).otherwise(
								Bindings.when(arcana.full.selectedProperty()).then(ProfBonus.add(IntelligenceMod)).otherwise(ProfBonus.multiply(2).add(IntelligenceMod))
						)));

		Text Arcana = new Text();
		Arcana.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(arcana.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Arcana:\t\t\t"),arcana.none,arcana.half,arcana.full,arcana.twice,Arcana));


		Skill athletics = new Skill();
		athletics.bonus.bind(
				Bindings.when(athletics.none.selectedProperty()).then(StrengthMod).otherwise(
						Bindings.when(athletics.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(StrengthMod)).otherwise(
								Bindings.when(athletics.full.selectedProperty()).then(ProfBonus.add(StrengthMod)).otherwise(ProfBonus.multiply(2).add(StrengthMod))
						)));

		Text Athletics = new Text();
		Athletics.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(athletics.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Athletics:\t\t\t"),athletics.none,athletics.half,athletics.full,athletics.twice,Athletics));


		Skill deception = new Skill();
		deception.bonus.bind(
				Bindings.when(deception.none.selectedProperty()).then(CharismaMod).otherwise(
						Bindings.when(deception.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(CharismaMod)).otherwise(
								Bindings.when(deception.full.selectedProperty()).then(ProfBonus.add(CharismaMod)).otherwise(ProfBonus.multiply(2).add(CharismaMod))
						)));

		Text Deception = new Text();
		Deception.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(deception.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Deception:\t\t"),deception.none,deception.half,deception.full,deception.twice,Deception));


		Skill history = new Skill();
		history.bonus.bind(
				Bindings.when(history.none.selectedProperty()).then(IntelligenceMod).otherwise(
						Bindings.when(history.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(IntelligenceMod)).otherwise(
								Bindings.when(history.full.selectedProperty()).then(ProfBonus.add(IntelligenceMod)).otherwise(ProfBonus.multiply(2).add(IntelligenceMod))
						)));

		Text History = new Text();
		History.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(history.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("History:\t\t\t"),history.none,history.half,history.full,history.twice,History));


		Skill insight = new Skill();
		insight.bonus.bind(
				Bindings.when(insight.none.selectedProperty()).then(WisdomMod).otherwise(
						Bindings.when(insight.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(WisdomMod)).otherwise(
								Bindings.when(insight.full.selectedProperty()).then(ProfBonus.add(WisdomMod)).otherwise(ProfBonus.multiply(2).add(WisdomMod))
						)));

		Text Insight = new Text();
		Insight.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(insight.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Insight:\t\t\t"),insight.none,insight.half,insight.full,insight.twice,Insight));


		Skill intimidation = new Skill();
		intimidation.bonus.bind(
				Bindings.when(intimidation.none.selectedProperty()).then(CharismaMod).otherwise(
						Bindings.when(intimidation.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(CharismaMod)).otherwise(
								Bindings.when(intimidation.full.selectedProperty()).then(ProfBonus.add(CharismaMod)).otherwise(ProfBonus.multiply(2).add(CharismaMod))
						)));

		Text Intimidation = new Text();
		Intimidation.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(intimidation.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Intimidation:\t\t"),intimidation.none,intimidation.half,intimidation.full,intimidation.twice,Intimidation));


		Skill investigation = new Skill();
		investigation.bonus.bind(
				Bindings.when(investigation.none.selectedProperty()).then(IntelligenceMod).otherwise(
						Bindings.when(investigation.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(IntelligenceMod)).otherwise(
								Bindings.when(investigation.full.selectedProperty()).then(ProfBonus.add(IntelligenceMod)).otherwise(ProfBonus.multiply(2).add(IntelligenceMod))
						)));

		Text Investigation = new Text();
		Investigation.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(investigation.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Investigation:\t\t"),investigation.none,investigation.half,investigation.full,investigation.twice,Investigation));


		Skill medicine = new Skill();
		medicine.bonus.bind(
				Bindings.when(medicine.none.selectedProperty()).then(WisdomMod).otherwise(
						Bindings.when(medicine.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(WisdomMod)).otherwise(
								Bindings.when(medicine.full.selectedProperty()).then(ProfBonus.add(WisdomMod)).otherwise(ProfBonus.multiply(2).add(WisdomMod))
						)));

		Text Medicine = new Text();
		Medicine.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(medicine.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Medicine:\t\t\t"),medicine.none,medicine.half,medicine.full,medicine.twice,Medicine));


		Skill nature = new Skill();
		nature.bonus.bind(
				Bindings.when(nature.none.selectedProperty()).then(IntelligenceMod).otherwise(
						Bindings.when(nature.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(IntelligenceMod)).otherwise(
								Bindings.when(nature.full.selectedProperty()).then(ProfBonus.add(IntelligenceMod)).otherwise(ProfBonus.multiply(2).add(IntelligenceMod))
						)));

		Text Nature = new Text();
		Nature.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(nature.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Nature:\t\t\t"),nature.none,nature.half,nature.full,nature.twice,Nature));


		Skill perception = new Skill();
		perception.bonus.bind(
				Bindings.when(perception.none.selectedProperty()).then(WisdomMod).otherwise(
						Bindings.when(perception.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(WisdomMod)).otherwise(
								Bindings.when(perception.full.selectedProperty()).then(ProfBonus.add(WisdomMod)).otherwise(ProfBonus.multiply(2).add(WisdomMod))
						)));

		Text Perception = new Text();
		Perception.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(perception.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Perception:\t\t"),perception.none,perception.half,perception.full,perception.twice,Perception));


		Skill performance = new Skill();
		performance.bonus.bind(
				Bindings.when(performance.none.selectedProperty()).then(CharismaMod).otherwise(
						Bindings.when(performance.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(CharismaMod)).otherwise(
								Bindings.when(performance.full.selectedProperty()).then(ProfBonus.add(CharismaMod)).otherwise(ProfBonus.multiply(2).add(CharismaMod))
						)));

		Text Performance = new Text();
		Performance.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(performance.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Performance:\t\t"),performance.none,performance.half,performance.full,performance.twice,Performance));


		Skill persuasion  = new Skill();
		persuasion .bonus.bind(
				Bindings.when(persuasion .none.selectedProperty()).then(CharismaMod).otherwise(
						Bindings.when(persuasion .half.selectedProperty()).then(ProfBonus.multiply(0.5).add(CharismaMod)).otherwise(
								Bindings.when(persuasion .full.selectedProperty()).then(ProfBonus.add(CharismaMod)).otherwise(ProfBonus.multiply(2).add(CharismaMod))
						)));

		Text Persuasion  = new Text();
		Persuasion .textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(persuasion .bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Persuasion :\t\t"),persuasion .none,persuasion .half,persuasion .full,persuasion .twice,Persuasion ));


		Skill religion = new Skill();
		religion.bonus.bind(
				Bindings.when(religion.none.selectedProperty()).then(IntelligenceMod).otherwise(
						Bindings.when(religion.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(IntelligenceMod)).otherwise(
								Bindings.when(religion.full.selectedProperty()).then(ProfBonus.add(IntelligenceMod)).otherwise(ProfBonus.multiply(2).add(IntelligenceMod))
						)));

		Text Religion = new Text();
		Religion.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(religion.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Religion:\t\t\t"),religion.none,religion.half,religion.full,religion.twice,Religion));


		Skill sleight_of_hand = new Skill();
		sleight_of_hand.bonus.bind(
				Bindings.when(sleight_of_hand.none.selectedProperty()).then(DexterityMod).otherwise(
						Bindings.when(sleight_of_hand.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(DexterityMod)).otherwise(
								Bindings.when(sleight_of_hand.full.selectedProperty()).then(ProfBonus.add(DexterityMod)).otherwise(ProfBonus.multiply(2).add(DexterityMod))
						)));

		Text Sleight_of_Hand = new Text();
		Sleight_of_Hand.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(sleight_of_hand.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Sleight_of_Hand:\t"),sleight_of_hand.none,sleight_of_hand.half,sleight_of_hand.full,sleight_of_hand.twice,Sleight_of_Hand));


		Skill stealth = new Skill();
		stealth.bonus.bind(
				Bindings.when(stealth.none.selectedProperty()).then(DexterityMod).otherwise(
						Bindings.when(stealth.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(DexterityMod)).otherwise(
								Bindings.when(stealth.full.selectedProperty()).then(ProfBonus.add(DexterityMod)).otherwise(ProfBonus.multiply(2).add(DexterityMod))
						)));

		Text Stealth = new Text();
		Stealth.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(stealth.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Stealth:\t\t\t"),stealth.none,stealth.half,stealth.full,stealth.twice,Stealth));


		Skill survival = new Skill();
		survival.bonus.bind(
				Bindings.when(survival.none.selectedProperty()).then(WisdomMod).otherwise(
						Bindings.when(survival.half.selectedProperty()).then(ProfBonus.multiply(0.5).add(WisdomMod)).otherwise(
								Bindings.when(survival.full.selectedProperty()).then(ProfBonus.add(WisdomMod)).otherwise(ProfBonus.multiply(2).add(WisdomMod))
						)));

		Text Survival = new Text();
		Survival.textProperty().bind(new SimpleStringProperty("Bonus:\t").concat(survival.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("Survival:\t\t\t"),survival.none,survival.half,survival.full,survival.twice,Survival));
		//</editor-fold>

		//<editor-fold desc="Feature Setup">
		Button newFeature = new Button("Add Feature");
		newFeature.setOnAction(e -> {
			TextArea itemDescription = new TextArea();
			itemDescription.prefWidthProperty().bind(Features.pane.widthProperty());
			itemDescription.setWrapText(true);
			itemDescription.textProperty().addListener(new ChangeListener() {
				@Override
				public void changed(ObservableValue observable, Object oldValue, Object newValue) {
					Text heightMan = new Text(newValue.toString());
					heightMan.setWrappingWidth(itemDescription.getWidth());
					itemDescription.setPrefHeight(heightMan.getLayoutBounds().getHeight() * 9 / 8);
				}
			});
			itemDescription.setPrefHeight(0);
			TextField featureLevel = new TextField("0");
			featureLevel.setPrefWidth(35);
			featureLevel.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					if (!newValue.matches("\\d{0,2}([\\.]\\d{0,0})?")) {
						featureLevel.setText(oldValue);
					}
				}
			});
			Button remove = new Button("Delete Feature");
			remove.setOnAction(x -> {
				((VBox)((Node)x.getSource()).getParent().getParent()).getChildren().remove(((Node)x.getSource()).getParent());
				Features.requestFocus();
			});
			Features.pane.getChildren().add(new FlowPane( new HBox(new Text("Name: "), new TextField()), new HBox(new Text("Level Gained: "), featureLevel), new HBox(new Text("Source: "), new TextField()), remove, itemDescription));
		});
		Button sortFeature = new Button("Sort Features");
		sortFeature.setOnAction(e -> {
			if (Features.pane.getChildren().size() <= 2) {return;}
			Node temp = Features.pane.getChildren().get(0);
			Features.pane.getChildren().remove(0);

			ObservableList<Node> copy = FXCollections.observableArrayList(Features.pane.getChildren());
			copy.sort((a, b) -> {
				int result = Integer.compare(Integer.parseInt(((TextField)((HBox)((FlowPane)a).getChildren().get(0)).getChildren().get(1)).getText()), Integer.parseInt(((TextField)((HBox)((FlowPane)b).getChildren().get(0)).getChildren().get(1)).getText()));
				if (result != 0) {return result;}
				return ((TextField)((HBox)((FlowPane)a).getChildren().get(0)).getChildren().get(1)).getText().compareToIgnoreCase(((TextField)((HBox)((FlowPane)b).getChildren().get(0)).getChildren().get(1)).getText());
			});
			copy.add(0, temp);
			Features.pane.getChildren().clear();
			Features.pane.getChildren().addAll(copy);
		});
		Features.pane.getChildren().add(new FlowPane(newFeature, sortFeature));
		//</editor-fold>

		//<editor-fold desc="Spells Setup">
		Button newSpell = new Button("Add a new Spell");
		newSpell.setOnAction(e -> {
			Button removeSpell = new Button("Remove Spell");
			removeSpell.setOnAction(x -> {
				((VBox)((Node)x.getSource()).getParent().getParent()).getChildren().remove(((Node)x.getSource()).getParent());
				Features.requestFocus();
			});
			TextField spellLevel = new TextField("0");
			spellLevel.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					if (!newValue.matches("\\d?([\\.]\\d{0,0})?")) {
						spellLevel.setText(oldValue);
					}
				}
			});
			spellLevel.setPrefWidth(25);
			ComboBox<String> spellSchool = new ComboBox<>();
			spellSchool.getItems().addAll("Abjuration", "Conjuration", "Divination", "Enchantment", "Evocation", "Illusion", "Necromancy", "Transmutation");
			TextField spellName = new TextField();
			TextField spellTime = new TextField();
			TextField spellRange = new TextField();
			TextField spellComponents = new TextField();
			TextField spellDuration = new TextField();
			TextArea spellDescription = new TextArea();
			spellDescription.prefWidthProperty().bind(stage.widthProperty());
			spellDescription.setWrapText(true);
			spellDescription.textProperty().addListener(new ChangeListener() {
				@Override
				public void changed(ObservableValue observable, Object oldValue, Object newValue) {
					Text heightMan = new Text(newValue.toString());
					heightMan.setWrappingWidth(spellDescription.getWidth());
					spellDescription.setPrefHeight(heightMan.getLayoutBounds().getHeight() * 9 / 8);
				}
			});
			spellDescription.setPrefHeight(0);
			Spells.pane.getChildren().addAll(new FlowPane(new HBox(new Text("Name: "), spellName), new HBox(new Text("Level: "), spellLevel,
					spellSchool, new RadioButton("Ritual ")), new HBox(new Text("Casting Time: "), spellTime), new HBox(new Text("Range: "), spellRange),
					new HBox(new Text("Components: "), spellComponents), new HBox(new Text("Duration: "), spellDuration), removeSpell, spellDescription));
		});
		Button sortSpell = new Button("Sort Spells (level then name)");
		sortSpell.setOnAction(e -> {
			if(Spells.pane.getChildren().size() <= 3){return;}
			Node temp = Spells.pane.getChildren().get(0);
			Node temp0 = Spells.pane.getChildren().get(1);
			Spells.pane.getChildren().remove(0);
			Spells.pane.getChildren().remove(0);
			ObservableList<Node> copy = FXCollections.observableArrayList(Spells.pane.getChildren());

			copy.sort((a, b) -> {
				int result = ((TextField)((HBox)((FlowPane)a).getChildren().get(1)).getChildren().get(1)).getText().compareTo(((TextField)((HBox)((FlowPane)b).getChildren().get(1)).getChildren().get(1)).getText());
				if (result != 0){
					return result;
				}
				else{
					return ((TextField)((HBox)((FlowPane)a).getChildren().get(0)).getChildren().get(1)).getText().compareToIgnoreCase(((TextField)((HBox)((FlowPane)b).getChildren().get(0)).getChildren().get(1)).getText());
				}
			});
			copy.add(0, temp);
			copy.add(1, temp0);
			Spells.pane.getChildren().clear();
			Spells.pane.getChildren().addAll(copy);

		});
		TextField casterClass = new TextField();
		ComboBox<String> casterMod = new ComboBox<>();
		casterMod.getItems().addAll("Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma");
		Text casterAttack = new Text();
		casterAttack.textProperty().bind(
				Bindings.when(casterMod.valueProperty().isEqualTo("Strength")).then(StrengthMod.add(ProfBonus)).otherwise(
				Bindings.when(casterMod.valueProperty().isEqualTo("Dexterity")).then(DexterityMod.add(ProfBonus)).otherwise(
				Bindings.when(casterMod.valueProperty().isEqualTo("Constitution")).then(ConstitutionMod.add(ProfBonus)).otherwise(
				Bindings.when(casterMod.valueProperty().isEqualTo("Intelligence")).then(IntelligenceMod.add(ProfBonus)).otherwise(
				Bindings.when(casterMod.valueProperty().isEqualTo("Wisdom")).then(WisdomMod.add(ProfBonus)).otherwise(
				Bindings.when(casterMod.valueProperty().isEqualTo("Charisma")).then(CharismaMod.add(ProfBonus)).otherwise(
						ProfBonus
				)))))).asString());
		Text casterDC = new Text();
		casterDC.textProperty().bind(
				Bindings.when(casterMod.valueProperty().isEqualTo("Strength")).then(StrengthMod.add(ProfBonus)).otherwise(
				Bindings.when(casterMod.valueProperty().isEqualTo("Dexterity")).then(DexterityMod.add(ProfBonus)).otherwise(
				Bindings.when(casterMod.valueProperty().isEqualTo("Constitution")).then(ConstitutionMod.add(ProfBonus)).otherwise(
				Bindings.when(casterMod.valueProperty().isEqualTo("Intelligence")).then(IntelligenceMod.add(ProfBonus)).otherwise(
				Bindings.when(casterMod.valueProperty().isEqualTo("Wisdom")).then(WisdomMod.add(ProfBonus)).otherwise(
				Bindings.when(casterMod.valueProperty().isEqualTo("Charisma")).then(CharismaMod.add(ProfBonus)).otherwise(
				ProfBonus
				)))))).add(8).asString());
		Spells.pane.getChildren().add(new FlowPane(newSpell, sortSpell));
		Spells.pane.getChildren().add(new FlowPane(new Text("Spellcasting Class: "), casterClass, new Text(" Spellcasting Modifier: "), casterMod, new Text(" Spell save DC: "), casterDC, new Text(" Spell attack bonus: "), casterAttack));
		//</editor-fold>

		//<editor-fold desc="Resource Setup">
		Button addResource = new Button("Add Resource");
		Button sortResources = new Button("Sort Resources");
		Button shortRest = new Button("Take Short Rest");
		Button longRest = new Button("Take Long Rest");
		Resources.pane.getChildren().add(new FlowPane(addResource, sortResources, shortRest, longRest));
		addResource.setOnAction(e -> {
			TextField resourceName = new TextField();
			TextField resourceUses = new TextField("1");
			SimpleDoubleProperty MaxUses = new SimpleDoubleProperty(1);
			SimpleDoubleProperty Used = new SimpleDoubleProperty(0);

			resourceUses.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					if (!newValue.matches("\\d{0,3}([\\.]\\d{0,0})?")) {
						resourceUses.setText(oldValue);
					}else if (newValue.length() > 0){
						MaxUses.setValue(Integer.parseInt(newValue));
						Used.setValue(Double.min(MaxUses.getValue(), Used.getValue()));
					}
				}
			});
			resourceUses.setPrefWidth(45);
			ProgressBar progressBar = new ProgressBar(0.5);

			progressBar.progressProperty().bind(Bindings.when(MaxUses.greaterThan(0)).then(MaxUses.subtract(Used).divide(MaxUses)).otherwise(0));
			Text remaining = new Text();
			remaining.textProperty().bind(MaxUses.subtract(Used).asString(" %.0f "));
			Button add = new Button("+");
			Button minus = new Button("-");
			minus.setOnAction(x -> Used.setValue(Double.min(Used.getValue() + 1, MaxUses.getValue())));
			add.setOnAction(x -> Used.setValue(Double.max(Used.getValue() - 1, 0)));
			Button reset = new Button("reset");
			reset.setOnAction(x -> Used.setValue(0));
			Button deleteResource = new Button("Delete Resource");
			deleteResource.setOnAction(x -> {
				((VBox)((Node)x.getSource()).getParent().getParent()).getChildren().remove(((Node)x.getSource()).getParent());
				Resources.requestFocus();
			});
			ComboBox<String> resetTime = new ComboBox<>();
			resetTime.getItems().addAll("Short Rest", "Long Rest", "Manual");
			resetTime.setValue("Manual");
			Resources.pane.getChildren().add(new FlowPane(
					new HBox(new Text("Name: "), resourceName),
					new HBox(new Text("Total Uses"), resourceUses),
					new HBox(remaining, minus, add),
					new HBox(progressBar, reset),
					resetTime,
					deleteResource
			));
		});
		sortResources.setOnAction(e -> {
			if (Resources.pane.getChildren().size() <= 2) {return;}
			Node temp = Resources.pane.getChildren().get(0);
			Resources.pane.getChildren().remove(0);

			ObservableList<Node> copy = FXCollections.observableArrayList(Resources.pane.getChildren());
			copy.sort((a, b) -> {
				return ((TextField)((HBox)((FlowPane)a).getChildren().get(0)).getChildren().get(1)).getText().compareToIgnoreCase(((TextField)((HBox)((FlowPane)b).getChildren().get(0)).getChildren().get(1)).getText());
			});
			copy.add(0, temp);
			Resources.pane.getChildren().clear();
			Resources.pane.getChildren().addAll(copy);
		});
		shortRest.setOnAction(e -> {
			ObservableList<Node> copy = FXCollections.observableArrayList(Resources.pane.getChildren());
			copy.remove(0);
			while(copy.size() > 0){
				FlowPane item = (FlowPane) copy.get(0);
				if (((ComboBox<String>)item.getChildren().get(4)).getValue().equals("Short Rest")){
					((Button)((HBox)item.getChildren().get(3)).getChildren().get(1)).fire();
				}
				copy.remove(0);
			}
		});
		longRest.setOnAction(e -> {
			ObservableList<Node> copy = FXCollections.observableArrayList(Resources.pane.getChildren());
			copy.remove(0);
			while(copy.size() > 0){
				FlowPane item = (FlowPane) copy.get(0);
				if (((ComboBox<String>)item.getChildren().get(4)).getValue().equals("Long Rest")){
					((Button)((HBox)item.getChildren().get(3)).getChildren().get(1)).fire();
				}
				copy.remove(0);
			}
			shortRest.fire();
		});
		//</editor-fold>

		//<editor-fold desc="Equipment Setup">
		VBox Weapons = new VBox(5,new Text("Weapons: "));
		VBox Armor = new VBox(5,new Text("Armor:"));
		Weapons.setPadding(new Insets(0,0,5,0));
		Armor.setPadding(new Insets(0,0,5,0));
		TextField Initiative = new TextField("0");
		Initiative.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,2}([\\.]\\d{0,2})?")) {
					Initiative.setText(oldValue);
				}
			}
		});
		TextField armorClass = new TextField("10");
		armorClass.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,2}([\\.]\\d{0,0})?")) {
					armorClass.setText(oldValue);
				}
			}
		});
		Initiative.setPrefWidth(35);
		armorClass.setPrefWidth(35);
		Button weapon = new Button("Add Weapon");
		weapon.setOnAction(e -> {

			Button remove = new Button("Delete Weapon");
			remove.setOnAction(x -> {
				((VBox)((Node)x.getSource()).getParent().getParent()).getChildren().remove(((Node)x.getSource()).getParent());
				Equipment.requestFocus();
			});
			Weapons.getChildren().add( new FlowPane( new HBox(new Text("Name: "), new TextField()), new HBox(new Text("Attack: "), new TextField()),new HBox(new Text("Damage: "), new TextField()), new HBox(new Text("Value: "), new TextField()), new HBox(new Text("Weight"), new TextField()),new HBox(new Text("Properties: "), new TextField()), remove));
		});

		Button armor = new Button("Add Armor");
		armor.setOnAction(e -> {

			Button remove = new Button("Delete Armor");
			remove.setOnAction(x -> {
				((VBox)((Node)x.getSource()).getParent().getParent()).getChildren().remove(((Node)x.getSource()).getParent());
				Equipment.requestFocus();
			});
			ComboBox<String> ArmorType = new ComboBox<>();
			ArmorType.getItems().addAll("Light", "Medium", "Heavy", "Shield");
			Armor.getChildren().add(new FlowPane( new HBox(new Text("Name: "), new TextField()), new HBox(new Text("Armor Class: "), new TextField()),new HBox(new Text("Type: "), ArmorType), new HBox(new Text("Value: "), new TextField()), new HBox(new Text("Weight"), new TextField()), remove));
		});

		Equipment.pane.getChildren().addAll(new FlowPane(new HBox(new Text("Initiative: "), Initiative), new HBox(new Text(" Armor Class: "), armorClass), weapon, armor), Weapons, Armor);
		//</editor-fold>

		//<editor-fold desc="Inventory Setup">
		Button newItem = new Button("Add Item");
		newItem.setOnAction(e -> {
			TextArea itemDescription = new TextArea();
			itemDescription.prefWidthProperty().bind(Inventory.pane.widthProperty());
			itemDescription.setWrapText(true);
			itemDescription.textProperty().addListener(new ChangeListener() {
				@Override
				public void changed(ObservableValue observable, Object oldValue, Object newValue) {
					Text heightMan = new Text(newValue.toString());
					heightMan.setWrappingWidth(itemDescription.getWidth());
					itemDescription.setPrefHeight(heightMan.getLayoutBounds().getHeight() * 9 / 8);
				}
			});
			itemDescription.setPrefHeight(0);
			Button remove = new Button("Delete Item");
			remove.setOnAction(x -> {
				((VBox)((Node)x.getSource()).getParent().getParent()).getChildren().remove(((Node)x.getSource()).getParent());
				Inventory.requestFocus();
			});
			Inventory.pane.getChildren().add(new FlowPane( new HBox(new Text("Name: "), new TextField()), new HBox(new Text("Value: "), new TextField()), new HBox(new Text("Weight"), new TextField()), remove, itemDescription));
		});
		Button sortItem = new Button ("Sort Inventory");
		sortItem.setOnAction(e -> {
			if (Inventory.pane.getChildren().size() <= 3) {return;}
			Node temp0 = Inventory.pane.getChildren().get(0);
			Node temp1 = Inventory.pane.getChildren().get(1);
			Inventory.pane.getChildren().remove(0);
			Inventory.pane.getChildren().remove(0);
			ObservableList<Node> copy = FXCollections.observableArrayList(Inventory.pane.getChildren());
			copy.sort((a, b) -> {
				return ((TextField)((HBox)((FlowPane)a).getChildren().get(0)).getChildren().get(1)).getText().compareToIgnoreCase(((TextField)((HBox)((FlowPane)b).getChildren().get(0)).getChildren().get(1)).getText());
			});
			copy.add(0, temp0);
			copy.add(1, temp1);
			Inventory.pane.getChildren().clear();
			Inventory.pane.getChildren().addAll(copy);
		});
		TextField Copper = new TextField();
		TextField Silver = new TextField();
		TextField Electrum = new TextField();
		TextField Gold = new TextField();
		TextField Platinum = new TextField();
		Copper.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,10}([\\.]\\d{0,0})?")) {
					Copper.setText(oldValue);
				}
			}
		});
		Silver.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,10}([\\.]\\d{0,0})?")) {
					Silver.setText(oldValue);
				}
			}
		});
		Electrum.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,10}([\\.]\\d{0,0})?")) {
					Electrum.setText(oldValue);
				}
			}
		});
		Gold.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,10}([\\.]\\d{0,0})?")) {
					Gold.setText(oldValue);
				}
			}
		});
		Platinum.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,10}([\\.]\\d{0,0})?")) {
					Platinum.setText(oldValue);
				}
			}
		});
		Inventory.pane.getChildren().addAll(new FlowPane(new HBox(new Text("Copper: "), Copper), new HBox(new Text(" Silver: "), Silver),
				new HBox(new Text(" Electrum: "), Electrum), new HBox(new Text(" Gold: "), Gold), new HBox(new Text(" Platinum: "), Platinum)
		), new FlowPane(newItem, sortItem));
		//</editor-fold>

		//<editor-fold desc="Notes Setup">
		TextArea notes = new TextArea();
		notes.prefWidthProperty().bind(stage.widthProperty());
		notes.prefHeightProperty().bind(stage.heightProperty());
		Notes.pane.getChildren().add(notes);
		//</editor-fold>

		//<editor-fold desc="Options Setup">
		Options.pane.setPadding(new Insets(200,0,0,0));
		Button save = new Button("Save Character");
		Button load = new Button("Load Character");
		Text message = new Text("");
		Options.pane.getChildren().addAll(save, load,message);
		Options.pane.setSpacing(200);
		Options.pane.setAlignment(Pos.BASELINE_CENTER);
		save.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
			message.setText("");
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileChooser.showSaveDialog(stage)));
				out.writeObject(Str.getText());
				out.writeObject(Dex.getText());
				out.writeObject(Con.getText());
				out.writeObject(Int.getText());
				out.writeObject(Wis.getText());
				out.writeObject(Cha.getText());
				//<editor-fold desc="Write Skills">
				if(acrobatics.none.isSelected()){out.writeObject("0");}
				else if (acrobatics.half.isSelected()){out.writeObject("1");}
				else if (acrobatics.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(animal_handling.none.isSelected()){out.writeObject("0");}
				else if (animal_handling.half.isSelected()){out.writeObject("1");}
				else if (animal_handling.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(arcana.none.isSelected()){out.writeObject("0");}
				else if (arcana.half.isSelected()){out.writeObject("1");}
				else if (arcana.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(athletics.none.isSelected()){out.writeObject("0");}
				else if (athletics.half.isSelected()){out.writeObject("1");}
				else if (athletics.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(deception.none.isSelected()){out.writeObject("0");}
				else if (deception.half.isSelected()){out.writeObject("1");}
				else if (deception.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(history.none.isSelected()){out.writeObject("0");}
				else if (history.half.isSelected()){out.writeObject("1");}
				else if (history.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(insight.none.isSelected()){out.writeObject("0");}
				else if (insight.half.isSelected()){out.writeObject("1");}
				else if (insight.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(intimidation.none.isSelected()){out.writeObject("0");}
				else if (intimidation.half.isSelected()){out.writeObject("1");}
				else if (intimidation.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(investigation.none.isSelected()){out.writeObject("0");}
				else if (investigation.half.isSelected()){out.writeObject("1");}
				else if (investigation.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(medicine.none.isSelected()){out.writeObject("0");}
				else if (medicine.half.isSelected()){out.writeObject("1");}
				else if (medicine.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(nature.none.isSelected()){out.writeObject("0");}
				else if (nature.half.isSelected()){out.writeObject("1");}
				else if (nature.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(perception.none.isSelected()){out.writeObject("0");}
				else if (perception.half.isSelected()){out.writeObject("1");}
				else if (perception.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(performance.none.isSelected()){out.writeObject("0");}
				else if (performance.half.isSelected()){out.writeObject("1");}
				else if (performance.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(persuasion.none.isSelected()){out.writeObject("0");}
				else if (persuasion.half.isSelected()){out.writeObject("1");}
				else if (persuasion.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(religion.none.isSelected()){out.writeObject("0");}
				else if (religion.half.isSelected()){out.writeObject("1");}
				else if (religion.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(sleight_of_hand.none.isSelected()){out.writeObject("0");}
				else if (sleight_of_hand.half.isSelected()){out.writeObject("1");}
				else if (sleight_of_hand.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(stealth.none.isSelected()){out.writeObject("0");}
				else if (stealth.half.isSelected()){out.writeObject("1");}
				else if (stealth.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}

				if(survival.none.isSelected()){out.writeObject("0");}
				else if (survival.half.isSelected()){out.writeObject("1");}
				else if (survival.full.isSelected()){out.writeObject("2");}
				else {out.writeObject("3");}
				//</editor-fold>
				out.writeObject(name.getText());
				out.writeObject(race.getText());
				out.writeObject(playerClass.getText());
				out.writeObject(level.getText());
				if (Features.pane.getChildren().size() > 1){
					ObservableList<Node> copy = FXCollections.observableArrayList(Features.pane.getChildren());
					copy.remove(0);
					while(copy.size() > 0){
						out.writeObject("NotDone");
						FlowPane next = (FlowPane)copy.get(0);
						out.writeObject(((TextField)((HBox)next.getChildren().get(0)).getChildren().get(1)).getText());
						out.writeObject(((TextField)((HBox)next.getChildren().get(1)).getChildren().get(1)).getText());
						out.writeObject(((TextField)((HBox)next.getChildren().get(2)).getChildren().get(1)).getText());
						out.writeObject(((TextArea)next.getChildren().get(4)).getText());
						copy.remove(0);
					}
				}
				out.writeObject("endFeatures");
				out.writeObject(casterClass.getText());
				out.writeObject(casterMod.getValue());
				if (Spells.pane.getChildren().size() > 2){
					ObservableList<Node> copy = FXCollections.observableArrayList(Spells.pane.getChildren());
					copy.remove(0);
					copy.remove(0);
					while(copy.size() > 0){
						out.writeObject("NotDone");
						FlowPane next = (FlowPane)copy.get(0);
						out.writeObject(((TextField)((HBox)next.getChildren().get(0)).getChildren().get(1)).getText());
						out.writeObject(((TextField)((HBox)next.getChildren().get(1)).getChildren().get(1)).getText());
						out.writeObject(((ComboBox<String>)((HBox)next.getChildren().get(1)).getChildren().get(2)).getValue());
						out.writeObject(((RadioButton)((HBox)next.getChildren().get(1)).getChildren().get(3)).isSelected());
						out.writeObject(((TextField)((HBox)next.getChildren().get(2)).getChildren().get(1)).getText());
						out.writeObject(((TextField)((HBox)next.getChildren().get(3)).getChildren().get(1)).getText());
						out.writeObject(((TextField)((HBox)next.getChildren().get(4)).getChildren().get(1)).getText());
						out.writeObject(((TextField)((HBox)next.getChildren().get(5)).getChildren().get(1)).getText());
						out.writeObject(((TextArea)next.getChildren().get(7)).getText());
						copy.remove(0);
					}
				}
				out.writeObject("endSpells");
				out.writeObject(Initiative.getText());
				out.writeObject(armorClass.getText());

				ObservableList<Node> copy = FXCollections.observableArrayList(Weapons.getChildren());
				copy.remove(0);
				while(copy.size() > 0){
					out.writeObject("NotDone");
					FlowPane next = (FlowPane)copy.get(0);
					out.writeObject(((TextField)((HBox)next.getChildren().get(0)).getChildren().get(1)).getText());
					out.writeObject(((TextField)((HBox)next.getChildren().get(1)).getChildren().get(1)).getText());
					out.writeObject(((TextField)((HBox)next.getChildren().get(2)).getChildren().get(1)).getText());
					out.writeObject(((TextField)((HBox)next.getChildren().get(3)).getChildren().get(1)).getText());
					out.writeObject(((TextField)((HBox)next.getChildren().get(4)).getChildren().get(1)).getText());
					out.writeObject(((TextField)((HBox)next.getChildren().get(5)).getChildren().get(1)).getText());
					copy.remove(0);
				}
				out.writeObject("endWeapons");
				copy = FXCollections.observableArrayList(Armor.getChildren());
				copy.remove(0);
				while(copy.size() > 0){
					out.writeObject("NotDone");
					FlowPane next = (FlowPane)copy.get(0);
					out.writeObject(((TextField)((HBox)next.getChildren().get(0)).getChildren().get(1)).getText());
					out.writeObject(((TextField)((HBox)next.getChildren().get(1)).getChildren().get(1)).getText());
					out.writeObject(((ComboBox<String>)((HBox)next.getChildren().get(2)).getChildren().get(1)).getValue());
					out.writeObject(((TextField)((HBox)next.getChildren().get(3)).getChildren().get(1)).getText());
					out.writeObject(((TextField)((HBox)next.getChildren().get(4)).getChildren().get(1)).getText());
					copy.remove(0);
				}
				out.writeObject("endArmor");
				out.writeObject(Copper.getText());
				out.writeObject(Silver.getText());
				out.writeObject(Electrum.getText());
				out.writeObject(Gold.getText());
				out.writeObject(Platinum.getText());
				copy = FXCollections.observableArrayList(Inventory.pane.getChildren());
				copy.remove(0);
				copy.remove(0);
				while(copy.size() > 0){
					out.writeObject("NotDone");
					FlowPane next = (FlowPane)copy.get(0);
					out.writeObject(((TextField)((HBox)next.getChildren().get(0)).getChildren().get(1)).getText());
					out.writeObject(((TextField)((HBox)next.getChildren().get(1)).getChildren().get(1)).getText());
					out.writeObject(((TextField)((HBox)next.getChildren().get(2)).getChildren().get(1)).getText());
					out.writeObject(((TextArea)next.getChildren().get(4)).getText());
					copy.remove(0);
				}
				out.writeObject("endInventory");
				out.writeObject(gender.getText());
				out.writeObject(background.getText());
				out.writeObject(alignment.getValue());
				out.writeObject(speed.getText());
				out.writeObject(hp.getText());
				out.writeObject(currentHP.getText());
				out.writeObject(tempHP.getText());
				out.writeObject(pass1.isSelected());
				out.writeObject(pass2.isSelected());
				out.writeObject(pass3.isSelected());
				out.writeObject(fail1.isSelected());
				out.writeObject(fail2.isSelected());
				out.writeObject(fail3.isSelected());
				out.writeObject(languageProficiencies.getText());
				out.writeObject(weaponProficiencies.getText());
				out.writeObject(armorProficiencies.getText());
				out.writeObject(toolProficiencies.getText());
				out.writeObject(strSave.isSelected());
				out.writeObject(dexSave.isSelected());
				out.writeObject(conSave.isSelected());
				out.writeObject(intSave.isSelected());
				out.writeObject(wisSave.isSelected());
				out.writeObject(chaSave.isSelected());
				out.writeObject(notes.getText());
				copy = FXCollections.observableArrayList(Resources.pane.getChildren());
				copy.remove(0);
				while(copy.size() > 0){
					out.writeObject("NotDone");
					FlowPane next = (FlowPane)copy.get(0);
					out.writeObject(((TextField)((HBox)next.getChildren().get(0)).getChildren().get(1)).getText());
					out.writeObject(((TextField)((HBox)next.getChildren().get(1)).getChildren().get(1)).getText());
					out.writeObject(((Text)((HBox)next.getChildren().get(2)).getChildren().get(0)).getText());
					out.writeObject(((ComboBox<String>)next.getChildren().get(4)).getValue());
					copy.remove(0);
				}
				out.writeObject("endResources");
				message.setText("Character saved successfully");
			} catch (NullPointerException nullPointerException) {
				nullPointerException.printStackTrace();
			}
			catch (Exception ex){
				ex.printStackTrace();
				message.setText("Could not save file");
			}
		});
		load.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileChooser.showOpenDialog(stage)));
				Str.setText((String)in.readObject());
				Dex.setText((String)in.readObject());
				Con.setText((String)in.readObject());
				Int.setText((String)in.readObject());
				Wis.setText((String)in.readObject());
				Cha.setText((String)in.readObject());

				//<editor-fold desc="Read Skills">
				String value = in.readObject().toString();
				if (value.equals("3")){acrobatics.twice.setSelected(true);}
				else if (value.equals("2")){acrobatics.full.setSelected(true);}
				else if (value.equals("1")){acrobatics.half.setSelected(true);}
				else {acrobatics.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){animal_handling.twice.setSelected(true);}
				else if (value.equals("2")){animal_handling.full.setSelected(true);}
				else if (value.equals("1")){animal_handling.half.setSelected(true);}
				else {animal_handling.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){arcana.twice.setSelected(true);}
				else if (value.equals("2")){arcana.full.setSelected(true);}
				else if (value.equals("1")){arcana.half.setSelected(true);}
				else {arcana.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){athletics.twice.setSelected(true);}
				else if (value.equals("2")){athletics.full.setSelected(true);}
				else if (value.equals("1")){athletics.half.setSelected(true);}
				else {athletics.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){deception.twice.setSelected(true);}
				else if (value.equals("2")){deception.full.setSelected(true);}
				else if (value.equals("1")){deception.half.setSelected(true);}
				else {deception.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){history.twice.setSelected(true);}
				else if (value.equals("2")){history.full.setSelected(true);}
				else if (value.equals("1")){history.half.setSelected(true);}
				else {history.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){insight.twice.setSelected(true);}
				else if (value.equals("2")){insight.full.setSelected(true);}
				else if (value.equals("1")){insight.half.setSelected(true);}
				else {insight.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){intimidation.twice.setSelected(true);}
				else if (value.equals("2")){intimidation.full.setSelected(true);}
				else if (value.equals("1")){intimidation.half.setSelected(true);}
				else {intimidation.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){investigation.twice.setSelected(true);}
				else if (value.equals("2")){investigation.full.setSelected(true);}
				else if (value.equals("1")){investigation.half.setSelected(true);}
				else {investigation.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){medicine.twice.setSelected(true);}
				else if (value.equals("2")){medicine.full.setSelected(true);}
				else if (value.equals("1")){medicine.half.setSelected(true);}
				else {medicine.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){nature.twice.setSelected(true);}
				else if (value.equals("2")){nature.full.setSelected(true);}
				else if (value.equals("1")){nature.half.setSelected(true);}
				else {nature.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){perception.twice.setSelected(true);}
				else if (value.equals("2")){perception.full.setSelected(true);}
				else if (value.equals("1")){perception.half.setSelected(true);}
				else {perception.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){performance.twice.setSelected(true);}
				else if (value.equals("2")){performance.full.setSelected(true);}
				else if (value.equals("1")){performance.half.setSelected(true);}
				else {performance.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){persuasion.twice.setSelected(true);}
				else if (value.equals("2")){persuasion.full.setSelected(true);}
				else if (value.equals("1")){persuasion.half.setSelected(true);}
				else {persuasion.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){religion.twice.setSelected(true);}
				else if (value.equals("2")){religion.full.setSelected(true);}
				else if (value.equals("1")){religion.half.setSelected(true);}
				else {religion.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){sleight_of_hand.twice.setSelected(true);}
				else if (value.equals("2")){sleight_of_hand.full.setSelected(true);}
				else if (value.equals("1")){sleight_of_hand.half.setSelected(true);}
				else {sleight_of_hand.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){stealth.twice.setSelected(true);}
				else if (value.equals("2")){stealth.full.setSelected(true);}
				else if (value.equals("1")){stealth.half.setSelected(true);}
				else {stealth.none.setSelected(true);}

				value = in.readObject().toString();
				if (value.equals("3")){survival.twice.setSelected(true);}
				else if (value.equals("2")){survival.full.setSelected(true);}
				else if (value.equals("1")){survival.half.setSelected(true);}
				else {survival.none.setSelected(true);}
				//</editor-fold>
				name.setText(in.readObject().toString());
				race.setText(in.readObject().toString());
				playerClass.setText(in.readObject().toString());
				level.setText(in.readObject().toString());
				Node temp = Features.pane.getChildren().get(0);
				Features.pane.getChildren().clear();
				Features.pane.getChildren().add(temp);
				while(true){
					String check = in.readObject().toString();
					if (check.equals("endFeatures")){break;}
					newFeature.fire();
					FlowPane tempFlowPane = (FlowPane) Features.pane.getChildren().get(Features.pane.getChildren().size() - 1);
					((TextField)((HBox)tempFlowPane.getChildren().get(0)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(1)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(2)).getChildren().get(1)).setText(in.readObject().toString());
					((TextArea)tempFlowPane.getChildren().get(4)).setText(in.readObject().toString());
				}
				Object nullChecker = in.readObject();
				if(nullChecker != null){casterClass.setText(nullChecker.toString());} else {casterClass.setText("");}
				nullChecker = in.readObject();
				if(nullChecker != null){casterMod.setValue(nullChecker.toString());} else{casterMod.getSelectionModel().clearSelection();}
				while(true){
					String check = in.readObject().toString();
					if (check.equals("endSpells")){break;}
					newSpell.fire();
					FlowPane tempFlowPane = (FlowPane) Spells.pane.getChildren().get(Spells.pane.getChildren().size() - 1);
					((TextField)((HBox)tempFlowPane.getChildren().get(0)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(1)).getChildren().get(1)).setText(in.readObject().toString());
					nullChecker = in.readObject();
					if (nullChecker != null){((ComboBox<String>)((HBox)tempFlowPane.getChildren().get(1)).getChildren().get(2)).setValue(nullChecker.toString());} else {((ComboBox<String>)((HBox)tempFlowPane.getChildren().get(1)).getChildren().get(2)).setValue("");}
					((RadioButton)((HBox)tempFlowPane.getChildren().get(1)).getChildren().get(3)).setSelected((Boolean)in.readObject());
					((TextField)((HBox)tempFlowPane.getChildren().get(2)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(3)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(4)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(5)).getChildren().get(1)).setText(in.readObject().toString());
					((TextArea)tempFlowPane.getChildren().get(7)).setText(in.readObject().toString());
				}
				nullChecker = in.readObject();
				if(nullChecker != null){Initiative.setText(nullChecker.toString());}else{Initiative.setText("0");}
				nullChecker = in.readObject();
				if(nullChecker != null){armorClass.setText(nullChecker.toString());}else{Initiative.setText("10");}
				while(true){
					String check = in.readObject().toString();
					if (check.equals("endWeapons")){break;}
					weapon.fire();
					FlowPane tempFlowPane = (FlowPane) Weapons.getChildren().get(Weapons.getChildren().size() - 1);
					((TextField)((HBox)tempFlowPane.getChildren().get(0)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(1)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(2)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(3)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(4)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(5)).getChildren().get(1)).setText(in.readObject().toString());

				}
				while(true){
					String check = in.readObject().toString();
					if (check.equals("endArmor")){break;}
					armor.fire();
					FlowPane tempFlowPane = (FlowPane) Armor.getChildren().get(Armor.getChildren().size() - 1);
					((TextField)((HBox)tempFlowPane.getChildren().get(0)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(1)).getChildren().get(1)).setText(in.readObject().toString());
					((ComboBox<String>)((HBox)tempFlowPane.getChildren().get(2)).getChildren().get(1)).setValue(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(3)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(4)).getChildren().get(1)).setText(in.readObject().toString());
				}
				Copper.setText(in.readObject().toString());
				Silver.setText(in.readObject().toString());
				Electrum.setText(in.readObject().toString());
				Gold.setText(in.readObject().toString());
				Platinum.setText(in.readObject().toString());
				while(true){
					String check = in.readObject().toString();
					if (check.equals("endInventory")){break;}
					newItem.fire();
					FlowPane tempFlowPane = (FlowPane) Inventory.pane.getChildren().get(Inventory.pane.getChildren().size() - 1);
					((TextField)((HBox)tempFlowPane.getChildren().get(0)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(1)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)tempFlowPane.getChildren().get(2)).getChildren().get(1)).setText(in.readObject().toString());
					((TextArea)tempFlowPane.getChildren().get(4)).setText(in.readObject().toString());
				}
				gender.setText(in.readObject().toString());
				background.setText(in.readObject().toString());
				nullChecker = in.readObject();
				if (nullChecker != null) {alignment.setValue(nullChecker.toString());} else {alignment.setValue("");}
				speed.setText(in.readObject().toString());
				hp.setText(in.readObject().toString());
				currentHP.setText(in.readObject().toString());
				tempHP.setText(in.readObject().toString());
				pass1.setSelected((Boolean)in.readObject());
				pass2.setSelected((Boolean)in.readObject());
				pass3.setSelected((Boolean)in.readObject());
				fail1.setSelected((Boolean)in.readObject());
				fail2.setSelected((Boolean)in.readObject());
				fail3.setSelected((Boolean)in.readObject());
				languageProficiencies.setText(in.readObject().toString());
				weaponProficiencies.setText(in.readObject().toString());
				armorProficiencies.setText(in.readObject().toString());
				toolProficiencies.setText(in.readObject().toString());
				strSave.setSelected((Boolean)in.readObject());
				dexSave.setSelected((Boolean)in.readObject());
				conSave.setSelected((Boolean)in.readObject());
				intSave.setSelected((Boolean)in.readObject());
				wisSave.setSelected((Boolean)in.readObject());
				chaSave.setSelected((Boolean)in.readObject());
				notes.setText(in.readObject().toString());
				while(true){
					String check = in.readObject().toString();
					if (check.equals("endResources")){break;}
					addResource.fire();
					FlowPane next = (FlowPane) Resources.pane.getChildren().get(Resources.pane.getChildren().size() - 1);
					((TextField)((HBox)next.getChildren().get(0)).getChildren().get(1)).setText(in.readObject().toString());
					((TextField)((HBox)next.getChildren().get(1)).getChildren().get(1)).setText(in.readObject().toString());
					int toRemove = Integer.parseInt(((TextField)((HBox)next.getChildren().get(1)).getChildren().get(1)).getText().strip()) - Integer.parseInt(in.readObject().toString().strip());
					for (int i = 0; i < toRemove; i++){((Button)((HBox)next.getChildren().get(2)).getChildren().get(1)).fire();}
					((ComboBox<String>)next.getChildren().get(4)).setValue(in.readObject().toString());
				}

				Main.fire();
				Main.requestFocus();
			} catch (NullPointerException nullPointerException) {
				nullPointerException.printStackTrace();
			} catch (Exception ex){
				ex.printStackTrace();
				message.setText("Could not load file");
			}



		});
		//</editor-fold>

//Final setup
		stage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}


	class Page extends Button{
		private final ScrollPane scrollPane;
		VBox pane;
		Page(String label){
			this(label, new VBox());
		}
		Page(String label, VBox vbox){
			super(label);
			this.pane = vbox;
			this.pane.prefWidthProperty().bind(stage.widthProperty());
			this.pane.prefHeightProperty().bind(stage.heightProperty());
			scrollPane = new ScrollPane();
			scrollPane.setContent(vbox);
			scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
			scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
			scrollPane.addEventFilter(ScrollEvent.SCROLL,new EventHandler<ScrollEvent>() {
				@Override
				public void handle(ScrollEvent event) {
					if (event.getDeltaX() != 0) {
						event.consume();
					}
				}
			});
			vbox.setOnScroll(new EventHandler<ScrollEvent>() {
				@Override
				public void handle(ScrollEvent event) {
					double deltaY = event.getDeltaY()*4; // *6 to make the scrolling a bit faster
					double width = scrollPane.getContent().getBoundsInLocal().getWidth();
					double vvalue = scrollPane.getVvalue();
					scrollPane.setVvalue(vvalue + -deltaY/width); // deltaY/width to make the scrolling equally fast regardless of the actual width of the component
				}
			});
			this.setOnAction(e -> bPane.setCenter(this.scrollPane));
		}
	}

	class Skill {
		ToggleGroup proficiency;
		RadioButton none;
		RadioButton half;
		RadioButton full;
		RadioButton twice;
		SimpleIntegerProperty bonus;
		Skill(){
			this(0);
		}
		Skill(int start){
			this.bonus = new SimpleIntegerProperty(start);
			proficiency = new ToggleGroup();
			none = new RadioButton("0");
			none.setSelected(true);
			none.setToggleGroup(proficiency);
			half = new RadioButton("1/2");
			half.setToggleGroup(proficiency);
			full = new RadioButton("1");
			full.setToggleGroup(proficiency);
			twice = new RadioButton("2");
			twice.setToggleGroup(proficiency);
		}
	}


}
