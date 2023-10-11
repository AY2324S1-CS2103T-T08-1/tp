package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a type of person in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidType(String)}
 */

public class Type {

    public static final String MESSAGE_CONSTRAINTS =
            "Type should only doctor or patient, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "^(doctor|patient)$";

    public final String type;

    /**
     * Constructs a {@code Type}.
     *
     * @param type A valid type.
     */
    public Type(String type) {
        requireNonNull(type);
        checkArgument(isValidType(type), MESSAGE_CONSTRAINTS);
        this.type = type;
    }

    /**
     * Returns true if a given string is a valid type.
     */
    public static boolean isValidType(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public boolean isDoctor(){
        return type.equals("doctor");
    }
    public boolean isPatient(){
        return type.equals("patient");
    }

    @Override
    public String toString() {
        return type;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Type)) {
            return false;
        }

        Type otherName = (Type) other;
        return type.equals(otherName.type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

}
