package ch13;


public class Deposit extends Transaction {

	private double amount; // quantia a depositar
	private Keypad keypad; // referência ao teclado numérico
	private DepositSlot depositSlot; // referência à abertura para deposito
	private final static int CANCELED = 0; // constante para a opção de cancelamento 
	
	// Construtor de Deposit
	public Deposit(int accountNumber, Screen screen, BankDatabase bankDatabase, Keypad keypad, DepositSlot depositSlot) {

		// inicializa as variáveis da superclasse
		super(accountNumber, screen, bankDatabase);
		
		// inicializa as referências a teclado e abertura de depósito
		this.keypad = keypad; 
		this.depositSlot = depositSlot;
	
	} // fim do construtor de Deposit
	
	// realiza a transação
	@Override
	public void execute() {
		
		BankDatabase bankDatabase = getBankDatabase(); // obtém a referência
		Screen screen = getScreen(); // obtém a referência
		
		amount = promptForDepositAmount(); // obtém a quantia de depósito do usuário
		
		// verifica se o usuário inseriu uma quantia de depósito ou cancelou
		if (amount != CANCELED) {

			// solicita o envelope de depósito contendo a quantia especificada
			screen.displayMessage("\nPlease insert a deposit envelope containing ");
			screen.displayDollarAmount(amount);
			screen.displayMessageLine(".");
			
			// recebe o envelope de depósito
			boolean envelopeReceived = depositSlot.isEnvelopeReceived();
			
			// verifica se envelope de depósito foi recebido
			if (envelopeReceived) {
				
				screen.displayMessageLine("\nYour envelope has been received.\nNOTE: The money just deposited will not be available until we verify the amount of any enclosed cash and your checks clear.");
				
				// credita na conta para refletir o depósito
				bankDatabase.credit(getAccountNumber(), amount);
			
			} else // envelope de depósito não foi recebido
				screen.displayMessageLine("\nYou did not insert an envelope, so the ATM has canceled your transaction");
				
		} else // o usuário cancelou em vez de inserir uma quantia
			screen.displayMessageLine("\nCanceling transaction...");
		
	} // fim do método execute
	
	// solicita que o usuário insira um quantia de depósito em centavos
	private double promptForDepositAmount() {
		
		Screen screen = getScreen(); // obtém a referência à tela
		
		// exibe a solicitação
		screen.displayMessage("\nPlease enter a deposit amount in CENTS (or 0 to cancel): ");
		int input = keypad.getInput(); // recebe a entrada da quantia do depósito
		
		// verifica se o usuário cancelou ou inseriu uma quantia válida
		if (input == CANCELED)
			return CANCELED;
		else
			return (double) input / 100; // retorna a quantia em dólares
		
	} // fim do método promptForDepositAmount

}
