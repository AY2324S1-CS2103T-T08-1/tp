package seedu.address.model.appointment;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDateTime;
import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.Listable;
import seedu.address.model.person.Nric;

/**
 * Represents a Appointment in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Appointment implements Listable {
    private final Nric doctorNric;
    private final Nric patientNric;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    /**
     * Every field must be present and not null.
     */
    public Appointment(Nric doctorNric, Nric patientNric, LocalDateTime startTime, LocalDateTime endTime) {
        requireAllNonNull(doctorNric, patientNric, startTime, endTime);
        this.doctorNric = doctorNric;
        this.patientNric = patientNric;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Nric getDoctorNric() {
        return doctorNric;
    }

    public Nric getPatientNric() {
        return patientNric;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
    @Override
    public boolean isSame(Listable otherListable) {
        if (!(otherListable instanceof Appointment)) {
            return false;
        }

        Appointment otherAppointment = (Appointment) otherListable;

        if (otherAppointment == this) {
            return true;
        }

        return otherAppointment.getDoctorNric().equals(getDoctorNric())
                && otherAppointment.getPatientNric().equals(getPatientNric())
                && otherAppointment.getStartTime().equals(getStartTime())
                && otherAppointment.getEndTime().equals(getEndTime());
    }

    /**
     * Returns true if both appointments have the same identity fields.
     * This defines a stronger notion of equality between two patients.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Appointment)) {
            return false;
        }

        Appointment otherAppointment = (Appointment) other;
        return doctorNric.equals(otherAppointment.doctorNric)
                && patientNric.equals(otherAppointment.patientNric)
                && startTime.equals(otherAppointment.startTime)
                && endTime.equals(otherAppointment.endTime);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(doctorNric, patientNric, startTime, endTime);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("doctorNric", doctorNric)
                .add("patientNric", patientNric)
                .add("startTime", startTime)
                .add("endTime", endTime)
                .toString();
    }
}
