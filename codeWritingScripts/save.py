def function(skill, other):
	s =  "if("+skill.lower()+".none.isSelected()){out.writeObject(\"0\");}\n"
	s += "else if ("+skill.lower()+".half.isSelected()){out.writeObject(\"1\");}\n"
	s += "else if ("+skill.lower()+".full.isSelected()){out.writeObject(\"2\");}\n"
	s += "else {out.writeObject(\"3\");}\n"
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
