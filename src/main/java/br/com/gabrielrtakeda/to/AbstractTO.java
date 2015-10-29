package br.com.gabrielrtakeda.to;

public abstract class AbstractTO {

    private boolean statusOperation;
    private String successMessage;
    private String errorMessage;

    public boolean getStatusOperation() { return this.statusOperation; }
    public AbstractTO setStatusOperation(boolean statusOperation) {
        this.statusOperation = statusOperation;
        return this;
    }

    public String getSuccessMessage() { return this.successMessage; }
    public AbstractTO setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
        return this;
    }

    public String getErrorMessage() { return this.errorMessage; }
    public AbstractTO setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
