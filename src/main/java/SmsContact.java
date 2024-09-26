public class SmsContact implements ContactInfo {
    private String telephoneNumber;

    public SmsContact(String telephoneNumber){
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneNumber() {
       return this.telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber){
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public void sendMessage() {

    }
}
