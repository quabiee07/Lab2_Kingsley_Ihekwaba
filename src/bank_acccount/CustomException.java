package bank_acccount;


class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String m) {
        super(m);
    }
}

class NegativeAmountException extends Exception {
    public NegativeAmountException(String m) {
        super(m);
    }
}

class InvalidAccountNumber extends Exception {
    public InvalidAccountNumber(String m) {
        super(m);
    }
}


class EmptyFieldException extends Exception {
    public EmptyFieldException(String m) {
        super(m);
    }
}

class ZeroAmountException extends Exception {
    public ZeroAmountException(String m) {
        super(m);
    }
}

class InvalidChoiceException extends Exception {
    public InvalidChoiceException(String m) {
        super(m);
    }
}
