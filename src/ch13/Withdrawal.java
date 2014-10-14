package ch13;


public class Withdrawal extends Transaction {
	
	private int amount; // quantia a sacar
	private Keypad keypad; // referência ao teclado numérico
	private CashDispenser cashDispenser; // referência ao dispensador de cédulas
	
	// constante que corresponde à opção de cancelar no menu
	private final static int CANCELED = 6;
	
	// Construtor de Withdrawal
	public Withdrawal(int accountNumber, Screen screen, BankDatabase bankDatabase, Keypad keypad, CashDispenser cashDispenser) {
		// inicializa as variáveis da superclasse
		super(accountNumber, screen, bankDatabase);
		// inicializa as referências ao teclado númerico e ao dispensador de cédulas
		this.keypad = keypad;
		this.cashDispenser = cashDispenser;
	} // fim do construtor DE Withdrawal
	
	// realiza a transação
	@Override
	public void execute() {
		
		boolean cashDispensed = false; // cédulas ainda não foram entregues
		double availableBalance; // quantia disponível para saque
		
		// obtém as referências ao banco de dados e tela do banco
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();
		
		// faz um loop até as cédulas serem entregues ou o usuário cancelar
		do {
			
			// obtém a quantia de um saque escolhida pelo usuário
			amount = displayMenuOfAmounts();
			
			// verifica se o usuário escolheu uma quantia de saque ou cancelou
			if (amount != CANCELED) {
				
				// obtém o saldo disponível na conta envolvida
				availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());
				
				// verifica se o usuário tem dinheiro suficiente na conta
				if (amount <= availableBalance) {
					
					// verifica se o dispensador de cédulas tem cédulas suficientes
					if (cashDispenser.isSufficientCashAvailable(amount)) {
						
						// atualiza a conta envolvida para refletir a retirada/saque
						bankDatabase.debit(getAccountNumber(), amount);
						cashDispenser.dispenseCash(amount); // entrega cédulas
						cashDispensed = true; // cédulas foram entregues
						
						// instrui o usuário a pegar as cédulas
						screen.displayMessageLine("\nYour cash has been dispensed. Please take your cash now.");
					
					} else // o dispensador de cédulas não tem cédulas suficientes
						screen.displayMessageLine("\nInsufficient cash available in the ATM.\n\nPlease choose a smaller amount.");
					
				} else // não há dinheiro suficiente disponível na conta do usuário
					screen.displayMessageLine("\nInsufficient funds in your account. \n\nPlease choose a smaller amount.");
			
			} else { // o usuário escolheu a opção cancelar do menu
				
				screen.displayMessageLine("\nCanceling transaction...");
				return; // retorna ao menu principal porque o usuário cancelou
				
			} // fim de else
		
		} while (!cashDispensed);
	
	} // fim do método execute
	
	// exibe um menu de quantias de saques e a opção para cancelar;
	// retorna a quantia escolhida ou 0 se o usuário escolheu cancelar
	private int displayMenuOfAmounts() {
		
		int userChoice = 0; // variável local para armazenar o valor de retorno
		Screen screen = getScreen(); // obtém a referência de tela
		
		// array de quantias que correspondem aos números no menu
		int[] amounts = { 0, 20, 40, 60, 100, 200 };
		
		// faz um loop enquanto nenhuma escolha válida for feita
		while (userChoice == 0) {
			// exibe o menu
			screen.displayMessageLine("\nWithdrawal Menu:");
			screen.displayMessageLine("1 - $20");
			screen.displayMessageLine("2 - $40");
			screen.displayMessageLine("3 - $60");
			screen.displayMessageLine("4 - $100");
			screen.displayMessageLine("5 - $200");
			screen.displayMessageLine("6 - Cancel transaction");
			screen.displayMessage("\nChoose a withdrawal amount: ");
			
			int input = keypad.getInput(); // obtém a entrada do usuário pelo teclado
			
			// determina como prosseguir com base no valor de entrada
			switch (input) {
			
				case 1: // se o usuário escolheu uma quantia de saque
				case 2: // (isto é, escolheu a opção 1, 2, 3, 4 ou 5), retorna a
				case 3: // quantia correspondente do array de quantias
				case 4:
				case 5:
					userChoice = amounts[input]; // salva a escolha do usuário
					break;
				case CANCELED: // o usuário escolheu cancelar
					userChoice = CANCELED; // salva a escolha do usuário
					break;
				default: // o usuário não inseriu um valor entre 1 e 6
					screen.displayMessageLine("\nInvalid selection. Try again.");
				
			} // fim do switch
			
		} // fim do while
		
		return userChoice; // retorna a quantia de saque ou CANCELED
			
	} // fim do método displayMenuOfAmounts
	
} // fim da classe Withdrawal