package go.tripservice.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: bobmouse
 * Date: 01.02.12
 * Time: 18:08
 * This is the test entity
 */
@Entity
@Table(name = "TS_TESTS")
public class TestEntity {
    private Long id;

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
