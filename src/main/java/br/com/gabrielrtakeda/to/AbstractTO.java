package br.com.gabrielrtakeda.to;

public abstract class AbstractTO {

    private boolean statusOperation;

    public AbstractTO setStatusOperation(boolean statusOperation) {
        this.statusOperation = statusOperation;
        return this;
    }
    public boolean getStatusOperation() {
        return this.statusOperation;
    }
}
