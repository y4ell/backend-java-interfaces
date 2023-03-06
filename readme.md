# Opdrachtbeschrijving

## Inleiding
In deze opdracht gaan we leren hoe we interfaces kunnen gebruiken
We gaan hier door op de vorige opdracht waar we een Customer hebben geschreven.
Je mag verder werken in je eigen uitwerking, of deze opdracht clonen.

## Voor je begint

Je hebt IntelliJ IDEA en de JDK (Java Development Kit) versie 17 of hoger nodig - deze heb je beiden via de instructies op EdHub geïnstalleerd.

### 🟩 Code runnen (vanuit IntelliJ)
Klik op de groene play-knop voor de main-methode en kies 'Run...'.
### 🟨 Testen uitvoeren (vanuit IntelliJ)
Klik op de groene play-knop voor de MainTest-class in src/test/java en kies 'Run 'MainTest''.
### ⬛ Code runnen (met Maven)
Of, als je bekend bent met de terminal, kun je de applicatie runnen met:
```shell
./mvnw clean compile exec:java
```
of
```shell
mvnw.cmd clean compile exec:java
```


## Opdracht

### Opdracht 1
Het nadeel van overerving is dat een klasse maar 1 andere klasse kan extenden. Daarbij is het ook zo dat een VisaCard nu ook een CreditCard is, oftewel, alle wijzigingen aan CreditCard hebben ook direct invloed op het gedrag van VisaCard. Soms is dit precies wat je wil, maar soms kan dit ook leiden tot fouten, als het veranderde gedrag in de CreditCard-class bijvoorbeeld niet meer werkt met wat VisaCard probeert te doen. In plaats van overerving, kunnen we er dus ook voor kiezen een interface te implementeren. Een interface kan je zien als een contract, het beschrijft welke methoden er in die klasse moeten zitten, maar het biedt geen _implementatie_.

Een situatie waarin je dit zou willen gebruiken, is bijvoorbeeld klantcontact. Contact opnemen met de klant zou namelijk via meerdere kanalen kunnen. Maak daarom een nieuwe interface aan genaamd `ContactInfo`:

```java
public interface ContactInfo {
    void sendMessage();
}
```

We hoeven hier geen `public` bij te zetten, want methodes in een interface zijn altijd `public`. We kunnen contact opnemen via e-mail, dus laten we hier een class genaamd `EmailContact` voor maken. Zorg dat deze class `ContactInfo` implementeert. We moeten nu ook de methode `sendMessage` hier overschrijven.

Een `EmailContact` heeft natuurlijk ook een private property `email` van het type String nodig. Voeg deze toe en zorg ervoor dat deze in de constructor wordt gezet en dat er getters en setters voor zijn.

We kunnen nu de `sendMessage`-methode zo aanpassen, dat deze een tekst print:
```
    @Override
    public void sendMessage() {
        System.out.println("Email send to " + email);
    }
```

Onze Customer-class kan nu worden uitgebreid met een private property `contactInfo` van het type `ContactInfo`.
Zorg ervoor dat deze in beide constructors zit en er getters en setters voor zijn!

De Main klasse moet nu natuurlijk ook weer worden aangepast omdat de constructor is aangepast.
```
Customer customer = new Customer("Frodo", "Balings", new MasterCard(0), new EmailContact("frodo@novi.nl"));
```
en we kunnen nu een bericht versturen door `customer.getContactInfo().sendMessage();` te doen.


### Opdracht 2

* Naast het versturen van e-mails, is ook sms-contact mogelijl. Maak nu een tweede implementatie van `ContactInfo` genaamd `SmsContact`, deze heeft in plaats van een e-mail-adres een telefoonnummer.
* Zorg ervoor dat `customer2` een implementatie van `SmsContact` krijgt.
* Zie nu ook dat `customer2.getContactInfo().sendMessage();` nog steeds gewoon werkt!

## Bonusopdracht

Maak ook een `SmsContactInfo`-class, die een SMS verstuurd naar een telefoonnummer.
