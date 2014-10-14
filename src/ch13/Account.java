package ch13;


public class Account {
	
	private int accountNumber; // número da conta
	private int pin; // PIN para autenticação
	private double availableBalance; // fundos disponíveis para saque
	private double totalBalance; // fundos disponíveis + depósitos pendentes
	
	// O construtor Account inicializa os atributos
	public Account(int accountNumber, int pin, double availableBalance, double totalBalance) {
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.availableBalance = availableBalance;
		this.totalBalance = totalBalance;
	} // fim do construtor Account
	
	// retorna o número da conta
	public int getAccountNumber() {
		return accountNumber;
	} // fim método getAccountNumber
	
	// retorna o saldo disponível
	public double getAvailableBalance() {
		return availableBalance;
	} // fim do método getAvailableBalance
	
	// retorna o saldo total
	public double getTotalBalance() {
		return totalBalance;
	} // fim do método getTotalBalance
	
	// credita uma quantia à conta
	public void credit(double amount) {
		totalBalance += amount; // adiciona ao saldo total
	} // fim do método credit
	
	// debita uma quantia da conta
	public void debit(double amount) {
		availableBalance -= amount; // subtrai do saldo disponível
		totalBalance -= amount; // subtrai do saldo total
	} // fim do método debit 

	// determina se um PIN especificado pelo usuário corresponde ao PIN em Account
	public boolean validatePIN(int pin) {
		if (pin == this.pin)
			return true;
		else
			return false;
	} // fim do método validatePIN
	
} // fim da classe Account