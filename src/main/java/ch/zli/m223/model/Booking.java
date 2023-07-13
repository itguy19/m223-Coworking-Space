package ch.zli.m223.model;

import javax.inject.Inject;
import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @Inject
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Inject
    @Column(nullable = false)
    private LocalDateTime startDateTime;

    @Inject
    @Column(nullable = false)
    private LocalDateTime endDateTime;

    @Inject
    @Column(nullable = false)
    private boolean isCancelled;

    @Inject
    @Column(nullable = false)
    private boolean reservedForWholeDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public boolean isReservedForWholeDay() {
        return reservedForWholeDay;
    }

    public void setReservedForWholeDay(boolean reservedForWholeDay) {
        this.reservedForWholeDay = reservedForWholeDay;
    }
}