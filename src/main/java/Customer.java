public class Customer {

		public Customer(String name, String lastName, CreditCard creditCard) {
				this(name, (int)(Math.random() * 100), lastName, creditCard);
		}

		public Customer(String name, int customerNumber, String lastName, CreditCard creditCard) {
				this.name = name;
				this.customerNumber = customerNumber;
				this.lastName = lastName;
				this.creditCard = creditCard;
		}

		private String name;

		private int customerNumber;
		private String lastName;

		private CreditCard creditCard;

		public String getName(){
				return name;
		}

		public void setName(String name){
				this.name = name;
		}

		public int getCustomerNumber() {
				return customerNumber;
		}

		public void setCustomerNumber(int customerNumber) {
				this.customerNumber = customerNumber;
		}

		public String getLastName() {
				return lastName;
		}

		public void setLastName(String lastName) {
				this.lastName = lastName;
		}

		public CreditCard getCreditCard() {
				return creditCard;
		}

		public void setCreditCard(CreditCard creditCard) {
				this.creditCard = creditCard;
		}

		public void printName(){
				System.out.println("Customer " + name);
		}
}
