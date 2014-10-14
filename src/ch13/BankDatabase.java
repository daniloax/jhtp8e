package ch13;


public class BankDatabase {

	private Account[] accounts; // array de Accounts
	
	// construtor BankDatabase sem argumentos inicializa as contas
	public BankDatabase() {
		accounts = new Account[2]; // apenas duas contas para teste
		accounts[0] = new Account(12345, 54321, 1000.0, 1200.0);
		accounts[1] = new Account(98765, 56789, 200.0, 200.0);
	} // fim do construtor BankDatabase sem argumentos
	
	// recupera o objeto Account que contém o número de conta especificado
	private Account getAccount(int accountNumber) {
		// faz um loop pelas contas procurando uma correspondência com o número de conta
		for (Account currentAccount : accounts) {
			// retorna a conta atual se uma correspondência for localizada
			if (currentAccount.getAccountNumber() == accountNumber)
				return currentAccount;
		} // final for
		return null; // se nenhuma correspondência com uma conta foi localizada, retorna null
	} // fim do método getAccount
	
	// determina se número da conta e PIN especificados pelo usuário correspondem
	// àqueles de uma conta no banco de dados
	public boolean authenticateUser(int accountNumber, int pin) {
		// tenta recuperar a conta com o número da conta
		Account userAccount = getAccount(accountNumber);
		
		// se a conta existir, retorna o resultado do método validatePIN de Account
		if (userAccount != null)
			return userAccount.validatePIN(pin);
		else
			return false; // número da conta não foi localizado, portanto retorna false		
	} // fim do método authenticateUser
	
	// retorna o saldo disponível de Account com o número da conta especificado
	public double getAvailableBalance(int accountNumber) {
		return getAccount(accountNumber).getAvailableBalance();
	} // fim do método getAvailableBalance
	
	// retorna o saldo total de Account com o número com o número da conta especificado
	public double getTotalBalance(int accountNumber) {
		return getAccount(accountNumber).getTotalBalance();
	} // fim do método getTotalBalance
	
	// credita uma quantia a Account com o número da conta especificado
	public void credit(int accountNumber, double amount) {
		getAccount(accountNumber).credit(amount);
	} // fim do método credit 
	
	// debita uma quantidade da Account com o número da conta especificado
	public void debit(int accountNumber, double amount) {
		getAccount(accountNumber).debit(amount);
	} // fim do método debit
	
} // fim da classe BankDatabase
