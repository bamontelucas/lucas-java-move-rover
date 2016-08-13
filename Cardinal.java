public enum Cardinal {
    N, E, S, W;
    public Cardinal next() {
        return this.ordinal() == (Cardinal.values().length - 1) 
            ? Cardinal.values()[0]
            : Cardinal.values()[this.ordinal()+1];
    }
    public Cardinal prior() {
        return this.ordinal() == 0 
            ? Cardinal.values()[Cardinal.values().length - 1]
            : Cardinal.values()[this.ordinal()-1];
    }
}