def function(skill, other):
	s = "\t\t\t\tvalue = in.readObject().toString();\n"
	s +="\t\t\t\tif (value.equals(\"3\")){"+skill.lower()+".twice.setSelected(true);}\n"
	s +="\t\t\t\telse if (value.equals(\"2\")){"+skill.lower()+".full.setSelected(true);}\n"
	s +="\t\t\t\telse if (value.equals(\"1\")){"+skill.lower()+".half.setSelected(true);}\n"
	s +="\t\t\t\telse {"+skill.lower()+".none.setSelected(true);}\n"
	return s


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
