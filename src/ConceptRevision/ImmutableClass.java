package ConceptRevision;

/**
 * In order to create Immutable class
 * Instance Variables should be Private and final
 * Class should be Final so that we cannot create the subclass
 * No setter methods should be available
 * Getter methods should be there
 *
 */
public final class  ImmutableClass {
     private final String panCardNumber;

    public ImmutableClass(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    public String getPanCardNumber() {
        return panCardNumber;
    }
}

class ImmutableDemo{
    public static void main(String[] args) {
        ImmutableClass im = new ImmutableClass("CNMPM8315D");

        String PAN_CARD = im.getPanCardNumber();

        System.out.println("Pan Card number is "+PAN_CARD);
    }
}
