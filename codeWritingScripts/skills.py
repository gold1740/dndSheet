
def function(skill, attribute):
	return f"""
		Skill {skill.lower()} = new Skill();
		{skill.lower()}.bonus.bind(
				Bindings.when({skill.lower()}.none.selectedProperty()).then({attribute}Mod).otherwise(
				Bindings.when({skill.lower()}.half.selectedProperty()).then(ProfBonus.multiply(0.5).add({attribute}Mod)).otherwise(
				Bindings.when({skill.lower()}.full.selectedProperty()).then(ProfBonus.add({attribute}Mod)).otherwise(ProfBonus.multiply(2).add({attribute}Mod))
						)));

		Text {skill} = new Text();
		{skill}.textProperty().bind(new SimpleStringProperty("\\tBonus:\\t").concat({skill.lower()}.bonus.asString()));
		Skills.pane.getChildren().add(new FlowPane (new Text("{skill + ':'}"),{skill.lower()}.none,{skill.lower()}.half,{skill.lower()}.full,{skill.lower()}.twice,{skill}));
"""


print(function("Acrobatics", "Dexterity"))
print(function("Animal_Handling", "Wisdom"))
print(function("Arcana", "Intelligence"))
print(function("Athletics", "Strength"))
print(function("Deception", "Charisma"))
print(function("History", "Intelligence"))
print(function("Insight", "Wisdom"))
print(function("Intimidation", "Charisma"))
print(function("Investigation", "Intelligence"))
print(function("Medicine", "Wisdom"))
print(function("Nature", "Intelligence"))
print(function("Perception", "Wisdom"))
print(function("Performance", "Charisma"))
print(function("Persuasion", "Charisma"))
print(function("Religion", "Intelligence"))
print(function("Sleight_of_Hand", "Dexterity"))
print(function("Stealth", "Dexterity"))
print(function("Survival", "Wisdom"))
