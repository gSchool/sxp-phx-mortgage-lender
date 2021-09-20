final class Lender {
    private long availableFunds;


    public long getAvailableFunds() {
        return this.availableFunds;
    }

    public void addFunds(long funds) throws IllegalArgumentException{
        if(funds <= 0L) {
            throw new IllegalArgumentException("Amount added must be greater than 0");
        }
        this.availableFunds = Math.addExact(this.availableFunds,funds);
    }
}
