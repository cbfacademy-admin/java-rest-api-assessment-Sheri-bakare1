# **Modified for API Assessment**

## ** Heating appliance REST API**

This project is a demostration of API development with Java and SpringBoot. This REST API End point will allow you to obtain a list of appliance recommendations based on certain criteria, such as the number of rooms and radiators.


### **Project Content:**

This project will allow you to:

1. **Obtain a sorted list of recommendations for heating equipment based on input parameters.**
2. **Generate recommendations and then save these recommendations to a JSON file using JSONFileHandler**
3. **Handle exceptions that appear in the code e,g some methods throw 'IOException'.**
4. **Test the ApplianceSelection class.**

Onward with this assessment, you're set for a deep dive into API development with Java and SpringBoot.

## **API Flow**

An instance of HeatingEquipment is created. This calls the getSortedRecommendations method of HeatingEquipment, 
this class has the required parameters such as number of rooms and radiators.
The resulting list of Recommendation objects is provided in the HTTP response.


### **Key Feautures:**
- **@GetMapping("/recommendations")**: This is the API endpoint and fetches the recommendations.**
- **HeatingEquipment** : The purpose of this class is to generate a list of recommended objects.This has methods such as getSortedRecommendations which will take the number of rooms and radiators as input, 
generate recommendations using an instance of ApplianceSelection. The generated recommendations
  include various types of heating equipment like heat pumps, boilers, and MCHP (micro-CHP). Also, the method adds these recommendations to a list, which is then sorted by price in ascending order.
- **JSONFileHandler** : This is used to write the list of recommendations to a specified JSON file. and contains a method that an IOException if there is an issue with the file writing process.