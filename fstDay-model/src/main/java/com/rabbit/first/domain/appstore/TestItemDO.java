package com.rabbit.first.domain.appstore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "item", schema = "mydb", catalog = "")
public class TestItemDO {
    @Version
    protected long version;
    private int id;
    private String name;
    private Timestamp lastModifyDate;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "last_modify_date", nullable = true)
    public Timestamp getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Timestamp lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestItemDO that = (TestItemDO) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastModifyDate != null ? !lastModifyDate.equals(that.lastModifyDate) : that.lastModifyDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastModifyDate != null ? lastModifyDate.hashCode() : 0);
        return result;
    }
}
