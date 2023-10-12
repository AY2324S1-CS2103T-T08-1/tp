package seedu.address.model.person.doctor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NRIC_BOB;
import static seedu.address.testutil.TypicalDoctor.ALICE;
import static seedu.address.testutil.TypicalDoctor.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.DoctorBuilder;
public class DoctorTest {
    @Test
    public void isSameDoctor() {
        // same object -> returns true
        assertTrue(ALICE.isSame(ALICE));

        // null -> returns false
        assertFalse(ALICE.isSame(null));

        // same NRIC, all other attributes different -> returns true
        Doctor editedAlice = new DoctorBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertTrue(ALICE.isSame(editedAlice));

        // different NRIC, all other attributes same -> returns false
        editedAlice = new DoctorBuilder(ALICE).withNric(VALID_NRIC_BOB).build();
        assertFalse(ALICE.isSame(editedAlice));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Doctor aliceCopy = new DoctorBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different person -> returns false
        assertFalse(ALICE.equals(BOB));

        // different name -> returns false
        Doctor editedAlice = new DoctorBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different name -> returns false
        editedAlice = new DoctorBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different NRIC -> returns false
        editedAlice = new DoctorBuilder(ALICE).withNric(VALID_NRIC_BOB).build();
        assertFalse(ALICE.equals(editedAlice));
    }

    @Test
    public void toStringMethod() {
        String expected = Doctor.class.getCanonicalName() + "{name=" + ALICE.getName() + ", nric="
                + ALICE.getNric() + "}";
        assertEquals(expected, ALICE.toString());
    }
}