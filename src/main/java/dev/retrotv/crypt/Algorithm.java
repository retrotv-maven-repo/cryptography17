package dev.retrotv.crypt;

public enum Algorithm {
      SHA3224("SHA3-224")
    , SHA3256("SHA3-256")
    , SHA3384("SHA3-384")
    , SHA3512("SHA3-512")
    ;

    private final String label;

    Algorithm(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
