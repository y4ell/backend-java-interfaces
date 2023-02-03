# Opdrachtbeschrijving

## Inleiding
In deze opdracht gaan we leren hoe we interfaces kunnen gebruiken
We gaan hier door op de vorige opdracht waar we een Customer hebben geschreven.

## Voor je begint

### Java installeren

Intellij kan Java voor je installeren:
1. Om dit te doen kan je het volgende scherm openen: `File -> Project Structure -> Project Settings -> Project`.
2. Bij SDK kan je in de dropdown `download JDK` selecteren.
3. Kies hier voor versie 17 en laat deze downloaden en installeren.

### Uitvoeren met Maven

We maken hier ook gebruik maken van de build tool maven.
Dit kunnen we zien aan het bestand `pom.xml`.
Deze file bevat de configuratie voor ons project.
Voor een klein project als dit is deze configuratie nog erg klein.
We zien hier dat we voor nu even Java versie 8 gebruiken, dit doen we nog even om te voorkomen dat Intellij je teveel gaat helpen terwijl je nog concepten aan het leren bent.
Later in deze cursus gaan we java 17 gebruiken.
We kunnen ook kijken of het programma via Maven te draaien is.
Hiervoor kun je helemaal onderin het scherm op het tabblad `terminal` klikken.
Hier kun je het volgende commando uitvoeren:

```shell
./mvnw clean compile exec:java
```

of

```shell
mvnw.cmd clean compile exec:java
```

Als het goed is komt er nu een boel tekst hier te staan waaronder de tekst "BUILD SUCCESS" en hierboven de tekst "Hello world".
Als dit werkt weet je dat maven correct werkt.

### Uitvoeren vanuit Intellij

Dit is een project dat gebruik maakt van Maven en Intellij kan hier mee omgaan.
Er is een kans dat Intellij dit al voor je gedaan heeft, maar dit kunnen we controleren door helemaal aan de rechterkant het tabblad `Maven` te openen.
Als dit tabblad leeg is moet er op het `+` icoon gedrukt worden en de `pom.xml` van dit project geselecteerd worden.
Nu zie je als het goed is het project `Helloworld` in dit tabblad staan.

Als alles goed is gegaan zie je nu in de map `src/main/java` de classe `Main` staan.
Hier zie je een groen play knopje voor de methode `main` staan.
Als je hier op klikt krijg je de mogelijkheid om `run Main.main()` te doen.
Als je hiervoor kiest gaat het programma draaien en zal je onderin in het `run` scherm de tekst:
"Hello world" te zien moeten krijgen (met daaronder de tekst "Process finished with exit code 0").
Als je dit ziet betekend dat Java goed is geinstalleerd.

## Opdracht

### Opdracht 1
Het nadeel van overerving is dat een klasse maar 1 andere klasse kan extenden.
Daarbij is het ook zo dat een VisaCard nu ook een CreditCard is, oftewel, alle wijzigingen aan CreditCard hebben ook direct invloed op het gedrag van VisaCard.
Soms is dit precies wat je wil, soms kan dit ook leiden tot fouten als het veranderde gedrag in CreditCard bijvoorbeeld niet meer werkt met wat VisaCard probeert te doen.
Een andere optie op overerving is het implementeren van een interface.
Een interface kan je zien als een contract, het beschrijft welke methoden er in die klasse moeten zitten, maar bied geen implementatie.

Een goede usecase hiervoor is het contact opnemen met de customer, dit zou namelijk via meerdere kanalen kunnen.
Maak daarom een nieuwe interface aan genaamd `ContactInfo`
```java
public interface ContactInfo {
    void sendMessage();
}
```
We hoeven hier geen `public` bij te zetten, want methodes in een interface zijn altijd public.

Een manier om contact op te nemen is via email, dus laten we hier een klasse voor maken genaamd `EmailContact` en zorg ervoor dat de `ContactInfo` implement.
We moeten nu ook de methode `sendMessage` hier overschrijven.

Een `EmailContact` heeft natuurlijk ook een private property `email` van het type String nodig, voeg deze toe en zorg ervoor dat deze in de constructor wordt gezet en dat er getters en setters voor zijn.

We kunnen nu `sendMessage` aanpassen dat het een tekst print
```
    @Override
    public void sendMessage() {
        System.out.println("Email send to " + email);
    }
```

Onze `Customer` klasse kan nu worden uitgebreid met een private property `contactInfo` van het type `ContactInfo`.
Zorg ervoor dat deze in beide constructors zit en er getters en setters voor zijn.

De Main klasse moet nu natuurlijk ook weer worden aangepast omdat de constructor is aangepast.
```
Customer customer = new Customer("Frodo", "Balings", new MasterCard(0), new EmailContact("frodo@novi.nl"));
```
en we kunnen nu een bericht versturen door
`customer.getContactInfo().sendMessage();`
te doen.


### Opdracht 2

Naast email contact is sms contact ook mogelijk./
Maak nu een tweede implementatie van `ContactInfo` genaamd `SmsContact`, deze heeft in plaats van een email adres een telefoonnummer.
Zorg ervoor dat `customer2` een implementatie van SmsContact krijgt.
Zie nu ook dat `customer2.getContactInfo().sendMessage();` nog steeds gewoon werkt.



### Stappenplan
_Let op:_ het is uitdagender om jouw eigen stappenplan te maken. Als je niet zo goed weet waar je moet beginnen, kun je onderstaand stappenplan gebruiken:
1.


## Bonusopdracht

Maak ook een MailContactInfo wat naar een huisadres iets verstuurd.

